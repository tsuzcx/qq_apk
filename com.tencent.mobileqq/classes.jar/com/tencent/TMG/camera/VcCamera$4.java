package com.tencent.TMG.camera;

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
    boolean bool2 = VcCamera.isCameraOpened;
    boolean bool1 = true;
    if (!bool2) {
      if (this.this$0.mContext == null) {
        QLog.d("VcCamera", 0, "openCamera context == null");
      }
    }
    for (;;)
    {
      bool1 = false;
      synchronized (this.this$0.holderLock)
      {
        Object localObject1 = VcCamera.mHolder;
        Object localObject3 = null;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = (SurfaceHolder)VcCamera.mHolder.get();
        }
        if (VcCamera.access$300(this.this$0))
        {
          this.this$0.mSurfaceTextureManager.init();
          ??? = this.this$0.mSurfaceTextureManager.getSurfaceTexture();
          localObject3 = ???;
          if (??? == null) {
            QLog.d("VcCamera", 0, "openCamera surfaceTexture == null");
          }
        }
        else if (localObject1 == null)
        {
          QLog.d("VcCamera", 0, "openCamera holder == null");
          continue;
        }
        if (this.this$0.NUM_CAMERA == 0) {
          this.this$0.NUM_CAMERA = VcCamera.access$400();
        }
        if (this.val$cameraId == 0)
        {
          if ((!VcCamera.access$500(this.this$0)) && (!VcCamera.access$600(this.this$0))) {
            QLog.d("VcCamera", 0, "openCamera failed");
          }
        }
        else if ((!VcCamera.access$600(this.this$0)) && (!VcCamera.access$500(this.this$0)))
        {
          QLog.d("VcCamera", 0, "openCamera failed");
          continue;
        }
        if (this.this$0.mCamera == null)
        {
          QLog.d("VcCamera", 0, "openCamera camera == null");
        }
        else
        {
          ??? = this.this$0;
          VcCamera.access$200((VcCamera)???, ((VcCamera)???).VideoChatSettings.width, this.this$0.VideoChatSettings.height);
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
              this.this$0.mCamera.setPreviewTexture(localObject3);
            } else {
              this.this$0.mCamera.setPreviewDisplay((SurfaceHolder)localObject1);
            }
            this.this$0.mCamera.startPreview();
          }
          catch (Exception localException)
          {
            QLog.d("VcCamera", 0, "setPreviewDisplay error", localException);
            localException.printStackTrace();
          }
          continue;
          VcCamera.isCameraOpened = bool1;
          VcCamera localVcCamera = this.this$0;
          AVUILoopProxy.postTaskToMainLooper(new VcCamera.OpenCompleteRunnable(localVcCamera, localVcCamera, bool1));
          QLog.d("VcCamera", 0, "openCamera end.");
          return;
        }
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.4
 * JD-Core Version:    0.7.0.1
 */