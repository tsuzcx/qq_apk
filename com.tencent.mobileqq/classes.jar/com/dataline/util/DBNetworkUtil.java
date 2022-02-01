package com.dataline.util;

import android.annotation.TargetApi;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class DBNetworkUtil
{
  public static int a(String paramString)
  {
    try
    {
      paramString = InetAddress.getByName(a()).getAddress();
      int i = paramString[3];
      int j = paramString[2];
      int k = paramString[1];
      int m = paramString[0];
      return (m & 0xFF) + (((i & 0xFF) << 24) + ((j & 0xFF) << 16) + ((k & 0xFF) << 8)) & 0xFFFFFFFF;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  @Deprecated
  @TargetApi(11)
  public static String a()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      try
      {
        InetAddress localInetAddress;
        do
        {
          localObject1 = NetworkInterface.getNetworkInterfaces();
          Object localObject2;
          while (!((Enumeration)localObject2).hasMoreElements())
          {
            do
            {
              if (!((Enumeration)localObject1).hasMoreElements()) {
                break;
              }
              localObject2 = (NetworkInterface)((Enumeration)localObject1).nextElement();
              ((NetworkInterface)localObject2).getHardwareAddress();
            } while (!((NetworkInterface)localObject2).getName().contains("wlan"));
            localObject2 = ((NetworkInterface)localObject2).getInetAddresses();
          }
          localInetAddress = (InetAddress)((Enumeration)localObject2).nextElement();
        } while ((localInetAddress.isLoopbackAddress()) || (localInetAddress.getAddress().length != 4));
        Object localObject1 = localInetAddress.getHostAddress();
        return localObject1;
      }
      catch (SocketException localSocketException)
      {
        localSocketException.printStackTrace();
      }
      return "";
    }
    WifiManager localWifiManager = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (!localWifiManager.isWifiEnabled()) {
      return "";
    }
    return a(localWifiManager.getConnectionInfo().getIpAddress());
  }
  
  public static String a(long paramLong)
  {
    return (paramLong & 0xFF) + "." + (paramLong >> 8 & 0xFF) + "." + (paramLong >> 16 & 0xFF) + "." + (paramLong >> 24 & 0xFF);
  }
  
  public static String a(boolean paramBoolean)
  {
    if (NetConnInfoCenter.getActiveNetIpFamily(true) == 2) {
      return a(paramBoolean, true);
    }
    return a(paramBoolean, false);
  }
  
  private static String a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      label59:
      InetAddress localInetAddress;
      do
      {
        do
        {
          do
          {
            localObject1 = NetworkInterface.getNetworkInterfaces();
            break label59;
            Object localObject2;
            while (!((Enumeration)localObject2).hasMoreElements())
            {
              do
              {
                if ((localObject1 == null) || (!((Enumeration)localObject1).hasMoreElements())) {
                  break;
                }
                localObject2 = (NetworkInterface)((Enumeration)localObject1).nextElement();
              } while ((localObject2 == null) || ((paramBoolean1) && ((((NetworkInterface)localObject2).getName() == null) || (!((NetworkInterface)localObject2).getName().contains("wlan")))));
              localObject2 = ((NetworkInterface)localObject2).getInetAddresses();
            }
            localInetAddress = (InetAddress)((Enumeration)localObject2).nextElement();
          } while ((localInetAddress == null) || (localInetAddress.isLoopbackAddress()) || (localInetAddress.isAnyLocalAddress()) || (localInetAddress.isLinkLocalAddress()));
          if (!paramBoolean2) {
            break;
          }
        } while (!(localInetAddress instanceof Inet6Address));
        return localInetAddress.getHostAddress();
      } while (!(localInetAddress instanceof Inet4Address));
      Object localObject1 = localInetAddress.getHostAddress();
      return localObject1;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static String b()
  {
    return a(true);
  }
  
  public static String b(long paramLong)
  {
    return (paramLong & 0xFF) + "." + (paramLong >> 8 & 0xFF) + "." + (paramLong >> 16 & 0xFF) + "." + (paramLong >> 24 & 0xFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.util.DBNetworkUtil
 * JD-Core Version:    0.7.0.1
 */