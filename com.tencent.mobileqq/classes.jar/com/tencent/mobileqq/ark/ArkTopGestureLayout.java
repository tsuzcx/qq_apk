package com.tencent.mobileqq.ark;

import android.content.Context;
import android.view.MotionEvent;
import apzu;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.StickerDismissGestureDetector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class ArkTopGestureLayout
  extends TopGestureLayout
{
  private int a = 10;
  
  public ArkTopGestureLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public void init(Context paramContext)
  {
    this.gestureListener = new apzu(this, paramContext);
    this.mTopGestureDetector = new TopGestureLayout.StickerDismissGestureDetector(this, paramContext, this.gestureListener);
    this.defaultGestureDetector = this.mTopGestureDetector;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (paramMotionEvent.getX() <= this.a / 100.0F * (float)DeviceInfoUtil.getPortraitWidth()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bool = super.onInterceptTouchEvent(paramMotionEvent);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */