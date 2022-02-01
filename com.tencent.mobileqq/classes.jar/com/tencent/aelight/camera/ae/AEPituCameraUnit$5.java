package com.tencent.aelight.camera.ae;

import android.view.MotionEvent;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraFocusGesture.FocusGestureListener;
import com.tencent.qphone.base.util.QLog;

class AEPituCameraUnit$5
  implements CameraFocusGesture.FocusGestureListener
{
  AEPituCameraUnit$5(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    AEPituCameraUnit.a(this.a);
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView != null) && (!this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.isFrontCamera()))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.a(paramMotionEvent);
      this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.requestCameraFocus(paramMotionEvent.getX(), paramMotionEvent.getY(), this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.getSurfaceWidth(), this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.getSurfaceHeight());
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, new Object[] { "", "CameraFocusGesture isRecording == false" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.5
 * JD-Core Version:    0.7.0.1
 */