package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.GuideInfoDialog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StoryListPresenter$4$1$3
  implements View.OnClickListener
{
  StoryListPresenter$4$1$3(StoryListPresenter.4.1 param1) {}
  
  public void onClick(View paramView)
  {
    StoryReportor.a("home_page", "clk_up_close", 0, 0, new String[0]);
    this.a.b.this$0.h.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4.1.3
 * JD-Core Version:    0.7.0.1
 */