package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.animation.Interpolator;

final class XViewPager$2
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.2
 * JD-Core Version:    0.7.0.1
 */