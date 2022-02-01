package com.tencent.mobileqq.activity.contacts.pullrefresh;

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
  implements AutoScroller.ScrollerCallback
{
  private float jdField_a_of_type_Float = 0.5F;
  private int jdField_a_of_type_Int = 200;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AutoScroller jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller;
  private CommonRefreshLayout.MiniAppScrollListener jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$MiniAppScrollListener;
  CommonRefreshLayout.RefreshCallback jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$RefreshCallback = new CommonRefreshLayout.2(this);
  private OnRefreshListener jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshOnRefreshListener;
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
    try
    {
      int m = paramAttributeSet.getIndexCount();
      paramInt = 0;
      while (paramInt < m)
      {
        int n = paramAttributeSet.getIndex(paramInt);
        if (n == 10) {
          setRefreshEnabled(paramAttributeSet.getBoolean(n, true));
        } else if (n == 2) {
          this.jdField_a_of_type_Float = paramAttributeSet.getFloat(n, 0.5F);
        } else if (n == 11) {
          this.jdField_c_of_type_Float = paramAttributeSet.getDimensionPixelOffset(n, 0);
        } else if (n == 12) {
          this.jdField_b_of_type_Float = paramAttributeSet.getDimensionPixelOffset(n, 0);
        } else if (n == 16) {
          this.jdField_a_of_type_Int = paramAttributeSet.getInt(n, 200);
        } else if (n == 14) {
          this.jdField_b_of_type_Int = paramAttributeSet.getInt(n, 200);
        } else if (n == 8) {
          setRefreshCompleteDelayDuration(paramAttributeSet.getInt(n, 300));
        } else if (n == 9) {
          this.jdField_d_of_type_Int = paramAttributeSet.getInt(n, 500);
        } else if (n == 1) {
          this.jdField_e_of_type_Int = paramAttributeSet.getInt(n, 500);
        }
        paramInt += 1;
      }
      paramAttributeSet.recycle();
      this.j = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller = new AutoScroller(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a(this);
      this.l = getResources().getDimensionPixelOffset(2131298921);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
    for (;;)
    {
      throw paramContext;
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
    if (MotionEventCompat.getPointerId(paramMotionEvent, m) == this.jdField_f_of_type_Int)
    {
      if (m == 0) {
        m = 1;
      } else {
        m = 0;
      }
      this.jdField_f_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, m);
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
    if ((CommonRefreshLayout.STATUS.a(this.k)) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$MiniAppScrollListener != null) && (paramFloat > 0.0F))
    {
      a(3);
      if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      }
    }
    if (CommonRefreshLayout.STATUS.g(this.k))
    {
      if (paramFloat < 0.0F)
      {
        a(2);
      }
      else
      {
        int m = this.i;
        float f1 = m;
        float f2 = this.jdField_b_of_type_Float;
        if (f1 >= f2) {
          a(4);
        } else if (m >= (f2 - this.l) / 2.0F) {
          a(5);
        } else {
          a(3);
        }
      }
      c(paramFloat);
    }
    if ((CommonRefreshLayout.STATUS.h(this.k)) || (CommonRefreshLayout.STATUS.i(this.k)))
    {
      if (paramFloat < 0.0F) {
        a(2);
      } else {
        a(1);
      }
      c(paramFloat);
    }
    if (((CommonRefreshLayout.STATUS.a(this.k)) || (CommonRefreshLayout.STATUS.h(this.k))) && (paramFloat > 0.0F) && (d()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$RefreshCallback.a();
      a(-1);
    }
    if (CommonRefreshLayout.STATUS.c(this.k))
    {
      if ((!CommonRefreshLayout.STATUS.d(this.k)) && (!CommonRefreshLayout.STATUS.e(this.k)))
      {
        if ((paramFloat < 0.0F) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$MiniAppScrollListener != null)) {
          a(2);
        }
      }
      else if (this.i >= this.jdField_b_of_type_Float) {
        a(-2);
      } else {
        a(-1);
      }
      c(paramFloat);
    }
  }
  
  private void c(float paramFloat)
  {
    float f1 = paramFloat * this.jdField_a_of_type_Float;
    int m = this.i;
    float f2 = m + f1;
    if ((m <= 0) || (f2 >= 0.0F))
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
    float f3 = this.jdField_c_of_type_Float;
    f1 = paramFloat;
    if (f3 > this.jdField_b_of_type_Float)
    {
      f1 = paramFloat;
      if (f2 > f3) {
        f1 = f3 - this.i;
      }
    }
    if (CommonRefreshLayout.STATUS.c(this.k))
    {
      m = this.i;
      if (c()) {
        m = this.i - ((int)this.jdField_b_of_type_Float - this.l);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$RefreshCallback.a(m, false, false);
    }
    d(f1);
  }
  
  private void d(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    this.i = ((int)(this.i + paramFloat));
    if ((CommonRefreshLayout.STATUS.c(this.k)) || (CommonRefreshLayout.STATUS.f(this.k))) {
      this.h = this.i;
    }
    g();
    requestLayout();
    invalidate();
  }
  
  private boolean d()
  {
    return (this.jdField_c_of_type_Boolean) && (!ViewUtils.a(this.jdField_a_of_type_AndroidViewView)) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Float > 0.0F);
  }
  
  private void f()
  {
    int n = getPaddingLeft();
    int m = getPaddingTop();
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int i1;
    if (localObject != null)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      i1 = localMarginLayoutParams.leftMargin + n;
      int i2 = localMarginLayoutParams.topMargin + m - this.jdField_g_of_type_Int + this.h;
      ((View)localObject).layout(i1, i2, ((View)localObject).getMeasuredWidth() + i1, ((View)localObject).getMeasuredHeight() + i2);
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      i1 = n + localMarginLayoutParams.leftMargin;
      n = m + localMarginLayoutParams.topMargin + this.i;
      m = n;
      if (n < 0) {
        m = 0;
      }
      ((View)localObject).layout(i1, m, ((View)localObject).getMeasuredWidth() + i1, ((View)localObject).getMeasuredHeight() + m);
    }
  }
  
  private void g()
  {
    int m = getPaddingTop();
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((View)localObject).setTop(((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams()).topMargin + m - this.jdField_g_of_type_Int + this.h);
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      int n = m + ((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams()).topMargin + this.i;
      m = n;
      if (n < 0) {
        m = 0;
      }
      ((View)localObject).setTop(m);
    }
  }
  
  private void h()
  {
    if (CommonRefreshLayout.STATUS.b(this.k))
    {
      this.i = ((int)(this.jdField_b_of_type_Float + 0.5F));
      this.h = this.i;
      g();
      requestLayout();
      invalidate();
      return;
    }
    if (CommonRefreshLayout.STATUS.a(this.k))
    {
      this.i = 0;
      this.h = 0;
      g();
      requestLayout();
      invalidate();
      return;
    }
    if (CommonRefreshLayout.STATUS.h(this.k))
    {
      this.i = ((int)(this.jdField_b_of_type_Float + 0.5F) - this.l);
      this.h = this.i;
      g();
      requestLayout();
      invalidate();
    }
  }
  
  private void i()
  {
    if (CommonRefreshLayout.STATUS.d(this.k))
    {
      if (c())
      {
        c();
        return;
      }
      k();
      return;
    }
    if (CommonRefreshLayout.STATUS.e(this.k))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$RefreshCallback.b();
      l();
      return;
    }
    if (CommonRefreshLayout.STATUS.b(this.k))
    {
      b();
      return;
    }
    if ((!CommonRefreshLayout.STATUS.j(this.k)) && (!CommonRefreshLayout.STATUS.k(this.k)))
    {
      if ((CommonRefreshLayout.STATUS.l(this.k)) || (CommonRefreshLayout.STATUS.i(this.k))) {
        d();
      }
    }
    else {
      c();
    }
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
    if (CommonRefreshLayout.STATUS.e(this.k))
    {
      a(-3);
      h();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$RefreshCallback.c();
      return;
    }
    if (CommonRefreshLayout.STATUS.b(this.k))
    {
      if (c()) {
        a(1);
      } else {
        a(0);
      }
      h();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$RefreshCallback.d();
      return;
    }
    if (CommonRefreshLayout.STATUS.d(this.k))
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        a(-3);
        h();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$RefreshCallback.c();
        return;
      }
      if (c()) {
        a(1);
      } else {
        a(0);
      }
      h();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$RefreshCallback.d();
      return;
    }
    if ((!CommonRefreshLayout.STATUS.j(this.k)) && (!CommonRefreshLayout.STATUS.k(this.k)))
    {
      if ((CommonRefreshLayout.STATUS.l(this.k)) || (CommonRefreshLayout.STATUS.i(this.k)))
      {
        a(0);
        h();
      }
    }
    else
    {
      a(1);
      h();
    }
  }
  
  public void a(float paramFloat)
  {
    if (CommonRefreshLayout.STATUS.d(this.k)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$RefreshCallback.a(this.i, false, true);
    } else if (CommonRefreshLayout.STATUS.e(this.k)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$RefreshCallback.a(this.i, false, true);
    } else if (CommonRefreshLayout.STATUS.b(this.k)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$RefreshCallback.a(this.i, true, true);
    }
    d(paramFloat);
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
    return CommonRefreshLayout.STATUS.c(this.k);
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
    CommonRefreshLayout.MiniAppScrollListener localMiniAppScrollListener = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$MiniAppScrollListener;
    if (localMiniAppScrollListener != null) {
      localMiniAppScrollListener.onFlingScrollHeader(this.k, -this.i);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    CommonRefreshLayout.MiniAppScrollListener localMiniAppScrollListener = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$MiniAppScrollListener;
    if (localMiniAppScrollListener != null) {
      localMiniAppScrollListener.onTouchMoving(this, -this.i, paramMotionEvent);
    }
    int m = paramMotionEvent.getAction();
    if ((m == 1) || (m == 3)) {
      i();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    a(0);
    h();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$RefreshCallback.d();
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
    if (m == 0) {
      return;
    }
    if ((m > 0) && (m < 4))
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131378153));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131378154);
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      if ((localViewGroup != null) && ((localViewGroup instanceof SwipeTrigger))) {
        localViewGroup.setVisibility(8);
      }
      return;
    }
    throw new IllegalStateException("Children num must equal or less than 3");
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = MotionEventCompat.getActionMasked(paramMotionEvent);
    ListView localListView = this.jdField_a_of_type_ComTencentWidgetListView;
    int i2 = 0;
    int m;
    if (localListView != null) {
      m = localListView.getListViewScrollY();
    } else {
      m = 0;
    }
    float f1;
    if (n != 0)
    {
      if (n != 1) {
        if (n != 2)
        {
          if (n != 3) {
            break label327;
          }
        }
        else
        {
          n = this.jdField_f_of_type_Int;
          if (n == -1) {
            return false;
          }
          f1 = b(paramMotionEvent, n);
          float f2 = a(paramMotionEvent, this.jdField_f_of_type_Int);
          float f3 = this.jdField_d_of_type_Float;
          float f4 = f2 - this.jdField_e_of_type_Float;
          this.jdField_f_of_type_Float = f1;
          this.jdField_g_of_type_Float = f2;
          if ((Math.abs(f1 - f3) < Math.abs(f4)) && (Math.abs(f4) > this.j)) {
            n = 1;
          } else {
            n = 0;
          }
          int i1 = i2;
          if (f4 > 0.0F)
          {
            i1 = i2;
            if (d()) {
              i1 = 1;
            }
          }
          if ((m != 0) || (n == 0) || ((i1 == 0) && (!CommonRefreshLayout.STATUS.b(this.k)) && (!CommonRefreshLayout.STATUS.f(this.k)))) {
            break label327;
          }
          return true;
        }
      }
      this.jdField_f_of_type_Int = -1;
    }
    else
    {
      this.jdField_f_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      f1 = b(paramMotionEvent, this.jdField_f_of_type_Int);
      this.jdField_d_of_type_Float = f1;
      this.jdField_f_of_type_Float = f1;
      f1 = a(paramMotionEvent, this.jdField_f_of_type_Int);
      this.jdField_e_of_type_Float = f1;
      this.jdField_g_of_type_Float = f1;
      if ((CommonRefreshLayout.STATUS.d(this.k)) || (CommonRefreshLayout.STATUS.e(this.k))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a();
      }
      if (((CommonRefreshLayout.STATUS.d(this.k)) || (CommonRefreshLayout.STATUS.e(this.k))) && (m == 0)) {
        return true;
      }
    }
    label327:
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    f();
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null)
    {
      measureChildWithMargins((View)localObject, paramInt1, 0, paramInt2, 0);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      this.jdField_g_of_type_Int = (((View)localObject).getMeasuredHeight() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin);
      float f1 = this.jdField_b_of_type_Float;
      int m = this.jdField_g_of_type_Int;
      if (f1 < m) {
        this.jdField_b_of_type_Float = m;
      }
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      measureChildWithMargins((View)localObject, paramInt1, 0, paramInt2, 0);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (m != 0)
    {
      if (m != 1) {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 5)
            {
              if (m != 6) {
                break label229;
              }
              a(paramMotionEvent);
              this.jdField_f_of_type_Float = b(paramMotionEvent, this.jdField_f_of_type_Int);
              this.jdField_g_of_type_Float = a(paramMotionEvent, this.jdField_f_of_type_Int);
              break label229;
            }
            m = MotionEventCompat.getPointerId(paramMotionEvent, MotionEventCompat.getActionIndex(paramMotionEvent));
            if (m != -1) {
              this.jdField_f_of_type_Int = m;
            }
            this.jdField_f_of_type_Float = b(paramMotionEvent, this.jdField_f_of_type_Int);
            this.jdField_g_of_type_Float = a(paramMotionEvent, this.jdField_f_of_type_Int);
            break label229;
          }
        }
        else
        {
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
        }
      }
      if (this.jdField_f_of_type_Int == -1) {
        return false;
      }
      this.jdField_f_of_type_Int = -1;
      label229:
      return super.onTouchEvent(paramMotionEvent);
    }
    this.jdField_f_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, 0);
    return true;
  }
  
  public void setMiniAppScrollListener(CommonRefreshLayout.MiniAppScrollListener paramMiniAppScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$MiniAppScrollListener = paramMiniAppScrollListener;
  }
  
  public void setOnRefreshListener(OnRefreshListener paramOnRefreshListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshOnRefreshListener = paramOnRefreshListener;
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
    if (a())
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
        return;
      }
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (paramBoolean)
      {
        if (CommonRefreshLayout.STATUS.a(this.k))
        {
          a(-1);
          j();
        }
      }
      else if (CommonRefreshLayout.STATUS.b(this.k))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$RefreshCallback.d();
        postDelayed(new CommonRefreshLayout.1(this), this.jdField_c_of_type_Int);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout
 * JD-Core Version:    0.7.0.1
 */