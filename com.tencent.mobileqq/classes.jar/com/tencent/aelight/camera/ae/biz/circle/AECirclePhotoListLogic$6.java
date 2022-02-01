package com.tencent.aelight.camera.ae.biz.circle;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.record.AEEditorRecordDataManager;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.util.ArrayList;

class AECirclePhotoListLogic$6
  implements DialogInterface.OnClickListener
{
  AECirclePhotoListLogic$6(AECirclePhotoListLogic paramAECirclePhotoListLogic) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = AEEditorRecordDataManager.a().f();
    if (paramDialogInterface != null)
    {
      this.a.c.selectedPhotoList.addAll(paramDialogInterface);
      paramDialogInterface = this.a;
      long l = AEEditorRecordDataManager.a().c();
      paramInt = 1;
      boolean bool;
      if (l == 2L) {
        bool = true;
      } else {
        bool = false;
      }
      paramDialogInterface.c(bool);
      AEEditorRecordDataManager.a().i();
      AEEditorRecordDataManager.a().a(2);
      if (AEEditorRecordDataManager.a().c() == 2L) {
        paramInt = 2;
      }
      AEReportUtils.d(paramInt, this.a.i());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.6
 * JD-Core Version:    0.7.0.1
 */