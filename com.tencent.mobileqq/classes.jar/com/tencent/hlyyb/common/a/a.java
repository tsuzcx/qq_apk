package com.tencent.hlyyb.common.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.PowerManager;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static volatile boolean a = true;
  private static String b = "";
  private static String c = "";
  private static String d = "";
  private static volatile int e = 0;
  private static volatile boolean f = false;
  private static Map<String, b> g = new ConcurrentHashMap();
  private static BroadcastReceiver h = new c();
  
  public static void a()
  {
    com.tencent.hlyyb.common.a.h().post(new d());
  }
  
  public static void a(String paramString, b paramb)
  {
    synchronized (g)
    {
      g.put(paramString, paramb);
      return;
    }
  }
  
  public static String b()
  {
    for (;;)
    {
      try
      {
        switch (e)
        {
        case 1: 
          str = "unknown";
          return str;
        }
      }
      finally {}
      String str = "ssid_" + c + d;
      continue;
      str = "apn_" + b;
    }
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
  
  public static void d()
  {
    for (;;)
    {
      try
      {
        i = e;
      }
      finally {}
      try
      {
        ??? = ((ConnectivityManager)com.tencent.hlyyb.common.a.a().getSystemService("connectivity")).getActiveNetworkInfo();
        if ((??? == null) || (!((NetworkInfo)???).isAvailable()) || (!((NetworkInfo)???).isConnected())) {
          break label438;
        }
        a = true;
        j = ((NetworkInfo)???).getType();
        if (j != 1) {
          break label170;
        }
        e = 1;
        f = false;
        ??? = ((WifiManager)com.tencent.hlyyb.common.a.a().getSystemService("wifi")).getConnectionInfo();
        c = ((WifiInfo)???).getSSID();
        d = ((WifiInfo)???).getBSSID();
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject4;
          localThrowable.printStackTrace();
          if (i == e) {
            break label460;
          }
          synchronized (g)
          {
            localObject4 = g.values().iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject8 = (b)((Iterator)localObject4).next();
            } while (localObject8 == null);
            ((b)localObject8).a(e, b());
          }
          if (j != 13) {
            break;
          }
          e = 4;
        }
      }
      finally
      {
        for (;;)
        {
          if (i == e) {
            break label471;
          }
          synchronized (g)
          {
            localObject8 = g.values().iterator();
            b localb;
            do
            {
              if (!((Iterator)localObject8).hasNext()) {
                break;
              }
              localb = (b)((Iterator)localObject8).next();
            } while (localb == null);
            localb.a(e, b());
          }
          e = 3;
        }
        b = "unknown";
        e = 0;
        f = false;
        continue;
        b = "unknown";
        e = 0;
        f = false;
        continue;
        b = "unknown";
        e = 0;
        f = false;
        a = false;
        continue;
        for (;;)
        {
          return;
        }
      }
      if (i == e) {
        break label460;
      }
      synchronized (g)
      {
        Iterator localIterator = g.values().iterator();
        if (!localIterator.hasNext()) {
          break label458;
        }
        localObject8 = (b)localIterator.next();
        if (localObject8 == null) {
          continue;
        }
        ((b)localObject8).a(e, b());
      }
      label170:
      localObject4 = localObject2.getExtraInfo();
      if (localObject4 == null) {
        break label422;
      }
      b = ((String)localObject4).trim().toLowerCase();
      if (j != 0) {
        break label406;
      }
      j = localObject2.getSubtype();
      if ((j != 1) && (j != 2) && (j != 4)) {
        break label309;
      }
      e = 2;
      f = b.contains("wap");
    }
  }
  
  public static boolean e()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        PowerManager localPowerManager = (PowerManager)com.tencent.hlyyb.common.a.a().getSystemService("power");
        if (localPowerManager != null)
        {
          boolean bool = ((Boolean)PowerManager.class.getDeclaredMethod("isDeviceIdleMode", new Class[0]).invoke(localPowerManager, new Object[0])).booleanValue();
          return bool;
        }
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean f()
  {
    return (e == 2) || (e == 3) || (e == 4);
  }
  
  public static int g()
  {
    return e;
  }
  
  public static boolean h()
  {
    return a;
  }
  
  public static boolean i()
  {
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hlyyb.common.a.a
 * JD-Core Version:    0.7.0.1
 */