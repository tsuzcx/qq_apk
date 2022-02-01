package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class TopGestureLayout$TopGestureDetector
  extends GestureDetector.SimpleOnGestureListener
{
  private float mTouchSlot;
  
  public TopGestureLayout$TopGestureDetector(TopGestureLayout paramTopGestureLayout, Context paramContext)
  {
    this.mTouchSlot = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.this$0.setGestureFlag(0);
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.this$0.isGestureIdle()) || (this.this$0.isGestureEnd())) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
    if (this.this$0.hasGestureFlag(1)) {
      if ((f1 < 0.0F) && (f2 < 0.5F) && (this.this$0.mOnFlingGesture != null))
      {
        this.this$0.setGestureFlag(-1);
        if (!this.this$0.isInTwoFingerMode()) {
          this.this$0.mOnFlingGesture.flingLToR();
        }
      }
    }
    for (;;)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      if ((this.this$0.hasGestureFlag(2)) && (f1 > 0.0F) && (f2 < 0.5F) && (this.this$0.mOnFlingGesture != null))
      {
        this.this$0.setGestureFlag(-1);
        if (!this.this$0.isInTwoFingerMode()) {
          this.this$0.mOnFlingGesture.flingRToL();
        }
      }
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.this$0.isGestureEnd()) {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
    if (this.this$0.isGestureIdle())
    {
      if (Math.abs(f1) > this.mTouchSlot) {
        if ((paramFloat1 < 0.0F) && (f2 < 0.5F))
        {
          if (TopGestureLayout.access$000(this.this$0))
          {
            this.this$0.setGestureFlag(1);
            return TopGestureLayout.access$100(this.this$0);
          }
        }
        else if ((paramFloat1 > 0.0F) && (f2 < 0.5F) && (TopGestureLayout.access$200(this.this$0)))
        {
          this.this$0.setGestureFlag(2);
          return TopGestureLayout.access$100(this.this$0);
        }
      }
    }
    else
    {
      if (!this.this$0.hasGestureFlag(1)) {
        break label212;
      }
      if ((paramFloat1 > 0.0F) || (f2 >= 0.5F)) {
        this.this$0.setGestureFlag(-1);
      }
    }
    for (;;)
    {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      label212:
      if ((this.this$0.hasGestureFlag(2)) && ((paramFloat1 < 0.0F) || (f2 >= 0.5F))) {
        this.this$0.setGestureFlag(-1);
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.this$0.setGestureFlag(-1);
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector
 * JD-Core Version:    0.7.0.1
 */