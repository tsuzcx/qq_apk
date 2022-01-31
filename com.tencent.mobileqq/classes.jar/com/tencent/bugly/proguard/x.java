package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

public final class x
{
  public static String a = "CrashReportInfo";
  public static String b = "CrashReport";
  public static boolean c = false;
  
  private static boolean a(int paramInt, String paramString, Object... paramVarArgs)
  {
    if (!c) {
      return false;
    }
    String str;
    if (paramString == null) {
      str = "null";
    }
    for (;;)
    {
      switch (paramInt)
      {
      case 4: 
      default: 
        return false;
      case 0: 
        Log.i(b, str);
        return true;
        str = paramString;
        if (paramVarArgs != null)
        {
          str = paramString;
          if (paramVarArgs.length != 0) {
            str = String.format(Locale.US, paramString, paramVarArgs);
          }
        }
        break;
      }
    }
    Log.i(a, str);
    return true;
    Log.d(b, str);
    return true;
    Log.w(b, str);
    return true;
    Log.e(b, str);
    return true;
  }
  
  public static boolean a(Class paramClass, String paramString, Object... paramVarArgs)
  {
    return a(0, String.format(Locale.US, "[%s] %s", new Object[] { paramClass.getSimpleName(), paramString }), paramVarArgs);
  }
  
  public static boolean a(String paramString, Object... paramVarArgs)
  {
    return a(0, paramString, paramVarArgs);
  }
  
  public static boolean a(Throwable paramThrowable)
  {
    if (!c) {
      return false;
    }
    return a(2, z.a(paramThrowable), new Object[0]);
  }
  
  public static boolean b(Class paramClass, String paramString, Object... paramVarArgs)
  {
    return a(1, String.format(Locale.US, "[%s] %s", new Object[] { paramClass.getSimpleName(), paramString }), paramVarArgs);
  }
  
  public static boolean b(String paramString, Object... paramVarArgs)
  {
    return a(5, paramString, paramVarArgs);
  }
  
  public static boolean b(Throwable paramThrowable)
  {
    if (!c) {
      return false;
    }
    return a(3, z.a(paramThrowable), new Object[0]);
  }
  
  public static boolean c(String paramString, Object... paramVarArgs)
  {
    return a(1, paramString, paramVarArgs);
  }
  
  public static boolean d(String paramString, Object... paramVarArgs)
  {
    return a(2, paramString, paramVarArgs);
  }
  
  public static boolean e(String paramString, Object... paramVarArgs)
  {
    return a(3, paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.x
 * JD-Core Version:    0.7.0.1
 */