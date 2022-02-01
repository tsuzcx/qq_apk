package com.tencent.aelight.camera.aebase.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class QIMCameraSegmentCaptureButtonLayoutNew$6
  extends AnimatorListenerAdapter
{
  QIMCameraSegmentCaptureButtonLayoutNew$6(QIMCameraSegmentCaptureButtonLayoutNew paramQIMCameraSegmentCaptureButtonLayoutNew, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("scaleAnimator end, shortVideoShot:");
      paramAnimator.append(this.b.a.get());
      paramAnimator.append(" segmentShot:");
      paramAnimator.append(this.b.B.get());
      paramAnimator.append(", mActionUpAnimator:");
      paramAnimator.append(this.b.b.get());
      QLog.i("CameraSegmentCaptureLayout", 2, paramAnimator.toString());
    }
    if (!this.b.b.get())
    {
      if (this.a) {
        this.b.a.set(true);
      }
      this.b.B.set(true);
      this.b.w.sendEmptyMessage(2);
      this.b.d();
      this.b.k = System.currentTimeMillis();
      this.b.w.sendEmptyMessage(5);
      this.b.i.setVisibility(0);
    }
    else if (this.a)
    {
      this.b.e();
      this.b.a(1.0F);
    }
    this.b.b.set(false);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSegmentCaptureLayout", 2, "scaleAnimator start!");
    }
    this.b.w.sendEmptyMessageDelayed(9, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QIMCameraSegmentCaptureButtonLayoutNew.6
 * JD-Core Version:    0.7.0.1
 */