package com.tencent.map.sdk.a;

import android.text.TextUtils;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public final class lk
  implements ku, mb
{
  public pn a = null;
  
  public lk(IMapRenderView paramIMapRenderView)
  {
    this.a = ((pn)paramIMapRenderView.getVectorMapDelegate());
    if (this.a == null) {}
    while (this.a.a(mq.class) != null) {
      return;
    }
    this.a.a(mq.class, this);
  }
  
  public final Circle a(CircleOptions paramCircleOptions, kh paramkh)
  {
    if (this.a == null) {}
    mq localmq;
    do
    {
      return null;
      localmq = new mq(this.a);
      localmq.a(paramCircleOptions);
      localmq.d();
    } while (!this.a.a(localmq));
    this.a.az.b.k();
    return new Circle(paramCircleOptions, paramkh, localmq.L);
  }
  
  public final void a()
  {
    if (this.a != null) {
      this.a.c(mq.class);
    }
  }
  
  public final void a(String paramString)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.a(paramString, false);
      if ((paramString == null) || (!(paramString instanceof mq))) {
        return;
      }
    }
    paramString.h();
    this.a.az.b.k();
  }
  
  public final void a(String paramString, double paramDouble)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mq)) {
      return;
    }
    ((mq)paramString).a(paramDouble);
    this.a.az.b.k();
  }
  
  public final void a(String paramString, float paramFloat)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mq)) {
      return;
    }
    ((mq)paramString).a(paramFloat);
    this.a.az.b.k();
  }
  
  public final void a(String paramString, int paramInt)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mq)) {
      return;
    }
    ((mq)paramString).c(paramInt);
    this.a.az.b.k();
  }
  
  public final void a(String paramString, CircleOptions paramCircleOptions)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mq)) {
      return;
    }
    ((mq)paramString).a(paramCircleOptions);
    this.a.az.b.k();
  }
  
  public final void a(String paramString, LatLng paramLatLng)
  {
    if (this.a == null) {}
    while (paramLatLng == null) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mq)) {
      return;
    }
    ((mq)paramString).a(fz.a(paramLatLng));
    this.a.az.b.k();
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mq)) {
      return;
    }
    ((mq)paramString).c(paramBoolean);
    this.a.az.b.k();
  }
  
  public final boolean a(mu parammu, GeoPoint paramGeoPoint)
  {
    return false;
  }
  
  public final List<gg> b(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if ((paramString == null) || (!(paramString instanceof mq))) {
        return null;
      }
      paramString = (mq)paramString;
      ??? = new ArrayList(1);
      ((List)???).add(paramString);
      return ???;
    }
  }
  
  public final void b(String paramString, float paramFloat)
  {
    if (this.a == null) {
      return;
    }
    ??? = this.a.c(paramString);
    if (??? != null) {
      ((mu)???).b(paramFloat);
    }
    pn localpn = this.a;
    if ((paramString == null) || (paramString.equals("")))
    {
      this.a.az.b.k();
      return;
    }
    for (;;)
    {
      int j;
      int k;
      int i;
      label93:
      int m;
      label170:
      synchronized (localpn.a)
      {
        int n = localpn.h.size();
        j = 0;
        k = -1;
        i = n;
        if (j < n)
        {
          mu localmu = (mu)localpn.h.get(j);
          m = i;
          if (localmu != null)
          {
            if (localmu.i() > paramFloat) {
              i = j;
            }
            m = i;
            if (TextUtils.equals(localmu.L, paramString))
            {
              k = j;
              m = i;
              i = k;
              k = m;
              break label248;
            }
          }
        }
      }
      label248:
      do
      {
        j = i;
        if (i >= k) {
          j = i - 1;
        }
        paramString = (mu)localpn.h.remove(k);
        if (paramString == null) {
          break;
        }
        localpn.h.add(j, paramString);
        break;
        i = k;
        k = m;
        j += 1;
        m = k;
        k = i;
        i = m;
        break label93;
        if (k == -1) {
          break label170;
        }
      } while (k != i);
    }
  }
  
  public final void b(String paramString, int paramInt)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mq)) {
      return;
    }
    ((mq)paramString).b(paramInt);
    this.a.az.b.k();
  }
  
  public final void c(String paramString, int paramInt)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mq)) {
      return;
    }
    if (paramString != null) {
      paramString.d(paramInt);
    }
    this.a.az.b.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.lk
 * JD-Core Version:    0.7.0.1
 */