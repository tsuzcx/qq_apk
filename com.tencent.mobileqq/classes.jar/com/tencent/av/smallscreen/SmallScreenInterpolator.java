package com.tencent.av.smallscreen;

import android.view.animation.Interpolator;

public class SmallScreenInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    if (0.8571429F < paramFloat) {
      return 1.0F;
    }
    double d = paramFloat * 7.0F / 6.0F + 1.0F;
    Double.isNaN(d);
    return 0.5F + (float)(Math.cos(d * 3.141592653589793D) / 2.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenInterpolator
 * JD-Core Version:    0.7.0.1
 */