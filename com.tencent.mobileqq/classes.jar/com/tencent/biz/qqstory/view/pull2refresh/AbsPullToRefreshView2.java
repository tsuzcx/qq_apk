package com.tencent.biz.qqstory.view.pull2refresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;

public abstract class AbsPullToRefreshView2
  extends LinearLayout
  implements Handler.Callback
{
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private PullToRefreshListener jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshPullToRefreshListener;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private int c;
  private int d;
  private int e = 10;
  private int f;
  
  public AbsPullToRefreshView2(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public AbsPullToRefreshView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  @TargetApi(11)
  public AbsPullToRefreshView2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    a("moveHeaderTo:" + paramInt1 + ",duration=" + paramInt2 + ",getHeaderCurPos()=" + b());
    if (paramInt1 == b()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramInt1, paramInt2));
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    b(paramView);
    this.c = a();
    this.jdField_b_of_type_Int = paramView.getMeasuredHeight();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.jdField_b_of_type_Int);
    localLayoutParams.topMargin = (-this.jdField_b_of_type_Int);
    super.addView(paramView, localLayoutParams);
  }
  
  private void a(String paramString)
  {
    Log.d("AbsPullToRefreshView2", paramString);
  }
  
  private int b()
  {
    return ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).topMargin;
  }
  
  private void b()
  {
    super.setOrientation(1);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidViewView = a();
    this.jdField_b_of_type_AndroidViewView = b();
    this.f = UIUtils.a(getContext(), 15.0F);
    this.d = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity();
    a(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshPullToRefreshListener == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt)
          {
          default: 
            return;
          }
        } while (this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshPullToRefreshListener.a(this.jdField_a_of_type_AndroidViewView);
        return;
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshPullToRefreshListener.a(this.jdField_a_of_type_AndroidViewView);
      return;
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshPullToRefreshListener.b(this.jdField_a_of_type_AndroidViewView);
    return;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshPullToRefreshListener.a(this.jdField_a_of_type_AndroidViewView, false);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0), 1000L);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    return;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshPullToRefreshListener.a(this.jdField_a_of_type_AndroidViewView, true);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0), 1000L);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
  }
  
  private void b(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    int j = ViewGroup.getChildMeasureSpec(0, 0, localLayoutParams1.width);
    int i = localLayoutParams1.height;
    if (i > 0) {}
    for (i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
  }
  
  private void c(int paramInt)
  {
    a("moveHeaderSmoothlyBy dy=" + paramInt);
    if (Math.abs(paramInt) > this.f * 2) {
      return;
    }
    d(paramInt);
  }
  
  private void c(boolean paramBoolean)
  {
    b(paramBoolean);
    getParent().requestDisallowInterceptTouchEvent(true);
  }
  
  private void d(int paramInt)
  {
    a("moveHeaderBy dy=" + paramInt);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.topMargin -= paramInt;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    invalidate();
  }
  
  protected int a()
  {
    return UIUtils.a(getContext(), 60.0F);
  }
  
  protected abstract View a();
  
  public void a()
  {
    if (a())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      a(this.c / 2 - this.jdField_b_of_type_Int, 100);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3), 100L);
    }
    while (!b()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    a(-this.jdField_b_of_type_Int - this.c, 100);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3), 100L);
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    a("change to state:" + paramInt);
    this.jdField_a_of_type_Int = paramInt;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      b(this.jdField_a_of_type_Int);
      return;
      a(-this.jdField_b_of_type_Int, 200);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      continue;
      a(this.c - this.jdField_b_of_type_Int, 200);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(2);
      return;
    }
    a(3);
  }
  
  protected abstract boolean a();
  
  protected abstract View b();
  
  protected abstract void b(boolean paramBoolean);
  
  protected abstract boolean b();
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      a("dispatchTouchEvent: ------down------ getY=" + paramMotionEvent.getY());
      c(false);
      c();
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      continue;
      float f1 = this.jdField_a_of_type_Float - paramMotionEvent.getY();
      int i = b();
      a("dispatchTouchEvent: move getY=" + paramMotionEvent.getY() + ",isScroll2Top()()=" + a() + ",mHeaderHeight=" + this.jdField_b_of_type_Int + ",currentHeaderPos=" + i + ",dy=" + f1);
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      if ((a()) && (f1 < 0.0F))
      {
        c((int)f1 / 2);
        c(true);
      }
      for (;;)
      {
        i = b();
        if (i <= this.c - this.jdField_b_of_type_Int) {
          break label403;
        }
        a(4);
        break;
        float f2;
        if (i > -this.jdField_b_of_type_Int)
        {
          if (paramMotionEvent.getPointerCount() > 1)
          {
            c(true);
          }
          else if (Math.abs(f1) > 0.0F)
          {
            f2 = f1;
            if (i - f1 < -this.jdField_b_of_type_Int) {
              f2 = this.jdField_b_of_type_Int + i;
            }
            c((int)f2);
            c(true);
          }
        }
        else if (i < -this.jdField_b_of_type_Int)
        {
          if (paramMotionEvent.getPointerCount() > 1)
          {
            c(true);
          }
          else if (Math.abs(f1) > 0.0F)
          {
            f2 = f1;
            if (i - f1 > -this.jdField_b_of_type_Int) {
              f2 = this.jdField_b_of_type_Int + i;
            }
            c((int)f2);
            c(true);
          }
        }
        else {
          c(false);
        }
      }
      label403:
      if (i > -this.jdField_b_of_type_Int)
      {
        a(5);
      }
      else if (i < -this.jdField_b_of_type_Int)
      {
        a(6);
        continue;
        a("dispatchTouchEvent: *******up****** mState=" + this.jdField_a_of_type_Int);
        getParent().requestDisallowInterceptTouchEvent(false);
        this.jdField_a_of_type_Float = -1.0F;
        if (this.jdField_a_of_type_Int == 4) {
          a(1);
        } else if (this.jdField_a_of_type_Int == 5) {
          a(0);
        } else if (this.jdField_a_of_type_Int == 6) {
          a(0);
        } else if (b() != -this.jdField_b_of_type_Int) {
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3));
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    int k;
    int j;
    do
    {
      return true;
      a(0);
      return true;
      a(-this.jdField_b_of_type_Int, 100);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      return true;
      a(3);
      return true;
      i = paramMessage.arg1;
      k = paramMessage.arg2;
      j = (i - b()) * this.e / k;
      k -= this.e;
    } while (j == 0);
    if (k <= 0)
    {
      d(b() - i);
      return true;
    }
    d(-j);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, i, k), this.e);
    return true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void setPullToRefreshListener(PullToRefreshListener paramPullToRefreshListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshPullToRefreshListener = paramPullToRefreshListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.pull2refresh.AbsPullToRefreshView2
 * JD-Core Version:    0.7.0.1
 */