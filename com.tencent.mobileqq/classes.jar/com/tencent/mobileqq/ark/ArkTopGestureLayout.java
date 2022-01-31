package com.tencent.mobileqq.ark;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.StickerDismissGestureDetector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class ArkTopGestureLayout
  extends TopGestureLayout
{
  private int a;
  
  public ArkTopGestureLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 10;
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new ArkTopGestureLayout.ArkEdgeTopGestureDetector(this, paramContext);
    this.mTopGestureDetector = new TopGestureLayout.StickerDismissGestureDetector(this, paramContext, this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener);
    this.defaultGestureDetector = this.mTopGestureDetector;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (paramMotionEvent.getX() <= this.jdField_a_of_type_Int / 100.0F * (float)DeviceInfoUtil.j()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bool = super.onInterceptTouchEvent(paramMotionEvent);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */