package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.concurrent.atomic.AtomicBoolean;

class AEFlashCameraCaptureButtonLayout$5
  extends AnimatorListenerAdapter
{
  AEFlashCameraCaptureButtonLayout$5(AEFlashCameraCaptureButtonLayout paramAEFlashCameraCaptureButtonLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEQLog.b("AEFlashCameraCaptureButtonLayout", "scaleAnimator cancel!");
    this.a.r.set(true);
    AEFlashCameraCaptureButtonLayout.c(this.a).setVisibility(8);
    AEFlashCameraCaptureButtonLayout.d(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = new StringBuilder();
    paramAnimator.append("scaleAnimator end, shortVideoShot:");
    paramAnimator.append(this.a.q.get());
    paramAnimator.append(", mActionUpAnimator:");
    paramAnimator.append(this.a.r.get());
    AEQLog.b("AEFlashCameraCaptureButtonLayout", paramAnimator.toString());
    if (!this.a.r.get())
    {
      this.a.q.set(true);
      this.a.s.sendEmptyMessage(2);
      this.a.p = System.currentTimeMillis();
      this.a.s.sendEmptyMessage(5);
      return;
    }
    this.a.m();
    this.a.a(1.0F);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEQLog.b("AEFlashCameraCaptureButtonLayout", "scaleAnimator start!");
    this.a.s.sendEmptyMessage(9);
    AEFlashCameraCaptureButtonLayout.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashCameraCaptureButtonLayout.5
 * JD-Core Version:    0.7.0.1
 */