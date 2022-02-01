package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraManager;

class AEPituCameraUnit$16
  implements Runnable
{
  AEPituCameraUnit$16(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    if (this.this$0.a.isFlashEnabled()) {
      this.this$0.a.turnFlash(this.this$0.a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.16
 * JD-Core Version:    0.7.0.1
 */