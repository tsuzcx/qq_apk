package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.animation.Interpolator;

class DailyTitleBarSwitcher$1
  implements Interpolator
{
  DailyTitleBarSwitcher$1(DailyTitleBarSwitcher paramDailyTitleBarSwitcher) {}
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat < 0.2F) {
      return 0.0F;
    }
    if (paramFloat < 0.5F) {
      return (paramFloat - 0.2F) / 0.3F;
    }
    return 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher.1
 * JD-Core Version:    0.7.0.1
 */