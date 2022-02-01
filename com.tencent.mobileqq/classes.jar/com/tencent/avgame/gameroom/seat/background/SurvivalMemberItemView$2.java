package com.tencent.avgame.gameroom.seat.background;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class SurvivalMemberItemView$2
  extends D8SafeAnimatorListener
{
  SurvivalMemberItemView$2(SurvivalMemberItemView paramSurvivalMemberItemView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.a.a != null) {
      this.a.a.a(0);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.a != null) {
      this.a.a.a(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalMemberItemView.2
 * JD-Core Version:    0.7.0.1
 */