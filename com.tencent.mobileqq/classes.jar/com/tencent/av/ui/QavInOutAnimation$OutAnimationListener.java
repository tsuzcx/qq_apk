package com.tencent.av.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

class QavInOutAnimation$OutAnimationListener
  implements Animation.AnimationListener
{
  QavInOutAnimation$OutAnimationListener(QavInOutAnimation paramQavInOutAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavInOutAnimation", 2, "OutAnimation onAnimationEnd");
    }
    try
    {
      if ((this.a.x != null) && (this.a.x.k() != null))
      {
        this.a.x.k().bD = false;
        this.a.x.k().bE = false;
      }
      if (this.a.i != null) {
        this.a.i.setVisibility(4);
      }
      if (this.a.b != null) {
        this.a.b.setVisibility(4);
      }
      if (this.a.c != null) {
        this.a.c.setVisibility(4);
      }
      if (this.a.d != null) {
        this.a.d.setVisibility(4);
      }
      if (this.a.e != null) {
        this.a.e.setVisibility(4);
      }
      if (this.a.f != null) {
        this.a.f.setVisibility(4);
      }
      if (this.a.h != null) {
        this.a.h.setVisibility(4);
      }
      if (this.a.z != null)
      {
        this.a.z.b();
        return;
      }
    }
    catch (Exception paramAnimation)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QavOutAnimationListener onAnimationEnd Exception :");
        localStringBuilder.append(paramAnimation);
        QLog.e("QavInOutAnimation", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavInOutAnimation", 2, "OutAnimation onAnimationStart");
    }
    try
    {
      if (this.a.z != null)
      {
        this.a.z.a();
        return;
      }
    }
    catch (Exception paramAnimation)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QavOutAnimationListener onAnimationStart Exception :");
        localStringBuilder.append(paramAnimation);
        QLog.e("QavInOutAnimation", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavInOutAnimation.OutAnimationListener
 * JD-Core Version:    0.7.0.1
 */