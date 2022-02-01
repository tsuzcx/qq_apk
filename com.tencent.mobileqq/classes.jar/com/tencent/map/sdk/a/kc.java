package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.engine.jni.JNI;

public final class kc
  implements Cloneable
{
  public int a = -1;
  public kc.a b = new kc.a();
  public Rect c = new Rect();
  public int d;
  public double e;
  public double f;
  public double g = 0.0D;
  public double h = 1.0D;
  public double i = 0.0D;
  public double j = 1.0D;
  public double k = 0.0D;
  public double l = 1.0D;
  public GeoPoint m = new GeoPoint();
  public Rect n;
  public lw o;
  public pf p;
  public DoublePoint q = new DoublePoint();
  public kc.b r;
  private Integer s = Integer.valueOf(0);
  
  public kc(lw paramlw)
  {
    this.o = paramlw;
    this.p = paramlw.a;
  }
  
  public final float a(float paramFloat)
  {
    if (this.p.q() == paramFloat) {
      return paramFloat;
    }
    f1 = paramFloat % 360.0F;
    double d1 = Math.toRadians(paramFloat);
    this.g = Math.sin(d1);
    this.h = Math.cos(d1);
    pf localpf = this.p;
    if (localpf != null) {
      try
      {
        localpf.y();
        long l1 = localpf.b;
        if (0L == l1) {}
        for (;;)
        {
          return f1;
          try
          {
            localpf.a.nativeSetRotate(localpf.b, f1, false);
          }
          finally {}
        }
        return f1;
      }
      finally
      {
        localpf.z();
      }
    }
  }
  
  public final boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    kc.b localb = this.r;
    if (localb == null)
    {
      this.r = new kc.b(paramFloat1, paramFloat2);
    }
    else
    {
      localb.a = paramFloat1;
      localb.b = paramFloat2;
    }
    this.o.a(paramFloat1, paramFloat2, paramBoolean);
    return true;
  }
  
  public final boolean a(int paramInt)
  {
    pf localpf = this.p;
    boolean bool = false;
    if (localpf == null) {
      return false;
    }
    int i1 = localpf.r();
    if (i1 == paramInt) {
      return false;
    }
    if (i1 == 11) {
      this.o.b(false);
    }
    if (paramInt == 11) {
      this.o.b(true);
    }
    this.a = paramInt;
    localpf = this.p;
    if ((i1 == paramInt) || (((i1 != 11) || (paramInt == 13)) && ((i1 != 13) || (paramInt == 11)) && ((paramInt != 11) || (i1 == 13)) && ((paramInt != 13) || (i1 == 11)))) {
      bool = true;
    }
    if (0L != localpf.b) {
      localpf.f.a(new pf.24(localpf, paramInt, bool));
    }
    return true;
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    int i1 = this.b.f;
    boolean bool2 = true;
    if (1 << 20 - i1 < 0) {
      i1 = 0;
    } else {
      i1 = 20 - this.b.f;
    }
    if (131072 > i1)
    {
      i2 = (this.n.width() * 131072 - this.n.width() * i1) / 2;
      i1 = (this.n.height() * 131072 - this.n.height() * i1) / 2;
    }
    else
    {
      i1 = 0;
      i2 = 0;
    }
    int i4 = this.c.left - i2;
    int i3 = this.c.right + i2;
    int i2 = this.c.top - i1;
    int i5 = this.c.bottom + i1;
    i1 = paramInt1;
    if (paramInt1 < i2) {
      i1 = i2;
    }
    i2 = i1;
    if (i1 > i5) {
      i2 = i5;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < i4) {
      paramInt1 = i4;
    }
    paramInt2 = paramInt1;
    if (paramInt1 > i3) {
      paramInt2 = i3;
    }
    boolean bool1 = bool2;
    if (i2 == this.m.getLatitudeE6()) {
      if (paramInt2 != this.m.getLongitudeE6()) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    this.m.setLatitudeE6(i2);
    this.m.setLongitudeE6(paramInt2);
    Object localObject = kd.a(this, this.m);
    double d1 = ((DoublePoint)localObject).x;
    double d2 = ((DoublePoint)localObject).y;
    this.q.set(d1, d2);
    localObject = this.p;
    GeoPoint localGeoPoint = this.m;
    if (0L != ((pf)localObject).b)
    {
      if (((pf)localObject).f == null) {
        return bool1;
      }
      ((pf)localObject).f.a(new pf.16((pf)localObject, localGeoPoint));
    }
    return bool1;
  }
  
  public final float b(float paramFloat)
  {
    if (this.p.p() == paramFloat) {
      return paramFloat;
    }
    f1 = Math.max(0.0F, Math.min(40.0F, paramFloat));
    double d1 = Math.toRadians(paramFloat);
    this.i = Math.sin(d1);
    this.j = Math.cos(d1);
    d1 = 1.570796326794897D - d1;
    this.l = Math.cos(d1);
    this.k = Math.sin(d1);
    pf localpf = this.p;
    if (localpf != null) {
      try
      {
        localpf.y();
        long l1 = localpf.b;
        if (0L == l1) {}
        for (;;)
        {
          return f1;
          try
          {
            localpf.a.nativeSetSkew(localpf.b, f1, false);
          }
          finally {}
        }
        return f1;
      }
      finally
      {
        localpf.z();
      }
    }
  }
  
  public final boolean b(int paramInt)
  {
    return c(kc.a.a(paramInt)) == kc.c.c;
  }
  
  public final int c(float paramFloat)
  {
    int i2 = kc.c.a;
    float f1 = this.b.e;
    int i3 = this.b.f;
    Object localObject = this.p;
    double d1;
    int i1;
    if (localObject != null)
    {
      d1 = paramFloat;
      if ((0L != ((pf)localObject).b) && (((pf)localObject).f != null)) {
        ((pf)localObject).f.a(new pf.17((pf)localObject, d1));
      }
      paramFloat = this.p.l();
      i1 = this.p.m();
    }
    else
    {
      paramFloat = f1;
      i1 = i3;
    }
    this.b.a(i1, paramFloat);
    if (i1 != i3)
    {
      i1 = kc.c.c;
    }
    else
    {
      i1 = i2;
      if (paramFloat != f1) {
        i1 = kc.c.b;
      }
    }
    if (kc.1.a[(i1 - 1)] == 1)
    {
      d1 = (1 << this.b.f) * 256;
      this.d = ((int)d1);
      Double.isNaN(d1);
      this.e = (d1 / 360.0D);
      Double.isNaN(d1);
      this.f = (d1 / 6.283185307179586D);
    }
    localObject = kd.a(this, this.m);
    this.q.set(((DoublePoint)localObject).x, ((DoublePoint)localObject).y);
    return i1;
  }
  
  public final void c(int paramInt)
  {
    this.b.d = paramInt;
  }
  
  public final Object clone()
  {
    kc localkc = (kc)super.clone();
    localkc.c = new Rect(this.c);
    localkc.b = ((kc.a)this.b.clone());
    localkc.m = new GeoPoint(this.m);
    localkc.q = new DoublePoint(this.q.x, this.q.y);
    return localkc;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof kc)) {
      return false;
    }
    paramObject = (kc)paramObject;
    if (!paramObject.m.equals(this.m)) {
      return false;
    }
    if (!paramObject.b.equals(this.b)) {
      return false;
    }
    return paramObject.a == this.a;
  }
  
  public final int hashCode()
  {
    return toString().hashCode();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = this.m;
    localStringBuilder1.append("mapParam: ");
    StringBuilder localStringBuilder2 = new StringBuilder("center:");
    localStringBuilder2.append(((GeoPoint)localObject).toString());
    localStringBuilder2.append(" ");
    localStringBuilder1.append(localStringBuilder2.toString());
    localObject = new StringBuilder("mode:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" ");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder("mapScale:");
    ((StringBuilder)localObject).append(this.b.toString());
    ((StringBuilder)localObject).append(" ");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder("screenRect:");
    ((StringBuilder)localObject).append(this.n.toString());
    ((StringBuilder)localObject).append(" ");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.kc
 * JD-Core Version:    0.7.0.1
 */