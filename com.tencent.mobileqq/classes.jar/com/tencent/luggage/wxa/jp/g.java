package com.tencent.luggage.wxa.jp;

import android.util.Log;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class g
{
  private static final String a = "g";
  private static List<NetworkInterface> b = new ArrayList();
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString2.startsWith("/"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(":");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static List<NetworkInterface> a()
  {
    b.clear();
    c();
    return b;
  }
  
  public static String b()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      Object localObject4 = NetworkMonitor.getNetworkInterfaces();
      Object localObject3;
      for (;;)
      {
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (!((Enumeration)localObject4).hasMoreElements()) {
          break;
        }
        localObject2 = localObject1;
        Enumeration localEnumeration = ((NetworkInterface)((Enumeration)localObject4).nextElement()).getInetAddresses();
        boolean bool;
        do
        {
          do
          {
            localObject2 = localObject1;
            if (!localEnumeration.hasMoreElements()) {
              break;
            }
            localObject2 = localObject1;
            localObject3 = (InetAddress)localEnumeration.nextElement();
            localObject2 = localObject1;
          } while ((localObject3 instanceof Inet6Address));
          localObject2 = localObject1;
          localObject3 = ((InetAddress)localObject3).getHostAddress();
          localObject2 = localObject1;
          bool = "127.0.0.1".equals(localObject3);
        } while (bool);
        localObject1 = localObject3;
      }
      return localObject3;
    }
    catch (SocketException localSocketException)
    {
      localObject3 = a;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("can not get host ip : ");
      ((StringBuilder)localObject4).append(localSocketException.getCause());
      Log.e((String)localObject3, ((StringBuilder)localObject4).toString());
      localSocketException.printStackTrace();
      localObject3 = localObject2;
    }
  }
  
  private static void c()
  {
    try
    {
      Object localObject = NetworkMonitor.getNetworkInterfaces();
      if (localObject == null) {
        return;
      }
      localObject = Collections.list((Enumeration)localObject).iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          return;
        }
        NetworkInterface localNetworkInterface = (NetworkInterface)((Iterator)localObject).next();
        Iterator localIterator = Collections.list(localNetworkInterface.getInetAddresses()).iterator();
        if (localIterator.hasNext())
        {
          if (!((InetAddress)localIterator.next()).getHostAddress().startsWith("192.168")) {
            break;
          }
          b.add(localNetworkInterface);
        }
      }
      return;
    }
    catch (SocketException localSocketException)
    {
      localSocketException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.g
 * JD-Core Version:    0.7.0.1
 */