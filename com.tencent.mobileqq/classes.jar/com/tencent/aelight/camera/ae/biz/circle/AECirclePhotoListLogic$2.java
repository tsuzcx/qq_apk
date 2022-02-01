package com.tencent.aelight.camera.ae.biz.circle;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.LocalMultiProcConfig;
import mqq.app.AppRuntime;

class AECirclePhotoListLogic$2
  implements DialogInterface.OnClickListener
{
  AECirclePhotoListLogic$2(AECirclePhotoListLogic paramAECirclePhotoListLogic) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LocalMultiProcConfig.putInt4Uin("_qq_circle_publish", 0, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    AEReportUtils.e(3, this.a.i());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.2
 * JD-Core Version:    0.7.0.1
 */