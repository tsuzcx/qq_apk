package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class QQLSActivity$17
  implements Animation.AnimationListener
{
  QQLSActivity$17(QQLSActivity paramQQLSActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QQLSActivity.B(this.a) != null) {
      QQLSActivity.f(this.a).post(new QQLSActivity.17.1(this));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.17
 * JD-Core Version:    0.7.0.1
 */