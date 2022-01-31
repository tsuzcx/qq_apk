package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import bdaq;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

public class TopEdgeGestureLayout
  extends TopGestureLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  
  public TopEdgeGestureLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TopEdgeGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopEdgeGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = bdaq.a(getContext(), 25.0F);
    this.jdField_b_of_type_Int = ViewConfiguration.getTouchSlop();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Float = paramMotionEvent.getX();
    }
    while (paramMotionEvent.getAction() != 2) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i = getWidth();
    if (((this.jdField_b_of_type_Float < this.jdField_a_of_type_Int) || (Math.abs(i - this.jdField_b_of_type_Float) < this.jdField_a_of_type_Int)) && (Math.abs(this.jdField_b_of_type_Float - paramMotionEvent.getX()) > this.jdField_b_of_type_Int)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.TopEdgeGestureLayout
 * JD-Core Version:    0.7.0.1
 */