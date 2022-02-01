package com.tencent.biz.richframework.part.block.base;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NestScrollRecyclerView
  extends RecyclerView
  implements NestedScrollingParent2
{
  private NestedScrollingParentHelper a;
  private int b;
  private int c;
  private int d;
  private int e;
  private IRefreshViewProvider f;
  private View g;
  private View h;
  private NestScrollRecyclerView.NestScrollDelegate i;
  private NestScrollRecyclerView.TransDispatchDelegate j;
  private boolean k;
  
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
    this.a = new NestedScrollingParentHelper(this);
    this.e = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private boolean a(int paramInt, RecyclerView paramRecyclerView)
  {
    setParentRefreshViewDelegate(paramRecyclerView);
    return ((paramInt > 0) && (a(paramRecyclerView))) || ((paramInt < 0) && (!paramRecyclerView.canScrollVertically(-1)));
  }
  
  public static boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    Rect localRect = new Rect();
    paramView.getLocalVisibleRect(localRect);
    return (paramFloat1 > localRect.left) && (paramFloat1 < localRect.right) && (paramFloat2 > localRect.top) && (paramFloat2 < localRect.bottom);
  }
  
  private boolean a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView instanceof NestScrollRecyclerView))
    {
      NestScrollRecyclerView localNestScrollRecyclerView = (NestScrollRecyclerView)paramRecyclerView;
      if (localNestScrollRecyclerView.getNestScrollDelegate() != null) {
        return localNestScrollRecyclerView.getNestScrollDelegate().a(paramRecyclerView);
      }
    }
    paramRecyclerView = this.h;
    boolean bool = false;
    if (paramRecyclerView == null)
    {
      QLog.d("NestScrollRecyclerView", 1, "[isNestViewNotReachTop] mNestTargetViewWrapper is null");
      return false;
    }
    if (paramRecyclerView.getTop() > 0) {
      bool = true;
    }
    return bool;
  }
  
  private void setParentRefreshView(IRefreshViewProvider paramIRefreshViewProvider)
  {
    this.f = paramIRefreshViewProvider;
  }
  
  private void setParentRefreshViewDelegate(RecyclerView paramRecyclerView)
  {
    if (((paramRecyclerView instanceof NestScrollRecyclerView)) && ((getAdapter() instanceof PullLoadMoreAdapter)) && (((PullLoadMoreAdapter)getAdapter()).p()))
    {
      paramRecyclerView = (NestScrollRecyclerView)paramRecyclerView;
      if (paramRecyclerView.getParentRefreshViewProvider() == null) {
        paramRecyclerView.setParentRefreshView(((PullLoadMoreAdapter)getAdapter()).r());
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent, View paramView, float[] paramArrayOfFloat)
  {
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    paramView.getGlobalVisibleRect(localRect2);
    getGlobalVisibleRect(localRect1);
    paramMotionEvent.offsetLocation(localRect1.left - localRect2.left - paramArrayOfFloat[0], localRect1.top - localRect2.top - paramArrayOfFloat[1]);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.j != null)
    {
      View localView = this.g;
      if ((localView != null) && (!a((RecyclerView)localView)) && (a(this.g, paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) && (this.j.a(paramMotionEvent, (RecyclerView)this.g)))
      {
        localView = this.g;
        if (((localView instanceof NestScrollRecyclerView)) && (((NestScrollRecyclerView)localView).getNestScrollDelegate() != null) && (((NestScrollRecyclerView)this.g).getNestScrollDelegate().a() != null))
        {
          localView = this.g;
          a(paramMotionEvent, localView, ((NestScrollRecyclerView)localView).getNestScrollDelegate().a());
        }
        else
        {
          a(paramMotionEvent, this.g, new float[] { 0.0F, 0.0F });
        }
        return this.g.dispatchTouchEvent(paramMotionEvent);
      }
    }
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      if (!RFApplication.isDebug()) {
        return false;
      }
      throw paramMotionEvent;
    }
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    return super.fling(paramInt1, paramInt2);
  }
  
  public NestScrollRecyclerView.NestScrollDelegate getNestScrollDelegate()
  {
    return this.i;
  }
  
  public int getNestedScrollAxes()
  {
    return this.a.getNestedScrollAxes();
  }
  
  public IRefreshViewProvider getParentRefreshViewProvider()
  {
    return this.f;
  }
  
  public NestScrollRecyclerView.TransDispatchDelegate getTransDispatchDelegate()
  {
    return this.j;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    int n = paramMotionEvent.getActionIndex();
    if (m != 0)
    {
      if (m != 2) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      n = (int)(paramMotionEvent.getX() + 0.5F);
      m = (int)(paramMotionEvent.getY() + 0.5F);
      n -= this.b;
      m = (int)((m - this.c) * 1.0F);
      if ((Math.abs(n) > this.e) && (Math.abs(n) >= Math.abs(m))) {
        return false;
      }
      if ((this.g instanceof NestScrollRecyclerView)) {
        return false;
      }
    }
    else
    {
      this.b = ((int)(paramMotionEvent.getX() + 0.5F));
      this.c = ((int)(paramMotionEvent.getY() + 0.5F));
      this.d = MotionEventCompat.findPointerIndex(paramMotionEvent, n);
      this.g = null;
      this.h = null;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = paramInt2;
    if (this.k)
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(ImmersiveUtils.getScreenHeight(), -2147483648);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(ImmersiveUtils.getScreenWidth(), -2147483648);
      m = paramInt1;
      paramInt1 = paramInt2;
    }
    if (RFApplication.isDebug())
    {
      super.onMeasure(paramInt1, m);
      return;
    }
    try
    {
      super.onMeasure(paramInt1, m);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    if (!(paramView instanceof NestScrollRecyclerView)) {
      return false;
    }
    int m = (int)paramFloat2;
    if (a(m, (NestScrollRecyclerView)paramView)) {
      fling((int)paramFloat1, m);
    }
    return false;
  }
  
  public void onNestedPreScroll(@NonNull View paramView, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt, int paramInt3)
  {
    if (!(paramView instanceof RecyclerView)) {
      return;
    }
    if (a(paramInt2, (RecyclerView)paramView))
    {
      scrollBy(0, paramInt2);
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void onNestedScrollAccepted(@NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    this.g = paramView2;
    this.h = paramView1;
    this.a.onNestedScrollAccepted(paramView1, paramView2, paramInt1);
  }
  
  public boolean onStartNestedScroll(@NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    return (paramInt1 & 0x2) != 0;
  }
  
  public void onStopNestedScroll(@NonNull View paramView, int paramInt)
  {
    this.a.onStopNestedScroll(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((getAdapter() instanceof PullLoadMoreAdapter)) && (((PullLoadMoreAdapter)getAdapter()).p()) && (((PullLoadMoreAdapter)getAdapter()).r() != null)) {
      ((PullLoadMoreAdapter)getAdapter()).r().a(paramMotionEvent);
    }
    if (getParentRefreshViewProvider() != null) {
      getParentRefreshViewProvider().a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    super.setAdapter(paramAdapter);
  }
  
  public void setNeedLimitHeightWidth(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setNestScrollDelegate(NestScrollRecyclerView.NestScrollDelegate paramNestScrollDelegate)
  {
    this.i = paramNestScrollDelegate;
  }
  
  public void setTransDispatchDelegate(NestScrollRecyclerView.TransDispatchDelegate paramTransDispatchDelegate)
  {
    this.j = paramTransDispatchDelegate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */