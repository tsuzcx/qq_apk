package com.tencent.luggage.wxa.in;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.picker.base.view.WheelView;

public final class a
  extends GestureDetector.SimpleOnGestureListener
{
  private final WheelView a;
  
  public a(WheelView paramWheelView)
  {
    this.a = paramWheelView;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.a.a(paramFloat2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.in.a
 * JD-Core Version:    0.7.0.1
 */