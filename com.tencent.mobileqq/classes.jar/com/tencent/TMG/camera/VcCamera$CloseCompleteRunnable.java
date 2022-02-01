package com.tencent.TMG.camera;

import java.lang.ref.WeakReference;

class VcCamera$CloseCompleteRunnable
  implements Runnable
{
  WeakReference<VcCamera> mHost = null;
  
  VcCamera$CloseCompleteRunnable(VcCamera paramVcCamera1, VcCamera paramVcCamera2)
  {
    this.mHost = new WeakReference(paramVcCamera2);
  }
  
  public void run()
  {
    if ((this.mHost != null) && (this.mHost.get() != null)) {
      ((VcCamera)this.mHost.get()).onCloseCamera();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.CloseCompleteRunnable
 * JD-Core Version:    0.7.0.1
 */