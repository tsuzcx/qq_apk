package com.tencent.biz.richframework.part.block.base;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import androidx.recyclerview.widget.RecyclerView.State;

public class GalleryLayoutManager
  extends RecyclerView.LayoutManager
  implements RecyclerView.SmoothScroller.ScrollVectorProvider
{
  int a = -1;
  View b;
  RecyclerView c;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private GalleryLayoutManager.State g;
  private LinearSnapHelper h = new LinearSnapHelper();
  private GalleryLayoutManager.InnerScrollListener i = new GalleryLayoutManager.InnerScrollListener(this, null);
  private boolean j = false;
  private int k = 0;
  private OrientationHelper l;
  private OrientationHelper m;
  private GalleryLayoutManager.ItemTransformer n;
  private GalleryLayoutManager.OnItemSelectedListener o;
  
  public GalleryLayoutManager(int paramInt)
  {
    this.k = paramInt;
  }
  
  private float a(View paramView, float paramFloat)
  {
    int i2 = b(paramView, paramFloat);
    int i1;
    if (this.k == 0) {
      i1 = paramView.getWidth();
    } else {
      i1 = paramView.getHeight();
    }
    return Math.max(-1.0F, Math.min(1.0F, i2 * 1.0F / i1));
  }
  
  private int a(int paramInt)
  {
    if (getChildCount() == 0) {
      return -1;
    }
    if (paramInt < this.d) {
      return -1;
    }
    return 1;
  }
  
  private void a(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect();
    int i1 = e();
    while ((paramInt1 >= 0) && (paramInt2 > paramInt3))
    {
      View localView = paramRecycler.getViewForPosition(paramInt1);
      addView(localView, 0);
      measureChildWithMargins(localView, 0, 0);
      int i2 = getDecoratedMeasuredWidth(localView);
      int i3 = getDecoratedMeasuredHeight(localView);
      int i4 = (int)(getPaddingTop() + (i1 - i3) / 2.0F);
      localRect.set(paramInt2 - i2, i4, paramInt2, i3 + i4);
      layoutDecorated(localView, localRect.left, localRect.top, localRect.right, localRect.bottom);
      paramInt2 = localRect.left;
      this.d = paramInt1;
      if (a().a.get(paramInt1) == null) {
        a().a.put(paramInt1, localRect);
      } else {
        ((Rect)a().a.get(paramInt1)).set(localRect);
      }
      paramInt1 -= 1;
    }
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    detachAndScrapAttachedViews(paramRecycler);
    int i1 = b().getStartAfterPadding();
    int i2 = b().getEndAfterPadding();
    int i3 = this.f;
    paramState = new Rect();
    int i6 = e();
    View localView = paramRecycler.getViewForPosition(this.f);
    addView(localView, 0);
    measureChildWithMargins(localView, 0, 0);
    int i4 = getDecoratedMeasuredWidth(localView);
    int i5 = getDecoratedMeasuredHeight(localView);
    i6 = (int)(getPaddingTop() + (i6 - i5) / 2.0F);
    int i7 = (int)(getPaddingLeft() + (d() - i4) / 2.0F);
    paramState.set(i7, i6, i4 + i7, i5 + i6);
    layoutDecorated(localView, paramState.left, paramState.top, paramState.right, paramState.bottom);
    if (a().a.get(i3) == null) {
      a().a.put(i3, paramState);
    } else {
      ((Rect)a().a.get(i3)).set(paramState);
    }
    this.e = i3;
    this.d = i3;
    i3 = getDecoratedLeft(localView);
    i4 = getDecoratedRight(localView);
    a(paramRecycler, this.f - 1, i3, i1);
    b(paramRecycler, this.f + 1, i4, i2);
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (this.k == 0) {
      a(paramRecycler, paramState);
    } else {
      b(paramRecycler, paramState);
    }
    if (this.n != null)
    {
      int i1 = 0;
      while (i1 < getChildCount())
      {
        paramRecycler = getChildAt(i1);
        this.n.a(this, paramRecycler, a(paramRecycler, paramInt));
        i1 += 1;
      }
    }
    this.i.onScrolled(this.c, 0, 0);
  }
  
  private int b(View paramView, float paramFloat)
  {
    OrientationHelper localOrientationHelper = b();
    int i2 = (localOrientationHelper.getEndAfterPadding() - localOrientationHelper.getStartAfterPadding()) / 2;
    int i3 = localOrientationHelper.getStartAfterPadding();
    if (this.k == 0) {
      paramFloat = paramView.getWidth() / 2 - paramFloat;
    }
    for (int i1 = paramView.getLeft();; i1 = paramView.getTop())
    {
      return (int)(paramFloat + i1 - (i2 + i3));
      paramFloat = paramView.getHeight() / 2 - paramFloat;
    }
  }
  
  private void b(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect();
    int i1 = e();
    while ((paramInt1 < getItemCount()) && (paramInt2 < paramInt3))
    {
      View localView = paramRecycler.getViewForPosition(paramInt1);
      addView(localView);
      measureChildWithMargins(localView, 0, 0);
      int i2 = getDecoratedMeasuredWidth(localView);
      int i3 = getDecoratedMeasuredHeight(localView);
      int i4 = (int)(getPaddingTop() + (i1 - i3) / 2.0F);
      localRect.set(paramInt2, i4, i2 + paramInt2, i3 + i4);
      layoutDecorated(localView, localRect.left, localRect.top, localRect.right, localRect.bottom);
      paramInt2 = localRect.right;
      this.e = paramInt1;
      if (a().a.get(paramInt1) == null) {
        a().a.put(paramInt1, localRect);
      } else {
        ((Rect)a().a.get(paramInt1)).set(localRect);
      }
      paramInt1 += 1;
    }
  }
  
  private void b(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    detachAndScrapAttachedViews(paramRecycler);
    int i1 = b().getStartAfterPadding();
    int i2 = b().getEndAfterPadding();
    int i3 = this.f;
    paramState = new Rect();
    int i6 = d();
    View localView = paramRecycler.getViewForPosition(this.f);
    addView(localView, 0);
    measureChildWithMargins(localView, 0, 0);
    int i4 = getDecoratedMeasuredWidth(localView);
    int i5 = getDecoratedMeasuredHeight(localView);
    i6 = (int)(getPaddingLeft() + (i6 - i4) / 2.0F);
    int i7 = (int)(getPaddingTop() + (e() - i5) / 2.0F);
    paramState.set(i6, i7, i4 + i6, i5 + i7);
    layoutDecorated(localView, paramState.left, paramState.top, paramState.right, paramState.bottom);
    if (a().a.get(i3) == null) {
      a().a.put(i3, paramState);
    } else {
      ((Rect)a().a.get(i3)).set(paramState);
    }
    this.e = i3;
    this.d = i3;
    i3 = getDecoratedTop(localView);
    i4 = getDecoratedBottom(localView);
    c(paramRecycler, this.f - 1, i3, i1);
    d(paramRecycler, this.f + 1, i4, i2);
  }
  
  private void b(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (getItemCount() == 0) {
      return;
    }
    if (this.k == 0) {
      d(paramRecycler, paramState, paramInt);
    } else {
      c(paramRecycler, paramState, paramInt);
    }
    if (this.n != null)
    {
      int i1 = 0;
      while (i1 < getChildCount())
      {
        paramRecycler = getChildAt(i1);
        this.n.a(this, paramRecycler, a(paramRecycler, paramInt));
        i1 += 1;
      }
    }
  }
  
  private void c()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((GalleryLayoutManager.State)localObject).a.clear();
    }
    int i1 = this.a;
    if (i1 != -1) {
      this.f = i1;
    }
    this.f = Math.min(Math.max(0, this.f), getItemCount() - 1);
    i1 = this.f;
    this.d = i1;
    this.e = i1;
    this.a = -1;
    localObject = this.b;
    if (localObject != null)
    {
      ((View)localObject).setSelected(false);
      this.b = null;
    }
  }
  
  private void c(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect();
    int i1 = d();
    while ((paramInt1 >= 0) && (paramInt2 > paramInt3))
    {
      View localView = paramRecycler.getViewForPosition(paramInt1);
      addView(localView, 0);
      measureChildWithMargins(localView, 0, 0);
      int i2 = getDecoratedMeasuredWidth(localView);
      int i3 = getDecoratedMeasuredHeight(localView);
      int i4 = (int)(getPaddingLeft() + (i1 - i2) / 2.0F);
      localRect.set(i4, paramInt2 - i3, i2 + i4, paramInt2);
      layoutDecorated(localView, localRect.left, localRect.top, localRect.right, localRect.bottom);
      paramInt2 = localRect.top;
      this.d = paramInt1;
      if (a().a.get(paramInt1) == null) {
        a().a.put(paramInt1, localRect);
      } else {
        ((Rect)a().a.get(paramInt1)).set(localRect);
      }
      paramInt1 -= 1;
    }
  }
  
  private void c(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    int i6 = b().getStartAfterPadding();
    int i5 = b().getEndAfterPadding();
    if (getChildCount() > 0)
    {
      if (paramInt >= 0)
      {
        i1 = 0;
        i2 = 0;
        while (i1 < getChildCount())
        {
          paramState = getChildAt(i1 + i2);
          if (getDecoratedBottom(paramState) - paramInt >= i6) {
            break;
          }
          removeAndRecycleView(paramState, paramRecycler);
          this.d += 1;
          i2 -= 1;
          i1 += 1;
        }
      }
      i1 = getChildCount() - 1;
      while (i1 >= 0)
      {
        paramState = getChildAt(i1);
        if (getDecoratedTop(paramState) - paramInt <= i5) {
          break;
        }
        removeAndRecycleView(paramState, paramRecycler);
        this.e -= 1;
        i1 -= 1;
      }
    }
    int i2 = this.d;
    int i4 = d();
    int i1 = -1;
    Rect localRect;
    View localView;
    int i7;
    if (paramInt >= 0)
    {
      if (getChildCount() != 0)
      {
        paramState = getChildAt(getChildCount() - 1);
        i1 = getPosition(paramState);
        i2 = getDecoratedBottom(paramState);
        i1 += 1;
      }
      else
      {
        i1 = i2;
        i2 = -1;
      }
      i3 = i1;
      while ((i3 < getItemCount()) && (i2 < i5 + paramInt))
      {
        localRect = (Rect)a().a.get(i3);
        localView = paramRecycler.getViewForPosition(i3);
        addView(localView);
        paramState = localRect;
        if (localRect == null)
        {
          paramState = new Rect();
          a().a.put(i3, paramState);
        }
        measureChildWithMargins(localView, 0, 0);
        i6 = getDecoratedMeasuredWidth(localView);
        i7 = getDecoratedMeasuredHeight(localView);
        int i8 = (int)(getPaddingLeft() + (i4 - i6) / 2.0F);
        if ((i2 == -1) && (i1 == 0))
        {
          i2 = (int)(getPaddingTop() + (e() - i7) / 2.0F);
          paramState.set(i8, i2, i6 + i8, i7 + i2);
        }
        else
        {
          paramState.set(i8, i2, i6 + i8, i7 + i2);
        }
        layoutDecorated(localView, paramState.left, paramState.top, paramState.right, paramState.bottom);
        i2 = paramState.bottom;
        this.e = i3;
        i3 += 1;
      }
    }
    if (getChildCount() > 0)
    {
      paramState = getChildAt(0);
      i2 = getPosition(paramState);
      i1 = getDecoratedTop(paramState);
      i2 -= 1;
    }
    int i3 = i2;
    i2 = i1;
    i1 = i3;
    while ((i1 >= 0) && (i2 > i6 + paramInt))
    {
      localRect = (Rect)a().a.get(i1);
      localView = paramRecycler.getViewForPosition(i1);
      addView(localView, 0);
      paramState = localRect;
      if (localRect == null)
      {
        paramState = new Rect();
        a().a.put(i1, paramState);
      }
      measureChildWithMargins(localView, 0, 0);
      i3 = getDecoratedMeasuredWidth(localView);
      i5 = getDecoratedMeasuredHeight(localView);
      i7 = (int)(getPaddingLeft() + (i4 - i3) / 2.0F);
      paramState.set(i7, i2 - i5, i3 + i7, i2);
      layoutDecorated(localView, paramState.left, paramState.top, paramState.right, paramState.bottom);
      i2 = paramState.top;
      this.d = i1;
      i1 -= 1;
    }
  }
  
  private int d()
  {
    return getWidth() - getPaddingRight() - getPaddingLeft();
  }
  
  private void d(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect();
    int i1 = d();
    while ((paramInt1 < getItemCount()) && (paramInt2 < paramInt3))
    {
      View localView = paramRecycler.getViewForPosition(paramInt1);
      addView(localView);
      measureChildWithMargins(localView, 0, 0);
      int i2 = getDecoratedMeasuredWidth(localView);
      int i3 = getDecoratedMeasuredHeight(localView);
      int i4 = (int)(getPaddingLeft() + (i1 - i2) / 2.0F);
      localRect.set(i4, paramInt2, i2 + i4, i3 + paramInt2);
      layoutDecorated(localView, localRect.left, localRect.top, localRect.right, localRect.bottom);
      paramInt2 = localRect.bottom;
      this.e = paramInt1;
      if (a().a.get(paramInt1) == null) {
        a().a.put(paramInt1, localRect);
      } else {
        ((Rect)a().a.get(paramInt1)).set(localRect);
      }
      paramInt1 += 1;
    }
  }
  
  private void d(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    int i6 = b().getStartAfterPadding();
    int i5 = b().getEndAfterPadding();
    if (getChildCount() > 0)
    {
      if (paramInt >= 0)
      {
        i1 = 0;
        i2 = 0;
        while (i1 < getChildCount())
        {
          paramState = getChildAt(i1 + i2);
          if (getDecoratedRight(paramState) - paramInt >= i6) {
            break;
          }
          removeAndRecycleView(paramState, paramRecycler);
          this.d += 1;
          i2 -= 1;
          i1 += 1;
        }
      }
      i1 = getChildCount() - 1;
      while (i1 >= 0)
      {
        paramState = getChildAt(i1);
        if (getDecoratedLeft(paramState) - paramInt > i5)
        {
          removeAndRecycleView(paramState, paramRecycler);
          this.e -= 1;
        }
        i1 -= 1;
      }
    }
    int i2 = this.d;
    int i4 = e();
    int i1 = -1;
    Rect localRect;
    View localView;
    int i7;
    if (paramInt >= 0)
    {
      if (getChildCount() != 0)
      {
        paramState = getChildAt(getChildCount() - 1);
        i1 = getPosition(paramState);
        i2 = getDecoratedRight(paramState);
        i1 += 1;
      }
      else
      {
        i1 = i2;
        i2 = -1;
      }
      i3 = i1;
      while ((i3 < getItemCount()) && (i2 < i5 + paramInt))
      {
        localRect = (Rect)a().a.get(i3);
        localView = paramRecycler.getViewForPosition(i3);
        addView(localView);
        paramState = localRect;
        if (localRect == null)
        {
          paramState = new Rect();
          a().a.put(i3, paramState);
        }
        measureChildWithMargins(localView, 0, 0);
        i6 = getDecoratedMeasuredWidth(localView);
        i7 = getDecoratedMeasuredHeight(localView);
        int i8 = (int)(getPaddingTop() + (i4 - i7) / 2.0F);
        if ((i2 == -1) && (i1 == 0))
        {
          i2 = (int)(getPaddingLeft() + (d() - i6) / 2.0F);
          paramState.set(i2, i8, i6 + i2, i7 + i8);
        }
        else
        {
          paramState.set(i2, i8, i6 + i2, i7 + i8);
        }
        layoutDecorated(localView, paramState.left, paramState.top, paramState.right, paramState.bottom);
        i2 = paramState.right;
        this.e = i3;
        i3 += 1;
      }
    }
    if (getChildCount() > 0)
    {
      paramState = getChildAt(0);
      i2 = getPosition(paramState);
      i1 = getDecoratedLeft(paramState);
      i2 -= 1;
    }
    int i3 = i2;
    i2 = i1;
    i1 = i3;
    while ((i1 >= 0) && (i2 > i6 + paramInt))
    {
      localRect = (Rect)a().a.get(i1);
      localView = paramRecycler.getViewForPosition(i1);
      addView(localView, 0);
      paramState = localRect;
      if (localRect == null)
      {
        paramState = new Rect();
        a().a.put(i1, paramState);
      }
      measureChildWithMargins(localView, 0, 0);
      i3 = getDecoratedMeasuredWidth(localView);
      i5 = getDecoratedMeasuredHeight(localView);
      i7 = (int)(getPaddingTop() + (i4 - i5) / 2.0F);
      paramState.set(i2 - i3, i7, i2, i5 + i7);
      layoutDecorated(localView, paramState.left, paramState.top, paramState.right, paramState.bottom);
      i2 = paramState.left;
      this.d = i1;
      i1 -= 1;
    }
  }
  
  private int e()
  {
    return getHeight() - getPaddingBottom() - getPaddingTop();
  }
  
  public GalleryLayoutManager.State a()
  {
    if (this.g == null) {
      this.g = new GalleryLayoutManager.State(this);
    }
    return this.g;
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramRecyclerView != null)
    {
      this.c = paramRecyclerView;
      this.f = Math.max(0, paramInt);
      paramRecyclerView.setLayoutManager(this);
      this.h.attachToRecyclerView(paramRecyclerView);
      paramRecyclerView.addOnScrollListener(this.i);
      return;
    }
    throw new IllegalArgumentException("The attach RecycleView must not null!!");
  }
  
  public void a(GalleryLayoutManager.ItemTransformer paramItemTransformer)
  {
    this.n = paramItemTransformer;
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public OrientationHelper b()
  {
    if (this.k == 0)
    {
      if (this.l == null) {
        this.l = OrientationHelper.createHorizontalHelper(this);
      }
      return this.l;
    }
    if (this.m == null) {
      this.m = OrientationHelper.createVerticalHelper(this);
    }
    return this.m;
  }
  
  public boolean canScrollHorizontally()
  {
    return this.k == 0;
  }
  
  public boolean canScrollVertically()
  {
    return this.k == 1;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof GalleryLayoutManager.LayoutParams;
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    paramInt = a(paramInt);
    PointF localPointF = new PointF();
    if (paramInt == 0) {
      return null;
    }
    if (this.k == 0)
    {
      localPointF.x = paramInt;
      localPointF.y = 0.0F;
      return localPointF;
    }
    localPointF.x = 0.0F;
    localPointF.y = paramInt;
    return localPointF;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    if (this.k == 1) {
      return new GalleryLayoutManager.LayoutParams(-1, -2);
    }
    return new GalleryLayoutManager.LayoutParams(-2, -1);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new GalleryLayoutManager.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new GalleryLayoutManager.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new GalleryLayoutManager.LayoutParams(paramLayoutParams);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onItemsRemoved(paramRecyclerView, paramInt1, paramInt2);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (getItemCount() == 0)
    {
      c();
      detachAndScrapAttachedViews(paramRecycler);
      return;
    }
    if (paramState.isPreLayout()) {
      return;
    }
    if ((paramState.getItemCount() != 0) && (!paramState.didStructureChange())) {
      return;
    }
    if ((getChildCount() == 0) || (paramState.didStructureChange())) {
      c();
    }
    this.f = Math.min(Math.max(0, this.f), getItemCount() - 1);
    detachAndScrapAttachedViews(paramRecycler);
    a(paramRecycler, paramState, 0);
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int i2 = getChildCount();
    int i1 = 0;
    if (i2 != 0)
    {
      if (paramInt == 0) {
        return 0;
      }
      i1 = -paramInt;
      i2 = (b().getEndAfterPadding() - b().getStartAfterPadding()) / 2 + b().getStartAfterPadding();
      if (paramInt > 0)
      {
        if (getPosition(getChildAt(getChildCount() - 1)) != getItemCount() - 1) {
          break label173;
        }
        localObject = getChildAt(getChildCount() - 1);
        paramInt = Math.max(0, Math.min(paramInt, (((View)localObject).getRight() - ((View)localObject).getLeft()) / 2 + ((View)localObject).getLeft() - i2));
      }
      else
      {
        if (this.d != 0) {
          break label173;
        }
        localObject = getChildAt(0);
        paramInt = Math.min(0, Math.max(paramInt, (((View)localObject).getRight() - ((View)localObject).getLeft()) / 2 + ((View)localObject).getLeft() - i2));
      }
      i1 = -paramInt;
      label173:
      Object localObject = a();
      paramInt = -i1;
      ((GalleryLayoutManager.State)localObject).b = paramInt;
      b(paramRecycler, paramState, paramInt);
      offsetChildrenHorizontal(i1);
      i1 = paramInt;
    }
    return i1;
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int i2 = getChildCount();
    int i1 = 0;
    if (i2 != 0)
    {
      if (paramInt == 0) {
        return 0;
      }
      i1 = -paramInt;
      i2 = (b().getEndAfterPadding() - b().getStartAfterPadding()) / 2 + b().getStartAfterPadding();
      if (paramInt > 0)
      {
        if (getPosition(getChildAt(getChildCount() - 1)) != getItemCount() - 1) {
          break label179;
        }
        localObject = getChildAt(getChildCount() - 1);
        paramInt = Math.max(0, Math.min(paramInt, (getDecoratedBottom((View)localObject) - getDecoratedTop((View)localObject)) / 2 + getDecoratedTop((View)localObject) - i2));
      }
      else
      {
        if (this.d != 0) {
          break label179;
        }
        localObject = getChildAt(0);
        paramInt = Math.min(0, Math.max(paramInt, (getDecoratedBottom((View)localObject) - getDecoratedTop((View)localObject)) / 2 + getDecoratedTop((View)localObject) - i2));
      }
      i1 = -paramInt;
      label179:
      Object localObject = a();
      paramInt = -i1;
      ((GalleryLayoutManager.State)localObject).b = paramInt;
      b(paramRecycler, paramState, paramInt);
      offsetChildrenVertical(i1);
      i1 = paramInt;
    }
    return i1;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    paramRecyclerView = new GalleryLayoutManager.GallerySmoothScroller(this, paramRecyclerView.getContext());
    paramRecyclerView.setTargetPosition(paramInt);
    startSmoothScroll(paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.GalleryLayoutManager
 * JD-Core Version:    0.7.0.1
 */