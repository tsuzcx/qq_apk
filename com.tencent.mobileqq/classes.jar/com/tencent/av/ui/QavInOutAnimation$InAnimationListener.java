package com.tencent.av.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class QavInOutAnimation$InAnimationListener
  implements Animation.AnimationListener
{
  QavInOutAnimation$InAnimationListener(QavInOutAnimation paramQavInOutAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavInOutAnimation", 2, "InAnimation onAnimationEnd");
    }
    try
    {
      if (this.a.a != null)
      {
        this.a.a.b();
        return;
      }
    }
    catch (Exception paramAnimation)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QavInAnimationListener onAnimationEnd Exception :");
        localStringBuilder.append(paramAnimation);
        QLog.e("QavInOutAnimation", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavInOutAnimation", 2, "InAnimation onAnimationStart");
    }
    try
    {
      if (this.a.a != null)
      {
        this.a.a.a();
        return;
      }
    }
    catch (Exception paramAnimation)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QavInAnimationListener onAnimationStart Exception :");
        localStringBuilder.append(paramAnimation);
        QLog.e("QavInOutAnimation", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavInOutAnimation.InAnimationListener
 * JD-Core Version:    0.7.0.1
 */