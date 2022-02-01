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
  private static float jdField_a_of_type_Float = 45.0F;
  private static int jdField_a_of_type_Int = 1;
  private static float jdField_b_of_type_Float = 20.0F;
  private static int jdField_b_of_type_Int = 2;
  private SparseArray<Float> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_c_of_type_Float = 1.4F;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float = 225.0F;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = 0;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public CircleLayoutManager(Context paramContext, int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_e_of_type_Float = 0.0F;
    this.jdField_f_of_type_Float = jdField_a_of_type_Float;
    this.g = 180;
    this.h = 270;
    this.jdField_f_of_type_Int = this.g;
  }
  
  private float a(float paramFloat)
  {
    if (Math.abs(paramFloat) >= this.g)
    {
      if (Math.abs(paramFloat) > this.h) {
        return 1.0F;
      }
      return (1.0F - Math.abs(paramFloat - this.jdField_d_of_type_Float) / 45.0F) * (this.jdField_c_of_type_Float - 1.0F) + 1.0F;
    }
    return 1.0F;
  }
  
  private int a(float paramFloat)
  {
    double d1 = this.jdField_c_of_type_Int;
    double d2 = Math.cos(Math.toRadians(90.0F - paramFloat));
    Double.isNaN(d1);
    return (int)(d1 * d2);
  }
  
  private void a()
  {
    if (this.jdField_e_of_type_Float < 0.0F) {
      this.jdField_e_of_type_Float = 0.0F;
    }
    if (this.jdField_e_of_type_Float > b()) {
      this.jdField_e_of_type_Float = b();
    }
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    a(paramRecycler, paramState, jdField_b_of_type_Int);
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (paramState.isPreLayout()) {
      return;
    }
    int k = 0;
    while (k < getChildCount())
    {
      paramState = getChildAt(k);
      m = getPosition(paramState);
      if ((((Float)this.jdField_a_of_type_AndroidUtilSparseArray.get(m)).floatValue() - this.jdField_e_of_type_Float > this.h) || (((Float)this.jdField_a_of_type_AndroidUtilSparseArray.get(m)).floatValue() - this.jdField_e_of_type_Float < this.g))
      {
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(m, false);
        removeAndRecycleView(paramState, paramRecycler);
      }
      k += 1;
    }
    int m = getItemCount();
    k = 0;
    while (k < m)
    {
      if ((this.jdField_a_of_type_AndroidUtilSparseArray.get(k) != null) && (((Float)this.jdField_a_of_type_AndroidUtilSparseArray.get(k)).floatValue() - this.jdField_e_of_type_Float <= this.h + jdField_a_of_type_Float) && (((Float)this.jdField_a_of_type_AndroidUtilSparseArray.get(k)).floatValue() - this.jdField_e_of_type_Float >= this.g - jdField_a_of_type_Float) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(k)))
      {
        paramState = (ViewGroup)paramRecycler.getViewForPosition(k);
        View localView = paramState.getChildAt(0);
        measureChildWithMargins(paramState, 0, 0);
        if (paramInt == jdField_a_of_type_Int) {
          addView(paramState, 0);
        } else {
          addView(paramState);
        }
        float f2 = ((Float)this.jdField_a_of_type_AndroidUtilSparseArray.get(k)).floatValue();
        float f1 = f2;
        if (m > 90.0F / jdField_a_of_type_Float + 1.0F) {
          f1 = f2 - this.jdField_e_of_type_Float;
        }
        int n = a(f1);
        int i1 = b(f1);
        paramState.setRotation(f1);
        int i2 = this.jdField_d_of_type_Int;
        int i3 = this.jdField_e_of_type_Int;
        layoutDecorated(paramState, i2 + n, i3 + i1, i2 + n + this.i, i3 + i1 + this.j);
        localView.setRotation(-f1);
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(k, true);
        a(paramState, f1);
      }
      k += 1;
    }
  }
  
  private void a(ViewGroup paramViewGroup, float paramFloat)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramFloat = a(paramFloat);
      paramViewGroup.setScaleX(paramFloat);
      paramViewGroup.setScaleY(paramFloat);
    }
  }
  
  private float b()
  {
    return (getItemCount() - 1) * this.jdField_f_of_type_Float - 90.0F;
  }
  
  private int b()
  {
    return getWidth() - getPaddingRight() - getPaddingLeft();
  }
  
  private int b(float paramFloat)
  {
    double d1 = this.jdField_c_of_type_Int;
    double d2 = Math.sin(Math.toRadians(90.0F - paramFloat));
    Double.isNaN(d1);
    return (int)(d1 * d2);
  }
  
  private int c()
  {
    return getHeight() - getPaddingBottom() - getPaddingTop();
  }
  
  public float a()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public int a()
  {
    return Math.round(this.jdField_e_of_type_Float / this.jdField_f_of_type_Float);
  }
  
  public int a(int paramInt)
  {
    return (int)((paramInt * this.jdField_f_of_type_Float - this.jdField_e_of_type_Float) * jdField_b_of_type_Float);
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
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    this.jdField_e_of_type_Float = 0.0F;
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
        this.i = getDecoratedMeasuredWidth(localView);
        this.j = getDecoratedMeasuredHeight(localView);
        this.jdField_d_of_type_Int = (b() - this.i);
        this.jdField_e_of_type_Int = (c() - this.j);
        float f1 = this.jdField_f_of_type_Int;
        int k = 0;
        while (k < getItemCount())
        {
          this.jdField_a_of_type_AndroidUtilSparseArray.put(k, Float.valueOf(f1));
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(k, false);
          f1 += this.jdField_f_of_type_Float;
          k += 1;
        }
        detachAndScrapAttachedViews(paramRecycler);
        a();
        a(paramRecycler, paramState);
        return;
      }
      this.jdField_e_of_type_Float = 0.0F;
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
    if (90.0F / jdField_a_of_type_Float + 1.0F >= getItemCount()) {
      return 0;
    }
    int k = -paramInt;
    float f2 = k;
    float f1 = jdField_b_of_type_Float;
    float f3 = f2 / f1;
    f2 = this.jdField_e_of_type_Float;
    f3 += f2;
    if (f3 < 0.0F) {}
    for (f1 = -f2 * f1;; f1 = (b() - this.jdField_e_of_type_Float) * jdField_b_of_type_Float)
    {
      k = (int)f1;
      break;
      if (f3 <= b()) {
        break;
      }
    }
    f1 = k / jdField_b_of_type_Float;
    this.jdField_e_of_type_Float += f1;
    int m = 0;
    while (m < getChildCount())
    {
      ViewGroup localViewGroup = (ViewGroup)getChildAt(m);
      View localView = localViewGroup.getChildAt(0);
      f2 = localViewGroup.getRotation() - f1;
      int n = a(f2);
      int i1 = b(f2);
      localViewGroup.setRotation(f2);
      int i2 = this.jdField_d_of_type_Int;
      int i3 = this.jdField_e_of_type_Int;
      layoutDecorated(localViewGroup, i2 + n, i3 + i1, i2 + n + this.i, i3 + i1 + this.j);
      localView.setRotation(-f2);
      a(localViewGroup, f2);
      m += 1;
    }
    if (paramInt > 0)
    {
      a(paramRecycler, paramState, jdField_a_of_type_Int);
      return k;
    }
    a(paramRecycler, paramState, jdField_b_of_type_Int);
    return k;
  }
  
  public void scrollToPosition(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= getItemCount() - 1))
    {
      float f1 = paramInt * this.jdField_f_of_type_Float;
      if (f1 != this.jdField_e_of_type_Float)
      {
        this.jdField_e_of_type_Float = f1;
        a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.CircleLayoutManager
 * JD-Core Version:    0.7.0.1
 */