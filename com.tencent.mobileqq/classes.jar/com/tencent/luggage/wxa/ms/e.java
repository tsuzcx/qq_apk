package com.tencent.luggage.wxa.ms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e
{
  private static boolean a = false;
  private static WeakReference<com.tencent.luggage.wxa.mt.a> b;
  private static c c;
  private static a d;
  private static Context e;
  private static BroadcastReceiver f;
  @Nullable
  private static volatile b g;
  
  public static c a()
  {
    WifiInfo localWifiInfo = com.tencent.luggage.wxa.mt.c.d();
    String str1 = "";
    String str2;
    if ((localWifiInfo != null) && (!TextUtils.isEmpty(localWifiInfo.getSSID())))
    {
      str1 = com.tencent.luggage.wxa.mt.d.a(localWifiInfo.getSSID());
      str2 = af.a(localWifiInfo.getBSSID(), "");
    }
    else
    {
      str2 = "";
    }
    c localc = c;
    if ((localc != null) && (str1.compareTo(localc.a) == 0) && (str2.compareTo(c.b) == 0)) {
      return c;
    }
    if (localWifiInfo != null)
    {
      o.d("MicroMsg.WiFiManagerWrapper", "getCurrentWiFi, currentWiFiInfo is null, try getWifiList");
      b();
      return c;
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    if ((!a) && (paramContext != null))
    {
      e = r.a();
      o.d("MicroMsg.WiFiManagerWrapper", "initSdk, register WifiScanResultBroadcastReceiver");
      if (f == null) {
        f = new e.a(null);
      }
      e.registerReceiver(f, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
      paramContext = (WifiManager)e.getSystemService("wifi");
      if (paramContext != null)
      {
        com.tencent.luggage.wxa.mt.c.a(paramContext);
        a = true;
      }
    }
  }
  
  public static void a(a parama)
  {
    d = parama;
  }
  
  public static void a(@NonNull b paramb)
  {
    o.d("MicroMsg.WiFiManagerWrapper", "getWifiListAsync");
    c = null;
    if ((a) && (com.tencent.luggage.wxa.mt.c.g()))
    {
      o.d("MicroMsg.WiFiManagerWrapper", "getWifiListAsync, startScan");
      com.tencent.luggage.wxa.mt.c.c();
      g = paramb;
      return;
    }
    d locald = new d();
    if (a) {
      locald.a = "wifi is disable";
    } else {
      locald.a = "sdk not init";
    }
    paramb.a(locald);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = b;
    if (localObject != null)
    {
      localObject = (com.tencent.luggage.wxa.mt.a)((WeakReference)localObject).get();
      if ((localObject != null) && (!((com.tencent.luggage.wxa.mt.a)localObject).a())) {
        ((com.tencent.luggage.wxa.mt.a)localObject).a("duplicated request");
      }
    }
    localObject = new com.tencent.luggage.wxa.mt.a(d, e);
    ((com.tencent.luggage.wxa.mt.a)localObject).a(paramString1, paramString2, paramString3);
    b = new WeakReference(localObject);
  }
  
  public static d b()
  {
    return b(true);
  }
  
  private static d b(boolean paramBoolean)
  {
    d locald = new d();
    Object localObject1 = null;
    c = null;
    if ((a) && (com.tencent.luggage.wxa.mt.c.g()))
    {
      if (paramBoolean) {
        com.tencent.luggage.wxa.mt.c.c();
      }
      Object localObject3 = com.tencent.luggage.wxa.mt.c.e();
      locald.b = new ArrayList();
      locald.a = "ok";
      if (localObject3 != null)
      {
        o.e("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", new Object[] { localObject3, Integer.valueOf(((List)localObject3).size()) });
        Object localObject2 = com.tencent.luggage.wxa.mt.c.d();
        o.e("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", new Object[] { localObject2 });
        if ((localObject2 != null) && (!TextUtils.isEmpty(((WifiInfo)localObject2).getSSID())))
        {
          localObject1 = com.tencent.luggage.wxa.mt.d.a(((WifiInfo)localObject2).getSSID());
          localObject2 = af.a(((WifiInfo)localObject2).getBSSID(), "");
        }
        else
        {
          localObject2 = null;
        }
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ScanResult localScanResult = (ScanResult)((Iterator)localObject3).next();
          if (localScanResult != null)
          {
            int j = com.tencent.luggage.wxa.mt.d.a(localScanResult);
            c localc = new c();
            localc.a = com.tencent.luggage.wxa.mt.d.a(localScanResult.SSID);
            localc.b = af.a(localScanResult.BSSID, "");
            localc.c = com.tencent.luggage.wxa.mt.c.a(localScanResult.level, 100);
            if (j == 2) {
              paramBoolean = true;
            } else {
              paramBoolean = false;
            }
            localc.d = paramBoolean;
            localc.e = localScanResult.frequency;
            int i;
            if ((localObject1 != null) && (localObject2 != null) && (localc.a.compareTo((String)localObject1) == 0) && (localc.b.compareTo((String)localObject2) == 0)) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0) {
              c = localc;
            }
            if ((j == 0) || (j == 2)) {
              locald.b.add(localc);
            }
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[getWifiList] mCurrentWiFi: ");
        ((StringBuilder)localObject1).append(c);
        o.d("MicroMsg.WiFiManagerWrapper", ((StringBuilder)localObject1).toString());
        return locald;
      }
      o.b("MicroMsg.WiFiManagerWrapper", "wifiList is null");
      return locald;
    }
    if (a)
    {
      locald.a = "wifi is disable";
      return locald;
    }
    locald.a = "sdk not init";
    return locald;
  }
  
  public static void c()
  {
    o.d("MicroMsg.WiFiManagerWrapper", "releaseGetWiFiListCallback");
    g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ms.e
 * JD-Core Version:    0.7.0.1
 */