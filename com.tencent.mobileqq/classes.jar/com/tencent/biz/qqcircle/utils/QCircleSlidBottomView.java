package com.tencent.biz.qqcircle.utils;

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
import azkz;
import bnle;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.widget.immersive.ImmersiveUtils;
import ube;
import ubf;
import ubg;
import ubh;
import ubi;
import ybu;
import yib;

public class QCircleSlidBottomView
  extends FrameLayout
  implements NestedScrollingParent
{
  private final int jdField_a_of_type_Int = 0;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private final NestedScrollingParentHelper jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper;
  private ScrollerCompat jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat = ScrollerCompat.create(getContext(), this.jdField_c_of_type_AndroidViewAnimationInterpolator);
  private View jdField_a_of_type_AndroidViewView;
  protected Interpolator a;
  private ubh jdField_a_of_type_Ubh;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 1;
  private ObjectAnimator jdField_b_of_type_AndroidAnimationObjectAnimator;
  protected Interpolator b;
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int = azkz.a(50.0F);
  private ObjectAnimator jdField_c_of_type_AndroidAnimationObjectAnimator;
  private Interpolator jdField_c_of_type_AndroidViewAnimationInterpolator = new ube(this);
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
  private int m;
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
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new ubi(this, 1.0D);
    this.jdField_b_of_type_AndroidViewAnimationInterpolator = new AccelerateInterpolator();
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.jdField_d_of_type_Int = localViewConfiguration.getScaledTouchSlop();
    this.e = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.f = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCircleSlidBottomView);
    float f1 = paramAttributeSet.getFloat(2, 0.5F);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.i = (ImmersiveUtils.getStatusBarHeight(paramContext) - 1);
    }
    if (azkz.a(paramContext)) {
      this.g = azkz.d(paramContext);
    }
    this.n = azkz.c(paramContext);
    if (bnle.c((Activity)paramContext)) {
      this.o = bnle.g;
    }
    this.k = ((int)((1.0F - f1) * this.n));
    this.j = ((int)paramAttributeSet.getDimension(3, this.jdField_c_of_type_Int));
    this.l = ((int)paramAttributeSet.getDimension(0, azkz.a(30.0F)));
    this.q = (this.n - this.j - Math.max(this.i, this.o));
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    this.h = (this.k - this.j);
    if (ybu.a()) {
      setBackgroundColor(Color.parseColor("#00000000"));
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (Math.abs(paramInt2) < this.e) {
      i1 = 0;
    }
    if ((paramInt1 == 0) && (i1 == 0)) {}
    do
    {
      do
      {
        return;
        e();
        paramInt1 = Math.max(-this.f, Math.min(paramInt1, this.f));
        paramInt2 = Math.max(-this.f, Math.min(i1, this.f));
      } while (Math.abs(paramInt2) <= Math.abs(paramInt1));
      this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.abortAnimation();
      this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.fling(0, getScrollY(), paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    } while (!this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.computeScrollOffset());
    paramInt1 = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getCurrY();
    paramInt2 = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getFinalY();
    i1 = paramInt2 - paramInt1;
    if (i1 > 0) {
      if ((a()) && (i1 > this.n / 2)) {
        d();
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
            b();
          }
        }
        else if (Math.abs(i1) > this.n * 2.0F / 3.0F) {
          b();
        }
      }
    }
  }
  
  private boolean a()
  {
    return this.m == 0;
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
    if ((paramRecyclerView != null) && ((paramRecyclerView.getAdapter() instanceof yib))) {
      return ((yib)paramRecyclerView.getAdapter()).a() > 0;
    }
    return false;
  }
  
  private void c()
  {
    this.jdField_d_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofInt(this, "ScrollY", new int[] { getScrollY(), 0 }).setDuration(200L);
    this.jdField_d_of_type_AndroidAnimationObjectAnimator.start();
    this.m = 0;
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofInt(this, "ScrollY", new int[] { getScrollY(), this.h }).setDuration(1500L);
    this.jdField_b_of_type_AndroidAnimationObjectAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.jdField_b_of_type_AndroidAnimationObjectAnimator.start();
    this.m = 1;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = this.q;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void e()
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
  
  protected void a()
  {
    int i1 = getScrollY();
    i1 = this.p - i1;
    QLog.d("QCircleSlidBottomView", 3, "onend:" + this.p);
    if (a()) {
      if (i1 > 0) {
        if (Math.abs(i1) > this.q / 6.0F) {
          b();
        }
      }
    }
    while (i1 <= 0)
    {
      return;
      c();
      return;
      if (Math.abs(i1) > this.q / 8.0F)
      {
        d();
        return;
      }
      c();
      return;
    }
    if (Math.abs(i1) > this.q / 2.0F)
    {
      b();
      return;
    }
    if (Math.abs(i1) > this.q / 6.0F)
    {
      c();
      return;
    }
    d();
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    setVisibility(0);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofInt(this, "ScrollY", new int[] { -this.q / 2, 0 }).setDuration(1500L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new ubf(this));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
    this.m = 0;
  }
  
  public void b()
  {
    int i1 = getScrollY();
    QLog.d("QCircleSlidBottomView", 3, "currentY:" + i1);
    this.jdField_c_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofInt(this, "ScrollY", new int[] { i1, -this.q / 2 }).setDuration(200L);
    this.jdField_c_of_type_AndroidAnimationObjectAnimator.setInterpolator(this.jdField_b_of_type_AndroidViewAnimationInterpolator);
    this.jdField_c_of_type_AndroidAnimationObjectAnimator.addListener(new ubg(this));
    this.jdField_c_of_type_AndroidAnimationObjectAnimator.start();
    this.m = 0;
  }
  
  public int getNestedScrollAxes()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = getChildCount();
    paramInt3 = this.n - this.k;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (paramInt1 == 0) {
        localView.setPadding(0, 0, 0, this.g);
      }
      localView.layout(0, paramInt3, localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt3);
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
    e();
    if (paramInt2 > this.jdField_d_of_type_Int * 2) {
      scrollBy(0, this.jdField_d_of_type_Int * 2);
    }
    for (;;)
    {
      paramArrayOfInt[1] = paramInt2;
      return;
      if (paramInt2 < this.jdField_d_of_type_Int * -2) {
        scrollBy(0, this.jdField_d_of_type_Int * -2);
      } else {
        scrollBy(0, paramInt2);
      }
    }
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
      a();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void setStatusListener(ubh paramubh)
  {
    this.jdField_a_of_type_Ubh = paramubh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleSlidBottomView
 * JD-Core Version:    0.7.0.1
 */