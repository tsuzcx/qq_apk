package com.tencent.biz.videostory.widget.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public class CustomHorizontallyScrollRecyclerView
  extends RecyclerView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private float b;
  
  public CustomHorizontallyScrollRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CustomHorizontallyScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CustomHorizontallyScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = ((LinearLayoutManager)getLayoutManager());
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getChildCount() > 0)
    {
      float f = this.jdField_a_of_type_Float;
      paramFloat2 -= this.b;
      return (Math.abs(paramFloat2) > this.jdField_a_of_type_Int) && (Math.abs(paramFloat2) > Math.abs(paramFloat1 - f));
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      if (a(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      getParent().requestDisallowInterceptTouchEvent(false);
    }
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    super.setScrollingTouchSlop(paramInt);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Int = localViewConfiguration.getScaledTouchSlop();
      return;
    }
    this.jdField_a_of_type_Int = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.CustomHorizontallyScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */