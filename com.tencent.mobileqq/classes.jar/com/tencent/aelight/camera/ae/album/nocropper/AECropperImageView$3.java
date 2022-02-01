package com.tencent.aelight.camera.ae.album.nocropper;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;

class AECropperImageView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  AECropperImageView$3(AECropperImageView paramAECropperImageView, Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView.getImageMatrix();
    float f2 = AECropperImageView.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView, this.jdField_a_of_type_AndroidGraphicsMatrix, 2);
    float f3 = AECropperImageView.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView, this.jdField_a_of_type_AndroidGraphicsMatrix, 5);
    paramValueAnimator.postTranslate(this.jdField_a_of_type_Float * f1 - (f2 - this.b), this.c * f1 - (f3 - this.d));
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView.setImageMatrix(paramValueAnimator);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.AECropperImageView.3
 * JD-Core Version:    0.7.0.1
 */