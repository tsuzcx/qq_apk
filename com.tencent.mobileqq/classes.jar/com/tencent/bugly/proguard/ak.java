package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class ak
  extends k
{
  private static ArrayList<aj> A;
  private static Map<String, String> B;
  private static Map<String, String> C;
  private static Map<String, String> v = new HashMap();
  private static ai w;
  private static ah x;
  private static ArrayList<ah> y;
  private static ArrayList<ah> z;
  public String a = "";
  public long b = 0L;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public Map<String, String> h = null;
  public String i = "";
  public ai j = null;
  public int k = 0;
  public String l = "";
  public String m = "";
  public ah n = null;
  public ArrayList<ah> o = null;
  public ArrayList<ah> p = null;
  public ArrayList<aj> q = null;
  public Map<String, String> r = null;
  public Map<String, String> s = null;
  public String t = "";
  private boolean u = true;
  
  static
  {
    v.put("", "");
    w = new ai();
    x = new ah();
    y = new ArrayList();
    Object localObject = new ah();
    y.add(localObject);
    z = new ArrayList();
    localObject = new ah();
    z.add(localObject);
    A = new ArrayList();
    localObject = new aj();
    A.add(localObject);
    B = new HashMap();
    B.put("", "");
    C = new HashMap();
    C.put("", "");
  }
  
  public final void a(i parami)
  {
    this.a = parami.b(0, true);
    this.b = parami.a(this.b, 1, true);
    this.c = parami.b(2, true);
    this.d = parami.b(3, false);
    this.e = parami.b(4, false);
    this.f = parami.b(5, false);
    this.g = parami.b(6, false);
    this.h = ((Map)parami.a(v, 7, false));
    this.i = parami.b(8, false);
    this.j = ((ai)parami.a(w, 9, false));
    this.k = parami.a(this.k, 10, false);
    this.l = parami.b(11, false);
    this.m = parami.b(12, false);
    this.n = ((ah)parami.a(x, 13, false));
    this.o = ((ArrayList)parami.a(y, 14, false));
    this.p = ((ArrayList)parami.a(z, 15, false));
    this.q = ((ArrayList)parami.a(A, 16, false));
    this.r = ((Map)parami.a(B, 17, false));
    this.s = ((Map)parami.a(C, 18, false));
    this.t = parami.b(19, false);
    boolean bool = this.u;
    this.u = parami.a(20, false);
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    paramj.a(this.c, 2);
    Object localObject = this.d;
    if (localObject != null) {
      paramj.a((String)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      paramj.a((String)localObject, 4);
    }
    localObject = this.f;
    if (localObject != null) {
      paramj.a((String)localObject, 5);
    }
    localObject = this.g;
    if (localObject != null) {
      paramj.a((String)localObject, 6);
    }
    localObject = this.h;
    if (localObject != null) {
      paramj.a((Map)localObject, 7);
    }
    localObject = this.i;
    if (localObject != null) {
      paramj.a((String)localObject, 8);
    }
    localObject = this.j;
    if (localObject != null) {
      paramj.a((k)localObject, 9);
    }
    paramj.a(this.k, 10);
    localObject = this.l;
    if (localObject != null) {
      paramj.a((String)localObject, 11);
    }
    localObject = this.m;
    if (localObject != null) {
      paramj.a((String)localObject, 12);
    }
    localObject = this.n;
    if (localObject != null) {
      paramj.a((k)localObject, 13);
    }
    localObject = this.o;
    if (localObject != null) {
      paramj.a((Collection)localObject, 14);
    }
    localObject = this.p;
    if (localObject != null) {
      paramj.a((Collection)localObject, 15);
    }
    localObject = this.q;
    if (localObject != null) {
      paramj.a((Collection)localObject, 16);
    }
    localObject = this.r;
    if (localObject != null) {
      paramj.a((Map)localObject, 17);
    }
    localObject = this.s;
    if (localObject != null) {
      paramj.a((Map)localObject, 18);
    }
    localObject = this.t;
    if (localObject != null) {
      paramj.a((String)localObject, 19);
    }
    paramj.a(this.u, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.proguard.ak
 * JD-Core Version:    0.7.0.1
 */