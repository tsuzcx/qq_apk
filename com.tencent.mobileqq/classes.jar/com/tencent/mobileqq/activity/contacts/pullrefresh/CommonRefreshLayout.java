package com.tencent.mobileqq.activity.contacts.pullrefresh;

import aiqu;
import aiqv;
import aiqw;
import aiqx;
import aiqy;
import aira;
import airc;
import aird;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.R.styleable;
import com.tencent.widget.ListView;

public class CommonRefreshLayout
  extends ViewGroup
  implements aiqu
{
  private float jdField_a_of_type_Float = 0.5F;
  private int jdField_a_of_type_Int = 200;
  private aiqw jdField_a_of_type_Aiqw;
  aiqx jdField_a_of_type_Aiqx = new aiqv(this);
  private aira jdField_a_of_type_Aira;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AutoScroller jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 200;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 300;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 500;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = 500;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int;
  private int h;
  private int i;
  private int j;
  private int k = 0;
  private int l;
  
  public CommonRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommonRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommonRefreshLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RefreshLayout, paramInt, 0);
    for (;;)
    {
      try
      {
        int n = paramAttributeSet.getIndexCount();
        paramInt = m;
        if (paramInt >= n) {
          break label313;
        }
        m = paramAttributeSet.getIndex(paramInt);
        if (m == 10) {
          setRefreshEnabled(paramAttributeSet.getBoolean(m, true));
        } else if (m == 2) {
          this.jdField_a_of_type_Float = paramAttributeSet.getFloat(m, 0.5F);
        }
      }
      finally
      {
        paramAttributeSet.recycle();
      }
      if (m == 11)
      {
        this.jdField_c_of_type_Float = paramAttributeSet.getDimensionPixelOffset(m, 0);
      }
      else if (m == 12)
      {
        this.jdField_b_of_type_Float = paramAttributeSet.getDimensionPixelOffset(m, 0);
      }
      else if (m == 16)
      {
        this.jdField_a_of_type_Int = paramAttributeSet.getInt(m, 200);
      }
      else if (m == 14)
      {
        this.jdField_b_of_type_Int = paramAttributeSet.getInt(m, 200);
      }
      else if (m == 8)
      {
        setRefreshCompleteDelayDuration(paramAttributeSet.getInt(m, 300));
      }
      else if (m == 9)
      {
        this.jdField_d_of_type_Int = paramAttributeSet.getInt(m, 500);
      }
      else if (m == 1)
      {
        this.jdField_e_of_type_Int = paramAttributeSet.getInt(m, 500);
        break label362;
        label313:
        paramAttributeSet.recycle();
        this.j = ViewConfiguration.get(paramContext).getScaledTouchSlop();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller = new AutoScroller(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a(this);
        this.l = getResources().getDimensionPixelOffset(2131298826);
        return;
      }
      label362:
      paramInt += 1;
    }
  }
  
  private float a(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    if (paramInt < 0) {
      return -1.0F;
    }
    return MotionEventCompat.getY(paramMotionEvent, paramInt);
  }
  
  private void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int m = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, m) == this.jdField_f_of_type_Int) {
      if (m != 0) {
        break label33;
      }
    }
    label33:
    for (m = 1;; m = 0)
    {
      this.jdField_f_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, m);
      return;
    }
  }
  
  private float b(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    if (paramInt < 0) {
      return -1.0F;
    }
    return MotionEventCompat.getX(paramMotionEvent, paramInt);
  }
  
  private void b(float paramFloat)
  {
    if ((aiqy.a(this.k)) && (this.jdField_a_of_type_Aiqw != null) && (paramFloat > 0.0F))
    {
      a(3);
      if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      }
    }
    if (aiqy.g(this.k))
    {
      if (paramFloat < 0.0F)
      {
        a(2);
        c(paramFloat);
      }
    }
    else
    {
      if ((aiqy.h(this.k)) || (aiqy.i(this.k)))
      {
        if (paramFloat >= 0.0F) {
          break label266;
        }
        a(2);
        label103:
        c(paramFloat);
      }
      if (((aiqy.a(this.k)) || (aiqy.h(this.k))) && (paramFloat > 0.0F) && (d()))
      {
        this.jdField_a_of_type_Aiqx.a();
        a(-1);
      }
      if (aiqy.c(this.k))
      {
        if ((!aiqy.d(this.k)) && (!aiqy.e(this.k))) {
          break label282;
        }
        if (this.i < this.jdField_b_of_type_Float) {
          break label274;
        }
        a(-2);
      }
    }
    for (;;)
    {
      c(paramFloat);
      return;
      if (this.i >= this.jdField_b_of_type_Float)
      {
        a(4);
        break;
      }
      if (this.i >= (this.jdField_b_of_type_Float - this.l) / 2.0F)
      {
        a(5);
        break;
      }
      a(3);
      break;
      label266:
      a(1);
      break label103;
      label274:
      a(-1);
      continue;
      label282:
      if ((paramFloat < 0.0F) && (this.jdField_a_of_type_Aiqw != null)) {
        a(2);
      }
    }
  }
  
  private void c(float paramFloat)
  {
    float f1 = this.jdField_a_of_type_Float * paramFloat;
    float f2 = this.i + f1;
    if ((this.i <= 0) || (f2 >= 0.0F))
    {
      paramFloat = f1;
      if (this.i < 0)
      {
        paramFloat = f1;
        if (f2 <= 0.0F) {}
      }
    }
    else
    {
      paramFloat = -this.i;
    }
    f1 = paramFloat;
    if (this.jdField_c_of_type_Float > this.jdField_b_of_type_Float)
    {
      f1 = paramFloat;
      if (f2 > this.jdField_c_of_type_Float) {
        f1 = this.jdField_c_of_type_Float - this.i;
      }
    }
    if (aiqy.c(this.k))
    {
      int m = this.i;
      if (c()) {
        m = this.i - ((int)this.jdField_b_of_type_Float - this.l);
      }
      this.jdField_a_of_type_Aiqx.a(m, false, false);
    }
    d(f1);
  }
  
  private void d(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    this.i = ((int)(this.i + paramFloat));
    if ((aiqy.c(this.k)) || (aiqy.f(this.k))) {
      this.h = this.i;
    }
    g();
    requestLayout();
    invalidate();
  }
  
  private boolean d()
  {
    return (this.jdField_c_of_type_Boolean) && (!aird.a(this.jdField_a_of_type_AndroidViewView)) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Float > 0.0F);
  }
  
  private void f()
  {
    int n = getPaddingLeft();
    int m = getPaddingTop();
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localObject = this.jdField_a_of_type_AndroidViewViewGroup;
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        i1 = localMarginLayoutParams.leftMargin + n;
        int i2 = localMarginLayoutParams.topMargin + m - this.jdField_g_of_type_Int + this.h;
        ((View)localObject).layout(i1, i2, ((View)localObject).getMeasuredWidth() + i1, ((View)localObject).getMeasuredHeight() + i2);
      }
    } while (this.jdField_a_of_type_AndroidViewView == null);
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
    int i1 = n + localMarginLayoutParams.leftMargin;
    n = localMarginLayoutParams.topMargin + m + this.i;
    m = n;
    if (n < 0) {
      m = 0;
    }
    ((View)localObject).layout(i1, m, ((View)localObject).getMeasuredWidth() + i1, ((View)localObject).getMeasuredHeight() + m);
  }
  
  private void g()
  {
    int m = getPaddingTop();
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localObject = this.jdField_a_of_type_AndroidViewViewGroup;
        ((View)localObject).setTop(((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams()).topMargin + m - this.jdField_g_of_type_Int + this.h);
      }
    } while (this.jdField_a_of_type_AndroidViewView == null);
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    int n = ((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams()).topMargin + m + this.i;
    m = n;
    if (n < 0) {
      m = 0;
    }
    ((View)localObject).setTop(m);
  }
  
  private void h()
  {
    if (aiqy.b(this.k))
    {
      this.i = ((int)(this.jdField_b_of_type_Float + 0.5F));
      this.h = this.i;
      g();
      requestLayout();
      invalidate();
    }
    do
    {
      return;
      if (aiqy.a(this.k))
      {
        this.i = 0;
        this.h = 0;
        g();
        requestLayout();
        invalidate();
        return;
      }
    } while (!aiqy.h(this.k));
    this.i = ((int)(this.jdField_b_of_type_Float + 0.5F) - this.l);
    this.h = this.i;
    g();
    requestLayout();
    invalidate();
  }
  
  private void i()
  {
    if (aiqy.d(this.k)) {
      if (c()) {
        c();
      }
    }
    do
    {
      return;
      k();
      return;
      if (aiqy.e(this.k))
      {
        this.jdField_a_of_type_Aiqx.b();
        l();
        return;
      }
      if (aiqy.b(this.k))
      {
        b();
        return;
      }
      if ((aiqy.j(this.k)) || (aiqy.k(this.k)))
      {
        c();
        return;
      }
    } while ((!aiqy.l(this.k)) && (!aiqy.i(this.k)));
    d();
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a((int)(this.jdField_b_of_type_Float + 0.5F), this.jdField_e_of_type_Int);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a(-this.h, this.jdField_a_of_type_Int);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a(this.jdField_g_of_type_Int - this.h, this.jdField_b_of_type_Int);
    }
  }
  
  public int a()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public void a()
  {
    if (aiqy.e(this.k))
    {
      a(-3);
      h();
      this.jdField_a_of_type_Aiqx.c();
    }
    do
    {
      return;
      if (aiqy.b(this.k))
      {
        if (c()) {
          a(1);
        }
        for (;;)
        {
          h();
          this.jdField_a_of_type_Aiqx.d();
          return;
          a(0);
        }
      }
      if (aiqy.d(this.k))
      {
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          a(-3);
          h();
          this.jdField_a_of_type_Aiqx.c();
          return;
        }
        if (c()) {
          a(1);
        }
        for (;;)
        {
          h();
          this.jdField_a_of_type_Aiqx.d();
          return;
          a(0);
        }
      }
      if ((aiqy.j(this.k)) || (aiqy.k(this.k)))
      {
        a(1);
        h();
        return;
      }
    } while ((!aiqy.l(this.k)) && (!aiqy.i(this.k)));
    a(0);
    h();
  }
  
  public void a(float paramFloat)
  {
    if (aiqy.d(this.k)) {
      this.jdField_a_of_type_Aiqx.a(this.i, false, true);
    }
    for (;;)
    {
      d(paramFloat);
      return;
      if (aiqy.e(this.k)) {
        this.jdField_a_of_type_Aiqx.a(this.i, false, true);
      } else if (aiqy.b(this.k)) {
        this.jdField_a_of_type_Aiqx.a(this.i, true, true);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a(-this.l, this.jdField_d_of_type_Int);
    }
  }
  
  public boolean b()
  {
    return aiqy.c(this.k);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a((int)(this.jdField_b_of_type_Float + 0.5F) - this.l - this.i, this.jdField_d_of_type_Int);
    }
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a(-this.i, this.jdField_d_of_type_Int);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Aiqw != null) {
      this.jdField_a_of_type_Aiqw.onFlingScrollHeader(this.k, -this.i);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Aiqw != null) {
      this.jdField_a_of_type_Aiqw.onTouchMoving(this, -this.i, paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      i();
    }
  }
  
  public void e()
  {
    a(0);
    h();
    this.jdField_a_of_type_Aiqx.d();
    this.jdField_b_of_type_Float = 0.0F;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new CommonRefreshLayout.LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new CommonRefreshLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new CommonRefreshLayout.LayoutParams(paramLayoutParams);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int m = getChildCount();
    if (m == 0) {}
    do
    {
      return;
      if ((m <= 0) || (m >= 4)) {
        break;
      }
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131378045));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131378046);
    } while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewViewGroup == null) || (!(this.jdField_a_of_type_AndroidViewViewGroup instanceof airc)));
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    return;
    throw new IllegalStateException("Children num must equal or less than 3");
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    int i2 = 0;
    int n = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (this.jdField_a_of_type_ComTencentWidgetListView != null) {}
    for (int m = this.jdField_a_of_type_ComTencentWidgetListView.getListViewScrollY();; m = 0)
    {
      switch (n)
      {
      }
      for (;;)
      {
        boolean bool1 = super.onInterceptTouchEvent(paramMotionEvent);
        label67:
        return bool1;
        this.jdField_f_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        float f1 = b(paramMotionEvent, this.jdField_f_of_type_Int);
        this.jdField_d_of_type_Float = f1;
        this.jdField_f_of_type_Float = f1;
        f1 = a(paramMotionEvent, this.jdField_f_of_type_Int);
        this.jdField_e_of_type_Float = f1;
        this.jdField_g_of_type_Float = f1;
        if ((aiqy.d(this.k)) || (aiqy.e(this.k))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a();
        }
        if (((aiqy.d(this.k)) || (aiqy.e(this.k))) && (m == 0))
        {
          return true;
          if (this.jdField_f_of_type_Int == -1) {
            return false;
          }
          f1 = b(paramMotionEvent, this.jdField_f_of_type_Int);
          float f2 = a(paramMotionEvent, this.jdField_f_of_type_Int);
          float f3 = this.jdField_d_of_type_Float;
          float f4 = f2 - this.jdField_e_of_type_Float;
          this.jdField_f_of_type_Float = f1;
          this.jdField_g_of_type_Float = f2;
          if ((Math.abs(f1 - f3) < Math.abs(f4)) && (Math.abs(f4) > this.j)) {}
          for (n = 1;; n = 0)
          {
            int i1 = i2;
            if (f4 > 0.0F)
            {
              i1 = i2;
              if (d()) {
                i1 = 1;
              }
            }
            if ((m != 0) || (n == 0)) {
              break;
            }
            bool1 = bool2;
            if (i1 != 0) {
              break label67;
            }
            bool1 = bool2;
            if (aiqy.b(this.k)) {
              break label67;
            }
            if (!aiqy.f(this.k)) {
              break;
            }
            return true;
          }
          this.jdField_f_of_type_Int = -1;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    f();
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      measureChildWithMargins(localViewGroup, paramInt1, 0, paramInt2, 0);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localViewGroup.getLayoutParams();
      int m = localViewGroup.getMeasuredHeight();
      int n = localMarginLayoutParams.topMargin;
      this.jdField_g_of_type_Int = (localMarginLayoutParams.bottomMargin + (m + n));
      if (this.jdField_b_of_type_Float < this.jdField_g_of_type_Int) {
        this.jdField_b_of_type_Float = this.jdField_g_of_type_Int;
      }
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      measureChildWithMargins(this.jdField_a_of_type_AndroidViewView, paramInt1, 0, paramInt2, 0);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.jdField_f_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      return true;
      float f1 = b(paramMotionEvent, this.jdField_f_of_type_Int);
      float f2 = a(paramMotionEvent, this.jdField_f_of_type_Int);
      float f3 = f1 - this.jdField_f_of_type_Float;
      float f4 = f2 - this.jdField_g_of_type_Float;
      this.jdField_f_of_type_Float = f1;
      this.jdField_g_of_type_Float = f2;
      if ((Math.abs(f3) >= Math.abs(f4)) && (Math.abs(f3) > this.j)) {
        return false;
      }
      b(f4);
      return true;
      int m = MotionEventCompat.getPointerId(paramMotionEvent, MotionEventCompat.getActionIndex(paramMotionEvent));
      if (m != -1) {
        this.jdField_f_of_type_Int = m;
      }
      this.jdField_f_of_type_Float = b(paramMotionEvent, this.jdField_f_of_type_Int);
      this.jdField_g_of_type_Float = a(paramMotionEvent, this.jdField_f_of_type_Int);
      continue;
      a(paramMotionEvent);
      this.jdField_f_of_type_Float = b(paramMotionEvent, this.jdField_f_of_type_Int);
      this.jdField_g_of_type_Float = a(paramMotionEvent, this.jdField_f_of_type_Int);
      continue;
      if (this.jdField_f_of_type_Int == -1) {
        return false;
      }
      this.jdField_f_of_type_Int = -1;
    }
  }
  
  public void setMiniAppScrollListener(aiqw paramaiqw)
  {
    this.jdField_a_of_type_Aiqw = paramaiqw;
  }
  
  public void setOnRefreshListener(aira paramaira)
  {
    this.jdField_a_of_type_Aira = paramaira;
  }
  
  public void setRefreshCompleteDelayDuration(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setRefreshEnabled(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((!a()) || (this.jdField_a_of_type_AndroidViewViewGroup == null)) {}
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Boolean = paramBoolean;
        if (!paramBoolean) {
          break;
        }
      } while (!aiqy.a(this.k));
      a(-1);
      j();
      return;
    } while (!aiqy.b(this.k));
    this.jdField_a_of_type_Aiqx.d();
    postDelayed(new CommonRefreshLayout.1(this), this.jdField_c_of_type_Int);
  }
  
  public void setShowMiniAppPanel(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setTargetListView(ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout
 * JD-Core Version:    0.7.0.1
 */