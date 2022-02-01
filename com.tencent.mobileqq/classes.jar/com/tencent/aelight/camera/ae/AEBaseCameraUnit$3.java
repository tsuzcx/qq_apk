package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;

class AEBaseCameraUnit$3
  implements AECameraManager.CameraOpenCallback
{
  AEBaseCameraUnit$3(AEBaseCameraUnit paramAEBaseCameraUnit) {}
  
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    String str = this.a.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryOpenCamera result=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", whichCamera=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", mActivityResume=");
    localStringBuilder.append(this.a.jdField_a_of_type_Boolean);
    AEQLog.b(str, localStringBuilder.toString());
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView != null) {
        this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.onChangeCamera(paramInt);
      }
      if (this.a.a()) {
        CameraHelper.a(paramInt);
      }
      if (!this.a.jdField_a_of_type_Boolean)
      {
        this.a.b(false);
        return;
      }
      this.a.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEBaseCameraUnit.3
 * JD-Core Version:    0.7.0.1
 */