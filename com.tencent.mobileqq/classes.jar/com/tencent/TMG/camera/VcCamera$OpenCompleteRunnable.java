package com.tencent.TMG.camera;

import java.lang.ref.WeakReference;

class VcCamera$OpenCompleteRunnable
  implements Runnable
{
  WeakReference<VcCamera> mHost = null;
  boolean mResult = false;
  
  VcCamera$OpenCompleteRunnable(VcCamera paramVcCamera1, VcCamera paramVcCamera2, boolean paramBoolean)
  {
    this.mResult = paramBoolean;
    this.mHost = new WeakReference(paramVcCamera2);
  }
  
  public void run()
  {
    if ((this.mHost != null) && (this.mHost.get() != null)) {
      ((VcCamera)this.mHost.get()).onOpenCamera(this.mResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.OpenCompleteRunnable
 * JD-Core Version:    0.7.0.1
 */