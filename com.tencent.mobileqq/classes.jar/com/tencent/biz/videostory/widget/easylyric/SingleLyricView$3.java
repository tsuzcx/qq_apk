package com.tencent.biz.videostory.widget.easylyric;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;

class SingleLyricView$3
  extends AnimatorListenerAdapter
{
  SingleLyricView$3(SingleLyricView paramSingleLyricView, String paramString) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (SingleLyricView.b(this.b) != null) {
      SingleLyricView.b(this.b).setText(this.a);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (SingleLyricView.b(this.b) != null)
    {
      SingleLyricView.b(this.b).setText(this.a);
      SingleLyricView.b(this.b).setAlpha(0.3F);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    SingleLyricView.b(this.b).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.SingleLyricView.3
 * JD-Core Version:    0.7.0.1
 */