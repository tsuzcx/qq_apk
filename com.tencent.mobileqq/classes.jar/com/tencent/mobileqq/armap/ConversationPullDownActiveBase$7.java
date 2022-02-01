package com.tencent.mobileqq.armap;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;

class ConversationPullDownActiveBase$7
  implements Animator.AnimatorListener
{
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    paramAnimator.topMargin = (-this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.a);
    this.b.setLayoutParams(paramAnimator);
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.e)
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    paramAnimator.topMargin = (-this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.a);
    this.b.setLayoutParams(paramAnimator);
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.e)
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.e) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ConversationPullDownActiveBase.7
 * JD-Core Version:    0.7.0.1
 */