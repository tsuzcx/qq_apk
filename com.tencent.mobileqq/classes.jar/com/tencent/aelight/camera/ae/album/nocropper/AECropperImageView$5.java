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
    paramValueAnimator = this.b.getImageMatrix();
    if (AECropperImageView.a(this.b, paramValueAnimator) <= AECropperImageView.d(this.b)) {
      return;
    }
    float f = (float)Math.pow(AECropperImageView.d(this.b) / this.a, 0.0500000007450581D);
    paramValueAnimator.postScale(f, f, AECropperImageView.e(this.b), AECropperImageView.f(this.b));
    this.b.setImageMatrix(paramValueAnimator);
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.AECropperImageView.5
 * JD-Core Version:    0.7.0.1
 */