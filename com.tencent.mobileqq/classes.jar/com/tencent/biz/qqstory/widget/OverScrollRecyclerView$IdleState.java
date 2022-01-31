package com.tencent.biz.qqstory.widget;

import android.view.MotionEvent;
import android.view.View;

public class OverScrollRecyclerView$IdleState
  implements OverScrollRecyclerView.IDecoratorState
{
  protected final OverScrollRecyclerView.MotionAttributes a;
  protected final OverScrollRecyclerView.OverScrollStateManager a;
  
  public OverScrollRecyclerView$IdleState(OverScrollRecyclerView.OverScrollStateManager paramOverScrollStateManager)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$MotionAttributes = new OverScrollRecyclerView.MotionAttributes();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager = paramOverScrollStateManager;
  }
  
  public void a(OverScrollRecyclerView.IDecoratorState paramIDecoratorState) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    View localView = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.a();
    OverScrollRecyclerView.IOverScrollDecor localIOverScrollDecor = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$IOverScrollDecor;
    if (!localIOverScrollDecor.a(localView, this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$MotionAttributes, paramMotionEvent)) {}
    OverScrollRecyclerView.OverScrollStartAttributes localOverScrollStartAttributes;
    do
    {
      return false;
      localOverScrollStartAttributes = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStartAttributes;
    } while (((!localIOverScrollDecor.a(localView)) || (!this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$MotionAttributes.jdField_a_of_type_Boolean)) && ((!localIOverScrollDecor.b(localView)) || (this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$MotionAttributes.jdField_a_of_type_Boolean)));
    localOverScrollStartAttributes.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
    localOverScrollStartAttributes.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$MotionAttributes.jdField_a_of_type_Float;
    localOverScrollStartAttributes.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$MotionAttributes.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.a(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollingState);
    return this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollingState.a(paramMotionEvent);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.OverScrollRecyclerView.IdleState
 * JD-Core Version:    0.7.0.1
 */