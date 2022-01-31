package com.samsung.android.sdk.camera.delegator;

import android.os.Handler;
import java.util.concurrent.Executor;

class SemCameraCaptureProcessor10_1$1
  implements Executor
{
  SemCameraCaptureProcessor10_1$1(SemCameraCaptureProcessor10_1 paramSemCameraCaptureProcessor10_1, Handler paramHandler) {}
  
  public void execute(Runnable paramRunnable)
  {
    this.val$handler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.samsung.android.sdk.camera.delegator.SemCameraCaptureProcessor10_1.1
 * JD-Core Version:    0.7.0.1
 */