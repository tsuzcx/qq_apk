package com.tencent.biz.videostory.capture.widgets;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public class RecyclerViewProxy
{
  private RecyclerView.LayoutManager a;
  
  public RecyclerViewProxy(@NonNull RecyclerView.LayoutManager paramLayoutManager)
  {
    this.a = paramLayoutManager;
  }
  
  public int a()
  {
    return this.a.getChildCount();
  }
  
  public View a(int paramInt)
  {
    return this.a.getChildAt(paramInt);
  }
  
  public View a(int paramInt, RecyclerView.Recycler paramRecycler)
  {
    paramRecycler = paramRecycler.getViewForPosition(paramInt);
    this.a.addView(paramRecycler);
    this.a.measureChildWithMargins(paramRecycler, 0, 0);
    return paramRecycler;
  }
  
  public void a(RecyclerView.Recycler paramRecycler)
  {
    this.a.detachAndScrapAttachedViews(paramRecycler);
  }
  
  public void a(RecyclerView.SmoothScroller paramSmoothScroller)
  {
    this.a.startSmoothScroll(paramSmoothScroller);
  }
  
  public void a(View paramView)
  {
    this.a.attachView(paramView);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    this.a.layoutDecorated(paramView, paramInt1 + localLayoutParams.leftMargin, paramInt2 + localLayoutParams.topMargin, paramInt3 - localLayoutParams.rightMargin, paramInt4 - localLayoutParams.bottomMargin);
  }
  
  public void a(View paramView, RecyclerView.Recycler paramRecycler)
  {
    this.a.detachAndScrapView(paramView, paramRecycler);
  }
  
  public int b()
  {
    return this.a.getItemCount();
  }
  
  public void b(int paramInt)
  {
    this.a.offsetChildrenHorizontal(paramInt);
  }
  
  public void b(RecyclerView.Recycler paramRecycler)
  {
    this.a.removeAndRecycleAllViews(paramRecycler);
  }
  
  public void b(View paramView)
  {
    this.a.detachView(paramView);
  }
  
  public void b(View paramView, RecyclerView.Recycler paramRecycler)
  {
    paramRecycler.recycleView(paramView);
  }
  
  public int c()
  {
    return this.a.getWidth();
  }
  
  public int c(View paramView)
  {
    return this.a.getPosition(paramView);
  }
  
  public void c(int paramInt)
  {
    this.a.offsetChildrenVertical(paramInt);
  }
  
  public int d()
  {
    return this.a.getHeight();
  }
  
  public int d(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return this.a.getDecoratedMeasuredWidth(paramView) + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
  }
  
  public int e(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return this.a.getDecoratedMeasuredHeight(paramView) + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin;
  }
  
  public void e()
  {
    this.a.requestLayout();
  }
  
  public void f()
  {
    this.a.removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.RecyclerViewProxy
 * JD-Core Version:    0.7.0.1
 */