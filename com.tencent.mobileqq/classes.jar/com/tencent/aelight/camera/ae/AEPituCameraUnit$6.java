package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraZoomGesture.ZoomGestureListener;

class AEPituCameraUnit$6
  implements CameraZoomGesture.ZoomGestureListener
{
  AEPituCameraUnit$6(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(int paramInt)
  {
    String str = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRequestZoom: ");
    localStringBuilder.append(paramInt);
    AEQLog.a(str, localStringBuilder.toString());
    this.a.d.setZoom(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.6
 * JD-Core Version:    0.7.0.1
 */