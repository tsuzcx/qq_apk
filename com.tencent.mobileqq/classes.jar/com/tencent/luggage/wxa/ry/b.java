package com.tencent.luggage.wxa.ry;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringTokenizer;

public final class b
{
  private static volatile b.a a;
  
  static
  {
    try
    {
      Class.forName("android.util.Log");
      localObject = new a();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject;
      label17:
      break label17;
    }
    localObject = new b.1();
    a = (b.a)localObject;
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    b.a locala = a;
    if (locala == null) {
      return;
    }
    locala.a(paramInt, paramString1, paramString2);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    b.a locala = a;
    if (locala != null)
    {
      if (!locala.a(paramString1, paramInt)) {
        return;
      }
      locala.a(paramInt, paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    b.a locala = a;
    if (locala != null)
    {
      if (!locala.a(paramString, paramInt)) {
        return;
      }
      StringWriter localStringWriter = new StringWriter(512);
      paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
      paramThrowable = new StringTokenizer(localStringWriter.toString(), "\n");
      while (paramThrowable.hasMoreTokens()) {
        locala.a(paramInt, paramString, paramThrowable.nextToken());
      }
    }
  }
  
  public static void a(b.a parama)
  {
    a = parama;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(6, paramString1, paramString2, paramVarArgs);
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      a(6, paramString1, paramString2);
    }
    if (paramThrowable != null) {
      a(6, paramString1, paramThrowable);
    }
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    a(6, paramString1, paramString2, paramVarArgs);
    if (paramThrowable != null) {
      a(6, paramString1, paramThrowable);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(5, paramString1, paramString2, paramVarArgs);
  }
  
  public static void b(String paramString1, Throwable paramThrowable, String paramString2)
  {
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      a(5, paramString1, paramString2);
    }
    if (paramThrowable != null) {
      a(5, paramString1, paramThrowable);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2);
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(4, paramString1, paramString2, paramVarArgs);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(3, paramString1, paramString2, paramVarArgs);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ry.b
 * JD-Core Version:    0.7.0.1
 */