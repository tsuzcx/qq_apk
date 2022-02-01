package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class CropNewView$MoveAdapter
  extends GestureDetector.SimpleOnGestureListener
{
  private CropNewView$MoveAdapter(CropNewView paramCropNewView) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return CropNewView.a(this.a, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop.CropNewView.MoveAdapter
 * JD-Core Version:    0.7.0.1
 */