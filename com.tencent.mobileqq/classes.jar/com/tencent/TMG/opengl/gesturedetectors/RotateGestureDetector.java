package com.tencent.TMG.opengl.gesturedetectors;

import android.content.Context;
import android.view.MotionEvent;

public class RotateGestureDetector
  extends TwoFingerGestureDetector
{
  private final OnRotateGestureListener mListener;
  private boolean mSloppyGesture;
  
  public RotateGestureDetector(Context paramContext, OnRotateGestureListener paramOnRotateGestureListener)
  {
    super(paramContext);
    this.mListener = paramOnRotateGestureListener;
  }
  
  public float getRotationDegreesDelta()
  {
    return (float)((Math.atan2(this.mPrevFingerDiffY, this.mPrevFingerDiffX) - Math.atan2(this.mCurrFingerDiffY, this.mCurrFingerDiffX)) * 180.0D / 3.141592653589793D);
  }
  
  protected void handleInProgressEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      updateStateByEvent(paramMotionEvent);
      if (!this.mSloppyGesture) {
        this.mListener.onRotateEnd(this);
      }
      resetState();
      return;
      if (!this.mSloppyGesture) {
        this.mListener.onRotateEnd(this);
      }
      resetState();
      return;
      updateStateByEvent(paramMotionEvent);
    } while ((this.mCurrPressure / this.mPrevPressure <= 0.67F) || (!this.mListener.onRotate(this)));
    this.mPrevEvent.recycle();
    this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
  }
  
  protected void handleStartProgressEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            resetState();
            this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
            this.mTimeDelta = 0L;
            updateStateByEvent(paramMotionEvent);
            this.mSloppyGesture = isSloppyGesture(paramMotionEvent);
          } while (this.mSloppyGesture);
          this.mGestureInProgress = this.mListener.onRotateBegin(this);
          return;
        } while (!this.mSloppyGesture);
        this.mSloppyGesture = isSloppyGesture(paramMotionEvent);
      } while (this.mSloppyGesture);
      this.mGestureInProgress = this.mListener.onRotateBegin(this);
      return;
    } while (this.mSloppyGesture);
  }
  
  protected void resetState()
  {
    super.resetState();
    this.mSloppyGesture = false;
  }
  
  public static abstract interface OnRotateGestureListener
  {
    public abstract boolean onRotate(RotateGestureDetector paramRotateGestureDetector);
    
    public abstract boolean onRotateBegin(RotateGestureDetector paramRotateGestureDetector);
    
    public abstract void onRotateEnd(RotateGestureDetector paramRotateGestureDetector);
  }
  
  public static class SimpleOnRotateGestureListener
    implements RotateGestureDetector.OnRotateGestureListener
  {
    public boolean onRotate(RotateGestureDetector paramRotateGestureDetector)
    {
      return false;
    }
    
    public boolean onRotateBegin(RotateGestureDetector paramRotateGestureDetector)
    {
      return true;
    }
    
    public void onRotateEnd(RotateGestureDetector paramRotateGestureDetector) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.opengl.gesturedetectors.RotateGestureDetector
 * JD-Core Version:    0.7.0.1
 */