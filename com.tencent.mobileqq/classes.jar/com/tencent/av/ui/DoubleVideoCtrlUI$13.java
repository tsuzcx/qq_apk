package com.tencent.av.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$13
  implements Animation.AnimationListener
{
  DoubleVideoCtrlUI$13(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.b.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showNoAnswerAnimation, onAnimationEnd, seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w(paramAnimation, 1, localStringBuilder.toString());
    if (this.b.aA != null)
    {
      paramAnimation = this.b;
      paramAnimation.c = true;
      paramAnimation.aA.m();
    }
    paramAnimation = this.b.U();
    if (paramAnimation != null) {
      paramAnimation.h(this.a);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = this.b.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showNoAnswerAnimation, onAnimationStart, seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w(paramAnimation, 1, localStringBuilder.toString());
    paramAnimation = this.b.U();
    if (paramAnimation != null) {
      paramAnimation.h(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.13
 * JD-Core Version:    0.7.0.1
 */