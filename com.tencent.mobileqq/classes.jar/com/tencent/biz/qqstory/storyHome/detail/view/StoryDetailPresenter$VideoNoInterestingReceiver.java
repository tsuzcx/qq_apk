package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.network.handler.ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent;

public class StoryDetailPresenter$VideoNoInterestingReceiver
  extends UIBaseEventReceiver<StoryDetailPresenter, ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent>
{
  public StoryDetailPresenter$VideoNoInterestingReceiver(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent paramReportNoInterestingVideoEvent)
  {
    StoryDetailPresenter.a(paramStoryDetailPresenter, paramReportNoInterestingVideoEvent.a, this.TAG);
  }
  
  public Class acceptEventClass()
  {
    return ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent paramReportNoInterestingVideoEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.VideoNoInterestingReceiver
 * JD-Core Version:    0.7.0.1
 */