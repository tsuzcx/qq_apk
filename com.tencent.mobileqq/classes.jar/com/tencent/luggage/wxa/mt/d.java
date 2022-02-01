package com.tencent.luggage.wxa.mt;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.util.BitSet;

public class d
{
  public static int a = -1;
  
  public static int a(ScanResult paramScanResult)
  {
    if ((paramScanResult != null) && (paramScanResult.capabilities != null))
    {
      if (paramScanResult.capabilities.contains("WEP")) {
        return 1;
      }
      if (paramScanResult.capabilities.contains("PSK")) {
        return 2;
      }
      if (paramScanResult.capabilities.contains("EAP")) {
        return 3;
      }
      return 0;
    }
    return -1;
  }
  
  public static int a(WifiConfiguration paramWifiConfiguration)
  {
    if (paramWifiConfiguration.allowedKeyManagement.get(1)) {
      return 2;
    }
    if (!paramWifiConfiguration.allowedKeyManagement.get(2))
    {
      if (paramWifiConfiguration.allowedKeyManagement.get(3)) {
        return 3;
      }
      paramWifiConfiguration = paramWifiConfiguration.wepKeys;
      int i = 0;
      if (paramWifiConfiguration[0] != null) {
        i = 1;
      }
      return i;
    }
    return 3;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.length();
    String str = paramString;
    if (i > 1)
    {
      str = paramString;
      if (paramString.charAt(0) == '"')
      {
        i -= 1;
        str = paramString;
        if (paramString.charAt(i) == '"') {
          str = paramString.substring(1, i);
        }
      }
    }
    return str;
  }
  
  public static int b(@Nullable String paramString)
  {
    WifiInfo localWifiInfo = NetworkMonitor.getConnectionInfo((WifiManager)r.a().getSystemService("wifi"));
    if ((localWifiInfo != null) && (localWifiInfo.getBSSID() != null) && (localWifiInfo.getBSSID().equals(paramString))) {
      return c.a(localWifiInfo.getRssi(), 100);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mt.d
 * JD-Core Version:    0.7.0.1
 */