package com.tencent.beacon.core.e;

import android.util.Log;
import java.util.Locale;

public class d
{
  private static boolean a;
  private static boolean b;
  public static boolean c;
  
  private static int a(StackTraceElement[] paramArrayOfStackTraceElement, Class paramClass)
  {
    int i = 5;
    if (i < paramArrayOfStackTraceElement.length)
    {
      String str = paramArrayOfStackTraceElement[i].getClassName();
      if ((paramClass.equals(Log.class)) && (i < paramArrayOfStackTraceElement.length - 1) && (paramArrayOfStackTraceElement[(i + 1)].getClassName().equals(Log.class.getName()))) {}
      while (!str.equals(paramClass.getName()))
      {
        i += 1;
        break;
      }
      return i + 1;
    }
    return -1;
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (d()) {
      Log.d("beacon", c(paramString, paramVarArgs));
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      if (d()) {
        paramThrowable.printStackTrace();
      }
    }
    else {
      return;
    }
    b(paramThrowable.getMessage(), new Object[0]);
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      b = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (d()) {
      Log.e("beacon", c(paramString, paramVarArgs));
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    try
    {
      a = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected static String c(String paramString, Object... paramVarArgs)
  {
    String str = f();
    if (paramString == null) {
      return str + "msg is null";
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return str + paramString;
    }
    return str + String.format(Locale.US, paramString, paramVarArgs);
  }
  
  public static void c(boolean paramBoolean)
  {
    try
    {
      c = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean c()
  {
    try
    {
      boolean bool = c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if (d()) {
      Log.i("beacon", c(paramString, paramVarArgs));
    }
  }
  
  private static boolean d()
  {
    return b();
  }
  
  private static StackTraceElement e()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int j = a(arrayOfStackTraceElement, d.class);
    int i = j;
    if (j == -1)
    {
      j = a(arrayOfStackTraceElement, Log.class);
      i = j;
      if (j == -1) {
        return null;
      }
    }
    return arrayOfStackTraceElement[i];
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    if (d()) {
      Log.d("beacon_step_api", c(paramString, paramVarArgs));
    }
  }
  
  private static String f()
  {
    if (c())
    {
      StackTraceElement localStackTraceElement = e();
      if (localStackTraceElement != null)
      {
        String str2 = localStackTraceElement.getFileName();
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        return "(" + str1 + ":" + localStackTraceElement.getLineNumber() + ")" + localStackTraceElement.getMethodName() + " ";
      }
    }
    return "";
  }
  
  public static void f(String paramString, Object... paramVarArgs)
  {
    if (d()) {
      Log.d("beacon_step_buffer", c(paramString, paramVarArgs));
    }
  }
  
  public static void g(String paramString, Object... paramVarArgs)
  {
    if (d()) {
      Log.d("beacon_step_db", c(paramString, paramVarArgs));
    }
  }
  
  public static void h(String paramString, Object... paramVarArgs)
  {
    if (d()) {
      Log.d("beacon_step_upload", c(paramString, paramVarArgs));
    }
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    if (d()) {
      Log.w("beacon", c(paramString, paramVarArgs));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.e.d
 * JD-Core Version:    0.7.0.1
 */