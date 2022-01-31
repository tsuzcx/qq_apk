package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class o
{
  private static volatile boolean a = true;
  private static String b = "";
  private static String c = "";
  private static String d = "";
  private static volatile int e = 0;
  private static volatile boolean f = false;
  private static volatile int g = -1;
  private static Map<String, d> h = new ConcurrentHashMap();
  private static BroadcastReceiver i = new s();
  private static String j = "";
  private static String k = "cmwap";
  private static String l = "3gwap";
  private static String m = "uniwap";
  private static String n = "ctwap";
  
  public static void a()
  {
    l.j().post(new u());
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
  
  public static String d()
  {
    for (;;)
    {
      try
      {
        switch (e)
        {
        case 1: 
          str = "null";
          return str;
        }
      }
      finally {}
      String str = "wifi";
      continue;
      str = b;
    }
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
        ??? = ((ConnectivityManager)l.a().getSystemService("connectivity")).getActiveNetworkInfo();
        if ((??? == null) || (!((NetworkInfo)???).isAvailable()) || (!((NetworkInfo)???).isConnected())) {
          break label540;
        }
        a = true;
        i2 = ((NetworkInfo)???).getType();
        if (i2 != 1) {
          break label170;
        }
        e = 1;
        g = 0;
        f = false;
        ??? = ((WifiManager)l.a().getSystemService("wifi")).getConnectionInfo();
        c = ((WifiInfo)???).getSSID();
        d = ((WifiInfo)???).getBSSID();
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject4;
          boolean bool;
          localThrowable.printStackTrace();
          if (i1 == e) {
            break label566;
          }
          synchronized (h)
          {
            localObject4 = h.values().iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
            } while ((d)((Iterator)localObject4).next() == null);
            i1 = e;
            b();
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
            break label577;
          }
          synchronized (h)
          {
            Iterator localIterator2 = h.values().iterator();
            do
            {
              if (!localIterator2.hasNext()) {
                break;
              }
            } while ((d)localIterator2.next() == null);
            i1 = e;
            b();
          }
          e = 3;
        }
        if (!b.contains(k)) {
          break label452;
        }
        j = "10.0.0.172";
        continue;
        if (!b.contains(m)) {
          break label472;
        }
        j = "10.0.0.172";
        continue;
        if (!b.contains(n)) {
          break label492;
        }
        j = "10.0.0.200";
        continue;
        j = "";
        continue;
        b = "unknown";
        e = 0;
        g = -1;
        f = false;
        continue;
        b = "unknown";
        e = 0;
        g = -1;
        f = false;
        continue;
        b = "unknown";
        e = 0;
        g = -1;
        f = false;
        a = false;
        continue;
        for (;;)
        {
          return;
        }
      }
      if (i1 == e) {
        break label566;
      }
      synchronized (h)
      {
        Iterator localIterator1 = h.values().iterator();
        if (!localIterator1.hasNext()) {
          break label564;
        }
        if ((d)localIterator1.next() == null) {
          continue;
        }
        i1 = e;
        b();
      }
      label170:
      localObject4 = localObject2.getExtraInfo();
      if (localObject4 == null) {
        break label520;
      }
      b = ((String)localObject4).trim().toLowerCase();
      if (i2 != 0) {
        break label500;
      }
      i2 = localObject2.getSubtype();
      g = i2;
      if ((i2 != 1) && (i2 != 2) && (i2 != 4)) {
        break label335;
      }
      e = 2;
      bool = b.contains("wap");
      f = bool;
      if (bool)
      {
        if (!b.contains(l)) {
          break label432;
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
  
  public static boolean h()
  {
    return a;
  }
  
  public static boolean i()
  {
    return f;
  }
  
  public static Integer j()
  {
    
    Object localObject2;
    Object localObject1;
    if ((e == 2) || (e == 3) || (e == 4))
    {
      i1 = 1;
      if (i1 == 0) {
        break label265;
      }
      localObject2 = l.a();
      localObject1 = b;
      localObject2 = (TelephonyManager)((Context)localObject2).getSystemService("phone");
      if ((localObject2 == null) || (((TelephonyManager)localObject2).getSimState() != 5)) {
        break label148;
      }
      localObject2 = ((TelephonyManager)localObject2).getSimOperator();
      if (((String)localObject2).length() <= 0) {
        break label148;
      }
      if ((!((String)localObject2).equals("46000")) && (!((String)localObject2).equals("46002"))) {
        break label112;
      }
      localObject1 = Integer.valueOf(1);
    }
    label97:
    for (int i1 = ((Integer)localObject1).intValue();; i1 = 0)
    {
      return Integer.valueOf(i1);
      i1 = 0;
      break;
      label112:
      if (((String)localObject2).equals("46001"))
      {
        localObject1 = Integer.valueOf(2);
        break label97;
      }
      if (((String)localObject2).equals("46003"))
      {
        localObject1 = Integer.valueOf(3);
        break label97;
      }
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).toLowerCase();
        if ((((String)localObject1).contains("cmnet")) || (((String)localObject1).contains("cmwap")))
        {
          localObject1 = Integer.valueOf(1);
          break label97;
        }
        if ((((String)localObject1).contains("uninet")) || (((String)localObject1).contains("uniwap")) || (((String)localObject1).contains("3gnet")) || (((String)localObject1).contains("3gwap")))
        {
          localObject1 = Integer.valueOf(2);
          break label97;
        }
        if ((((String)localObject1).contains("ctnet")) || (((String)localObject1).contains("ctwap")))
        {
          localObject1 = Integer.valueOf(3);
          break label97;
        }
      }
      localObject1 = Integer.valueOf(0);
      break label97;
    }
  }
  
  public static Proxy k()
  {
    if ((f) && (!TextUtils.isEmpty(j))) {
      return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(j, 80));
    }
    return null;
  }
  
  public static boolean l()
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)l.a().getSystemService("power");
      if ((Build.VERSION.SDK_INT >= 23) && (localPowerManager != null))
      {
        boolean bool = ((Boolean)PowerManager.class.getDeclaredMethod("isDeviceIdleMode", new Class[0]).invoke(localPowerManager, new Object[0])).booleanValue();
        return bool;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.o
 * JD-Core Version:    0.7.0.1
 */