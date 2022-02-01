package com.tencent.avgame.gameroom.seat;

import android.animation.Animator;
import android.widget.TextView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class MemberItemView$1
  extends D8SafeAnimatorListener
{
  MemberItemView$1(MemberItemView paramMemberItemView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.b.setTextColor(-1);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.g.setVisibility(4);
    this.a.b.setTextColor(-1);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.g.setVisibility(0);
    this.a.b.setTextColor(-14558778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.MemberItemView.1
 * JD-Core Version:    0.7.0.1
 */