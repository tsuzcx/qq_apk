package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.huawei.hms.base.log.a;

public class HMSLog
{
  public static final a a = new a();
  
  public static String a(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    if (localObject != null) {}
    try
    {
      paramContext = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 16384);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("HMS-");
      ((StringBuilder)localObject).append(paramContext.versionName);
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(paramContext.versionCode);
      ((StringBuilder)localObject).append(")");
      paramContext = ((StringBuilder)localObject).toString();
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return "HMS-[unknown-version]";
    return "HMS-[unknown-version]";
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a.a(3, paramString1, paramString2);
  }
  
  public static void e(String paramString1, long paramLong, String paramString2)
  {
    a locala = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString2);
    locala.a(6, paramString1, localStringBuilder.toString());
  }
  
  public static void e(String paramString1, long paramLong, String paramString2, Throwable paramThrowable)
  {
    a locala = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString2);
    locala.b(6, paramString1, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a.a(6, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a.b(6, paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    a.a(4, paramString1, paramString2);
  }
  
  public static void init(Context paramContext, int paramInt, String paramString)
  {
    a.a(paramContext, paramInt, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("============================================================================");
    localStringBuilder.append('\n');
    localStringBuilder.append("====== ");
    localStringBuilder.append(a(paramContext));
    localStringBuilder.append('\n');
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.log.HMSLog
 * JD-Core Version:    0.7.0.1
 */