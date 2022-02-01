package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public final class fq
{
  public static boolean a = false;
  private static long b = 0L;
  private static boolean c = false;
  
  public static String a()
  {
    try
    {
      SharedPreferences localSharedPreferences = dy.a("LocationSDK");
      String str1 = (String)dy.b(localSharedPreferences, "mac", "");
      String str2 = str1;
      Enumeration localEnumeration;
      Object localObject1;
      Object localObject2;
      StringBuilder localStringBuilder;
      int j;
      int i;
      return str2;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(str1)) {
            return str1;
          }
          str2 = str1;
          localEnumeration = NetworkMonitor.getNetworkInterfaces();
          localObject1 = str1;
          str2 = str1;
          if (localEnumeration.hasMoreElements())
          {
            str2 = str1;
            localObject1 = (NetworkInterface)localEnumeration.nextElement();
            if (localObject1 == null) {
              continue;
            }
            str2 = str1;
            if (!((NetworkInterface)localObject1).getName().equalsIgnoreCase("wlan0")) {
              continue;
            }
            str2 = str1;
            localObject2 = ((NetworkInterface)localObject1).getHardwareAddress();
            if (localObject2 == null) {
              continue;
            }
            str2 = str1;
            if (localObject2.length == 0) {
              continue;
            }
            str2 = str1;
            localStringBuilder = new StringBuilder();
            str2 = str1;
            j = localObject2.length;
            i = 0;
            if (i < j)
            {
              str2 = str1;
              localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(localObject2[i]) }));
              i += 1;
              continue;
            }
            str2 = str1;
            if (localStringBuilder.length() > 0)
            {
              str2 = str1;
              localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
            }
            str2 = str1;
            str1 = localStringBuilder.toString();
            str2 = str1;
            dy.a(localSharedPreferences, "mac", str1);
            str2 = str1;
            localObject2 = new StringBuilder("interfaceName=");
            str2 = str1;
            ((StringBuilder)localObject2).append(((NetworkInterface)localObject1).getName());
            str2 = str1;
            ((StringBuilder)localObject2).append(", mac=");
            str2 = str1;
            ((StringBuilder)localObject2).append(str1);
            continue;
            localObject1 = "";
          }
          return localObject1;
        }
        catch (Throwable localThrowable2) {}
        localThrowable1 = localThrowable1;
      }
    }
  }
  
  public static boolean a(WifiManager paramWifiManager)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramWifiManager != null) {
      bool1 = bool2;
    }
    try
    {
      try
      {
        if (System.currentTimeMillis() - b > 4000L)
        {
          bool1 = bool2;
          bool2 = paramWifiManager.startScan();
          bool1 = bool2;
          c = bool2;
          bool1 = bool2;
          b = System.currentTimeMillis();
          bool1 = bool2;
        }
        else
        {
          bool1 = bool2;
          bool2 = c;
          bool1 = bool2;
        }
      }
      finally
      {
        break label75;
      }
    }
    catch (Exception paramWifiManager)
    {
      label68:
      label75:
      label80:
      break label68;
    }
    a = true;
    break label80;
    throw paramWifiManager;
    return bool1;
  }
  
  public static boolean a(ea paramea)
  {
    try
    {
      paramea = paramea.g;
      if (paramea != null)
      {
        boolean bool = paramea.isWifiEnabled();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramea) {}
    return false;
  }
  
  public static List<ScanResult> b(WifiManager paramWifiManager)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramWifiManager != null) {
      localObject1 = localObject2;
    }
    try
    {
      paramWifiManager = paramWifiManager.getScanResults();
      localObject1 = paramWifiManager;
      a = false;
      localObject1 = paramWifiManager;
    }
    catch (Exception paramWifiManager)
    {
      label26:
      break label26;
    }
    a = true;
    paramWifiManager = (WifiManager)localObject1;
    if (localObject1 == null) {
      paramWifiManager = Collections.emptyList();
    }
    return paramWifiManager;
  }
  
  @SuppressLint({"NewApi"})
  public static boolean b(ea paramea)
  {
    paramea = paramea.g;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramea != null) {}
    try
    {
      boolean bool3 = paramea.isWifiEnabled();
      bool1 = bool3;
      if (!bool3)
      {
        bool1 = bool3;
        bool2 = bool3;
        if (Build.VERSION.SDK_INT >= 18)
        {
          bool2 = bool3;
          bool1 = paramea.isScanAlwaysAvailable();
        }
      }
      return bool1;
    }
    catch (Throwable paramea) {}
    return bool2;
  }
  
  public static String c(ea paramea)
  {
    Object localObject = paramea.a;
    if (localObject == null) {
      return "{}";
    }
    try
    {
      paramea = (WifiManager)((Context)localObject).getSystemService("wifi");
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if (paramea != null)
      {
        if (localObject == null) {
          return "{}";
        }
        paramea = NetworkMonitor.getConnectionInfo(paramea);
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
        if ((paramea != null) && (localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          localObject = paramea.getBSSID();
          if ((localObject != null) && (!((String)localObject).equals("000000000000")) && (!((String)localObject).equals("00-00-00-00-00-00")))
          {
            if (((String)localObject).equals("00:00:00:00:00:00")) {
              return "{}";
            }
            int i = paramea.getRssi();
            if (i >= -100)
            {
              if (i > -20) {
                return "{}";
              }
              paramea = paramea.getSSID().replace("\"", "").replace("|", "");
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("{");
              localStringBuilder.append("\"mac\":\"");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append("\",\"rssi\":");
              localStringBuilder.append(i);
              localStringBuilder.append(",\"ssid\":\"");
              localStringBuilder.append(paramea);
              localStringBuilder.append("\"}");
              paramea = localStringBuilder.toString();
              return paramea;
            }
          }
        }
      }
      return "{}";
    }
    catch (Exception paramea) {}
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.fq
 * JD-Core Version:    0.7.0.1
 */