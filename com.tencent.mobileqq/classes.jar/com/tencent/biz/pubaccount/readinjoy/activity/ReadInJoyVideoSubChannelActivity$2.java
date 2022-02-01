package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyVideoSubChannelActivity$2
  implements Runnable
{
  ReadInJoyVideoSubChannelActivity$2(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007413", "0X8007413", 0, 0, "", "1", "", VideoReporter.a(ReadInJoyVideoSubChannelActivity.a(this.this$0), null), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity.2
 * JD-Core Version:    0.7.0.1
 */