package com.tencent.map.sdk.a;

import android.os.Handler;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import org.json.JSONArray;

public final class kj
  implements hb, mg
{
  public gc a;
  public hh b;
  boolean c;
  public pn d;
  TencentMap.OnIndoorStateChangeListener e;
  public Handler f;
  public pm g;
  public boolean h;
  public IndoorBuilding i;
  
  public kj(pn parampn, String paramString)
  {
    Object localObject = null;
    this.e = null;
    this.f = new Handler();
    this.g = null;
    this.h = false;
    this.i = null;
    this.d = parampn;
    parampn = this.d;
    if (parampn != null)
    {
      if (paramString == null) {
        this.a = gf.a(parampn.ay);
      } else {
        this.a = ge.a(parampn.ay, paramString);
      }
      int j = this.a.b("AIEnabled");
      int k = this.a.b("AIType");
      try
      {
        parampn = new JSONArray(this.a.a("AIBuildingList"));
      }
      catch (Exception parampn)
      {
        or.a("indoor auth init failed", parampn);
        parampn = localObject;
      }
      if ((j != -1) && (k != -1) && (parampn != null)) {
        this.b = new hh(j, k, parampn);
      }
      parampn = this.g;
      if ((parampn != null) && (k == 1)) {
        parampn.a(a());
      }
      this.c = false;
      a(this.c);
      this.g = this.d.az;
    }
    parampn = this.g;
    if (parampn != null)
    {
      parampn.a(this);
      this.g.b.a(this);
      this.e = new pj(this.d);
    }
  }
  
  private boolean d()
  {
    hh localhh = this.b;
    return (localhh != null) && (localhh.a == 1);
  }
  
  public final void a(int paramInt)
  {
    if (this.c)
    {
      pn localpn = this.d;
      if ((localpn != null) && (localpn.az != null))
      {
        if (this.d.n == null) {
          return;
        }
        if (this.h)
        {
          this.d.n.a(true);
          return;
        }
        this.d.n.a(false);
        c();
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (this.g == null) {
      return;
    }
    if (!d())
    {
      this.g.b(false);
      return;
    }
    Object localObject = this.d;
    if ((localObject != null) && (((pn)localObject).n != null)) {
      this.d.n.a(paramBoolean);
    }
    this.g.b(paramBoolean);
    if ((!paramBoolean) && (this.h))
    {
      this.h = false;
      this.i = null;
      localObject = this.e;
      if (localObject != null) {
        ((TencentMap.OnIndoorStateChangeListener)localObject).onIndoorBuildingDeactivated();
      }
    }
  }
  
  public final String[] a()
  {
    hh localhh = this.b;
    if (localhh != null) {
      return localhh.d;
    }
    return null;
  }
  
  public final void b()
  {
    if (this.c)
    {
      Object localObject1 = this.d;
      if (localObject1 != null)
      {
        if (((pt)localObject1).az == null) {
          return;
        }
        localObject1 = this.d.az;
        Object localObject2 = new GeoPoint();
        localObject1 = ((pm)localObject1).b.a.b((GeoPoint)localObject2);
        if (localObject1 == null) {
          return;
        }
        double d1 = ((GeoPoint)localObject2).getLatitudeE6();
        Double.isNaN(d1);
        d1 = d1 * 1.0D / 1000000.0D;
        double d2 = ((GeoPoint)localObject2).getLongitudeE6();
        Double.isNaN(d2);
        localObject2 = new LatLng(d1, d2 * 1.0D / 1000000.0D);
        String str1 = ((ii)localObject1).a;
        String str2 = ((ii)localObject1).b;
        String[] arrayOfString = ((ii)localObject1).d;
        int j = ((ii)localObject1).c;
        this.f.post(new kj.2(this, str1, str2, (LatLng)localObject2, arrayOfString, j));
      }
    }
  }
  
  final void c()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((pt)localObject).az != null))
    {
      if (this.h) {
        return;
      }
      localObject = this.d.az;
      int j = Math.min(20, this.d.g);
      if (((pm)localObject).e() < j) {
        ((pm)localObject).e(j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.kj
 * JD-Core Version:    0.7.0.1
 */