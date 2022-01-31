package android.support.v4.view;

import android.view.MotionEvent;

abstract interface MotionEventCompat$MotionEventVersionImpl
{
  public abstract int findPointerIndex(MotionEvent paramMotionEvent, int paramInt);
  
  public abstract float getAxisValue(MotionEvent paramMotionEvent, int paramInt);
  
  public abstract float getAxisValue(MotionEvent paramMotionEvent, int paramInt1, int paramInt2);
  
  public abstract int getPointerCount(MotionEvent paramMotionEvent);
  
  public abstract int getPointerId(MotionEvent paramMotionEvent, int paramInt);
  
  public abstract int getSource(MotionEvent paramMotionEvent);
  
  public abstract float getX(MotionEvent paramMotionEvent, int paramInt);
  
  public abstract float getY(MotionEvent paramMotionEvent, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.MotionEventCompat.MotionEventVersionImpl
 * JD-Core Version:    0.7.0.1
 */