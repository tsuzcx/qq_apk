package com.tencent.mm.ui.widget.pulldown;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class WeUIPullDownView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  WeUIPullDownView$1(WeUIPullDownView paramWeUIPullDownView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a((int)f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.WeUIPullDownView.1
 * JD-Core Version:    0.7.0.1
 */