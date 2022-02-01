package com.tencent.biz.videostory.widget.view.smartmusicview;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.State;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class CircleLayoutManager
  extends RecyclerView.LayoutManager
{
  private static float a = 45.0F;
  private static float b = 20.0F;
  private static int e = 1;
  private static int f = 2;
  private float c = 1.4F;
  private float d = 225.0F;
  private int g;
  private float h;
  private int i;
  private int j;
  private int k = 0;
  private float l;
  private int m;
  private int n;
  private SparseBooleanArray o = new SparseBooleanArray();
  private SparseArray<Float> p = new SparseArray();
  private int q;
  private int r;
  private boolean s = true;
  
  public CircleLayoutManager(Context paramContext, int paramInt)
  {
    this.g = paramInt;
    this.h = 0.0F;
    this.l = a;
    this.m = 180;
    this.n = 270;
    this.k = this.m;
  }
  
  private float a(float paramFloat)
  {
    if (Math.abs(paramFloat) >= this.m)
    {
      if (Math.abs(paramFloat) > this.n) {
        return 1.0F;
      }
      return (1.0F - Math.abs(paramFloat - this.d) / 45.0F) * (this.c - 1.0F) + 1.0F;
    }
    return 1.0F;
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    a(paramRecycler, paramState, f);
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (paramState.isPreLayout()) {
      return;
    }
    int i1 = 0;
    while (i1 < getChildCount())
    {
      paramState = getChildAt(i1);
      i2 = getPosition(paramState);
      if ((((Float)this.p.get(i2)).floatValue() - this.h > this.n) || (((Float)this.p.get(i2)).floatValue() - this.h < this.m))
      {
        this.o.put(i2, false);
        removeAndRecycleView(paramState, paramRecycler);
      }
      i1 += 1;
    }
    int i2 = getItemCount();
    i1 = 0;
    while (i1 < i2)
    {
      if ((this.p.get(i1) != null) && (((Float)this.p.get(i1)).floatValue() - this.h <= this.n + a) && (((Float)this.p.get(i1)).floatValue() - this.h >= this.m - a) && (!this.o.get(i1)))
      {
        paramState = (ViewGroup)paramRecycler.getViewForPosition(i1);
        View localView = paramState.getChildAt(0);
        measureChildWithMargins(paramState, 0, 0);
        if (paramInt == e) {
          addView(paramState, 0);
        } else {
          addView(paramState);
        }
        float f2 = ((Float)this.p.get(i1)).floatValue();
        float f1 = f2;
        if (i2 > 90.0F / a + 1.0F) {
          f1 = f2 - this.h;
        }
        int i3 = b(f1);
        int i4 = c(f1);
        paramState.setRotation(f1);
        int i5 = this.i;
        int i6 = this.j;
        layoutDecorated(paramState, i5 + i3, i6 + i4, i5 + i3 + this.q, i6 + i4 + this.r);
        localView.setRotation(-f1);
        this.o.put(i1, true);
        a(paramState, f1);
      }
      i1 += 1;
    }
  }
  
  private void a(ViewGroup paramViewGroup, float paramFloat)
  {
    if (this.s)
    {
      paramFloat = a(paramFloat);
      paramViewGroup.setScaleX(paramFloat);
      paramViewGroup.setScaleY(paramFloat);
    }
  }
  
  private int b(float paramFloat)
  {
    double d1 = this.g;
    double d2 = Math.cos(Math.toRadians(90.0F - paramFloat));
    Double.isNaN(d1);
    return (int)(d1 * d2);
  }
  
  private int c(float paramFloat)
  {
    double d1 = this.g;
    double d2 = Math.sin(Math.toRadians(90.0F - paramFloat));
    Double.isNaN(d1);
    return (int)(d1 * d2);
  }
  
  private void c()
  {
    if (this.h < 0.0F) {
      this.h = 0.0F;
    }
    if (this.h > d()) {
      this.h = d();
    }
  }
  
  private float d()
  {
    return (getItemCount() - 1) * this.l - 90.0F;
  }
  
  private int e()
  {
    return getWidth() - getPaddingRight() - getPaddingLeft();
  }
  
  private int f()
  {
    return getHeight() - getPaddingBottom() - getPaddingTop();
  }
  
  public int a()
  {
    return Math.round(this.h / this.l);
  }
  
  public PointF a(int paramInt)
  {
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {
      paramInt = -1;
    } else {
      paramInt = 1;
    }
    return new PointF(paramInt, 0.0F);
  }
  
  public void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public float b()
  {
    return this.c;
  }
  
  public int b(int paramInt)
  {
    return (int)((paramInt * this.l - this.h) * b);
  }
  
  public boolean canScrollHorizontally()
  {
    return true;
  }
  
  public boolean canScrollVertically()
  {
    return true;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2)
  {
    removeAllViews();
    this.h = 0.0F;
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      if ((paramState.getItemCount() > 0) && (!paramState.isPreLayout()))
      {
        View localView = paramRecycler.getViewForPosition(0);
        addView(localView);
        measureChildWithMargins(localView, 0, 0);
        this.q = getDecoratedMeasuredWidth(localView);
        this.r = getDecoratedMeasuredHeight(localView);
        this.i = (e() - this.q);
        this.j = (f() - this.r);
        float f1 = this.k;
        int i1 = 0;
        while (i1 < getItemCount())
        {
          this.p.put(i1, Float.valueOf(f1));
          this.o.put(i1, false);
          f1 += this.l;
          i1 += 1;
        }
        detachAndScrapAttachedViews(paramRecycler);
        c();
        a(paramRecycler, paramState);
        return;
      }
      this.h = 0.0F;
      if (paramState.getItemCount() == 0) {
        removeAndRecycleAllViews(paramRecycler);
      }
      return;
    }
    catch (IndexOutOfBoundsException paramRecycler)
    {
      paramRecycler.printStackTrace();
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (90.0F / a + 1.0F >= getItemCount()) {
      return 0;
    }
    int i1 = -paramInt;
    float f2 = i1;
    float f1 = b;
    float f3 = f2 / f1;
    f2 = this.h;
    f3 += f2;
    if (f3 < 0.0F) {}
    for (f1 = -f2 * f1;; f1 = (d() - this.h) * b)
    {
      i1 = (int)f1;
      break;
      if (f3 <= d()) {
        break;
      }
    }
    f1 = i1 / b;
    this.h += f1;
    int i2 = 0;
    while (i2 < getChildCount())
    {
      ViewGroup localViewGroup = (ViewGroup)getChildAt(i2);
      View localView = localViewGroup.getChildAt(0);
      f2 = localViewGroup.getRotation() - f1;
      int i3 = b(f2);
      int i4 = c(f2);
      localViewGroup.setRotation(f2);
      int i5 = this.i;
      int i6 = this.j;
      layoutDecorated(localViewGroup, i5 + i3, i6 + i4, i5 + i3 + this.q, i6 + i4 + this.r);
      localView.setRotation(-f2);
      a(localViewGroup, f2);
      i2 += 1;
    }
    if (paramInt > 0)
    {
      a(paramRecycler, paramState, e);
      return i1;
    }
    a(paramRecycler, paramState, f);
    return i1;
  }
  
  public void scrollToPosition(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= getItemCount() - 1))
    {
      float f1 = paramInt * this.l;
      if (f1 != this.h)
      {
        this.h = f1;
        c();
        requestLayout();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("scrollToPosition pos:");
        localStringBuilder.append(paramInt);
        Log.i("EditVideoSmartMusicPart", localStringBuilder.toString());
      }
    }
    EventCollector.getInstance().onRecyclerViewScrollToPosition(this);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return scrollHorizontallyBy(-paramInt, paramRecycler, paramState);
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    paramRecyclerView = new CircleLayoutManager.1(this, paramRecyclerView.getContext());
    paramRecyclerView.setTargetPosition(paramInt);
    paramState = new StringBuilder();
    paramState.append("smoothScrollToPosition pos:");
    paramState.append(paramInt);
    Log.i("EditVideoSmartMusicPart", paramState.toString());
    startSmoothScroll(paramRecyclerView);
  }
  
  public void startSmoothScroll(RecyclerView.SmoothScroller paramSmoothScroller)
  {
    super.startSmoothScroll(paramSmoothScroller);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.CircleLayoutManager
 * JD-Core Version:    0.7.0.1
 */