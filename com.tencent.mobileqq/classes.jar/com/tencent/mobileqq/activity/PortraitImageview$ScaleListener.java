package com.tencent.mobileqq.activity;

import android.view.ScaleGestureDetector;

class PortraitImageview$ScaleListener
  extends PortraitImageview.SimpleOnScaleGestureListener
{
  PortraitImageview$ScaleListener(PortraitImageview paramPortraitImageview) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.isInProgress())) {
      try
      {
        float f1 = this.a.a();
        float f2 = paramScaleGestureDetector.getScaleFactor();
        f1 = Math.min(this.a.b(), Math.max(f1 * f2, 0.1F));
        this.a.a(f1, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
        this.a.invalidate();
        return true;
      }
      catch (IllegalArgumentException paramScaleGestureDetector)
      {
        paramScaleGestureDetector.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PortraitImageview.ScaleListener
 * JD-Core Version:    0.7.0.1
 */