package com.tencent.beacon.a.g;

import android.util.Log;
import java.util.Locale;

public class a
{
  public static boolean a = false;
  public static boolean b = false;
  public static boolean c = false;
  
  private static int a(StackTraceElement[] paramArrayOfStackTraceElement, Class paramClass)
  {
    int i = 5;
    while (i < paramArrayOfStackTraceElement.length)
    {
      String str = paramArrayOfStackTraceElement[i].getClassName();
      if (((!paramClass.equals(Log.class)) || (i >= paramArrayOfStackTraceElement.length - 1) || (!paramArrayOfStackTraceElement[(i + 1)].getClassName().equals(Log.class.getName()))) && (str.equals(paramClass.getName()))) {
        return i + 1;
      }
      i += 1;
    }
    return -1;
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (a) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.i("beacon", i(paramString, paramVarArgs));
      }
      return;
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    int j = 1;
    int i;
    if (a)
    {
      i = 1;
      if (i == 0) {
        break label24;
      }
      paramThrowable.printStackTrace();
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label24:
      paramThrowable = paramThrowable.getMessage();
      if (a) {}
      for (i = j; i != 0; i = 0)
      {
        Log.e("beacon", i(paramThrowable, new Object[0]));
        return;
      }
    }
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (a) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.d("beacon", i(paramString, paramVarArgs));
      }
      return;
    }
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    if (a) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.w("beacon", i(paramString, paramVarArgs));
      }
      return;
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if (a) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.e("beacon", i(paramString, paramVarArgs));
      }
      return;
    }
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    if (a) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.d("beacon_step_api", i(paramString, paramVarArgs));
      }
      return;
    }
  }
  
  public static void f(String paramString, Object... paramVarArgs)
  {
    if (a) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.d("beacon_step_buffer", i(paramString, paramVarArgs));
      }
      return;
    }
  }
  
  public static void g(String paramString, Object... paramVarArgs)
  {
    if (a) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.d("beacon_step_db", i(paramString, paramVarArgs));
      }
      return;
    }
  }
  
  public static void h(String paramString, Object... paramVarArgs)
  {
    if (a) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Log.d("beacon_step_upload", i(paramString, paramVarArgs));
      }
      return;
    }
  }
  
  private static String i(String paramString, Object... paramVarArgs)
  {
    int i;
    String str1;
    if (c)
    {
      localObject = Thread.currentThread().getStackTrace();
      int j = a((StackTraceElement[])localObject, a.class);
      i = j;
      if (j == -1)
      {
        j = a((StackTraceElement[])localObject, Log.class);
        i = j;
        if (j == -1)
        {
          localObject = null;
          if (localObject == null) {
            break label156;
          }
          String str2 = ((StackTraceElement)localObject).getFileName();
          str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
        }
      }
    }
    label156:
    for (Object localObject = "(" + str1 + ":" + ((StackTraceElement)localObject).getLineNumber() + ")" + ((StackTraceElement)localObject).getMethodName() + " ";; localObject = "")
    {
      if (paramString != null) {
        break label163;
      }
      return (String)localObject + "msg is null";
      localObject = localObject[i];
      break;
    }
    label163:
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return (String)localObject + paramString;
    }
    return (String)localObject + String.format(Locale.US, paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.g.a
 * JD-Core Version:    0.7.0.1
 */