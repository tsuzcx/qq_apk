package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.core.functions.animation.GlAnimation;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnPolylineClickListener;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class lt
  implements lb, mb
{
  public pn a = null;
  private TencentMap.OnPolylineClickListener b = null;
  
  public lt(IMapRenderView paramIMapRenderView)
  {
    this.a = ((pn)paramIMapRenderView.getVectorMapDelegate());
    paramIMapRenderView = this.a;
    if ((paramIMapRenderView != null) && (paramIMapRenderView.a(mw.class) == null)) {
      this.a.a(mw.class, this);
    }
  }
  
  public final Polyline a(PolylineOptions paramPolylineOptions, kq paramkq)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return null;
    }
    localObject = new mw((pn)localObject);
    ((mw)localObject).a(paramPolylineOptions);
    ((mw)localObject).d();
    if (!this.a.a((mu)localObject)) {
      return null;
    }
    this.a.az.b.k();
    paramPolylineOptions = new Polyline(paramPolylineOptions, paramkq, ((mu)localObject).L);
    ((mw)localObject).i = paramPolylineOptions;
    return paramPolylineOptions;
  }
  
  public final void a()
  {
    pn localpn = this.a;
    if (localpn != null) {
      localpn.c(mw.class);
    }
  }
  
  public final void a(TencentMap.OnPolylineClickListener paramOnPolylineClickListener)
  {
    this.b = paramOnPolylineClickListener;
  }
  
  public final void a(String paramString)
  {
    pn localpn = this.a;
    if (localpn != null)
    {
      if (localpn.az == null) {
        return;
      }
      this.a.a(paramString, true);
      this.a.az.b.k();
    }
  }
  
  public final void a(String paramString, float paramFloat)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        if (!(paramString instanceof mw)) {
          return;
        }
        paramString = (mw)paramString;
        paramString.a(paramFloat);
        paramString.d();
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        paramString.b(paramInt);
        paramString.d();
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        if (!(paramString instanceof mw)) {
          return;
        }
        paramString = (mw)paramString;
        if (paramString.h != null)
        {
          paramString.h.a();
          paramString.h.a(paramInt1, paramInt2);
          paramString.e();
        }
        paramString.d();
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final void a(String paramString, int paramInt, LatLng paramLatLng)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        if (!(paramString instanceof mw)) {
          return;
        }
        paramString = (mw)paramString;
        paramLatLng = fz.a(paramLatLng);
        if ((paramInt != -1) && (paramLatLng != null))
        {
          paramString.r = paramInt;
          paramString.s = paramLatLng;
          if (paramString.h != null) {
            paramString.h.a(paramString.r, paramString.s);
          }
          if (paramString.k != null) {
            paramString.k.s();
          }
        }
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final void a(String paramString, GlAnimation paramGlAnimation)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if ((paramString != null) && ((paramString instanceof mw)))
        {
          ((mw)paramString).a(paramGlAnimation);
          return;
        }
        return;
      }
    }
  }
  
  public final void a(String paramString, BitmapDescriptor paramBitmapDescriptor)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        if (!(paramString instanceof mw)) {
          return;
        }
        paramString = (mw)paramString;
        paramString.a(paramBitmapDescriptor);
        paramString.d();
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final void a(String paramString, PolylineOptions.Text paramText)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (!(paramString instanceof mw)) {
          return;
        }
        paramString = (mw)paramString;
        paramString.o = paramText;
        paramString.d();
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final void a(String paramString, PolylineOptions paramPolylineOptions)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if ((paramString != null) && ((paramString instanceof mw)))
        {
          ((mw)paramString).a(paramPolylineOptions);
          this.a.az.b.k();
          return;
        }
        return;
      }
    }
  }
  
  public final void a(String paramString, List<LatLng> paramList)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        if (!(paramString instanceof mw)) {
          return;
        }
        paramString = (mw)paramString;
      }
    }
    try
    {
      paramString.a(paramList);
      label63:
      paramString.d();
      this.a.az.b.k();
      return;
      paramString = finally;
      throw paramString;
      return;
    }
    catch (IndexOutOfBoundsException paramList)
    {
      break label63;
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        paramString.c(paramBoolean);
        paramString.d();
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final void a(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        if (!(paramString instanceof mw)) {
          return;
        }
        paramString = (mw)paramString;
        paramString.a(paramArrayOfInt1, paramArrayOfInt2);
        paramString.d();
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final boolean a(mu parammu, GeoPoint paramGeoPoint)
  {
    parammu = (mw)parammu;
    boolean bool = parammu.i.isClickable();
    if ((this.b != null) && (bool))
    {
      paramGeoPoint = fz.a(paramGeoPoint);
      this.b.onPolylineClick(parammu.i, paramGeoPoint);
      return true;
    }
    return false;
  }
  
  public final void b(String paramString, float paramFloat)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        if (!(paramString instanceof mw)) {
          return;
        }
        paramString = (mw)paramString;
        paramString.b(paramFloat);
        paramString.d();
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final void b(String paramString, int paramInt)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        paramString.d(paramInt);
        paramString.d();
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final void b(String paramString, boolean paramBoolean)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        if (!(paramString instanceof mw)) {
          return;
        }
        paramString = (mw)paramString;
        paramString.l = paramBoolean;
        paramString.d();
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final int[][] b(String paramString)
  {
    ??? = this.a;
    Object localObject1 = null;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return null;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return null;
        }
        if (!(paramString instanceof mw)) {
          return null;
        }
        mw localmw = (mw)paramString;
        paramString = localObject1;
        if (localmw.m != null) {
          if (localmw.n == null)
          {
            paramString = localObject1;
          }
          else if (localmw.m.length != localmw.n.length)
          {
            paramString = localObject1;
          }
          else
          {
            paramString = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, localmw.m.length });
            paramString[0] = localmw.m;
            paramString[1] = localmw.n;
          }
        }
        return paramString;
      }
    }
    return null;
  }
  
  public final void c(String paramString)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        if (!(paramString instanceof mw)) {
          return;
        }
        paramString = (mw)paramString;
        if (paramString.h != null) {
          paramString.h.a();
        }
        paramString.d();
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final void c(String paramString, boolean paramBoolean)
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
      if (!(paramString instanceof mw)) {
        return;
      }
      paramString = (mw)paramString;
      paramString.p = paramBoolean;
      paramString.d();
      this.a.az.b.k();
      return;
    }
  }
  
  public final Rect d(String paramString)
  {
    ??? = this.a;
    if ((??? != null) && (((pt)???).az != null)) {
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null)
        {
          paramString = new Rect();
          return paramString;
        }
        if (!(paramString instanceof mw))
        {
          paramString = new Rect();
          return paramString;
        }
        paramString = ((mw)paramString).h.b();
        return paramString;
      }
    }
    return new Rect();
  }
  
  public final void d(String paramString, boolean paramBoolean)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        if (!(paramString instanceof mw)) {
          return;
        }
        paramString = (mw)paramString;
        paramString.q = paramBoolean;
        if (paramString.h != null) {
          paramString.h.a.q = paramBoolean;
        }
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final List<gg> e(String paramString)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return null;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (!(paramString instanceof mw)) {
          return null;
        }
        paramString = (mw)paramString;
        ??? = new ArrayList(1);
        ((List)???).add(paramString.h);
        return ???;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.lt
 * JD-Core Version:    0.7.0.1
 */