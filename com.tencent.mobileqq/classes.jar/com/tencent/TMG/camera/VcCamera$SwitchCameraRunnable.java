package com.tencent.TMG.camera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.tencent.TMG.camera.opengl.SurfaceTextureManager;
import com.tencent.TMG.utils.QLog;
import java.lang.ref.WeakReference;

class VcCamera$SwitchCameraRunnable
  implements Runnable
{
  int mCameraId = 0;
  
  VcCamera$SwitchCameraRunnable(VcCamera paramVcCamera, int paramInt)
  {
    this.mCameraId = paramInt;
  }
  
  public void run()
  {
    if ((this.this$0.NUM_CAMERA < 2) || (this.this$0.mCamera == null)) {}
    while (this.mCameraId == this.this$0.CUR_CAMERA) {
      return;
    }
    this.this$0.closeInternal();
    if (this.mCameraId == 0)
    {
      if (!VcCamera.access$500(this.this$0)) {
        break label397;
      }
      VcCamera.access$200(this.this$0, this.this$0.VideoChatSettings.width, this.this$0.VideoChatSettings.height);
    }
    label397:
    for (int i = 1;; i = 0) {
      for (;;)
      {
        synchronized (this.this$0.holderLock)
        {
          if (VcCamera.mHolder == null)
          {
            localSurfaceHolder1 = null;
            if (!VcCamera.access$300(this.this$0)) {
              break label339;
            }
            this.this$0.mSurfaceTextureManager.init();
            SurfaceTexture localSurfaceTexture = this.this$0.mSurfaceTextureManager.getSurfaceTexture();
            ??? = localSurfaceTexture;
            if (localSurfaceTexture == null)
            {
              QLog.d("VcCamera", 0, "switchCamera surfaceTexture == null");
              i = 0;
              ??? = localSurfaceTexture;
            }
            if (i == 0) {
              break;
            }
            try
            {
              this.this$0.mCallbackBufferAddStrategy.setCameraCaptureSettings(this.this$0.VideoChatSettings);
              this.this$0.mCallbackBufferAddStrategy.fistAdd(this.this$0.mCamera);
              if (!this.this$0.mCallbackBufferAddStrategy.getIsUseBuffer()) {
                break label358;
              }
              this.this$0.mCamera.setPreviewCallbackWithBuffer(VcCamera.access$100(this.this$0));
              if (!VcCamera.access$300(this.this$0)) {
                break label378;
              }
              this.this$0.mCamera.setPreviewTexture(???);
              this.this$0.mCamera.startPreview();
              return;
            }
            catch (Exception localException) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("VcCamera", 0, "setPreviewDisplay error", localException);
            return;
            if (!VcCamera.access$600(this.this$0)) {
              break label397;
            }
            VcCamera.access$200(this.this$0, this.this$0.VideoChatSettings.width, this.this$0.VideoChatSettings.height);
            i = 1;
            continue;
          }
          SurfaceHolder localSurfaceHolder1 = (SurfaceHolder)VcCamera.mHolder.get();
        }
        label339:
        Object localObject2;
        if (localSurfaceHolder2 == null)
        {
          QLog.d("VcCamera", 0, "switchCamera holder == null");
          localObject2 = null;
          i = 0;
          continue;
          label358:
          this.this$0.mCamera.setPreviewCallback(VcCamera.access$100(this.this$0));
          continue;
          label378:
          this.this$0.mCamera.setPreviewDisplay(localSurfaceHolder2);
        }
        else
        {
          localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.SwitchCameraRunnable
 * JD-Core Version:    0.7.0.1
 */