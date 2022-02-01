package com.tencent.luggage.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class i
{
  public static String a()
  {
    int i = 0;
    try
    {
      int j = x.d(r.a());
      i = j;
    }
    catch (Exception localException1)
    {
      o.b("Luggage.LuggageNetUtil", "getSelfIp, call NetworkDetailInfo.getNetType(), exp = %s", new Object[] { localException1 });
    }
    String str = "127.0.0.1";
    if (i == -1) {
      return "127.0.0.1";
    }
    if (i == 0) {
      return a(r.a());
    }
    try
    {
      Enumeration localEnumeration = NetworkMonitor.getNetworkInterfaces();
      InetAddress localInetAddress;
      do
      {
        while (!((Enumeration)localObject).hasMoreElements())
        {
          do
          {
            localObject = str;
            if (!localEnumeration.hasMoreElements()) {
              break;
            }
            localObject = (NetworkInterface)localEnumeration.nextElement();
          } while (localObject == null);
          localObject = ((NetworkInterface)localObject).getInetAddresses();
        }
        localInetAddress = (InetAddress)((Enumeration)localObject).nextElement();
      } while ((localInetAddress == null) || (localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
      if (af.c(localInetAddress.getHostAddress())) {
        return "127.0.0.1";
      }
      Object localObject = localInetAddress.getHostAddress();
      return localObject;
    }
    catch (Exception localException2) {}
    return "127.0.0.1";
  }
  
  public static String a(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    try
    {
      paramContext = NetworkMonitor.getConnectionInfo(paramContext);
    }
    catch (Exception paramContext)
    {
      label18:
      int i;
      break label18;
    }
    paramContext = null;
    if (paramContext == null) {
      return "127.0.0.1";
    }
    i = paramContext.getIpAddress();
    return String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(i & 0xFF), Integer.valueOf(i >> 8 & 0xFF), Integer.valueOf(i >> 16 & 0xFF), Integer.valueOf(i >> 24 & 0xFF) });
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getNetworkInfo(1);
      if (paramContext != null) {
        return paramContext.isConnected();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.i
 * JD-Core Version:    0.7.0.1
 */