package com.tencent.aelight.camera.ae.album.logic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.view.AEEditorCancelableProgressDialog;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.concurrent.CountDownLatch;

class AEPhotoListLogicBase$14
  implements View.OnClickListener
{
  AEPhotoListLogicBase$14(AEPhotoListLogicBase paramAEPhotoListLogicBase) {}
  
  public void onClick(View paramView)
  {
    AEQLog.b("AEPhotoListLogicBase", "batchCompressDialog cancel clicked");
    AEPhotoListLogicBase.a(this.a, true);
    this.a.i();
    if (AEPhotoListLogicBase.g(this.a) != null) {
      AEPhotoListLogicBase.g(this.a).countDown();
    }
    AEPhotoListLogicBase.h(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.14
 * JD-Core Version:    0.7.0.1
 */