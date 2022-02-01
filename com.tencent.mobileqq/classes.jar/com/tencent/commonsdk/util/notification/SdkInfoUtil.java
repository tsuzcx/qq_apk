package com.tencent.commonsdk.util.notification;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;

public class SdkInfoUtil
{
  public static final int Q_VERSION_CODE = 29;
  
  public static boolean isAndroidQ()
  {
    return Build.VERSION.SDK_INT >= 29;
  }
  
  public static boolean isOreo()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  public static boolean isTargetSDKOreo()
  {
    return BaseApplication.getContext().getApplicationContext().getApplicationInfo().targetSdkVersion >= 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.util.notification.SdkInfoUtil
 * JD-Core Version:    0.7.0.1
 */