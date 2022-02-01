package com.tencent.luggage.wxa.mt;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.util.List;

public final class c
{
  private static WifiManager a;
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= -100) {
      return 0;
    }
    if (paramInt1 >= -55) {
      return paramInt2 - 1;
    }
    float f = paramInt2 - 1;
    return (int)((paramInt1 + 100) * f / 45.0F);
  }
  
  public static int a(WifiConfiguration paramWifiConfiguration)
  {
    try
    {
      int i = a.addNetwork(paramWifiConfiguration);
      return i;
    }
    catch (Throwable paramWifiConfiguration)
    {
      Log.e("MicroMsg.WifiManagerInternalWrapper", paramWifiConfiguration.toString());
    }
    return d.a;
  }
  
  public static WifiManager a()
  {
    return a;
  }
  
  public static void a(WifiManager paramWifiManager)
  {
    a = paramWifiManager;
  }
  
  public static boolean a(int paramInt)
  {
    try
    {
      boolean bool = a.removeNetwork(paramInt);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.WifiManagerInternalWrapper", localThrowable.toString());
    }
    return false;
  }
  
  public static boolean a(int paramInt, boolean paramBoolean)
  {
    try
    {
      paramBoolean = a.enableNetwork(paramInt, paramBoolean);
      return paramBoolean;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.WifiManagerInternalWrapper", localThrowable.toString());
    }
    return false;
  }
  
  public static List<WifiConfiguration> b()
  {
    try
    {
      List localList = a.getConfiguredNetworks();
      return localList;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.WifiManagerInternalWrapper", localThrowable.toString());
    }
    return null;
  }
  
  public static boolean b(int paramInt)
  {
    try
    {
      boolean bool = a.disableNetwork(paramInt);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.WifiManagerInternalWrapper", localThrowable.toString());
    }
    return false;
  }
  
  public static boolean c()
  {
    try
    {
      boolean bool = a.startScan();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.WifiManagerInternalWrapper", localThrowable.toString());
    }
    return false;
  }
  
  public static WifiInfo d()
  {
    try
    {
      WifiInfo localWifiInfo = NetworkMonitor.getConnectionInfo(a);
      return localWifiInfo;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.WifiManagerInternalWrapper", localThrowable.toString());
    }
    return null;
  }
  
  public static List<ScanResult> e()
  {
    try
    {
      List localList = a.getScanResults();
      return localList;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.WifiManagerInternalWrapper", localThrowable.toString());
    }
    return null;
  }
  
  public static boolean f()
  {
    try
    {
      boolean bool = a.saveConfiguration();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.WifiManagerInternalWrapper", localThrowable.toString());
    }
    return false;
  }
  
  public static boolean g()
  {
    try
    {
      boolean bool = a.isWifiEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.WifiManagerInternalWrapper", localThrowable.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mt.c
 * JD-Core Version:    0.7.0.1
 */