package com.tencent.biz.pubaccount.weishi_new.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class WSDeviceUtils
{
  public static int a()
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = a(BaseApplicationImpl.getContext());
    if ((localObject == null) || (TextUtils.isEmpty((CharSequence)localObject))) {
      return 0;
    }
    localObject = ((String)localObject).split("\\.");
    int j = localObject.length;
    if (i < j)
    {
      int k = Integer.parseInt(localObject[i]);
      if (k < 10) {
        localStringBuilder.append("0").append(k);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(k);
      }
    }
    return Integer.parseInt(localStringBuilder.toString());
  }
  
  public static int a(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return -1;
  }
  
  public static String a()
  {
    try
    {
      if (NetworkInterface.getNetworkInterfaces() == null) {
        return "";
      }
      Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
      for (;;)
      {
        if (!localEnumeration.hasMoreElements()) {
          return "";
        }
        Object localObject1 = (NetworkInterface)localEnumeration.nextElement();
        if (localObject1 != null)
        {
          localObject1 = ((NetworkInterface)localObject1).getInetAddresses();
          while (((Enumeration)localObject1).hasMoreElements())
          {
            Object localObject2 = (InetAddress)((Enumeration)localObject1).nextElement();
            try
            {
              if ((!((InetAddress)localObject2).isLoopbackAddress()) && ((localObject2 instanceof Inet4Address)) && (Inet4Address.getByName(((InetAddress)localObject2).getHostAddress()) != null) && (!((InetAddress)localObject2).getHostAddress().equals("null")) && (((InetAddress)localObject2).getHostAddress() != null))
              {
                localObject2 = ((InetAddress)localObject2).getHostAddress().trim();
                return localObject2;
              }
            }
            catch (UnknownHostException localUnknownHostException)
            {
              localUnknownHostException.printStackTrace();
            }
          }
        }
      }
      return "";
    }
    catch (SocketException localSocketException)
    {
      LogUtils.e(localSocketException);
    }
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static boolean a()
  {
    return TextUtils.equals("Wi-Fi", g());
  }
  
  public static int b()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Runtime.getRuntime().availableProcessors();
    }
    return c();
  }
  
  public static String b()
  {
    return DeviceInstance.getInstance().getDeviceName();
  }
  
  public static int c()
  {
    return DeviceInfoUtil.c();
  }
  
  public static String c()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String d()
  {
    String str = "" + Build.MODEL;
    str = str + "&";
    str = str + Build.VERSION.RELEASE;
    str = str + "&";
    str = str + Build.VERSION.SDK_INT;
    str = str + "&";
    return str + b();
  }
  
  public static String e()
  {
    return ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getDeviceInfor();
  }
  
  public static String f()
  {
    try
    {
      Object localObject = (WifiManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("wifi");
      if (localObject != null)
      {
        localObject = ((WifiManager)localObject).getConnectionInfo();
        if (localObject != null)
        {
          localObject = ((WifiInfo)localObject).getBSSID();
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      WSLog.d("WSDeviceUtils", "getWifiBssid : " + localException.toString());
    }
    return "";
  }
  
  public static String g()
  {
    String str = "unknown";
    if (AppNetConnInfo.isWifiConn()) {
      str = "Wi-Fi";
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return str;
    }
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return "unknown";
    case 1: 
      return "2G";
    case 2: 
      return "3G";
    case 3: 
      return "4G";
    }
    return "5G";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSDeviceUtils
 * JD-Core Version:    0.7.0.1
 */