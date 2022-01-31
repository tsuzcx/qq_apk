package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import bbev;
import bfob;
import bftk;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryListLoadMoreView;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;
import tlo;
import umf;
import umh;
import umi;
import umj;

public class MyMemoriesListView
  extends QQStoryPullToRefreshListView
  implements bfob, bftk
{
  private int jdField_a_of_type_Int = 5;
  private bfob jdField_a_of_type_Bfob;
  public StoryListLoadMoreView a;
  public PullRefreshHeader a;
  public umf a;
  public umi a;
  
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
    int i;
    if (this.jdField_a_of_type_Umf.getCount() == 3) {
      i = 0;
    }
    while (i < this.jdField_a_of_type_Umf.getCount())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)this.jdField_a_of_type_Umf.getItem(i);
      if ((!localVideoCollectionItem.isEmptyFakeItem) && (!TextUtils.isEmpty(localVideoCollectionItem.collectionId))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void b()
  {
    super.setActTAG("list_qqstory_memories");
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getContext()).inflate(2131561345, this, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTextColor(-1, -1, -1, -1, -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setHeaderBgDrawable(getResources().getDrawable(2130839135));
    super.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    super.setOverScrollHeight(getResources().getDimensionPixelSize(2131298637));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView = new StoryListLoadMoreView(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.a(3);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.setOnClickListener(new umh(this));
    super.addFooterView(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView);
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
    super.setOverScrollListener(this);
    super.setOnScrollListener(this);
  }
  
  protected void a() {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
    }
  }
  
  public void a(tlo paramtlo)
  {
    if ((paramtlo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtlo.jdField_a_of_type_JavaUtilList != null) && (paramtlo.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_Umf.a(paramtlo.jdField_a_of_type_JavaLangString, paramtlo.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
    }
    for (;;)
    {
      super.postDelayed(new MyMemoriesListView.2(this), 800L);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
      if (this.jdField_a_of_type_Umi != null) {
        this.jdField_a_of_type_Umi.b();
      }
    }
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bfob != null) {
      this.jdField_a_of_type_Bfob.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Umf.getCount() == 0) || (a()) || (getCount() - getLastVisiblePosition() > this.jdField_a_of_type_Int) || ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.a() == 5) && (!bbev.g(getContext()))) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.a() == 4) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.a() == 1));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.a(1);
    } while (this.jdField_a_of_type_Umi == null);
    this.jdField_a_of_type_Umi.c();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Bfob != null) {
      this.jdField_a_of_type_Bfob.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (paramInt == 0)
    {
      a();
      if ((getCount() - getLastVisiblePosition() <= this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.a() == 5))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.a(1);
        if (this.jdField_a_of_type_Umi != null) {
          this.jdField_a_of_type_Umi.c();
        }
      }
    }
  }
  
  public void setListAdapter(umf paramumf)
  {
    super.setAdapter(paramumf);
    this.jdField_a_of_type_Umf = paramumf;
  }
  
  public void setListener(umi paramumi, umj paramumj)
  {
    this.jdField_a_of_type_Umi = paramumi;
    this.jdField_a_of_type_Umf.a(paramumi, paramumj);
  }
  
  public void setLoadMoreState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.a(4);
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.a(3);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.a(5);
  }
  
  public void setOnScrollListener(bfob parambfob)
  {
    this.jdField_a_of_type_Bfob = parambfob;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.MyMemoriesListView
 * JD-Core Version:    0.7.0.1
 */