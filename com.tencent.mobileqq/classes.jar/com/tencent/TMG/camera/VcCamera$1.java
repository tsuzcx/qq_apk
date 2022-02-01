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
      for (;;)
      {
        try
        {
          if (this.this$0.mCallbackBufferAddStrategy.getIsUseBuffer())
          {
            this.this$0.mCamera.setPreviewCallbackWithBuffer(null);
            this.this$0.mCamera.stopPreview();
            VcCamera.access$000(this.this$0, this.val$fps);
            this.this$0.mCallbackBufferAddStrategy.setCameraCaptureSettings(this.this$0.VideoChatSettings);
            this.this$0.mCallbackBufferAddStrategy.fistAdd(this.this$0.mCamera);
            if (!this.this$0.mCallbackBufferAddStrategy.getIsUseBuffer()) {
              break label167;
            }
            this.this$0.mCamera.setPreviewCallbackWithBuffer(VcCamera.access$100(this.this$0));
            this.this$0.mCamera.startPreview();
            return;
          }
        }
        catch (Exception localException)
        {
          QLog.d("VcCamera", 0, "setCameraParaDynamic error", localException);
          localException.printStackTrace();
          return;
        }
        this.this$0.mCamera.setPreviewCallback(null);
        continue;
        label167:
        this.this$0.mCamera.setPreviewCallback(VcCamera.access$100(this.this$0));
      }
    }
    VcCamera.access$000(this.this$0, this.val$fps);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.1
 * JD-Core Version:    0.7.0.1
 */