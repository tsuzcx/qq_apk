package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import c.t.m.g.co;
import c.t.m.g.do;
import c.t.m.g.dr;
import c.t.m.g.dx;
import c.t.m.g.ee;
import c.t.m.g.eh;
import c.t.m.g.ei;
import c.t.m.g.ez;
import c.t.m.g.fm;

public final class TencentLocationManager
{
  public static final int COORDINATE_TYPE_GCJ02 = 1;
  public static final int COORDINATE_TYPE_WGS84 = 0;
  private static TencentLocationManager d;
  private final byte[] a = new byte[0];
  private final dx b;
  private final eh c;
  
  private TencentLocationManager(Context paramContext)
  {
    do.a(paramContext);
    this.b = dx.a(paramContext);
    this.c = new eh(this.b);
  }
  
  public static TencentLocationManager getInstance(Context paramContext)
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
    dr localdr = this.b.e();
    if (localdr != null) {
      return localdr.e();
    }
    return "None";
  }
  
  public final int getCoordinateType()
  {
    return this.c.a;
  }
  
  public final String getKey()
  {
    return co.d(this.b.b.g);
  }
  
  public final TencentLocation getLastKnownLocation()
  {
    eh localeh = this.c;
    if (localeh.m == 0)
    {
      localeh.a(localeh.l);
      return localeh.l;
    }
    return null;
  }
  
  public final int getPedometerData()
  {
    eh localeh = this.c;
    if (localeh.c != null) {
      return localeh.c.h;
    }
    return -1;
  }
  
  public final TencentPedestrianData getPedometerDataFromLastCheck()
  {
    return this.c.c();
  }
  
  public final String getVersion()
  {
    dr localdr = this.b.e();
    if (localdr != null) {
      return localdr.d();
    }
    return "None";
  }
  
  public final boolean isSupportPedometer()
  {
    return this.c.a();
  }
  
  public final void removeUpdates(TencentLocationListener arg1)
  {
    new StringBuilder("remove location update,thread name:").append(Thread.currentThread().getName());
    synchronized (this.a)
    {
      this.c.d();
      return;
    }
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener)
  {
    new StringBuilder("request location with no looper,thread name:").append(Thread.currentThread().getName());
    return requestLocationUpdates(paramTencentLocationRequest, paramTencentLocationListener, Looper.myLooper());
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    new StringBuilder("request location with looper,thread name:").append(Thread.currentThread().getName());
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
        eh localeh = this.c;
        if (localeh.a != paramInt) {
          localeh.a = paramInt;
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
    eh localeh = this.c;
    int i;
    if ((paramTencentDirectionListener == null) || (paramLooper == null)) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      if (localeh.b == null) {
        return -2;
      }
      localeh.b.a();
      paramLooper = new Handler(paramLooper);
      j = localeh.b.a(paramLooper, paramTencentDirectionListener);
      i = j;
    } while (j != 0);
    localeh.b.a = true;
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
      eh localeh = this.c;
      if (localeh.d == null) {}
      for (;;)
      {
        return i;
        if (!localeh.e) {
          break;
        }
        i = 2;
      }
      localeh.e = true;
      localeh.k = paramTencentDistanceListener;
      i = 0;
    }
  }
  
  public final void stopDirectionUpdate()
  {
    eh localeh = this.c;
    if (localeh.b != null) {
      localeh.b.a();
    }
  }
  
  public final TencentDistanceAnalysis stopDistanceCalculate(TencentDistanceListener arg1)
  {
    synchronized (this.a)
    {
      eh localeh = this.c;
      localeh.k = null;
      localeh.f = 0.0D;
      localeh.e = false;
      localeh.j = null;
      ez localez = new ez();
      localez.a = (fm.a((localeh.g + 1) / (localeh.i + 1), 4) * 100.0D);
      localez.b = localeh.g;
      localez.c = localeh.h;
      localeh.g = 0;
      localeh.h = 0;
      localeh.i = 0;
      return localez;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationManager
 * JD-Core Version:    0.7.0.1
 */