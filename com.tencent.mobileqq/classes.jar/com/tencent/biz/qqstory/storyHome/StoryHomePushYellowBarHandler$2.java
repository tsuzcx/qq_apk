package com.tencent.biz.qqstory.storyHome;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StoryHomePushYellowBarHandler$2
  implements View.OnClickListener
{
  StoryHomePushYellowBarHandler$2(StoryHomePushYellowBarHandler paramStoryHomePushYellowBarHandler) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    this.a.c.j();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.StoryHomePushYellowBarHandler.2
 * JD-Core Version:    0.7.0.1
 */