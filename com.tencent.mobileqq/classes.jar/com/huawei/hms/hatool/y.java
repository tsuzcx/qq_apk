package com.huawei.hms.hatool;

public class y
{
  public static z a = new z();
  
  public static void a(int paramInt)
  {
    a.a(paramInt);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((a()) && (paramString1 != null) && (paramString2 != null)) {
      a.b(3, paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((c()) && (paramString1 != null) && (paramString2 != null))
    {
      paramString2 = String.format(paramString2, paramVarArgs);
      a.b(4, paramString1, paramString2);
    }
  }
  
  public static boolean a()
  {
    return a.b(3);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if ((b()) && (paramString1 != null) && (paramString2 != null)) {
      a.b(6, paramString1, paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    d(paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static boolean b()
  {
    return a.b(6);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if ((c()) && (paramString1 != null) && (paramString2 != null)) {
      a.b(4, paramString1, paramString2);
    }
  }
  
  public static boolean c()
  {
    return a.b(4);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      a.b(4, paramString1, paramString2);
    }
  }
  
  public static boolean d()
  {
    return a.b(5);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      a.b(5, paramString1, paramString2);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    if ((d()) && (paramString1 != null) && (paramString2 != null)) {
      a.b(5, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.y
 * JD-Core Version:    0.7.0.1
 */