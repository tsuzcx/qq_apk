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
    if (this.this$0.NUM_CAMERA >= 2)
    {
      if (this.this$0.mCamera == null) {
        return;
      }
      if (this.mCameraId == this.this$0.CUR_CAMERA) {
        return;
      }
      this.this$0.closeInternal();
      int j = this.mCameraId;
      int i = 1;
      Object localObject1;
      if (j == 0)
      {
        if (VcCamera.access$500(this.this$0))
        {
          localObject1 = this.this$0;
          VcCamera.access$200((VcCamera)localObject1, ((VcCamera)localObject1).VideoChatSettings.width, this.this$0.VideoChatSettings.height);
          break label135;
        }
      }
      else if (VcCamera.access$600(this.this$0))
      {
        localObject1 = this.this$0;
        VcCamera.access$200((VcCamera)localObject1, ((VcCamera)localObject1).VideoChatSettings.width, this.this$0.VideoChatSettings.height);
        break label135;
      }
      i = 0;
      label135:
      synchronized (this.this$0.holderLock)
      {
        Object localObject3 = VcCamera.mHolder;
        localObject1 = null;
        SurfaceTexture localSurfaceTexture = null;
        if (localObject3 == null) {
          localObject3 = null;
        } else {
          localObject3 = (SurfaceHolder)VcCamera.mHolder.get();
        }
        if (VcCamera.access$300(this.this$0))
        {
          this.this$0.mSurfaceTextureManager.init();
          localSurfaceTexture = this.this$0.mSurfaceTextureManager.getSurfaceTexture();
          localObject1 = localSurfaceTexture;
          if (localSurfaceTexture != null) {
            break label254;
          }
          QLog.d("VcCamera", 0, "switchCamera surfaceTexture == null");
          localObject1 = localSurfaceTexture;
        }
        else
        {
          if (localObject3 != null) {
            break label254;
          }
          QLog.d("VcCamera", 0, "switchCamera holder == null");
          localObject1 = localSurfaceTexture;
        }
        i = 0;
        label254:
        if (i == 0) {
          return;
        }
        try
        {
          this.this$0.mCallbackBufferAddStrategy.setCameraCaptureSettings(this.this$0.VideoChatSettings);
          this.this$0.mCallbackBufferAddStrategy.fistAdd(this.this$0.mCamera);
          if (this.this$0.mCallbackBufferAddStrategy.getIsUseBuffer()) {
            this.this$0.mCamera.setPreviewCallbackWithBuffer(VcCamera.access$100(this.this$0));
          } else {
            this.this$0.mCamera.setPreviewCallback(VcCamera.access$100(this.this$0));
          }
          if (VcCamera.access$300(this.this$0)) {
            this.this$0.mCamera.setPreviewTexture((SurfaceTexture)localObject1);
          } else {
            this.this$0.mCamera.setPreviewDisplay((SurfaceHolder)localObject3);
          }
          this.this$0.mCamera.startPreview();
          return;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VcCamera", 0, "setPreviewDisplay error", localException);
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.SwitchCameraRunnable
 * JD-Core Version:    0.7.0.1
 */