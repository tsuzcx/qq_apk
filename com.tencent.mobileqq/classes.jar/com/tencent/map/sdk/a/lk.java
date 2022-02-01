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
    paramIMapRenderView = this.a;
    if (paramIMapRenderView == null) {
      return;
    }
    if (paramIMapRenderView.a(mq.class) == null) {
      this.a.a(mq.class, this);
    }
  }
  
  public final Circle a(CircleOptions paramCircleOptions, kh paramkh)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return null;
    }
    localObject = new mq((pn)localObject);
    ((mq)localObject).a(paramCircleOptions);
    ((mq)localObject).d();
    if (!this.a.a((mu)localObject)) {
      return null;
    }
    this.a.az.b.k();
    return new Circle(paramCircleOptions, paramkh, ((mu)localObject).L);
  }
  
  public final void a()
  {
    pn localpn = this.a;
    if (localpn != null) {
      localpn.c(mq.class);
    }
  }
  
  public final void a(String paramString)
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    synchronized (((pn)???).a)
    {
      paramString = this.a.a(paramString, false);
      if ((paramString != null) && ((paramString instanceof mq)))
      {
        paramString.h();
        this.a.az.b.k();
        return;
      }
      return;
    }
  }
  
  public final void a(String paramString, double paramDouble)
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    synchronized (((pn)???).a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
      if (!(paramString instanceof mq)) {
        return;
      }
      ((mq)paramString).a(paramDouble);
      this.a.az.b.k();
      return;
    }
  }
  
  public final void a(String paramString, float paramFloat)
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    synchronized (((pn)???).a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
      if (!(paramString instanceof mq)) {
        return;
      }
      ((mq)paramString).a(paramFloat);
      this.a.az.b.k();
      return;
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    synchronized (((pn)???).a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
      if (!(paramString instanceof mq)) {
        return;
      }
      ((mq)paramString).c(paramInt);
      this.a.az.b.k();
      return;
    }
  }
  
  public final void a(String paramString, CircleOptions paramCircleOptions)
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    synchronized (((pn)???).a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
      if (!(paramString instanceof mq)) {
        return;
      }
      ((mq)paramString).a(paramCircleOptions);
      this.a.az.b.k();
      return;
    }
  }
  
  public final void a(String paramString, LatLng paramLatLng)
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    if (paramLatLng == null) {
      return;
    }
    synchronized (((pn)???).a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
      if (!(paramString instanceof mq)) {
        return;
      }
      ((mq)paramString).a(fz.a(paramLatLng));
      this.a.az.b.k();
      return;
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    synchronized (((pn)???).a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
      if (!(paramString instanceof mq)) {
        return;
      }
      ((mq)paramString).c(paramBoolean);
      this.a.az.b.k();
      return;
    }
  }
  
  public final boolean a(mu parammu, GeoPoint paramGeoPoint)
  {
    return false;
  }
  
  public final List<gg> b(String paramString)
  {
    ??? = this.a;
    if (??? == null) {
      return null;
    }
    synchronized (((pn)???).a)
    {
      paramString = this.a.c(paramString);
      if ((paramString != null) && ((paramString instanceof mq)))
      {
        paramString = (mq)paramString;
        ??? = new ArrayList(1);
        ((List)???).add(paramString);
        return ???;
      }
      return null;
    }
  }
  
  public final void b(String paramString, float paramFloat)
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    ??? = ((pn)???).c(paramString);
    if (??? != null) {
      ((mu)???).b(paramFloat);
    }
    pn localpn = this.a;
    if ((paramString != null) && (!paramString.equals(""))) {}
    for (;;)
    {
      int i;
      int m;
      int n;
      synchronized (localpn.a)
      {
        int i1 = localpn.h.size();
        i = 0;
        j = i1;
        k = -1;
        if (i >= i1) {
          break label247;
        }
        mu localmu = (mu)localpn.h.get(i);
        m = k;
        n = j;
        if (localmu == null) {
          break label232;
        }
        if (localmu.i() > paramFloat) {
          j = i;
        }
        m = k;
        n = j;
        if (!TextUtils.equals(localmu.L, paramString)) {
          break label232;
        }
        m = i;
        n = j;
        break label232;
        paramString = (mu)localpn.h.remove(k);
        if (paramString != null) {
          localpn.h.add(i, paramString);
        }
      }
      this.a.az.b.k();
      return;
      label232:
      i += 1;
      int k = m;
      int j = n;
      continue;
      label247:
      if ((k != -1) && (k != j))
      {
        i = j;
        if (j >= k) {
          i = j - 1;
        }
      }
    }
  }
  
  public final void b(String paramString, int paramInt)
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    synchronized (((pn)???).a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
      if (!(paramString instanceof mq)) {
        return;
      }
      ((mq)paramString).b(paramInt);
      this.a.az.b.k();
      return;
    }
  }
  
  public final void c(String paramString, int paramInt)
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    synchronized (((pn)???).a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
      if (!(paramString instanceof mq)) {
        return;
      }
      if (paramString != null) {
        paramString.d(paramInt);
      }
      this.a.az.b.k();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.lk
 * JD-Core Version:    0.7.0.1
 */