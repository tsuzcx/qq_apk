package com.tencent.biz.qqcircle.utils;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.widget.ScrollerCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class QCircleSlidBottomView
  extends FrameLayout
  implements NestedScrollingParent
{
  private static final int c = ViewUtils.a(50.0F);
  private static final int d = ViewUtils.a(5.0F);
  private ObjectAnimator A;
  private ObjectAnimator B;
  private ObjectAnimator C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  protected Interpolator a = new QCircleSlidBottomView.OpenInterpolator(this, 1.0D);
  protected Interpolator b = new AccelerateInterpolator();
  private final NestedScrollingParentHelper e;
  private final int f;
  private final int g;
  private final int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p = -2;
  private int q;
  private int r;
  private int s;
  private int t;
  private View u;
  private boolean v;
  private QCircleSlidBottomView.IStatusListener w;
  private Interpolator x = new QCircleSlidBottomView.1(this);
  private ScrollerCompat y = ScrollerCompat.create(getContext(), this.x);
  private ObjectAnimator z;
  
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
    this.q = DisplayUtil.a(paramContext);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.f = localViewConfiguration.getScaledTouchSlop();
    this.g = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.h = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cV);
    float f1 = paramAttributeSet.getFloat(R.styleable.cY, 0.5F);
    this.n = ((int)(this.q * f1));
    this.m = ((int)paramAttributeSet.getDimension(R.styleable.cZ, c));
    this.o = ((this.q - Math.max(this.l, this.r)) / 6);
    this.i = ((int)paramAttributeSet.getDimension(R.styleable.cW, 0.0F));
    this.v = paramAttributeSet.getBoolean(R.styleable.cX, false);
    if (ImmersiveUtils.d() == 1) {
      this.l = (ImmersiveUtils.a(paramContext) - 1);
    }
    paramContext = (Activity)paramContext;
    if (QCircleLiuHaiUtils.d(paramContext))
    {
      QCircleLiuHaiUtils.e(paramContext);
      this.r = QCircleLiuHaiUtils.a();
    }
    paramAttributeSet.recycle();
    int i1 = this.q;
    if (this.v) {
      paramInt = this.o;
    } else {
      paramInt = this.m;
    }
    this.t = (i1 - paramInt - Math.max(this.l, this.r));
    if (this.v)
    {
      paramInt = this.q / 2;
      i1 = this.o;
    }
    else
    {
      paramInt = this.n;
      i1 = this.m;
    }
    this.k = (paramInt - i1);
    paramContext = new StringBuilder();
    paramContext.append("isFix = ");
    paramContext.append(this.v);
    QLog.d("QCircleSlidBottomView", 4, paramContext.toString());
    this.e = new NestedScrollingParentHelper(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (Math.abs(paramInt2) < this.g) {
      i1 = 0;
    }
    if ((paramInt1 == 0) && (i1 == 0)) {
      return;
    }
    i();
    paramInt2 = this.h;
    paramInt1 = Math.max(-paramInt2, Math.min(paramInt1, paramInt2));
    paramInt2 = this.h;
    paramInt2 = Math.max(-paramInt2, Math.min(i1, paramInt2));
    if (Math.abs(paramInt2) < Math.abs(paramInt1)) {
      return;
    }
    b(paramInt1, paramInt2);
  }
  
  private boolean a(int paramInt, RecyclerView paramRecyclerView)
  {
    if (d()) {
      if (paramInt >= 0) {
        return this.E;
      }
    }
    for (boolean bool = paramRecyclerView.canScrollVertically(-1);; bool = paramRecyclerView.canScrollVertically(-1))
    {
      return true ^ bool;
      if (c())
      {
        if (a(paramRecyclerView)) {
          return true;
        }
        return paramInt <= 0;
      }
      if (paramInt >= 0) {
        return this.E;
      }
    }
  }
  
  private boolean a(RecyclerView paramRecyclerView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramRecyclerView != null)
    {
      bool1 = bool2;
      if ((paramRecyclerView.getAdapter() instanceof BlockMerger))
      {
        bool1 = bool2;
        if (((BlockMerger)paramRecyclerView.getAdapter()).d() > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.y.abortAnimation();
    this.y.fling(0, getScrollY(), paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    if (this.y.computeScrollOffset())
    {
      paramInt1 = this.y.getCurrY();
      paramInt2 = this.y.getFinalY();
      int i1 = paramInt2 - paramInt1;
      if (i1 > 0)
      {
        if ((c()) && (i1 > this.q / 2)) {
          e();
        }
      }
      else if (i1 < 0) {
        if (c())
        {
          if (Math.abs(i1) > this.q / 2) {
            f();
          }
        }
        else if (Math.abs(i1) > this.q * 2.0F / 3.0F) {
          f();
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fling start y:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("   end y:");
      localStringBuilder.append(paramInt2);
      QLog.d("QCircleSlidBottomView", 4, localStringBuilder.toString());
    }
  }
  
  private void h()
  {
    this.C = ObjectAnimator.ofInt(this, "ScrollY", new int[] { getScrollY(), 0 }).setDuration(200L);
    this.C.start();
    this.p = 0;
    QCircleSlidBottomView.IStatusListener localIStatusListener = this.w;
    if (localIStatusListener != null) {
      localIStatusListener.a(this.p);
    }
  }
  
  private void i()
  {
    ObjectAnimator localObjectAnimator = this.z;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
    localObjectAnimator = this.A;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
    localObjectAnimator = this.C;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
    localObjectAnimator = this.B;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  public void a()
  {
    if (!this.F)
    {
      this.m += Math.max(this.l, this.r);
      this.o += Math.max(this.l, this.r);
      int i1;
      int i2;
      if (this.v)
      {
        i1 = this.q / 2;
        i2 = this.o;
      }
      else
      {
        i1 = this.n;
        i2 = this.m;
      }
      this.k = (i1 - i2);
      this.F = true;
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.G)
    {
      this.i += paramInt;
      requestLayout();
      this.G = true;
    }
  }
  
  public void a(View paramView)
  {
    if ((DisplayUtil.c(paramView.getContext())) && (DisplayUtil.e(paramView.getContext())) && (QCirclePluginUtil.a((Activity)paramView.getContext()))) {
      this.j = DisplayUtil.b(paramView.getContext());
    } else {
      this.j = 0;
    }
    if ((this.p == 0) && (!this.v)) {
      return;
    }
    if (this.v)
    {
      this.p = 2;
      this.z = ObjectAnimator.ofInt(this, "ScrollY", new int[] { -this.t / 2, this.q / 2 - this.o }).setDuration(1500L);
      QLog.d("QCircleSlidBottomView", 4, "STATE_FIX");
    }
    else
    {
      this.p = 0;
      this.z = ObjectAnimator.ofInt(this, "ScrollY", new int[] { -this.t / 2, 0 }).setDuration(1500L);
      QLog.d("QCircleSlidBottomView", 4, "STATE_HALF");
    }
    this.u = paramView;
    setVisibility(0);
    this.z.addListener(new QCircleSlidBottomView.2(this));
    this.z.setInterpolator(this.a);
    this.z.start();
  }
  
  protected void b()
  {
    int i1 = getScrollY();
    i1 = this.s - i1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onend:");
    localStringBuilder.append(this.s);
    QLog.d("QCircleSlidBottomView", 4, localStringBuilder.toString());
    if (d())
    {
      if (i1 > 0)
      {
        if (Math.abs(i1) > this.t / 6.0F)
        {
          f();
          return;
        }
        e();
        return;
      }
      e();
      return;
    }
    if (c())
    {
      if (i1 > 0)
      {
        if (Math.abs(i1) > this.t / 6.0F)
        {
          f();
          return;
        }
        h();
        return;
      }
      if (Math.abs(i1) > this.t / 8.0F)
      {
        e();
        return;
      }
      h();
      return;
    }
    if (i1 > 0)
    {
      if (Math.abs(i1) > this.t / 2.0F)
      {
        f();
        return;
      }
      if (Math.abs(i1) > this.t / 6.0F)
      {
        h();
        return;
      }
      e();
    }
  }
  
  public boolean c()
  {
    return this.p == 0;
  }
  
  public boolean d()
  {
    return this.p == 2;
  }
  
  public void e()
  {
    int i2 = getScrollY();
    int i1 = 2;
    this.A = ObjectAnimator.ofInt(this, "ScrollY", new int[] { i2, this.k }).setDuration(1500L);
    this.A.setInterpolator(this.a);
    this.A.start();
    if (!this.v) {
      i1 = 1;
    }
    this.p = i1;
    Object localObject = (FrameLayout.LayoutParams)this.u.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).height = (this.t + d);
    this.u.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.w;
    if (localObject != null) {
      ((QCircleSlidBottomView.IStatusListener)localObject).a(this.p);
    }
  }
  
  public void f()
  {
    int i1 = getScrollY();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentY:");
    localStringBuilder.append(i1);
    QLog.d("QCircleSlidBottomView", 4, localStringBuilder.toString());
    this.B = ObjectAnimator.ofInt(this, "ScrollY", new int[] { i1, -this.t / 2 }).setDuration(200L);
    this.B.setInterpolator(this.b);
    this.B.addListener(new QCircleSlidBottomView.3(this));
    this.B.start();
    this.p = -1;
  }
  
  public boolean g()
  {
    return this.p != -1;
  }
  
  public int getNestedScrollAxes()
  {
    return this.e.getNestedScrollAxes();
  }
  
  public int getPanelHeight()
  {
    return this.t;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = getChildCount();
    paramInt3 = this.n;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (paramInt1 == 0) {
        localView.setPadding(0, 0, 0, this.i + this.j + d);
      }
      localView.layout(0, paramInt3, localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt3 + this.j + d);
      paramInt1 += 1;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    if ((paramView instanceof NestScrollRecyclerView))
    {
      int i1 = (int)paramFloat2;
      if (a(i1, (NestScrollRecyclerView)paramView))
      {
        a((int)paramFloat1, i1);
        paramView = new StringBuilder();
        paramView.append("fling:");
        paramView.append(paramFloat1);
        paramView.append(" ");
        paramView.append(paramFloat2);
        QLog.d("QCircleSlidBottomView", 4, paramView.toString());
        return true;
      }
    }
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (((paramView instanceof RecyclerView)) && (a(paramInt2, (RecyclerView)paramView)))
    {
      this.E = true;
      if ((getScrollY() + paramInt2 > this.k) && (paramInt2 > 0))
      {
        paramArrayOfInt[1] = paramInt2;
        return;
      }
      i();
      paramInt1 = this.f;
      if (paramInt2 > paramInt1 * 2) {
        scrollBy(0, paramInt1 * 2);
      } else if (paramInt2 < paramInt1 * -2) {
        scrollBy(0, paramInt1 * -2);
      } else {
        scrollBy(0, paramInt2);
      }
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.e.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    this.s = getScrollY();
    paramView1 = new StringBuilder();
    paramView1.append("onstart:");
    paramView1.append(this.s);
    QLog.d("QCircleSlidBottomView", 4, paramView1.toString());
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.e.onStopNestedScroll(paramView);
    if (!this.D) {
      b();
    }
    this.E = false;
  }
  
  public void setStatusListener(QCircleSlidBottomView.IStatusListener paramIStatusListener)
  {
    this.w = paramIStatusListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleSlidBottomView
 * JD-Core Version:    0.7.0.1
 */