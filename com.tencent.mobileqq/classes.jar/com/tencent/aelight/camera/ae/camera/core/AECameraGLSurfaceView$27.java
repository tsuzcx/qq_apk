package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener;
import com.tencent.qphone.base.util.QLog;

class AECameraGLSurfaceView$27
  implements HWEncodeListener
{
  AECameraGLSurfaceView$27(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Test Video  onEncodeError:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(paramThrowable.getMessage());
    QLog.e("AECameraGLSurfaceView", 4, localStringBuilder.toString());
  }
  
  public void onEncodeFinish(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Test Video onEncodeFinish:");
    localStringBuilder.append(paramString);
    QLog.i("AECameraGLSurfaceView", 4, localStringBuilder.toString());
  }
  
  public void onEncodeFrame() {}
  
  public void onEncodeStart()
  {
    QLog.i("AECameraGLSurfaceView", 4, "Test Video onEncodeStart.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.27
 * JD-Core Version:    0.7.0.1
 */