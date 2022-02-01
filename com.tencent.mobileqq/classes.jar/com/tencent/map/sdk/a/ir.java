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
    mn localmn = this.b;
    if (localmn != null) {
      return localmn.n;
    }
    return false;
  }
  
  public final int a()
  {
    mn localmn = this.b;
    if (localmn != null) {
      return localmn.a;
    }
    return -1;
  }
  
  public final Rect a(fu paramfu)
  {
    if (this.b != null)
    {
      Object localObject = this.a;
      if ((localObject != null) && (((is)localObject).a != null))
      {
        if (d())
        {
          paramfu = this.a.a;
          localObject = new DoublePoint(0.0D, 0.0D);
          if (paramfu != null)
          {
            ((DoublePoint)localObject).x = paramfu.getLongitudeE6();
            ((DoublePoint)localObject).y = paramfu.getLatitudeE6();
          }
          this.c = ((DoublePoint)localObject);
        }
        else
        {
          this.c = paramfu.a(this.a.a);
        }
        paramfu = new DoublePoint();
        localObject = new DoublePoint();
        Bitmap localBitmap = this.b.a();
        int j = 0;
        if (localBitmap != null)
        {
          j = localBitmap.getWidth();
          i = localBitmap.getHeight();
        }
        else
        {
          i = 0;
        }
        paramfu.x = this.c.x;
        double d1 = this.c.x;
        double d2 = j;
        Double.isNaN(d2);
        ((DoublePoint)localObject).x = (d1 + d2);
        paramfu.y = this.c.y;
        d1 = this.c.y;
        d2 = i;
        Double.isNaN(d2);
        ((DoublePoint)localObject).y = (d1 + d2);
        j = (int)(this.a.c * j);
        int i = (int)(this.a.d * i);
        d2 = paramfu.x;
        d1 = j;
        Double.isNaN(d1);
        paramfu.x = (d2 - d1);
        d2 = ((DoublePoint)localObject).x;
        Double.isNaN(d1);
        ((DoublePoint)localObject).x = (d2 - d1);
        d2 = paramfu.y;
        d1 = i;
        Double.isNaN(d1);
        paramfu.y = (d2 - d1);
        d2 = ((DoublePoint)localObject).y;
        Double.isNaN(d1);
        ((DoublePoint)localObject).y = (d2 - d1);
        i = this.a.h;
        j = this.a.i;
        d2 = paramfu.x;
        d1 = i;
        Double.isNaN(d1);
        paramfu.x = (d2 + d1);
        d2 = ((DoublePoint)localObject).x;
        Double.isNaN(d1);
        ((DoublePoint)localObject).x = (d2 + d1);
        d2 = paramfu.y;
        d1 = j;
        Double.isNaN(d1);
        paramfu.y = (d2 + d1);
        d2 = ((DoublePoint)localObject).y;
        Double.isNaN(d1);
        ((DoublePoint)localObject).y = (d2 + d1);
        return new Rect((int)paramfu.x, (int)paramfu.y, (int)((DoublePoint)localObject).x, (int)((DoublePoint)localObject).y);
      }
    }
    return null;
  }
  
  public final void a(float paramFloat)
  {
    Object localObject = this.a;
    ((is)localObject).e = paramFloat;
    this.a = ((is)localObject);
    localObject = this.b;
    if (localObject != null)
    {
      ((mn)localObject).a(paramFloat);
      this.b.i = true;
    }
  }
  
  public final void a(int paramInt)
  {
    Object localObject = this.a;
    ((is)localObject).k = paramInt;
    this.a = ((is)localObject);
    localObject = this.b;
    if (localObject != null) {
      ((mn)localObject).i = true;
    }
  }
  
  public final void a(GeoPoint paramGeoPoint)
  {
    Object localObject = this.a;
    ((is)localObject).a = paramGeoPoint;
    this.a = ((is)localObject);
    localObject = this.b;
    if (localObject != null)
    {
      if (paramGeoPoint != null)
      {
        double d1;
        if (((mn)localObject).n) {
          d1 = 1.0D;
        } else {
          d1 = 1000000.0D;
        }
        double d2 = paramGeoPoint.getLongitudeE6();
        Double.isNaN(d2);
        ((mn)localObject).e = (d2 / d1);
        d2 = paramGeoPoint.getLatitudeE6();
        Double.isNaN(d2);
        ((mn)localObject).f = (d2 / d1);
        ((mn)localObject).i = true;
      }
      this.b.i = true;
    }
  }
  
  public final void a(is paramis)
  {
    if (paramis == null) {
      return;
    }
    is localis = this.a;
    if (localis == null)
    {
      this.a = paramis;
    }
    else
    {
      localis.e = paramis.e;
      this.a.a(paramis.c, paramis.d);
      this.a.f = paramis.f;
      this.a.g = paramis.g;
      this.a.j = paramis.j;
      this.a.o = paramis.o;
      this.a.k = paramis.k;
    }
    if (this.b == null) {
      this.b = new mn(this.a.a(), this.a.a, this.a.c, this.a.d, this.a.h, this.a.i, this.a.b);
    }
    this.b.a(this.a.e);
    this.b.a(this.a.c, this.a.d);
    this.b.a(paramis.g);
    this.b.n = paramis.l;
    this.b.p = paramis.m;
    this.b.q = paramis.o;
  }
  
  public final void a(String paramString, Bitmap... paramVarArgs)
  {
    this.a = this.a.a(paramString, paramVarArgs);
    mn localmn = this.b;
    if (localmn != null)
    {
      localmn.a(paramString, paramVarArgs);
      this.b.i = true;
    }
  }
  
  public final void a(GL10 paramGL10)
  {
    if (this.e == null) {
      return;
    }
    if (!this.d)
    {
      paramGL10 = this.b;
      if (paramGL10 != null) {
        paramGL10.a = -1;
      }
      return;
    }
    paramGL10 = this.g;
    if (paramGL10 != null) {
      if (!paramGL10.isEnded()) {
        this.g.drawAnimation();
      } else {
        this.g = null;
      }
    }
    paramGL10 = this.b;
    if (paramGL10 != null)
    {
      lv locallv = this.e;
      boolean bool1 = this.a.f;
      boolean bool2 = this.a.p;
      int i = this.a.j;
      int j = this.a.k;
      float f1;
      if (bool2) {
        f1 = 360.0F - paramGL10.k;
      } else {
        f1 = paramGL10.k;
      }
      if (locallv.c.containsKey(Integer.valueOf(paramGL10.a)))
      {
        if (paramGL10.i)
        {
          pf localpf = locallv.b;
          int k = paramGL10.a;
          String str = paramGL10.b;
          double d1 = paramGL10.e;
          double d2 = paramGL10.f;
          float f2 = paramGL10.g;
          float f3 = paramGL10.h;
          float f4 = paramGL10.l;
          float f5 = paramGL10.m;
          float f6 = paramGL10.j;
          bool2 = paramGL10.n;
          boolean bool3 = paramGL10.p;
          boolean bool4 = paramGL10.q;
          GL10 localGL10 = paramGL10;
          if (0L != localpf.b)
          {
            localpf.f.a(new pf.5(localpf, k, str, d1, d2, f2, f3, f4, f5, f6, f1, bool1, bool2, bool3, bool4, i, j));
            localGL10 = paramGL10;
          }
          if (localGL10.o)
          {
            oi.a(localGL10.b, localGL10.a());
            if (!nl.a(localGL10.b, localGL10.c)) {
              oi.b(localGL10.c);
            }
            localGL10.a(false);
          }
          paramGL10 = localGL10;
        }
        locallv.d.put(Integer.valueOf(paramGL10.a), paramGL10);
        return;
      }
      paramGL10.a = locallv.b.a(paramGL10.b, paramGL10.e, paramGL10.f, paramGL10.g, paramGL10.h, paramGL10.l, paramGL10.m, paramGL10.j, f1, bool1, paramGL10.n, paramGL10.p, paramGL10.q, i, j);
      if (paramGL10.a > 0)
      {
        oi.a(paramGL10.b, paramGL10.a());
        paramGL10.a(false);
        paramGL10.i = false;
        locallv.d.put(Integer.valueOf(paramGL10.a), paramGL10);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    mn localmn = this.b;
    if (localmn != null)
    {
      localmn.n = paramBoolean;
      localmn.i = true;
    }
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    if ((this.d) && (this.a.a != null))
    {
      Object localObject = this.f;
      if (localObject == null) {
        return false;
      }
      localObject = ((lg)localObject).g().b(paramFloat1, paramFloat2);
      boolean bool;
      if ((localObject != null) && (((TappedElement)localObject).itemId == a())) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool)
      {
        this.b.b(1);
        return bool;
      }
      this.b.b(0);
      return bool;
    }
    return false;
  }
  
  public final Rect b(fu paramfu)
  {
    Object localObject3 = this.b;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = this.a;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        if (((is)localObject3).a == null) {
          return null;
        }
        if (d())
        {
          localObject1 = this.a.a;
          localObject2 = new DoublePoint(0.0D, 0.0D);
          if (localObject1 != null)
          {
            ((DoublePoint)localObject2).x = ((GeoPoint)localObject1).getLongitudeE6();
            ((DoublePoint)localObject2).y = ((GeoPoint)localObject1).getLatitudeE6();
          }
          this.c = ((DoublePoint)localObject2);
        }
        else
        {
          this.c = paramfu.a(this.a.a);
        }
        localObject2 = new DoublePoint();
        localObject1 = new DoublePoint();
        localObject3 = this.b.a();
        if (localObject3 == null) {
          return null;
        }
        int j = ((Bitmap)localObject3).getWidth();
        int i = ((Bitmap)localObject3).getHeight();
        ((DoublePoint)localObject2).x = this.c.x;
        double d1 = this.c.x;
        double d2 = j;
        Double.isNaN(d2);
        ((DoublePoint)localObject1).x = (d1 + d2);
        ((DoublePoint)localObject2).y = this.c.y;
        d1 = this.c.y;
        d2 = i;
        Double.isNaN(d2);
        ((DoublePoint)localObject1).y = (d1 + d2);
        j = (int)(this.a.c * j);
        i = (int)(this.a.d * i);
        d2 = ((DoublePoint)localObject2).x;
        d1 = j;
        Double.isNaN(d1);
        ((DoublePoint)localObject2).x = (d2 - d1);
        d2 = ((DoublePoint)localObject1).x;
        Double.isNaN(d1);
        ((DoublePoint)localObject1).x = (d2 - d1);
        d2 = ((DoublePoint)localObject2).y;
        d1 = i;
        Double.isNaN(d1);
        ((DoublePoint)localObject2).y = (d2 - d1);
        d2 = ((DoublePoint)localObject1).y;
        Double.isNaN(d1);
        ((DoublePoint)localObject1).y = (d2 - d1);
        i = this.a.h;
        j = this.a.i;
        d2 = ((DoublePoint)localObject2).x;
        d1 = i;
        Double.isNaN(d1);
        ((DoublePoint)localObject2).x = (d2 + d1);
        d2 = ((DoublePoint)localObject1).x;
        Double.isNaN(d1);
        ((DoublePoint)localObject1).x = (d2 + d1);
        d2 = ((DoublePoint)localObject2).y;
        d1 = j;
        Double.isNaN(d1);
        ((DoublePoint)localObject2).y = (d2 + d1);
        d2 = ((DoublePoint)localObject1).y;
        Double.isNaN(d1);
        ((DoublePoint)localObject1).y = (d2 + d1);
        localObject2 = paramfu.a((DoublePoint)localObject2);
        paramfu = paramfu.a((DoublePoint)localObject1);
        localObject1 = new Rect(((GeoPoint)localObject2).getLongitudeE6(), ((GeoPoint)localObject2).getLatitudeE6(), paramfu.getLongitudeE6(), paramfu.getLatitudeE6());
      }
    }
    return localObject1;
  }
  
  public final void b()
  {
    mn localmn = this.b;
    if (localmn != null) {
      localmn.a = 0;
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2)
  {
    this.a = this.a.a(paramFloat1, paramFloat2);
    mn localmn = this.b;
    if (localmn != null)
    {
      localmn.a(paramFloat1, paramFloat2);
      this.b.i = true;
    }
  }
  
  public final void b(int paramInt)
  {
    Object localObject = this.a;
    ((is)localObject).g = paramInt;
    this.a = ((is)localObject);
    localObject = this.b;
    if (localObject != null)
    {
      ((mn)localObject).a(paramInt);
      this.b.i = true;
    }
  }
  
  public final void c()
  {
    mn localmn = this.b;
    if (localmn == null) {
      return;
    }
    localmn.p = false;
    localmn.i = true;
  }
  
  public final void c(float paramFloat1, float paramFloat2)
  {
    mn localmn = this.b;
    if (localmn != null)
    {
      localmn.l = paramFloat1;
      localmn.m = paramFloat2;
      localmn.i = true;
      localmn.i = true;
    }
  }
  
  public final void c(int paramInt)
  {
    Object localObject = this.a;
    ((is)localObject).j = paramInt;
    this.a = ((is)localObject);
    localObject = this.b;
    if (localObject != null) {
      ((mn)localObject).i = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ir
 * JD-Core Version:    0.7.0.1
 */