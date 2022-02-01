package com.google.android.material.timepicker;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class TimePickerView$3
  extends GestureDetector.SimpleOnGestureListener
{
  TimePickerView$3(TimePickerView paramTimePickerView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onDoubleTap(paramMotionEvent);
    if (TimePickerView.c(this.a) != null) {
      TimePickerView.c(this.a).a();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.TimePickerView.3
 * JD-Core Version:    0.7.0.1
 */