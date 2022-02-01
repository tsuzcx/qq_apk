package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.GuideInfoDialog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StoryListPresenter$4$1$1
  implements View.OnClickListener
{
  StoryListPresenter$4$1$1(StoryListPresenter.4.1 param1) {}
  
  public void onClick(View paramView)
  {
    StoryReportor.a("home_page", "clk_up_shoot", 0, 0, new String[0]);
    this.a.a.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a(false, true, 13, null);
    this.a.a.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4.1.1
 * JD-Core Version:    0.7.0.1
 */