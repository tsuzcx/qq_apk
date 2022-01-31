package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.core.functions.animation.GlAnimation;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class lq
  implements kx, mb
{
  public pn a = null;
  public km b = null;
  public BaseMapView c = null;
  public TencentMap.OnMarkerDragListener d = null;
  public TencentMap.InfoWindowAdapter e = null;
  private lq.a f = new lq.1(this);
  
  public lq(BaseMapView paramBaseMapView, IMapRenderView paramIMapRenderView)
  {
    this.a = ((pn)paramIMapRenderView.getVectorMapDelegate());
    this.c = paramBaseMapView;
    if (this.a == null) {}
    do
    {
      return;
      this.a.t = this.f;
    } while (this.a.a(ms.class) != null);
    this.a.a(ms.class, this);
  }
  
  private ms p(String paramString)
  {
    paramString = this.a.c(paramString);
    if (paramString == null) {
      return null;
    }
    if (!(paramString instanceof ms)) {
      return null;
    }
    return (ms)paramString;
  }
  
  public final Marker a(MarkerOptions paramMarkerOptions, km paramkm)
  {
    if (this.a == null) {
      return null;
    }
    if (this.b == null) {
      this.b = paramkm;
    }
    Object localObject = new ms(this, this.a);
    ((ms)localObject).a(paramMarkerOptions);
    this.a.a((mu)localObject);
    if (this.a.a(ms.class) == null) {
      this.a.a(ms.class, this);
    }
    this.a.az.b.k();
    paramkm = new Marker(paramMarkerOptions, paramkm, ((mu)localObject).L);
    ((ms)localObject).G = paramkm;
    paramMarkerOptions = this.a;
    hr localhr;
    String str;
    int i;
    if (paramMarkerOptions.av != null)
    {
      localhr = paramMarkerOptions.av;
      str = ((ms)localObject).G.getContentDescription();
      if (!nl.a(str))
      {
        paramMarkerOptions = ((ms)localObject).g();
        i = ((ms)localObject).F.getWidth();
        int j = ((ms)localObject).F.getHeight();
        if ((paramMarkerOptions.left < 0) || (paramMarkerOptions.top < 0) || (paramMarkerOptions.right > i) || (paramMarkerOptions.bottom > j)) {
          break label296;
        }
        i = 1;
        if (i != 0)
        {
          localObject = new hs(localhr.d, (ms)localObject);
          if (localhr.a.size() <= 0) {
            break label383;
          }
          paramMarkerOptions = (hq)localhr.a.get(localhr.a.size() - 1);
          if ((paramMarkerOptions == null) || (!(paramMarkerOptions instanceof hs))) {
            break label383;
          }
        }
      }
    }
    for (;;)
    {
      if (str.startsWith("我的位置")) {
        localhr.a.add(localObject);
      }
      for (;;)
      {
        return paramkm;
        label296:
        i = 0;
        break;
        localhr.a.clear();
        localhr.b.add(localObject);
        Collections.sort(localhr.b);
        localhr.a.addAll(localhr.b);
        localhr.a.addAll(localhr.c);
        if (paramMarkerOptions != null) {
          localhr.a.add(paramMarkerOptions);
        }
      }
      label383:
      paramMarkerOptions = null;
    }
  }
  
  public final void a()
  {
    if (this.a == null) {
      return;
    }
    this.a.az.b.k();
  }
  
  public final void a(TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    this.e = paramInfoWindowAdapter;
  }
  
  public final void a(TencentMap.OnMarkerDragListener paramOnMarkerDragListener)
  {
    this.d = paramOnMarkerDragListener;
  }
  
  public final void a(String paramString)
  {
    if (this.a == null) {
      return;
    }
    mu localmu;
    synchronized (this.a.a)
    {
      localmu = this.a.a(paramString, false);
      if (!(localmu instanceof ms)) {
        return;
      }
    }
    localmu.h();
    if (paramString.equals(this.a.g())) {
      this.a.a("");
    }
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
    if (!(paramString instanceof ms)) {
      return;
    }
    ((ms)paramString).c(paramFloat);
    this.a.az.b.k();
  }
  
  public final void a(String paramString, float paramFloat1, float paramFloat2)
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
    if (!(paramString instanceof ms)) {
      return;
    }
    ((ms)paramString).b(paramFloat1, paramFloat2);
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
    if (!(paramString instanceof ms)) {
      return;
    }
    ((ms)paramString).d(paramInt);
    this.a.az.b.k();
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2)
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
    if (!(paramString instanceof ms)) {
      return;
    }
    paramString = (ms)paramString;
    paramString.D = paramInt1;
    paramString.E = paramInt2;
    if (paramString.H != null)
    {
      paramString.a(true);
      GeoPoint localGeoPoint = new GeoPoint(paramString.E, paramString.D);
      paramString.H.a(localGeoPoint);
    }
    if (paramString.J != null) {
      paramString.J.a(paramInt1, paramInt2);
    }
  }
  
  public final void a(String paramString, Animation paramAnimation)
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
    if (!(paramString instanceof ms)) {
      return;
    }
    paramString = (ms)paramString;
    paramString.I = paramAnimation.glAnimation;
    if (paramString.I != null) {
      paramString.I.setAnimationProperty(paramString.K);
    }
  }
  
  public final void a(String paramString, BitmapDescriptor paramBitmapDescriptor)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = p(paramString);
      if (paramString != null) {
        paramString.a(paramBitmapDescriptor);
      }
      this.a.az.b.k();
      return;
    }
  }
  
  public final void a(String paramString, LatLng paramLatLng)
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
    if (!(paramString instanceof ms)) {
      return;
    }
    ((ms)paramString).a(fz.a(paramLatLng));
    this.a.az.b.k();
  }
  
  public final void a(String paramString, MarkerOptions paramMarkerOptions)
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
    if (!(paramString instanceof ms)) {
      return;
    }
    ((ms)paramString).a(paramMarkerOptions);
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
    paramString.c(paramBoolean);
    this.a.az.b.k();
  }
  
  public final boolean a(mu parammu, GeoPoint paramGeoPoint)
  {
    boolean bool2 = false;
    int j = 0;
    boolean bool3 = true;
    boolean bool1;
    if ((this.a == null) || (parammu == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        parammu = (ms)parammu;
        paramGeoPoint = parammu.L;
        if (parammu.G == null)
        {
          this.a.a("");
          return true;
        }
        if (this.a.z == null) {
          break;
        }
        bool1 = bool3;
      } while (this.a.z.onMarkerClick(parammu.G));
      bool1 = bool3;
    } while (!parammu.G.isInfoWindowEnable());
    if (!this.a.as)
    {
      if (this.a.at == null)
      {
        parammu.o();
        this.a.at = parammu;
        return true;
      }
      if (this.a.at == parammu)
      {
        int i = j;
        if (parammu.J != null)
        {
          i = j;
          if (parammu.J.e()) {
            i = 1;
          }
        }
        if (i != 0)
        {
          parammu.n();
          this.a.at = null;
          return true;
        }
        parammu.o();
        this.a.at = parammu;
        return true;
      }
      this.a.at.n();
      parammu.o();
      this.a.at = parammu;
      return true;
    }
    if (parammu.J == null) {
      parammu.o();
    }
    for (;;)
    {
      this.a.a(paramGeoPoint);
      return true;
      bool3 = parammu.J.e();
      gj localgj = parammu.J;
      bool1 = bool2;
      if (!bool3) {
        bool1 = true;
      }
      localgj.a(bool1);
      if (!bool3) {
        this.a.at = parammu;
      }
    }
  }
  
  public final void b()
  {
    if (this.a == null) {
      return;
    }
    this.a.c(ms.class);
    this.a.a("");
    this.f.a();
  }
  
  public final void b(String paramString)
  {
    if (this.a == null) {}
    do
    {
      return;
      paramString = p(paramString);
    } while ((paramString == null) || (paramString.J == null));
    paramString.J.f();
  }
  
  public final void b(String paramString, float paramFloat)
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
    if (!(paramString instanceof ms)) {
      return;
    }
    ((ms)paramString).d(paramFloat);
    this.a.az.b.k();
  }
  
  public final void b(String paramString, boolean paramBoolean)
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
    if (!(paramString instanceof ms)) {
      return;
    }
    ((ms)paramString).A = paramBoolean;
    this.a.az.b.k();
  }
  
  public final void c(String paramString)
  {
    if (this.a == null) {}
    do
    {
      return;
      paramString = p(paramString);
    } while ((paramString == null) || (paramString.J == null));
    paramString.J.f();
  }
  
  public final void c(String paramString, float paramFloat)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.a(paramString, false);
      if (paramString == null) {
        return;
      }
    }
    paramString.b(paramFloat);
    this.a.a(paramString);
    this.a.az.b.k();
  }
  
  public final void c(String paramString, boolean paramBoolean)
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
    if (!(paramString instanceof ms)) {
      return;
    }
    ((ms)paramString).B = paramBoolean;
    this.a.az.b.k();
  }
  
  public final LatLng d(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    for (;;)
    {
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return null;
        }
        if (!(paramString instanceof ms)) {
          return null;
        }
        paramString = ((ms)paramString).e();
        if (paramString != null)
        {
          paramString = fz.a(paramString);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public final void d(String paramString, boolean paramBoolean)
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
    if (!(paramString instanceof ms)) {
      return;
    }
    paramString = (ms)paramString;
    paramString.a(paramBoolean);
    if (!paramBoolean) {
      paramString.a(paramString.e());
    }
  }
  
  public final boolean e(String paramString)
  {
    if (this.a == null) {
      return false;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return false;
      }
      if (!(paramString instanceof ms)) {
        return false;
      }
      paramString = (ms)paramString;
      if (!paramString.a()) {
        return false;
      }
      if (!paramString.G.isInfoWindowEnable()) {
        return false;
      }
      if ((!this.a.as) && (this.a.at != null) && (this.a.at != paramString)) {
        this.a.at.n();
      }
      paramString.o();
      this.a.at = paramString;
      this.a.az.b.k();
      return true;
    }
  }
  
  public final boolean f(String paramString)
  {
    if (this.a == null) {
      return false;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return false;
      }
      if (!(paramString instanceof ms)) {
        return false;
      }
      ((ms)paramString).n();
      return true;
    }
  }
  
  public final void g(String paramString)
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
    if (!(paramString instanceof ms)) {
      return;
    }
    paramString = (ms)paramString;
    if (!paramString.G.isInfoWindowEnable()) {
      return;
    }
    if ((paramString.J != null) && (paramString.J.e())) {
      paramString.J.f();
    }
    this.a.az.b.k();
  }
  
  public final boolean h(String paramString)
  {
    if (this.a == null) {
      return false;
    }
    paramString = this.a.c(paramString);
    if (paramString == null) {
      return false;
    }
    if (!(paramString instanceof ms)) {
      return false;
    }
    paramString = (ms)paramString;
    return (paramString.J != null) && (paramString.J.e());
  }
  
  public final float i(String paramString)
  {
    if (this.a == null) {
      return 0.0F;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return 0.0F;
      }
      if (!(paramString instanceof ms)) {
        return 0.0F;
      }
      float f1 = ((ms)paramString).l();
      return f1;
    }
  }
  
  public final boolean j(String paramString)
  {
    if (this.a == null) {
      return false;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return false;
      }
      if (!(paramString instanceof ms)) {
        return false;
      }
      boolean bool = ((ms)paramString).f();
      this.a.az.b.k();
      return bool;
    }
  }
  
  public final boolean k(String paramString)
  {
    if (this.a == null) {
      return false;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return false;
      }
      if (!(paramString instanceof ms)) {
        return false;
      }
      boolean bool = ((ms)paramString).B;
      return bool;
    }
  }
  
  public final boolean l(String paramString)
  {
    if (this.a == null) {
      return false;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return false;
      }
      if (!(paramString instanceof ms)) {
        return false;
      }
      boolean bool = ((ms)paramString).C;
      return bool;
    }
  }
  
  public final List<gg> m(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return null;
      }
      if (!(paramString instanceof ms)) {
        return null;
      }
      paramString = (ms)paramString;
      ??? = new ArrayList(2);
      ((List)???).add(paramString.H);
      gj localgj = paramString.J;
      if ((localgj != null) && (localgj.e())) {
        ((List)???).add(paramString.J);
      }
      return ???;
    }
  }
  
  public final void n(String paramString)
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
    if (!(paramString instanceof ms)) {
      return;
    }
    paramString = (ms)paramString;
    if (paramString.H != null) {
      paramString.H.c();
    }
    this.a.az.b.k();
  }
  
  final Marker o(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")) || (this.a == null)) {
      return null;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return null;
      }
      if (!(paramString instanceof ms)) {
        return null;
      }
      paramString = ((ms)paramString).G;
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.lq
 * JD-Core Version:    0.7.0.1
 */