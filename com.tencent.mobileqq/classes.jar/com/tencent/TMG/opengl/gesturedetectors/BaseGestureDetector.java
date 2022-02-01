package com.tencent.TMG.opengl.gesturedetectors;

import android.content.Context;
import android.view.MotionEvent;

public abstract class BaseGestureDetector
{
  protected static final float PRESSURE_THRESHOLD = 0.67F;
  protected final Context mContext;
  protected MotionEvent mCurrEvent;
  protected float mCurrPressure;
  protected boolean mGestureInProgress;
  protected MotionEvent mPrevEvent;
  protected float mPrevPressure;
  protected long mTimeDelta;
  
  public BaseGestureDetector(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public long getEventTime()
  {
    return this.mCurrEvent.getEventTime();
  }
  
  public long getTimeDelta()
  {
    return this.mTimeDelta;
  }
  
  protected abstract void handleInProgressEvent(int paramInt, MotionEvent paramMotionEvent);
  
  protected abstract void handleStartProgressEvent(int paramInt, MotionEvent paramMotionEvent);
  
  public boolean isInProgress()
  {
    return this.mGestureInProgress;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (!this.mGestureInProgress) {
      handleStartProgressEvent(i, paramMotionEvent);
    } else {
      handleInProgressEvent(i, paramMotionEvent);
    }
    return true;
  }
  
  protected void resetState()
  {
    MotionEvent localMotionEvent = this.mPrevEvent;
    if (localMotionEvent != null)
    {
      localMotionEvent.recycle();
      this.mPrevEvent = null;
    }
    localMotionEvent = this.mCurrEvent;
    if (localMotionEvent != null)
    {
      localMotionEvent.recycle();
      this.mCurrEvent = null;
    }
    this.mGestureInProgress = false;
  }
  
  protected void updateStateByEvent(MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent1 = this.mPrevEvent;
    MotionEvent localMotionEvent2 = this.mCurrEvent;
    if (localMotionEvent2 != null)
    {
      localMotionEvent2.recycle();
      this.mCurrEvent = null;
    }
    this.mCurrEvent = MotionEvent.obtain(paramMotionEvent);
    this.mTimeDelta = (paramMotionEvent.getEventTime() - localMotionEvent1.getEventTime());
    this.mCurrPressure = paramMotionEvent.getPressure(paramMotionEvent.getActionIndex());
    this.mPrevPressure = localMotionEvent1.getPressure(localMotionEvent1.getActionIndex());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.gesturedetectors.BaseGestureDetector
 * JD-Core Version:    0.7.0.1
 */