package com.tencent.mm.plugin.appbrand.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ah$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ah$2(ah paramah) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.getContentView().setScrollY(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ah.2
 * JD-Core Version:    0.7.0.1
 */