package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class ea
  extends BroadcastReceiver
{
  static Handler e;
  private static final Comparator<ScanResult> l = new Comparator() {};
  volatile boolean a;
  final de b;
  boolean c;
  volatile boolean d = false;
  private final WifiManager f;
  private long g;
  private HashSet<String> h;
  private List<ScanResult> i;
  private final Runnable j;
  private final Object k = new Object();
  
  public ea(de paramde)
  {
    this.b = paramde;
    this.f = paramde.g;
    this.h = new HashSet();
    this.j = new Runnable()
    {
      public final void run()
      {
        ea.a(ea.this);
        long l = ea.b(ea.this).b.m;
        ea.a(ea.this, l);
        ev.a("TxWifiProvider", 6, "Interval:".concat(String.valueOf(l)));
      }
    };
  }
  
  private void a(List<ScanResult> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      d();
    }
    for (;;)
    {
      paramList = new ei(paramList, this.g, this.f.getWifiState());
      this.b.b(paramList);
      return;
      if (ex.a)
      {
        ex.a = false;
        d();
      }
    }
  }
  
  private void c()
  {
    ev.a("TxWifiProvider", 6, Thread.currentThread().getName());
    if (this.h == null) {
      this.h = new HashSet();
    }
    ScanResult localScanResult;
    if (this.h.size() == 0)
    {
      localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        localScanResult = (ScanResult)localIterator.next();
        this.h.add(localScanResult.toString());
      }
      this.g = System.currentTimeMillis();
      ev.b("TxWifiProvider", "first receiver");
      a(this.i);
      return;
    }
    int m = this.h.size();
    if (m != this.i.size())
    {
      this.h.clear();
      localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        localScanResult = (ScanResult)localIterator.next();
        this.h.add(localScanResult.BSSID + localScanResult.level);
      }
      this.g = System.currentTimeMillis();
      ev.b("TxWifiProvider", "size not same");
      a(this.i);
      return;
    }
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      localScanResult = (ScanResult)localIterator.next();
      this.h.add(localScanResult.BSSID + localScanResult.level);
    }
    if (m != this.h.size())
    {
      this.h.clear();
      localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        localScanResult = (ScanResult)localIterator.next();
        this.h.add(localScanResult.BSSID + localScanResult.level);
      }
      this.g = System.currentTimeMillis();
      ev.b("TxWifiProvider", "size same,but mac is not same");
      a(this.i);
      return;
    }
    ev.b("TxWifiProvider", "size same,mac and rssi same");
  }
  
  private void d()
  {
    m = 1;
    n = this.f.getWifiState();
    if (n == 3) {
      a(0L);
    }
    for (;;)
    {
      n = m;
      try
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          n = m;
          if (!this.b.h.isProviderEnabled("network"))
          {
            boolean bool = this.b.h.isProviderEnabled("gps");
            n = m;
            if (!bool) {
              n = 5;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Message localMessage;
          n = m;
        }
      }
      localMessage = new Message();
      localMessage.what = 12999;
      localMessage.arg1 = 12001;
      localMessage.arg2 = n;
      this.b.b(localMessage);
      return;
      if (n == 1)
      {
        m = 0;
        if (this.i != null) {
          this.i.clear();
        }
        this.b.b(ei.a);
      }
      else
      {
        m = -1;
      }
    }
  }
  
  public final void a()
  {
    synchronized (this.k)
    {
      if (!this.a) {
        return;
      }
      this.a = false;
      e.removeCallbacksAndMessages(null);
    }
    try
    {
      this.b.a.unregisterReceiver(this);
      ev.a("TxWifiProvider", 6, "unregisterReceiver success");
      this.g = 0L;
      this.h = null;
      if (this.i != null) {
        this.i.clear();
      }
      if (this.h != null) {
        this.h.clear();
      }
      ev.a("TxWifiProvider", 4, "shutdown: state=[shutdown]");
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ev.a("TxWifiProvider", 6, "unregisterReceiver failed");
      }
    }
  }
  
  final void a(long paramLong)
  {
    ev.a("TxWifiProvider", 6, "ScanInterval:".concat(String.valueOf(paramLong)));
    Handler localHandler = e;
    Runnable localRunnable = this.j;
    localHandler.removeCallbacks(localRunnable);
    localHandler.postDelayed(localRunnable, paramLong);
  }
  
  final boolean b()
  {
    if ((!ex.b(this.b)) || (this.c))
    {
      ev.a("TxWifiProvider", 6, "no try scan ,return!!");
      return false;
    }
    return ex.a(this.f);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      synchronized (this.k)
      {
        paramContext = paramIntent.getAction();
        ev.a("TxWifiProvider", 4, "onReceive ".concat(String.valueOf(paramContext)));
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramContext)) {
          d();
        }
        if (("android.net.wifi.WIFI_STATE_CHANGED".equals(paramContext)) || ("android.net.wifi.SCAN_RESULTS".equals(paramContext)))
        {
          paramContext = ex.b(this.f);
          if ((paramContext == null) || (paramContext.size() <= 0)) {
            break label159;
          }
          this.i = new ArrayList(paramContext);
          eb.a(this.i);
          if ((this.i != null) && (this.i.size() > 0))
          {
            Collections.sort(this.i, l);
            c();
          }
        }
        return;
      }
      paramIntent = new StringBuilder("ScanResult list is ");
    }
    catch (Exception paramContext)
    {
      ev.b("TxWifiProvider", paramContext.toString());
      return;
    }
    label159:
    if (paramContext == null) {}
    for (paramContext = "null";; paramContext = "size=0")
    {
      ev.a("TxWifiProvider", paramContext);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ea
 * JD-Core Version:    0.7.0.1
 */