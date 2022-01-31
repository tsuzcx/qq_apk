package com.tencent.map.core.functions.animation;

import android.view.animation.Interpolator;

public class GlScaleAnimation
  extends GlAnimation
{
  private float a = 0.0F;
  private float b = 0.0F;
  private float c = 0.0F;
  private float d = 0.0F;
  
  public GlScaleAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  protected void performAnimation(float paramFloat, Interpolator paramInterpolator)
  {
    if (paramFloat < 0.0F) {}
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    do
    {
      return;
      f1 = this.b;
      f2 = this.a;
      f3 = this.d;
      f4 = this.c;
      paramFloat = paramInterpolator.getInterpolation(paramFloat);
      f5 = this.a;
      f6 = this.c;
    } while (this.animationProperty == null);
    this.animationProperty.setScale((f1 - f2) * paramFloat + f5, (f3 - f4) * paramFloat + f6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GlScaleAnimation
 * JD-Core Version:    0.7.0.1
 */