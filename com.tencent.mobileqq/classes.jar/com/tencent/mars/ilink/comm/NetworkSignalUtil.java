package com.tencent.mars.ilink.comm;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;

public class NetworkSignalUtil
{
  public static final String TAG = "MicroMsg.NetworkSignalUtil";
  private static Context context;
  private static long strength = 10000L;
  
  public static void InitNetworkSignalUtil(Context paramContext)
  {
    context = paramContext;
    paramContext = (TelephonyManager)context.getSystemService("phone");
    try
    {
      paramContext.listen(new NetworkSignalUtil.1(), 256);
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramContext) {}
  }
  
  private static void calSignalStrength(SignalStrength paramSignalStrength)
  {
    int i;
    if (paramSignalStrength.isGsm()) {
      i = paramSignalStrength.getGsmSignalStrength();
    } else {
      i = (paramSignalStrength.getCdmaDbm() + 113) / 2;
    }
    boolean bool = paramSignalStrength.isGsm();
    long l2 = 0L;
    if ((bool) && (i == 99))
    {
      strength = 0L;
      return;
    }
    strength = (i * 3.225807F);
    long l3 = strength;
    long l1 = l3;
    if (l3 > 100L) {
      l1 = 100L;
    }
    strength = l1;
    l1 = strength;
    if (l1 < 0L) {
      l1 = l2;
    }
    strength = l1;
  }
  
  public static long getGSMSignalStrength()
  {
    return strength;
  }
  
  public static long getNetworkSignalStrength(boolean paramBoolean)
  {
    return 0L;
  }
  
  public static long getWifiSignalStrength()
  {
    WifiInfo localWifiInfo = NetworkMonitor.getConnectionInfo((WifiManager)context.getSystemService("wifi"));
    if ((localWifiInfo != null) && (localWifiInfo.getBSSID() != null))
    {
      int j = WifiManager.calculateSignalLevel(localWifiInfo.getRssi(), 10);
      int i = j;
      if (j > 10) {
        i = 10;
      }
      j = i;
      if (i < 0) {
        j = 0;
      }
      return j * 10;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.ilink.comm.NetworkSignalUtil
 * JD-Core Version:    0.7.0.1
 */