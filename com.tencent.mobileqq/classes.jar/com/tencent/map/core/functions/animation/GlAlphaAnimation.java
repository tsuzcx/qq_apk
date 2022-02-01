package com.tencent.map.core.functions.animation;

import android.view.animation.Interpolator;

public class GlAlphaAnimation
  extends GlAnimation
{
  private float a = 0.0F;
  private float b = 0.0F;
  
  public GlAlphaAnimation(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  protected void performAnimation(float paramFloat, Interpolator paramInterpolator)
  {
    float f1 = this.b;
    float f2 = this.a;
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    float f3 = this.a;
    if (this.animationProperty != null) {
      this.animationProperty.setAlpha((f1 - f2) * paramFloat + f3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GlAlphaAnimation
 * JD-Core Version:    0.7.0.1
 */