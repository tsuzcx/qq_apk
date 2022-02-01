package com.tencent.featuretoggle.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.featuretoggle.SpManager;
import com.tencent.featuretoggle.ToggleSetting;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceUtils
{
  private static volatile String jdField_a_of_type_JavaLangString = "";
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^([0-9A-F]{2}:){5}([0-9A-F]{2})$");
  
  public static int a()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    catch (Throwable localThrowable)
    {
      if (!LogUtils.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1;
  }
  
  public static String a()
  {
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      return jdField_a_of_type_JavaLangString;
    }
    jdField_a_of_type_JavaLangString = SpManager.a().a();
    if ((TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (ToggleSetting.a() != null))
    {
      jdField_a_of_type_JavaLangString = d(ToggleSetting.a());
      SpManager.a().a(jdField_a_of_type_JavaLangString);
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(Context paramContext)
  {
    Object localObject = "fail";
    if (paramContext == null) {
      return "fail";
    }
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (paramContext == null) {
        return "null";
      }
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!LogUtils.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return localObject;
  }
  
  public static String b()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (!LogUtils.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String b(Context paramContext)
  {
    StringBuilder localStringBuilder = null;
    Object localObject4 = null;
    Iterator localIterator = null;
    Object localObject2 = null;
    Object localObject1 = localObject4;
    try
    {
      boolean bool = AppUtils.a(paramContext, "android.permission.ACCESS_WIFI_STATE");
      if (!bool) {
        return "02:00:00:00:00:00";
      }
      localObject1 = localObject4;
      bool = Utils.a(23);
      if (bool)
      {
        paramContext = localStringBuilder;
        try
        {
          localObject1 = NetworkInterface.getNetworkInterfaces();
          if (localObject1 == null) {
            return "02:00:00:00:00:00";
          }
          paramContext = localStringBuilder;
          localObject1 = Collections.list((Enumeration)localObject1);
          if (localObject1 != null)
          {
            paramContext = localStringBuilder;
            if (((List)localObject1).isEmpty()) {
              return "02:00:00:00:00:00";
            }
            paramContext = localStringBuilder;
            localIterator = ((List)localObject1).iterator();
            localObject1 = localObject2;
            for (;;)
            {
              paramContext = (Context)localObject1;
              localObject2 = localObject1;
              if (!localIterator.hasNext()) {
                break;
              }
              paramContext = (Context)localObject1;
              localObject2 = (NetworkInterface)localIterator.next();
              paramContext = (Context)localObject1;
              if (((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"))
              {
                paramContext = (Context)localObject1;
                localObject2 = ((NetworkInterface)localObject2).getHardwareAddress();
                if (localObject2 == null) {
                  return "";
                }
                paramContext = (Context)localObject1;
                localStringBuilder = new StringBuilder();
                paramContext = (Context)localObject1;
                int j = localObject2.length;
                int i = 0;
                while (i < j)
                {
                  paramContext = (Context)localObject1;
                  localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(localObject2[i]) }));
                  i += 1;
                }
                paramContext = (Context)localObject1;
                if (localStringBuilder.length() > 0)
                {
                  paramContext = (Context)localObject1;
                  localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
                }
                paramContext = (Context)localObject1;
                localObject1 = localStringBuilder.toString().toUpperCase().trim();
              }
            }
          }
          return "02:00:00:00:00:00";
        }
        catch (Throwable localThrowable2)
        {
          localObject2 = paramContext;
          localObject1 = paramContext;
          if (!LogUtils.a(localThrowable2))
          {
            localObject1 = paramContext;
            localThrowable2.printStackTrace();
            localObject2 = paramContext;
          }
          localObject1 = localObject2;
          if (Utils.a((String)localObject2)) {
            break label489;
          }
        }
        return localObject2;
      }
      localObject1 = localObject4;
      paramContext = (WifiManager)AppUtils.a(paramContext).getSystemService("wifi");
      localObject2 = localThrowable2;
      if (paramContext == null) {
        break label486;
      }
      localObject1 = localObject4;
      localObject2 = localThrowable2;
      if (!paramContext.isWifiEnabled()) {
        break label486;
      }
      localObject1 = localObject4;
      paramContext = paramContext.getConnectionInfo();
      if (paramContext != null) {
        return null;
      }
      localObject1 = localObject4;
      localObject2 = paramContext.getMacAddress();
      if (localObject2 == null) {
        return localObject2;
      }
      paramContext = (Context)localObject2;
      try
      {
        localObject1 = ((String)localObject2).toUpperCase().trim();
        paramContext = (Context)localObject1;
        localObject2 = localThrowable2;
        if ("00:00:00:00:00:00".equals(localObject1)) {
          break label486;
        }
        paramContext = (Context)localObject1;
        bool = jdField_a_of_type_JavaUtilRegexPattern.matcher((CharSequence)localObject1).matches();
        if (!bool) {
          return null;
        }
        return localObject1;
      }
      catch (Throwable localThrowable1)
      {
        localObject1 = paramContext;
        paramContext = localThrowable1;
      }
      localObject3 = localObject1;
    }
    catch (Throwable paramContext) {}
    Object localObject3;
    if (!LogUtils.a(paramContext))
    {
      paramContext.printStackTrace();
      localObject3 = localObject1;
    }
    label486:
    return localObject3;
    label489:
    return "02:00:00:00:00:00";
  }
  
  public static String c()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (!LogUtils.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  @SuppressLint({"MissingPermission"})
  public static String c(Context paramContext)
  {
    if (paramContext != null)
    {
      if (!AppUtils.a(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
        return "unknown";
      }
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo == null) {
          return null;
        }
        if (localNetworkInfo.getType() == 1)
        {
          paramContext = "WIFI";
        }
        else if (localNetworkInfo.getType() == 0)
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null)
          {
            int i = paramContext.getNetworkType();
            switch (i)
            {
            default: 
              paramContext = new StringBuilder();
              paramContext.append("MOBILE(");
              paramContext.append(i);
              paramContext.append(")");
              paramContext = paramContext.toString();
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        if (!LogUtils.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
    }
    else
    {
      return "unknown";
    }
    for (;;)
    {
      return paramContext;
      break;
      paramContext = "HSPA+";
      continue;
      paramContext = "eHRPD";
      continue;
      paramContext = "LTE";
      continue;
      paramContext = "EVDO_B";
      continue;
      paramContext = "iDen";
      continue;
      paramContext = "HSPA";
      continue;
      paramContext = "HSUPA";
      continue;
      paramContext = "HSDPA";
      continue;
      paramContext = "1xRTT";
      continue;
      paramContext = "EVDO_A";
      continue;
      paramContext = "EVDO_0";
      continue;
      paramContext = "CDMA";
      continue;
      paramContext = "UMTS";
      continue;
      paramContext = "EDGE";
      continue;
      paramContext = "GPRS";
    }
  }
  
  public static String d()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (!LogUtils.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  private static String d(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b(paramContext));
    localStringBuilder.append('-');
    localStringBuilder.append(a(paramContext));
    localStringBuilder.append('-');
    localStringBuilder.append(c());
    localStringBuilder.append('-');
    localStringBuilder.append(b());
    paramContext = new StringBuilder();
    paramContext.append("T");
    paramContext.append(Utils.a(localStringBuilder.toString()));
    return paramContext.toString();
  }
  
  public static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Android ");
    localStringBuilder.append(d());
    localStringBuilder.append(",level ");
    localStringBuilder.append(a());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.DeviceUtils
 * JD-Core Version:    0.7.0.1
 */