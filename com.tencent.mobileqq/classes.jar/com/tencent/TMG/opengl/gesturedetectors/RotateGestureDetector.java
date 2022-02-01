package com.tencent.TMG.opengl.gesturedetectors;

import android.content.Context;
import android.view.MotionEvent;

public class RotateGestureDetector
  extends TwoFingerGestureDetector
{
  private final RotateGestureDetector.OnRotateGestureListener mListener;
  private boolean mSloppyGesture;
  
  public RotateGestureDetector(Context paramContext, RotateGestureDetector.OnRotateGestureListener paramOnRotateGestureListener)
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
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 6) {
          return;
        }
        updateStateByEvent(paramMotionEvent);
        if (!this.mSloppyGesture) {
          this.mListener.onRotateEnd(this);
        }
        resetState();
        return;
      }
      if (!this.mSloppyGesture) {
        this.mListener.onRotateEnd(this);
      }
      resetState();
      return;
    }
    updateStateByEvent(paramMotionEvent);
    if ((this.mCurrPressure / this.mPrevPressure > 0.67F) && (this.mListener.onRotate(this)))
    {
      this.mPrevEvent.recycle();
      this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
    }
  }
  
  protected void handleStartProgressEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    if (paramInt != 2)
    {
      if (paramInt != 5)
      {
        if (paramInt != 6) {
          return;
        }
        boolean bool = this.mSloppyGesture;
        return;
      }
      resetState();
      this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
      this.mTimeDelta = 0L;
      updateStateByEvent(paramMotionEvent);
      this.mSloppyGesture = isSloppyGesture(paramMotionEvent);
      if (!this.mSloppyGesture) {
        this.mGestureInProgress = this.mListener.onRotateBegin(this);
      }
    }
    else
    {
      if (!this.mSloppyGesture) {
        return;
      }
      this.mSloppyGesture = isSloppyGesture(paramMotionEvent);
      if (!this.mSloppyGesture) {
        this.mGestureInProgress = this.mListener.onRotateBegin(this);
      }
    }
  }
  
  protected void resetState()
  {
    super.resetState();
    this.mSloppyGesture = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.gesturedetectors.RotateGestureDetector
 * JD-Core Version:    0.7.0.1
 */