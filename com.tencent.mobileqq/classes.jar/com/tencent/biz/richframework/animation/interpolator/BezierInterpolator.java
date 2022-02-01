package com.tencent.biz.richframework.animation.interpolator;

import android.view.animation.Interpolator;

public class BezierInterpolator
  implements Interpolator
{
  private float a;
  private float b;
  private float c;
  private float d;
  
  public BezierInterpolator(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.c = paramFloat3;
    this.b = paramFloat2;
    this.d = paramFloat4;
  }
  
  public float getInterpolation(float paramFloat)
  {
    float f = 1.0F - paramFloat;
    double d1 = Math.pow(f, 2.0D);
    double d2 = paramFloat;
    Double.isNaN(d2);
    double d3 = this.b;
    Double.isNaN(d3);
    double d4 = f * 3.0F;
    double d5 = Math.pow(d2, 2.0D);
    Double.isNaN(d4);
    double d6 = this.d;
    Double.isNaN(d6);
    return (float)(d1 * 3.0D * d2 * d3 + d4 * d5 * d6 + Math.pow(d2, 3.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.interpolator.BezierInterpolator
 * JD-Core Version:    0.7.0.1
 */