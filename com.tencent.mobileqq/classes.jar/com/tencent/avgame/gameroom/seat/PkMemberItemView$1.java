package com.tencent.avgame.gameroom.seat;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class PkMemberItemView$1
  extends D8SafeAnimatorListener
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkMemberItemView.1
 * JD-Core Version:    0.7.0.1
 */