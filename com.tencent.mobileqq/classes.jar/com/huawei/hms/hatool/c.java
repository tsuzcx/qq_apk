package com.huawei.hms.hatool;

import java.util.Map;

public abstract class c
{
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      paramString1.a(paramLong);
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.a();
    }
    return true;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.d();
    }
    return 7;
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.g();
    }
    return true;
  }
  
  public static String d(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.f();
    }
    return "";
  }
  
  public static boolean e(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.i();
    }
    return false;
  }
  
  public static String f(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.h();
    }
    return "";
  }
  
  public static String g(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.n();
    }
    return "";
  }
  
  public static k h(String paramString1, String paramString2)
  {
    m localm = i.c().a(paramString1);
    if (localm != null)
    {
      if ("alltype".equals(paramString2))
      {
        paramString2 = localm.a("oper");
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = localm.a("maint");
        }
        return paramString1;
      }
      return localm.a(paramString2);
    }
    return null;
  }
  
  public static Map<String, String> i(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.k();
    }
    return null;
  }
  
  public static long j(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.l();
    }
    return 0L;
  }
  
  public static int k(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.b();
    }
    return 10;
  }
  
  public static String l(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.o();
    }
    return "";
  }
  
  public static String m(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.q();
    }
    return "";
  }
  
  public static String n(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.m();
    }
    return "";
  }
  
  public static String o(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.p();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.c
 * JD-Core Version:    0.7.0.1
 */