package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import uxb;
import vvv;
import vvw;
import vvx;

public class QCircleDoubleClickLayout
  extends FrameLayout
{
  private int jdField_a_of_type_Int = uxb.jdField_a_of_type_Int;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private Runnable jdField_a_of_type_JavaLangRunnable = new QCircleDoubleClickLayout.1(this);
  private vvv jdField_a_of_type_Vvv;
  private vvw jdField_a_of_type_Vvw;
  private vvx jdField_a_of_type_Vvx;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  private Runnable jdField_b_of_type_JavaLangRunnable = new QCircleDoubleClickLayout.2(this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private MotionEvent jdField_c_of_type_AndroidViewMotionEvent;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private MotionEvent jdField_d_of_type_AndroidViewMotionEvent;
  private int jdField_e_of_type_Int;
  private MotionEvent jdField_e_of_type_AndroidViewMotionEvent;
  
  public QCircleDoubleClickLayout(@android.support.annotation.NonNull @androidx.annotation.NonNull Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public QCircleDoubleClickLayout(@android.support.annotation.NonNull @androidx.annotation.NonNull Context paramContext, @android.support.annotation.Nullable @androidx.annotation.Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public QCircleDoubleClickLayout(@android.support.annotation.NonNull @androidx.annotation.NonNull Context paramContext, @android.support.annotation.Nullable @androidx.annotation.Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null) {
      super.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, paramMotionEvent.getX(), paramMotionEvent.getY(), 0));
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    int i;
    int j;
    do
    {
      return false;
      i = (int)paramMotionEvent2.getX() - (int)paramMotionEvent1.getX();
      j = (int)paramMotionEvent2.getY() - (int)paramMotionEvent1.getY();
    } while (i * i + j * j <= this.jdField_d_of_type_Int);
    return true;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
      } while ((paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > this.jdField_a_of_type_Int) || (a(paramMotionEvent1, paramMotionEvent2)));
      i = (int)paramMotionEvent1.getX() - (int)paramMotionEvent3.getX();
      j = (int)paramMotionEvent1.getY() - (int)paramMotionEvent3.getY();
    } while (i * i + j * j >= this.jdField_c_of_type_Int);
    return true;
  }
  
  private void b()
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.jdField_b_of_type_Int = localViewConfiguration.getScaledDoubleTapSlop();
    this.jdField_c_of_type_Int = (this.jdField_b_of_type_Int * this.jdField_b_of_type_Int);
    int i = localViewConfiguration.getScaledTouchSlop();
    this.jdField_d_of_type_Int = (localViewConfiguration.getScaledTouchSlop() * i);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null) {
      super.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, paramMotionEvent.getX(), paramMotionEvent.getY(), 0));
    }
  }
  
  private boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    while (a(paramMotionEvent1, paramMotionEvent2)) {
      return false;
    }
    return true;
  }
  
  private void c()
  {
    if (b(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent))
    {
      a(this.jdField_a_of_type_AndroidViewMotionEvent);
      b(this.jdField_b_of_type_AndroidViewMotionEvent);
      if (this.jdField_a_of_type_Vvx != null) {
        this.jdField_a_of_type_Vvx.a();
      }
      QLog.d("QCircleDoubleClickLayout", 1, "singleTap success");
      return;
    }
    QLog.d("QCircleDoubleClickLayout", 1, "singleTap error");
  }
  
  private void d()
  {
    if (this.jdField_e_of_type_AndroidViewMotionEvent != null)
    {
      a(this.jdField_e_of_type_AndroidViewMotionEvent);
      QLog.d("QCircleDoubleClickLayout", 4, "move success");
      return;
    }
    QLog.d("QCircleDoubleClickLayout", 4, "move error");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewMotionEvent = null;
    this.jdField_b_of_type_AndroidViewMotionEvent = null;
    this.jdField_c_of_type_AndroidViewMotionEvent = null;
    this.jdField_d_of_type_AndroidViewMotionEvent = null;
    this.jdField_e_of_type_AndroidViewMotionEvent = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("QCircleDoubleClickLayout", 4, "not intercept");
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return bool;
      QLog.d("QCircleDoubleClickLayout", 4, "event:" + paramMotionEvent.getAction() + " mIsRunnablePosting:" + this.jdField_b_of_type_Boolean);
      if (paramMotionEvent.getAction() == 0)
      {
        if (this.jdField_a_of_type_AndroidViewMotionEvent == null)
        {
          this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
          this.jdField_e_of_type_Int = 1;
          QLog.d("QCircleDoubleClickLayout", 4, "firstdown clickcount:" + this.jdField_e_of_type_Int);
        }
        if ((this.jdField_e_of_type_Int >= 1) && (a(this.jdField_c_of_type_AndroidViewMotionEvent, this.jdField_d_of_type_AndroidViewMotionEvent, paramMotionEvent)))
        {
          this.jdField_e_of_type_Int += 1;
          QLog.d("QCircleDoubleClickLayout", 4, "considerdown clickcount:" + this.jdField_e_of_type_Int);
        }
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, uxb.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, uxb.jdField_b_of_type_Int);
          this.jdField_b_of_type_Boolean = true;
        }
        if (this.jdField_c_of_type_AndroidViewMotionEvent != null) {
          this.jdField_c_of_type_AndroidViewMotionEvent.recycle();
        }
        this.jdField_c_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
      }
      while (!this.jdField_b_of_type_Boolean)
      {
        return super.dispatchTouchEvent(paramMotionEvent);
        if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
          if (this.jdField_c_of_type_Boolean)
          {
            this.jdField_c_of_type_Boolean = false;
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          if (this.jdField_b_of_type_AndroidViewMotionEvent == null) {
            this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
          }
          if (this.jdField_d_of_type_AndroidViewMotionEvent != null) {
            this.jdField_d_of_type_AndroidViewMotionEvent.recycle();
          }
          this.jdField_d_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        }
        else if (paramMotionEvent.getAction() == 2)
        {
          if (this.jdField_e_of_type_AndroidViewMotionEvent != null) {
            this.jdField_e_of_type_AndroidViewMotionEvent.recycle();
          }
          this.jdField_e_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
          if (a(this.jdField_c_of_type_AndroidViewMotionEvent, this.jdField_e_of_type_AndroidViewMotionEvent))
          {
            this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
            d();
            a();
            this.jdField_c_of_type_Boolean = true;
          }
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setEnableDoubleClick(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnDoubleClickListener(vvv paramvvv)
  {
    this.jdField_a_of_type_Vvv = paramvvv;
  }
  
  public void setOnLongClickListener(vvw paramvvw)
  {
    this.jdField_a_of_type_Vvw = paramvvw;
  }
  
  public void setOnTapClickListener(vvx paramvvx)
  {
    this.jdField_a_of_type_Vvx = paramvvx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout
 * JD-Core Version:    0.7.0.1
 */