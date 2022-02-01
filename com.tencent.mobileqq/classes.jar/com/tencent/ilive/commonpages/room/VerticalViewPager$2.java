package com.tencent.ilive.commonpages.room;

import android.view.animation.Interpolator;

final class VerticalViewPager$2
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.commonpages.room.VerticalViewPager.2
 * JD-Core Version:    0.7.0.1
 */