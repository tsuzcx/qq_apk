package com.tencent.mm.plugin.appbrand.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class bm$7
  implements ValueAnimator.AnimatorUpdateListener
{
  bm$7(bm parambm) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.getView().setScrollY(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bm.7
 * JD-Core Version:    0.7.0.1
 */