package com.tencent.biz.qqstory.shareGroup.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StoryPickerHorizontalListAdapter$ItemHolder$1
  implements View.OnClickListener
{
  StoryPickerHorizontalListAdapter$ItemHolder$1(StoryPickerHorizontalListAdapter.ItemHolder paramItemHolder) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (this.a.a.a != null) {
      this.a.a.a.a(paramView, this.a.a.a(i));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListAdapter.ItemHolder.1
 * JD-Core Version:    0.7.0.1
 */