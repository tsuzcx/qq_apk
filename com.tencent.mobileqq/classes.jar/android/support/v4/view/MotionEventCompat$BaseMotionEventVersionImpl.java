package android.support.v4.view;

import android.view.MotionEvent;

class MotionEventCompat$BaseMotionEventVersionImpl
  implements MotionEventCompat.MotionEventVersionImpl
{
  public int findPointerIndex(MotionEvent paramMotionEvent, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return -1;
  }
  
  public float getAxisValue(MotionEvent paramMotionEvent, int paramInt)
  {
    return 0.0F;
  }
  
  public float getAxisValue(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    return 0.0F;
  }
  
  public int getPointerCount(MotionEvent paramMotionEvent)
  {
    return 1;
  }
  
  public int getPointerId(MotionEvent paramMotionEvent, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
  }
  
  public int getSource(MotionEvent paramMotionEvent)
  {
    return 0;
  }
  
  public float getX(MotionEvent paramMotionEvent, int paramInt)
  {
    if (paramInt == 0) {
      return paramMotionEvent.getX();
    }
    throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
  }
  
  public float getY(MotionEvent paramMotionEvent, int paramInt)
  {
    if (paramInt == 0) {
      return paramMotionEvent.getY();
    }
    throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.MotionEventCompat.BaseMotionEventVersionImpl
 * JD-Core Version:    0.7.0.1
 */