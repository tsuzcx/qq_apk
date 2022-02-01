package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.SwipListView;

public class QQStoryPullToRefreshListView
  extends SwipListView
  implements AbsListView.OnScrollListener, OverScrollViewListener
{
  private OverScrollViewForwardListener a = new OverScrollViewForwardListener(this);
  private View.OnTouchListener b;
  private String c;
  private AbsListView.OnScrollListener d = null;
  private int e = -1;
  public LoadingMoreHelper j;
  public PullRefreshHeader k;
  protected QQStoryPullToRefreshListView.PullToRefreshListener l;
  
  public QQStoryPullToRefreshListView(Context paramContext)
  {
    super(paramContext.getApplicationContext());
    a();
  }
  
  public QQStoryPullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QQStoryPullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    t();
    super.setOnScrollListener(this);
  }
  
  public void a(boolean paramBoolean)
  {
    PullRefreshHeader localPullRefreshHeader = this.k;
    if (localPullRefreshHeader == null) {
      return;
    }
    if (paramBoolean) {
      localPullRefreshHeader.a(0);
    } else {
      localPullRefreshHeader.a(1);
    }
    postDelayed(new QQStoryPullToRefreshListView.1(this), 800L);
  }
  
  protected void o()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.j = new LoadingMoreHelper(localLoadMoreLayout, getContext().getApplicationContext());
    super.addFooterView(localLoadMoreLayout);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.k.c(0L);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.d;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt1 == this.e) {
      return;
    }
    this.e = paramInt1;
    if (paramInt3 - (paramInt1 + paramInt2) <= this.j.a()) {
      this.j.b(true);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.d;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    View.OnTouchListener localOnTouchListener = this.b;
    if (localOnTouchListener != null) {
      localOnTouchListener.onTouch(this, paramMotionEvent);
    }
    return bool;
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.k.b(0L);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.k.a(0L);
    if (!NetworkUtil.isNetworkAvailable(getContext().getApplicationContext())) {
      a(false);
    } else {
      this.l.a();
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.k.a(0L);
  }
  
  protected void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (this.c != null)
    {
      if (paramInt == 0)
      {
        DropFrameMonitor.b().a(this.c, false);
        return;
      }
      DropFrameMonitor.b().a(this.c);
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.c = paramString;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.d = paramOnScrollListener;
  }
  
  public void setOnTouchExtraListener(View.OnTouchListener paramOnTouchListener)
  {
    this.b = paramOnTouchListener;
  }
  
  public void setPullToRefreshListener(QQStoryPullToRefreshListView.PullToRefreshListener paramPullToRefreshListener)
  {
    this.l = paramPullToRefreshListener;
  }
  
  protected void t()
  {
    o();
    u();
  }
  
  protected void u()
  {
    this.k = ((PullRefreshHeader)LayoutInflater.from(super.getContext()).inflate(2131628132, this, false));
    this.k.setTextColor(-1, -1, -1, -1, -1);
    this.k.setHeaderBgDrawable(getResources().getDrawable(2130839580));
    super.setOverScrollHeight(super.getResources().getDimensionPixelSize(2131299643));
    super.setOverScrollHeader(this.k);
    super.setOverScrollListener(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView
 * JD-Core Version:    0.7.0.1
 */