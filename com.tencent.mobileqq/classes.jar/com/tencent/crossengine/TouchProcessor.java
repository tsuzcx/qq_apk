package com.tencent.crossengine;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

public class TouchProcessor
{
  float lastX = -1.0F;
  float lastY = -1.0F;
  private CEApplication mCEApp;
  
  public TouchProcessor(CEApplication paramCEApplication)
  {
    this.mCEApp = paramCEApplication;
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    float f1 = this.mCEApp.getWidth() / this.mCEApp.getScale();
    float f2 = this.mCEApp.getHeight() / this.mCEApp.getScale();
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      int j = paramMotionEvent.getAction();
      float f3 = paramMotionEvent.getX(i) / this.mCEApp.getScale();
      float f4 = paramMotionEvent.getY(i) / this.mCEApp.getScale();
      if (j != 0)
      {
        if (j != 1) {
          if (j != 2)
          {
            if (j != 3) {
              break label199;
            }
          }
          else
          {
            float f5 = this.lastX;
            float f6 = this.lastY;
            this.mCEApp.dispatchTouchEvent(j, 1, (f3 - f5) / f1, (f4 - f6) / f2);
            this.lastX = f3;
            this.lastY = f4;
          }
        }
        this.mCEApp.dispatchTouchEvent(j, 1, 0.0F, 0.0F);
      }
      else
      {
        this.lastX = f3;
        this.lastY = f4;
        this.mCEApp.dispatchTouchEvent(j, 1, f3, f4);
      }
      label199:
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.TouchProcessor
 * JD-Core Version:    0.7.0.1
 */