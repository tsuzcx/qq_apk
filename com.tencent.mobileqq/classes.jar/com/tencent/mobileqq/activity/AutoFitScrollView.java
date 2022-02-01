package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import mqq.os.MqqHandler;

public class AutoFitScrollView
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  public int a;
  private long jdField_a_of_type_Long;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private AutoFitScroller jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 0;
  private int d;
  private int e;
  
  public AutoFitScrollView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AutoFitScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AutoFitScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller = new AutoFitScroller(getContext());
    this.d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    setFitWidth(paramContext.getResources().getDisplayMetrics().widthPixels, 10);
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AutoFitScroller localAutoFitScroller;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a() == 0)
    {
      localAutoFitScroller = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller;
      localAutoFitScroller.a(localAutoFitScroller.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b(), paramInt1, paramInt2);
    }
    else
    {
      localAutoFitScroller = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller;
      localAutoFitScroller.a(localAutoFitScroller.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b(), paramInt1 - this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(), paramInt2);
    }
    scrollTo(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b());
    postInvalidate();
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b())
    {
      scrollTo(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b());
      postInvalidate();
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localObject != null)
      {
        ((MqqHandler)localObject).removeMessages(65539);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65540);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65538);
        int i = this.jdField_a_of_type_Int - getWidth();
        if (getScrollX() <= i) {
          i = getScrollX();
        }
        if (i <= 0) {
          i = 0;
        }
        localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(65540, i, getScrollX() - this.e, Integer.valueOf(this.jdField_a_of_type_Int));
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(65538, 3000L);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 2) && (this.jdField_c_of_type_Int != 0)) {
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label139;
          }
        }
        else
        {
          i = (int)(f1 - this.jdField_a_of_type_Float);
          if ((Math.abs((int)(f2 - this.jdField_b_of_type_Float)) >= Math.abs(i)) || (Math.abs(i) <= this.d)) {
            break label139;
          }
          this.jdField_c_of_type_Int = 1;
          break label139;
        }
      }
      this.jdField_c_of_type_Int = 0;
    }
    else
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_c_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a() ^ true);
    }
    label139:
    return this.jdField_c_of_type_Int != 0;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0) {
      getChildAt(0).layout(0, 0, this.jdField_a_of_type_Int, paramInt4 - paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
        }
        else
        {
          scrollBy((int)(this.jdField_c_of_type_Float - f), 0);
          this.jdField_c_of_type_Float = f;
          this.jdField_a_of_type_Boolean = false;
          long l = System.currentTimeMillis();
          paramMotionEvent = this.jdField_a_of_type_MqqOsMqqHandler;
          if ((paramMotionEvent == null) || (l - this.jdField_a_of_type_Long <= 50L)) {
            break label522;
          }
          this.jdField_a_of_type_Long = l;
          paramMotionEvent.removeMessages(65539);
          i = this.jdField_a_of_type_Int - getWidth();
          if (getScrollX() <= i) {
            i = getScrollX();
          }
          if (i <= 0) {
            i = 0;
          }
          paramMotionEvent = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(65539, i, this.jdField_b_of_type_Int);
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramMotionEvent);
          return true;
        }
      }
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000);
      int k = (int)paramMotionEvent.getXVelocity();
      if (getChildCount() > 0)
      {
        int j;
        if (Math.abs(k) > 1000)
        {
          j = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(k);
          i = j;
          if (k > 0) {
            i = -j;
          }
          i = Math.round((i + getScrollX()) / this.jdField_b_of_type_Int);
          j = this.jdField_b_of_type_Int;
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller;
          boolean bool;
          if (k < 0) {
            bool = true;
          } else {
            bool = false;
          }
          i = paramMotionEvent.a(bool, Math.abs(i * j - getScrollX()));
          if (i < 0) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(getScrollX(), getScrollY(), -i, 0, 0, this.jdField_a_of_type_Int - getWidth(), 0, 0);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(getScrollX(), getScrollY(), -i, 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(), 0, 0);
          }
          postInvalidate();
        }
        else
        {
          i = getScrollX();
          j = Math.max(Math.min(Math.round((i + 0.1F) / this.jdField_b_of_type_Int) * this.jdField_b_of_type_Int, this.jdField_a_of_type_Int - getWidth()), 0);
          this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(i, getScrollY(), j - i, 0);
          postInvalidate();
        }
      }
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      }
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    else
    {
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller;
      if ((paramMotionEvent != null) && (!paramMotionEvent.a())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a();
      }
      this.jdField_c_of_type_Float = f;
      this.jdField_a_of_type_Boolean = false;
      this.e = getScrollX();
    }
    label522:
    return true;
  }
  
  public void setCallback(MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void setFitWidth(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoFitScrollView
 * JD-Core Version:    0.7.0.1
 */