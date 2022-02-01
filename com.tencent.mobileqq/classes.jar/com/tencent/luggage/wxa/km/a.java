package com.tencent.luggage.wxa.km;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.kl.d;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.kn.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
{
  private final String a;
  @Nullable
  private final Context b;
  @Nullable
  private e c;
  @Nullable
  private Map<String, d> d;
  private final AtomicBoolean e;
  private final AtomicBoolean f;
  private final Handler g;
  @Nullable
  private List<d> h;
  private final Runnable i;
  @Nullable
  private BroadcastReceiver j;
  @Nullable
  private volatile com.tencent.luggage.wxa.kl.i k;
  
  public a(@Nullable Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MicroMsg.Ble.BleScanWorker#");
    localStringBuilder.append(hashCode());
    this.a = localStringBuilder.toString();
    this.e = new AtomicBoolean(false);
    this.f = new AtomicBoolean(false);
    this.g = new Handler();
    this.i = new a.1(this);
    this.b = paramContext;
  }
  
  private static i a(@NonNull String paramString)
  {
    int m = paramString.hashCode();
    if (m != -1078030475)
    {
      if (m != 107348)
      {
        if ((m == 3202466) && (paramString.equals("high")))
        {
          m = 2;
          break label70;
        }
      }
      else if (paramString.equals("low"))
      {
        m = 0;
        break label70;
      }
    }
    else if (paramString.equals("medium"))
    {
      m = 1;
      break label70;
    }
    m = -1;
    label70:
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2) {
          return a("medium");
        }
        return new i.a().a(2).a();
      }
      return new i.a().a(1).a();
    }
    return new i.a().a(0).a();
  }
  
  private void f()
  {
    try
    {
      if (this.b == null)
      {
        o.c(this.a, "initBroadcaseListener, context is null");
        return;
      }
      if (this.j == null)
      {
        o.d(this.a, "bluetoothStateListener init");
        this.j = new a.3(this);
        IntentFilter localIntentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        this.b.registerReceiver(this.j, localIntentFilter);
      }
      return;
    }
    finally {}
  }
  
  private void g()
  {
    try
    {
      if ((this.j != null) && (this.b != null))
      {
        o.d(this.a, "bluetoothStateListener uninit");
        this.b.unregisterReceiver(this.j);
        this.j = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    try
    {
      com.tencent.luggage.wxa.kn.a.c(this.a, "init", new Object[0]);
      this.f.set(true);
      this.d = new HashMap();
      this.h = new ArrayList();
      this.c = new a.2(this);
      f();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.kl.b paramb, List<f> paramList, @NonNull com.tencent.luggage.wxa.kl.i parami)
  {
    try
    {
      if ((this.f.get()) && (this.c != null))
      {
        if (this.e.get())
        {
          com.tencent.luggage.wxa.kn.a.b(this.a, "already scan", new Object[0]);
          paramb.a(j.a);
          return;
        }
        BluetoothAdapter localBluetoothAdapter = c.b();
        if ((localBluetoothAdapter != null) && (c.f()))
        {
          if (Build.VERSION.SDK_INT >= 23)
          {
            bool = c.e();
            com.tencent.luggage.wxa.kn.a.c(this.a, "checkLocationPermission :%b", new Object[] { Boolean.valueOf(bool) });
            bool = c.d();
            com.tencent.luggage.wxa.kn.a.c(this.a, "checkGpsEnable:%b", new Object[] { Boolean.valueOf(bool) });
          }
          this.e.set(true);
          List<f> localList = paramList;
          if (paramList != null)
          {
            localList = paramList;
            if (paramList.size() == 0)
            {
              com.tencent.luggage.wxa.kn.a.b(this.a, "scanFilterCompats size:%d", new Object[] { Integer.valueOf(paramList.size()) });
              localList = null;
            }
          }
          boolean bool = b.a(localBluetoothAdapter, localList, a(com.tencent.luggage.wxa.kh.a.a.m), this.c);
          com.tencent.luggage.wxa.kn.a.c(this.a, "startBleScan isOk:%b", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            a(parami);
            if (com.tencent.luggage.wxa.kh.a.a.b > 0) {
              this.g.postDelayed(this.i, com.tencent.luggage.wxa.kh.a.a.b);
            }
            paramb.a(j.a);
          }
          else
          {
            paramb.a(j.k);
          }
          return;
        }
        com.tencent.luggage.wxa.kn.a.a(this.a, "BluetoothAdapter is null, err", new Object[0]);
        paramb.a(j.d);
        return;
      }
      paramb.a(j.k);
      return;
    }
    finally {}
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.kl.i parami)
  {
    this.k = parami;
  }
  
  public j b()
  {
    try
    {
      if ((this.f.get()) && (this.c != null))
      {
        if (!d())
        {
          com.tencent.luggage.wxa.kn.a.b(this.a, "not scan", new Object[0]);
          localObject1 = j.a;
          return localObject1;
        }
        localObject1 = c.b();
        if ((localObject1 != null) && (c.f()))
        {
          com.tencent.luggage.wxa.kn.a.b(this.a, "stopBleScan, stopScan", new Object[0]);
          this.e.set(false);
          b.a((BluetoothAdapter)localObject1, this.c);
          localObject1 = j.a;
          return localObject1;
        }
        com.tencent.luggage.wxa.kn.a.a(this.a, "BluetoothAdapter is null, err", new Object[0]);
        localObject1 = j.d;
        return localObject1;
      }
      Object localObject1 = j.c;
      return localObject1;
    }
    finally {}
  }
  
  public List<d> c()
  {
    try
    {
      if (this.d == null)
      {
        localArrayList = new ArrayList();
        return localArrayList;
      }
      ArrayList localArrayList = new ArrayList(this.d.values());
      return localArrayList;
    }
    finally {}
  }
  
  public boolean d()
  {
    return this.e.get();
  }
  
  public void e()
  {
    try
    {
      com.tencent.luggage.wxa.kn.a.c(this.a, "uninit", new Object[0]);
      b();
      this.f.set(false);
      if (this.d != null) {
        this.d.clear();
      }
      if (this.h != null) {
        this.h.clear();
      }
      if ((c.b() != null) && (c.b().isDiscovering())) {
        c.b().cancelDiscovery();
      }
      g();
      this.c = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.a
 * JD-Core Version:    0.7.0.1
 */