package com.bm.library;

import android.view.MotionEvent;

public class RotateGestureDetector
{
  private float jdField_a_of_type_Float;
  private OnRotateListener jdField_a_of_type_ComBmLibraryOnRotateListener;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  
  public RotateGestureDetector(OnRotateListener paramOnRotateListener)
  {
    this.jdField_a_of_type_ComBmLibraryOnRotateListener = paramOnRotateListener;
  }
  
  private float a(MotionEvent paramMotionEvent)
  {
    this.c = paramMotionEvent.getX(0);
    this.d = paramMotionEvent.getY(0);
    this.e = paramMotionEvent.getX(1);
    this.f = paramMotionEvent.getY(1);
    return (this.f - this.d) / (this.e - this.c);
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
        this.jdField_a_of_type_Float = a(paramMotionEvent);
      }
    }
    else if (paramMotionEvent.getPointerCount() > 1)
    {
      this.b = a(paramMotionEvent);
      double d1 = Math.toDegrees(Math.atan(this.b)) - Math.toDegrees(Math.atan(this.jdField_a_of_type_Float));
      if (Math.abs(d1) <= 120.0D) {
        this.jdField_a_of_type_ComBmLibraryOnRotateListener.a((float)d1, (this.e + this.c) / 2.0F, (this.f + this.d) / 2.0F);
      }
      this.jdField_a_of_type_Float = this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.bm.library.RotateGestureDetector
 * JD-Core Version:    0.7.0.1
 */