package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.GuideInfoDialog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StoryListPresenter$5
  implements View.OnClickListener
{
  StoryListPresenter$5(StoryListPresenter paramStoryListPresenter, GuideInfoDialog paramGuideInfoDialog) {}
  
  public void onClick(View paramView)
  {
    StoryReportor.a("home_page", "guide_shoot", 0, 0, new String[0]);
    this.b.c.a(false, true, 13, null);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.5
 * JD-Core Version:    0.7.0.1
 */