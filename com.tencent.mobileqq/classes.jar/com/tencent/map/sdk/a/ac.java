package com.tencent.map.sdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;

public final class ac
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static volatile boolean e;
  public static boolean f;
  public static boolean g = false;
  private static Context h = null;
  private static int i = 0;
  private static boolean j = false;
  private static String k = "";
  private static String l;
  private static String m;
  private static boolean n;
  private static String o;
  private static Handler p;
  private static boolean q;
  
  static
  {
    a = "null";
    b = "";
    c = "";
    d = "";
    l = "3.5.1.52";
    m = "";
    n = false;
    o = "";
    e = false;
    f = true;
    q = false;
  }
  
  public static Context a()
  {
    return h;
  }
  
  public static void a(boolean paramBoolean, int paramInt, q paramq, String paramString)
  {
    g = paramq.g;
    q = paramBoolean;
    Process.myPid();
    Object localObject = paramq.a;
    h = ((Context)localObject).getApplicationContext();
    k = ((Context)localObject).getPackageName();
    i = paramInt;
    j = paramq.c;
    String str = paramq.d;
    localObject = str;
    if (dg.a(str)) {
      localObject = "";
    }
    c = (String)localObject;
    localObject = paramq.e;
    paramq = (q)localObject;
    if (dg.a((String)localObject)) {
      paramq = "";
    }
    d = paramq;
    l = "3.5.1.52";
    new Handler(h.getMainLooper());
    m = paramString;
    n = k.equals(m);
    paramq = new HandlerThread("halley_" + i + "_" + "TempTask", 10);
    paramq.start();
    paramq = new Handler(paramq.getLooper());
    p = paramq;
    paramq.post(new ba());
  }
  
  public static boolean b()
  {
    return q;
  }
  
  public static int c()
  {
    return i;
  }
  
  public static String d()
  {
    return k;
  }
  
  public static boolean e()
  {
    return j;
  }
  
  public static String f()
  {
    return l;
  }
  
  public static String g()
  {
    if (!dg.a(o)) {
      return o;
    }
    if ((!dg.a(m)) && (m.contains(":")))
    {
      int i1 = m.indexOf(":");
      return m.substring(i1 + 1);
    }
    return "";
  }
  
  public static Handler h()
  {
    return p;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.ac
 * JD-Core Version:    0.7.0.1
 */