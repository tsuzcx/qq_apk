package androidx.constraintlayout.motion.widget;

import android.view.MotionEvent;

public abstract interface MotionLayout$MotionTracker
{
  public abstract void addMovement(MotionEvent paramMotionEvent);
  
  public abstract void clear();
  
  public abstract void computeCurrentVelocity(int paramInt);
  
  public abstract void computeCurrentVelocity(int paramInt, float paramFloat);
  
  public abstract float getXVelocity();
  
  public abstract float getXVelocity(int paramInt);
  
  public abstract float getYVelocity();
  
  public abstract float getYVelocity(int paramInt);
  
  public abstract void recycle();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
 * JD-Core Version:    0.7.0.1
 */