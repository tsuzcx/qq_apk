package com.tencent.biz.qqstory.storyHome.tag;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TagAdapter$TagViewHolder$1
  implements View.OnClickListener
{
  TagAdapter$TagViewHolder$1(TagAdapter.TagViewHolder paramTagViewHolder, TagAdapter.OnItemClickListener paramOnItemClickListener, TagItem.TagInfoBase paramTagInfoBase) {}
  
  public void onClick(View paramView)
  {
    TagAdapter.OnItemClickListener localOnItemClickListener = this.a;
    if (localOnItemClickListener != null) {
      localOnItemClickListener.a(this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.tag.TagAdapter.TagViewHolder.1
 * JD-Core Version:    0.7.0.1
 */