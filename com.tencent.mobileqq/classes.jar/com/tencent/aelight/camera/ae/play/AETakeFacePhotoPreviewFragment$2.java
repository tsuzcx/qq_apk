package com.tencent.aelight.camera.ae.play;

import com.tencent.aelight.camera.ae.config.CameraPeakServiceObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AETakeFacePhotoPreviewFragment$2
  extends CameraPeakServiceObserver
{
  AETakeFacePhotoPreviewFragment$2(AETakeFacePhotoPreviewFragment paramAETakeFacePhotoPreviewFragment) {}
  
  public void onUpdateFaceDetect(boolean paramBoolean, int paramInt)
  {
    AETakeFacePhotoPreviewFragment.access$100(this.this$0).removeObserver(this);
    ThreadManager.getUIHandler().post(new AETakeFacePhotoPreviewFragment.2.1(this, paramBoolean, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AETakeFacePhotoPreviewFragment.2
 * JD-Core Version:    0.7.0.1
 */