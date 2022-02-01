package com.tencent.biz.richframework.part.block.base;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.qphone.base.util.QLog;

@SuppressLint({"ClickableViewAccessibility"})
public class QCirclePagerSnapHelper
{
  private RecyclerView a;
  private LinearLayoutManager b;
  private QCirclePagerSnapHelper.PagerChangeListener c;
  private QCirclePagerSnapHelper.TouchEventProcessor d;
  private QCirclePagerSnapHelper.OnLayoutChangedListenerImpl e;
  private QCirclePagerSnapHelper.OnLayoutSizeChangedListener f;
  private OrientationHelper g;
  private OrientationHelper h;
  private int i;
  private int j;
  private int k;
  private boolean l;
  private boolean m;
  private int n;
  private int o;
  private boolean p;
  private boolean q;
  private float r;
  private boolean s;
  private boolean t;
  
  public QCirclePagerSnapHelper()
  {
    this(0, 25.0F);
  }
  
  public QCirclePagerSnapHelper(int paramInt, float paramFloat)
  {
    c();
    this.n = paramInt;
    this.r = paramFloat;
  }
  
  private int a(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    if (this.n != 1) {
      return c(paramLinearLayoutManager, paramView, paramOrientationHelper);
    }
    return b(paramLinearLayoutManager, paramView, paramOrientationHelper);
  }
  
  private int a(LinearLayoutManager paramLinearLayoutManager, OrientationHelper paramOrientationHelper)
  {
    int i1;
    if (paramLinearLayoutManager.getClipToPadding()) {
      i1 = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;
    } else {
      i1 = paramOrientationHelper.getEnd() / 2;
    }
    return i1 + this.o;
  }
  
  private int a(OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getStartAfterPadding() + this.o;
  }
  
  private int a(RecyclerView.LayoutManager paramLayoutManager)
  {
    return paramLayoutManager.getItemCount() - this.i - 1;
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      Object localObject = this.a;
      if ((localObject != null) && (this.b != null))
      {
        localObject = ((RecyclerView)localObject).getChildViewHolder(paramView);
        int i1 = this.b.getPosition(paramView);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("dispatchPagerChanged: position=");
          localStringBuilder.append(i1);
          localStringBuilder.append(", centerPosition=");
          localStringBuilder.append(this.k);
          localStringBuilder.append(", reset=");
          localStringBuilder.append(paramBoolean);
          localStringBuilder.append(", isRealIdle=");
          localStringBuilder.append(this.s);
          localStringBuilder.append(", isNeedCallPageIdle=");
          localStringBuilder.append(this.t);
          QLog.d("PagerSnapHelper", 2, localStringBuilder.toString());
        }
        if ((localObject != null) && (i1 != -1))
        {
          if ((i1 != this.k) || (paramBoolean))
          {
            if (a(i1, this.b)) {
              return;
            }
            this.k = i1;
            this.t = true;
            if (this.c != null)
            {
              TraceCompat.beginSection("onPagerChanged");
              this.c.a((RecyclerView.ViewHolder)localObject);
              TraceCompat.endSection();
            }
          }
          if ((this.s) && (this.t) && (this.c != null))
          {
            this.t = false;
            paramView = this.a.getChildViewHolder(paramView);
            TraceCompat.beginSection("onPagerIdle");
            this.c.b(paramView);
            TraceCompat.endSection();
          }
        }
      }
    }
  }
  
  private boolean a(int paramInt, RecyclerView.LayoutManager paramLayoutManager)
  {
    int i1 = a(paramLayoutManager);
    return (paramInt < i()) || (paramInt > i1);
  }
  
  private boolean a(@NonNull LinearLayoutManager paramLinearLayoutManager, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    if (paramLinearLayoutManager.getItemCount() == 0) {
      return false;
    }
    View localView = a(paramLinearLayoutManager);
    if (localView == null) {
      return false;
    }
    int i1 = paramLinearLayoutManager.getPosition(localView);
    if (i1 == -1) {
      return false;
    }
    int i2 = c(i1);
    int i3 = h();
    boolean bool = paramLinearLayoutManager.canScrollHorizontally();
    i1 = 1;
    if (bool)
    {
      if (Math.abs(paramFloat1) > i3 ? paramFloat1 > 0.0F : paramFloat3 > 0.0F) {}
    }
    else {
      while (Math.abs(paramFloat2) > i3 ? paramFloat2 <= 0.0F : paramFloat4 <= 0.0F)
      {
        i1 = 0;
        break;
      }
    }
    if ((paramInt != -1) && (i2 != paramInt)) {
      paramInt = i2;
    } else if (i1 != 0) {
      paramInt = i2 + 1;
    } else {
      paramInt = i2 - 1;
    }
    if (paramInt == -1) {
      return false;
    }
    paramInt = c(paramInt);
    if (QLog.isColorLevel())
    {
      paramLinearLayoutManager = new StringBuilder();
      paramLinearLayoutManager.append("snapFromFling: position=");
      paramLinearLayoutManager.append(paramInt);
      QLog.d("PagerSnapHelper", 2, paramLinearLayoutManager.toString());
    }
    return a(paramInt);
  }
  
  @NonNull
  private int[] a(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLinearLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = a(paramLinearLayoutManager, paramView, b(paramLinearLayoutManager));
    } else {
      arrayOfInt[0] = 0;
    }
    if (paramLinearLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = a(paramLinearLayoutManager, paramView, b(paramLinearLayoutManager));
      return arrayOfInt;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  private int b(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) - a(paramOrientationHelper);
  }
  
  private void b(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView != null) && (paramRecyclerView.getAdapter() != null) && (paramRecyclerView.getLayoutManager() != null))
    {
      if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
        return;
      }
      throw new IllegalStateException("PagerSnapHelper can only attach to the RecyclerView with LinearLayoutManager");
    }
    throw new IllegalStateException("PagerSnapHelper can't attach to the RecyclerView before setup Adapter or LayoutManager");
  }
  
  private int c(int paramInt)
  {
    int i1 = i();
    int i2 = a(this.b);
    if (paramInt < i1) {
      return i1;
    }
    i1 = paramInt;
    if (paramInt > i2) {
      i1 = i2;
    }
    return i1;
  }
  
  private int c(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) + paramOrientationHelper.getDecoratedMeasurement(paramView) / 2 - a(paramLinearLayoutManager, paramOrientationHelper);
  }
  
  private void c()
  {
    this.i = 0;
    this.j = 0;
    this.k = -1;
    this.l = false;
    this.m = false;
    this.t = false;
    this.s = true;
    this.p = true;
    this.q = true;
  }
  
  private void d()
  {
    QCirclePagerSnapHelper.PagerChangeListener localPagerChangeListener = this.c;
    if (localPagerChangeListener != null)
    {
      localPagerChangeListener.b();
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: onFooterRebound");
      }
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: onHeaderRebound");
    }
  }
  
  private void f()
  {
    if (this.a.getOnFlingListener() == null)
    {
      this.d = new QCirclePagerSnapHelper.TouchEventProcessor(this, null);
      this.e = new QCirclePagerSnapHelper.OnLayoutChangedListenerImpl(this, null);
      this.f = new QCirclePagerSnapHelper.OnLayoutSizeChangedListener(this, null);
      this.a.setOnTouchListener(this.d);
      this.a.addOnScrollListener(this.d);
      this.a.setOnFlingListener(this.d.a());
      this.a.addOnLayoutChangeListener(this.e);
      this.a.addOnLayoutChangeListener(this.f);
      this.a.getAdapter().registerAdapterDataObserver(new QCirclePagerSnapHelper.1(this));
      return;
    }
    throw new IllegalStateException("An instance of OnFlingListener already set.");
  }
  
  private void g()
  {
    this.a.removeOnScrollListener(this.d);
    this.a.setOnFlingListener(null);
  }
  
  private int h()
  {
    return ViewConfiguration.get(this.a.getContext()).getScaledTouchSlop();
  }
  
  private int i()
  {
    return this.j;
  }
  
  @Nullable
  public View a(LinearLayoutManager paramLinearLayoutManager)
  {
    int i5 = paramLinearLayoutManager.getChildCount();
    Object localObject1 = null;
    if (i5 == 0) {
      return null;
    }
    OrientationHelper localOrientationHelper = b(paramLinearLayoutManager);
    int i2 = 2147483647;
    int i1 = 0;
    while (i1 < i5)
    {
      View localView = paramLinearLayoutManager.getChildAt(i1);
      int i4 = Math.abs(a(paramLinearLayoutManager, localView, localOrientationHelper));
      Object localObject2;
      int i3;
      if (i4 >= i2)
      {
        localObject2 = localObject1;
        i3 = i2;
        if (this.n == 1)
        {
          localObject2 = localObject1;
          i3 = i2;
          if (paramLinearLayoutManager.getPosition(localView) == paramLinearLayoutManager.getItemCount() - 1)
          {
            localObject2 = localObject1;
            i3 = i2;
            if (paramLinearLayoutManager.findLastCompletelyVisibleItemPosition() != paramLinearLayoutManager.getItemCount() - 1) {}
          }
        }
      }
      else
      {
        localObject2 = localView;
        i3 = i4;
      }
      i1 += 1;
      localObject1 = localObject2;
      i2 = i3;
    }
    return localObject1;
  }
  
  public void a(@Nullable RecyclerView paramRecyclerView)
  {
    RecyclerView localRecyclerView = this.a;
    if (localRecyclerView == paramRecyclerView) {
      return;
    }
    if (localRecyclerView != null) {
      g();
    }
    this.a = paramRecyclerView;
    paramRecyclerView = this.a;
    if (paramRecyclerView != null)
    {
      b(paramRecyclerView);
      this.b = ((LinearLayoutManager)this.a.getLayoutManager());
      f();
      a();
    }
  }
  
  public void a(QCirclePagerSnapHelper.PagerChangeListener paramPagerChangeListener)
  {
    this.c = paramPagerChangeListener;
  }
  
  public boolean a()
  {
    if (this.a != null)
    {
      Object localObject = this.b;
      if (localObject == null) {
        return false;
      }
      localObject = a((LinearLayoutManager)localObject);
      if (localObject == null) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("snapToCenterPosition: findCenterView=");
        localStringBuilder.append(this.b.getPosition((View)localObject));
        QLog.d("PagerSnapHelper", 2, localStringBuilder.toString());
      }
      return a((View)localObject);
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    if (a(paramInt, this.b)) {
      return false;
    }
    View localView = this.b.findViewByPosition(paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("snapToTargetPosition: position=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", view=");
      ((StringBuilder)localObject).append(localView);
      QLog.d("PagerSnapHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (localView == null)
    {
      this.a.smoothScrollToPosition(paramInt);
      this.l = true;
      return true;
    }
    Object localObject = a(this.b, localView);
    int i1 = localObject[0];
    int i2 = localObject[1];
    if ((i1 == 0) && (i2 == 0)) {
      return false;
    }
    localObject = c(this.b);
    ((RecyclerView.SmoothScroller)localObject).setTargetPosition(paramInt);
    this.b.startSmoothScroll((RecyclerView.SmoothScroller)localObject);
    this.l = true;
    if (this.m) {
      a(localView, false);
    }
    if ((paramInt == a(this.b)) && ((i1 < 0) || (i2 < 0)))
    {
      d();
      return true;
    }
    if ((paramInt == i()) && ((i1 > 0) || (i2 > 0))) {
      e();
    }
    return true;
  }
  
  public boolean a(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    int i1 = this.b.getPosition(paramView);
    if (i1 == -1) {
      return false;
    }
    return a(c(i1));
  }
  
  @NonNull
  protected OrientationHelper b(LinearLayoutManager paramLinearLayoutManager)
  {
    if (paramLinearLayoutManager.canScrollVertically())
    {
      if (this.g == null) {
        this.g = OrientationHelper.createOrientationHelper(paramLinearLayoutManager, 1);
      }
      return this.g;
    }
    if (this.h == null) {
      this.h = OrientationHelper.createOrientationHelper(paramLinearLayoutManager, 0);
    }
    return this.h;
  }
  
  public void b()
  {
    this.a.addOnLayoutChangeListener(this.e);
  }
  
  public void b(int paramInt)
  {
    if (this.a != null)
    {
      LinearLayoutManager localLinearLayoutManager = this.b;
      if (localLinearLayoutManager == null) {
        return;
      }
      b(localLinearLayoutManager.findViewByPosition(paramInt));
    }
  }
  
  public void b(View paramView)
  {
    if (this.a != null)
    {
      LinearLayoutManager localLinearLayoutManager = this.b;
      if (localLinearLayoutManager == null) {
        return;
      }
      if (paramView == null) {
        return;
      }
      if (a(localLinearLayoutManager.getPosition(paramView), this.b)) {
        return;
      }
      if (paramView != null)
      {
        paramView = a(this.b, paramView);
        if ((paramView[0] != 0) || (paramView[1] != 0)) {
          this.a.scrollBy(paramView[0], paramView[1]);
        }
      }
    }
  }
  
  protected LinearSmoothScroller c(LinearLayoutManager paramLinearLayoutManager)
  {
    return new QCirclePagerSnapHelper.2(this, this.a.getContext(), paramLinearLayoutManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper
 * JD-Core Version:    0.7.0.1
 */