package com.huawei.hms.framework.common;

import android.content.ContentResolver;
import android.provider.Settings.Secure;
import android.provider.Settings.System;

public class SettingUtil
{
  private static final String TAG = "SettingUtil";
  
  public static int getSecureInt(ContentResolver paramContentResolver, String paramString, int paramInt)
  {
    try
    {
      int i = Settings.Secure.getInt(paramContentResolver, paramString, paramInt);
      return i;
    }
    catch (RuntimeException paramContentResolver)
    {
      Logger.e("SettingUtil", "Settings Secure getInt throwFromSystemServer:", paramContentResolver);
    }
    return paramInt;
  }
  
  public static int getSystemInt(ContentResolver paramContentResolver, String paramString, int paramInt)
  {
    try
    {
      int i = Settings.System.getInt(paramContentResolver, paramString, paramInt);
      return i;
    }
    catch (RuntimeException paramContentResolver)
    {
      Logger.e("SettingUtil", "Settings System getInt throwFromSystemServer:", paramContentResolver);
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.SettingUtil
 * JD-Core Version:    0.7.0.1
 */