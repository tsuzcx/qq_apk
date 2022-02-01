package com.bm.library;

import android.view.MotionEvent;

public class RotateGestureDetector
{
  private OnRotateListener a;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  
  public RotateGestureDetector(OnRotateListener paramOnRotateListener)
  {
    this.a = paramOnRotateListener;
  }
  
  private float b(MotionEvent paramMotionEvent)
  {
    this.d = paramMotionEvent.getX(0);
    this.e = paramMotionEvent.getY(0);
    this.f = paramMotionEvent.getX(1);
    this.g = paramMotionEvent.getY(1);
    return (this.g - this.e) / (this.f - this.d);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 2)
    {
      if ((i != 5) && (i != 6)) {
        return;
      }
      if (paramMotionEvent.getPointerCount() == 2) {
        this.b = b(paramMotionEvent);
      }
    }
    else if (paramMotionEvent.getPointerCount() > 1)
    {
      this.c = b(paramMotionEvent);
      double d1 = Math.toDegrees(Math.atan(this.c)) - Math.toDegrees(Math.atan(this.b));
      if (Math.abs(d1) <= 120.0D) {
        this.a.a((float)d1, (this.f + this.d) / 2.0F, (this.g + this.e) / 2.0F);
      }
      this.b = this.c;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bm.library.RotateGestureDetector
 * JD-Core Version:    0.7.0.1
 */