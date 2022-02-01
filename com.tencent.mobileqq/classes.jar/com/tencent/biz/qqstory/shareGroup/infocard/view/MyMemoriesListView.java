package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.VidToSimpleInfoHandler.GetSimpleInfoListEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryListLoadMoreView;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.util.List;

public class MyMemoriesListView
  extends QQStoryPullToRefreshListView
  implements AbsListView.OnScrollListener, OverScrollViewListener
{
  public PullRefreshHeader a;
  protected StoryListLoadMoreView b;
  public MyMemoriesListView.OnRefreshListener c;
  public BaseStoryTimeLineAdapter d;
  private int e = 5;
  private AbsListView.OnScrollListener f = null;
  
  public MyMemoriesListView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public MyMemoriesListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public MyMemoriesListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    super.setActTAG("list_qqstory_memories");
    this.a = ((PullRefreshHeader)LayoutInflater.from(getContext()).inflate(2131628132, this, false));
    this.a.setTextColor(-1, -1, -1, -1, -1);
    this.a.setHeaderBgDrawable(getResources().getDrawable(2130839580));
    super.setOverScrollHeader(this.a);
    super.setOverScrollHeight(getResources().getDimensionPixelSize(2131299643));
    this.b = new StoryListLoadMoreView(getContext());
    this.b.setState(3);
    this.b.setOnClickListener(new MyMemoriesListView.1(this));
    super.addFooterView(this.b);
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
    super.setOverScrollListener(this);
    super.setOnScrollListener(this);
  }
  
  private boolean c()
  {
    if (this.d.getCount() == 3)
    {
      int i = 0;
      while (i < this.d.getCount())
      {
        VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)this.d.getItem(i);
        if ((!localVideoCollectionItem.isEmptyFakeItem) && (!TextUtils.isEmpty(localVideoCollectionItem.collectionId))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  protected void a() {}
  
  public void a(VidToSimpleInfoHandler.GetSimpleInfoListEvent paramGetSimpleInfoListEvent)
  {
    if ((paramGetSimpleInfoListEvent.g.isSuccess()) && (paramGetSimpleInfoListEvent.b != null) && (paramGetSimpleInfoListEvent.b.size() > 0)) {
      this.d.a(paramGetSimpleInfoListEvent.a, paramGetSimpleInfoListEvent.b);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.a(0);
    } else {
      this.a.a(1);
    }
    super.postDelayed(new MyMemoriesListView.2(this), 800L);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.a.c(0L);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.f;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      return;
    }
    if (this.d.getCount() == 0) {
      return;
    }
    if (c()) {
      return;
    }
    if (getCount() - getLastVisiblePosition() <= this.e)
    {
      if ((this.b.getState() == 5) && (!NetworkUtil.isNetworkAvailable(getContext()))) {
        return;
      }
      if ((this.b.getState() != 4) && (this.b.getState() != 1))
      {
        this.b.setState(1);
        paramAbsListView = this.c;
        if (paramAbsListView != null) {
          paramAbsListView.c();
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.f;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (paramInt == 0)
    {
      a();
      if ((getCount() - getLastVisiblePosition() <= this.e) && (this.b.getState() == 5))
      {
        this.b.setState(1);
        paramAbsListView = this.c;
        if (paramAbsListView != null) {
          paramAbsListView.c();
        }
      }
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.a.b(0L);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0)
    {
      this.a.a(0L);
      paramView = this.c;
      if (paramView != null) {
        paramView.b();
      }
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.a.a(0L);
    }
  }
  
  public void setListAdapter(BaseStoryTimeLineAdapter paramBaseStoryTimeLineAdapter)
  {
    super.setAdapter(paramBaseStoryTimeLineAdapter);
    this.d = paramBaseStoryTimeLineAdapter;
  }
  
  public void setListener(MyMemoriesListView.OnRefreshListener paramOnRefreshListener, MyMemoriesListView.OnUIClickListener paramOnUIClickListener)
  {
    this.c = paramOnRefreshListener;
    this.d.a(paramOnRefreshListener, paramOnUIClickListener);
  }
  
  public void setLoadMoreState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.b.setState(4);
        return;
      }
      this.b.setState(3);
      return;
    }
    this.b.setState(5);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.f = paramOnScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.MyMemoriesListView
 * JD-Core Version:    0.7.0.1
 */