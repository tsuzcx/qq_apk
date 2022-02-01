package com.tencent.ad.tangram.device;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static final String TAG = "AdDevice";
  private static String androidId;
  private static String deviceId;
  private static Map<Integer, String> deviceIdList = new ConcurrentHashMap();
  private static String imei;
  private static Map<Integer, String> imeiList = new ConcurrentHashMap();
  private static String meid;
  private static Map<Integer, String> meidList = new ConcurrentHashMap();
  
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
  
  public static String getDeviceId(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty((CharSequence)deviceIdList.get(Integer.valueOf(paramInt)))) {
      return (String)deviceIdList.get(Integer.valueOf(paramInt));
    }
    if ((paramBoolean) && (!e.checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))) {}
    for (;;)
    {
      return (String)deviceIdList.get(Integer.valueOf(paramInt));
      if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 23) && (paramContext != null))
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
                paramContext = paramContext.getDeviceId(paramInt);
                if (!TextUtils.isEmpty(paramContext)) {
                  deviceIdList.put(Integer.valueOf(paramInt), paramContext);
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
  
  public static String getDeviceId(Context paramContext, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(deviceId)) {
      return deviceId;
    }
    if ((paramBoolean) && (!e.checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))) {}
    for (;;)
    {
      return deviceId;
      if ((Build.VERSION.SDK_INT < 29) && (paramContext != null))
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
  
  public static String getDeviceIdCache(Context paramContext, int paramInt)
  {
    return (String)deviceIdList.get(Integer.valueOf(paramInt));
  }
  
  public static String getImei(Context paramContext)
  {
    return imei;
  }
  
  public static String getImei(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty((CharSequence)imeiList.get(Integer.valueOf(paramInt)))) {
      return (String)imeiList.get(Integer.valueOf(paramInt));
    }
    if ((paramBoolean) && (!e.checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))) {}
    for (;;)
    {
      return (String)imeiList.get(Integer.valueOf(paramInt));
      if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26) && (paramContext != null))
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
                paramContext = paramContext.getImei(paramInt);
                if (!TextUtils.isEmpty(paramContext)) {
                  imeiList.put(Integer.valueOf(paramInt), paramContext);
                }
              }
            }
          }
          catch (Throwable paramContext)
          {
            AdLog.i("AdDevice", "getImei", paramContext);
          }
        }
      }
    }
  }
  
  public static String getImei(Context paramContext, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(imei)) {
      return imei;
    }
    if ((paramBoolean) && (!e.checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))) {}
    for (;;)
    {
      return imei;
      if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26) && (paramContext != null))
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
                paramContext = paramContext.getImei();
                if (!TextUtils.isEmpty(paramContext)) {
                  imei = paramContext;
                }
              }
            }
          }
          catch (Throwable paramContext)
          {
            AdLog.i("AdDevice", "getImei", paramContext);
          }
        }
      }
    }
  }
  
  public static String getImeiCache(Context paramContext, int paramInt)
  {
    return (String)imeiList.get(Integer.valueOf(paramInt));
  }
  
  public static String getMeid(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty((CharSequence)meidList.get(Integer.valueOf(paramInt)))) {
      return (String)meidList.get(Integer.valueOf(paramInt));
    }
    if ((paramBoolean) && (!e.checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))) {}
    for (;;)
    {
      return (String)meidList.get(Integer.valueOf(paramInt));
      if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26) && (paramContext != null))
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
                paramContext = paramContext.getMeid(paramInt);
                if (!TextUtils.isEmpty(paramContext)) {
                  meidList.put(Integer.valueOf(paramInt), paramContext);
                }
              }
            }
          }
          catch (Throwable paramContext)
          {
            AdLog.i("AdDevice", "getMeid", paramContext);
          }
        }
      }
    }
  }
  
  public static String getMeid(Context paramContext, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(meid)) {
      return meid;
    }
    if ((paramBoolean) && (!e.checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))) {}
    for (;;)
    {
      return meid;
      if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26) && (paramContext != null))
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
                paramContext = paramContext.getMeid();
                if (!TextUtils.isEmpty(paramContext)) {
                  meid = paramContext;
                }
              }
            }
          }
          catch (Throwable paramContext)
          {
            AdLog.i("AdDevice", "getMeid", paramContext);
          }
        }
      }
    }
  }
  
  public static String getMeidCache(Context paramContext)
  {
    return meid;
  }
  
  public static String getMeidCache(Context paramContext, int paramInt)
  {
    return (String)meidList.get(Integer.valueOf(paramInt));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.c
 * JD-Core Version:    0.7.0.1
 */