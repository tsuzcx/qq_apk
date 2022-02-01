package com.tencent.mobileqq.ark;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector;

public class ArkTopGestureLayout$ArkEdgeTopGestureDetector
  extends TopGestureLayout.TopGestureDetector
{
  public ArkTopGestureLayout$ArkEdgeTopGestureDetector(ArkTopGestureLayout paramArkTopGestureLayout, Context paramContext)
  {
    super(paramArkTopGestureLayout, paramContext);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.a.isGestureIdle()) || (this.a.isGestureEnd())) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
            paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
            if (!this.a.hasGestureFlag(1)) {
              break;
            }
          } while ((paramFloat1 >= 0.0F) || (paramFloat2 >= 0.5F) || (this.a.mOnFlingGesture == null));
          this.a.setGestureFlag(-1);
        } while (ArkTopGestureLayout.a(this.a));
        this.a.mOnFlingGesture.flingLToR();
        return false;
      } while ((!this.a.hasGestureFlag(2)) || (paramFloat1 <= 0.0F) || (paramFloat2 >= 0.5F) || (this.a.mOnFlingGesture == null));
      this.a.setGestureFlag(-1);
    } while (ArkTopGestureLayout.b(this.a));
    this.a.mOnFlingGesture.flingRToL();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTopGestureLayout.ArkEdgeTopGestureDetector
 * JD-Core Version:    0.7.0.1
 */