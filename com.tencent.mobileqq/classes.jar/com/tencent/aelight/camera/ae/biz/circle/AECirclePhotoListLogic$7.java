package com.tencent.aelight.camera.ae.biz.circle;

import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.record.AEEditorRecordDataManager;
import com.tencent.mobileqq.utils.QQCustomDialog;

class AECirclePhotoListLogic$7
  implements Runnable
{
  AECirclePhotoListLogic$7(AECirclePhotoListLogic paramAECirclePhotoListLogic, QQCustomDialog paramQQCustomDialog) {}
  
  public void run()
  {
    this.a.show();
    int i;
    if (AEEditorRecordDataManager.a().c() == 2L) {
      i = 2;
    } else {
      i = 1;
    }
    AEReportUtils.c(i, this.this$0.i());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.7
 * JD-Core Version:    0.7.0.1
 */