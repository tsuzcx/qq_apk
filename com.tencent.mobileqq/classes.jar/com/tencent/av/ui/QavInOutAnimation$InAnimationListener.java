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
      if (this.a.a != null) {
        this.a.a.b();
      }
      return;
    }
    catch (Exception paramAnimation)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QavInOutAnimation", 2, "QavInAnimationListener onAnimationEnd Exception :" + paramAnimation);
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
      if (this.a.a != null) {
        this.a.a.a();
      }
      return;
    }
    catch (Exception paramAnimation)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QavInOutAnimation", 2, "QavInAnimationListener onAnimationStart Exception :" + paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavInOutAnimation.InAnimationListener
 * JD-Core Version:    0.7.0.1
 */