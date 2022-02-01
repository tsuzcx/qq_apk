package com.tencent.luggage.wxa.ks;

import android.graphics.PointF;
import android.view.animation.Interpolator;

public class d$a
  implements Interpolator
{
  protected PointF a;
  protected PointF b;
  protected PointF c = new PointF();
  protected PointF d = new PointF();
  protected PointF e = new PointF();
  private int g = 0;
  private final PointF h = new PointF();
  private final PointF i = new PointF();
  
  public d$a(d paramd, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(paramd, new PointF(paramFloat1, paramFloat2), new PointF(paramFloat3, paramFloat4));
  }
  
  public d$a(d paramd, PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1.x >= 0.0F) && (paramPointF1.x <= 1.0F))
    {
      if ((paramPointF2.x >= 0.0F) && (paramPointF2.x <= 1.0F))
      {
        this.a = paramPointF1;
        this.b = paramPointF2;
        return;
      }
      throw new IllegalArgumentException("endX value must be in the range [0, 1]");
    }
    throw new IllegalArgumentException("startX value must be in the range [0, 1]");
  }
  
  private float c(float paramFloat)
  {
    return this.e.x + paramFloat * (this.d.x * 2.0F + this.c.x * 3.0F * paramFloat);
  }
  
  private float d(float paramFloat)
  {
    this.e.x = (this.a.x * 3.0F);
    this.d.x = ((this.b.x - this.a.x) * 3.0F - this.e.x);
    this.c.x = (1.0F - this.e.x - this.d.x);
    return paramFloat * (this.e.x + (this.d.x + this.c.x * paramFloat) * paramFloat);
  }
  
  protected float a(float paramFloat)
  {
    this.e.y = (this.a.y * 3.0F);
    this.d.y = ((this.b.y - this.a.y) * 3.0F - this.e.y);
    this.c.y = (1.0F - this.e.y - this.d.y);
    return paramFloat * (this.e.y + (this.d.y + this.c.y * paramFloat) * paramFloat);
  }
  
  protected float b(float paramFloat)
  {
    int j = 1;
    float f1 = paramFloat;
    while (j < 14)
    {
      float f2 = d(f1) - paramFloat;
      if (Math.abs(f2) < 0.001D) {
        return f1;
      }
      f1 -= f2 / c(f1);
      j += 1;
    }
    return f1;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return a(b(paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ks.d.a
 * JD-Core Version:    0.7.0.1
 */