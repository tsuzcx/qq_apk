package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

public class MsgTabStoryNodeView
  extends FrameLayout
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  public RecyclerView a;
  boolean jdField_a_of_type_Boolean = false;
  float b;
  
  public MsgTabStoryNodeView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    inflate(paramContext, 2130970733, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131371635));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new MsgTabStoryNodeView.HorizontalSpaceItemDecoration(paramContext));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    float f2;
    float f1;
    if (bool)
    {
      f2 = paramMotionEvent.getRawX();
      f1 = paramMotionEvent.getRawY();
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          do
          {
            return bool;
            this.b = f1;
            this.jdField_a_of_type_Float = f2;
          } while (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0);
          requestDisallowInterceptTouchEvent(true);
          return bool;
        } while (this.jdField_a_of_type_Boolean);
        f2 = Math.abs(f2 - this.jdField_a_of_type_Float);
        f1 = Math.abs(f1 - this.b);
        if ((f2 > this.jdField_a_of_type_Int) && (f2 > f1))
        {
          this.jdField_a_of_type_Boolean = true;
          return bool;
        }
      } while ((f1 <= this.jdField_a_of_type_Int) || (f1 <= f2));
      this.jdField_a_of_type_Boolean = true;
      requestDisallowInterceptTouchEvent(false);
      return bool;
    }
    this.jdField_a_of_type_Boolean = false;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView
 * JD-Core Version:    0.7.0.1
 */