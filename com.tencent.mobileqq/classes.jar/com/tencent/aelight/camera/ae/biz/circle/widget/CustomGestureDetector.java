package com.tencent.aelight.camera.ae.biz.circle.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

class CustomGestureDetector
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private final ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private OnGestureListener jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetOnGestureListener;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private final float c;
  private final float d;
  
  CustomGestureDetector(Context paramContext, OnGestureListener paramOnGestureListener)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.d = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.c = localViewConfiguration.getScaledTouchSlop();
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetOnGestureListener = paramOnGestureListener;
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, new CustomGestureDetector.1(this));
  }
  
  private float a(MotionEvent paramMotionEvent)
  {
    try
    {
      float f = paramMotionEvent.getX(this.jdField_b_of_type_Int);
      return f;
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    return paramMotionEvent.getX();
  }
  
  private float b(MotionEvent paramMotionEvent)
  {
    try
    {
      float f = paramMotionEvent.getY(this.jdField_b_of_type_Int);
      return f;
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    return paramMotionEvent.getY();
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    VelocityTracker localVelocityTracker;
    if (i != 0)
    {
      float f1;
      float f2;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 6)
            {
              i = Util.a(paramMotionEvent.getAction());
              if (paramMotionEvent.getPointerId(i) == this.jdField_a_of_type_Int)
              {
                if (i == 0) {
                  i = 1;
                } else {
                  i = 0;
                }
                this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(i);
                this.jdField_a_of_type_Float = paramMotionEvent.getX(i);
                this.jdField_b_of_type_Float = paramMotionEvent.getY(i);
              }
            }
          }
          else
          {
            this.jdField_a_of_type_Int = -1;
            localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
            if (localVelocityTracker != null)
            {
              localVelocityTracker.recycle();
              this.jdField_a_of_type_AndroidViewVelocityTracker = null;
            }
          }
        }
        else
        {
          f1 = a(paramMotionEvent);
          f2 = b(paramMotionEvent);
          i = paramMotionEvent.getPointerCount();
          float f3 = f1 - this.jdField_a_of_type_Float;
          float f4 = f2 - this.jdField_b_of_type_Float;
          if (!this.jdField_a_of_type_Boolean)
          {
            boolean bool;
            if (Math.sqrt(f3 * f3 + f4 * f4) >= this.c) {
              bool = true;
            } else {
              bool = false;
            }
            this.jdField_a_of_type_Boolean = bool;
          }
          if (i > 1) {
            this.jdField_a_of_type_Boolean = false;
          }
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Float = f1;
            this.jdField_b_of_type_Float = f2;
            localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
            if (localVelocityTracker != null) {
              localVelocityTracker.addMovement(paramMotionEvent);
            }
          }
        }
      }
      else
      {
        this.jdField_a_of_type_Int = -1;
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewVelocityTracker != null))
        {
          this.jdField_a_of_type_Float = a(paramMotionEvent);
          this.jdField_b_of_type_Float = b(paramMotionEvent);
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
          this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
          f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
          f2 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
          if (Math.max(Math.abs(f1), Math.abs(f2)) >= this.d) {
            this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetOnGestureListener.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, -f1, -f2);
          }
        }
        localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
        if (localVelocityTracker != null)
        {
          localVelocityTracker.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
      if (localVelocityTracker != null) {
        localVelocityTracker.addMovement(paramMotionEvent);
      }
      this.jdField_a_of_type_Float = a(paramMotionEvent);
      this.jdField_b_of_type_Float = b(paramMotionEvent);
      this.jdField_a_of_type_Boolean = false;
    }
    i = this.jdField_a_of_type_Int;
    if (i == -1) {
      i = 0;
    }
    this.jdField_b_of_type_Int = paramMotionEvent.findPointerIndex(i);
    return true;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    try
    {
      boolean bool3 = this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
      boolean bool4 = b(paramMotionEvent);
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.widget.CustomGestureDetector
 * JD-Core Version:    0.7.0.1
 */