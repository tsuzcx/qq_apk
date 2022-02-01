package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

class BusinessEggsAnimation$2$1
  extends D8SafeAnimatorListener
{
  BusinessEggsAnimation$2$1(BusinessEggsAnimation.2 param2) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!BusinessEggsAnimation.a(this.a.a).isEmpty())
    {
      paramAnimator = (BusinessEggsElement)BusinessEggsAnimation.a(this.a.a).remove();
      BusinessEggsAnimation.b(this.a.a).add(paramAnimator);
      paramAnimator.b();
      if (QLog.isColorLevel()) {
        QLog.i("BusinessEggsAnimation", 2, "[onAnimationEnd]");
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsAnimation.2.1
 * JD-Core Version:    0.7.0.1
 */