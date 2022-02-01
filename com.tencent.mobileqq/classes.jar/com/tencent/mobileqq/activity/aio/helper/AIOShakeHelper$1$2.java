package com.tencent.mobileqq.activity.aio.helper;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class AIOShakeHelper$1$2
  implements Animation.AnimationListener
{
  AIOShakeHelper$1$2(AIOShakeHelper.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel())
    {
      paramAnimation = new StringBuilder();
      paramAnimation.append("animSet onAnimationEnd is called,time is:");
      paramAnimation.append(System.currentTimeMillis());
      QLog.d("Q.aio.BaseChatPie.AIOShakeHelper", 2, paramAnimation.toString());
    }
    AIOShakeHelper.b(this.a.this$0).post(new AIOShakeHelper.1.2.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (QLog.isColorLevel())
    {
      paramAnimation = new StringBuilder();
      paramAnimation.append("animSet onAnimationRepeat is called,time is:");
      paramAnimation.append(System.currentTimeMillis());
      QLog.d("Q.aio.BaseChatPie.AIOShakeHelper", 2, paramAnimation.toString());
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel())
    {
      paramAnimation = new StringBuilder();
      paramAnimation.append("animSet onAnimationStart is called,time is:");
      paramAnimation.append(System.currentTimeMillis());
      QLog.d("Q.aio.BaseChatPie.AIOShakeHelper", 2, paramAnimation.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.1.2
 * JD-Core Version:    0.7.0.1
 */