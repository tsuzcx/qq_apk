package com.tencent.ilivesdk.pluginloaderservice.utils;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.log.LogInterface;

public class LogUtil
{
  private static LogInterface a;
  private static String b = "%s";
  
  public static void a()
  {
    a = null;
  }
  
  public static void a(String paramString, LogInterface paramLogInterface)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" | %s");
      b = localStringBuilder.toString();
    }
    a = paramLogInterface;
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogInterface localLogInterface = a;
    if (localLogInterface != null) {
      localLogInterface.d(String.format(b, new Object[] { paramString1 }), paramString2, paramVarArgs);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogInterface localLogInterface = a;
    if (localLogInterface != null) {
      localLogInterface.i(String.format(b, new Object[] { paramString1 }), paramString2, paramVarArgs);
    }
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogInterface localLogInterface = a;
    if (localLogInterface != null) {
      localLogInterface.e(String.format(b, new Object[] { paramString1 }), paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil
 * JD-Core Version:    0.7.0.1
 */