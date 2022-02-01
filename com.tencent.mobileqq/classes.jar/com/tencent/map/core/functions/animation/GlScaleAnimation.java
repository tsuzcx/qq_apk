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
    if (paramFloat < 0.0F) {
      return;
    }
    float f1 = this.b;
    float f2 = this.a;
    float f3 = this.d;
    float f4 = this.c;
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    float f5 = this.a;
    float f6 = this.c;
    if (this.animationProperty != null) {
      this.animationProperty.setScale(f5 + (f1 - f2) * paramFloat, f6 + (f3 - f4) * paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GlScaleAnimation
 * JD-Core Version:    0.7.0.1
 */