package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Looper;
import c.t.m.g.da;
import c.t.m.g.db;
import c.t.m.g.do;
import c.t.m.g.f.a;

public final class TencentLocationManager
{
  public static final int COORDINATE_TYPE_GCJ02 = 1;
  public static final int COORDINATE_TYPE_WGS84 = 0;
  private static TencentLocationManager d;
  private final byte[] a = new byte[0];
  private final da b;
  private final do c;
  
  private TencentLocationManager(Context paramContext)
  {
    this.b = da.a(paramContext);
    this.c = new do(this.b);
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
    return this.c.e();
  }
  
  public final String getBuild()
  {
    db localdb = this.b.j();
    if (localdb != null) {
      return localdb.e();
    }
    return "None";
  }
  
  public final int getCoordinateType()
  {
    return this.c.i();
  }
  
  public final String getKey()
  {
    return f.a.c(this.b.i().h);
  }
  
  public final TencentLocation getLastKnownLocation()
  {
    return this.c.b();
  }
  
  public final int getPedometerData()
  {
    return this.c.d();
  }
  
  public final TencentPedestrianData getPedometerDataFromLastCheck()
  {
    return this.c.f();
  }
  
  public final String getVersion()
  {
    db localdb = this.b.j();
    if (localdb != null) {
      return localdb.d();
    }
    return "None";
  }
  
  public final boolean isSupportPedometer()
  {
    return this.c.c();
  }
  
  public final void removeUpdates(TencentLocationListener arg1)
  {
    synchronized (this.a)
    {
      this.c.h();
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
        this.c.a(paramInt);
        return;
      }
    }
    throw new IllegalArgumentException("unknown coordinate type: " + paramInt);
  }
  
  public final void setKey(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      throw new IllegalArgumentException("bad key: " + paramString);
    }
    this.b.i().h = paramString;
  }
  
  public final int startDirectionUpdates(TencentDirectionListener paramTencentDirectionListener, Looper paramLooper)
  {
    if (paramTencentDirectionListener == null) {
      throw new NullPointerException("listener is null");
    }
    if (paramLooper == null) {
      throw new NullPointerException("looper is null");
    }
    return this.c.a(paramTencentDirectionListener, paramLooper);
  }
  
  public final int startDistanceCalculate(TencentDistanceListener paramTencentDistanceListener)
  {
    if (paramTencentDistanceListener == null) {
      throw new NullPointerException("listener is null");
    }
    synchronized (this.a)
    {
      int i = this.c.a(paramTencentDistanceListener);
      return i;
    }
  }
  
  public final void stopDirectionUpdate()
  {
    this.c.a();
  }
  
  public final TencentDistanceAnalysis stopDistanceCalculate(TencentDistanceListener arg1)
  {
    synchronized (this.a)
    {
      TencentDistanceAnalysis localTencentDistanceAnalysis = this.c.g();
      return localTencentDistanceAnalysis;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationManager
 * JD-Core Version:    0.7.0.1
 */