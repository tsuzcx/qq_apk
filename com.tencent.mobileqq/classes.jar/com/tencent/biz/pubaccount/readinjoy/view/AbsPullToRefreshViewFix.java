package com.tencent.biz.pubaccount.readinjoy.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
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
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimBaseManager;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyRefreshAnimFactory;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.PullToRefreshListener;
import org.jetbrains.annotations.Nullable;

public abstract class AbsPullToRefreshViewFix
  extends LinearLayout
  implements Handler.Callback
{
  private float jdField_a_of_type_Float = -1.0F;
  protected int a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected View a;
  protected ReadInJoyAnimBaseManager a;
  private PullToRefreshListener jdField_a_of_type_ComTencentWidgetPull2refreshPullToRefreshListener;
  protected boolean a;
  private float jdField_b_of_type_Float = -1.0F;
  private int jdField_b_of_type_Int = 0;
  protected View b;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean;
  private int e;
  private int f = 10;
  private int g;
  
  public AbsPullToRefreshViewFix(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    b();
  }
  
  public AbsPullToRefreshViewFix(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    b();
  }
  
  @TargetApi(11)
  public AbsPullToRefreshViewFix(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    b();
  }
  
  private float a(int paramInt, float paramFloat)
  {
    float f1;
    if (paramInt > -this.jdField_c_of_type_Int)
    {
      f1 = paramFloat;
      if (paramInt - paramFloat < -this.jdField_c_of_type_Int) {
        f1 = this.jdField_c_of_type_Int + paramInt;
      }
    }
    do
    {
      do
      {
        return f1;
        f1 = paramFloat;
      } while (paramInt >= -this.jdField_c_of_type_Int);
      f1 = paramFloat;
    } while (paramInt - paramFloat <= -this.jdField_c_of_type_Int);
    return this.jdField_c_of_type_Int + paramInt;
  }
  
  @Nullable
  private Boolean a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      a(true);
      getParent().requestDisallowInterceptTouchEvent(true);
      return Boolean.valueOf(super.dispatchTouchEvent(paramMotionEvent));
    }
    if (Math.abs(paramFloat1) / Math.abs(paramFloat2) >= 2.0F)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      if (!bool) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
      for (;;)
      {
        return Boolean.valueOf(bool);
        this.jdField_b_of_type_Boolean = true;
        a(true);
        getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
    return null;
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
  
  private void a(MotionEvent paramMotionEvent, float paramFloat, int paramInt)
  {
    if ((a()) && (paramFloat < 0.0F))
    {
      c((int)paramFloat / 2);
      d(true);
    }
    do
    {
      return;
      if (paramMotionEvent.getPointerCount() > 1)
      {
        d(true);
        return;
      }
    } while (Math.abs(paramFloat) <= 0.0F);
    c((int)a(paramInt, paramFloat));
    d(true);
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    b(paramView);
    this.jdField_d_of_type_Int = a();
    this.jdField_c_of_type_Int = paramView.getMeasuredHeight();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.jdField_c_of_type_Int);
    localLayoutParams.topMargin = (-this.jdField_c_of_type_Int);
    super.addView(paramView, localLayoutParams);
  }
  
  private void a(String paramString)
  {
    Log.d("AbsPullToRefreshView2", paramString);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat2) - Math.abs(paramFloat1) <= 0.0F;
  }
  
  private int b()
  {
    return ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).topMargin;
  }
  
  private void b()
  {
    a();
    super.setOrientation(1);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidViewView = a();
    this.jdField_b_of_type_AndroidViewView = b();
    this.g = UIUtils.a(getContext(), 15.0F);
    this.e = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity();
    a(this.jdField_a_of_type_AndroidViewView);
    setWillNotDraw(false);
    this.jdField_a_of_type_Int = (ViewConfiguration.get(getContext()).getScaledTouchSlop() / 8);
  }
  
  private void b(int paramInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshPullToRefreshListener == null) {}
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
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPullToRefreshListener.a(this.jdField_a_of_type_AndroidViewView);
    return;
    paramInt = 100 - Math.abs((int)(b() * 1.0F / -this.jdField_c_of_type_Int * 100.0F));
    if (paramInt < 0) {
      paramInt = i;
    }
    while (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshPullToRefreshListener.a(this.jdField_a_of_type_AndroidViewView, paramInt);
      return;
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetPull2refreshPullToRefreshListener.a(this.jdField_a_of_type_AndroidViewView);
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentWidgetPull2refreshPullToRefreshListener.a(this.jdField_a_of_type_AndroidViewView, false);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0), 1000L);
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentWidgetPull2refreshPullToRefreshListener.a(this.jdField_a_of_type_AndroidViewView, true);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0), 0L);
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      return;
    }
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
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    return (Math.abs(paramFloat1) >= this.jdField_a_of_type_Int) || (Math.abs(paramFloat2) >= this.jdField_a_of_type_Int);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
  }
  
  private void c(int paramInt)
  {
    a("moveHeaderSmoothlyBy dy=" + paramInt);
    if (Math.abs(paramInt) > this.g * 2) {
      return;
    }
    d(paramInt);
  }
  
  private boolean c()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      getParent().requestDisallowInterceptTouchEvent(false);
      return false;
    }
    return true;
  }
  
  private void d()
  {
    int i = b();
    if (i > this.jdField_d_of_type_Int - this.jdField_c_of_type_Int) {
      a(4);
    }
    do
    {
      return;
      if (i > -this.jdField_c_of_type_Int)
      {
        a(5);
        return;
      }
    } while (i >= -this.jdField_c_of_type_Int);
    a(6);
  }
  
  private void d(int paramInt)
  {
    a("moveHeaderBy dy=" + paramInt);
    if (paramInt == 0) {
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.topMargin -= paramInt;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    invalidate();
  }
  
  private void d(boolean paramBoolean)
  {
    c(paramBoolean);
    getParent().requestDisallowInterceptTouchEvent(true);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Int == 4) {
      a(1);
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Int == 5)
      {
        a(0);
        return;
      }
      if (this.jdField_b_of_type_Int == 6)
      {
        a(0);
        return;
      }
    } while (b() == -this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3));
  }
  
  protected int a()
  {
    return UIUtils.a(getContext(), 60.0F);
  }
  
  protected abstract View a();
  
  protected ReadInJoyAnimBaseManager a()
  {
    return a(0);
  }
  
  public ReadInJoyAnimBaseManager a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsPullToRefreshView2", 1, "setAnimType animType = " + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager instanceof ReadInJoySkinAnimManager))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.d();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager = ReadInJoyRefreshAnimFactory.a(getContext(), paramInt);
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager;
  }
  
  protected void a()
  {
    if (a())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      a(this.jdField_d_of_type_Int / 2 - this.jdField_c_of_type_Int, 100);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3), 100L);
    }
    while (!b()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    a(-this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, 100);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3), 100L);
  }
  
  protected void a(int paramInt)
  {
    if ((this.jdField_b_of_type_Int == paramInt) && (paramInt != 5)) {
      return;
    }
    a("change to state:" + paramInt);
    this.jdField_b_of_type_Int = paramInt;
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      b(this.jdField_b_of_type_Int);
      return;
      a(-this.jdField_c_of_type_Int, 200);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      continue;
      a(this.jdField_d_of_type_Int - this.jdField_c_of_type_Int, 200);
    }
  }
  
  protected void a(PullToRefreshListener paramPullToRefreshListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPullToRefreshListener = paramPullToRefreshListener;
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected abstract boolean a();
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected abstract View b();
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(2);
      return;
    }
    a(3);
  }
  
  protected abstract boolean b();
  
  protected abstract void c(boolean paramBoolean);
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      float f2;
      int i;
      do
      {
        return bool;
        a("dispatchTouchEvent: ------down------ getY=" + paramMotionEvent.getY());
        c();
        this.jdField_b_of_type_Float = paramMotionEvent.getX();
        this.jdField_a_of_type_Float = paramMotionEvent.getY();
        this.jdField_b_of_type_Boolean = false;
        a(false);
        this.jdField_c_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = a(paramMotionEvent);
        break;
        float f1 = this.jdField_b_of_type_Float - paramMotionEvent.getX();
        f2 = this.jdField_a_of_type_Float - paramMotionEvent.getY();
        if (!this.jdField_c_of_type_Boolean)
        {
          if ((Math.abs(f1) <= this.jdField_a_of_type_Int) && (Math.abs(f2) <= this.jdField_a_of_type_Int)) {
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          this.jdField_c_of_type_Boolean = true;
        }
        i = b();
        a("dispatchTouchEvent: move getY=" + paramMotionEvent.getY() + ",isScroll2Top()()=" + a() + ",mHeaderHeight=" + this.jdField_c_of_type_Int + ",currentHeaderPos=" + i + ",dy=" + f2 + ",dx=" + f1);
        this.jdField_b_of_type_Float = paramMotionEvent.getX();
        this.jdField_a_of_type_Float = paramMotionEvent.getY();
        if (!b(f1, f2)) {
          break;
        }
        if (a(f1, f2))
        {
          if (this.jdField_d_of_type_Boolean)
          {
            Boolean localBoolean = a(paramMotionEvent, f1, f2);
            if (localBoolean == null) {
              break label355;
            }
            return localBoolean.booleanValue();
          }
          if (!c()) {
            break;
          }
          return true;
        }
      } while (this.jdField_b_of_type_Boolean);
      label355:
      a(paramMotionEvent, f2, i);
      d();
      continue;
      this.jdField_b_of_type_Boolean = false;
      a(false);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      a("dispatchTouchEvent: *******up****** mState=" + this.jdField_b_of_type_Int);
      getParent().requestDisallowInterceptTouchEvent(false);
      this.jdField_a_of_type_Float = -1.0F;
      this.jdField_b_of_type_Float = -1.0F;
      e();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 0: 
      a(0);
      return true;
    case 3: 
      a(-this.jdField_c_of_type_Int, 100);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      return true;
    case 2: 
      a(3);
      return true;
    }
    int i = paramMessage.arg1;
    int k = paramMessage.arg2;
    int j = (i - b()) * this.f / k;
    k -= this.f;
    if ((k <= 0) || ((j == 0) && (b() - i > 0)))
    {
      d(b() - i);
      return true;
    }
    d(-j);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, i, k), this.f);
    return true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i = b() + this.jdField_c_of_type_Int;
    if ((i > 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, getWidth(), i);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setPullHeaderBgDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.AbsPullToRefreshViewFix
 * JD-Core Version:    0.7.0.1
 */