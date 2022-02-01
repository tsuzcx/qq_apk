package com.tencent.biz.videostory.widget.easylyric;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;

class SingleLyricView$6
  extends AnimatorListenerAdapter
{
  SingleLyricView$6(SingleLyricView paramSingleLyricView) {}
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    if (SingleLyricView.b(this.a) != null) {
      SingleLyricView.b(this.a).setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.SingleLyricView.6
 * JD-Core Version:    0.7.0.1
 */