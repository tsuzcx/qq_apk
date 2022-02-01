package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.GuideInfoDialog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StoryListPresenter$7
  implements View.OnClickListener
{
  StoryListPresenter$7(StoryListPresenter paramStoryListPresenter, GuideInfoDialog paramGuideInfoDialog) {}
  
  public void onClick(View paramView)
  {
    StoryReportor.a("home_page", "guide_close", 0, 0, new String[0]);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.7
 * JD-Core Version:    0.7.0.1
 */