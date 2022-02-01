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
    if (this.a == null) {}
    while ((!this.a.aa) || (this.a.p == null) || (!this.a.aa)) {
      return false;
    }
    return this.a.p.onDoubleTap(paramFloat1, paramFloat2);
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
    if (this.a == null) {}
    do
    {
      do
      {
        return false;
      } while (!this.a.aa);
      if (!this.a.c(paramFloat1, paramFloat2)) {
        this.a.b(paramFloat1, paramFloat2);
      }
    } while ((this.a.p == null) || (!this.a.aa));
    return this.a.p.onSingleTap(paramFloat1, paramFloat2);
  }
  
  public final boolean c()
  {
    return false;
  }
  
  public final boolean c(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {}
    while ((!this.a.aa) || (this.a.p == null)) {
      return false;
    }
    return this.a.p.onFling(paramFloat1, paramFloat2);
  }
  
  public final boolean d()
  {
    return false;
  }
  
  public final boolean d(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {}
    while ((!this.a.aa) || (this.a.p == null)) {
      return false;
    }
    return this.a.p.onScroll(paramFloat1, paramFloat2);
  }
  
  public final boolean e(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {}
    do
    {
      do
      {
        return false;
      } while (!this.a.aa);
      this.a.a(paramFloat1, paramFloat2);
    } while (this.a.p == null);
    return this.a.p.onLongPress(paramFloat1, paramFloat2);
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
    if (this.a == null) {}
    do
    {
      do
      {
        return false;
      } while (!this.a.aa);
      pn localpn = this.a;
      localpn.ai += 1;
    } while (this.a.p == null);
    return this.a.p.onDown(paramFloat1, paramFloat2);
  }
  
  public final boolean j(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {}
    while (!this.a.aa) {
      return false;
    }
    Object localObject = this.a;
    int i;
    if (this.a.ai > 0)
    {
      pn localpn = this.a;
      i = localpn.ai - 1;
      localpn.ai = i;
    }
    for (;;)
    {
      ((pn)localObject).ai = i;
      if ((this.a.ah) && (this.a.ag) && (this.a.ai == 0))
      {
        localObject = this.a.f();
        if (localObject == null) {
          break;
        }
        this.a.ah = false;
        this.a.onCameraChangeFinished((CameraPosition)localObject);
      }
      if (this.a.p == null) {
        break;
      }
      return this.a.p.onUp(paramFloat1, paramFloat2);
      i = 0;
    }
  }
  
  public final boolean k(float paramFloat1, float paramFloat2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.pk
 * JD-Core Version:    0.7.0.1
 */