package com.tencent.biz.qqcircle.utils;

import aaaf;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import bclx;
import bqcd;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.widget.immersive.ImmersiveUtils;
import vtn;
import vto;
import vtp;
import vtq;
import vtr;
import zxo;

public class QCircleSlidBottomView
  extends FrameLayout
  implements NestedScrollingParent
{
  private final int jdField_a_of_type_Int = bclx.a(50.0F);
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private final NestedScrollingParentHelper jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper;
  private ScrollerCompat jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat = ScrollerCompat.create(getContext(), this.jdField_c_of_type_AndroidViewAnimationInterpolator);
  private View jdField_a_of_type_AndroidViewView;
  protected Interpolator a;
  private vtq jdField_a_of_type_Vtq;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = bclx.a(5.0F);
  private ObjectAnimator jdField_b_of_type_AndroidAnimationObjectAnimator;
  protected Interpolator b;
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int;
  private ObjectAnimator jdField_c_of_type_AndroidAnimationObjectAnimator;
  private Interpolator jdField_c_of_type_AndroidViewAnimationInterpolator = new vtn(this);
  private boolean jdField_c_of_type_Boolean;
  private final int jdField_d_of_type_Int;
  private ObjectAnimator jdField_d_of_type_AndroidAnimationObjectAnimator;
  private final int e;
  private final int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m = -2;
  private int n;
  private int o;
  private int p;
  private int q;
  
  public QCircleSlidBottomView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleSlidBottomView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleSlidBottomView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new vtr(this, 1.0D);
    this.jdField_b_of_type_AndroidViewAnimationInterpolator = new AccelerateInterpolator();
    this.n = bclx.c(paramContext);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.jdField_c_of_type_Int = localViewConfiguration.getScaledTouchSlop();
    this.jdField_d_of_type_Int = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.e = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCircleSlidBottomView);
    this.k = ((int)(paramAttributeSet.getFloat(3, 0.5F) * this.n));
    this.j = ((int)paramAttributeSet.getDimension(4, this.jdField_a_of_type_Int));
    this.l = ((int)paramAttributeSet.getDimension(1, bclx.a(30.0F)));
    this.f = ((int)paramAttributeSet.getDimension(0, 0.0F));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.i = (ImmersiveUtils.getStatusBarHeight(paramContext) - 1);
    }
    if (bclx.a(paramContext)) {
      this.g = bclx.d(paramContext);
    }
    if (bqcd.c((Activity)paramContext)) {
      this.o = bqcd.g;
    }
    this.q = (this.n - this.j - Math.max(this.i, this.o));
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    this.h = (this.k - this.j);
    if (aaaf.a()) {
      setBackgroundColor(Color.parseColor("#00000000"));
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (Math.abs(paramInt2) < this.jdField_d_of_type_Int) {
      i1 = 0;
    }
    if ((paramInt1 == 0) && (i1 == 0)) {}
    do
    {
      do
      {
        return;
        f();
        paramInt1 = Math.max(-this.e, Math.min(paramInt1, this.e));
        paramInt2 = Math.max(-this.e, Math.min(i1, this.e));
      } while (Math.abs(paramInt2) <= Math.abs(paramInt1));
      this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.abortAnimation();
      this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.fling(0, getScrollY(), paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    } while (!this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.computeScrollOffset());
    paramInt1 = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getCurrY();
    paramInt2 = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getFinalY();
    i1 = paramInt2 - paramInt1;
    if (i1 > 0) {
      if ((a()) && (i1 > this.n / 2)) {
        c();
      }
    }
    for (;;)
    {
      QLog.d("QCircleSlidBottomView", 3, "fling start y:" + paramInt1 + "   end y:" + paramInt2);
      return;
      if (i1 < 0) {
        if (a())
        {
          if (Math.abs(i1) > this.n / 2) {
            d();
          }
        }
        else if (Math.abs(i1) > this.n * 2.0F / 3.0F) {
          d();
        }
      }
    }
  }
  
  private boolean a(int paramInt, RecyclerView paramRecyclerView)
  {
    if (a()) {
      if (!a(paramRecyclerView)) {}
    }
    do
    {
      do
      {
        return true;
      } while (paramInt <= 0);
      return false;
      if (paramInt >= 0) {
        return this.jdField_b_of_type_Boolean;
      }
    } while (!paramRecyclerView.canScrollVertically(-1));
    return false;
  }
  
  private boolean a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView != null) && ((paramRecyclerView.getAdapter() instanceof zxo))) {
      return ((zxo)paramRecyclerView.getAdapter()).a() > 0;
    }
    return false;
  }
  
  private void e()
  {
    this.jdField_d_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofInt(this, "ScrollY", new int[] { getScrollY(), 0 }).setDuration(200L);
    this.jdField_d_of_type_AndroidAnimationObjectAnimator.start();
    this.m = 0;
    if (this.jdField_a_of_type_Vtq != null) {
      this.jdField_a_of_type_Vtq.a(this.m);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.cancel();
    }
    if (this.jdField_d_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_d_of_type_AndroidAnimationObjectAnimator.cancel();
    }
    if (this.jdField_c_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_c_of_type_AndroidAnimationObjectAnimator.cancel();
    }
  }
  
  public void a()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.j += Math.max(this.i, this.o);
      this.h = (this.k - this.j);
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void a(View paramView)
  {
    if (this.m == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    setVisibility(0);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofInt(this, "ScrollY", new int[] { -this.q / 2, 0 }).setDuration(1500L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new vto(this));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
    this.m = 0;
  }
  
  public boolean a()
  {
    return this.m == 0;
  }
  
  protected void b()
  {
    int i1 = getScrollY();
    i1 = this.p - i1;
    QLog.d("QCircleSlidBottomView", 3, "onend:" + this.p);
    if (a()) {
      if (i1 > 0) {
        if (Math.abs(i1) > this.q / 6.0F) {
          d();
        }
      }
    }
    while (i1 <= 0)
    {
      return;
      e();
      return;
      if (Math.abs(i1) > this.q / 8.0F)
      {
        c();
        return;
      }
      e();
      return;
    }
    if (Math.abs(i1) > this.q / 2.0F)
    {
      d();
      return;
    }
    if (Math.abs(i1) > this.q / 6.0F)
    {
      e();
      return;
    }
    c();
  }
  
  public boolean b()
  {
    return this.m != -1;
  }
  
  public void c()
  {
    this.jdField_b_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofInt(this, "ScrollY", new int[] { getScrollY(), this.h }).setDuration(1500L);
    this.jdField_b_of_type_AndroidAnimationObjectAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.jdField_b_of_type_AndroidAnimationObjectAnimator.start();
    this.m = 1;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = (this.q + this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    if (this.jdField_a_of_type_Vtq != null) {
      this.jdField_a_of_type_Vtq.a(this.m);
    }
  }
  
  public void d()
  {
    int i1 = getScrollY();
    QLog.d("QCircleSlidBottomView", 3, "currentY:" + i1);
    this.jdField_c_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofInt(this, "ScrollY", new int[] { i1, -this.q / 2 }).setDuration(200L);
    this.jdField_c_of_type_AndroidAnimationObjectAnimator.setInterpolator(this.jdField_b_of_type_AndroidViewAnimationInterpolator);
    this.jdField_c_of_type_AndroidAnimationObjectAnimator.addListener(new vtp(this));
    this.jdField_c_of_type_AndroidAnimationObjectAnimator.start();
    this.m = -1;
  }
  
  public int getNestedScrollAxes()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = getChildCount();
    paramInt3 = this.k;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (paramInt1 == 0) {
        localView.setPadding(0, 0, 0, this.f + this.g + this.jdField_b_of_type_Int);
      }
      localView.layout(0, paramInt3, localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt3 + this.g + this.jdField_b_of_type_Int);
      paramInt1 += 1;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramView instanceof NestScrollRecyclerView))
    {
      bool1 = bool2;
      if (a((int)paramFloat2, (NestScrollRecyclerView)paramView))
      {
        a((int)paramFloat1, (int)paramFloat2);
        bool1 = true;
        QLog.d("QCircleSlidBottomView", 3, "fling:" + paramFloat1 + " " + paramFloat2);
      }
    }
    return bool1;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (((paramView instanceof RecyclerView)) && (a(paramInt2, (RecyclerView)paramView)))
    {
      this.jdField_b_of_type_Boolean = true;
      if ((getScrollY() + paramInt2 > this.h) && (paramInt2 > 0)) {
        paramArrayOfInt[1] = paramInt2;
      }
    }
    else
    {
      return;
    }
    f();
    if (paramInt2 > this.jdField_c_of_type_Int * 2) {
      scrollBy(0, this.jdField_c_of_type_Int * 2);
    }
    for (;;)
    {
      paramArrayOfInt[1] = paramInt2;
      return;
      if (paramInt2 < this.jdField_c_of_type_Int * -2) {
        scrollBy(0, this.jdField_c_of_type_Int * -2);
      } else {
        scrollBy(0, paramInt2);
      }
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    this.p = getScrollY();
    QLog.d("QCircleSlidBottomView", 3, "onstart:" + this.p);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.onStopNestedScroll(paramView);
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void setStatusListener(vtq paramvtq)
  {
    this.jdField_a_of_type_Vtq = paramvtq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleSlidBottomView
 * JD-Core Version:    0.7.0.1
 */