package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class BubbleInterActiveAnim$6
  extends AnimatorListenerAdapter
{
  BubbleInterActiveAnim$6(BubbleInterActiveAnim paramBubbleInterActiveAnim, ObjectAnimator paramObjectAnimator, BubbleInterActiveAnim.AnimHolder paramAnimHolder) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "animHolder.animView.startAnimation!");
    }
    paramAnimator = this.a;
    if (paramAnimator != null) {
      paramAnimator.start();
    }
    paramAnimator = this.b;
    if (paramAnimator != null)
    {
      if (paramAnimator.c == null) {
        return;
      }
      if (this.b.c.istroop == 0) {
        paramAnimator = "1";
      }
      for (;;)
      {
        break;
        if (this.b.c.istroop == 1) {
          paramAnimator = "2";
        } else if (this.b.c.istroop == 3000) {
          paramAnimator = "3";
        } else {
          paramAnimator = "";
        }
      }
      VasWebviewUtil.a("", "Bubble", "Active_dync", paramAnimator, 1, 0, 0, "", String.valueOf(SVIPHandlerConstants.a(this.b.c.vipBubbleID)), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.6
 * JD-Core Version:    0.7.0.1
 */