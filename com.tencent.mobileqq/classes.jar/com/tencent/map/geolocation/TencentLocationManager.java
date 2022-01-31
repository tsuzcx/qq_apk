package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import c.t.m.g.co;
import c.t.m.g.dp;
import c.t.m.g.dy;
import c.t.m.g.ea;
import c.t.m.g.eb;
import c.t.m.g.ei;
import c.t.m.g.el;
import c.t.m.g.em;
import c.t.m.g.fc;
import c.t.m.g.fp;

public final class TencentLocationManager
{
  public static final int COORDINATE_TYPE_GCJ02 = 1;
  public static final int COORDINATE_TYPE_WGS84 = 0;
  public static final String TYPE_OAID = "oaId";
  public static final String TYPE_QIMEI = "qImei";
  private static TencentLocationManager d;
  private final byte[] a = new byte[0];
  private final ea b;
  private final el c;
  
  private TencentLocationManager(Context paramContext)
  {
    dp.a(paramContext);
    dp.b();
    this.b = ea.a(paramContext);
    this.c = new el(this.b);
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
    eb localeb = this.b.e();
    if (localeb != null) {
      return localeb.e();
    }
    return "None";
  }
  
  public final int getCoordinateType()
  {
    return this.c.a;
  }
  
  public final String getKey()
  {
    return co.e(this.b.b.g);
  }
  
  public final TencentLocation getLastKnownLocation()
  {
    el localel = this.c;
    if (localel.m == 0)
    {
      localel.a(localel.l);
      return localel.l;
    }
    return null;
  }
  
  public final int getPedometerData()
  {
    el localel = this.c;
    if (localel.c != null) {
      return localel.c.h;
    }
    return -1;
  }
  
  public final TencentPedestrianData getPedometerDataFromLastCheck()
  {
    return this.c.c();
  }
  
  public final String getVersion()
  {
    eb localeb = this.b.e();
    if (localeb != null) {
      return localeb.d();
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
        el localel = this.c;
        if (localel.a != paramInt) {
          localel.a = paramInt;
        }
        return;
      }
    }
    throw new IllegalArgumentException("unknown coordinate type: ".concat(String.valueOf(paramInt)));
  }
  
  public final void setDeviceID(Pair<String, String> paramPair)
  {
    if (paramPair == null) {
      throw new IllegalArgumentException("deviceID is null!");
    }
    if (((!((String)paramPair.first).equals("qImei")) && (!((String)paramPair.first).equals("oaId")) && (!((String)paramPair.first).matches("^[a-z0-9A-Z]{6,32}$"))) || (TextUtils.isEmpty((CharSequence)paramPair.second))) {
      throw new IllegalArgumentException("your deviceID is illegal!");
    }
    eb localeb = this.b.b;
    dy.a("LocationSDK", "location_device_id_type", paramPair.first);
    dy.a("LocationSDK", "location_device_id", paramPair.second);
    localeb.p = paramPair;
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
    el localel = this.c;
    int i;
    if ((paramTencentDirectionListener == null) || (paramLooper == null)) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      if (localel.b == null) {
        return -2;
      }
      localel.b.a();
      paramLooper = new Handler(paramLooper);
      j = localel.b.a(paramLooper, paramTencentDirectionListener);
      i = j;
    } while (j != 0);
    localel.b.a = true;
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
      el localel = this.c;
      if (localel.d == null) {}
      for (;;)
      {
        return i;
        if (!localel.e) {
          break;
        }
        i = 2;
      }
      localel.e = true;
      localel.k = paramTencentDistanceListener;
      i = 0;
    }
  }
  
  public final void stopDirectionUpdate()
  {
    el localel = this.c;
    if (localel.b != null) {
      localel.b.a();
    }
  }
  
  public final TencentDistanceAnalysis stopDistanceCalculate(TencentDistanceListener arg1)
  {
    synchronized (this.a)
    {
      el localel = this.c;
      localel.k = null;
      localel.f = 0.0D;
      localel.e = false;
      localel.j = null;
      fc localfc = new fc();
      localfc.a = (fp.a((localel.g + 1) / (localel.i + 1), 4) * 100.0D);
      localfc.b = localel.g;
      localfc.c = localel.h;
      localel.g = 0;
      localel.h = 0;
      localel.i = 0;
      return localfc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationManager
 * JD-Core Version:    0.7.0.1
 */