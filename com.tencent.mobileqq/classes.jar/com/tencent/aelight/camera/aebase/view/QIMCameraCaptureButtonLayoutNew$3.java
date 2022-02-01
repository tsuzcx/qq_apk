package com.tencent.aelight.camera.aebase.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class QIMCameraCaptureButtonLayoutNew$3
  extends AnimatorListenerAdapter
{
  QIMCameraCaptureButtonLayoutNew$3(QIMCameraCaptureButtonLayoutNew paramQIMCameraCaptureButtonLayoutNew) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "scaleAnimator cancel!");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("scaleAnimator end, shortVideoShot:");
      paramAnimator.append(this.a.a.get());
      paramAnimator.append(", mActionUpAnimator:");
      paramAnimator.append(this.a.b.get());
      QLog.i("QIMCameraCaptureButtonLayoutNew", 2, paramAnimator.toString());
    }
    if (!this.a.b.get())
    {
      this.a.a.set(true);
      this.a.w.sendEmptyMessage(2);
      this.a.d();
      this.a.k = System.currentTimeMillis();
      this.a.w.sendEmptyMessage(5);
    }
    else
    {
      this.a.e();
      this.a.a(1.0F);
    }
    this.a.b.set(false);
    this.a.i.setVisibility(0);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "scaleAnimator start!");
    }
    this.a.w.sendEmptyMessage(9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew.3
 * JD-Core Version:    0.7.0.1
 */