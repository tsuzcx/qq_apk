package com.tencent.component.network.module.base;

import com.tencent.component.network.module.base.inter.IDownloadConfig;
import java.util.HashMap;

public class Config
{
  private static IDownloadConfig a = null;
  
  public static int a()
  {
    if (a != null) {
      return a.b();
    }
    return -1;
  }
  
  public static long a()
  {
    if (a != null) {
      return a.a();
    }
    return 0L;
  }
  
  public static long a(String paramString1, String paramString2, long paramLong)
  {
    long l = paramLong;
    if (a != null) {
      l = a.a(paramString1, paramString2, paramLong);
    }
    return l;
  }
  
  public static String a()
  {
    if (a != null) {
      return a.c();
    }
    return "android";
  }
  
  public static void a(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, String paramString2)
  {
    if (a != null) {
      a.a(paramInt1, paramBoolean, paramString1, paramInt2, paramString2);
    }
  }
  
  public static void a(IDownloadConfig paramIDownloadConfig)
  {
    a = paramIDownloadConfig;
  }
  
  public static void a(String paramString, boolean paramBoolean, HashMap paramHashMap, long paramLong)
  {
    if (a != null) {
      a.a(paramString, paramBoolean, paramHashMap, paramLong);
    }
  }
  
  public static boolean a()
  {
    if (a != null) {
      return a.a();
    }
    return true;
  }
  
  public static boolean a(int paramInt)
  {
    if (a != null) {
      return a.a(paramInt);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (a != null) {
      return a.a(paramString);
    }
    return false;
  }
  
  public static int b()
  {
    if (a != null) {
      return a.c();
    }
    return -1;
  }
  
  public static long b()
  {
    if ((a != null) && (a.b() > 0L)) {
      return a.b();
    }
    return 120L;
  }
  
  public static String b()
  {
    if (a != null) {
      return a.e();
    }
    return "1.0";
  }
  
  public static boolean b(String paramString)
  {
    if (a != null) {
      return a.b(paramString);
    }
    return false;
  }
  
  public static int c()
  {
    if (a != null) {
      return a.a();
    }
    return 0;
  }
  
  public static long c()
  {
    if ((a != null) && (a.c() > 0L)) {
      return a.c();
    }
    return 120L;
  }
  
  public static String c()
  {
    if (a != null) {
      return a.b();
    }
    return "tencent";
  }
  
  public static int d()
  {
    if (a != null) {
      return a.d();
    }
    return 5;
  }
  
  public static String d()
  {
    if (a != null) {
      return a.d();
    }
    return "android-tencent";
  }
  
  public static int e()
  {
    if ((a != null) && (a.e() > 0)) {
      return a.e();
    }
    return 2;
  }
  
  public static String e()
  {
    if (a != null) {
      return a.a();
    }
    return "";
  }
  
  public static int f()
  {
    if ((a != null) && (a.f() > 0)) {
      return a.f();
    }
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.base.Config
 * JD-Core Version:    0.7.0.1
 */