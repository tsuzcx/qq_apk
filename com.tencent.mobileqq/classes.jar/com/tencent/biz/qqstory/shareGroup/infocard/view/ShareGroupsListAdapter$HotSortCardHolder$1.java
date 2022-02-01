package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShareGroupsListAdapter$HotSortCardHolder$1
  implements View.OnClickListener
{
  ShareGroupsListAdapter$HotSortCardHolder$1(ShareGroupsListAdapter.HotSortCardHolder paramHotSortCardHolder, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter$HotSortCardHolder.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnUIClickListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter$HotSortCardHolder.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnUIClickListener.a(null, 0, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter$HotSortCardHolder.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.HotSortCardHolder.1
 * JD-Core Version:    0.7.0.1
 */