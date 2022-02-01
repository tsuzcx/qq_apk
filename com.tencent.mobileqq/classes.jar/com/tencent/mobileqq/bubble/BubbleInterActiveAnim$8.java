package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class BubbleInterActiveAnim$8
  extends AnimatorListenerAdapter
{
  BubbleInterActiveAnim$8(BubbleInterActiveAnim paramBubbleInterActiveAnim, BubbleInterActiveAnim.AnimHolder paramAnimHolder) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "animHolder.animView.startPassiveAnimator!");
    }
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder;
    if ((paramAnimator != null) && (paramAnimator.b != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.b.istroop == 0) {
        paramAnimator = "1";
      }
      for (;;)
      {
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.b.istroop == 1) {
          paramAnimator = "2";
        } else if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.b.istroop == 3000) {
          paramAnimator = "3";
        } else {
          paramAnimator = "";
        }
      }
      VasWebviewUtil.a("", "Bubble", "Passive_dync", paramAnimator, 1, 0, 0, "", String.valueOf(SVIPHandlerConstants.a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.b.vipBubbleID)), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.8
 * JD-Core Version:    0.7.0.1
 */