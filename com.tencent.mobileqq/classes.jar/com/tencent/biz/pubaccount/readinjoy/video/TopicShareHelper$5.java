package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;

class TopicShareHelper$5
  implements Runnable
{
  TopicShareHelper$5(TopicShareHelper paramTopicShareHelper, String paramString) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80088B4", "0X80088B4", 0, 0, "", this.a, "", VideoReporter.a(TopicShareHelper.a(this.this$0).mChannelID, null), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper.5
 * JD-Core Version:    0.7.0.1
 */