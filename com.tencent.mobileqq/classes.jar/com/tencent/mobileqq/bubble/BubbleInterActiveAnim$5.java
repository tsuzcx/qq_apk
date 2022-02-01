package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class BubbleInterActiveAnim$5
  extends AnimatorListenerAdapter
{
  BubbleInterActiveAnim$5(BubbleInterActiveAnim paramBubbleInterActiveAnim, ObjectAnimator paramObjectAnimator, BubbleInterActiveAnim.AnimHolder paramAnimHolder) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "animHolder.animView.startAnimation!");
    }
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.a != null))
    {
      paramAnimator = "";
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.a.istroop != 0) {
        break label98;
      }
      paramAnimator = "1";
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "Bubble", "Active_dync", paramAnimator, 1, 0, 0, "", String.valueOf(SVIPHandler.a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.a.vipBubbleID)), "");
      return;
      label98:
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.a.istroop == 1) {
        paramAnimator = "2";
      } else if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.a.istroop == 3000) {
        paramAnimator = "3";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.5
 * JD-Core Version:    0.7.0.1
 */