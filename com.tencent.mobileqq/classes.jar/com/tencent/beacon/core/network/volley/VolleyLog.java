package com.tencent.beacon.core.network.volley;

import android.util.Log;
import com.tencent.beacon.core.e.d;
import java.util.Locale;

public class VolleyLog
{
  private static final String CLASS_NAME = VolleyLog.class.getName();
  public static boolean DEBUG = Log.isLoggable(TAG, 2);
  public static String TAG = "Beacon.Volley";
  
  private static String buildMessage(String paramString, Object... paramVarArgs)
  {
    int i;
    label20:
    String str;
    if (paramVarArgs == null)
    {
      paramVarArgs = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
      if (i >= paramVarArgs.length) {
        break label155;
      }
      if (paramVarArgs[i].getClassName().equals(CLASS_NAME)) {
        break label148;
      }
      str = paramVarArgs[i].getClassName();
      str = str.substring(str.lastIndexOf('.') + 1);
      str = str.substring(str.lastIndexOf('$') + 1);
    }
    label148:
    label155:
    for (paramVarArgs = str + "." + paramVarArgs[i].getMethodName();; paramVarArgs = "<unknown>")
    {
      return String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramVarArgs, paramString });
      paramString = String.format(Locale.US, paramString, paramVarArgs);
      break;
      i += 1;
      break label20;
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    d.a(TAG, new Object[] { buildMessage(paramString, paramVarArgs) });
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    d.b(TAG, new Object[] { buildMessage(paramString, paramVarArgs) });
  }
  
  public static void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    d.b(TAG, new Object[] { buildMessage(paramString, paramVarArgs), paramThrowable });
  }
  
  public static void setTag(String paramString)
  {
    d("Changing log tag to %s", new Object[] { paramString });
    TAG = paramString;
    DEBUG = Log.isLoggable(TAG, 2);
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    if (DEBUG) {
      d.d(TAG, new Object[] { buildMessage(paramString, paramVarArgs) });
    }
  }
  
  public static void wtf(String paramString, Object... paramVarArgs)
  {
    d.b(TAG, new Object[] { buildMessage(paramString, paramVarArgs) });
  }
  
  public static void wtf(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    d.b(TAG, new Object[] { buildMessage(paramString, paramVarArgs), paramThrowable });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.VolleyLog
 * JD-Core Version:    0.7.0.1
 */