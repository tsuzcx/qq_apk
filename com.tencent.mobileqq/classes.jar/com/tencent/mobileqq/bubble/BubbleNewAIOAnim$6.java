package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.AvatarPendantManager;

class BubbleNewAIOAnim$6
  extends AnimatorListenerAdapter
{
  BubbleNewAIOAnim$6(BubbleNewAIOAnim paramBubbleNewAIOAnim, BubbleNewAnimConf.PendantAnimConf paramPendantAnimConf) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.d != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.e != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.d.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.e.setVisibility(0);
      paramAnimator = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      paramAnimator.jdField_a_of_type_Long = -1L;
      BubbleNewAIOAnim localBubbleNewAIOAnim = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("show pendant, ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.jdField_a_of_type_Long);
      localBubbleNewAIOAnim.a(localStringBuilder.toString());
      paramAnimator.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.c != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.c.setVisibility(0);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.d != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.e != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.d.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.e.setVisibility(4);
      paramAnimator = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      BubbleNewAIOAnim localBubbleNewAIOAnim = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop show pendant, ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.jdField_a_of_type_Long);
      localBubbleNewAIOAnim.a(localStringBuilder.toString());
      paramAnimator.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.jdField_a_of_type_Long;
      paramAnimator.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.c != null) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAnimConf$PendantAnimConf.e))) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.c.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAIOAnim.6
 * JD-Core Version:    0.7.0.1
 */