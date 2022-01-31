package com.tencent.biz.qqstory.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class OverScrollRecyclerView$OverScrollingState
  implements OverScrollRecyclerView.IDecoratorState
{
  protected final float a;
  protected int a;
  protected final OverScrollRecyclerView.MotionAttributes a;
  protected final OverScrollRecyclerView.OverScrollStateManager a;
  protected final float b;
  
  public OverScrollRecyclerView$OverScrollingState(OverScrollRecyclerView.OverScrollStateManager paramOverScrollStateManager, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager = paramOverScrollStateManager;
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$MotionAttributes = new OverScrollRecyclerView.MotionAttributes();
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(OverScrollRecyclerView.IDecoratorState paramIDecoratorState)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStartAttributes.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    OverScrollRecyclerView.OverScrollStartAttributes localOverScrollStartAttributes = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStartAttributes;
    if (localOverScrollStartAttributes.jdField_a_of_type_Int != paramMotionEvent.getPointerId(0)) {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.a(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$BounceBackState);
    }
    View localView;
    OverScrollRecyclerView.IOverScrollDecor localIOverScrollDecor;
    do
    {
      return true;
      localView = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.a();
      localIOverScrollDecor = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$IOverScrollDecor;
    } while (!localIOverScrollDecor.a(localView, this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$MotionAttributes, paramMotionEvent));
    float f2 = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$MotionAttributes.b;
    if (this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$MotionAttributes.jdField_a_of_type_Boolean == localOverScrollStartAttributes.jdField_a_of_type_Boolean) {}
    for (float f1 = this.jdField_a_of_type_Float;; f1 = this.b)
    {
      f1 = f2 / f1;
      f2 = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$MotionAttributes.jdField_a_of_type_Float + f1;
      if (((!localOverScrollStartAttributes.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$MotionAttributes.jdField_a_of_type_Boolean) || (f2 > localOverScrollStartAttributes.jdField_a_of_type_Float)) && ((localOverScrollStartAttributes.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$MotionAttributes.jdField_a_of_type_Boolean) || (f2 < localOverScrollStartAttributes.jdField_a_of_type_Float))) {
        break;
      }
      localIOverScrollDecor.a(localView, localOverScrollStartAttributes.jdField_a_of_type_Float, paramMotionEvent);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.a(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$IdleState);
      return true;
    }
    if (localView.getParent() != null) {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
    if (l > 0L) {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_Float = (f1 / (float)l);
    }
    localIOverScrollDecor.a(localView, f2);
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.a(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$BounceBackState);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.OverScrollRecyclerView.OverScrollingState
 * JD-Core Version:    0.7.0.1
 */