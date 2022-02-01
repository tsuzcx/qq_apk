package com.tencent.av.ui;

import android.animation.Animator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

class QavVideoRecordUICtrl$6
  extends D8SafeAnimatorListener
{
  QavVideoRecordUICtrl$6(QavVideoRecordUICtrl paramQavVideoRecordUICtrl) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationCancel");
    }
    this.a.b(3, false);
    if (QavVideoRecordUICtrl.f(this.a) != null) {
      QavVideoRecordUICtrl.f(this.a).requestLayout();
    }
    QavVideoRecordUICtrl.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationEnd");
    }
    this.a.c(3);
    if (QavVideoRecordUICtrl.f(this.a) != null) {
      QavVideoRecordUICtrl.f(this.a).requestLayout();
    }
    QavVideoRecordUICtrl.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationStart");
    }
    QavVideoRecordUICtrl.d(this.a).setVisibility(0);
    QavVideoRecordUICtrl.d(this.a).setAlpha(0.0F);
    QavVideoRecordUICtrl.e(this.a).setVisibility(0);
    QavVideoRecordUICtrl.e(this.a).setAlpha(0.0F);
    QavVideoRecordUICtrl.g(this.a).height = -2;
    QavVideoRecordUICtrl.g(this.a).width = -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.6
 * JD-Core Version:    0.7.0.1
 */