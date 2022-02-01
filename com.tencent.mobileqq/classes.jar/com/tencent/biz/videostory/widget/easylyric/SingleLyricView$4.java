package com.tencent.biz.videostory.widget.easylyric;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

class SingleLyricView$4
  implements ValueAnimator.AnimatorUpdateListener
{
  SingleLyricView$4(SingleLyricView paramSingleLyricView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (SingleLyricView.a(this.a) != null) {
      SingleLyricView.a(this.a).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.SingleLyricView.4
 * JD-Core Version:    0.7.0.1
 */