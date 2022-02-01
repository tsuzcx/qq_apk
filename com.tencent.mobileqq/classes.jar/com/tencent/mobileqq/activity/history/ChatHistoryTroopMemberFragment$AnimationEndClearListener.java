package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ChatHistoryTroopMemberFragment$AnimationEndClearListener
  implements Animation.AnimationListener
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.b.postDelayed(new ChatHistoryTroopMemberFragment.AnimationEndClearListener.1(this), 0L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = (String)this.jdField_a_of_type_AndroidViewView.getTag();
    if ((this.jdField_a_of_type_Int == 1) && (paramAnimation.equals("left")))
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_Int = 6;
    }
    if ((this.jdField_a_of_type_Int == 0) && (paramAnimation.equals("right")))
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_Int = 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.AnimationEndClearListener
 * JD-Core Version:    0.7.0.1
 */