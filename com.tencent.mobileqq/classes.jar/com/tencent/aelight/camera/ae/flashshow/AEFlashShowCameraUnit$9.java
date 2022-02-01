package com.tencent.aelight.camera.ae.flashshow;

import com.tencent.aelight.camera.ae.camera.core.AECameraManager;

class AEFlashShowCameraUnit$9
  implements Runnable
{
  AEFlashShowCameraUnit$9(AEFlashShowCameraUnit paramAEFlashShowCameraUnit) {}
  
  public void run()
  {
    if (AEFlashShowCameraUnit.q(this.this$0).isFlashEnabled()) {
      AEFlashShowCameraUnit.r(this.this$0).turnFlash(this.this$0.s(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit.9
 * JD-Core Version:    0.7.0.1
 */