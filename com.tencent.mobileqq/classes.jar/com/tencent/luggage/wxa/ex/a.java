package com.tencent.luggage.wxa.ex;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.wxa.hd.c;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.pc.l.a;
import com.tencent.luggage.wxa.pg.a.a;
import com.tencent.luggage.wxa.pg.a.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationListener;
import com.tencent.map.geolocation.sapp.TencentLocationManager;
import com.tencent.map.geolocation.sapp.TencentLocationRequest;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
  implements com.tencent.luggage.wxa.pg.a
{
  TencentLocationListener a = new a.2(this);
  private volatile TencentLocationManager b;
  @SuppressLint({"NewApi"})
  private final List<a.b> c = new CopyOnWriteArrayList();
  @SuppressLint({"NewApi"})
  private final List<a.b> d = new CopyOnWriteArrayList();
  @SuppressLint({"NewApi"})
  private final List<a.b> e = new CopyOnWriteArrayList();
  @SuppressLint({"NewApi"})
  private final List<a.b> f = new CopyOnWriteArrayList();
  private Set<String> g = new HashSet();
  private Runnable h = new a.3(this);
  
  public a()
  {
    o.d("MicroMsg.DefaultTencentLocationManager", "DefaultTencentLocationManager() construct in process %s", new Object[] { r.c() });
  }
  
  private a.a a(TencentLocation paramTencentLocation, boolean paramBoolean)
  {
    a.a locala = new a.a();
    if (paramBoolean)
    {
      locala.a = paramTencentLocation.getLatitude();
      locala.b = paramTencentLocation.getLongitude();
    }
    else
    {
      double d1 = paramTencentLocation.getLatitude();
      double d2 = paramTencentLocation.getLongitude();
      double[] arrayOfDouble = new double[2];
      TencentLocationUtils.wgs84ToGcj02(new double[] { d1, d2 }, arrayOfDouble);
      locala.a = arrayOfDouble[0];
      locala.b = arrayOfDouble[1];
    }
    locala.c = c(paramTencentLocation.getProvider());
    locala.d = paramTencentLocation.getSpeed();
    locala.e = paramTencentLocation.getAccuracy();
    locala.f = paramTencentLocation.getAltitude();
    locala.j = paramTencentLocation.getIndoorLocationType();
    locala.k = paramTencentLocation.getBearing();
    if (paramTencentLocation.getExtra() != null) {
      locala.l = paramTencentLocation.getExtra().getDouble("steps");
    }
    o.f("MicroMsg.DefaultTencentLocationManager", "buildingId:%s floorName:%s steps:%f", new Object[] { paramTencentLocation.getIndoorBuildingId(), paramTencentLocation.getIndoorBuildingFloor(), Double.valueOf(locala.l) });
    if (!af.c(paramTencentLocation.getIndoorBuildingId()))
    {
      locala.g = paramTencentLocation.getIndoorBuildingId();
      locala.h = paramTencentLocation.getIndoorBuildingFloor();
      return locala;
    }
    locala.g = "";
    locala.h = "";
    return locala;
  }
  
  private void a(List<a.b> paramList, int paramInt, String paramString, a.a parama)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a.b localb = (a.b)paramList.next();
      if (localb != null) {
        localb.a(paramInt, paramString, parama);
      }
    }
  }
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((String)localIterator.next());
    }
    o.e("MicroMsg.DefaultTencentLocationManager", "MapReport reportMsg:%s", new Object[] { localStringBuilder.toString() });
    return localStringBuilder.toString();
  }
  
  private String c(String paramString)
  {
    if ("gps".equals(paramString)) {
      return "gps";
    }
    return "network";
  }
  
  private void c()
  {
    if ((this.d.size() <= 0) && (this.c.size() <= 0) && (this.e.size() <= 0) && (this.f.size() <= 0))
    {
      o.d("MicroMsg.DefaultTencentLocationManager", "releaseLocationManager");
      getLocationManager().removeUpdates(null);
    }
  }
  
  void a(String paramString)
  {
    if (af.c(paramString)) {
      return;
    }
    this.g.add(paramString);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  void b(String paramString)
  {
    this.g.remove(paramString);
  }
  
  public void getLocation(String paramString, a.b paramb, Bundle paramBundle)
  {
    if ("wgs84".equals(paramString)) {
      this.c.add(paramb);
    } else {
      this.d.add(paramb);
    }
    l.a().b(this.h);
    l.a().a(this.h, 20000L);
    boolean bool1 = paramBundle.getBoolean("enableIndoor");
    boolean bool2 = paramBundle.getBoolean("isHighAccuracy", false);
    int i = paramBundle.getInt("highAccuracyExpireTime", 3000);
    paramString = TencentLocationRequest.create();
    paramString.setInterval(2000L);
    paramString.setIndoorLocationMode(bool1);
    paramString.setSmallAppKey(paramBundle.getString("smallAppKey"));
    paramString.setmExpirationTime(i);
    i = getLocationManager().requestSingleFreshLocation(paramString, this.a, Looper.getMainLooper(), bool2);
    o.e("MicroMsg.DefaultTencentLocationManager", "MapReport:%s getLocation", new Object[] { paramBundle.getString("smallAppKey") });
    o.d("MicroMsg.DefaultTencentLocationManager", "requestCode %d", new Object[] { Integer.valueOf(i) });
  }
  
  public TencentLocationManager getLocationManager()
  {
    if (this.b == null) {
      try
      {
        if (this.b == null)
        {
          if (a())
          {
            Object localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(com.tencent.luggage.wxa.hz.a.d());
            ((StringBuilder)localObject1).append("/lbs");
            ((StringBuilder)localObject1).append(r.c().substring(r.b().length() + 1));
            localObject1 = new i(k.c(((StringBuilder)localObject1).toString(), true));
            try
            {
              TencentExtraKeys.setTencentLog(r.a(), new File(k.c(((i)localObject1).b(), true)));
            }
            catch (Exception localException1)
            {
              o.h("MicroMsg.DefaultTencentLocationManager", "", new Object[] { localException1 });
            }
          }
          TencentExtraKeys.setContext(r.a());
          try
          {
            TencentExtraKeys.setTencentLogCallback(new a.1(this));
          }
          catch (Exception localException2)
          {
            o.h("MicroMsg.DefaultTencentLocationManager", "", new Object[] { localException2 });
          }
          String str = c.a();
          if (TextUtils.isEmpty(str)) {
            this.b = TencentLocationManager.getInstance(r.a());
          } else {
            this.b = TencentLocationManager.getInstance(r.a(), new Pair("oaId", str));
          }
          this.b.setCoordinateType(0);
          o.d("MicroMsg.DefaultTencentLocationManager", "%s Location Sdk Version %s", new Object[] { str, this.b.getVersion() });
        }
      }
      finally {}
    }
    return this.b;
  }
  
  public boolean registerLocation(String paramString, a.b paramb, Bundle paramBundle)
  {
    try
    {
      o.d("MicroMsg.DefaultTencentLocationManager", "[registerLocation]type:%s", new Object[] { paramString });
      a.b localb;
      if ("wgs84".equals(paramString))
      {
        paramString = this.e.iterator();
        while (paramString.hasNext())
        {
          localb = (a.b)paramString.next();
          if ((localb != null) && (localb.equals(paramb)))
          {
            o.c("MicroMsg.DefaultTencentLocationManager", "already register");
            return false;
          }
        }
        this.e.add(paramb);
      }
      else
      {
        paramString = this.f.iterator();
        while (paramString.hasNext())
        {
          localb = (a.b)paramString.next();
          if ((localb != null) && (localb.equals(paramb)))
          {
            o.c("MicroMsg.DefaultTencentLocationManager", "already register");
            return false;
          }
        }
        this.f.add(paramb);
      }
      if (paramBundle != null) {
        a(paramBundle.getString("smallAppKey"));
      }
      if ((paramBundle == null) || (!paramBundle.getBoolean("enableIndoor"))) {
        break label317;
      }
      bool = true;
    }
    finally
    {
      for (;;)
      {
        long l;
        for (;;)
        {
          throw paramString;
        }
        label317:
        boolean bool = false;
        continue;
        int i = 0;
        label326:
        if (i == 0) {
          if (bool)
          {
            continue;
            label339:
            l = 2000L;
          }
        }
      }
    }
    if (this.e.size() + this.f.size() == 1)
    {
      i = 1;
      break label326;
      paramString = TencentLocationRequest.create();
      paramString.setIndoorLocationMode(bool);
      if (!bool) {
        break label339;
      }
      l = 1000L;
      paramString.setInterval(l);
      paramString.setSmallAppKey(b());
      o.d("MicroMsg.DefaultTencentLocationManager", "requestCode %d", new Object[] { Integer.valueOf(getLocationManager().requestLocationUpdates(paramString, this.a, Looper.getMainLooper())) });
      return false;
    }
  }
  
  public boolean unregisterLocation(String paramString, a.b paramb, Bundle paramBundle)
  {
    try
    {
      o.d("MicroMsg.DefaultTencentLocationManager", "[unregisterLocation]type:%s", new Object[] { paramString });
      if ("wgs84".equals(paramString)) {
        this.e.remove(paramb);
      } else {
        this.f.remove(paramb);
      }
      if (paramBundle != null) {
        b(paramBundle.getString("smallAppKey"));
      }
      c();
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ex.a
 * JD-Core Version:    0.7.0.1
 */