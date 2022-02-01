package com.tencent.aelight.camera.ae.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.tencent.aelight.camera.aebase.view.QIMCameraCountTimeLayout;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.concurrent.atomic.AtomicBoolean;

class AEPituCameraCaptureButtonLayout$3
  extends AnimatorListenerAdapter
{
  AEPituCameraCaptureButtonLayout$3(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEQLog.b("CameraCaptureLayout", "scaleAnimator cancel!");
    this.a.b.set(true);
    this.a.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = new StringBuilder();
    paramAnimator.append("scaleAnimator end, shortVideoShot:");
    paramAnimator.append(this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    paramAnimator.append(", mActionUpAnimator:");
    paramAnimator.append(this.a.b.get());
    AEQLog.b("CameraCaptureLayout", paramAnimator.toString());
    if (!this.a.b.get())
    {
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.a.f();
      this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      return;
    }
    this.a.g();
    this.a.a(1.0F);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEQLog.b("CameraCaptureLayout", "scaleAnimator start!");
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout.3
 * JD-Core Version:    0.7.0.1
 */