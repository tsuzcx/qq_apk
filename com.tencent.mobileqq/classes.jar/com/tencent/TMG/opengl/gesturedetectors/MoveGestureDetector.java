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
    float f1 = 0.0F;
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    float f2 = 0.0F;
    while (i < j)
    {
      f2 += paramMotionEvent.getX(i);
      f1 += paramMotionEvent.getY(i);
      i += 1;
    }
    return new PointF(f2 / j, f1 / j);
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
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.mListener.onMoveEnd(this);
      resetState();
      return;
      updateStateByEvent(paramMotionEvent);
    } while ((this.mCurrPressure / this.mPrevPressure <= 0.67F) || (!this.mListener.onMove(this)));
    this.mPrevEvent.recycle();
    this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
  }
  
  protected void handleStartProgressEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      resetState();
      this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
      this.mTimeDelta = 0L;
      updateStateByEvent(paramMotionEvent);
      return;
    }
    this.mGestureInProgress = this.mListener.onMoveBegin(this);
  }
  
  protected void updateStateByEvent(MotionEvent paramMotionEvent)
  {
    super.updateStateByEvent(paramMotionEvent);
    MotionEvent localMotionEvent = this.mPrevEvent;
    this.mCurrFocusInternal = determineFocalPoint(paramMotionEvent);
    this.mPrevFocusInternal = determineFocalPoint(localMotionEvent);
    int i;
    if (localMotionEvent.getPointerCount() != paramMotionEvent.getPointerCount())
    {
      i = 1;
      if (i == 0) {
        break label102;
      }
    }
    label102:
    for (paramMotionEvent = FOCUS_DELTA_ZERO;; paramMotionEvent = new PointF(this.mCurrFocusInternal.x - this.mPrevFocusInternal.x, this.mCurrFocusInternal.y - this.mPrevFocusInternal.y))
    {
      this.mFocusDeltaExternal = paramMotionEvent;
      paramMotionEvent = this.mFocusExternal;
      paramMotionEvent.x += this.mFocusDeltaExternal.x;
      paramMotionEvent = this.mFocusExternal;
      paramMotionEvent.y += this.mFocusDeltaExternal.y;
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.opengl.gesturedetectors.MoveGestureDetector
 * JD-Core Version:    0.7.0.1
 */