package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TroopMemberListActivity$AnimationEndClearListener
  implements Animation.AnimationListener
{
  int jdField_a_of_type_Int = -1;
  View jdField_a_of_type_AndroidViewView;
  
  public TroopMemberListActivity$AnimationEndClearListener(TroopMemberListActivity paramTroopMemberListActivity, View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mHandler.postDelayed(new TroopMemberListActivity.AnimationEndClearListener.1(this), 0L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.AnimationEndClearListener
 * JD-Core Version:    0.7.0.1
 */