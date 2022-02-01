package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.qphone.base.util.QLog;

class AEPituCameraUnit$38
  implements Runnable
{
  AEPituCameraUnit$38(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.a, 2, "onResourceDownload update filterpager begin");
    }
    if (this.this$0.al != null)
    {
      FilterPagerViewStubHolder localFilterPagerViewStubHolder = this.this$0.al;
      boolean bool;
      if (this.this$0.x == AECaptureMode.NORMAL) {
        bool = true;
      } else {
        bool = false;
      }
      localFilterPagerViewStubHolder.d(bool);
    }
    ((AEMaterialManager)AEQIMManager.a(1)).b(false);
    ((AEFlashShowMaterialManager)AEQIMManager.a(3)).b(false);
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.a, 2, "onResourceDownload update filterpager end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.38
 * JD-Core Version:    0.7.0.1
 */