package com.tencent.aelight.camera.ae.biz.circle;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.record.AEEditorRecordDataManager;

class AECirclePhotoListLogic$5
  implements DialogInterface.OnClickListener
{
  AECirclePhotoListLogic$5(AECirclePhotoListLogic paramAECirclePhotoListLogic) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AEEditorRecordDataManager.a().d();
    AEEditorRecordDataManager.a().a(-1);
    if (AEEditorRecordDataManager.a().a() == 2L) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    AEReportUtils.e(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.5
 * JD-Core Version:    0.7.0.1
 */