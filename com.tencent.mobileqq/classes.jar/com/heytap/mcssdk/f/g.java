package com.heytap.mcssdk.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;

public class g
{
  public static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseInt--NumberFormatException");
        localStringBuilder.append(paramString.getMessage());
        c.b(localStringBuilder.toString());
      }
    }
    return -1;
  }
  
  public static String a(int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((char)paramArrayOfInt[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString, 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("isExistPackage NameNotFoundException:");
      paramString.append(paramContext.getMessage());
      c.b(paramString.toString());
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramString1, 128);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramString1 = new StringBuilder();
      paramString1.append("isSupportPush NameNotFoundException:");
      paramString1.append(paramContext.getMessage());
      c.b(paramString1.toString());
      paramContext = null;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.metaData.getBoolean(paramString2, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int b(Context paramContext, String paramString)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("getVersionCode--Exception:");
      paramString.append(paramContext.getMessage());
      c.a(paramString.toString());
    }
    return 0;
  }
  
  public static String c(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("getVersionName--Exception:");
      paramString.append(paramContext.getMessage());
      c.a(paramString.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.f.g
 * JD-Core Version:    0.7.0.1
 */