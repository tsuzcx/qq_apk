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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364505));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView = ((StoryCoverView)paramView.findViewById(2131381523));
  }
  
  void a(VideoCollectionItem.FakeVideoUIItem paramFakeVideoUIItem, int paramInt)
  {
    if (paramFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListAdapter.a.getResources().getDrawable(2130846965));
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(null, -1, null);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(null, -1, -1L, -1);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(paramInt));
      ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramFakeVideoUIItem.jdField_a_of_type_Boolean) {
        break label186;
      }
      paramInt = 2130840700;
      label78:
      localImageView.setImageResource(paramInt);
      if (!paramFakeVideoUIItem.b) {
        break label192;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setAlpha(1.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new StoryPickerHorizontalListAdapter.ItemHolder.1(this));
      return;
      if (TextUtils.isEmpty(paramFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl)) {
        break;
      }
      StoryPickerHorizontalListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListAdapter, this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.jdField_a_of_type_AndroidWidgetImageView, paramFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(paramFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(paramFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
      break;
      label186:
      paramInt = 2130840696;
      break label78;
      label192:
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setAlpha(0.6F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListAdapter.ItemHolder
 * JD-Core Version:    0.7.0.1
 */