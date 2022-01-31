package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import c.t.m.g.de;
import c.t.m.g.dp;
import c.t.m.g.ds;
import c.t.m.g.dt;
import c.t.m.g.el;
import c.t.m.g.ev;

public final class TencentLocationManager
{
  public static final int COORDINATE_TYPE_GCJ02 = 1;
  public static final int COORDINATE_TYPE_WGS84 = 0;
  private static TencentLocationManager d;
  private final byte[] a = new byte[0];
  private final de b;
  private final ds c;
  
  private TencentLocationManager(Context paramContext)
  {
    this.b = de.a(paramContext);
    this.c = new ds(this.b);
  }
  
  public static TencentLocationManager getInstance(Context paramContext)
    throws NullPointerException, IllegalArgumentException
  {
    try
    {
      if (d != null) {
        break label76;
      }
      if (paramContext == null) {
        throw new NullPointerException("context is null");
      }
    }
    finally {}
    if (paramContext.getApplicationContext() == null) {
      throw new NullPointerException("application context is null");
    }
    if (Looper.myLooper() == null) {
      throw new IllegalArgumentException("getInstance must be use in Thread with looper. Please first use Looper.prapare()");
    }
    d = new TencentLocationManager(paramContext.getApplicationContext());
    label76:
    paramContext = d;
    return paramContext;
  }
  
  public final int clearPedometerData()
  {
    return this.c.b();
  }
  
  public final String getBuild()
  {
    ev localev = this.b.e();
    if (localev != null) {
      return localev.e();
    }
    return "None";
  }
  
  public final int getCoordinateType()
  {
    return this.c.a;
  }
  
  public final String getKey()
  {
    return ev.c(this.b.b.g);
  }
  
  public final TencentLocation getLastKnownLocation()
  {
    ds localds = this.c;
    if (localds.m == 0)
    {
      localds.a(localds.l);
      return localds.l;
    }
    return null;
  }
  
  public final int getPedometerData()
  {
    ds localds = this.c;
    if (localds.c != null) {
      return localds.c.h;
    }
    return -1;
  }
  
  public final TencentPedestrianData getPedometerDataFromLastCheck()
  {
    return this.c.c();
  }
  
  public final String getVersion()
  {
    ev localev = this.b.e();
    if (localev != null) {
      return localev.d();
    }
    return "None";
  }
  
  public final boolean isSupportPedometer()
  {
    return this.c.a();
  }
  
  public final void removeUpdates(TencentLocationListener arg1)
  {
    synchronized (this.a)
    {
      this.c.d();
      return;
    }
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener)
  {
    return requestLocationUpdates(paramTencentLocationRequest, paramTencentLocationListener, Looper.myLooper());
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    if (paramTencentLocationRequest == null) {
      throw new NullPointerException("request is null");
    }
    if (paramTencentLocationListener == null) {
      throw new NullPointerException("listener is null");
    }
    if (paramLooper == null) {
      throw new NullPointerException("looper is null");
    }
    synchronized (this.a)
    {
      int i = this.c.a(paramTencentLocationRequest, paramTencentLocationListener, paramLooper);
      return i;
    }
  }
  
  public final void setCoordinateType(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0)) {
      synchronized (this.a)
      {
        ds localds = this.c;
        if (localds.a != paramInt) {
          localds.a = paramInt;
        }
        return;
      }
    }
    throw new IllegalArgumentException("unknown coordinate type: ".concat(String.valueOf(paramInt)));
  }
  
  public final void setKey(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      throw new IllegalArgumentException("bad key: ".concat(String.valueOf(paramString)));
    }
    this.b.b.g = paramString;
  }
  
  public final int startDirectionUpdates(TencentDirectionListener paramTencentDirectionListener, Looper paramLooper)
  {
    if (paramTencentDirectionListener == null) {
      throw new NullPointerException("listener is null");
    }
    if (paramLooper == null) {
      throw new NullPointerException("looper is null");
    }
    ds localds = this.c;
    int i;
    if ((paramTencentDirectionListener == null) || (paramLooper == null)) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      if (localds.b == null) {
        return -2;
      }
      localds.b.a();
      paramLooper = new Handler(paramLooper);
      j = localds.b.a(paramLooper, paramTencentDirectionListener);
      i = j;
    } while (j != 0);
    localds.b.a = true;
    return j;
  }
  
  public final int startDistanceCalculate(TencentDistanceListener paramTencentDistanceListener)
  {
    int i = 1;
    if (paramTencentDistanceListener == null) {
      throw new NullPointerException("listener is null");
    }
    synchronized (this.a)
    {
      ds localds = this.c;
      if (localds.d == null) {}
      for (;;)
      {
        return i;
        if (!localds.e) {
          break;
        }
        i = 2;
      }
      localds.e = true;
      localds.k = paramTencentDistanceListener;
      i = 0;
    }
  }
  
  public final void stopDirectionUpdate()
  {
    ds localds = this.c;
    if (localds.b != null) {
      localds.b.a();
    }
  }
  
  public final TencentDistanceAnalysis stopDistanceCalculate(TencentDistanceListener arg1)
  {
    synchronized (this.a)
    {
      ds localds = this.c;
      localds.k = null;
      localds.f = 0.0D;
      localds.e = false;
      localds.j = null;
      el localel = new el();
      localel.a = (ev.a((localds.g + 1) / (localds.i + 1), 4) * 100.0D);
      localel.b = localds.g;
      localel.c = localds.h;
      localds.g = 0;
      localds.h = 0;
      localds.i = 0;
      return localel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationManager
 * JD-Core Version:    0.7.0.1
 */