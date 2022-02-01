package com.tencent.mobileqq.activity;

import adla;
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
  private adla jdField_a_of_type_Adla;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
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
    this.jdField_a_of_type_Adla = new adla(getContext());
    this.d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    setFitWidth(paramContext.getResources().getDisplayMetrics().widthPixels, 10);
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Adla.a() == 0) {
      this.jdField_a_of_type_Adla.a(this.jdField_a_of_type_Adla.a(), this.jdField_a_of_type_Adla.b(), paramInt1, paramInt2);
    }
    for (;;)
    {
      scrollTo(this.jdField_a_of_type_Adla.a(), this.jdField_a_of_type_Adla.b());
      postInvalidate();
      return;
      this.jdField_a_of_type_Adla.a(this.jdField_a_of_type_Adla.a(), this.jdField_a_of_type_Adla.b(), paramInt1 - this.jdField_a_of_type_Adla.a(), paramInt2);
    }
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_Adla.b())
    {
      scrollTo(this.jdField_a_of_type_Adla.a(), this.jdField_a_of_type_Adla.b());
      postInvalidate();
    }
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65539);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65540);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65538);
      i = this.jdField_a_of_type_Int - getWidth();
      if (getScrollX() <= i) {
        break label151;
      }
      if (i <= 0) {
        break label159;
      }
    }
    for (;;)
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(65540, i, getScrollX() - this.e, Integer.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(65538, 3000L);
      this.jdField_a_of_type_Boolean = false;
      return;
      label151:
      i = getScrollX();
      break;
      label159:
      i = 0;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 2) && (this.jdField_c_of_type_Int != 0)) {}
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      switch (i)
      {
      }
      while (this.jdField_c_of_type_Int == 0)
      {
        return false;
        this.jdField_a_of_type_Float = f1;
        this.jdField_b_of_type_Float = f2;
        if (this.jdField_a_of_type_Adla.a()) {}
        for (i = 0;; i = 1)
        {
          this.jdField_c_of_type_Int = i;
          break;
        }
        i = (int)(f1 - this.jdField_a_of_type_Float);
        if ((Math.abs((int)(f2 - this.jdField_b_of_type_Float)) < Math.abs(i)) && (Math.abs(i) > this.d))
        {
          this.jdField_c_of_type_Int = 1;
          continue;
          this.jdField_c_of_type_Int = 0;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0) {
      getChildAt(0).layout(0, 0, this.jdField_a_of_type_Int, paramInt4 - paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    super.onTouchEvent(paramMotionEvent);
    if (this.jdField_b_of_type_Boolean) {}
    long l;
    do
    {
      return true;
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      float f = paramMotionEvent.getX();
      paramMotionEvent.getY();
      switch (paramMotionEvent.getAction())
      {
      default: 
        return true;
      case 0: 
        if ((this.jdField_a_of_type_Adla != null) && (!this.jdField_a_of_type_Adla.a())) {
          this.jdField_a_of_type_Adla.a();
        }
        this.jdField_c_of_type_Float = f;
        this.jdField_a_of_type_Boolean = false;
        this.e = getScrollX();
        return true;
      case 2: 
        scrollBy((int)(this.jdField_c_of_type_Float - f), 0);
        this.jdField_c_of_type_Float = f;
        this.jdField_a_of_type_Boolean = false;
        l = System.currentTimeMillis();
      }
    } while ((this.jdField_a_of_type_MqqOsMqqHandler == null) || (l - this.jdField_a_of_type_Long <= 50L));
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65539);
    int i = this.jdField_a_of_type_Int - getWidth();
    if (getScrollX() > i) {}
    for (;;)
    {
      if (i > 0) {
        j = i;
      }
      paramMotionEvent = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(65539, j, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramMotionEvent);
      return true;
      i = getScrollX();
    }
    paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
    paramMotionEvent.computeCurrentVelocity(1000);
    int k = (int)paramMotionEvent.getXVelocity();
    boolean bool;
    if (getChildCount() > 0)
    {
      if (Math.abs(k) <= 1000) {
        break label473;
      }
      j = this.jdField_a_of_type_Adla.a(k);
      i = j;
      if (k > 0) {
        i = -j;
      }
      i = Math.round((i + getScrollX()) / this.jdField_b_of_type_Int);
      j = this.jdField_b_of_type_Int;
      paramMotionEvent = this.jdField_a_of_type_Adla;
      if (k >= 0) {
        break label436;
      }
      bool = true;
      i = paramMotionEvent.a(bool, Math.abs(j * i - getScrollX()));
      if (i >= 0) {
        break label442;
      }
      this.jdField_a_of_type_Adla.a(getScrollX(), getScrollY(), -i, 0, 0, this.jdField_a_of_type_Int - getWidth(), 0, 0);
      label401:
      postInvalidate();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      }
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = true;
      return true;
      label436:
      bool = false;
      break;
      label442:
      this.jdField_a_of_type_Adla.a(getScrollX(), getScrollY(), -i, 0, 0, this.jdField_a_of_type_Adla.a(), 0, 0);
      break label401;
      label473:
      i = getScrollX();
      j = Math.max(Math.min(Math.round((i + 0.1F) / this.jdField_b_of_type_Int) * this.jdField_b_of_type_Int, this.jdField_a_of_type_Int - getWidth()), 0);
      this.jdField_a_of_type_Adla.a(i, getScrollY(), j - i, 0);
      postInvalidate();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoFitScrollView
 * JD-Core Version:    0.7.0.1
 */