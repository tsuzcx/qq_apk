package com.tencent.map.core.functions.animation;

import android.view.animation.Interpolator;

public class GlRotateAnimation
  extends GlAnimation
{
  private float a = 0.0F;
  private float b = 0.0F;
  private float c = 0.0F;
  private float d = 0.0F;
  private float e = 0.0F;
  
  public GlRotateAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.e = paramFloat5;
  }
  
  protected void performAnimation(float paramFloat, Interpolator paramInterpolator)
  {
    float f1 = this.b;
    float f2 = this.a;
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    float f3 = this.a;
    if (this.animationProperty != null) {
      this.animationProperty.setRotate(f3 + (f1 - f2) * paramFloat, this.c, this.d, this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GlRotateAnimation
 * JD-Core Version:    0.7.0.1
 */