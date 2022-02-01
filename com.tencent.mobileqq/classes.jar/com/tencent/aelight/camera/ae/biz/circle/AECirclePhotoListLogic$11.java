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
    this.a.k();
    if (AECirclePhotoListLogic.b(this.a) != null) {
      AECirclePhotoListLogic.b(this.a).countDown();
    }
    AECirclePhotoListLogic.c(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.11
 * JD-Core Version:    0.7.0.1
 */