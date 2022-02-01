package com.tencent.aelight.camera.ae.biz.circle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.view.AEEditorCancelableProgressDialog;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.concurrent.CountDownLatch;

class AECirclePhotoListLogic$11
  implements View.OnClickListener
{
  AECirclePhotoListLogic$11(AECirclePhotoListLogic paramAECirclePhotoListLogic) {}
  
  public void onClick(View paramView)
  {
    AEQLog.b("AECirclePhotoListLogic", "batchCompressDialog cancel clicked");
    AECirclePhotoListLogic.a(this.a, true);
    this.a.c();
    if (AECirclePhotoListLogic.a(this.a) != null) {
      AECirclePhotoListLogic.a(this.a).countDown();
    }
    AECirclePhotoListLogic.a(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.11
 * JD-Core Version:    0.7.0.1
 */