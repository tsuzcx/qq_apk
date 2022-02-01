package com.tencent.mobileqq.activity.emogroupstore;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ProgressBar;

final class SDKSetEmotionHelper$1
  implements ValueAnimator.AnimatorUpdateListener
{
  SDKSetEmotionHelper$1(ProgressBar paramProgressBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ProgressBar localProgressBar = this.a;
    if (localProgressBar != null) {
      localProgressBar.setProgress(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKSetEmotionHelper.1
 * JD-Core Version:    0.7.0.1
 */