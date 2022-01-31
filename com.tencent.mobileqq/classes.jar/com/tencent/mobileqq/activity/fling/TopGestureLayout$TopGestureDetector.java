package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class TopGestureLayout$TopGestureDetector
  extends GestureDetector.SimpleOnGestureListener
{
  private float jdField_a_of_type_Float;
  
  public TopGestureLayout$TopGestureDetector(TopGestureLayout paramTopGestureLayout, Context paramContext)
  {
    this.jdField_a_of_type_Float = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setGestureFlag(0);
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.isGestureIdle()) || (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.isGestureEnd())) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.hasGestureFlag(1)) {
      if ((f1 < 0.0F) && (f2 < 0.5F) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.mOnFlingGesture != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setGestureFlag(-1);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.mOnFlingGesture.flingLToR();
        }
      }
    }
    for (;;)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.hasGestureFlag(2)) && (f1 > 0.0F) && (f2 < 0.5F) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.mOnFlingGesture != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setGestureFlag(-1);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.mOnFlingGesture.flingRToL();
        }
      }
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.isGestureEnd()) {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.isGestureIdle())
    {
      if (Math.abs(f1) > this.jdField_a_of_type_Float) {
        if ((paramFloat1 < 0.0F) && (f2 < 0.5F))
        {
          if (TopGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setGestureFlag(1);
            return true;
          }
        }
        else if ((paramFloat1 > 0.0F) && (f2 < 0.5F) && (TopGestureLayout.b(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setGestureFlag(2);
          return true;
        }
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.hasGestureFlag(1)) {
        break label200;
      }
      if ((paramFloat1 > 0.0F) || (f2 >= 0.5F)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setGestureFlag(-1);
      }
    }
    for (;;)
    {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      label200:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.hasGestureFlag(2)) && ((paramFloat1 < 0.0F) || (f2 >= 0.5F))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setGestureFlag(-1);
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setGestureFlag(-1);
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector
 * JD-Core Version:    0.7.0.1
 */