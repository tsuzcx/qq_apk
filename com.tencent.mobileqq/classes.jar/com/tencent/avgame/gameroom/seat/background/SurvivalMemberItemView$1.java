package com.tencent.avgame.gameroom.seat.background;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class SurvivalMemberItemView$1
  implements Animator.AnimatorListener
{
  SurvivalMemberItemView$1(SurvivalMemberItemView paramSurvivalMemberItemView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.a.a != null) {
      this.a.a.a(2);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.a != null) {
      this.a.a.a(2);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.a != null) {
      this.a.a.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalMemberItemView.1
 * JD-Core Version:    0.7.0.1
 */