package com.tencent.biz.pubaccount.weishi_new.util;

import android.app.Activity;
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
import com.tencent.widget.immersive.ImmersiveUtils;
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
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = a(BaseApplicationImpl.getContext());
    int i = 0;
    if (localObject != null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return 0;
      }
      localObject = ((String)localObject).split("\\.");
      int j = localObject.length;
      while (i < j)
      {
        int k = Integer.parseInt(localObject[i]);
        if (k < 10)
        {
          localStringBuilder.append("0");
          localStringBuilder.append(k);
        }
        else
        {
          localStringBuilder.append(k);
        }
        i += 1;
      }
      return Integer.parseInt(localStringBuilder.toString());
    }
    return 0;
  }
  
  public static int a(Activity paramActivity)
  {
    return ImmersiveUtils.getStatusBarHeight(paramActivity);
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append(".");
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
  
  public static int b(Context paramContext)
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
  
  public static String b()
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
  
  public static String c()
  {
    return DeviceInstance.getInstance().getDeviceName();
  }
  
  public static String d()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static int e()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Runtime.getRuntime().availableProcessors();
    }
    return f();
  }
  
  public static int f()
  {
    return DeviceInfoUtil.i();
  }
  
  public static String g()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(Build.VERSION.RELEASE);
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(e());
    return localStringBuilder.toString();
  }
  
  public static String h()
  {
    return ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getDeviceInfor();
  }
  
  public static boolean i()
  {
    return TextUtils.equals("Wi-Fi", k());
  }
  
  public static String j()
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWifiBssid : ");
      localStringBuilder.append(localException.toString());
      WSLog.d("WSDeviceUtils", localStringBuilder.toString());
    }
    return "";
  }
  
  public static String k()
  {
    boolean bool = AppNetConnInfo.isWifiConn();
    String str = "unknown";
    if (bool) {
      return "Wi-Fi";
    }
    if (AppNetConnInfo.isMobileConn())
    {
      int i = AppNetConnInfo.getMobileInfo();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return "unknown";
            }
            return "5G";
          }
          return "4G";
        }
        return "3G";
      }
      str = "2G";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSDeviceUtils
 * JD-Core Version:    0.7.0.1
 */