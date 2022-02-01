package com.google.zxing.client.android.wifi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.BitSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BizWifiConfigManager
{
  private static final Pattern d = Pattern.compile("[0-9A-Fa-f]+");
  protected final String a = "WEP";
  protected final String b = "WPA";
  protected final String c = "nopass";
  private final WifiManager e;
  
  public BizWifiConfigManager(WifiManager paramWifiManager)
  {
    this.e = paramWifiManager;
  }
  
  static Integer a(WifiManager paramWifiManager, String paramString)
  {
    paramWifiManager = paramWifiManager.getConfiguredNetworks();
    if (paramWifiManager == null) {
      return null;
    }
    paramWifiManager = paramWifiManager.iterator();
    while (paramWifiManager.hasNext())
    {
      WifiConfiguration localWifiConfiguration = (WifiConfiguration)paramWifiManager.next();
      if (localWifiConfiguration.SSID.equals(paramString)) {
        return Integer.valueOf(localWifiConfiguration.networkId);
      }
    }
    return null;
  }
  
  public static String a(Context paramContext)
  {
    Object localObject = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getAllNetworkInfo();
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          if ((localObject[i].getTypeName().equals("WIFI")) && (localObject[i].isAvailable()) && (localObject[i].isConnected())) {
            return NetworkMonitor.getConnectionInfo((WifiManager)paramContext.getSystemService("wifi")).getSSID();
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((paramString.charAt(0) == '"') && (paramString.charAt(paramString.length() - 1) == '"')) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('"');
    localStringBuilder.append(paramString);
    localStringBuilder.append('"');
    return localStringBuilder.toString();
  }
  
  static String a(String paramString, int... paramVarArgs)
  {
    if (a(paramString, paramVarArgs)) {
      return paramString;
    }
    return a(paramString);
  }
  
  static boolean a(WifiManager paramWifiManager, WifiConfiguration paramWifiConfiguration)
  {
    Object localObject = a(paramWifiManager, paramWifiConfiguration.SSID);
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Removing old configuration for network ");
        localStringBuilder.append(paramWifiConfiguration.SSID);
        QLog.d("BizWifiConfigManager", 2, localStringBuilder.toString());
      }
      paramWifiManager.removeNetwork(((Integer)localObject).intValue());
      if (!paramWifiManager.saveConfiguration()) {
        return false;
      }
    }
    int i = paramWifiManager.addNetwork(paramWifiConfiguration);
    if (i >= 0)
    {
      if (paramWifiManager.enableNetwork(i, true))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Associating to network ");
          ((StringBuilder)localObject).append(paramWifiConfiguration.SSID);
          QLog.d("BizWifiConfigManager", 2, ((StringBuilder)localObject).toString());
        }
        if (paramWifiManager.saveConfiguration()) {
          return true;
        }
      }
      else if (QLog.isColorLevel())
      {
        paramWifiManager = new StringBuilder();
        paramWifiManager.append("Failed to enable network ");
        paramWifiManager.append(paramWifiConfiguration.SSID);
        QLog.d("BizWifiConfigManager", 2, paramWifiManager.toString());
        return false;
      }
    }
    else if (QLog.isColorLevel())
    {
      paramWifiManager = new StringBuilder();
      paramWifiManager.append("Unable to add network ");
      paramWifiManager.append(paramWifiConfiguration.SSID);
      QLog.d("BizWifiConfigManager", 2, paramWifiManager.toString());
    }
    return false;
  }
  
  static boolean a(WifiManager paramWifiManager, WifiParsedResult paramWifiParsedResult)
  {
    WifiConfiguration localWifiConfiguration = b(paramWifiParsedResult);
    localWifiConfiguration.wepKeys[0] = a(paramWifiParsedResult.d(), new int[] { 10, 26, 58 });
    localWifiConfiguration.wepTxKeyIndex = 0;
    localWifiConfiguration.allowedAuthAlgorithms.set(1);
    localWifiConfiguration.allowedKeyManagement.set(0);
    localWifiConfiguration.allowedGroupCiphers.set(2);
    localWifiConfiguration.allowedGroupCiphers.set(3);
    localWifiConfiguration.allowedGroupCiphers.set(0);
    localWifiConfiguration.allowedGroupCiphers.set(1);
    return a(paramWifiManager, localWifiConfiguration);
  }
  
  static boolean a(CharSequence paramCharSequence, int... paramVarArgs)
  {
    if (paramCharSequence != null)
    {
      if (!d.matcher(paramCharSequence).matches()) {
        return false;
      }
      if (paramVarArgs.length == 0) {
        return true;
      }
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        if (paramCharSequence.length() == k) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  static WifiConfiguration b(WifiParsedResult paramWifiParsedResult)
  {
    WifiConfiguration localWifiConfiguration = new WifiConfiguration();
    localWifiConfiguration.allowedAuthAlgorithms.clear();
    localWifiConfiguration.allowedGroupCiphers.clear();
    localWifiConfiguration.allowedKeyManagement.clear();
    localWifiConfiguration.allowedPairwiseCiphers.clear();
    localWifiConfiguration.allowedProtocols.clear();
    localWifiConfiguration.SSID = a(paramWifiParsedResult.b(), new int[0]);
    localWifiConfiguration.hiddenSSID = paramWifiParsedResult.e();
    return localWifiConfiguration;
  }
  
  static boolean b(WifiManager paramWifiManager, WifiParsedResult paramWifiParsedResult)
  {
    WifiConfiguration localWifiConfiguration = b(paramWifiParsedResult);
    localWifiConfiguration.preSharedKey = a(paramWifiParsedResult.d(), new int[] { 64 });
    localWifiConfiguration.allowedAuthAlgorithms.set(0);
    localWifiConfiguration.allowedProtocols.set(0);
    localWifiConfiguration.allowedProtocols.set(1);
    localWifiConfiguration.allowedKeyManagement.set(1);
    localWifiConfiguration.allowedKeyManagement.set(2);
    localWifiConfiguration.allowedPairwiseCiphers.set(1);
    localWifiConfiguration.allowedPairwiseCiphers.set(2);
    localWifiConfiguration.allowedGroupCiphers.set(2);
    localWifiConfiguration.allowedGroupCiphers.set(3);
    return a(paramWifiManager, localWifiConfiguration);
  }
  
  static boolean c(WifiManager paramWifiManager, WifiParsedResult paramWifiParsedResult)
  {
    paramWifiParsedResult = b(paramWifiParsedResult);
    paramWifiParsedResult.allowedKeyManagement.set(0);
    return a(paramWifiManager, paramWifiParsedResult);
  }
  
  public boolean a(WifiParsedResult paramWifiParsedResult)
  {
    int i;
    if (!this.e.isWifiEnabled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("BizWifiConfigManager", 2, "Enabling wi-fi...");
      }
      if (this.e.setWifiEnabled(true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BizWifiConfigManager", 2, "Wi-fi enabled");
        }
        i = 0;
      }
    }
    for (;;)
    {
      if (!this.e.isWifiEnabled()) {
        if (i >= 10)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BizWifiConfigManager", 2, "Took too long to enable wi-fi, quitting");
          }
          return false;
        }
      }
      try
      {
        Thread.sleep(1000L);
        label92:
        i += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("BizWifiConfigManager", 2, "Wi-fi could not be enabled!");
        }
        return false;
        String str = paramWifiParsedResult.c();
        if ((!TextUtils.isEmpty(str)) && (!str.equals("nopass")))
        {
          if (!TextUtils.isEmpty(paramWifiParsedResult.d()))
          {
            if ("WEP".equals(str)) {
              return a(this.e, paramWifiParsedResult);
            }
            if ("WPA".equals(str)) {
              return b(this.e, paramWifiParsedResult);
            }
          }
          return false;
        }
        return c(this.e, paramWifiParsedResult);
      }
      catch (InterruptedException localInterruptedException)
      {
        break label92;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.zxing.client.android.wifi.BizWifiConfigManager
 * JD-Core Version:    0.7.0.1
 */