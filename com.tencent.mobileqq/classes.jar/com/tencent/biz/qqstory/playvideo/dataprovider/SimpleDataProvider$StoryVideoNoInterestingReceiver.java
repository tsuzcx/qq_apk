package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class SimpleDataProvider$StoryVideoNoInterestingReceiver
  extends Subscriber.SingleEventSubscriberNoRefect<ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent>
{
  SimpleDataProvider a;
  
  public SimpleDataProvider$StoryVideoNoInterestingReceiver(@NonNull SimpleDataProvider paramSimpleDataProvider)
  {
    this.a = paramSimpleDataProvider;
  }
  
  protected void a(@NonNull ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent paramReportNoInterestingVideoEvent)
  {
    if (paramReportNoInterestingVideoEvent.g.isSuccess()) {
      this.a.a(paramReportNoInterestingVideoEvent.a);
    }
  }
  
  public Class acceptEventClass()
  {
    return ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.StoryVideoNoInterestingReceiver
 * JD-Core Version:    0.7.0.1
 */