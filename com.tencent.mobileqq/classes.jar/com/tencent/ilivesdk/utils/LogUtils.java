package com.tencent.ilivesdk.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.MissingFormatArgumentException;

public class LogUtils
{
  public static final int DEBUG = 50;
  public static final int ERROR = 10;
  public static final int INFO = 40;
  public static final int VERBOSE = 60;
  public static final int WARNING = 20;
  private static boolean isDebug = true;
  private static int logPrintLevel = 50;
  private static LogUtils.OnLogListener onLogListener;
  
  public static void d(String paramString1, String paramString2)
  {
    printTag(50, paramString1, paramString2, new Object[0]);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    printTag(10, paramString1, paramString2, new Object[0]);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    e(paramString, paramThrowable, "");
  }
  
  public static void e(String paramString1, Throwable paramThrowable, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("\n");
      paramString2 = ((StringBuilder)localObject).toString();
    }
    else
    {
      paramString2 = "";
    }
    Object localObject = paramString2;
    if (paramThrowable != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramThrowable));
      localObject = ((StringBuilder)localObject).toString();
    }
    printTag(10, paramString1, (String)localObject, new Object[0]);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    printTag(40, paramString1, paramString2, new Object[0]);
  }
  
  private static void logToLogListener(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 10)
    {
      if (paramInt != 20)
      {
        if (paramInt != 40)
        {
          if (paramInt != 50)
          {
            if (paramInt != 60) {
              return;
            }
            onLogListener.v(paramString1, paramString2);
            return;
          }
          onLogListener.d(paramString1, paramString2);
          return;
        }
        onLogListener.i(paramString1, paramString2);
        return;
      }
      onLogListener.w(paramString1, paramString2);
      return;
    }
    onLogListener.e(paramString1, paramString2);
  }
  
  private static void printTag(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    int i = paramInt;
    if (paramInt == 20) {
      i = 10;
    }
    String str = paramString2;
    if (paramVarArgs != null) {}
    try
    {
      if (paramVarArgs.length == 0) {
        str = paramString2;
      } else {
        str = String.format(paramString2, paramVarArgs);
      }
      if (onLogListener != null)
      {
        if (i > logPrintLevel) {
          break label105;
        }
        logToLogListener(i, paramString1, str);
        return;
      }
      if ((!isDebug) || (i > logPrintLevel)) {
        break label105;
      }
      Log.println(toSysLevel(i), paramString1, str);
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      break label91;
    }
    catch (Exception paramString1)
    {
      break label96;
    }
    catch (MissingFormatArgumentException paramString1)
    {
      label91:
      break label101;
    }
    paramString1.printStackTrace();
    return;
    label96:
    paramString1.printStackTrace();
    return;
    label101:
    paramString1.printStackTrace();
    label105:
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    isDebug = paramBoolean;
  }
  
  public static void setLogPrintLevel(int paramInt)
  {
    logPrintLevel = paramInt;
  }
  
  public static void setOnLogListener(LogUtils.OnLogListener paramOnLogListener)
  {
    onLogListener = paramOnLogListener;
  }
  
  private static int toSysLevel(int paramInt)
  {
    if (paramInt != 10)
    {
      if (paramInt != 20)
      {
        if (paramInt != 40)
        {
          if (paramInt != 50)
          {
            if (paramInt != 60) {
              return 0;
            }
            return 2;
          }
          return 3;
        }
        return 4;
      }
      return 5;
    }
    return 6;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    printTag(60, paramString1, paramString2, new Object[0]);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    printTag(20, paramString1, paramString2, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.utils.LogUtils
 * JD-Core Version:    0.7.0.1
 */