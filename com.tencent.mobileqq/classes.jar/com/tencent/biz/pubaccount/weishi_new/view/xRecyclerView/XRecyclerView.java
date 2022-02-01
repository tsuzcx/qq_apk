package com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.AbsPullToRefreshView2;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener;
import com.tencent.widget.pull2refresh.PullToRefreshListener;
import com.tencent.widget.pull2refresh.XLoadMoreLayout;
import com.tencent.widget.pull2refresh.anim.IAnimManager;

public class XRecyclerView
  extends AbsPullToRefreshView2
  implements LoadingMoreHelper.OnLoadMoreListener, PullToRefreshListener
{
  protected RecyclerViewWithHeaderFooter a;
  private XRecyclerView.RefreshCallback b;
  private LoadingMoreHelper c;
  private XLoadMoreLayout d;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private boolean h = true;
  private boolean i;
  private ThreadLocal<Boolean> j = new XRecyclerView.1(this);
  
  public XRecyclerView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    setPullToRefreshListener(this);
    LayoutInflater.from(getContext()).inflate(1929773084, this, true);
    this.d = new XLoadMoreLayout(getContext());
    this.a = ((RecyclerViewWithHeaderFooter)findViewById(1929707565));
    this.c = new LoadingMoreHelper(this.d, getContext());
    this.c.setLoadMoreEnabled(true);
    this.c.setOnLoadMoreListener(this);
    this.a.a(this.d);
    this.a.addOnScrollListener(new XRecyclerView.2(this));
  }
  
  public void a()
  {
    this.a.stopScroll();
    this.a.scrollToPosition(0);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMoreComplete(): hasMoreData=");
      localStringBuilder.append(paramBoolean2);
      QLog.d("XRecyclerView", 2, localStringBuilder.toString());
    }
    this.c.setLoadMoreComplete(paramBoolean1, paramBoolean2);
    this.c.setLoadMoreEnabled(paramBoolean2);
  }
  
  protected void clearContentViewClickEvent(boolean paramBoolean)
  {
    this.a.a = paramBoolean;
  }
  
  protected int configHeaderVisibleHeight()
  {
    return this.mAnimManager.getPullRefreshAreaHeight();
  }
  
  protected View generateFooterView()
  {
    return null;
  }
  
  protected View generateHeaderView()
  {
    View localView = this.mAnimManager.getRefreshView(this);
    if (this.mAnimManager.isSkinAnimManager())
    {
      setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#F7F7F7")));
      return localView;
    }
    setPullHeaderBgDrawable(getResources().getDrawable(2130839580));
    return localView;
  }
  
  public LoadingMoreHelper getLoadMoreLayoutHelper()
  {
    return this.c;
  }
  
  public RecyclerViewWithHeaderFooter getRecyclerView()
  {
    return this.a;
  }
  
  public int getScrollPositionX()
  {
    return this.f;
  }
  
  public int getScrollPositionY()
  {
    return this.g;
  }
  
  @TargetApi(14)
  protected boolean isScroll2Bottom()
  {
    return this.a.canScrollVertically(1) ^ true;
  }
  
  @TargetApi(14)
  protected boolean isScroll2Top()
  {
    if (!this.h) {
      return false;
    }
    return this.a.canScrollVertically(-1) ^ true;
  }
  
  public boolean onLoadMore(boolean paramBoolean)
  {
    XRecyclerView.RefreshCallback localRefreshCallback = this.b;
    if (localRefreshCallback != null) {
      localRefreshCallback.a(this, 0);
    }
    return true;
  }
  
  public void onLoadMoreComplete() {}
  
  public void onNotCompleteVisable(View paramView, int paramInt)
  {
    if ((this.mAnimManager != null) && (paramView == this.mAnimManager.getRefreshView(this))) {
      this.mAnimManager.onPullRefreshing(paramInt, this.isRefreshing);
    }
  }
  
  public void onRefreshCompleted(View paramView, boolean paramBoolean) {}
  
  public void onViewCompleteVisable(View paramView)
  {
    if ((this.mAnimManager != null) && (paramView == this.mAnimManager.getRefreshView(this))) {
      this.mAnimManager.onPullRefreshing(100, this.isRefreshing);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(View paramView)
  {
    boolean bool = ((Boolean)this.j.get()).booleanValue();
    this.j.set(Boolean.valueOf(false));
    if ((this.mAnimManager != null) && (paramView == this.mAnimManager.getRefreshView(this)))
    {
      this.mAnimManager.onPullRefreshComplete(bool);
      paramView = this.b;
      if (paramView != null) {
        paramView.a(this, bool);
      }
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(View paramView) {}
  
  public void pullRefreshCompleted(boolean paramBoolean)
  {
    super.pullRefreshCompleted(paramBoolean);
    if (this.mAnimManager != null) {
      this.mAnimManager.showRefreshResult(paramBoolean, "");
    }
    XRecyclerView.RefreshCallback localRefreshCallback = this.b;
    if (localRefreshCallback != null) {
      localRefreshCallback.a();
    }
  }
  
  protected void rebound()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSXRecyclerView.java][rebound] mAutoScroller:");
    localStringBuilder.append(this.i);
    WSLog.e("XRecyclerView", localStringBuilder.toString());
    if (!this.i) {
      super.rebound();
    }
  }
  
  public void setIsAutoScrolling(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setRefreshCallback(XRecyclerView.RefreshCallback paramRefreshCallback)
  {
    this.b = paramRefreshCallback;
  }
  
  public void setRefreshEnable(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.XRecyclerView
 * JD-Core Version:    0.7.0.1
 */