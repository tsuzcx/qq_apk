package com.tencent.aelight.camera.ae.camera.ui.gallery;

import com.tencent.aelight.camera.ae.config.CameraPeakServiceObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class PhotoListCustomizationAECapture$1
  extends CameraPeakServiceObserver
{
  PhotoListCustomizationAECapture$1(PhotoListCustomizationAECapture paramPhotoListCustomizationAECapture, String paramString) {}
  
  public void onUpdateFaceDetect(boolean paramBoolean, int paramInt)
  {
    PhotoListCustomizationAECapture.a(this.b).removeObserver(this);
    PhotoListCustomizationAECapture.a(this.b, null);
    ThreadManager.getUIHandler().post(new PhotoListCustomizationAECapture.1.1(this, paramBoolean, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoListCustomizationAECapture.1
 * JD-Core Version:    0.7.0.1
 */