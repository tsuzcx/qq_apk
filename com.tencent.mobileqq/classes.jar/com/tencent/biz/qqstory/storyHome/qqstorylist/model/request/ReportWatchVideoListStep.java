package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.model.ReportWatchVideoManager;
import com.tencent.biz.qqstory.model.ReportWatchVideoManager.WatchVideoBatchFinishEvent;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ReportWatchVideoListStep
  extends QQUIEventReceiver
  implements Step
{
  protected Step.FinishCallBack a;
  
  public ReportWatchVideoListStep(StoryListPresenter paramStoryListPresenter)
  {
    super(paramStoryListPresenter);
  }
  
  public Object a()
  {
    return null;
  }
  
  public String a()
  {
    return "ReportWatchVideoListStep";
  }
  
  public void a()
  {
    Dispatchers.get().registerSubscriber(this);
    ((ReportWatchVideoManager)SuperManager.a(13)).c();
  }
  
  public void a(Step.ErrorCallBack paramErrorCallBack) {}
  
  public void a(Step.FinishCallBack paramFinishCallBack)
  {
    this.a = paramFinishCallBack;
  }
  
  public void a(StoryListPresenter paramStoryListPresenter, ReportWatchVideoManager.WatchVideoBatchFinishEvent paramWatchVideoBatchFinishEvent)
  {
    Dispatchers.get().unRegisterSubscriber(this);
    if (this.a != null) {
      this.a.a(a());
    }
    for (;;)
    {
      SLog.d("Q.qqstory.home,ReportWatchVideoListStep", "receive event. step is done");
      return;
      SLog.d("Q.qqstory.home,ReportWatchVideoListStep", "finish callBack is null");
    }
  }
  
  public void a(Object paramObject) {}
  
  public boolean a()
  {
    return false;
  }
  
  public Class acceptEventClass()
  {
    return ReportWatchVideoManager.WatchVideoBatchFinishEvent.class;
  }
  
  public void b()
  {
    SLog.a("Q.qqstory.home.qqstory_step", "Q.qqstory.home,ReportWatchVideoListStep", "Q.qqstory.home,ReportWatchVideoListStep");
  }
  
  public void c()
  {
    ReportWatchVideoManager localReportWatchVideoManager = (ReportWatchVideoManager)SuperManager.a(13);
    Dispatchers.get().unRegisterSubscriber(this);
    localReportWatchVideoManager.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.ReportWatchVideoListStep
 * JD-Core Version:    0.7.0.1
 */