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
      paramAnimator.append(this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      paramAnimator.append(" segmentShot:");
      paramAnimator.append(this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.c.get());
      paramAnimator.append(", mActionUpAnimator:");
      paramAnimator.append(this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.b.get());
      QLog.i("CameraSegmentCaptureLayout", 2, paramAnimator.toString());
    }
    if (!this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.b.get())
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.c.set(true);
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.e();
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setVisibility(0);
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.f();
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.a(1.0F);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.b.set(false);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSegmentCaptureLayout", 2, "scaleAnimator start!");
    }
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QIMCameraSegmentCaptureButtonLayoutNew.6
 * JD-Core Version:    0.7.0.1
 */