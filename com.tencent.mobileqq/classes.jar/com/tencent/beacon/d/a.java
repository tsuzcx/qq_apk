package com.tencent.beacon.d;

import android.util.Log;
import java.util.Locale;

public final class a
{
  public static boolean a = false;
  public static boolean b = false;
  
  private static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    int i;
    String str;
    if (a)
    {
      i = 1;
      if (i != 0)
      {
        if (paramString2 != null) {
          break label33;
        }
        str = "null";
      }
    }
    for (;;)
    {
      Log.d(paramString1, str);
      return;
      i = 0;
      break;
      label33:
      str = paramString2;
      if (paramVarArgs != null)
      {
        str = paramString2;
        if (paramVarArgs.length != 0) {
          str = String.format(Locale.US, paramString2, paramVarArgs);
        }
      }
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    int i;
    String str;
    if (a)
    {
      i = 1;
      if (i != 0)
      {
        if (paramString != null) {
          break label32;
        }
        str = "null";
      }
    }
    for (;;)
    {
      Log.i("beacon", str);
      return;
      i = 0;
      break;
      label32:
      str = paramString;
      if (paramVarArgs != null)
      {
        str = paramString;
        if (paramVarArgs.length != 0) {
          str = String.format(Locale.US, paramString, paramVarArgs);
        }
      }
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    if ((paramThrowable != null) && ((paramThrowable instanceof Throwable))) {
      if (!a) {
        break label28;
      }
    }
    label28:
    for (int i = 1; i != 0; i = 0)
    {
      paramThrowable.printStackTrace();
      return;
    }
    d(paramThrowable.getMessage(), new Object[0]);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    int i;
    String str;
    if (a)
    {
      i = 1;
      if (i != 0)
      {
        if (paramString != null) {
          break label32;
        }
        str = "null";
      }
    }
    for (;;)
    {
      Log.d("beacon", str);
      return;
      i = 0;
      break;
      label32:
      str = paramString;
      if (paramVarArgs != null)
      {
        str = paramString;
        if (paramVarArgs.length != 0) {
          str = String.format(Locale.US, paramString, paramVarArgs);
        }
      }
    }
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    String str;
    if (paramString == null) {
      str = "null";
    }
    for (;;)
    {
      Log.w("beacon", str);
      return;
      str = paramString;
      if (paramVarArgs != null)
      {
        str = paramString;
        if (paramVarArgs.length != 0) {
          str = String.format(Locale.US, paramString, paramVarArgs);
        }
      }
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    String str;
    if (paramString == null) {
      str = "null";
    }
    for (;;)
    {
      Log.e("beacon", str);
      return;
      str = paramString;
      if (paramVarArgs != null)
      {
        str = paramString;
        if (paramVarArgs.length != 0) {
          str = String.format(Locale.US, paramString, paramVarArgs);
        }
      }
    }
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    a("beacon_step_api", paramString, paramVarArgs);
  }
  
  public static void f(String paramString, Object... paramVarArgs)
  {
    a("beacon_step_buffer", paramString, paramVarArgs);
  }
  
  public static void g(String paramString, Object... paramVarArgs)
  {
    a("beacon_step_db", paramString, paramVarArgs);
  }
  
  public static void h(String paramString, Object... paramVarArgs)
  {
    a("beacon_step_upload", paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.d.a
 * JD-Core Version:    0.7.0.1
 */