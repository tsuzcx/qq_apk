package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class ClipDianDianTouchAreaLayout
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_a_of_type_AndroidViewView;
  boolean jdField_a_of_type_Boolean = false;
  
  public ClipDianDianTouchAreaLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ClipDianDianTouchAreaLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidViewView.getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_a_of_type_AndroidGraphicsRect.inset(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    }
    if (!this.jdField_a_of_type_AndroidGraphicsRect.contains(i, j)) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    if ((k == 1) || (k == 3)) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (k == 0)
      {
        this.jdField_a_of_type_AndroidViewView.getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidGraphicsRect.inset(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Boolean = false;
      }
      if (!this.jdField_a_of_type_AndroidGraphicsRect.contains(i, j))
      {
        if (k == 2) {
          this.jdField_a_of_type_Boolean = true;
        }
        super.onTouchEvent(paramMotionEvent);
        setPressed(false);
        return false;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setTouchWidget(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ClipDianDianTouchAreaLayout
 * JD-Core Version:    0.7.0.1
 */