package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.network.handler.ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent;
import com.tencent.biz.qqstory.support.logging.SLog;

public class HomeFeedPresenter$VideoNoInterestingRec
  extends UIBaseEventReceiver<HomeFeedPresenter, ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent>
{
  public HomeFeedPresenter$VideoNoInterestingRec(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent paramReportNoInterestingVideoEvent)
  {
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramReportNoInterestingVideoEvent);
    HomeFeedPresenter.a(paramHomeFeedPresenter, paramReportNoInterestingVideoEvent.a);
  }
  
  public Class acceptEventClass()
  {
    return ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent paramReportNoInterestingVideoEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.VideoNoInterestingRec
 * JD-Core Version:    0.7.0.1
 */