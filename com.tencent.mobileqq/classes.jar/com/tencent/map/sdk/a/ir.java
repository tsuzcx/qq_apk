package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.core.functions.animation.Animation;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.engine.jni.models.TappedElement;
import java.util.HashMap;
import javax.microedition.khronos.opengles.GL10;

public final class ir
  implements go
{
  protected is a;
  protected mn b;
  protected DoublePoint c = new DoublePoint();
  public boolean d;
  private lv e;
  private lg f;
  private Animation g = null;
  
  public ir()
  {
    this.d = true;
  }
  
  public ir(lv paramlv, is paramis)
  {
    this.e = paramlv;
    this.f = paramlv.a;
    this.a = paramis;
    this.b = new mn(this.a.a(), this.a.a, this.a.c, this.a.d, this.a.h, this.a.i, this.a.b);
    this.b.n = paramis.l;
    this.b.p = paramis.m;
    this.b.a(paramis.g);
    this.b.q = paramis.o;
    this.b.a(paramis.e);
    this.d = true;
  }
  
  private boolean d()
  {
    if (this.b != null) {
      return this.b.n;
    }
    return false;
  }
  
  public final int a()
  {
    if (this.b != null) {
      return this.b.a;
    }
    return -1;
  }
  
  public final Rect a(fu paramfu)
  {
    int i = 0;
    if ((this.b == null) || (this.a == null) || (this.a.a == null)) {
      return null;
    }
    DoublePoint localDoublePoint;
    int j;
    if (d())
    {
      paramfu = this.a.a;
      localDoublePoint = new DoublePoint(0.0D, 0.0D);
      if (paramfu != null)
      {
        localDoublePoint.x = paramfu.getLongitudeE6();
        localDoublePoint.y = paramfu.getLatitudeE6();
      }
      this.c = localDoublePoint;
      paramfu = new DoublePoint();
      localDoublePoint = new DoublePoint();
      Bitmap localBitmap = this.b.a();
      if (localBitmap == null) {
        break label394;
      }
      j = localBitmap.getWidth();
      i = localBitmap.getHeight();
    }
    for (;;)
    {
      paramfu.x = this.c.x;
      localDoublePoint.x = (this.c.x + j);
      paramfu.y = this.c.y;
      localDoublePoint.y = (this.c.y + i);
      float f1 = this.a.c;
      j = (int)(j * f1);
      f1 = this.a.d;
      i = (int)(i * f1);
      paramfu.x -= j;
      localDoublePoint.x -= j;
      paramfu.y -= i;
      localDoublePoint.y -= i;
      i = this.a.h;
      j = this.a.i;
      paramfu.x += i;
      localDoublePoint.x += i;
      paramfu.y += j;
      double d1 = localDoublePoint.y;
      localDoublePoint.y = (j + d1);
      return new Rect((int)paramfu.x, (int)paramfu.y, (int)localDoublePoint.x, (int)localDoublePoint.y);
      this.c = paramfu.a(this.a.a);
      break;
      label394:
      j = 0;
    }
  }
  
  public final void a(float paramFloat)
  {
    is localis = this.a;
    localis.e = paramFloat;
    this.a = localis;
    if (this.b != null)
    {
      this.b.a(paramFloat);
      this.b.i = true;
    }
  }
  
  public final void a(int paramInt)
  {
    is localis = this.a;
    localis.k = paramInt;
    this.a = localis;
    if (this.b != null) {
      this.b.i = true;
    }
  }
  
  public final void a(GeoPoint paramGeoPoint)
  {
    Object localObject = this.a;
    ((is)localObject).a = paramGeoPoint;
    this.a = ((is)localObject);
    if (this.b != null)
    {
      localObject = this.b;
      if (paramGeoPoint != null) {
        if (!((mn)localObject).n) {
          break label84;
        }
      }
    }
    label84:
    for (double d1 = 1.0D;; d1 = 1000000.0D)
    {
      ((mn)localObject).e = (paramGeoPoint.getLongitudeE6() / d1);
      ((mn)localObject).f = (paramGeoPoint.getLatitudeE6() / d1);
      ((mn)localObject).i = true;
      this.b.i = true;
      return;
    }
  }
  
  public final void a(is paramis)
  {
    if (paramis == null) {
      return;
    }
    if (this.a == null) {
      this.a = paramis;
    }
    for (;;)
    {
      if (this.b == null) {
        this.b = new mn(this.a.a(), this.a.a, this.a.c, this.a.d, this.a.h, this.a.i, this.a.b);
      }
      this.b.a(this.a.e);
      this.b.a(this.a.c, this.a.d);
      this.b.a(paramis.g);
      this.b.n = paramis.l;
      this.b.p = paramis.m;
      this.b.q = paramis.o;
      return;
      this.a.e = paramis.e;
      this.a.a(paramis.c, paramis.d);
      this.a.f = paramis.f;
      this.a.g = paramis.g;
      this.a.j = paramis.j;
      this.a.o = paramis.o;
      this.a.k = paramis.k;
    }
  }
  
  public final void a(String paramString, Bitmap... paramVarArgs)
  {
    this.a = this.a.a(paramString, paramVarArgs);
    if (this.b != null)
    {
      this.b.a(paramString, paramVarArgs);
      this.b.i = true;
    }
  }
  
  public final void a(GL10 paramGL10)
  {
    if (this.e == null) {}
    label55:
    mn localmn;
    label374:
    label376:
    do
    {
      do
      {
        return;
        if (this.d) {
          break;
        }
      } while (this.b == null);
      this.b.a = -1;
      return;
      boolean bool1;
      boolean bool2;
      int i;
      int j;
      if (this.g != null)
      {
        if (!this.g.isEnded()) {
          this.g.drawAnimation();
        }
      }
      else
      {
        if (this.b == null) {
          break label374;
        }
        paramGL10 = this.e;
        localmn = this.b;
        bool1 = this.a.f;
        bool2 = this.a.p;
        i = this.a.j;
        j = this.a.k;
        if (!bool2) {
          break label376;
        }
      }
      for (float f1 = 360.0F - localmn.k;; f1 = localmn.k)
      {
        if (!paramGL10.c.containsKey(Integer.valueOf(localmn.a))) {
          break label387;
        }
        if (localmn.i)
        {
          pf localpf = paramGL10.b;
          int k = localmn.a;
          String str = localmn.b;
          double d1 = localmn.e;
          double d2 = localmn.f;
          float f2 = localmn.g;
          float f3 = localmn.h;
          float f4 = localmn.l;
          float f5 = localmn.m;
          float f6 = localmn.j;
          bool2 = localmn.n;
          boolean bool3 = localmn.p;
          boolean bool4 = localmn.q;
          if (0L != localpf.b) {
            localpf.f.a(new pf.5(localpf, k, str, d1, d2, f2, f3, f4, f5, f6, f1, bool1, bool2, bool3, bool4, i, j));
          }
          if (localmn.o)
          {
            oi.a(localmn.b, localmn.a());
            if (!nl.a(localmn.b, localmn.c)) {
              oi.b(localmn.c);
            }
            localmn.a(false);
          }
        }
        paramGL10.d.put(Integer.valueOf(localmn.a), localmn);
        return;
        this.g = null;
        break label55;
        break;
      }
      localmn.a = paramGL10.b.a(localmn.b, localmn.e, localmn.f, localmn.g, localmn.h, localmn.l, localmn.m, localmn.j, f1, bool1, localmn.n, localmn.p, localmn.q, i, j);
    } while (localmn.a <= 0);
    label387:
    oi.a(localmn.b, localmn.a());
    localmn.a(false);
    localmn.i = false;
    paramGL10.d.put(Integer.valueOf(localmn.a), localmn);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.b != null)
    {
      this.b.n = paramBoolean;
      this.b.i = true;
    }
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    if ((!this.d) || (this.a.a == null) || (this.f == null)) {
      return false;
    }
    TappedElement localTappedElement = this.f.g().b(paramFloat1, paramFloat2);
    if ((localTappedElement != null) && (localTappedElement.itemId == a())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.b.b(1);
        return bool;
      }
      this.b.b(0);
      return bool;
    }
  }
  
  public final Rect b(fu paramfu)
  {
    if ((this.b == null) || (this.a == null) || (this.a.a == null)) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    if (d())
    {
      localObject1 = this.a.a;
      localObject2 = new DoublePoint(0.0D, 0.0D);
      if (localObject1 != null)
      {
        ((DoublePoint)localObject2).x = ((GeoPoint)localObject1).getLongitudeE6();
        ((DoublePoint)localObject2).y = ((GeoPoint)localObject1).getLatitudeE6();
      }
    }
    for (this.c = ((DoublePoint)localObject2);; this.c = paramfu.a(this.a.a))
    {
      localObject2 = new DoublePoint();
      localObject1 = new DoublePoint();
      Bitmap localBitmap = this.b.a();
      if (localBitmap == null) {
        break;
      }
      int j = localBitmap.getWidth();
      int i = localBitmap.getHeight();
      ((DoublePoint)localObject2).x = this.c.x;
      ((DoublePoint)localObject1).x = (this.c.x + j);
      ((DoublePoint)localObject2).y = this.c.y;
      ((DoublePoint)localObject1).y = (this.c.y + i);
      float f1 = this.a.c;
      j = (int)(j * f1);
      f1 = this.a.d;
      i = (int)(i * f1);
      ((DoublePoint)localObject2).x -= j;
      ((DoublePoint)localObject1).x -= j;
      ((DoublePoint)localObject2).y -= i;
      ((DoublePoint)localObject1).y -= i;
      i = this.a.h;
      j = this.a.i;
      ((DoublePoint)localObject2).x += i;
      ((DoublePoint)localObject1).x += i;
      ((DoublePoint)localObject2).y += j;
      ((DoublePoint)localObject1).y += j;
      localObject2 = paramfu.a((DoublePoint)localObject2);
      paramfu = paramfu.a((DoublePoint)localObject1);
      return new Rect(((GeoPoint)localObject2).getLongitudeE6(), ((GeoPoint)localObject2).getLatitudeE6(), paramfu.getLongitudeE6(), paramfu.getLatitudeE6());
    }
  }
  
  public final void b()
  {
    if (this.b != null) {
      this.b.a = 0;
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2)
  {
    this.a = this.a.a(paramFloat1, paramFloat2);
    if (this.b != null)
    {
      this.b.a(paramFloat1, paramFloat2);
      this.b.i = true;
    }
  }
  
  public final void b(int paramInt)
  {
    is localis = this.a;
    localis.g = paramInt;
    this.a = localis;
    if (this.b != null)
    {
      this.b.a(paramInt);
      this.b.i = true;
    }
  }
  
  public final void c()
  {
    if (this.b == null) {
      return;
    }
    this.b.p = false;
    this.b.i = true;
  }
  
  public final void c(float paramFloat1, float paramFloat2)
  {
    if (this.b != null)
    {
      mn localmn = this.b;
      localmn.l = paramFloat1;
      localmn.m = paramFloat2;
      localmn.i = true;
      this.b.i = true;
    }
  }
  
  public final void c(int paramInt)
  {
    is localis = this.a;
    localis.j = paramInt;
    this.a = localis;
    if (this.b != null) {
      this.b.i = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ir
 * JD-Core Version:    0.7.0.1
 */