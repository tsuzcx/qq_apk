package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

public class ClipDianDianTouchAreaLayout
  extends FrameLayout
{
  int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  boolean jdField_a_of_type_Boolean = false;
  int b = 1;
  private int c;
  
  public ClipDianDianTouchAreaLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ClipDianDianTouchAreaLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledMinimumFlingVelocity();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    if (k == 0)
    {
      this.jdField_a_of_type_AndroidViewView.getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_a_of_type_AndroidGraphicsRect.inset(this.c, this.c);
      this.jdField_a_of_type_Boolean = false;
      this.b = 1;
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null)
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
        label93:
        this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_AndroidGraphicsRect.contains(i, j)) {
        break;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      break label93;
      if (k == 2)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
        {
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
          this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
          if (Math.abs((int)this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity()) >= this.jdField_a_of_type_Int) {
            this.b = 2;
          }
        }
        if (this.b != 2) {
          continue;
        }
        return true;
      }
      if ((k == 1) || (k == 3))
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    if ((k == 1) || (k == 3)) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (k != 0) {
        break label104;
      }
      this.jdField_a_of_type_AndroidViewView.getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_a_of_type_AndroidGraphicsRect.inset(this.c, this.c);
      this.jdField_a_of_type_Boolean = false;
    }
    label104:
    do
    {
      do
      {
        return super.onTouchEvent(paramMotionEvent);
      } while (k != 2);
      if (this.b == 2)
      {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
          break;
        }
        this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        return false;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
          break;
        }
        this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        return false;
      }
    } while (this.jdField_a_of_type_AndroidGraphicsRect.contains(i, j));
    this.jdField_a_of_type_Boolean = true;
    super.onTouchEvent(paramMotionEvent);
    setPressed(false);
    return false;
  }
  
  public void setTouchWidget(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ClipDianDianTouchAreaLayout
 * JD-Core Version:    0.7.0.1
 */