package com.tencent.TMG.camera;

import com.tencent.TMG.sdk.AVVideoCtrl.CameraPreviewChangeCallback;
import com.tencent.TMG.utils.QLog;
import java.lang.ref.WeakReference;

class VcCamera$CameraPreviewChangeRunnable
  implements Runnable
{
  int cameraId = -1;
  
  VcCamera$CameraPreviewChangeRunnable(VcCamera paramVcCamera, int paramInt)
  {
    this.cameraId = paramInt;
  }
  
  public void run()
  {
    QLog.d("VcCamera", 0, "onCameraPreviewChangeCallback run.");
    Object localObject2 = this.this$0.cameraPreviewChangeCallbackLock;
    AVVideoCtrl.CameraPreviewChangeCallback localCameraPreviewChangeCallback = null;
    try
    {
      if (VcCamera.mCameraPreviewChangeCallback != null) {
        localCameraPreviewChangeCallback = (AVVideoCtrl.CameraPreviewChangeCallback)VcCamera.mCameraPreviewChangeCallback.get();
      }
      if (localCameraPreviewChangeCallback != null) {
        localCameraPreviewChangeCallback.onCameraPreviewChangeCallback(this.cameraId);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.CameraPreviewChangeRunnable
 * JD-Core Version:    0.7.0.1
 */