package com.tencent.biz.qqstory.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class OverScrollRecyclerView$OverScrollStateManager
  implements View.OnTouchListener
{
  protected float a;
  protected final RecyclerView a;
  protected OverScrollRecyclerView.BounceBackState a;
  protected OverScrollRecyclerView.IDecoratorState a;
  protected OverScrollRecyclerView.IOverScrollDecor a;
  protected OverScrollRecyclerView.IdleState a;
  protected final OverScrollRecyclerView.OverScrollStartAttributes a;
  protected OverScrollRecyclerView.OverScrollingState a;
  
  public OverScrollRecyclerView$OverScrollStateManager(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$IOverScrollDecor = new OverScrollRecyclerView.LinearScrollViewOverScrollDecor();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollStartAttributes = new OverScrollRecyclerView.OverScrollStartAttributes();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$BounceBackState = new OverScrollRecyclerView.BounceBackState(this, -2.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$OverScrollingState = new OverScrollRecyclerView.OverScrollingState(this, 3.0F, 1.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$IdleState = new OverScrollRecyclerView.IdleState(this);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$IDecoratorState = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$IdleState;
    b();
  }
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      paramLayoutManager = (LinearLayoutManager)paramLayoutManager;
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$IOverScrollDecor.a(paramLayoutManager.getOrientation());
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$IOverScrollDecor.a(1);
  }
  
  protected void a(OverScrollRecyclerView.IDecoratorState paramIDecoratorState)
  {
    OverScrollRecyclerView.IDecoratorState localIDecoratorState = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$IDecoratorState;
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$IDecoratorState = paramIDecoratorState;
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$IDecoratorState.a(localIDecoratorState);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnTouchListener(null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(0);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 2: 
      return this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$IDecoratorState.a(paramMotionEvent);
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$IDecoratorState.b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.OverScrollRecyclerView.OverScrollStateManager
 * JD-Core Version:    0.7.0.1
 */