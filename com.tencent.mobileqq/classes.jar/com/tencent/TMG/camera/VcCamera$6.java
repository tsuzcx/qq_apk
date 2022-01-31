package com.tencent.TMG.camera;

import android.os.HandlerThread;
import com.tencent.TMG.sdk.AVUILoopProxy;

class VcCamera$6
  implements Runnable
{
  VcCamera$6(VcCamera paramVcCamera) {}
  
  public void run()
  {
    this.this$0.closeInternal();
    this.this$0.mCameraThread.quit();
    this.this$0.mCameraThread = null;
    AVUILoopProxy.postTaskToMainLooper(new VcCamera.FinishCompleteRunnable(this.this$0, this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.6
 * JD-Core Version:    0.7.0.1
 */