package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;

class VideoUIManager$6
  implements Runnable
{
  VideoUIManager$6(VideoUIManager paramVideoUIManager) {}
  
  public void run()
  {
    if ((VideoUIManager.a(this.this$0) != null) && (VideoUIManager.a(this.this$0).a != null)) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008ACD", "0X8008ACD", 0, 0, "", "", "", VideoReporter.a(VideoUIManager.a(this.this$0).a.mVideoVid, VideoUIManager.a(this.this$0).a.innerUniqueID, (int)VideoUIManager.a(this.this$0).a.mChannelID, null), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.6
 * JD-Core Version:    0.7.0.1
 */