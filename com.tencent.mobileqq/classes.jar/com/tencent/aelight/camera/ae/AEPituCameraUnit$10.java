package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import org.light.listener.IOnClickWatermarkListener;

class AEPituCameraUnit$10
  implements IOnClickWatermarkListener
{
  AEPituCameraUnit$10(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onClickWatermark()
  {
    AEQLog.a(this.a.a, "onClickWatermark");
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.10
 * JD-Core Version:    0.7.0.1
 */