package com.tencent.mobileqq.apollo.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Build.VERSION;
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class ApolloHardWareTester
{
  private static boolean a;
  private static boolean b;
  private static boolean c;
  private static boolean d;
  private static boolean e;
  
  public static int a()
  {
    if ((c) && (ApolloConfigUtils.e)) {
      return 3;
    }
    return 2;
  }
  
  public static boolean a()
  {
    if (!d)
    {
      e = DeviceInfoUtil.e();
      d = true;
    }
    return e;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = a();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (a) {
      return b;
    }
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    }
    b = bool1;
    bool1 = b;
    if (!bool1)
    {
      a = true;
      return bool1;
    }
    if (paramContext != null)
    {
      b = b(paramContext);
      a = true;
    }
    return b;
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    if (paramContext == null) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
        if (paramContext != null)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isOpenglSupport reqGlEsVersion:");
          localStringBuilder.append(paramContext.reqGlEsVersion);
          QLog.i("[cmshow]ApolloHardWareTester", 1, localStringBuilder.toString());
          if (paramContext.reqGlEsVersion < 196608) {
            break label145;
          }
          bool1 = true;
          c = bool1;
          int i = paramContext.reqGlEsVersion;
          bool1 = bool2;
          if (i >= 131072) {
            bool1 = true;
          }
          return bool1;
        }
      }
      catch (Throwable paramContext)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isOpenglSupport:");
          localStringBuilder.append(paramContext.getMessage());
          QLog.e("[cmshow]ApolloHardWareTester", 2, localStringBuilder.toString());
        }
      }
      return false;
      label145:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloHardWareTester
 * JD-Core Version:    0.7.0.1
 */