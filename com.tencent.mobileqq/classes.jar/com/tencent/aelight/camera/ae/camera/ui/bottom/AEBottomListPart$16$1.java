package com.tencent.aelight.camera.ae.camera.ui.bottom;

import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;

class AEBottomListPart$16$1
  implements Runnable
{
  AEBottomListPart$16$1(AEBottomListPart.16 param16, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" material usable id: ");
    localStringBuilder.append(this.a.m);
    AEQLog.b("AEBottomListPart", localStringBuilder.toString());
    this.b.this$0.d.a(this.a);
    this.b.this$0.e.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.16.1
 * JD-Core Version:    0.7.0.1
 */