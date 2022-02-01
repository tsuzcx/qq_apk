package com.tencent.TMG.opengl.gesturedetectors;

import android.content.Context;
import android.view.MotionEvent;

public class ShoveGestureDetector
  extends TwoFingerGestureDetector
{
  private float mCurrAverageY;
  private final ShoveGestureDetector.OnShoveGestureListener mListener;
  private float mPrevAverageY;
  private boolean mSloppyGesture;
  
  public ShoveGestureDetector(Context paramContext, ShoveGestureDetector.OnShoveGestureListener paramOnShoveGestureListener)
  {
    super(paramContext);
    this.mListener = paramOnShoveGestureListener;
  }
  
  public float getShovePixelsDelta()
  {
    return this.mCurrAverageY - this.mPrevAverageY;
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
          this.mListener.onShoveEnd(this);
        }
        resetState();
        return;
      }
      if (!this.mSloppyGesture) {
        this.mListener.onShoveEnd(this);
      }
      resetState();
      return;
    }
    updateStateByEvent(paramMotionEvent);
    if ((this.mCurrPressure / this.mPrevPressure > 0.67F) && (Math.abs(getShovePixelsDelta()) > 0.5F) && (this.mListener.onShove(this)))
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
        this.mGestureInProgress = this.mListener.onShoveBegin(this);
      }
    }
    else
    {
      if (!this.mSloppyGesture) {
        return;
      }
      this.mSloppyGesture = isSloppyGesture(paramMotionEvent);
      if (!this.mSloppyGesture) {
        this.mGestureInProgress = this.mListener.onShoveBegin(this);
      }
    }
  }
  
  protected boolean isSloppyGesture(MotionEvent paramMotionEvent)
  {
    boolean bool2 = super.isSloppyGesture(paramMotionEvent);
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    double d = Math.abs(Math.atan2(this.mCurrFingerDiffY, this.mCurrFingerDiffX));
    if ((0.0D >= d) || (d >= 0.3499999940395355D))
    {
      if (2.789999961853027D >= d) {
        break label69;
      }
      if (d >= 3.141592653589793D) {
        return true;
      }
    }
    bool1 = false;
    label69:
    return bool1;
  }
  
  protected void resetState()
  {
    super.resetState();
    this.mSloppyGesture = false;
    this.mPrevAverageY = 0.0F;
    this.mCurrAverageY = 0.0F;
  }
  
  protected void updateStateByEvent(MotionEvent paramMotionEvent)
  {
    super.updateStateByEvent(paramMotionEvent);
    MotionEvent localMotionEvent = this.mPrevEvent;
    this.mPrevAverageY = ((localMotionEvent.getY(0) + localMotionEvent.getY(1)) / 2.0F);
    this.mCurrAverageY = ((paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.gesturedetectors.ShoveGestureDetector
 * JD-Core Version:    0.7.0.1
 */