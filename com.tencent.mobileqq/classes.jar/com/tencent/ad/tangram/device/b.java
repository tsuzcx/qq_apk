package com.tencent.ad.tangram.device;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;

public final class b
{
  private static final String TAG = "AdDevice";
  private static String androidId;
  private static String deviceId;
  
  public static String getAndroidId(Context paramContext)
  {
    if (!TextUtils.isEmpty(androidId)) {
      return androidId;
    }
    try
    {
      paramContext = Settings.System.getString(paramContext.getApplicationContext().getContentResolver(), "android_id");
      if (!TextUtils.isEmpty(paramContext)) {
        androidId = paramContext;
      }
      return androidId;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        AdLog.e("AdDevice", "getAndroidId", paramContext);
      }
    }
  }
  
  public static String getAndroidIdCache(Context paramContext)
  {
    return androidId;
  }
  
  public static String getDeviceId(Context paramContext)
  {
    if (!TextUtils.isEmpty(deviceId)) {
      return deviceId;
    }
    if (Build.VERSION.SDK_INT >= 29) {}
    for (;;)
    {
      return deviceId;
      if (paramContext != null)
      {
        paramContext = paramContext.getApplicationContext();
        if (paramContext != null) {
          try
          {
            paramContext = paramContext.getSystemService("phone");
            if ((paramContext instanceof TelephonyManager))
            {
              paramContext = (TelephonyManager)TelephonyManager.class.cast(paramContext);
              if (paramContext != null)
              {
                paramContext = paramContext.getDeviceId();
                if (!TextUtils.isEmpty(paramContext)) {
                  deviceId = paramContext;
                }
              }
            }
          }
          catch (Throwable paramContext)
          {
            AdLog.i("AdDevice", "getDeviceId", paramContext);
          }
        }
      }
    }
  }
  
  public static String getDeviceIdCache(Context paramContext)
  {
    return deviceId;
  }
  
  public static int getPhoneType(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return 0;
      paramContext = paramContext.getApplicationContext();
      if (paramContext != null) {
        try
        {
          paramContext = paramContext.getSystemService("phone");
          if ((paramContext instanceof TelephonyManager))
          {
            paramContext = (TelephonyManager)TelephonyManager.class.cast(paramContext);
            if (paramContext != null)
            {
              int i = paramContext.getPhoneType();
              return i;
            }
          }
        }
        catch (Throwable paramContext)
        {
          AdLog.e("AdDevice", "getPhoneType", paramContext);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.device.b
 * JD-Core Version:    0.7.0.1
 */