package com.tencent.luggage.wxa.mt;

import android.net.wifi.WifiConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class b
{
  public static int a(WifiConfiguration paramWifiConfiguration)
  {
    if ((paramWifiConfiguration != null) && (paramWifiConfiguration.networkId < 0))
    {
      paramWifiConfiguration.networkId = c.a(paramWifiConfiguration);
      return paramWifiConfiguration.networkId;
    }
    return -1;
  }
  
  @Nullable
  public static WifiConfiguration a(String paramString)
  {
    List localList = a();
    if (localList != null) {
      return a(paramString, localList);
    }
    return null;
  }
  
  public static WifiConfiguration a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString1.length() <= 0) {
        return null;
      }
      WifiConfiguration localWifiConfiguration = new WifiConfiguration();
      localWifiConfiguration.allowedAuthAlgorithms.clear();
      localWifiConfiguration.allowedGroupCiphers.clear();
      localWifiConfiguration.allowedKeyManagement.clear();
      localWifiConfiguration.allowedPairwiseCiphers.clear();
      localWifiConfiguration.allowedProtocols.clear();
      localWifiConfiguration.SSID = b(paramString1);
      localWifiConfiguration.hiddenSSID = true;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {}
            return null;
          }
          if (paramString2.length() != 0) {
            if (paramString2.matches("[0-9A-Fa-f]{64}"))
            {
              localWifiConfiguration.preSharedKey = paramString2;
            }
            else
            {
              paramString1 = new StringBuilder();
              paramString1.append('"');
              paramString1.append(paramString2);
              paramString1.append('"');
              localWifiConfiguration.preSharedKey = paramString1.toString();
            }
          }
        }
        else
        {
          return null;
        }
      }
      else {
        localWifiConfiguration.allowedKeyManagement.set(0);
      }
      localWifiConfiguration.status = 2;
      return localWifiConfiguration;
    }
    return null;
  }
  
  public static WifiConfiguration a(String paramString, int paramInt, List<WifiConfiguration> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)paramList.next();
        if ((d.a(localWifiConfiguration.SSID).compareTo(paramString) == 0) && (d.a(localWifiConfiguration) == paramInt)) {
          return localWifiConfiguration;
        }
      }
    }
    return null;
  }
  
  @Nullable
  private static WifiConfiguration a(String paramString, @NonNull List<WifiConfiguration> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WifiConfiguration localWifiConfiguration = (WifiConfiguration)paramList.next();
      if (Objects.equals(localWifiConfiguration.BSSID, paramString)) {
        return localWifiConfiguration;
      }
    }
    return null;
  }
  
  public static List<WifiConfiguration> a()
  {
    return c.b();
  }
  
  public static boolean a(int paramInt)
  {
    if ((!c.a(paramInt)) && (!c.b(paramInt))) {
      return false;
    }
    c.f();
    return true;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return false;
      }
      Object localObject = a();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        bool2 = bool3;
        for (;;)
        {
          bool1 = bool2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
          if ((d.a(localWifiConfiguration.SSID).compareTo(paramString) == 0) && (d.a(localWifiConfiguration) == paramInt)) {
            bool2 |= c.a(localWifiConfiguration.networkId);
          }
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        c.f();
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public static WifiConfiguration b(String paramString, int paramInt)
  {
    List localList = a();
    if (localList != null) {
      return a(paramString, paramInt, localList);
    }
    return null;
  }
  
  static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"");
    return localStringBuilder.toString();
  }
  
  public static boolean c(String paramString, int paramInt)
  {
    if (a(paramString, paramInt))
    {
      c.f();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mt.b
 * JD-Core Version:    0.7.0.1
 */