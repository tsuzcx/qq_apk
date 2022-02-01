package com.huawei.hms.hatool;

public abstract class a
{
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = c(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.a();
    }
    return "";
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    paramString1 = c(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.e());
  }
  
  public static j c(String paramString1, String paramString2)
  {
    paramString1 = i.c().a(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(paramString2);
      if (paramString1 != null) {
        return paramString1.j();
      }
    }
    return null;
  }
  
  public static String d(String paramString1, String paramString2)
  {
    paramString1 = c(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.b();
    }
    return "";
  }
  
  public static boolean e(String paramString1, String paramString2)
  {
    paramString1 = c(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.f());
  }
  
  public static boolean f(String paramString1, String paramString2)
  {
    paramString1 = i.c().a(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(paramString2);
      if (paramString1 != null) {
        return paramString1.c();
      }
    }
    return false;
  }
  
  public static String g(String paramString1, String paramString2)
  {
    paramString1 = c(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.d();
    }
    return "";
  }
  
  public static boolean h(String paramString1, String paramString2)
  {
    paramString1 = c(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.g());
  }
  
  public static boolean i(String paramString1, String paramString2)
  {
    paramString1 = i.c().a(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(paramString2);
      if (paramString1 != null) {
        return paramString1.e();
      }
    }
    return false;
  }
  
  public static String j(String paramString1, String paramString2)
  {
    paramString1 = c(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.c();
    }
    return "";
  }
  
  public static boolean k(String paramString1, String paramString2)
  {
    paramString1 = c(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.h());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.a
 * JD-Core Version:    0.7.0.1
 */