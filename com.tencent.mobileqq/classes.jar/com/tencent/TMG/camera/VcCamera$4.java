package com.tencent.TMG.camera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.tencent.TMG.camera.opengl.SurfaceTextureManager;
import com.tencent.TMG.sdk.AVUILoopProxy;
import com.tencent.TMG.utils.QLog;
import java.lang.ref.WeakReference;

class VcCamera$4
  implements Runnable
{
  VcCamera$4(VcCamera paramVcCamera, int paramInt) {}
  
  public void run()
  {
    QLog.d("VcCamera", 0, "openCamera run.");
    boolean bool;
    if (VcCamera.isCameraOpened) {
      bool = true;
    }
    for (;;)
    {
      VcCamera.isCameraOpened = bool;
      AVUILoopProxy.postTaskToMainLooper(new VcCamera.OpenCompleteRunnable(this.this$0, this.this$0, bool));
      QLog.d("VcCamera", 0, "openCamera end.");
      return;
      if (this.this$0.mContext == null)
      {
        QLog.d("VcCamera", 0, "openCamera context == null");
        bool = false;
      }
      else
      {
        synchronized (this.this$0.holderLock)
        {
          SurfaceHolder localSurfaceHolder;
          if (VcCamera.mHolder == null)
          {
            localSurfaceHolder = null;
            if (VcCamera.access$300(this.this$0))
            {
              this.this$0.mSurfaceTextureManager.init();
              SurfaceTexture localSurfaceTexture = this.this$0.mSurfaceTextureManager.getSurfaceTexture();
              ??? = localSurfaceTexture;
              if (localSurfaceTexture != null) {
                break label181;
              }
              QLog.d("VcCamera", 0, "openCamera surfaceTexture == null");
              bool = false;
            }
          }
          else
          {
            localSurfaceHolder = (SurfaceHolder)VcCamera.mHolder.get();
          }
        }
        if (localObject1 == null)
        {
          QLog.d("VcCamera", 0, "openCamera holder == null");
          bool = false;
        }
        else
        {
          ??? = null;
          label181:
          if (this.this$0.NUM_CAMERA == 0) {
            this.this$0.NUM_CAMERA = VcCamera.access$400();
          }
          if (this.val$cameraId == 0)
          {
            if ((!VcCamera.access$500(this.this$0)) && (!VcCamera.access$600(this.this$0)))
            {
              QLog.d("VcCamera", 0, "openCamera failed");
              bool = false;
            }
          }
          else if ((!VcCamera.access$600(this.this$0)) && (!VcCamera.access$500(this.this$0)))
          {
            QLog.d("VcCamera", 0, "openCamera failed");
            bool = false;
            continue;
          }
          if (this.this$0.mCamera != null) {
            break;
          }
          QLog.d("VcCamera", 0, "openCamera camera == null");
          bool = false;
        }
      }
    }
    VcCamera.access$200(this.this$0, this.this$0.VideoChatSettings.width, this.this$0.VideoChatSettings.height);
    for (;;)
    {
      try
      {
        this.this$0.mCallbackBufferAddStrategy.setCameraCaptureSettings(this.this$0.VideoChatSettings);
        this.this$0.mCallbackBufferAddStrategy.fistAdd(this.this$0.mCamera);
        if (this.this$0.mCallbackBufferAddStrategy.getIsUseBuffer())
        {
          this.this$0.mCamera.setPreviewCallbackWithBuffer(VcCamera.access$100(this.this$0));
          if (!VcCamera.access$300(this.this$0)) {
            break label463;
          }
          this.this$0.mCamera.setPreviewTexture(???);
          this.this$0.mCamera.startPreview();
          bool = true;
          break;
        }
        this.this$0.mCamera.setPreviewCallback(VcCamera.access$100(this.this$0));
        continue;
      }
      catch (Exception localException)
      {
        QLog.d("VcCamera", 0, "setPreviewDisplay error", localException);
        localException.printStackTrace();
        bool = false;
      }
      label463:
      this.this$0.mCamera.setPreviewDisplay(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.4
 * JD-Core Version:    0.7.0.1
 */