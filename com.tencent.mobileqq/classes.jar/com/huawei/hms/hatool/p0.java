package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.File;

public class p0
{
  public static boolean a(Context paramContext)
  {
    long l = g0.a(paramContext, "Privacy_MY", "flashKeyTime", -1L);
    return System.currentTimeMillis() - l > 43200000L;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return true;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      if (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) != 0)
      {
        y.f("hmsSdk", "not have read phone permission!");
        return true;
      }
    }
    else if (paramContext.checkSelfPermission(paramString) != 0)
    {
      y.f("hmsSdk", "not have read phone permission!");
      return true;
    }
    return false;
  }
  
  @SuppressLint({"DefaultLocale"})
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(g0.c(paramContext, paramString));
    localStringBuilder.append(".xml");
    paramString = localStringBuilder.toString();
    paramContext = paramContext.getFilesDir();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("../shared_prefs/");
    localStringBuilder.append(paramString);
    long l = new File(paramContext, localStringBuilder.toString()).length();
    if (l > paramInt)
    {
      y.c("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt) }));
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return paramLong1 - l > paramLong2;
    }
    catch (NumberFormatException paramString)
    {
      label28:
      break label28;
    }
    y.f("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.p0
 * JD-Core Version:    0.7.0.1
 */