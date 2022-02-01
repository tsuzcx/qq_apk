package com.tencent.biz.qqstory.view.segment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qqstory.base.QQStoryIllegalException;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper.OnLoadMoreListener;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView.PullToRefreshListener;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AbsListView.RecyclerListener;
import com.tencent.widget.ListView;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

public abstract class SegmentList
  extends QQStoryPullToRefreshListView
  implements SegmentManager.RequestDataCompletedListener, AbsListView.RecyclerListener
{
  public static int c = 0;
  public static int d = 1;
  public static int e = 2;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected SegmentManager a;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private AbsListView.RecyclerListener jdField_a_of_type_ComTencentWidgetAbsListView$RecyclerListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private LoadingMoreHelper jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper;
  private String jdField_b_of_type_JavaLangString = "default";
  protected boolean b;
  private boolean c;
  
  public SegmentList(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public SegmentList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public SegmentList(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private boolean a(Message paramMessage)
  {
    if (paramMessage.what == 2)
    {
      if (this.jdField_a_of_type_Boolean) {
        return false;
      }
      setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager);
      f();
    }
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager = new SegmentManager(this, this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new SegmentList.1(this));
    super.setRecyclerListener(this);
    super.setDragEnable(true);
    super.setSwipListListener(new SegmentList.2(this));
    super.setRightIconMenuListener(new SegmentList.3(this));
  }
  
  public <T extends SegmentView> T a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(paramString);
  }
  
  public LoadingMoreHelper a(@NonNull String paramString)
  {
    AssertUtils.checkNotEmpty(paramString);
    if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper;
    }
    return null;
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    InfoPrinter.c("SwipListView", new Object[] { "allRequestCompletedAndSuccess ", Integer.valueOf(paramInt) });
    if (paramInt != 1)
    {
      if (paramInt != 3) {
        return;
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        g();
        this.jdField_b_of_type_Boolean = true;
      }
      a(true, jdField_c_of_type_Int);
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      super.postDelayed(new SegmentList.6(this), 800L);
    }
    b(true, jdField_c_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    InfoPrinter.c("SwipListView", new Object[] { "allRequestCompletedButOccurError ", Integer.valueOf(paramInt1) });
    if (paramInt1 != 1)
    {
      if (paramInt1 != 3) {
        return;
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        g();
        this.jdField_b_of_type_Boolean = true;
      }
      a(false, paramInt2);
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
      super.postDelayed(new SegmentList.7(this), 800L);
    }
    b(false, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(@NonNull SegmentView paramSegmentView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(paramSegmentView);
  }
  
  public void a(@NonNull String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void b(boolean paramBoolean, int paramInt) {}
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void f()
  {
    h();
  }
  
  public void g() {}
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(true);
  }
  
  public void j()
  {
    setPullToRefreshListener(new SegmentList.4(this));
    a();
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a();
    Bosses.get().postJob(new SegmentList.5(this, "SwipListView"));
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.c();
  }
  
  public void l()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.d();
  }
  
  protected void layoutChildren()
  {
    try
    {
      super.layoutChildren();
      this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.e();
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a();
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localIllegalStateException.toString());
      localStringBuilder.append(" ##info: mItemCount=");
      localStringBuilder.append(this.mItemCount);
      localStringBuilder.append("mAdapter.getCount()=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.getCount());
      localStringBuilder.append(" .last segmentSimpleInfo=");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(" ,and current segmentSimpleInfo=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a());
      SLog.e("SwipListView", localStringBuilder.toString());
      if (this.jdField_c_of_type_Boolean)
      {
        if (this.mItemCount == this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.getCount()) {
          throw localIllegalStateException;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localIllegalStateException.toString());
        localStringBuilder.append(" ##info: mItemCount=");
        localStringBuilder.append(this.mItemCount);
        localStringBuilder.append("mAdapter.getCount()=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.getCount());
        localStringBuilder.append(" .last segmentSimpleInfo=");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        localStringBuilder.append(" ,and current segmentSimpleInfo=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a());
        throw new QQStoryIllegalException(localStringBuilder.toString());
      }
      throw localIllegalStateException;
    }
  }
  
  protected void n()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper = new LoadingMoreHelper(localLoadMoreLayout, getContext().getApplicationContext());
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper.a(true, false);
    super.addFooterView(localLoadMoreLayout);
    super.setOnScrollListener(this);
  }
  
  public void o()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.b();
  }
  
  public void onMovedToScrapHeap(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(paramView);
    AbsListView.RecyclerListener localRecyclerListener = this.jdField_a_of_type_ComTencentWidgetAbsListView$RecyclerListener;
    if (localRecyclerListener != null) {
      localRecyclerListener.onMovedToScrapHeap(paramView);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt1 == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    if (paramInt3 - (paramInt1 + paramInt2) <= this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper.a()) {
      this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper.b(true);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    if (!NetworkUtil.a(getContext().getApplicationContext()))
    {
      a(1, d);
      return true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView$PullToRefreshListener.a();
    return true;
  }
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.notifyDataSetChanged();
  }
  
  public void q()
  {
    if (this.jdField_c_of_type_Boolean) {
      super.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager);
    }
  }
  
  protected void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(paramInt);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof SegmentManager))
    {
      super.setAdapter(paramListAdapter);
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    throw new QQStoryIllegalException("SegmentList do not necessary call setAdapter()");
  }
  
  public void setLoadMoreComplete(@NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AssertUtils.checkNotEmpty(paramString);
    if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void setOnLoadMoreListener(@NonNull String paramString, LoadingMoreHelper.OnLoadMoreListener paramOnLoadMoreListener)
  {
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper.a(paramOnLoadMoreListener);
    this.jdField_a_of_type_JavaLangString = paramString;
    AssertUtils.checkNotEmpty(paramString);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void setRecyclerListener(AbsListView.RecyclerListener paramRecyclerListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$RecyclerListener = paramRecyclerListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentList
 * JD-Core Version:    0.7.0.1
 */