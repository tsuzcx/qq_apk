package com.tencent.biz.qqstory.storyHome.tag;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TagAdapter$2
  implements View.OnClickListener
{
  TagAdapter$2(TagAdapter paramTagAdapter) {}
  
  public void onClick(View paramView)
  {
    if (TagAdapter.a(this.a) != null) {
      TagAdapter.a(this.a).f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.tag.TagAdapter.2
 * JD-Core Version:    0.7.0.1
 */