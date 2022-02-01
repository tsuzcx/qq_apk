package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class AEPituCameraUnit$17
  implements Runnable
{
  AEPituCameraUnit$17(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2064515101), 0).a();
    this.this$0.R();
    if ((this.this$0.a.isFlashEnabled()) && (!this.this$0.f())) {
      this.this$0.a.turnFlash(this.this$0.a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.17
 * JD-Core Version:    0.7.0.1
 */