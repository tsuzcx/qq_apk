package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class ap
  extends k
{
  private static byte[] y;
  private static Map<String, String> z;
  public int a = 0;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public int g = 0;
  public byte[] h = null;
  public String i = "";
  public String j = "";
  public Map<String, String> k = null;
  public String l = "";
  public long m = 0L;
  public String n = "";
  public String o = "";
  public String p = "";
  public long q = 0L;
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  public String v = "";
  public String w = "";
  private String x = "";
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    y = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    z = new HashMap();
    z.put("", "");
  }
  
  public final void a(i parami)
  {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.b(1, true);
    this.c = parami.b(2, true);
    this.d = parami.b(3, true);
    this.e = parami.b(4, false);
    this.f = parami.b(5, true);
    this.g = parami.a(this.g, 6, true);
    byte[] arrayOfByte = y;
    this.h = ((byte[])parami.c(7, true));
    this.i = parami.b(8, false);
    this.j = parami.b(9, false);
    this.k = ((Map)parami.a(z, 10, false));
    this.l = parami.b(11, false);
    this.m = parami.a(this.m, 12, false);
    this.n = parami.b(13, false);
    this.o = parami.b(14, false);
    this.p = parami.b(15, false);
    this.q = parami.a(this.q, 16, false);
    this.r = parami.b(17, false);
    this.s = parami.b(18, false);
    this.t = parami.b(19, false);
    this.u = parami.b(20, false);
    this.v = parami.b(21, false);
    this.w = parami.b(22, false);
    this.x = parami.b(23, false);
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    paramj.a(this.c, 2);
    paramj.a(this.d, 3);
    if (this.e != null) {
      paramj.a(this.e, 4);
    }
    paramj.a(this.f, 5);
    paramj.a(this.g, 6);
    paramj.a(this.h, 7);
    if (this.i != null) {
      paramj.a(this.i, 8);
    }
    if (this.j != null) {
      paramj.a(this.j, 9);
    }
    if (this.k != null) {
      paramj.a(this.k, 10);
    }
    if (this.l != null) {
      paramj.a(this.l, 11);
    }
    paramj.a(this.m, 12);
    if (this.n != null) {
      paramj.a(this.n, 13);
    }
    if (this.o != null) {
      paramj.a(this.o, 14);
    }
    if (this.p != null) {
      paramj.a(this.p, 15);
    }
    paramj.a(this.q, 16);
    if (this.r != null) {
      paramj.a(this.r, 17);
    }
    if (this.s != null) {
      paramj.a(this.s, 18);
    }
    if (this.t != null) {
      paramj.a(this.t, 19);
    }
    if (this.u != null) {
      paramj.a(this.u, 20);
    }
    if (this.v != null) {
      paramj.a(this.v, 21);
    }
    if (this.w != null) {
      paramj.a(this.w, 22);
    }
    if (this.x != null) {
      paramj.a(this.x, 23);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.ap
 * JD-Core Version:    0.7.0.1
 */