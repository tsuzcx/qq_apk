package com.tencent.TMG.opengl.gesturedetectors;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public abstract class TwoFingerGestureDetector
  extends BaseGestureDetector
{
  private float mBottomSlopEdge;
  protected float mCurrFingerDiffX;
  protected float mCurrFingerDiffY;
  private float mCurrLen;
  private final float mEdgeSlop;
  protected float mPrevFingerDiffX;
  protected float mPrevFingerDiffY;
  private float mPrevLen;
  private float mRightSlopEdge;
  
  public TwoFingerGestureDetector(Context paramContext)
  {
    super(paramContext);
    this.mEdgeSlop = ViewConfiguration.get(paramContext).getScaledEdgeSlop();
  }
  
  protected static float getRawX(MotionEvent paramMotionEvent, int paramInt)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getRawX();
    if (paramInt < paramMotionEvent.getPointerCount()) {
      return f1 - f2 + paramMotionEvent.getX(paramInt);
    }
    return 0.0F;
  }
  
  protected static float getRawY(MotionEvent paramMotionEvent, int paramInt)
  {
    float f1 = paramMotionEvent.getY();
    float f2 = paramMotionEvent.getRawY();
    if (paramInt < paramMotionEvent.getPointerCount()) {
      return f1 - f2 + paramMotionEvent.getY(paramInt);
    }
    return 0.0F;
  }
  
  public float getCurrentSpan()
  {
    if (this.mCurrLen == -1.0F)
    {
      float f1 = this.mCurrFingerDiffX;
      float f2 = this.mCurrFingerDiffY;
      this.mCurrLen = FloatMath.sqrt(f1 * f1 + f2 * f2);
    }
    return this.mCurrLen;
  }
  
  public float getPreviousSpan()
  {
    if (this.mPrevLen == -1.0F)
    {
      float f1 = this.mPrevFingerDiffX;
      float f2 = this.mPrevFingerDiffY;
      this.mPrevLen = FloatMath.sqrt(f1 * f1 + f2 * f2);
    }
    return this.mPrevLen;
  }
  
  protected abstract void handleInProgressEvent(int paramInt, MotionEvent paramMotionEvent);
  
  protected abstract void handleStartProgressEvent(int paramInt, MotionEvent paramMotionEvent);
  
  protected boolean isSloppyGesture(MotionEvent paramMotionEvent)
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    this.mRightSlopEdge = (localDisplayMetrics.widthPixels - this.mEdgeSlop);
    this.mBottomSlopEdge = (localDisplayMetrics.heightPixels - this.mEdgeSlop);
    float f1 = this.mEdgeSlop;
    float f2 = this.mRightSlopEdge;
    float f3 = this.mBottomSlopEdge;
    float f4 = paramMotionEvent.getRawX();
    float f5 = paramMotionEvent.getRawY();
    float f6 = getRawX(paramMotionEvent, 1);
    float f7 = getRawY(paramMotionEvent, 1);
    int i;
    int j;
    if ((f4 < f1) || (f5 < f1) || (f4 > f2) || (f5 > f3))
    {
      i = 1;
      if ((f6 >= f1) && (f7 >= f1) && (f6 <= f2) && (f7 <= f3)) {
        break label166;
      }
      j = 1;
      label148:
      if ((i == 0) || (j == 0)) {
        break label172;
      }
    }
    label166:
    label172:
    while ((i != 0) || (j != 0))
    {
      return true;
      i = 0;
      break;
      j = 0;
      break label148;
    }
    return false;
  }
  
  protected void updateStateByEvent(MotionEvent paramMotionEvent)
  {
    super.updateStateByEvent(paramMotionEvent);
    MotionEvent localMotionEvent = this.mPrevEvent;
    this.mCurrLen = -1.0F;
    this.mPrevLen = -1.0F;
    float f1 = localMotionEvent.getX(0);
    float f2 = localMotionEvent.getY(0);
    float f3 = localMotionEvent.getX(1);
    float f4 = localMotionEvent.getY(1);
    this.mPrevFingerDiffX = (f3 - f1);
    this.mPrevFingerDiffY = (f4 - f2);
    f1 = paramMotionEvent.getX(0);
    f2 = paramMotionEvent.getY(0);
    f3 = paramMotionEvent.getX(1);
    f4 = paramMotionEvent.getY(1);
    this.mCurrFingerDiffX = (f3 - f1);
    this.mCurrFingerDiffY = (f4 - f2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.opengl.gesturedetectors.TwoFingerGestureDetector
 * JD-Core Version:    0.7.0.1
 */