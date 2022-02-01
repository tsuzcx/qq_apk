package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraManager;
import com.tencent.aelight.camera.log.AEQLog;

class AEPituCameraUnit$1$3
  implements Runnable
{
  AEPituCameraUnit$1$3(AEPituCameraUnit.1 param1) {}
  
  public void run()
  {
    AEQLog.b(this.a.a.a, "onRetryOpenCamera post| will retry in the UI thread");
    this.a.a.d.stopCamera(false);
    this.a.a.d.openCamera(new AEPituCameraUnit.1.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.1.3
 * JD-Core Version:    0.7.0.1
 */