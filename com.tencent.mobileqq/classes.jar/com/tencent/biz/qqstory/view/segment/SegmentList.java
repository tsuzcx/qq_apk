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
import ouy;
import ouz;
import ova;
import ovb;
import ovc;
import ovd;
import ove;

public abstract class SegmentList
  extends QQStoryPullToRefreshListView
  implements SegmentManager.RequestDataCompletedListener, AbsListView.RecyclerListener
{
  public static int c;
  public static int d = 1;
  public static int e = 2;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public SegmentManager a;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private AbsListView.RecyclerListener jdField_a_of_type_ComTencentWidgetAbsListView$RecyclerListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private LoadingMoreHelper jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper;
  private String jdField_b_of_type_JavaLangString = "default";
  public boolean b;
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
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_Boolean) {
        return false;
      }
      setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager);
      g();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager = new SegmentManager(this, this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new ouy(this));
    super.setRecyclerListener(this);
    super.setDragEnable(true);
    super.setSwipListListener(new ouz(this));
    super.setRightIconMenuListener(new ova(this));
  }
  
  public SegmentView a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(paramString);
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    InfoPrinter.c("SwipListView", new Object[] { "allRequestCompletedAndSuccess ", Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 1: 
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
        super.postDelayed(new ovd(this), 800L);
      }
      b(true, jdField_c_of_type_Int);
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      h();
      this.jdField_b_of_type_Boolean = true;
    }
    a(true, jdField_c_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    InfoPrinter.c("SwipListView", new Object[] { "allRequestCompletedButOccurError ", Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    case 2: 
    default: 
      return;
    case 1: 
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
        super.postDelayed(new ove(this), 800L);
      }
      b(false, paramInt2);
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      h();
      this.jdField_b_of_type_Boolean = true;
    }
    a(false, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(@NonNull SegmentView paramSegmentView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(paramSegmentView);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt1 == this.jdField_a_of_type_Int) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
    } while (paramInt3 - (paramInt1 + paramInt2) > this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper.a());
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper.b(true);
  }
  
  public void a(@NonNull String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
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
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(paramView);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$RecyclerListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$RecyclerListener.b(paramView);
    }
  }
  
  public void b(boolean paramBoolean, int paramInt) {}
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void g()
  {
    i();
  }
  
  public void h() {}
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(true);
  }
  
  public void k()
  {
    setPullToRefreshListener(new ovb(this));
    a();
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a();
    Bosses.get().postJob(new ovc(this));
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.c();
  }
  
  public void layoutChildren()
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
      SLog.e("SwipListView", localIllegalStateException.toString() + " ##info: mItemCount=" + this.mItemCount + "mAdapter.getCount()=" + this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.getCount() + " .last segmentSimpleInfo=" + this.jdField_b_of_type_JavaLangString + " ,and current segmentSimpleInfo=" + this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a());
      if (!this.jdField_c_of_type_Boolean) {
        throw localIllegalStateException;
      }
      if (this.mItemCount == this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.getCount()) {
        throw localIllegalStateException;
      }
      throw new QQStoryIllegalException(localIllegalStateException.toString() + " ##info: mItemCount=" + this.mItemCount + "mAdapter.getCount()=" + this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.getCount() + " .last segmentSimpleInfo=" + this.jdField_b_of_type_JavaLangString + " ,and current segmentSimpleInfo=" + this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a());
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.d();
  }
  
  protected void o()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper = new LoadingMoreHelper(localLoadMoreLayout, getContext().getApplicationContext());
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper.a(true, false);
    super.addFooterView(localLoadMoreLayout);
    super.setOnScrollListener(this);
  }
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.b();
  }
  
  public void q()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.notifyDataSetChanged();
  }
  
  public void r()
  {
    if (this.jdField_c_of_type_Boolean) {
      super.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager);
    }
  }
  
  public void reportScrollStateChange(int paramInt)
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
    AssertUtils.a(paramString);
    if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void setOnLoadMoreListener(@NonNull String paramString, LoadingMoreHelper.OnLoadMoreListener paramOnLoadMoreListener)
  {
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper.a(paramOnLoadMoreListener);
    this.jdField_a_of_type_JavaLangString = paramString;
    AssertUtils.a(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentList
 * JD-Core Version:    0.7.0.1
 */