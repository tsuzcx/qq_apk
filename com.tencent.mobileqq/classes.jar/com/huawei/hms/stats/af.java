package com.huawei.hms.stats;

public class af
{
  private static ag a = new ag();
  
  public static void a(int paramInt)
  {
    a.a(paramInt);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((a()) && (paramString1 != null) && (paramString2 != null)) {
      a.a(3, paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((b()) && (paramString1 != null) && (paramString2 != null))
    {
      paramString2 = String.format(paramString2, paramVarArgs);
      a.a(4, paramString1, paramString2);
    }
  }
  
  private static boolean a()
  {
    return a.b(3);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if ((b()) && (paramString1 != null) && (paramString2 != null)) {
      a.a(4, paramString1, paramString2);
    }
  }
  
  private static boolean b()
  {
    return a.b(4);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if ((c()) && (paramString1 != null) && (paramString2 != null)) {
      a.a(5, paramString1, paramString2);
    }
  }
  
  private static boolean c()
  {
    return a.b(5);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if ((d()) && (paramString1 != null) && (paramString2 != null)) {
      a.a(6, paramString1, paramString2);
    }
  }
  
  private static boolean d()
  {
    return a.b(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.af
 * JD-Core Version:    0.7.0.1
 */