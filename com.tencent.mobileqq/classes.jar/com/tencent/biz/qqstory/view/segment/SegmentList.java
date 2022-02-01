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
  public static int e = 0;
  public static int f = 1;
  public static int g = 2;
  private Handler a;
  private LoadingMoreHelper b;
  private String c;
  private boolean d = false;
  protected SegmentManager h;
  protected boolean i;
  private boolean m;
  private AbsListView.RecyclerListener n;
  private String o = "default";
  private AbsListView.OnScrollListener p;
  private int q = -1;
  
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
      if (this.d) {
        return false;
      }
      setAdapter(this.h);
      f();
    }
    return true;
  }
  
  private void b()
  {
    this.h = new SegmentManager(this, this);
    this.a = new Handler(Looper.getMainLooper(), new SegmentList.1(this));
    super.setRecyclerListener(this);
    super.setDragEnable(true);
    super.setSwipListListener(new SegmentList.2(this));
    super.setRightIconMenuListener(new SegmentList.3(this));
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
      if (!this.i)
      {
        h();
        this.i = true;
      }
      a(true, e);
      return;
    }
    if (this.k != null)
    {
      this.k.a(0);
      super.postDelayed(new SegmentList.6(this), 800L);
    }
    b(true, e);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    InfoPrinter.c("SwipListView", new Object[] { "allRequestCompletedButOccurError ", Integer.valueOf(paramInt1) });
    if (paramInt1 != 1)
    {
      if (paramInt1 != 3) {
        return;
      }
      if (!this.i)
      {
        h();
        this.i = true;
      }
      a(false, paramInt2);
      return;
    }
    if (this.k != null)
    {
      this.k.a(1);
      super.postDelayed(new SegmentList.7(this), 800L);
    }
    b(false, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.h.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(@NonNull SegmentView paramSegmentView)
  {
    this.h.a(paramSegmentView);
  }
  
  public void a(@NonNull String paramString)
  {
    this.h.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  public <T extends SegmentView> T b(String paramString)
  {
    return this.h.b(paramString);
  }
  
  protected void b(boolean paramBoolean, int paramInt) {}
  
  public LoadingMoreHelper c(@NonNull String paramString)
  {
    AssertUtils.checkNotEmpty(paramString);
    if (paramString.equals(this.c)) {
      return this.b;
    }
    return null;
  }
  
  public void f()
  {
    i();
  }
  
  public void h() {}
  
  public void i()
  {
    this.h.a(true);
  }
  
  public void k()
  {
    setPullToRefreshListener(new SegmentList.4(this));
    a();
    this.h.a();
    Bosses.get().postJob(new SegmentList.5(this, "SwipListView"));
  }
  
  public void l()
  {
    this.h.c();
  }
  
  protected void layoutChildren()
  {
    try
    {
      super.layoutChildren();
      this.h.e();
      if (this.m) {
        this.o = this.h.g();
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
      localStringBuilder.append(this.h.getCount());
      localStringBuilder.append(" .last segmentSimpleInfo=");
      localStringBuilder.append(this.o);
      localStringBuilder.append(" ,and current segmentSimpleInfo=");
      localStringBuilder.append(this.h.g());
      SLog.e("SwipListView", localStringBuilder.toString());
      if (this.m)
      {
        if (this.mItemCount == this.h.getCount()) {
          throw localIllegalStateException;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localIllegalStateException.toString());
        localStringBuilder.append(" ##info: mItemCount=");
        localStringBuilder.append(this.mItemCount);
        localStringBuilder.append("mAdapter.getCount()=");
        localStringBuilder.append(this.h.getCount());
        localStringBuilder.append(" .last segmentSimpleInfo=");
        localStringBuilder.append(this.o);
        localStringBuilder.append(" ,and current segmentSimpleInfo=");
        localStringBuilder.append(this.h.g());
        throw new QQStoryIllegalException(localStringBuilder.toString());
      }
      throw localIllegalStateException;
    }
  }
  
  public void m()
  {
    this.d = true;
    this.a.removeCallbacksAndMessages(null);
    this.h.d();
  }
  
  protected void o()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.b = new LoadingMoreHelper(localLoadMoreLayout, getContext().getApplicationContext());
    this.b.a(true, false);
    super.addFooterView(localLoadMoreLayout);
    super.setOnScrollListener(this);
  }
  
  public void onMovedToScrapHeap(View paramView)
  {
    this.h.a(paramView);
    AbsListView.RecyclerListener localRecyclerListener = this.n;
    if (localRecyclerListener != null) {
      localRecyclerListener.onMovedToScrapHeap(paramView);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.p;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt1 == this.q) {
      return;
    }
    this.q = paramInt1;
    if (paramInt3 - (paramInt1 + paramInt2) <= this.b.a()) {
      this.b.b(true);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.p;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.k.a(0L);
    if (!NetworkUtil.a(getContext().getApplicationContext()))
    {
      a(1, f);
      return true;
    }
    this.l.a();
    return true;
  }
  
  public void p()
  {
    this.h.b();
  }
  
  public void q()
  {
    this.h.notifyDataSetChanged();
  }
  
  public boolean r()
  {
    return this.m;
  }
  
  protected void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    this.h.a(paramInt);
  }
  
  public void s()
  {
    if (this.m) {
      super.setAdapter(this.h);
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof SegmentManager))
    {
      super.setAdapter(paramListAdapter);
      this.m = true;
      return;
    }
    throw new QQStoryIllegalException("SegmentList do not necessary call setAdapter()");
  }
  
  public void setLoadMoreComplete(@NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AssertUtils.checkNotEmpty(paramString);
    if (paramString.equals(this.c)) {
      this.b.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void setOnLoadMoreListener(@NonNull String paramString, LoadingMoreHelper.OnLoadMoreListener paramOnLoadMoreListener)
  {
    this.b.a(paramOnLoadMoreListener);
    this.c = paramString;
    AssertUtils.checkNotEmpty(paramString);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.p = paramOnScrollListener;
  }
  
  public void setRecyclerListener(AbsListView.RecyclerListener paramRecyclerListener)
  {
    this.n = paramRecyclerListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentList
 * JD-Core Version:    0.7.0.1
 */