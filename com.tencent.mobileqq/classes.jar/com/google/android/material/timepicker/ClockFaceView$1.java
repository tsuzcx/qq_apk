package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ClockFaceView$1
  implements ViewTreeObserver.OnPreDrawListener
{
  ClockFaceView$1(ClockFaceView paramClockFaceView) {}
  
  public boolean onPreDraw()
  {
    if (!this.a.isShown()) {
      return true;
    }
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    int i = this.a.getHeight() / 2;
    int j = ClockFaceView.a(this.a).c();
    int k = ClockFaceView.b(this.a);
    this.a.a(i - j - k);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.ClockFaceView.1
 * JD-Core Version:    0.7.0.1
 */