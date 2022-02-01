package com.huawei.hms.stats;

public abstract class a
{
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.e();
    }
    return "";
  }
  
  public static String b(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.f();
    }
    return "";
  }
  
  public static String c(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.g();
    }
    return "";
  }
  
  public static String d(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.h();
    }
    return "";
  }
  
  public static boolean e(String paramString1, String paramString2)
  {
    paramString1 = n.a().a(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(paramString2);
      if (paramString1 != null) {
        return paramString1.e();
      }
    }
    return false;
  }
  
  public static boolean f(String paramString1, String paramString2)
  {
    paramString1 = n.a().a(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(paramString2);
      if (paramString1 != null) {
        return paramString1.f();
      }
    }
    return false;
  }
  
  public static boolean g(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.a());
  }
  
  public static boolean h(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.c());
  }
  
  public static boolean i(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.d());
  }
  
  public static boolean j(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.b());
  }
  
  private static o k(String paramString1, String paramString2)
  {
    paramString1 = n.a().a(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(paramString2);
      if (paramString1 != null) {
        return paramString1.b();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.a
 * JD-Core Version:    0.7.0.1
 */