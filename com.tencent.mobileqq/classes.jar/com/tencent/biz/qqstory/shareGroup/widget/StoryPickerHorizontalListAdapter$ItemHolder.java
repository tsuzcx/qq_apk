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
  public StoryCoverView b;
  
  public StoryPickerHorizontalListAdapter$ItemHolder(StoryPickerHorizontalListAdapter paramStoryPickerHorizontalListAdapter, View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131430423));
    this.b = ((StoryCoverView)paramView.findViewById(2131449726));
  }
  
  void a(VideoCollectionItem.FakeVideoUIItem paramFakeVideoUIItem, int paramInt)
  {
    if (paramFakeVideoUIItem.b == null)
    {
      this.b.setImageDrawable(this.c.e.getResources().getDrawable(2130848395));
      this.b.setPollLayout(null, -1, null);
      this.b.setRateLayout(null, -1, -1L, -1);
    }
    else if (!TextUtils.isEmpty(paramFakeVideoUIItem.b.mVideoThumbnailUrl))
    {
      StoryPickerHorizontalListAdapter.a(this.c, this.b.a, paramFakeVideoUIItem.b.mVideoThumbnailUrl);
      this.b.setPollLayout(paramFakeVideoUIItem.b.getPollLayout(), -1, null);
      this.b.setRateLayout(paramFakeVideoUIItem.b.getInteractLayout(), -1, -1L, -1);
    }
    this.a.setTag(Integer.valueOf(paramInt));
    ImageView localImageView = this.a;
    if (paramFakeVideoUIItem.c) {
      paramInt = 2130841341;
    } else {
      paramInt = 2130841337;
    }
    localImageView.setImageResource(paramInt);
    if (paramFakeVideoUIItem.d) {
      this.b.setAlpha(1.0F);
    } else {
      this.b.setAlpha(0.6F);
    }
    this.a.setOnClickListener(new StoryPickerHorizontalListAdapter.ItemHolder.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListAdapter.ItemHolder
 * JD-Core Version:    0.7.0.1
 */