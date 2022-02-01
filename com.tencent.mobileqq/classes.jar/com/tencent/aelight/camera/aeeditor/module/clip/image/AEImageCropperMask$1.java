package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;

class AEImageCropperMask$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AEImageCropperMask$1(AEImageCropperMask paramAEImageCropperMask, Rect paramRect1, Rect paramRect2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    AEImageCropperMask.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperMask, new Rect());
    AEImageCropperMask.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperMask).left = (this.jdField_a_of_type_AndroidGraphicsRect.left + (int)((this.b.left - this.jdField_a_of_type_AndroidGraphicsRect.left) * paramValueAnimator.intValue() / 20.0F));
    AEImageCropperMask.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperMask).top = (this.jdField_a_of_type_AndroidGraphicsRect.top + (int)((this.b.top - this.jdField_a_of_type_AndroidGraphicsRect.top) * paramValueAnimator.intValue() / 20.0F));
    AEImageCropperMask.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperMask).right = (this.jdField_a_of_type_AndroidGraphicsRect.right + (int)((this.b.right - this.jdField_a_of_type_AndroidGraphicsRect.right) * paramValueAnimator.intValue() / 20.0F));
    AEImageCropperMask.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperMask).bottom = (this.jdField_a_of_type_AndroidGraphicsRect.bottom + (int)((this.b.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom) * paramValueAnimator.intValue() / 20.0F));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperMask.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEImageCropperMask.1
 * JD-Core Version:    0.7.0.1
 */