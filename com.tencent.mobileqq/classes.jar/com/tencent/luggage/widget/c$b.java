package com.tencent.luggage.widget;

import android.graphics.PointF;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.List;

public final class c$b
{
  private final float b;
  private final PointF c;
  private final PointF d;
  private long e = 500L;
  private int f = 2;
  private int g = 1;
  private boolean h = true;
  private boolean i = true;
  private c.d j;
  
  private c$b(c paramc, float paramFloat, PointF paramPointF)
  {
    this.b = paramFloat;
    this.c = paramPointF;
    this.d = null;
  }
  
  private c$b(c paramc, float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    this.b = paramFloat;
    this.c = paramPointF1;
    this.d = paramPointF2;
  }
  
  private c$b(c paramc, PointF paramPointF)
  {
    this.b = c.f(paramc);
    this.c = paramPointF;
    this.d = null;
  }
  
  @NonNull
  private b b(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  @NonNull
  private b b(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  @NonNull
  public b a(int paramInt)
  {
    if (c.e().contains(Integer.valueOf(paramInt)))
    {
      this.f = paramInt;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown easing type: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @NonNull
  public b a(long paramLong)
  {
    this.e = paramLong;
    return this;
  }
  
  @NonNull
  public b a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public void a()
  {
    if ((c.o(this.a) != null) && (c.a.b(c.o(this.a)) != null)) {
      try
      {
        c.a.b(c.o(this.a)).c();
      }
      catch (Exception localException)
      {
        Log.w(c.d(), "Error thrown by animation listener", localException);
      }
    }
    int k = this.a.getPaddingLeft();
    int m = (this.a.getWidth() - this.a.getPaddingRight() - this.a.getPaddingLeft()) / 2;
    int n = this.a.getPaddingTop();
    int i1 = (this.a.getHeight() - this.a.getPaddingBottom() - this.a.getPaddingTop()) / 2;
    float f1 = c.c(this.a, this.b);
    if (this.i) {
      localObject = c.a(this.a, this.c.x, this.c.y, f1, new PointF());
    } else {
      localObject = this.c;
    }
    c.a(this.a, new c.a(null));
    c.a.a(c.o(this.a), c.f(this.a));
    c.a.b(c.o(this.a), f1);
    c.a.a(c.o(this.a), System.currentTimeMillis());
    c.a.a(c.o(this.a), (PointF)localObject);
    c.a.b(c.o(this.a), this.a.getCenter());
    c.a.c(c.o(this.a), (PointF)localObject);
    c.a.d(c.o(this.a), this.a.b((PointF)localObject));
    c.a.e(c.o(this.a), new PointF(k + m, n + i1));
    c.a.b(c.o(this.a), this.e);
    c.a.a(c.o(this.a), this.h);
    c.a.a(c.o(this.a), this.f);
    c.a.b(c.o(this.a), this.g);
    c.a.a(c.o(this.a), System.currentTimeMillis());
    c.a.a(c.o(this.a), this.j);
    Object localObject = this.d;
    if (localObject != null)
    {
      float f2 = ((PointF)localObject).x - c.a.l(c.o(this.a)).x * f1;
      float f3 = this.d.y - c.a.l(c.o(this.a)).y * f1;
      localObject = new c.g(f1, new PointF(f2, f3), null);
      c.a(this.a, true, (c.g)localObject);
      c.a.e(c.o(this.a), new PointF(this.d.x + (c.g.b((c.g)localObject).x - f2), this.d.y + (c.g.b((c.g)localObject).y - f3)));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.c.b
 * JD-Core Version:    0.7.0.1
 */