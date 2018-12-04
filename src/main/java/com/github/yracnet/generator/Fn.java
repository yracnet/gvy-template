/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.yracnet.generator;

/**
 *
 * @author yracnet
 */
public class Fn {

    public String toName(String name) {
        System.out.println("--->"+name);
        name = name.replace("Crm", "");
        System.out.println("--->"+name);
        return name;
    }

    public String toNameVar(String name) {
        name = toName(name);
        return toVar(name);
    }

    public String toVar(String name) {
        return name.toLowerCase().charAt(0) + name.substring(1);
    }

    public String toNameConst(String name) {
        name = toName(name);
        return toConst(name);
    }

    public String toConst(String name) {
        name = name.replaceAll("([a-z0-9]+)([A-Z0-9]+)", "$1_$2");
        return name.toUpperCase();
    }

    public String toNameLiteral(String name) {
        name = toName(name);
        return toLiteral(name);
    }

    public String toLiteral(String name) {
        return name.replaceAll("([a-z0-9]+)([A-Z0-9]+)", "$1 $2");
    }

    public String toNameText(String name) {
        name = toName(name);
        return toText(name);
    }

    public String toText(String name) {
        return name.replaceAll("([a-z0-9]+)([A-Z0-9]+)", "$1 $2");
    }


    public static void main(String arg[]) {
        Fn fn = new Fn();
        String values[] = {"AaaBbbb", "aaaBbbb", "xxxx"};
        for (String value : values) {
            System.out.println("===========>" + value);
            System.out.println("---->" + fn.toName(value));
            System.out.println("---->" + fn.toNameVar(value));
            System.out.println("---->" + fn.toNameConst(value));
            System.out.println("---->" + fn.toNameLiteral(value));
        }
    }
}