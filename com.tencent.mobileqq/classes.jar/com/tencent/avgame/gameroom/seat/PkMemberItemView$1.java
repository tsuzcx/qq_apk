package com.tencent.avgame.gameroom.seat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class PkMemberItemView$1
  implements Animator.AnimatorListener
{
  PkMemberItemView$1(PkMemberItemView paramPkMemberItemView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkMemberItemView.1
 * JD-Core Version:    0.7.0.1
 */