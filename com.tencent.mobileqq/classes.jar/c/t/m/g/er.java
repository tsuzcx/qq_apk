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

final class er
  extends BroadcastReceiver
{
  static Handler e;
  private static final Comparator<ScanResult> l = new er.2();
  volatile boolean a;
  final ea b;
  boolean c;
  volatile boolean d = false;
  private final WifiManager f;
  private long g;
  private HashSet<String> h;
  private List<ScanResult> i;
  private final Runnable j;
  private final Object k = new Object();
  
  public er(ea paramea)
  {
    this.b = paramea;
    this.f = paramea.g;
    this.h = new HashSet();
    this.j = new er.1(this);
  }
  
  private void a(List<ScanResult> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (fq.a)
      {
        fq.a = false;
        d();
      }
    }
    else {
      d();
    }
    paramList = new ex(paramList, this.g, this.f.getWifiState());
    this.b.b(paramList);
  }
  
  private void c()
  {
    Thread.currentThread().getName();
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
      a(this.i);
      return;
    }
    int m = this.h.size();
    HashSet localHashSet;
    StringBuilder localStringBuilder;
    if (m != this.i.size())
    {
      this.h.clear();
      localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        localScanResult = (ScanResult)localIterator.next();
        localHashSet = this.h;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localScanResult.BSSID);
        localStringBuilder.append(localScanResult.level);
        localHashSet.add(localStringBuilder.toString());
      }
      this.g = System.currentTimeMillis();
      a(this.i);
      return;
    }
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      localScanResult = (ScanResult)localIterator.next();
      localHashSet = this.h;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localScanResult.BSSID);
      localStringBuilder.append(localScanResult.level);
      localHashSet.add(localStringBuilder.toString());
    }
    if (m != this.h.size())
    {
      this.h.clear();
      localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        localScanResult = (ScanResult)localIterator.next();
        localHashSet = this.h;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localScanResult.BSSID);
        localStringBuilder.append(localScanResult.level);
        localHashSet.add(localStringBuilder.toString());
      }
      this.g = System.currentTimeMillis();
      a(this.i);
    }
  }
  
  private void d()
  {
    n = this.f.getWifiState();
    m = 1;
    if (n == 3)
    {
      a(0L);
    }
    else if (n == 1)
    {
      m = 0;
      localObject = this.i;
      if (localObject != null) {
        ((List)localObject).clear();
      }
      this.b.b(ex.a);
    }
    else
    {
      m = -1;
    }
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
        n = m;
      }
    }
    Object localObject = new Message();
    ((Message)localObject).what = 12999;
    ((Message)localObject).arg1 = 12001;
    ((Message)localObject).arg2 = n;
    this.b.b(localObject);
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
      new StringBuilder("unregister system wifi provider,thread name:").append(Thread.currentThread().getName());
      label59:
      this.g = 0L;
      this.h = null;
      if (this.i != null) {
        this.i.clear();
      }
      if (this.h != null) {
        this.h.clear();
      }
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (Exception localException)
    {
      break label59;
    }
  }
  
  final void a(long paramLong)
  {
    Handler localHandler = e;
    Runnable localRunnable = this.j;
    localHandler.removeCallbacks(localRunnable);
    localHandler.postDelayed(localRunnable, paramLong);
  }
  
  final boolean b()
  {
    if ((fq.b(this.b)) && (!this.c)) {
      return fq.a(this.f);
    }
    return false;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    label163:
    for (;;)
    {
      try
      {
        synchronized (this.k)
        {
          paramContext = paramIntent.getAction();
          if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramContext)) {
            d();
          }
          if (("android.net.wifi.WIFI_STATE_CHANGED".equals(paramContext)) || ("android.net.wifi.SCAN_RESULTS".equals(paramContext)))
          {
            paramContext = fq.b(this.f);
            if ((paramContext != null) && (paramContext.size() > 0))
            {
              this.i = new ArrayList(paramContext);
              es.a(this.i);
              if ((this.i != null) && (this.i.size() > 0))
              {
                Collections.sort(this.i, l);
                c();
              }
            }
            else
            {
              paramIntent = new StringBuilder("ScanResult list is ");
              if (paramContext != null) {
                break label163;
              }
              paramContext = "null";
              paramIntent.append(paramContext);
            }
          }
          return;
        }
        paramContext = "size=0";
      }
      catch (Exception paramContext)
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.er
 * JD-Core Version:    0.7.0.1
 */