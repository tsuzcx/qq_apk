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
  private int jdField_a_of_type_Int = -1;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  public LoadingMoreHelper a;
  private OverScrollViewForwardListener jdField_a_of_type_ComTencentBizQqstoryViewWidgetOverScrollViewForwardListener = new OverScrollViewForwardListener(this);
  protected QQStoryPullToRefreshListView.PullToRefreshListener a;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
  private String jdField_a_of_type_JavaLangString;
  public PullRefreshHeader b;
  
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
    r();
    super.setOnScrollListener(this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    if (paramBoolean) {
      this.b.a(0);
    }
    for (;;)
    {
      postDelayed(new QQStoryPullToRefreshListView.1(this), 800L);
      return;
      this.b.a(1);
    }
  }
  
  protected void n()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper = new LoadingMoreHelper(localLoadMoreLayout, getContext().getApplicationContext());
    super.addFooterView(localLoadMoreLayout);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.b.c(0L);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt1 == this.jdField_a_of_type_Int) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
    } while (paramInt3 - (paramInt1 + paramInt2) > this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper.a());
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper.b(true);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    View.OnTouchListener localOnTouchListener = this.jdField_a_of_type_AndroidViewView$OnTouchListener;
    if (localOnTouchListener != null) {
      localOnTouchListener.onTouch(this, paramMotionEvent);
    }
    return bool;
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.b.b(0L);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.b.a(0L);
    if (!NetworkUtil.g(getContext().getApplicationContext())) {
      a(false);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView$PullToRefreshListener.a();
    }
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.b.a(0L);
  }
  
  protected void r()
  {
    n();
    s();
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (paramInt == 0) {
        DropFrameMonitor.a().a(this.jdField_a_of_type_JavaLangString, false);
      }
    }
    else {
      return;
    }
    DropFrameMonitor.a().a(this.jdField_a_of_type_JavaLangString);
  }
  
  protected void s()
  {
    this.b = ((PullRefreshHeader)LayoutInflater.from(super.getContext()).inflate(2131561906, this, false));
    this.b.setTextColor(-1, -1, -1, -1, -1);
    this.b.setHeaderBgDrawable(getResources().getDrawable(2130839540));
    super.setOverScrollHeight(super.getResources().getDimensionPixelSize(2131298917));
    super.setOverScrollHeader(this.b);
    super.setOverScrollListener(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetOverScrollViewForwardListener);
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void setOnTouchExtraListener(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
  }
  
  public void setPullToRefreshListener(QQStoryPullToRefreshListView.PullToRefreshListener paramPullToRefreshListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView$PullToRefreshListener = paramPullToRefreshListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView
 * JD-Core Version:    0.7.0.1
 */