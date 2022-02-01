package com.tencent.luggage.wxa.ke;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.kl.g;
import com.tencent.luggage.wxa.kl.h;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.kn.a.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.HashMap;
import java.util.Map;

public class a
{
  @NonNull
  private static Map<String, b> a = new HashMap();
  @Nullable
  private static BroadcastReceiver b;
  private static boolean c;
  @NonNull
  private static a.a d = new a.1();
  
  public static b a(String paramString)
  {
    try
    {
      paramString = (b)a.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static j a(@Nullable String paramString, @NonNull b.a parama, @NonNull h paramh, @NonNull g paramg)
  {
    try
    {
      o.d("MicroMsg.Ble.BleManager", "open appId:%s", new Object[] { paramString });
      if (!com.tencent.luggage.wxa.kn.c.c())
      {
        o.b("MicroMsg.Ble.BleManager", "api version is below 18");
        paramString = j.l;
        return paramString;
      }
      if (!a.containsKey(paramString))
      {
        b localb = new b(paramString);
        localb.f();
        localb.a(parama);
        localb.a(paramh);
        localb.a(paramg);
        a.put(paramString, localb);
        com.tencent.luggage.wxa.iu.c.a(paramString, localb);
        c();
        com.tencent.luggage.wxa.kn.a.a(d);
      }
      else
      {
        o.d("MicroMsg.Ble.BleManager", "already open appId:%s", new Object[] { paramString });
      }
      if (!com.tencent.luggage.wxa.kn.c.f())
      {
        o.b("MicroMsg.Ble.BleManager", "bluetooth not enable, err");
        paramString = j.d;
        return paramString;
      }
      paramString = j.a;
      return paramString;
    }
    finally {}
  }
  
  public static j b(String paramString)
  {
    try
    {
      o.d("MicroMsg.Ble.BleManager", "close appId:%s", new Object[] { paramString });
      if (!a.containsKey(paramString))
      {
        paramString = j.a;
        return paramString;
      }
      b localb = (b)a.remove(paramString);
      com.tencent.luggage.wxa.iu.c.b(paramString, localb);
      if (localb == null) {
        o.d("MicroMsg.Ble.BleManager", "close, bleWorker is null");
      } else {
        localb.l();
      }
      if (a.size() == 0) {
        d();
      }
      paramString = j.a;
      return paramString;
    }
    finally {}
  }
  
  private static void c()
  {
    try
    {
      if (b == null)
      {
        o.d("MicroMsg.Ble.BleManager", "bluetoothStateListener init");
        b = new a.2();
        IntentFilter localIntentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        r.a().registerReceiver(b, localIntentFilter);
        c = com.tencent.luggage.wxa.kn.c.f();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void d()
  {
    try
    {
      if (b != null)
      {
        o.d("MicroMsg.Ble.BleManager", "bluetoothStateListener uninit");
        r.a().unregisterReceiver(b);
        b = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ke.a
 * JD-Core Version:    0.7.0.1
 */