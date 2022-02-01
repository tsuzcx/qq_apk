package com.tencent.featuretoggle.utils;

import android.util.Log;
import com.tencent.featuretoggle.ToggleSetting;
import java.util.Locale;

public class LogUtils
{
  private static String a(String paramString, Object... paramVarArgs)
  {
    if (paramString == null) {
      return "null";
    }
    String str = paramString;
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return paramString;
      }
      str = String.format(Locale.US, paramString, paramVarArgs);
    }
    return str;
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    a(4, paramString, paramVarArgs);
  }
  
  public static void a(Throwable paramThrowable) {}
  
  private static boolean a(int paramInt, String paramString, Object... paramVarArgs)
  {
    paramString = a(paramString, paramVarArgs);
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6) {
            return false;
          }
          Log.e("ToggleLog", paramString);
          return true;
        }
        Log.w("ToggleLog", paramString);
        return true;
      }
      Log.i("ToggleLog", paramString);
      return true;
    }
    Log.d("ToggleLog", paramString);
    return true;
  }
  
  private static boolean a(int paramInt, Throwable paramThrowable)
  {
    paramThrowable = Utils.a(paramThrowable);
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 6) {
          return false;
        }
        Log.e("ToggleLog", paramThrowable);
        return true;
      }
      Log.w("ToggleLog", paramThrowable);
      return true;
    }
    Log.d("ToggleLog", paramThrowable);
    return true;
  }
  
  public static boolean a(String paramString, Object... paramVarArgs)
  {
    if (ToggleSetting.c()) {
      return a(5, paramString, paramVarArgs);
    }
    return true;
  }
  
  public static boolean a(Throwable paramThrowable)
  {
    if (ToggleSetting.c()) {
      return a(5, paramThrowable);
    }
    return true;
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (ToggleSetting.c()) {
      a(3, paramString, paramVarArgs);
    }
  }
  
  public static boolean b(String paramString, Object... paramVarArgs)
  {
    if (ToggleSetting.c()) {
      return a(6, paramString, paramVarArgs);
    }
    return true;
  }
  
  public static void c(String paramString, Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.LogUtils
 * JD-Core Version:    0.7.0.1
 */