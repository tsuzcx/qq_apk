package com.tencent.TMG.camera;

import java.lang.ref.WeakReference;

class VcCamera$FinishCompleteRunnable
  implements Runnable
{
  WeakReference<VcCamera> mHost = null;
  
  VcCamera$FinishCompleteRunnable(VcCamera paramVcCamera1, VcCamera paramVcCamera2)
  {
    this.mHost = new WeakReference(paramVcCamera2);
  }
  
  public void run()
  {
    if ((this.mHost != null) && (this.mHost.get() != null)) {
      ((VcCamera)this.mHost.get()).onFinishCamera();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.FinishCompleteRunnable
 * JD-Core Version:    0.7.0.1
 */