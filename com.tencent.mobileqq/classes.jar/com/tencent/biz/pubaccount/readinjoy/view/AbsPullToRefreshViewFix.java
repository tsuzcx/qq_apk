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
import biez;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.qphone.base.util.QLog;
import sgm;
import sgr;
import xsm;

public abstract class AbsPullToRefreshViewFix
  extends LinearLayout
  implements Handler.Callback
{
  private float jdField_a_of_type_Float = -1.0F;
  protected int a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected View a;
  private biez jdField_a_of_type_Biez;
  protected sgm a;
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
    b();
  }
  
  public AbsPullToRefreshViewFix(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  @TargetApi(11)
  public AbsPullToRefreshViewFix(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    this.g = xsm.a(getContext(), 15.0F);
    this.e = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity();
    a(this.jdField_a_of_type_AndroidViewView);
    setWillNotDraw(false);
    this.jdField_a_of_type_Int = (ViewConfiguration.get(getContext()).getScaledTouchSlop() / 8);
  }
  
  private void b(int paramInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_Biez == null) {}
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
    this.jdField_a_of_type_Biez.a(this.jdField_a_of_type_AndroidViewView);
    return;
    paramInt = 100 - Math.abs((int)(b() * 1.0F / -this.jdField_c_of_type_Int * 100.0F));
    if (paramInt < 0) {
      paramInt = i;
    }
    while (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Biez.a(this.jdField_a_of_type_AndroidViewView, paramInt);
      return;
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Biez.a(this.jdField_a_of_type_AndroidViewView);
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Biez.a(this.jdField_a_of_type_AndroidViewView, false);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0), 1000L);
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Biez.a(this.jdField_a_of_type_AndroidViewView, true);
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
  
  protected int a()
  {
    return xsm.a(getContext(), 60.0F);
  }
  
  protected abstract View a();
  
  protected sgm a()
  {
    return a(0);
  }
  
  public sgm a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsPullToRefreshView2", 1, "setAnimType animType = " + paramInt);
    }
    if ((this.jdField_a_of_type_Sgm != null) && ((this.jdField_a_of_type_Sgm instanceof ReadInJoySkinAnimManager))) {
      this.jdField_a_of_type_Sgm.d();
    }
    this.jdField_a_of_type_Sgm = sgr.a(getContext(), paramInt);
    return this.jdField_a_of_type_Sgm;
  }
  
  public void a()
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
  
  protected void a(biez parambiez)
  {
    this.jdField_a_of_type_Biez = parambiez;
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
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      a("dispatchTouchEvent: ------down------ getY=" + paramMotionEvent.getY());
      c();
      this.jdField_b_of_type_Float = paramMotionEvent.getX();
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Boolean = false;
      a(false);
      this.jdField_c_of_type_Boolean = false;
      if (a(paramMotionEvent))
      {
        this.jdField_d_of_type_Boolean = true;
      }
      else
      {
        this.jdField_d_of_type_Boolean = false;
        continue;
        float f2 = this.jdField_b_of_type_Float - paramMotionEvent.getX();
        float f1 = this.jdField_a_of_type_Float - paramMotionEvent.getY();
        if (!this.jdField_c_of_type_Boolean)
        {
          if ((Math.abs(f2) <= this.jdField_a_of_type_Int) && (Math.abs(f1) <= this.jdField_a_of_type_Int)) {
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          this.jdField_c_of_type_Boolean = true;
        }
        int i = b();
        a("dispatchTouchEvent: move getY=" + paramMotionEvent.getY() + ",isScroll2Top()()=" + a() + ",mHeaderHeight=" + this.jdField_c_of_type_Int + ",currentHeaderPos=" + i + ",dy=" + f1 + ",dx=" + f2);
        this.jdField_b_of_type_Float = paramMotionEvent.getX();
        this.jdField_a_of_type_Float = paramMotionEvent.getY();
        if ((Math.abs(f2) >= this.jdField_a_of_type_Int) || (Math.abs(f1) >= this.jdField_a_of_type_Int))
        {
          if (Math.abs(f1) - Math.abs(f2) <= 0.0F)
          {
            if (this.jdField_d_of_type_Boolean)
            {
              if (this.jdField_b_of_type_Boolean)
              {
                a(true);
                getParent().requestDisallowInterceptTouchEvent(true);
                return super.dispatchTouchEvent(paramMotionEvent);
              }
              if (Math.abs(f2) / Math.abs(f1) >= 2.0F)
              {
                boolean bool = super.dispatchTouchEvent(paramMotionEvent);
                if (!bool)
                {
                  getParent().requestDisallowInterceptTouchEvent(false);
                  return bool;
                }
                this.jdField_b_of_type_Boolean = true;
                a(true);
                getParent().requestDisallowInterceptTouchEvent(true);
                return bool;
              }
            }
            else
            {
              if (!this.jdField_b_of_type_Boolean)
              {
                getParent().requestDisallowInterceptTouchEvent(false);
                continue;
              }
              return true;
            }
          }
          else if (this.jdField_b_of_type_Boolean) {
            return true;
          }
          if ((a()) && (f1 < 0.0F))
          {
            c((int)f1 / 2);
            d(true);
          }
          for (;;)
          {
            i = b();
            if (i <= this.jdField_d_of_type_Int - this.jdField_c_of_type_Int) {
              break label674;
            }
            a(4);
            break;
            if (i > -this.jdField_c_of_type_Int)
            {
              if (paramMotionEvent.getPointerCount() > 1)
              {
                d(true);
              }
              else if (Math.abs(f1) > 0.0F)
              {
                f2 = f1;
                if (i - f1 < -this.jdField_c_of_type_Int) {
                  f2 = this.jdField_c_of_type_Int + i;
                }
                c((int)f2);
                d(true);
              }
            }
            else if (i < -this.jdField_c_of_type_Int) {
              if (paramMotionEvent.getPointerCount() > 1)
              {
                d(true);
              }
              else if (Math.abs(f1) > 0.0F)
              {
                f2 = f1;
                if (i - f1 > -this.jdField_c_of_type_Int) {
                  f2 = this.jdField_c_of_type_Int + i;
                }
                c((int)f2);
                d(true);
              }
            }
          }
          label674:
          if (i > -this.jdField_c_of_type_Int)
          {
            a(5);
          }
          else if (i < -this.jdField_c_of_type_Int)
          {
            a(6);
            continue;
            this.jdField_b_of_type_Boolean = false;
            a(false);
            this.jdField_c_of_type_Boolean = false;
            this.jdField_d_of_type_Boolean = false;
            a("dispatchTouchEvent: *******up****** mState=" + this.jdField_b_of_type_Int);
            getParent().requestDisallowInterceptTouchEvent(false);
            this.jdField_a_of_type_Float = -1.0F;
            this.jdField_b_of_type_Float = -1.0F;
            if (this.jdField_b_of_type_Int == 4) {
              a(1);
            } else if (this.jdField_b_of_type_Int == 5) {
              a(0);
            } else if (this.jdField_b_of_type_Int == 6) {
              a(0);
            } else if (b() != -this.jdField_c_of_type_Int) {
              this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3));
            }
          }
        }
      }
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
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  protected void onDraw(Canvas paramCanvas)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.AbsPullToRefreshViewFix
 * JD-Core Version:    0.7.0.1
 */