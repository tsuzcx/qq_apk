package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;

public class TouchControllerFrameLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float = -3.402824E+038F;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
  private TouchControllerFrameLayout.CustomTouchListener jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginTouchControllerFrameLayout$CustomTouchListener;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public TouchControllerFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, getScrollY(), 0, paramInt - getScrollY());
    invalidate();
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    View localView2 = this.jdField_a_of_type_AndroidViewView;
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = getChildAt(0);
    }
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    if (a(localView1, paramMotionEvent))
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  public static boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    int i = (int)paramMotionEvent.getRawY();
    int j = (int)paramMotionEvent.getRawX();
    paramMotionEvent = new int[2];
    paramView.getLocationOnScreen(paramMotionEvent);
    int k = paramMotionEvent[0];
    int m = paramMotionEvent[1];
    int n = paramView.getMeasuredWidth();
    int i1 = paramView.getMeasuredHeight();
    boolean bool1 = bool2;
    if (i >= m)
    {
      bool1 = bool2;
      if (i <= i1 + m)
      {
        bool1 = bool2;
        if (j >= k)
        {
          bool1 = bool2;
          if (j <= n + k) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public float a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TouchControllerFrameLayout", 2, new Object[] { "canScrollDistance getScrollY()=", Integer.valueOf(getScrollY()), ", dist=", Float.valueOf(paramFloat) });
    }
    if ((int)(getScrollY() + paramFloat) < 0) {
      return paramFloat;
    }
    return -getScrollY();
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      invalidate();
      return;
    }
    if (this.b)
    {
      this.b = false;
      TouchControllerFrameLayout.CustomTouchListener localCustomTouchListener = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginTouchControllerFrameLayout$CustomTouchListener;
      if (localCustomTouchListener != null) {
        localCustomTouchListener.a();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!a(paramMotionEvent)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
        }
        else
        {
          float f2 = this.jdField_a_of_type_Float;
          if (f2 == -3.402824E+038F)
          {
            this.jdField_a_of_type_Float = f1;
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          f2 = -(f1 - f2);
          float f3 = a(f2);
          if ((this.jdField_a_of_type_Boolean) && (f3 != 0.0F)) {
            scrollBy(0, (int)f3);
          } else if (f3 > 0.0F) {
            scrollBy(0, (int)f3);
          }
          if (Math.abs(f2) > 5.0F) {
            this.c = true;
          }
          this.jdField_a_of_type_Float = f1;
          return true;
        }
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = -3.402824E+038F;
      i = -getScrollY();
      boolean bool;
      if (-getScrollY() < this.jdField_a_of_type_Int) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("TouchControllerFrameLayout", 1, new Object[] { "dispatchTouchEvent ACTION_UP -getScrollY()=", Integer.valueOf(i), ", toUp=", Boolean.valueOf(bool) });
      if (this.c)
      {
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        if (-getScrollY() < this.jdField_a_of_type_Int)
        {
          a(0);
          return false;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginTouchControllerFrameLayout$CustomTouchListener != null)
        {
          this.b = true;
          a(-getHeight());
        }
        return false;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    this.c = false;
    this.jdField_a_of_type_Float = f1;
    QLog.d("TouchControllerFrameLayout", 1, new Object[] { "dispatchTouchEvent ACTION_DOWN mPreY=", Float.valueOf(this.jdField_a_of_type_Float) });
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setCustomTouchListener(TouchControllerFrameLayout.CustomTouchListener paramCustomTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginTouchControllerFrameLayout$CustomTouchListener = paramCustomTouchListener;
  }
  
  public void setHeadView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setMaxScrollHeight(int paramInt)
  {
    QLog.d("TouchControllerFrameLayout", 1, new Object[] { "maxScrollHeight=", Integer.valueOf(paramInt) });
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.TouchControllerFrameLayout
 * JD-Core Version:    0.7.0.1
 */