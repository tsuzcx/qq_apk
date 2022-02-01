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
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private float b = 0.0F;
  
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
    int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getChildCount();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
    {
      float f = this.jdField_a_of_type_Float;
      paramFloat2 -= this.b;
      bool1 = bool2;
      if (Math.abs(paramFloat2) > this.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (Math.abs(paramFloat2) > Math.abs(paramFloat1 - f)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label110;
          }
        }
        else
        {
          if (a(paramMotionEvent.getX(), paramMotionEvent.getY()))
          {
            getParent().requestDisallowInterceptTouchEvent(false);
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          getParent().requestDisallowInterceptTouchEvent(true);
          break label110;
        }
      }
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    label110:
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    super.setScrollingTouchSlop(paramInt);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.jdField_a_of_type_Int = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
      return;
    }
    this.jdField_a_of_type_Int = localViewConfiguration.getScaledTouchSlop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.CustomHorizontallyScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */