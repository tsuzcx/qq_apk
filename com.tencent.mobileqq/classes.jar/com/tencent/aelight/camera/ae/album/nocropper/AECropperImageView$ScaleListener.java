package com.tencent.aelight.camera.ae.album.nocropper;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.tencent.aelight.camera.log.AEQLog;

class AECropperImageView$ScaleListener
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private AECropperImageView$ScaleListener(AECropperImageView paramAECropperImageView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (!AECropperImageView.a(this.a)) {
      return false;
    }
    if (AECropperImageView.a(this.a) == 2) {
      return false;
    }
    if (AECropperImageView.b(this.a))
    {
      AEQLog.d("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
      return false;
    }
    Matrix localMatrix = this.a.getImageMatrix();
    AECropperImageView.a(this.a, paramScaleGestureDetector.getFocusX());
    AECropperImageView.b(this.a, paramScaleGestureDetector.getFocusY());
    localMatrix.postScale(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    this.a.setImageMatrix(localMatrix);
    this.a.invalidate();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.AECropperImageView.ScaleListener
 * JD-Core Version:    0.7.0.1
 */