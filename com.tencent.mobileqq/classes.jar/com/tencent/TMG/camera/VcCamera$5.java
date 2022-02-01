package com.tencent.TMG.camera;

import android.os.HandlerThread;
import com.tencent.TMG.sdk.AVUILoopProxy;

class VcCamera$5
  implements Runnable
{
  VcCamera$5(VcCamera paramVcCamera) {}
  
  public void run()
  {
    this.this$0.closeInternal();
    this.this$0.mCameraThread.quit();
    VcCamera localVcCamera = this.this$0;
    localVcCamera.mCameraThread = null;
    VcCamera.access$702(localVcCamera, null);
    localVcCamera = this.this$0;
    AVUILoopProxy.postTaskToMainLooper(new VcCamera.CloseCompleteRunnable(localVcCamera, localVcCamera));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.5
 * JD-Core Version:    0.7.0.1
 */