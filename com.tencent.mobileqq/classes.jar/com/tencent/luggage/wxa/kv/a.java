package com.tencent.luggage.wxa.kv;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public class a
{
  public static Map<String, a.a> a = new ConcurrentHashMap();
  public static BroadcastReceiver b;
  public static boolean c;
  
  public static a.a a(String paramString)
  {
    return (a.a)a.get(paramString);
  }
  
  public static void a(String paramString, a.a parama)
  {
    a.put(paramString, parama);
    if (b == null)
    {
      o.d("MicroMsg.BeaconManager", "bluetoothStateListener init");
      b = new a.1();
      paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
      r.a().registerReceiver(b, paramString);
    }
  }
  
  public static void b(String paramString)
  {
    a.remove(paramString);
    o.d("MicroMsg.BeaconManager", "remove Beacon appid:%s", new Object[] { paramString });
    if ((a.size() == 0) && (b != null))
    {
      o.d("MicroMsg.BeaconManager", "bluetoothStateListener uninit");
      r.a().unregisterReceiver(b);
      b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kv.a
 * JD-Core Version:    0.7.0.1
 */