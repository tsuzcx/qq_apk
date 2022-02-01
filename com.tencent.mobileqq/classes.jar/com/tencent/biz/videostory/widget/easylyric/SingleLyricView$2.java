package com.tencent.biz.videostory.widget.easylyric;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

class SingleLyricView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  SingleLyricView$2(SingleLyricView paramSingleLyricView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (SingleLyricView.b(this.a) != null) {
      SingleLyricView.b(this.a).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.SingleLyricView.2
 * JD-Core Version:    0.7.0.1
 */