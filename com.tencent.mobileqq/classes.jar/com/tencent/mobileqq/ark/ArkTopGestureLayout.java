package com.tencent.mobileqq.ark;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.StickerDismissGestureDetector;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class ArkTopGestureLayout
  extends TopGestureLayout
{
  private int a = 10;
  
  public ArkTopGestureLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void init(Context paramContext)
  {
    this.gestureListener = new ArkTopGestureLayout.ArkEdgeTopGestureDetector(this, paramContext);
    this.mTopGestureDetector = new StickerDismissGestureDetector(this, paramContext, this.gestureListener);
    this.defaultGestureDetector = this.mTopGestureDetector;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    if (paramMotionEvent.getX() <= this.a / 100.0F * (float)DeviceInfoUtil.D()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */