package com.tencent.biz.qqstory.shareGroup.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;

public class StoryPickerHorizontalListAdapter$ItemHolder
{
  public ImageView a;
  public StoryCoverView a;
  
  public StoryPickerHorizontalListAdapter$ItemHolder(StoryPickerHorizontalListAdapter paramStoryPickerHorizontalListAdapter, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364394));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView = ((StoryCoverView)paramView.findViewById(2131380758));
  }
  
  void a(VideoCollectionItem.FakeVideoUIItem paramFakeVideoUIItem, int paramInt)
  {
    if (paramFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListAdapter.a.getResources().getDrawable(2130846843));
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(null, -1, null);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(null, -1, -1L, -1);
    }
    else if (!TextUtils.isEmpty(paramFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl))
    {
      StoryPickerHorizontalListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListAdapter, this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.jdField_a_of_type_AndroidWidgetImageView, paramFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(paramFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(paramFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(paramInt));
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramFakeVideoUIItem.jdField_a_of_type_Boolean) {
      paramInt = 2130840575;
    } else {
      paramInt = 2130840571;
    }
    localImageView.setImageResource(paramInt);
    if (paramFakeVideoUIItem.b) {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setAlpha(1.0F);
    } else {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setAlpha(0.6F);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new StoryPickerHorizontalListAdapter.ItemHolder.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListAdapter.ItemHolder
 * JD-Core Version:    0.7.0.1
 */