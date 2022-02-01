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
  private int jdField_a_of_type_Int = 5;
  public BaseStoryTimeLineAdapter a;
  public MyMemoriesListView.OnRefreshListener a;
  protected StoryListLoadMoreView a;
  public PullRefreshHeader a;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
  
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
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewBaseStoryTimeLineAdapter.getCount() == 3)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewBaseStoryTimeLineAdapter.getCount())
      {
        VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewBaseStoryTimeLineAdapter.getItem(i);
        if ((!localVideoCollectionItem.isEmptyFakeItem) && (!TextUtils.isEmpty(localVideoCollectionItem.collectionId))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private void b()
  {
    super.setActTAG("list_qqstory_memories");
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getContext()).inflate(2131561753, this, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTextColor(-1, -1, -1, -1, -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setHeaderBgDrawable(getResources().getDrawable(2130839396));
    super.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    super.setOverScrollHeight(getResources().getDimensionPixelSize(2131298921));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView = new StoryListLoadMoreView(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.setState(3);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.setOnClickListener(new MyMemoriesListView.1(this));
    super.addFooterView(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView);
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
    super.setOverScrollListener(this);
    super.setOnScrollListener(this);
  }
  
  protected void a() {}
  
  public void a(VidToSimpleInfoHandler.GetSimpleInfoListEvent paramGetSimpleInfoListEvent)
  {
    if ((paramGetSimpleInfoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramGetSimpleInfoListEvent.jdField_a_of_type_JavaUtilList != null) && (paramGetSimpleInfoListEvent.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewBaseStoryTimeLineAdapter.a(paramGetSimpleInfoListEvent.jdField_a_of_type_JavaLangString, paramGetSimpleInfoListEvent.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
    }
    super.postDelayed(new MyMemoriesListView.2(this), 800L);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewBaseStoryTimeLineAdapter.getCount() == 0) {
      return;
    }
    if (a()) {
      return;
    }
    if (getCount() - getLastVisiblePosition() <= this.jdField_a_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.getState() == 5) && (!NetworkUtil.isNetworkAvailable(getContext()))) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.getState() != 4) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.getState() != 1))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.setState(1);
        paramAbsListView = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnRefreshListener;
        if (paramAbsListView != null) {
          paramAbsListView.c();
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (paramInt == 0)
    {
      a();
      if ((getCount() - getLastVisiblePosition() <= this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.getState() == 5))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.setState(1);
        paramAbsListView = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnRefreshListener;
        if (paramAbsListView != null) {
          paramAbsListView.c();
        }
      }
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnRefreshListener;
      if (paramView != null) {
        paramView.b();
      }
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    }
  }
  
  public void setListAdapter(BaseStoryTimeLineAdapter paramBaseStoryTimeLineAdapter)
  {
    super.setAdapter(paramBaseStoryTimeLineAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewBaseStoryTimeLineAdapter = paramBaseStoryTimeLineAdapter;
  }
  
  public void setListener(MyMemoriesListView.OnRefreshListener paramOnRefreshListener, MyMemoriesListView.OnUIClickListener paramOnUIClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnRefreshListener = paramOnRefreshListener;
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewBaseStoryTimeLineAdapter.a(paramOnRefreshListener, paramOnUIClickListener);
  }
  
  public void setLoadMoreState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.setState(4);
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.setState(3);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.setState(5);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.MyMemoriesListView
 * JD-Core Version:    0.7.0.1
 */