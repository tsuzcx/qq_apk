package com.huawei.hms.stats;

import java.util.Map;

public abstract class c
{
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.l();
    }
    return "";
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      paramString1.a(paramLong);
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.g();
    }
    return "";
  }
  
  public static String c(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.h();
    }
    return "";
  }
  
  public static String d(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.i();
    }
    return "";
  }
  
  public static String e(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.j();
    }
    return "";
  }
  
  public static String f(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.k();
    }
    return "";
  }
  
  public static int g(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.c();
    }
    return 7;
  }
  
  public static int h(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.d();
    }
    return 10;
  }
  
  public static boolean i(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.n();
    }
    return true;
  }
  
  public static boolean j(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.o();
    }
    return false;
  }
  
  public static boolean k(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.m();
    }
    return true;
  }
  
  public static Map<String, String> l(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.a();
    }
    return null;
  }
  
  public static String m(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.p();
    }
    return "";
  }
  
  public static long n(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.q();
    }
    return 0L;
  }
  
  private static p o(String paramString1, String paramString2)
  {
    s locals = n.a().a(paramString1);
    if (locals != null)
    {
      if ("alltype".equals(paramString2))
      {
        paramString2 = locals.a("oper");
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = locals.a("maint");
        }
        return paramString1;
      }
      return locals.a(paramString2);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.c
 * JD-Core Version:    0.7.0.1
 */