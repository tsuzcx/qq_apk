package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraManagerListener;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderView;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.perf.AELaunchRecorder;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEPituCameraUnit$1
  implements AECameraManager.CameraManagerListener
{
  AEPituCameraUnit$1(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onCameraPreviewSizeChanged(int paramInt1, int paramInt2)
  {
    String str = this.a.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCameraPreviewSizeChanged---width=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height=");
    localStringBuilder.append(paramInt2);
    AEQLog.b(str, localStringBuilder.toString());
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView != null) {
      this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.onCameraPreviewSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onCameraPreviewStarted()
  {
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView != null) {
      this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.onCameraPreviewStarted();
    }
  }
  
  public void onCameraStarted(boolean paramBoolean, String paramString)
  {
    String str = this.a.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCameraStarted--success=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(paramString);
    AEQLog.b(str, localStringBuilder.toString());
    this.a.a(paramBoolean, paramString);
    if (paramBoolean) {
      AELaunchRecorder.a().a("onCameraStart");
    }
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.1.1(this));
    } else if (this.a.jdField_a_of_type_ComTencentAelightCameraAeViewAECameraErrorDialog != null) {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.1.2(this));
    }
    int i = AEBeautyProviderView.a();
    int j = AEBeautyProviderView.b();
    this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.a(i);
    this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.b(j);
    this.a.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(458753, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.1
 * JD-Core Version:    0.7.0.1
 */