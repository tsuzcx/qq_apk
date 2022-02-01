package com.tencent.TMG.opengl.gesturedetectors;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

public class MoveGestureDetector
  extends BaseGestureDetector
{
  private static final PointF FOCUS_DELTA_ZERO = new PointF();
  private PointF mCurrFocusInternal;
  private PointF mFocusDeltaExternal = new PointF();
  private PointF mFocusExternal = new PointF();
  private final MoveGestureDetector.OnMoveGestureListener mListener;
  private PointF mPrevFocusInternal;
  
  public MoveGestureDetector(Context paramContext, MoveGestureDetector.OnMoveGestureListener paramOnMoveGestureListener)
  {
    super(paramContext);
    this.mListener = paramOnMoveGestureListener;
  }
  
  private PointF determineFocalPoint(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    float f2 = 0.0F;
    int i = 0;
    float f1 = 0.0F;
    while (i < j)
    {
      f2 += paramMotionEvent.getX(i);
      f1 += paramMotionEvent.getY(i);
      i += 1;
    }
    float f3 = j;
    return new PointF(f2 / f3, f1 / f3);
  }
  
  public PointF getFocusDelta()
  {
    return this.mFocusDeltaExternal;
  }
  
  public float getFocusX()
  {
    return this.mFocusExternal.x;
  }
  
  public float getFocusY()
  {
    return this.mFocusExternal.y;
  }
  
  protected void handleInProgressEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt == 3) {}
      }
      else
      {
        updateStateByEvent(paramMotionEvent);
        if ((this.mCurrPressure / this.mPrevPressure <= 0.67F) || (!this.mListener.onMove(this))) {
          return;
        }
        this.mPrevEvent.recycle();
        this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
        return;
      }
    }
    this.mListener.onMoveEnd(this);
    resetState();
  }
  
  protected void handleStartProgressEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    if (paramInt != 0)
    {
      if (paramInt != 2) {
        return;
      }
      this.mGestureInProgress = this.mListener.onMoveBegin(this);
      return;
    }
    resetState();
    this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
    this.mTimeDelta = 0L;
    updateStateByEvent(paramMotionEvent);
  }
  
  protected void updateStateByEvent(MotionEvent paramMotionEvent)
  {
    super.updateStateByEvent(paramMotionEvent);
    MotionEvent localMotionEvent = this.mPrevEvent;
    this.mCurrFocusInternal = determineFocalPoint(paramMotionEvent);
    this.mPrevFocusInternal = determineFocalPoint(localMotionEvent);
    int i;
    if (localMotionEvent.getPointerCount() != paramMotionEvent.getPointerCount()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramMotionEvent = FOCUS_DELTA_ZERO;
    } else {
      paramMotionEvent = new PointF(this.mCurrFocusInternal.x - this.mPrevFocusInternal.x, this.mCurrFocusInternal.y - this.mPrevFocusInternal.y);
    }
    this.mFocusDeltaExternal = paramMotionEvent;
    paramMotionEvent = this.mFocusExternal;
    paramMotionEvent.x += this.mFocusDeltaExternal.x;
    paramMotionEvent = this.mFocusExternal;
    paramMotionEvent.y += this.mFocusDeltaExternal.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.gesturedetectors.MoveGestureDetector
 * JD-Core Version:    0.7.0.1
 */