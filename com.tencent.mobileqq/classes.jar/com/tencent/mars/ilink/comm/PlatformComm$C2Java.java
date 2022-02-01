package com.tencent.mars.ilink.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PlatformComm$C2Java
{
  private static String exception2String(Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static PlatformComm.APNInfo getAPNInfo()
  {
    try
    {
      Object localObject = ((ConnectivityManager)PlatformComm.context.getSystemService("connectivity")).getActiveNetworkInfo();
      PlatformComm.APNInfo localAPNInfo = new PlatformComm.APNInfo();
      if (localObject != null)
      {
        localAPNInfo.netType = ((NetworkInfo)localObject).getType();
        localAPNInfo.subNetType = ((NetworkInfo)localObject).getSubtype();
        if (1 != ((NetworkInfo)localObject).getType())
        {
          if (((NetworkInfo)localObject).getExtraInfo() == null) {
            localObject = "";
          } else {
            localObject = ((NetworkInfo)localObject).getExtraInfo();
          }
          localAPNInfo.extraInfo = ((String)localObject);
          return localAPNInfo;
        }
        localAPNInfo.extraInfo = getCurWifiInfo().ssid;
        return localAPNInfo;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static int getCurRadioAccessNetworkInfo()
  {
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      return 0;
    }
    try
    {
      int i = ((TelephonyManager)PlatformComm.context.getSystemService("phone")).getNetworkType();
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localException.getClass().getSimpleName());
      localStringBuilder.append(":");
      localStringBuilder.append(localException.getStackTrace()[0]);
      localStringBuilder.append(", ");
      localStringBuilder.append(localException.getStackTrace()[1]);
      PlatformComm.Assert.assertTrue(localStringBuilder.toString(), false);
    }
    return 0;
  }
  
  public static PlatformComm.SIMInfo getCurSIMInfo()
  {
    try
    {
      if (PlatformComm.context == null) {
        return null;
      }
      int i = NetStatusUtil.getISPCode(PlatformComm.context);
      if (i == 0) {
        return null;
      }
      PlatformComm.SIMInfo localSIMInfo = new PlatformComm.SIMInfo();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      localSIMInfo.ispCode = localStringBuilder.toString();
      localSIMInfo.ispName = NetStatusUtil.getISPName(PlatformComm.context);
      return localSIMInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static PlatformComm.WifiInfo getCurWifiInfo()
  {
    try
    {
      if (PlatformComm.context == null) {
        return null;
      }
      Object localObject = (ConnectivityManager)PlatformComm.context.getSystemService("connectivity");
      if (localObject == null) {
        return null;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        if (1 != ((NetworkInfo)localObject).getType()) {
          return null;
        }
        localObject = (WifiManager)PlatformComm.context.getSystemService("wifi");
        if (localObject == null) {
          return null;
        }
        localObject = NetworkMonitor.getConnectionInfo((WifiManager)localObject);
        if (localObject == null) {
          return null;
        }
        PlatformComm.WifiInfo localWifiInfo = new PlatformComm.WifiInfo();
        localWifiInfo.ssid = ((WifiInfo)localObject).getSSID();
        localWifiInfo.bssid = ((WifiInfo)localObject).getBSSID();
        return localWifiInfo;
      }
      return null;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static int getNetInfo()
  {
    Object localObject = (ConnectivityManager)PlatformComm.context.getSystemService("connectivity");
    if (localObject == null) {
      return -1;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null) {
      return -1;
    }
    try
    {
      int i = ((NetworkInfo)localObject).getType();
      if (i != 0) {
        if (i != 1)
        {
          if ((i != 2) && (i != 3) && (i != 4) && (i != 5)) {
            return 3;
          }
        }
        else {
          return 1;
        }
      }
      return 2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 3;
  }
  
  public static int getProxyInfo(StringBuffer paramStringBuffer)
  {
    return -1;
  }
  
  public static long getSignal(boolean paramBoolean)
  {
    try
    {
      if (PlatformComm.context == null)
      {
        PlatformComm.Assert.assertTrue(false);
        return 0L;
      }
      if (paramBoolean) {
        return NetworkSignalUtil.getWifiSignalStrength();
      }
      long l = NetworkSignalUtil.getGSMSignalStrength();
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public static int getStatisticsNetType()
  {
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      return 0;
    }
    try
    {
      int i = NetStatusUtil.getNetType(PlatformComm.context);
      if (i == -1) {
        return -1;
      }
      if (NetStatusUtil.is2G(PlatformComm.context)) {
        return 3;
      }
      if (NetStatusUtil.is3G(PlatformComm.context)) {
        return 4;
      }
      if (NetStatusUtil.is4G(PlatformComm.context)) {
        return 5;
      }
      if (NetStatusUtil.isWifi(i)) {
        return 1;
      }
      boolean bool = NetStatusUtil.isWap(i);
      if (bool) {
        return 2;
      }
      return 6;
    }
    catch (Exception localException)
    {
      Log.e("PlatformComm", exception2String(localException));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localException.getClass().getSimpleName());
      localStringBuilder.append(":");
      localStringBuilder.append(localException.getStackTrace()[0]);
      localStringBuilder.append(", ");
      localStringBuilder.append(localException.getStackTrace()[1]);
      PlatformComm.Assert.assertTrue(localStringBuilder.toString(), false);
    }
    return -1;
  }
  
  public static boolean isNetworkConnected()
  {
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      return false;
    }
    try
    {
      boolean bool = NetStatusUtil.isNetworkConnected(PlatformComm.context);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("PlatformComm", exception2String(localException));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localException.getClass().getSimpleName());
      localStringBuilder.append(":");
      localStringBuilder.append(localException.getStackTrace()[0]);
      localStringBuilder.append(", ");
      localStringBuilder.append(localException.getStackTrace()[1]);
      PlatformComm.Assert.assertTrue(localStringBuilder.toString(), false);
    }
    return false;
  }
  
  public static boolean startAlarm(int paramInt1, int paramInt2, int paramInt3)
  {
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      return false;
    }
    long l = paramInt2;
    try
    {
      boolean bool = Alarm.start(paramInt1, l, paramInt3, PlatformComm.context);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("PlatformComm", exception2String(localException));
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localException.getClass().getSimpleName());
      localStringBuilder.append(":");
      localStringBuilder.append(localException.getStackTrace()[0]);
      localStringBuilder.append(", ");
      localStringBuilder.append(localException.getStackTrace()[1]);
      PlatformComm.Assert.assertTrue(localStringBuilder.toString(), false);
    }
    return false;
  }
  
  public static boolean stopAlarm(int paramInt)
  {
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      return false;
    }
    long l = paramInt;
    try
    {
      boolean bool = Alarm.stop(l, PlatformComm.context);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("PlatformComm", exception2String(localException));
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localException.getClass().getSimpleName());
      localStringBuilder.append(":");
      localStringBuilder.append(localException.getStackTrace()[0]);
      localStringBuilder.append(", ");
      localStringBuilder.append(localException.getStackTrace()[1]);
      PlatformComm.Assert.assertTrue(localStringBuilder.toString(), false);
    }
    return false;
  }
  
  public static WakerLock wakeupLock_new()
  {
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      return null;
    }
    try
    {
      WakerLock localWakerLock = new WakerLock(PlatformComm.context);
      return localWakerLock;
    }
    catch (Exception localException)
    {
      Log.e("PlatformComm", exception2String(localException));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localException.getClass().getSimpleName());
      localStringBuilder.append(":");
      localStringBuilder.append(localException.getStackTrace()[0]);
      localStringBuilder.append(", ");
      localStringBuilder.append(localException.getStackTrace()[1]);
      PlatformComm.Assert.assertTrue(localStringBuilder.toString(), false);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.ilink.comm.PlatformComm.C2Java
 * JD-Core Version:    0.7.0.1
 */