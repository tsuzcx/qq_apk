package com.tencent.biz.qqcircle.widgets.animation.interpolator;

import android.graphics.PointF;
import android.view.animation.Interpolator;

public class EaseCubicInterpolator
  implements Interpolator
{
  private final PointF a = new PointF();
  private final PointF b = new PointF();
  private int c = 0;
  
  public EaseCubicInterpolator(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    PointF localPointF = this.a;
    localPointF.x = paramFloat1;
    localPointF.y = paramFloat2;
    localPointF = this.b;
    localPointF.x = paramFloat3;
    localPointF.y = paramFloat4;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    double d1 = 1.0D - paramDouble1;
    double d2 = paramDouble1 * paramDouble1;
    double d3 = d1 * d1;
    return d3 * d1 * paramDouble2 + d3 * 3.0D * paramDouble1 * paramDouble3 + d1 * 3.0D * d2 * paramDouble4 + d2 * paramDouble1 * paramDouble5;
  }
  
  public float getInterpolation(float paramFloat)
  {
    int i = this.c;
    float f = paramFloat;
    while (i < 4096)
    {
      f = i * 1.0F / 4096.0F;
      if (a(f, 0.0D, this.a.x, this.b.x, 1.0D) >= paramFloat)
      {
        this.c = i;
        break;
      }
      i += 1;
    }
    double d2 = a(f, 0.0D, this.a.y, this.b.y, 1.0D);
    double d1 = d2;
    if (d2 > 0.999D)
    {
      d1 = 1.0D;
      this.c = 0;
    }
    return (float)d1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.animation.interpolator.EaseCubicInterpolator
 * JD-Core Version:    0.7.0.1
 */