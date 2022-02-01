package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraManager;

class AEPituCameraUnit$16
  implements Runnable
{
  AEPituCameraUnit$16(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    if ((this.this$0.d.isFlashEnabled()) && (!this.this$0.Z())) {
      this.this$0.d.turnFlash(this.this$0.s(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.16
 * JD-Core Version:    0.7.0.1
 */