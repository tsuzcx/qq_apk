package com.tencent.map.sdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ao
{
  private static volatile byte a = 0;
  private static volatile boolean b = true;
  private static String c = "";
  private static String d = "unknown";
  private static volatile int e = 0;
  private static volatile boolean f = false;
  private static volatile int g = -1;
  private static Map<String, at> h = new ConcurrentHashMap();
  private static BroadcastReceiver i = new ap();
  private static String j = "";
  private static String k = "cmwap";
  private static String l = "3gwap";
  private static String m = "uniwap";
  private static String n = "ctwap";
  
  private static byte a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = NetworkInterface.getByName(paramString);
        if (!paramString.isUp()) {
          return 1;
        }
        Iterator localIterator = paramString.getInterfaceAddresses().iterator();
        int i1 = 0;
        int i2 = 0;
        if (localIterator.hasNext())
        {
          paramString = ((InterfaceAddress)localIterator.next()).getAddress();
          if (!paramString.isLoopbackAddress())
          {
            String str = paramString.getHostAddress();
            paramString = str;
            if (str.contains("%")) {
              paramString = str.split("%")[0];
            }
            if (as.b(paramString))
            {
              i2 = 1;
            }
            else if ((i1 == 0) && (as.c(paramString)))
            {
              boolean bool = as.a(paramString);
              if (bool) {
                i1 = 1;
              }
            }
          }
        }
        else
        {
          if ((i2 != 0) && (i1 != 0)) {
            return 2;
          }
          if (i1 != 0) {
            return 3;
          }
          if (i2 != 0) {
            break;
          }
          return 0;
        }
      }
      catch (Exception paramString)
      {
        return 0;
      }
    }
    return 1;
  }
  
  public static void a()
  {
    try
    {
      o();
      e();
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      ac.a().registerReceiver(i, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(String paramString, at paramat)
  {
    synchronized (h)
    {
      h.put(paramString, paramat);
      return;
    }
  }
  
  public static String b()
  {
    return d;
  }
  
  public static String c()
  {
    switch (e)
    {
    default: 
      return "";
    case 1: 
      return "wifi";
    case 2: 
      return "2g";
    case 3: 
      return "3g";
    }
    return "4g";
  }
  
  public static String d()
  {
    switch (e)
    {
    default: 
      return "null";
    case 1: 
      return "wifi";
    }
    return c;
  }
  
  public static void e()
  {
    for (;;)
    {
      try
      {
        i1 = e;
      }
      finally {}
      try
      {
        ??? = ((ConnectivityManager)ac.a().getSystemService("connectivity")).getActiveNetworkInfo();
        if ((??? == null) || (!((NetworkInfo)???).isAvailable()) || (!((NetworkInfo)???).isConnected())) {
          break label598;
        }
        b = true;
        i2 = ((NetworkInfo)???).getType();
        if (i2 != 1) {
          break label189;
        }
        e = 1;
        g = 0;
        f = false;
        ??? = ((WifiManager)ac.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        d = "ssid_" + ((WifiInfo)???).getSSID() + ((WifiInfo)???).getBSSID();
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject4;
          boolean bool;
          localThrowable.printStackTrace();
          if (i1 == e) {
            break label633;
          }
          synchronized (h)
          {
            localObject4 = h.values().iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
            } while ((at)((Iterator)localObject4).next() == null);
            at.a(e, d);
          }
          if ((i2 != 13) && (i2 != 19)) {
            break;
          }
          e = 4;
        }
      }
      finally
      {
        for (;;)
        {
          if (i1 == e) {
            break label644;
          }
          synchronized (h)
          {
            Iterator localIterator2 = h.values().iterator();
            do
            {
              if (!localIterator2.hasNext()) {
                break;
              }
            } while ((at)localIterator2.next() == null);
            at.a(e, d);
          }
          e = 3;
        }
        if (!c.contains(k)) {
          break label498;
        }
        j = "10.0.0.172";
        continue;
        if (!c.contains(m)) {
          break label519;
        }
        j = "10.0.0.172";
        continue;
        if (!c.contains(n)) {
          break label540;
        }
        j = "10.0.0.200";
        continue;
        j = "";
        continue;
        c = "unknown";
        e = 0;
        g = -1;
        d = "unknown";
        f = false;
        continue;
        c = "unknown";
        e = 0;
        g = -1;
        d = "unknown";
        f = false;
        continue;
        c = "unknown";
        e = 0;
        g = -1;
        d = "unknown";
        f = false;
        b = false;
        a = 0;
        continue;
        for (;;)
        {
          return;
        }
      }
      if (i1 == e) {
        break label633;
      }
      synchronized (h)
      {
        Iterator localIterator1 = h.values().iterator();
        if (!localIterator1.hasNext()) {
          break label631;
        }
        if ((at)localIterator1.next() == null) {
          continue;
        }
        at.a(e, d);
      }
      label189:
      localObject4 = localObject2.getExtraInfo();
      if (localObject4 == null) {
        break label573;
      }
      c = ((String)localObject4).trim().toLowerCase();
      if (i2 != 0) {
        break label548;
      }
      d = "apn_" + c;
      i2 = localObject2.getSubtype();
      g = i2;
      if ((i2 != 1) && (i2 != 2) && (i2 != 4)) {
        break label379;
      }
      e = 2;
      bool = c.contains("wap");
      f = bool;
      if (bool)
      {
        if (!c.contains(l)) {
          break label477;
        }
        j = "10.0.0.172";
      }
    }
  }
  
  public static String f()
  {
    if (g == -1) {
      return "unknown";
    }
    switch (g)
    {
    default: 
      return "unknown";
    case 0: 
      return "wifi";
    case 13: 
      return "LTE";
    case 1: 
      return "GPRS";
    case 2: 
      return "EDGE";
    case 4: 
      return "CDMA";
    case 3: 
      return "UMTS";
    case 8: 
      return "HSDPA";
    case 9: 
      return "HSUPA";
    case 10: 
      return "HSPA";
    case 5: 
      return "EVDO_0";
    case 6: 
      return "EVDO_A";
    case 7: 
      return "1xRTT";
    case 11: 
      return "iDen";
    case 12: 
      return "EVDO_B";
    case 14: 
      return "EHRPD";
    }
    return "HSPAP";
  }
  
  public static int g()
  {
    return e;
  }
  
  public static byte h()
  {
    return a;
  }
  
  public static boolean i()
  {
    return b;
  }
  
  public static boolean j()
  {
    return f;
  }
  
  public static Integer k()
  {
    
    Object localObject2;
    Object localObject1;
    if ((e == 2) || (e == 3) || (e == 4))
    {
      i1 = 1;
      if (i1 == 0) {
        break label266;
      }
      localObject2 = ac.a();
      localObject1 = c;
      localObject2 = (TelephonyManager)((Context)localObject2).getSystemService("phone");
      if ((localObject2 == null) || (((TelephonyManager)localObject2).getSimState() != 5)) {
        break label149;
      }
      localObject2 = ((TelephonyManager)localObject2).getSimOperator();
      if (((String)localObject2).length() <= 0) {
        break label149;
      }
      if ((!((String)localObject2).equals("46000")) && (!((String)localObject2).equals("46002"))) {
        break label113;
      }
      localObject1 = Integer.valueOf(1);
    }
    label98:
    for (int i1 = ((Integer)localObject1).intValue();; i1 = 0)
    {
      return Integer.valueOf(i1);
      i1 = 0;
      break;
      label113:
      if (((String)localObject2).equals("46001"))
      {
        localObject1 = Integer.valueOf(2);
        break label98;
      }
      if (((String)localObject2).equals("46003"))
      {
        localObject1 = Integer.valueOf(3);
        break label98;
      }
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).toLowerCase();
        if ((((String)localObject1).contains("cmnet")) || (((String)localObject1).contains("cmwap")))
        {
          localObject1 = Integer.valueOf(1);
          break label98;
        }
        if ((((String)localObject1).contains("uninet")) || (((String)localObject1).contains("uniwap")) || (((String)localObject1).contains("3gnet")) || (((String)localObject1).contains("3gwap")))
        {
          localObject1 = Integer.valueOf(2);
          break label98;
        }
        if ((((String)localObject1).contains("ctnet")) || (((String)localObject1).contains("ctwap")))
        {
          localObject1 = Integer.valueOf(3);
          break label98;
        }
      }
      localObject1 = Integer.valueOf(0);
      break label98;
    }
  }
  
  public static Proxy l()
  {
    if ((f) && (!TextUtils.isEmpty(j))) {
      return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(j, 80));
    }
    return null;
  }
  
  public static boolean m()
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)ac.a().getSystemService("power");
      if ((Build.VERSION.SDK_INT >= 23) && (localPowerManager != null))
      {
        boolean bool = ((Boolean)PowerManager.class.getDeclaredMethod("isDeviceIdleMode", new Class[0]).invoke(localPowerManager, new Object[0])).booleanValue();
        return bool;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  private static boolean o()
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      a = 1;
      return false;
    }
    Object localObject = (ConnectivityManager)ac.a().getSystemService("connectivity");
    NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable()) || (!localNetworkInfo.isConnected()))
    {
      a = 0;
      return false;
    }
    try
    {
      localObject = (LinkProperties)ConnectivityManager.class.getDeclaredMethod("getActiveLinkProperties", new Class[0]).invoke(localObject, new Object[0]);
      if (localObject == null) {
        a = 0;
      } else {
        a = a(((LinkProperties)localObject).getInterfaceName());
      }
    }
    catch (Exception localException)
    {
      a = 0;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ao
 * JD-Core Version:    0.7.0.1
 */