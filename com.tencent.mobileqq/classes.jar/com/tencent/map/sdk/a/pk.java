package com.tencent.map.sdk.a;

import android.graphics.PointF;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;

public final class pk
  implements gr
{
  private pn a;
  
  public pk(pn parampn)
  {
    this.a = parampn;
  }
  
  public final void a() {}
  
  public final boolean a(float paramFloat)
  {
    return false;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    pn localpn = this.a;
    if (localpn == null) {
      return false;
    }
    if (!localpn.aa) {
      return false;
    }
    if ((this.a.p != null) && (this.a.aa)) {
      return this.a.p.onDoubleTap(paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public final boolean a(PointF paramPointF1, PointF paramPointF2, double paramDouble1, double paramDouble2)
  {
    return false;
  }
  
  public final boolean a(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    return false;
  }
  
  public final boolean b()
  {
    return false;
  }
  
  public final boolean b(float paramFloat1, float paramFloat2)
  {
    pn localpn = this.a;
    if (localpn == null) {
      return false;
    }
    if (!localpn.aa) {
      return false;
    }
    if (!this.a.c(paramFloat1, paramFloat2)) {
      this.a.b(paramFloat1, paramFloat2);
    }
    if ((this.a.p != null) && (this.a.aa)) {
      return this.a.p.onSingleTap(paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public final boolean c()
  {
    return false;
  }
  
  public final boolean c(float paramFloat1, float paramFloat2)
  {
    pn localpn = this.a;
    if (localpn == null) {
      return false;
    }
    if (!localpn.aa) {
      return false;
    }
    if (this.a.p != null) {
      return this.a.p.onFling(paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public final boolean d()
  {
    return false;
  }
  
  public final boolean d(float paramFloat1, float paramFloat2)
  {
    pn localpn = this.a;
    if (localpn == null) {
      return false;
    }
    if (!localpn.aa) {
      return false;
    }
    if (this.a.p != null) {
      return this.a.p.onScroll(paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public final boolean e(float paramFloat1, float paramFloat2)
  {
    pn localpn = this.a;
    if (localpn == null) {
      return false;
    }
    if (!localpn.aa) {
      return false;
    }
    this.a.a(paramFloat1, paramFloat2);
    if (this.a.p != null) {
      return this.a.p.onLongPress(paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public final boolean f(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean g(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean h(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean i(float paramFloat1, float paramFloat2)
  {
    pn localpn = this.a;
    if (localpn == null) {
      return false;
    }
    if (!localpn.aa) {
      return false;
    }
    localpn = this.a;
    localpn.ai += 1;
    if (this.a.p != null) {
      return this.a.p.onDown(paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public final boolean j(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    if (!((pn)localObject).aa) {
      return false;
    }
    localObject = this.a;
    pn localpn;
    int i;
    if (((pn)localObject).ai > 0)
    {
      localpn = this.a;
      i = localpn.ai - 1;
      localpn.ai = i;
    }
    else
    {
      i = 0;
    }
    ((pn)localObject).ai = i;
    if ((this.a.ah) && (this.a.ag) && (this.a.ai == 0))
    {
      localObject = this.a.f();
      if (localObject == null) {
        return false;
      }
      localpn = this.a;
      localpn.ah = false;
      localpn.onCameraChangeFinished((CameraPosition)localObject);
    }
    if (this.a.p != null) {
      return this.a.p.onUp(paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public final boolean k(float paramFloat1, float paramFloat2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.pk
 * JD-Core Version:    0.7.0.1
 */