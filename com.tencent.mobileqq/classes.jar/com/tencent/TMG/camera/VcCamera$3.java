package com.tencent.TMG.camera;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;

class VcCamera$3
  implements Runnable
{
  VcCamera$3(VcCamera paramVcCamera, Object paramObject) {}
  
  public void run()
  {
    if ((this.val$cameraPara != null) && (this.this$0.mCamera != null) && ((this.val$cameraPara instanceof Camera.Parameters))) {}
    try
    {
      this.this$0.mCamera.setParameters((Camera.Parameters)this.val$cameraPara);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.3
 * JD-Core Version:    0.7.0.1
 */