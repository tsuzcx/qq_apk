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
    this.this$0.mCameraThread = null;
    VcCamera.access$702(this.this$0, null);
    AVUILoopProxy.postTaskToMainLooper(new VcCamera.CloseCompleteRunnable(this.this$0, this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.5
 * JD-Core Version:    0.7.0.1
 */