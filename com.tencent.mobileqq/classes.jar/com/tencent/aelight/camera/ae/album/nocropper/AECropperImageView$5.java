package com.tencent.aelight.camera.ae.album.nocropper;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;

class AECropperImageView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  AECropperImageView$5(AECropperImageView paramAECropperImageView, float paramFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView.getImageMatrix();
    if (AECropperImageView.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView, paramValueAnimator) <= AECropperImageView.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView)) {
      return;
    }
    float f = (float)Math.pow(AECropperImageView.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView) / this.jdField_a_of_type_Float, 0.0500000007450581D);
    paramValueAnimator.postScale(f, f, AECropperImageView.b(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView), AECropperImageView.c(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView));
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView.setImageMatrix(paramValueAnimator);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.AECropperImageView.5
 * JD-Core Version:    0.7.0.1
 */