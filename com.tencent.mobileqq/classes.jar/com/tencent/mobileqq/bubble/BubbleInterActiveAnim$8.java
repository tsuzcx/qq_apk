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
    paramAnimator = this.a;
    if ((paramAnimator != null) && (paramAnimator.d != null))
    {
      if (this.a.d.istroop == 0) {
        paramAnimator = "1";
      }
      for (;;)
      {
        break;
        if (this.a.d.istroop == 1) {
          paramAnimator = "2";
        } else if (this.a.d.istroop == 3000) {
          paramAnimator = "3";
        } else {
          paramAnimator = "";
        }
      }
      VasWebviewUtil.a("", "Bubble", "Passive_dync", paramAnimator, 1, 0, 0, "", String.valueOf(SVIPHandlerConstants.a(this.a.d.vipBubbleID)), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.8
 * JD-Core Version:    0.7.0.1
 */