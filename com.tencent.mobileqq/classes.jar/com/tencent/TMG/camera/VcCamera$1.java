package com.tencent.TMG.camera;

import android.hardware.Camera;
import com.tencent.TMG.utils.QLog;

class VcCamera$1
  implements Runnable
{
  VcCamera$1(VcCamera paramVcCamera, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.mCamera == null) {
      return;
    }
    if (this.val$needRestartPreview) {
      try
      {
        if (this.this$0.mCallbackBufferAddStrategy.getIsUseBuffer()) {
          this.this$0.mCamera.setPreviewCallbackWithBuffer(null);
        } else {
          this.this$0.mCamera.setPreviewCallback(null);
        }
        this.this$0.mCamera.stopPreview();
        VcCamera.access$000(this.this$0, this.val$fps);
        this.this$0.mCallbackBufferAddStrategy.setCameraCaptureSettings(this.this$0.VideoChatSettings);
        this.this$0.mCallbackBufferAddStrategy.fistAdd(this.this$0.mCamera);
        if (this.this$0.mCallbackBufferAddStrategy.getIsUseBuffer()) {
          this.this$0.mCamera.setPreviewCallbackWithBuffer(VcCamera.access$100(this.this$0));
        } else {
          this.this$0.mCamera.setPreviewCallback(VcCamera.access$100(this.this$0));
        }
        this.this$0.mCamera.startPreview();
        return;
      }
      catch (Exception localException)
      {
        QLog.d("VcCamera", 0, "setCameraParaDynamic error", localException);
        localException.printStackTrace();
        return;
      }
    }
    VcCamera.access$000(this.this$0, this.val$fps);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.1
 * JD-Core Version:    0.7.0.1
 */