package com.tencent.luggage.wxa.cg;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c
{
  private static String a = "";
  private static String b = "";
  private static Map<Integer, String> c = new ConcurrentHashMap();
  private static String d = "";
  private static Map<Integer, String> e = new ConcurrentHashMap();
  private static String f = "";
  private static Map<Integer, String> g = new ConcurrentHashMap();
  private static String h = "";
  private static String i = "";
  private static volatile String j = "";
  
  public static String a()
  {
    if (!af.c(a)) {
      return a;
    }
    try
    {
      a = com.tencent.luggage.wxa.hd.c.a();
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AdDeviceInfo.DeviceInfoUtils.getOAID: ");
      localStringBuilder.append(localThrowable.toString());
      o.b("AdDeviceInfo.DeviceInfoUtils", localStringBuilder.toString());
    }
    return a;
  }
  
  public static String a(int paramInt)
  {
    Object localObject = (String)c.get(Integer.valueOf(paramInt));
    if (!af.c((String)localObject)) {
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 23))
    {
      localObject = r.a();
      if (localObject != null) {
        try
        {
          localObject = ((Context)localObject).getSystemService("phone");
          if ((localObject instanceof TelephonyManager))
          {
            localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
            if (localObject != null)
            {
              localObject = PhoneInfoMonitor.getDeviceId((TelephonyManager)localObject, paramInt);
              if (!af.c((String)localObject)) {
                c.put(Integer.valueOf(paramInt), localObject);
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("AdDeviceInfo.DeviceInfoUtils.getDeviceId");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(": ");
          localStringBuilder.append(localThrowable.toString());
          o.b("AdDeviceInfo.DeviceInfoUtils", localStringBuilder.toString());
        }
      }
    }
    return af.b((String)c.get(Integer.valueOf(paramInt)));
  }
  
  public static String b()
  {
    if (!af.c(b)) {
      return b;
    }
    if (Build.VERSION.SDK_INT < 29)
    {
      Object localObject = r.a();
      if (localObject != null) {
        try
        {
          localObject = ((Context)localObject).getSystemService("phone");
          if ((localObject instanceof TelephonyManager))
          {
            localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
            if (localObject != null)
            {
              localObject = PhoneInfoMonitor.getDeviceId((TelephonyManager)localObject);
              if (!af.c((String)localObject)) {
                b = (String)localObject;
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("AdDeviceInfo.DeviceInfoUtils.getDeviceId: ");
          localStringBuilder.append(localThrowable.toString());
          o.b("AdDeviceInfo.DeviceInfoUtils", localStringBuilder.toString());
        }
      }
    }
    return b;
  }
  
  public static String b(int paramInt)
  {
    Object localObject = (String)e.get(Integer.valueOf(paramInt));
    if (!af.c((String)localObject)) {
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject = r.a();
      if (localObject != null) {
        try
        {
          localObject = ((Context)localObject).getSystemService("phone");
          if ((localObject instanceof TelephonyManager))
          {
            localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
            if (localObject != null)
            {
              localObject = PhoneInfoMonitor.getImei((TelephonyManager)localObject, paramInt);
              if (!af.c((String)localObject)) {
                e.put(Integer.valueOf(paramInt), localObject);
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("AdDeviceInfo.DeviceInfoUtils.getIMEI");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(": ");
          localStringBuilder.append(localThrowable.toString());
          o.b("AdDeviceInfo.DeviceInfoUtils", localStringBuilder.toString());
        }
      }
    }
    return af.b((String)e.get(Integer.valueOf(paramInt)));
  }
  
  public static String c()
  {
    if (!af.c(d)) {
      return d;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      Object localObject = r.a();
      if (localObject != null) {
        try
        {
          localObject = ((Context)localObject).getSystemService("phone");
          if ((localObject instanceof TelephonyManager))
          {
            localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
            if (localObject != null)
            {
              localObject = PhoneInfoMonitor.getImei((TelephonyManager)localObject);
              if (!af.c((String)localObject)) {
                d = (String)localObject;
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("AdDeviceInfo.DeviceInfoUtils.getIMEI: ");
          localStringBuilder.append(localThrowable.toString());
          o.b("AdDeviceInfo.DeviceInfoUtils", localStringBuilder.toString());
        }
      }
    }
    return d;
  }
  
  public static String c(int paramInt)
  {
    Object localObject = (String)g.get(Integer.valueOf(paramInt));
    if (!af.c((String)localObject)) {
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject = r.a();
      if (localObject != null) {
        try
        {
          localObject = ((Context)localObject).getSystemService("phone");
          if ((localObject instanceof TelephonyManager))
          {
            localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
            if (localObject != null)
            {
              localObject = ((TelephonyManager)localObject).getMeid(paramInt);
              if (!af.c((String)localObject)) {
                g.put(Integer.valueOf(paramInt), localObject);
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("AdDeviceInfo.DeviceInfoUtils.getMEID");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(": ");
          localStringBuilder.append(localThrowable.toString());
          o.b("AdDeviceInfo.DeviceInfoUtils", localStringBuilder.toString());
        }
      }
    }
    return af.b((String)g.get(Integer.valueOf(paramInt)));
  }
  
  public static String d()
  {
    if (!af.c(f)) {
      return f;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      Object localObject = r.a();
      if (localObject != null) {
        try
        {
          localObject = ((Context)localObject).getSystemService("phone");
          if ((localObject instanceof TelephonyManager))
          {
            localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
            if (localObject != null)
            {
              localObject = ((TelephonyManager)localObject).getMeid();
              if (!af.c((String)localObject)) {
                f = (String)localObject;
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("AdDeviceInfo.DeviceInfoUtils.getMEID: ");
          localStringBuilder.append(localThrowable.toString());
          o.b("AdDeviceInfo.DeviceInfoUtils", localStringBuilder.toString());
        }
      }
    }
    return f;
  }
  
  public static String e()
  {
    if (!af.c(h)) {
      return h;
    }
    if (Build.VERSION.SDK_INT < 29)
    {
      Object localObject = r.a();
      if (localObject != null) {
        try
        {
          localObject = ((Context)localObject).getSystemService("phone");
          if ((localObject instanceof TelephonyManager))
          {
            localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
            if (localObject != null)
            {
              localObject = PhoneInfoMonitor.getSubscriberId((TelephonyManager)localObject);
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                h = (String)localObject;
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("AdDeviceInfo.DeviceInfoUtils.getIMSI: ");
          localStringBuilder.append(localThrowable.toString());
          o.b("AdDeviceInfo.DeviceInfoUtils", localStringBuilder.toString());
        }
      }
    }
    return h;
  }
  
  public static String f()
  {
    try
    {
      String str = com.tencent.luggage.wxa.hd.c.a(false);
      return str;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AdDeviceInfo.DeviceInfoUtils.getIMEIWx: ");
      localStringBuilder.append(localThrowable.toString());
      o.b("AdDeviceInfo.DeviceInfoUtils", localStringBuilder.toString());
    }
    return "";
  }
  
  public static String g()
  {
    if (!af.c(i)) {
      return i;
    }
    try
    {
      String str = Settings.System.getString(r.a().getContentResolver(), "android_id");
      if (!af.c(str)) {
        i = str;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AdDeviceInfo.DeviceInfoUtils.getAndroidId: ");
      localStringBuilder.append(localThrowable.toString());
      o.b("AdDeviceInfo.DeviceInfoUtils", localStringBuilder.toString());
    }
    return i;
  }
  
  public static String h()
  {
    f.a.c(new c.1());
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cg.c
 * JD-Core Version:    0.7.0.1
 */