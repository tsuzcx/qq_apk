package com.tencent.avgame.gameroom.seat;

import android.animation.Animator;
import android.view.View;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class PkMemberItemView$3
  extends D8SafeAnimatorListener
{
  PkMemberItemView$3(PkMemberItemView paramPkMemberItemView, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = this.b;
    PkMemberItemView.a(paramAnimator, paramAnimator, this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.b;
    PkMemberItemView.a(paramAnimator, paramAnimator, this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkMemberItemView.3
 * JD-Core Version:    0.7.0.1
 */