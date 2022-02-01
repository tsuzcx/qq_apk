package com.tencent.biz.videostory.widget.easylyric;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;

class SingleLyricView$5
  extends AnimatorListenerAdapter
{
  SingleLyricView$5(SingleLyricView paramSingleLyricView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (SingleLyricView.a(this.a) != null) {
      SingleLyricView.a(this.a).setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.SingleLyricView.5
 * JD-Core Version:    0.7.0.1
 */