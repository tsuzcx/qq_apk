package com.tencent.aelight.camera.ae.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.tencent.aelight.camera.aebase.view.QIMCameraCountTimeLayout;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.concurrent.atomic.AtomicBoolean;

class AEPituCameraCaptureButtonLayout$4
  extends AnimatorListenerAdapter
{
  AEPituCameraCaptureButtonLayout$4(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEQLog.b("CameraCaptureLayout", "scaleAnimator cancel!");
    this.a.u.set(true);
    this.a.E.setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = new StringBuilder();
    paramAnimator.append("scaleAnimator end, shortVideoShot:");
    paramAnimator.append(this.a.t.get());
    paramAnimator.append(", mActionUpAnimator:");
    paramAnimator.append(this.a.u.get());
    AEQLog.b("CameraCaptureLayout", paramAnimator.toString());
    if (!this.a.u.get())
    {
      this.a.t.set(true);
      this.a.Z.sendEmptyMessage(2);
      this.a.q();
      this.a.J = System.currentTimeMillis();
      this.a.Z.sendEmptyMessage(5);
      return;
    }
    this.a.m();
    this.a.a(1.0F);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEQLog.b("CameraCaptureLayout", "scaleAnimator start!");
    this.a.Z.sendEmptyMessage(9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout.4
 * JD-Core Version:    0.7.0.1
 */