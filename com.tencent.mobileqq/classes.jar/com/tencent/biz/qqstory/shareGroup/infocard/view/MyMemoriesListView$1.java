package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryListLoadMoreView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MyMemoriesListView$1
  implements View.OnClickListener
{
  MyMemoriesListView$1(MyMemoriesListView paramMyMemoriesListView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.b.getState() != 4) && (this.a.b.getState() != 1))
    {
      this.a.b.setState(1);
      if (this.a.c != null) {
        this.a.c.c();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.MyMemoriesListView.1
 * JD-Core Version:    0.7.0.1
 */