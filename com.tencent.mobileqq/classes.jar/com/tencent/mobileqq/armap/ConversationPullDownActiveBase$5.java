package com.tencent.mobileqq.armap;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;

class ConversationPullDownActiveBase$5
  implements Animator.AnimatorListener
{
  ConversationPullDownActiveBase$5(ConversationPullDownActiveBase paramConversationPullDownActiveBase, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.l();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.l();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.e) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ConversationPullDownActiveBase.5
 * JD-Core Version:    0.7.0.1
 */