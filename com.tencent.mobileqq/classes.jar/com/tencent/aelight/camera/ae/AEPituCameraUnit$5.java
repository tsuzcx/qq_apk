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
    AEPituCameraUnit.c(this.a);
    if ((this.a.k != null) && (!this.a.d.isFrontCamera()))
    {
      this.a.k.a(paramMotionEvent);
      this.a.d.requestCameraFocus(paramMotionEvent.getX(), paramMotionEvent.getY(), this.a.h.getSurfaceWidth(), this.a.h.getSurfaceHeight());
      if (QLog.isColorLevel()) {
        QLog.d(this.a.a, 2, new Object[] { "", "CameraFocusGesture isRecording == false" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.5
 * JD-Core Version:    0.7.0.1
 */