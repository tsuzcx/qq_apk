package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;

class AEImageCropperView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  AEImageCropperView$5(AEImageCropperView paramAEImageCropperView, float paramFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView.getImageMatrix();
    if (AEImageCropperView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView, paramValueAnimator) <= AEImageCropperView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView)) {
      return;
    }
    float f = (float)Math.pow(AEImageCropperView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView) / this.jdField_a_of_type_Float, 0.0500000007450581D);
    paramValueAnimator.postScale(f, f, AEImageCropperView.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView), AEImageCropperView.c(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView.setImageMatrix(paramValueAnimator);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEImageCropperView.5
 * JD-Core Version:    0.7.0.1
 */