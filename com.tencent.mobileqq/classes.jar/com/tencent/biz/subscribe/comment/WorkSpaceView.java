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

public class WorkSpaceView
  extends FrameLayout
{
  private static final double jdField_a_of_type_Double = Math.tan(Math.toRadians(30.0D));
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private Scroller jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
  private WorkSpaceView.OnScreenChangeListener jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView$OnScreenChangeListener;
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
    int i = Math.min(paramInt, getChildCount() - 1);
    paramInt = 0;
    i = Math.max(0, i);
    if (i != this.jdField_a_of_type_Int) {
      paramInt = 1;
    }
    this.jdField_b_of_type_Int = i;
    Object localObject = getFocusedChild();
    if ((localObject != null) && (paramInt != 0) && (localObject == getChildAt(this.jdField_a_of_type_Int))) {
      ((View)localObject).clearFocus();
    }
    paramInt = getWidth() * i - getScrollX();
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(paramInt) * 2);
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView$OnScreenChangeListener;
    if (localObject != null) {
      ((WorkSpaceView.OnScreenChangeListener)localObject).a(i);
    }
    invalidate();
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
      return;
    }
    int i = this.jdField_b_of_type_Int;
    if (i != -1)
    {
      this.jdField_a_of_type_Int = Math.max(0, Math.min(i, getChildCount() - 1));
      this.jdField_b_of_type_Int = -1;
    }
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
    boolean bool = false;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label233;
          }
        }
        else
        {
          int k = (int)Math.abs(f1 - this.jdField_a_of_type_Float);
          int m = (int)Math.abs(f2 - this.jdField_b_of_type_Float);
          int j = this.d;
          if (k > j) {
            i = 1;
          } else {
            i = 0;
          }
          if (m > j) {
            j = 1;
          } else {
            j = 0;
          }
          double d1 = m;
          double d2 = k;
          Double.isNaN(d1);
          Double.isNaN(d2);
          d1 /= d2;
          if (((i == 0) && (j == 0)) || (d1 >= jdField_a_of_type_Double)) {
            break label233;
          }
          if (i != 0) {
            this.c = 1;
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label233;
          }
          this.jdField_a_of_type_Boolean = false;
          getChildAt(this.jdField_a_of_type_Int).cancelLongPress();
          break label233;
        }
      }
      this.c = 0;
      this.jdField_a_of_type_Boolean = false;
    }
    else
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_a_of_type_Boolean = true;
      this.c = (this.jdField_a_of_type_AndroidWidgetScroller.isFinished() ^ true);
    }
    label233:
    if (this.c != 0) {
      bool = true;
    }
    return bool;
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
        paramInt3 = getMeasuredWidth() + paramInt2;
        localView.layout(paramInt2, 0, paramInt3, getMeasuredHeight());
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
    if (i != 0)
    {
      int j;
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
        }
        else
        {
          if (this.c != 1) {
            break label310;
          }
          i = (int)(this.jdField_a_of_type_Float - f);
          this.jdField_a_of_type_Float = f;
          j = getScrollX();
          if (i < 0)
          {
            if (j <= 0) {
              break label310;
            }
            scrollBy(Math.max(-j, i), 0);
            return true;
          }
          if (i <= 0) {
            break label310;
          }
          j = getChildAt(getChildCount() - 1).getRight() - j - getWidth();
          if (j > 0) {
            scrollBy(Math.min(j, i), 0);
          }
          paramMotionEvent = Message.obtain();
          paramMotionEvent.what = 0;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMotionEvent);
          return true;
        }
      }
      if (this.c == 1)
      {
        paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
        paramMotionEvent.computeCurrentVelocity(1000);
        i = (int)paramMotionEvent.getXVelocity();
        if (i > 500)
        {
          j = this.jdField_a_of_type_Int;
          if (j > 0)
          {
            a(j - 1);
            break label258;
          }
        }
        if ((i < -500) && (this.jdField_a_of_type_Int < getChildCount() - 1)) {
          a(this.jdField_a_of_type_Int + 1);
        } else {
          a();
        }
        label258:
        paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
      }
      this.c = 0;
      return true;
    }
    else
    {
      if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
        this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      }
      this.jdField_a_of_type_Float = f;
      this.c = 1;
    }
    label310:
    return true;
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
  
  public void setOnScreenChangeListener(WorkSpaceView.OnScreenChangeListener paramOnScreenChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView$OnScreenChangeListener = paramOnScreenChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.WorkSpaceView
 * JD-Core Version:    0.7.0.1
 */