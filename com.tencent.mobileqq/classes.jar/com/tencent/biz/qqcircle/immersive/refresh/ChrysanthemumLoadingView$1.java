package com.tencent.biz.qqcircle.immersive.refresh;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ChrysanthemumLoadingView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ChrysanthemumLoadingView$1(ChrysanthemumLoadingView paramChrysanthemumLoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ChrysanthemumLoadingView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.refresh.ChrysanthemumLoadingView.1
 * JD-Core Version:    0.7.0.1
 */