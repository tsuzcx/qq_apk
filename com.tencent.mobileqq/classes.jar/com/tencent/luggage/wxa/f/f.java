package com.tencent.luggage.wxa.f;

public class f
{
  private static n a = ;
  
  private static String a(String paramString, Object... paramVarArgs)
  {
    return String.format(null, paramString, paramVarArgs);
  }
  
  public static void a(n paramn)
  {
    if (paramn != null)
    {
      a = paramn;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a.a(3)) {
      a.a(paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject)
  {
    if (a.a(3)) {
      a.a(paramString1, a(paramString2, new Object[] { paramObject }));
    }
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    if (a.a(4)) {
      a.b(paramString1, a(paramString2, new Object[] { paramObject1, paramObject2 }));
    }
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (a.a(4)) {
      a.b(paramString1, a(paramString2, new Object[] { paramObject1, paramObject2, paramObject3 }));
    }
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (a.a(4)) {
      a.b(paramString1, a(paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a.a(4)) {
      a.a(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a.a(4)) {
      a.b(paramString1, a(paramString2, paramVarArgs));
    }
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a.a(6)) {
      a.c(paramString1, a(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a.a(4)) {
      a.b(paramString1, paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object paramObject)
  {
    if (a.a(4)) {
      a.b(paramString1, a(paramString2, new Object[] { paramObject }));
    }
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a.a(5)) {
      a.b(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a.a(6)) {
      a.d(paramString1, a(paramString2, paramVarArgs));
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a.a(5)) {
      a.c(paramString1, paramString2);
    }
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a.a(6)) {
      a.c(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a.a(6)) {
      a.d(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.f
 * JD-Core Version:    0.7.0.1
 */