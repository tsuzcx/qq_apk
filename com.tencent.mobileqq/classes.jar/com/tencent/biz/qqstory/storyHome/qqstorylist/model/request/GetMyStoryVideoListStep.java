package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqTodayStoryVidList;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Calendar;

public class GetMyStoryVideoListStep
  implements Step
{
  protected Step.FinishCallBack a;
  protected Step.ErrorCallBack b;
  protected GetMyStoryVideoListStep.Result c = null;
  
  public Object a()
  {
    return this.c;
  }
  
  public void a(Step.ErrorCallBack paramErrorCallBack)
  {
    this.b = paramErrorCallBack;
  }
  
  public void a(Step.FinishCallBack paramFinishCallBack)
  {
    this.a = paramFinishCallBack;
  }
  
  public void a(Object paramObject) {}
  
  public void b()
  {
    SLog.c("GetMyStoryVideoListStep", "GetMyStoryVideoListStep");
    g();
  }
  
  public String c()
  {
    return getClass().getSimpleName();
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e() {}
  
  public void f() {}
  
  protected void g()
  {
    String str = StoryApi.a("StorySvc.homepage_my_day_710");
    qqstory_service.ReqTodayStoryVidList localReqTodayStoryVidList = new qqstory_service.ReqTodayStoryVidList();
    long l = NetConnInfoCenter.getServerTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    localReqTodayStoryVidList.date.set(i * 10000 + (j + 1) * 100 + k);
    this.c = new GetMyStoryVideoListStep.Result();
    CmdTaskManger.a().a(new CommonRequest(str, localReqTodayStoryVidList, null), new GetMyStoryVideoListStep.2(this, localReqTodayStoryVidList, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryVideoListStep
 * JD-Core Version:    0.7.0.1
 */