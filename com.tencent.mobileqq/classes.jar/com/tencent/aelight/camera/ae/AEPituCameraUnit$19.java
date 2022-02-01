package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class AEPituCameraUnit$19
  implements Runnable
{
  AEPituCameraUnit$19(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2064187433), 0).show();
    this.this$0.au();
    if ((this.this$0.d.isFlashEnabled()) && (!this.this$0.Z())) {
      this.this$0.d.turnFlash(this.this$0.s(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.19
 * JD-Core Version:    0.7.0.1
 */