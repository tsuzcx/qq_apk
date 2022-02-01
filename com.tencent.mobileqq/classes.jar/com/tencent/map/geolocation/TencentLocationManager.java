package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import c.t.m.g.co;
import c.t.m.g.dp;
import c.t.m.g.du;
import c.t.m.g.dy;
import c.t.m.g.ea;
import c.t.m.g.eh;
import c.t.m.g.ek;
import c.t.m.g.el;
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
  private final ek c;
  
  private TencentLocationManager(Context paramContext)
  {
    dp.a(paramContext);
    dp.b();
    this.b = ea.a(paramContext);
    this.c = new ek(this.b);
  }
  
  public static TencentLocationManager getInstance(Context paramContext)
  {
    try
    {
      if (d == null) {
        if (paramContext != null)
        {
          if (paramContext.getApplicationContext() != null)
          {
            if (Looper.myLooper() != null) {
              d = new TencentLocationManager(paramContext.getApplicationContext());
            } else {
              throw new IllegalArgumentException("getInstance must be use in Thread with looper. Please first use Looper.prapare()");
            }
          }
          else {
            throw new NullPointerException("application context is null");
          }
        }
        else {
          throw new NullPointerException("context is null");
        }
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  public final int clearPedometerData()
  {
    return this.c.b();
  }
  
  public final String getBuild()
  {
    du localdu = this.b.e();
    if (localdu != null) {
      return localdu.e();
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
    ek localek = this.c;
    if (localek.m == 0)
    {
      localek.a(localek.l);
      return localek.l;
    }
    return null;
  }
  
  public final int getPedometerData()
  {
    ek localek = this.c;
    if (localek.c != null) {
      return localek.c.h;
    }
    return -1;
  }
  
  public final TencentPedestrianData getPedometerDataFromLastCheck()
  {
    return this.c.c();
  }
  
  public final String getVersion()
  {
    du localdu = this.b.e();
    if (localdu != null) {
      return localdu.d();
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
    if (paramTencentLocationRequest != null)
    {
      if (paramTencentLocationListener != null)
      {
        if (paramLooper != null) {
          synchronized (this.a)
          {
            int i = this.c.a(paramTencentLocationRequest, paramTencentLocationListener, paramLooper);
            return i;
          }
        }
        throw new NullPointerException("looper is null");
      }
      throw new NullPointerException("listener is null");
    }
    throw new NullPointerException("request is null");
  }
  
  public final void setCoordinateType(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 0)) {
      throw new IllegalArgumentException("unknown coordinate type: ".concat(String.valueOf(paramInt)));
    }
    synchronized (this.a)
    {
      ek localek = this.c;
      if (localek.a != paramInt) {
        localek.a = paramInt;
      }
      return;
    }
  }
  
  public final void setDeviceID(Pair<String, String> paramPair)
  {
    if (paramPair != null)
    {
      if (((((String)paramPair.first).equals("qImei")) || (((String)paramPair.first).equals("oaId")) || (((String)paramPair.first).matches("^[a-z0-9A-Z]{6,32}$"))) && (!TextUtils.isEmpty((CharSequence)paramPair.second)))
      {
        du localdu = this.b.b;
        dy.a("LocationSDK", "location_device_id_type", paramPair.first);
        dy.a("LocationSDK", "location_device_id", paramPair.second);
        localdu.p = paramPair;
        return;
      }
      throw new IllegalArgumentException("your deviceID is illegal!");
    }
    throw new IllegalArgumentException("deviceID is null!");
  }
  
  public final void setKey(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      this.b.b.g = paramString;
      return;
    }
    throw new IllegalArgumentException("bad key: ".concat(String.valueOf(paramString)));
  }
  
  public final int startDirectionUpdates(TencentDirectionListener paramTencentDirectionListener, Looper paramLooper)
  {
    if (paramTencentDirectionListener != null)
    {
      if (paramLooper != null)
      {
        ek localek = this.c;
        if ((paramTencentDirectionListener != null) && (paramLooper != null))
        {
          if (localek.b == null) {
            return -2;
          }
          localek.b.a();
          paramLooper = new Handler(paramLooper);
          int i = localek.b.a(paramLooper, paramTencentDirectionListener);
          if (i == 0) {
            localek.b.a = true;
          }
          return i;
        }
        return -1;
      }
      throw new NullPointerException("looper is null");
    }
    throw new NullPointerException("listener is null");
  }
  
  public final int startDistanceCalculate(TencentDistanceListener paramTencentDistanceListener)
  {
    if (paramTencentDistanceListener != null) {
      synchronized (this.a)
      {
        ek localek = this.c;
        TencentLocationListener localTencentLocationListener = localek.d;
        int i = 1;
        if (localTencentLocationListener != null) {
          if (localek.e)
          {
            i = 2;
          }
          else
          {
            localek.e = true;
            localek.k = paramTencentDistanceListener;
            i = 0;
          }
        }
        return i;
      }
    }
    throw new NullPointerException("listener is null");
  }
  
  public final void stopDirectionUpdate()
  {
    ek localek = this.c;
    if (localek.b != null) {
      localek.b.a();
    }
  }
  
  public final TencentDistanceAnalysis stopDistanceCalculate(TencentDistanceListener arg1)
  {
    synchronized (this.a)
    {
      ek localek = this.c;
      localek.k = null;
      localek.f = 0.0D;
      localek.e = false;
      localek.j = null;
      fc localfc = new fc();
      double d1 = localek.g + 1;
      int i = localek.i;
      double d2 = i + 1;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      localfc.a = (fp.a(d1, 4) * 100.0D);
      localfc.b = localek.g;
      localfc.c = localek.h;
      localek.g = 0;
      localek.h = 0;
      localek.i = 0;
      return localfc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationManager
 * JD-Core Version:    0.7.0.1
 */