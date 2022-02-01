package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class HMSLog
{
  private static final a a = new a();
  
  private static String a(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager != null) {
      try
      {
        paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 16384);
        paramContext = "HMS-" + paramContext.versionName + "(" + paramContext.versionCode + ")";
        return paramContext;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        return "HMS-[unknown-version]";
      }
    }
    return "HMS-[unknown-version]";
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a.a(3, paramString1, paramString2);
  }
  
  public static void e(String paramString1, long paramLong, String paramString2)
  {
    a.a(6, paramString1, "[" + paramLong + "] " + paramString2);
  }
  
  public static void e(String paramString1, long paramLong, String paramString2, Throwable paramThrowable)
  {
    a.a(6, paramString1, "[" + paramLong + "] " + paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a.a(6, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a.a(6, paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    a.a(4, paramString1, paramString2);
  }
  
  public static void init(Context paramContext, int paramInt, String paramString)
  {
    a.a(paramContext, paramInt, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("============================================================================").append('\n');
    localStringBuilder.append("====== ").append(a(paramContext)).append('\n');
    localStringBuilder.append("============================================================================");
    a.a(paramString, localStringBuilder.toString());
  }
  
  public static boolean isErrorEnable()
  {
    return a.a(6);
  }
  
  public static boolean isInfoEnable()
  {
    return a.a(4);
  }
  
  public static boolean isWarnEnable()
  {
    return a.a(5);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    a.a(5, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.log.HMSLog
 * JD-Core Version:    0.7.0.1
 */