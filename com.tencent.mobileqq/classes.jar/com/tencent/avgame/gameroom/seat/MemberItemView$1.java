package com.tencent.avgame.gameroom.seat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;

class MemberItemView$1
  implements Animator.AnimatorListener
{
  MemberItemView$1(MemberItemView paramMemberItemView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setVisibility(4);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-14558778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.MemberItemView.1
 * JD-Core Version:    0.7.0.1
 */