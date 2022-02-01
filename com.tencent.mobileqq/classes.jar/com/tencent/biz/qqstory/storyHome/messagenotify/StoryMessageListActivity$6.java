package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StoryMessageListActivity$6
  implements View.OnClickListener
{
  StoryMessageListActivity$6(StoryMessageListActivity paramStoryMessageListActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(this.jdField_a_of_type_Int);
    StoryReportor.a("play_video", "del_notice", 0, 0, new String[] { "", "", "", "" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.6
 * JD-Core Version:    0.7.0.1
 */