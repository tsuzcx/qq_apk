package com.tencent.biz.qqcircle.immersive.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.immersive.bean.QFSTouchBean;
import com.tencent.biz.qqcircle.immersive.bean.QFSTouchBean.TouchPoint;
import com.tencent.biz.qqcircle.immersive.refresh.QFSLayerLoadFooterView;
import com.tencent.biz.qqcircle.immersive.refresh.QFSLayerRefreshHeaderView;
import com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QFSPageTurnContainer
  extends FrameLayout
{
  private boolean a;
  private ViewPager2 b;
  private QFSPullRefreshLayout c;
  private int d = 1;
  private QFSPageTurnContainer.OnLoadDataCallback e;
  private int f = 2;
  private QFSPageTurnContainer.OnRefreshLoadViewStatusListener g;
  private QFSLayerRefreshHeaderView h;
  private QFSLayerLoadFooterView i;
  private boolean j = true;
  private float k;
  private int l;
  private int m;
  private int n;
  private int o;
  private QFSPageTurnContainer.ChildDisallowInterceptListener p;
  private LinearLayoutManager q;
  private RecyclerView r;
  private QFSTouchBean s;
  
  public QFSPageTurnContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QFSPageTurnContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QFSPageTurnContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(float paramFloat)
  {
    if ((this.j) && (this.k < 100.0F) && (paramFloat > 0.0F) && (paramFloat >= 200.0F) && ((getContext() instanceof Activity))) {
      ((Activity)getContext()).finish();
    }
  }
  
  private void a(int paramInt)
  {
    if (!g())
    {
      if (h()) {
        return;
      }
      if (!(getViewPager2().getAdapter() instanceof BaseListViewAdapter)) {
        return;
      }
      BaseListViewAdapter localBaseListViewAdapter = (BaseListViewAdapter)getViewPager2().getAdapter();
      int i1;
      if (localBaseListViewAdapter.getDataList() != null) {
        i1 = localBaseListViewAdapter.getDataList().size();
      } else {
        i1 = 0;
      }
      if (paramInt >= i1 - 1 - this.f)
      {
        QLog.d("FSPageTurnContainer", 1, "checkNeedTriggerPreloadLoadMore  preload loadMore");
        e(true);
        setPreloadLoadMore(true);
      }
    }
  }
  
  private boolean a(QFSTouchBean paramQFSTouchBean)
  {
    if (this.p != null)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (getRecyclerView() != null)
      {
        localObject1 = localObject2;
        if (getLinearLayoutManager() != null) {
          localObject1 = getLinearLayoutManager().findViewByPosition(getLinearLayoutManager().findFirstCompletelyVisibleItemPosition());
        }
      }
      if (localObject1 != null)
      {
        boolean bool = this.p.a((View)localObject1, paramQFSTouchBean);
        c(bool);
        return bool;
      }
    }
    return false;
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("triggerRefreshOrLoadMore  isLoadMore = ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("FSPageTurnContainer", 1, ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      if (!this.c.d())
      {
        QLog.d("FSPageTurnContainer", 1, "triggerRefreshOrLoadMore  hasMoreData = false");
        return;
      }
      if (c())
      {
        QLog.d("FSPageTurnContainer", 1, "triggerRefreshOrLoadMore  isLoadMore = true , running preloadLoadMore");
        return;
      }
      localObject = this.e;
      if (localObject != null) {
        ((QFSPageTurnContainer.OnLoadDataCallback)localObject).a(true);
      }
    }
    else
    {
      localObject = this.e;
      if (localObject != null) {
        ((QFSPageTurnContainer.OnLoadDataCallback)localObject).a(false);
      }
    }
  }
  
  private RecyclerView getRecyclerView()
  {
    if (this.r == null)
    {
      ViewPager2 localViewPager2 = this.b;
      if ((localViewPager2 != null) && ((localViewPager2.getChildAt(0) instanceof RecyclerView))) {
        this.r = ((RecyclerView)this.b.getChildAt(0));
      }
    }
    return this.r;
  }
  
  private void i()
  {
    this.c = ((QFSPullRefreshLayout)findViewById(2131440660));
    setRefreshEnable(true);
    setLoadMoreEnable(true);
    this.c.setAutoLoadEnable(true);
    this.c.setOffsetRadio(3.0F);
    this.h = new QFSLayerRefreshHeaderView(getContext());
    this.c.setHeaderView(this.h, 3);
    this.c.setHeaderViewMarginTop(ViewUtils.a());
    this.i = new QFSLayerLoadFooterView(getContext());
    this.c.setFooterView(this.i, 2);
    this.c.setOnRefreshListener(new QFSPageTurnContainer.2(this));
  }
  
  protected void a()
  {
    try
    {
      LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initView error:");
      localStringBuilder.append(localThrowable.toString());
      QLog.d("FSPageTurnContainer", 1, localStringBuilder.toString());
    }
    this.l = ImmersiveUtils.b();
    b();
    i();
    this.m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.b(paramBoolean);
  }
  
  protected void b()
  {
    this.b = ((ViewPager2)findViewById(2131444762));
    this.b.setOrientation(this.d);
    this.b.registerOnPageChangeCallback(new QFSPageTurnContainer.1(this));
  }
  
  public void b(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
    setPreloadLoadMore(false);
  }
  
  public void c(boolean paramBoolean)
  {
    QFSPullRefreshLayout localQFSPullRefreshLayout = this.c;
    if (localQFSPullRefreshLayout != null) {
      localQFSPullRefreshLayout.c(paramBoolean);
    }
    if (getViewPager2() != null) {
      getViewPager2().setUserInputEnabled(paramBoolean ^ true);
    }
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public void d()
  {
    this.c.e();
  }
  
  public void d(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.s == null) {
      this.s = new QFSTouchBean();
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 == 2)
      {
        this.s.b(paramMotionEvent.getX(), paramMotionEvent.getY());
        QFSTouchBean.TouchPoint localTouchPoint = this.s.b();
        float f1;
        if (localTouchPoint == null) {
          f1 = 0.0F;
        } else {
          f1 = localTouchPoint.a();
        }
        if (!a(this.s)) {
          a(f1);
        }
      }
    }
    else {
      this.s.a(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    this.c.f();
  }
  
  public void f()
  {
    this.c.g();
  }
  
  public boolean g()
  {
    return this.c.b();
  }
  
  public int getLayoutId()
  {
    return 2131627152;
  }
  
  public LinearLayoutManager getLinearLayoutManager()
  {
    LinearLayoutManager localLinearLayoutManager = this.q;
    if (localLinearLayoutManager != null) {
      return localLinearLayoutManager;
    }
    if (getRecyclerView() != null) {
      return (LinearLayoutManager)getRecyclerView().getLayoutManager();
    }
    return null;
  }
  
  public ViewPager2 getViewPager2()
  {
    return this.b;
  }
  
  public boolean h()
  {
    return this.c.c();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 2) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      int i2 = (int)(paramMotionEvent.getX() + 0.5F);
      i1 = (int)(paramMotionEvent.getY() + 0.5F);
      i2 -= this.n;
      i1 = (int)((i1 - this.o) * 1.0F);
      if ((Math.abs(i2) > this.m) && (Math.abs(i2) >= Math.abs(i1))) {
        return false;
      }
    }
    else
    {
      this.n = ((int)(paramMotionEvent.getX() + 0.5F));
      this.o = ((int)(paramMotionEvent.getY() + 0.5F));
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setChildDisallowInterceptListener(QFSPageTurnContainer.ChildDisallowInterceptListener paramChildDisallowInterceptListener)
  {
    this.p = paramChildDisallowInterceptListener;
  }
  
  public void setLoadMoreEnable(boolean paramBoolean)
  {
    this.c.setLoadMoreEnable(paramBoolean);
  }
  
  public void setLoadMorePreloadNum(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setOnLoadDataCallback(QFSPageTurnContainer.OnLoadDataCallback paramOnLoadDataCallback)
  {
    this.e = paramOnLoadDataCallback;
  }
  
  public void setOnRefreshViewStatusListener(QFSPageTurnContainer.OnRefreshLoadViewStatusListener paramOnRefreshLoadViewStatusListener)
  {
    this.g = paramOnRefreshLoadViewStatusListener;
    paramOnRefreshLoadViewStatusListener = this.h;
    if (paramOnRefreshLoadViewStatusListener != null) {
      paramOnRefreshLoadViewStatusListener.setOnRefreshViewStatusListener(this.g);
    }
    paramOnRefreshLoadViewStatusListener = this.i;
    if (paramOnRefreshLoadViewStatusListener != null) {
      paramOnRefreshLoadViewStatusListener.setOnRefreshViewStatusListener(this.g);
    }
  }
  
  public void setOrientationType(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setPreloadLoadMore(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setRefreshEnable(boolean paramBoolean)
  {
    this.c.setRefreshEnable(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer
 * JD-Core Version:    0.7.0.1
 */