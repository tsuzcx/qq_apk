package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.aelight.camera.log.AEQLog;

class AEImageCropperMask$GestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private AEImageCropperMask$GestureListener(AEImageCropperMask paramAEImageCropperMask) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!AEImageCropperMask.a(this.a)) {
      return false;
    }
    if (AEImageCropperMask.b(this.a))
    {
      AEQLog.d("CropperGridView", "Cropping current bitmap. Can't perform this action right now.");
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
        if (AEImageCropperMask.c(this.a))
        {
          AEImageCropperMask.a(this.a, paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
          return false;
        }
        if (AEImageCropperMask.d(this.a)) {
          AEImageCropperMask.a(this.a, paramFloat1, paramFloat2);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEImageCropperMask.GestureListener
 * JD-Core Version:    0.7.0.1
 */