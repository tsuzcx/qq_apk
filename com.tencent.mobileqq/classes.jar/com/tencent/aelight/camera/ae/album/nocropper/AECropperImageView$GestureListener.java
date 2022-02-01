package com.tencent.aelight.camera.ae.album.nocropper;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.aelight.camera.log.AEQLog;

class AECropperImageView$GestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private AECropperImageView$GestureListener(AECropperImageView paramAECropperImageView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!AECropperImageView.a(this.a)) {
      return false;
    }
    if (AECropperImageView.b(this.a))
    {
      AEQLog.d("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
      return false;
    }
    if (paramMotionEvent1 != null)
    {
      if (paramMotionEvent2 == null) {
        return false;
      }
      if (paramMotionEvent1.getPointerCount() <= 1)
      {
        if (paramMotionEvent2.getPointerCount() > 1) {
          return false;
        }
        this.a.a(paramFloat1, paramFloat2);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.AECropperImageView.GestureListener
 * JD-Core Version:    0.7.0.1
 */