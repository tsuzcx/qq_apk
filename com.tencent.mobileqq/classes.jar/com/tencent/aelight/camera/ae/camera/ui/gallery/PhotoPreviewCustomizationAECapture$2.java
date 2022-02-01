package com.tencent.aelight.camera.ae.camera.ui.gallery;

import com.tencent.aelight.camera.ae.config.CameraPeakServiceObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class PhotoPreviewCustomizationAECapture$2
  extends CameraPeakServiceObserver
{
  PhotoPreviewCustomizationAECapture$2(PhotoPreviewCustomizationAECapture paramPhotoPreviewCustomizationAECapture, String paramString) {}
  
  public void onUpdateFaceDetect(boolean paramBoolean, int paramInt)
  {
    PhotoPreviewCustomizationAECapture.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiGalleryPhotoPreviewCustomizationAECapture).removeObserver(this);
    PhotoPreviewCustomizationAECapture.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiGalleryPhotoPreviewCustomizationAECapture, null);
    ThreadManager.getUIHandler().post(new PhotoPreviewCustomizationAECapture.2.1(this, paramBoolean, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoPreviewCustomizationAECapture.2
 * JD-Core Version:    0.7.0.1
 */