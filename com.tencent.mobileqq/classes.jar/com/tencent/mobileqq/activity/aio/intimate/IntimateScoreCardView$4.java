package com.tencent.mobileqq.activity.aio.intimate;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;

class IntimateScoreCardView$4
  implements Animator.AnimatorListener
{
  IntimateScoreCardView$4(IntimateScoreCardView paramIntimateScoreCardView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    IntimateScoreCardView.a(this.a).setAlpha(1.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.IntimateScoreCardView.4
 * JD-Core Version:    0.7.0.1
 */