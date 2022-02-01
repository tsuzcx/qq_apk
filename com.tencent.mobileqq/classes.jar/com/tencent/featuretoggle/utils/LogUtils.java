package com.tencent.featuretoggle.utils;

import android.util.Log;
import com.tencent.featuretoggle.ToggleSetting;
import java.util.Locale;

public class LogUtils
{
  public static void a(String paramString, Object... paramVarArgs)
  {
    a(4, paramString, paramVarArgs);
  }
  
  private static boolean a(int paramInt, String paramString, Object... paramVarArgs)
  {
    paramString = f(paramString, paramVarArgs);
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
  
  public static boolean a(Throwable paramThrowable)
  {
    if (ToggleSetting.p()) {
      return a(5, paramThrowable);
    }
    return true;
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (ToggleSetting.p()) {
      a(3, paramString, paramVarArgs);
    }
  }
  
  public static void b(Throwable paramThrowable) {}
  
  public static boolean c(String paramString, Object... paramVarArgs)
  {
    if (ToggleSetting.p()) {
      return a(5, paramString, paramVarArgs);
    }
    return true;
  }
  
  public static boolean d(String paramString, Object... paramVarArgs)
  {
    if (ToggleSetting.p()) {
      return a(6, paramString, paramVarArgs);
    }
    return true;
  }
  
  public static void e(String paramString, Object... paramVarArgs) {}
  
  private static String f(String paramString, Object... paramVarArgs)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.LogUtils
 * JD-Core Version:    0.7.0.1
 */