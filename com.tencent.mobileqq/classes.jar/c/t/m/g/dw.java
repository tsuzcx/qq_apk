package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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

final class dw
  extends BroadcastReceiver
{
  private static Handler h;
  private static final Comparator<ScanResult> l = new Comparator() {};
  private volatile boolean a;
  private final da b;
  private final WifiManager c;
  private boolean d;
  private volatile boolean e = false;
  private long f;
  private HashSet<String> g;
  private List<ScanResult> i;
  private final Runnable j;
  private final Object k = new Object();
  
  public dw(da paramda)
  {
    this.b = paramda;
    this.c = paramda.d();
    this.g = new HashSet();
    this.j = new Runnable()
    {
      public final void run()
      {
        dw.a(dw.this);
        long l = dw.b(dw.this).i().m;
        dw.a(dw.this, l);
        f.a.b("TxWifiProvider", "Interval:" + l);
      }
    };
  }
  
  private void a(long paramLong)
  {
    f.a.b("TxWifiProvider", "ScanInterval:" + paramLong);
    Handler localHandler = h;
    Runnable localRunnable = this.j;
    localHandler.removeCallbacks(localRunnable);
    localHandler.postDelayed(localRunnable, paramLong);
  }
  
  private void a(List<ScanResult> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      e();
    }
    for (;;)
    {
      long l1 = this.f;
      this.c.getWifiState();
      paramList = new ee(paramList, l1);
      this.b.b(paramList);
      return;
      if (es.a)
      {
        es.a = false;
        e();
      }
    }
  }
  
  private boolean c()
  {
    if ((!es.b(this.b)) || (this.d))
    {
      f.a.b("TxWifiProvider", "no try scan ,return!!");
      return false;
    }
    return es.a(this.c);
  }
  
  private void d()
  {
    f.a.b("TxWifiProvider", Thread.currentThread().getName());
    if (this.g == null) {
      this.g = new HashSet();
    }
    ScanResult localScanResult;
    if (this.g.size() == 0)
    {
      localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        localScanResult = (ScanResult)localIterator.next();
        this.g.add(localScanResult.toString());
      }
      this.f = System.currentTimeMillis();
      f.a.b("TxWifiProvider", "first receiver");
      a(this.i);
      return;
    }
    int m = this.g.size();
    if (m != this.i.size())
    {
      this.g.clear();
      localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        localScanResult = (ScanResult)localIterator.next();
        this.g.add(localScanResult.BSSID + localScanResult.level);
      }
      this.f = System.currentTimeMillis();
      f.a.b("TxWifiProvider", "size not same");
      a(this.i);
      return;
    }
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      localScanResult = (ScanResult)localIterator.next();
      this.g.add(localScanResult.BSSID + localScanResult.level);
    }
    if (m != this.g.size())
    {
      this.g.clear();
      localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        localScanResult = (ScanResult)localIterator.next();
        this.g.add(localScanResult.BSSID + localScanResult.level);
      }
      this.f = System.currentTimeMillis();
      f.a.b("TxWifiProvider", "size same,but mac is not same");
      a(this.i);
      return;
    }
    f.a.b("TxWifiProvider", "size same,mac and rssi same");
  }
  
  private void e()
  {
    m = 1;
    n = this.c.getWifiState();
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
          if (!this.b.e().isProviderEnabled("network"))
          {
            boolean bool = this.b.e().isProviderEnabled("gps");
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
        this.b.b(ee.a);
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
      h.removeCallbacksAndMessages(null);
    }
    try
    {
      this.b.a.unregisterReceiver(this);
      f.a.b("TxWifiProvider", "unregisterReceiver success");
      this.f = 0L;
      this.g = null;
      if (this.i != null) {
        this.i.clear();
      }
      if (this.g != null) {
        this.g.clear();
      }
      f.a.a("TxWifiProvider", "shutdown: state=[shutdown]");
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        f.a.b("TxWifiProvider", "unregisterReceiver failed");
      }
    }
  }
  
  public final void a(Handler paramHandler, boolean paramBoolean)
  {
    if (this.a) {
      return;
    }
    this.a = true;
    this.e = false;
    this.d = paramBoolean;
    h = paramHandler;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
    try
    {
      this.b.a.registerReceiver(this, localIntentFilter, null, paramHandler);
      if (!this.d) {
        a(0L);
      }
      f.a.a("TxWifiProvider", "startup: state=[start]");
      return;
    }
    catch (Exception paramHandler)
    {
      for (;;)
      {
        f.a.a("TxWifiProvider", "listenWifiState: failed", paramHandler);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final int b()
  {
    if (c()) {
      return 0;
    }
    return 1;
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
        f.a.a("TxWifiProvider", "onReceive " + paramContext);
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramContext)) {
          e();
        }
        if (("android.net.wifi.WIFI_STATE_CHANGED".equals(paramContext)) || ("android.net.wifi.SCAN_RESULTS".equals(paramContext)))
        {
          paramContext = es.b(this.c);
          if ((paramContext == null) || (paramContext.size() <= 0)) {
            break label175;
          }
          this.i = new ArrayList(paramContext);
          paramContext = this.i;
          dx.a(this.i);
          paramContext = this.i;
          if ((this.i != null) && (this.i.size() > 0))
          {
            Collections.sort(this.i, l);
            d();
          }
        }
        return;
      }
      paramIntent = new StringBuilder("ScanResult list is ");
    }
    catch (Exception paramContext)
    {
      f.a.b("TxWifiProvider", paramContext.toString());
      return;
    }
    label175:
    if (paramContext == null) {}
    for (paramContext = "null";; paramContext = "size=0")
    {
      f.a.a("TxWifiProvider", paramContext);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dw
 * JD-Core Version:    0.7.0.1
 */