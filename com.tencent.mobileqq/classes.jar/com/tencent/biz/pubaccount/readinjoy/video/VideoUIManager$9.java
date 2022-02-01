package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.mobileqq.qroute.QRoute;

class VideoUIManager$9
  implements Runnable
{
  VideoUIManager$9(VideoUIManager paramVideoUIManager, int paramInt) {}
  
  public void run()
  {
    if ((VideoUIManager.a(this.this$0) != null) && (VideoUIManager.a(this.this$0).a != null))
    {
      VideoR5.Builder localBuilder = new VideoR5.Builder("", "", VideoUIManager.a(this.this$0).a.mVideoVid, VideoUIManager.a(this.this$0).a.innerUniqueID).a((int)VideoUIManager.a(this.this$0).a.mChannelID);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008AD0", "0X8008AD0", 0, 0, "", "", "", localBuilder.a().a(), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009B57", "0X8009B57", 0, 0, String.valueOf(this.a), "", "", localBuilder.a().a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.9
 * JD-Core Version:    0.7.0.1
 */