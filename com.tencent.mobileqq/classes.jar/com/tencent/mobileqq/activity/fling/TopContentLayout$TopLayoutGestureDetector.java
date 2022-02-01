package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class TopContentLayout$TopLayoutGestureDetector
  extends GestureDetector.SimpleOnGestureListener
{
  private float jdField_a_of_type_Float;
  
  public TopContentLayout$TopLayoutGestureDetector(TopContentLayout paramTopContentLayout, Context paramContext)
  {
    this.jdField_a_of_type_Float = TypedValue.applyDimension(1, 50.0F, paramContext.getResources().getDisplayMetrics());
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i;
    int j;
    if (TopContentLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout))
    {
      TopContentLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout, false);
      i = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout.getWidth();
      j = Math.abs((int)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout.getMovingViewTransX());
      if (paramFloat1 <= 0.0F) {
        break label96;
      }
      i -= j;
    }
    for (;;)
    {
      TopContentLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout).startScroll((int)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout.getMovingViewTransX(), 0, i, 0, 350);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout.invalidate();
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      label96:
      i = -j;
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1;
    if (!TopContentLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout))
    {
      f1 = Math.abs(paramFloat2 / paramFloat1);
      float f2 = Math.abs(paramMotionEvent1.getX() - paramMotionEvent2.getX());
      if ((paramFloat1 < 0.0F) && (f1 < 0.5F) && (f2 > this.jdField_a_of_type_Float))
      {
        TopContentLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout, true);
        if (TopContentLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout) != null) {
          TopContentLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout).startDrag();
        }
        return true;
      }
      f1 = paramFloat1;
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, f1, paramFloat2);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout.getMovingViewWidth();
    int j = Math.abs((int)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout.getMovingViewTransX());
    if ((paramFloat1 < 0.0F) && (j < i)) {
      if (Math.abs(paramFloat1) > i - j) {
        paramFloat1 = i - j;
      }
    }
    for (;;)
    {
      f1 = paramFloat1;
      if (Math.abs(paramFloat1) <= 0.0F) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout.movingViewTransBy((int)paramFloat1, 0.0F);
      f1 = paramFloat1;
      if (TopContentLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout) == null) {
        break;
      }
      TopContentLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout).outing((int)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout.getMovingViewTransX(), 0, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout);
      f1 = paramFloat1;
      break;
      paramFloat1 = -paramFloat1;
      continue;
      if ((paramFloat1 > 0.0F) && (j > 0))
      {
        if (Math.abs(paramFloat1) > j) {
          paramFloat1 = -j;
        } else {
          paramFloat1 = -paramFloat1;
        }
      }
      else {
        paramFloat1 = 0.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopContentLayout.TopLayoutGestureDetector
 * JD-Core Version:    0.7.0.1
 */