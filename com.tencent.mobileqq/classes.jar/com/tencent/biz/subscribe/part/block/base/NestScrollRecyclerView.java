package com.tencent.biz.subscribe.part.block.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.biz.subscribe.part.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

public class NestScrollRecyclerView
  extends RecyclerViewCompat
  implements NestedScrollingParent
{
  private static String a = "NestScrollRecyclerView";
  private NestedScrollingParentHelper b;
  private int c;
  private int d;
  private int e;
  private int f;
  private RefreshHeaderView g;
  private View h;
  private View i;
  private NestScrollRecyclerView.NestScrollDelegate j;
  private NestScrollRecyclerView.TransDispatchDelegate k;
  private boolean l;
  
  public NestScrollRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NestScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.b = new NestedScrollingParentHelper(this);
    this.f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void a(MotionEvent paramMotionEvent, View paramView)
  {
    Object localObject = new Rect();
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    getGlobalVisibleRect((Rect)localObject);
    float f1 = ((Rect)localObject).left - localRect.left;
    float f2 = ((Rect)localObject).top - localRect.top;
    paramView = a;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("modifyEventPos offsetX:");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(" offsetY:");
    ((StringBuilder)localObject).append(f2);
    QLog.d(paramView, 4, ((StringBuilder)localObject).toString());
    paramMotionEvent.offsetLocation(f1, f2);
  }
  
  private boolean a(int paramInt, RecyclerView paramRecyclerView)
  {
    setParentRefreshViewDelegate(paramRecyclerView);
    if (((paramInt > 0) && (a(paramRecyclerView))) || ((paramInt < 0) && (!paramRecyclerView.canScrollVertically(-1))))
    {
      QLog.d(a, 4, "parent is consume");
      return true;
    }
    QLog.d(a, 4, "self consume");
    return false;
  }
  
  private boolean a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView instanceof NestScrollRecyclerView))
    {
      localObject = (NestScrollRecyclerView)paramRecyclerView;
      if (((NestScrollRecyclerView)localObject).getNestScrollDelegate() != null) {
        return ((NestScrollRecyclerView)localObject).getNestScrollDelegate().a(paramRecyclerView);
      }
    }
    paramRecyclerView = this.i;
    boolean bool = false;
    if (paramRecyclerView == null)
    {
      QLog.d(a, 1, "isNestViewNotReachTop mNestTargetViewWrapper is null");
      return false;
    }
    paramRecyclerView = a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isNestViewNotReachTop mNestTargetViewWrapper.getTop()");
    ((StringBuilder)localObject).append(this.i.getTop());
    QLog.d(paramRecyclerView, 1, ((StringBuilder)localObject).toString());
    if (this.i.getTop() > 0) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (((getAdapter() instanceof PullLoadMoreAdapter)) && (((PullLoadMoreAdapter)getAdapter()).m()) && (((PullLoadMoreAdapter)getAdapter()).o() != null)) {
      ((PullLoadMoreAdapter)getAdapter()).o().a(paramMotionEvent);
    }
    if (getParentRefreshView() != null) {
      getParentRefreshView().a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  private void setParentRefreshView(RefreshHeaderView paramRefreshHeaderView)
  {
    this.g = paramRefreshHeaderView;
  }
  
  private void setParentRefreshViewDelegate(RecyclerView paramRecyclerView)
  {
    if (((paramRecyclerView instanceof NestScrollRecyclerView)) && ((getAdapter() instanceof PullLoadMoreAdapter)) && (((PullLoadMoreAdapter)getAdapter()).m()))
    {
      paramRecyclerView = (NestScrollRecyclerView)paramRecyclerView;
      if (paramRecyclerView.getParentRefreshView() == null) {
        paramRecyclerView.setParentRefreshView(((PullLoadMoreAdapter)getAdapter()).o());
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.k != null)
    {
      View localView = this.h;
      if ((localView != null) && (!a((RecyclerView)localView)) && (ViewUtils.a(this.h, paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) && (this.k.a(paramMotionEvent, (RecyclerView)this.h)))
      {
        a(paramMotionEvent, this.h);
        return this.h.dispatchTouchEvent(paramMotionEvent);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("velocityX");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("   velocityY:");
    localStringBuilder.append(paramInt2);
    QLog.d(str, 1, localStringBuilder.toString());
    return super.fling(paramInt1, paramInt2);
  }
  
  public NestScrollRecyclerView.NestScrollDelegate getNestScrollDelegate()
  {
    return this.j;
  }
  
  public int getNestedScrollAxes()
  {
    return this.b.getNestedScrollAxes();
  }
  
  public RefreshHeaderView getParentRefreshView()
  {
    return this.g;
  }
  
  public NestScrollRecyclerView.TransDispatchDelegate getTransDispatchDelegate()
  {
    return this.k;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInterceptTouchEvent hashCode");
    localStringBuilder.append(hashCode());
    QLog.d(str, 4, localStringBuilder.toString());
    int m = paramMotionEvent.getAction();
    int n = paramMotionEvent.getActionIndex();
    if (m != 0)
    {
      if (m != 2) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInterceptTouchEvent:  X:");
      localStringBuilder.append(paramMotionEvent.getX());
      localStringBuilder.append(" Y:");
      localStringBuilder.append(paramMotionEvent.getY());
      QLog.d(str, 4, localStringBuilder.toString());
      n = (int)(paramMotionEvent.getX() + 0.5F);
      m = (int)(paramMotionEvent.getY() + 0.5F);
      n -= this.c;
      m = (int)((m - this.d) * 0.6F);
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ACTION_MOVE dx:");
      localStringBuilder.append(n);
      localStringBuilder.append("    dy:");
      localStringBuilder.append(m);
      QLog.d(str, 1, localStringBuilder.toString());
      if ((Math.abs(n) > this.f) && (Math.abs(n) >= Math.abs(m)))
      {
        QLog.d(a, 4, "move axis x");
        return false;
      }
      if ((this.h instanceof NestScrollRecyclerView))
      {
        QLog.d(a, 4, "NestScrollRecyclerView");
        return false;
      }
    }
    else
    {
      this.c = ((int)(paramMotionEvent.getX() + 0.5F));
      this.d = ((int)(paramMotionEvent.getY() + 0.5F));
      this.e = MotionEventCompat.findPointerIndex(paramMotionEvent, n);
      this.h = null;
      this.i = null;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.l)
    {
      paramInt1 = getMeasuredHeight();
      paramInt2 = getMeasuredWidth();
      if (getMeasuredHeight() > ImmersiveUtils.getScreenHeight()) {
        paramInt1 = ImmersiveUtils.getScreenHeight();
      }
      if (getMeasuredWidth() > ImmersiveUtils.getScreenWidth()) {
        paramInt2 = ImmersiveUtils.getScreenWidth();
      }
      setMeasuredDimension(paramInt2, paramInt1);
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    Log.d(a, String.format("----onNestedFling---------------- velocityX:%s, velocityY:%s, consumed:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(paramBoolean) }));
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    if ((paramView instanceof NestScrollRecyclerView))
    {
      int m = (int)paramFloat2;
      if (a(m, (NestScrollRecyclerView)paramView))
      {
        fling((int)paramFloat1, m);
        bool = true;
        break label42;
      }
    }
    boolean bool = false;
    label42:
    Log.d(a, String.format("----onNestedPreFling---------------- ret:%s, velocityY:%s", new Object[] { Boolean.valueOf(bool), Float.valueOf(paramFloat2) }));
    return bool;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    Log.d(a, String.format("onNestedPreScroll dx:%s,dy:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (((paramView instanceof RecyclerView)) && (a(paramInt2, (RecyclerView)paramView)))
    {
      scrollBy(0, paramInt2);
      paramView = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollBy");
      localStringBuilder.append(paramInt2);
      Log.d(paramView, localStringBuilder.toString());
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNestedScroll: targetView:");
    localStringBuilder.append(paramView.hashCode());
    localStringBuilder.append(" dxConsumed:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("   dyConsumed:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("   dxUnconsumed:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("   dyUnconsumed:");
    localStringBuilder.append(paramInt4);
    Log.d(str, localStringBuilder.toString());
  }
  
  @SuppressLint({"NewApi"})
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    Log.d(a, "----父布局onNestedScrollAccepted----------------");
    this.h = paramView2;
    this.i = paramView1;
    this.b.onNestedScrollAccepted(paramView1, paramView2, paramInt);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    Log.d(a, String.format("父布局onStartNestedScroll: child:%s, target:%s, nestedScrollAxes:%s", new Object[] { Integer.valueOf(paramView1.hashCode()), Integer.valueOf(paramView2.hashCode()), Integer.valueOf(paramInt) }));
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    Log.d(a, "----父布局onStopNestedScroll----------------");
    this.b.onStopNestedScroll(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = a(paramMotionEvent);
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    super.setAdapter(paramAdapter);
  }
  
  public void setNeedLimitHeightWidth(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setNestScrollDelegate(NestScrollRecyclerView.NestScrollDelegate paramNestScrollDelegate)
  {
    this.j = paramNestScrollDelegate;
  }
  
  public void setTransDispatchDelegate(NestScrollRecyclerView.TransDispatchDelegate paramTransDispatchDelegate)
  {
    this.k = paramTransDispatchDelegate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.base.NestScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */