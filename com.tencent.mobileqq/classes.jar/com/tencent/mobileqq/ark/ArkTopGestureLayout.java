package com.tencent.mobileqq.ark;

import android.content.Context;
import android.view.MotionEvent;
import anla;
import bdcb;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.StickerDismissGestureDetector;

public class ArkTopGestureLayout
  extends TopGestureLayout
{
  private int a;
  
  public ArkTopGestureLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 10;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new anla(this, paramContext);
    this.mTopGestureDetector = new TopGestureLayout.StickerDismissGestureDetector(this, paramContext, this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener);
    this.defaultGestureDetector = this.mTopGestureDetector;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (paramMotionEvent.getX() <= this.jdField_a_of_type_Int / 100.0F * (float)bdcb.i()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bool = super.onInterceptTouchEvent(paramMotionEvent);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */