package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.Scroller;
import ydl;

public class WorkSpaceView
  extends FrameLayout
{
  private static final double jdField_a_of_type_Double = Math.tan(Math.toRadians(30.0D));
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private Scroller jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
  private ydl jdField_a_of_type_Ydl;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  private int c = 0;
  private int d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  
  public WorkSpaceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WorkSpaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WorkSpaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    int i = getWidth();
    a((getScrollX() + i / 2) / i);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      return;
    }
    b(paramInt);
  }
  
  public void b(int paramInt)
  {
    int i = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (i != this.jdField_a_of_type_Int) {}
    for (paramInt = 1;; paramInt = 0)
    {
      this.jdField_b_of_type_Int = i;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt != 0) && (localView == getChildAt(this.jdField_a_of_type_Int))) {
        localView.clearFocus();
      }
      paramInt = getWidth() * i - getScrollX();
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(paramInt) * 2);
      if (this.jdField_a_of_type_Ydl != null) {
        this.jdField_a_of_type_Ydl.a(i);
      }
      invalidate();
      return;
    }
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
    while (this.jdField_b_of_type_Int == -1) {
      return;
    }
    this.jdField_a_of_type_Int = Math.max(0, Math.min(this.jdField_b_of_type_Int, getChildCount() - 1));
    this.jdField_b_of_type_Int = -1;
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (paramInt == 17)
    {
      if (a() > 0)
      {
        a(a() - 1);
        return true;
      }
    }
    else if ((paramInt == 66) && (a() < getChildCount() - 1))
    {
      a(a() + 1);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    while (this.c != 0)
    {
      return true;
      int k = (int)Math.abs(f1 - this.jdField_a_of_type_Float);
      int m = (int)Math.abs(f2 - this.jdField_b_of_type_Float);
      int j = this.d;
      if (k > j)
      {
        i = 1;
        label103:
        if (m <= j) {
          break label181;
        }
      }
      label181:
      for (j = 1;; j = 0)
      {
        double d1 = m / k;
        if (((i == 0) && (j == 0)) || (d1 >= jdField_a_of_type_Double)) {
          break;
        }
        if (i != 0) {
          this.c = 1;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_Boolean = false;
        getChildAt(this.jdField_a_of_type_Int).cancelLongPress();
        break;
        i = 0;
        break label103;
      }
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.c = i;
        break;
      }
      this.c = 0;
      this.jdField_a_of_type_Boolean = false;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = getMeasuredWidth();
        localView.layout(paramInt2, 0, paramInt2 + paramInt3, getMeasuredHeight());
        paramInt3 = paramInt2 + paramInt3;
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).measure(paramInt1, paramInt2);
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    switch (i)
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
            return true;
            if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
              this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
            }
            this.jdField_a_of_type_Float = f;
            this.c = 1;
            return true;
          } while (this.c != 1);
          i = (int)(this.jdField_a_of_type_Float - f);
          this.jdField_a_of_type_Float = f;
          j = getScrollX();
          if (i >= 0) {
            break;
          }
        } while (j <= 0);
        scrollBy(Math.max(-j, i), 0);
        return true;
      } while (i <= 0);
      int j = getChildAt(getChildCount() - 1).getRight() - j - getWidth();
      if (j > 0) {
        scrollBy(Math.min(j, i), 0);
      }
      paramMotionEvent = Message.obtain();
      paramMotionEvent.what = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMotionEvent);
      return true;
    }
    if (this.c == 1)
    {
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000);
      i = (int)paramMotionEvent.getXVelocity();
      if ((i <= 500) || (this.jdField_a_of_type_Int <= 0)) {
        break label284;
      }
      a(this.jdField_a_of_type_Int - 1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      }
      this.c = 0;
      return true;
      label284:
      if ((i < -500) && (this.jdField_a_of_type_Int < getChildCount() - 1)) {
        a(this.jdField_a_of_type_Int + 1);
      } else {
        a();
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    paramView1 = new Rect();
    paramView2.getDrawingRect(paramView1);
    paramView2.requestRectangleOnScreen(paramView1);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return (indexOfChild(paramView) != this.jdField_a_of_type_Int) || (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished());
  }
  
  public void setAllowLongPress(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setHandler(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void setOnScreenChangeListener(ydl paramydl)
  {
    this.jdField_a_of_type_Ydl = paramydl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.WorkSpaceView
 * JD-Core Version:    0.7.0.1
 */