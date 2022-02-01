package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.report.RIJVideoReportManager;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.IEntranceButtonDataSource;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.readinjoy.ReadInJoyHelper;

final class VideoFeedsFirstVideoRecommendationManager$1
  implements Runnable
{
  VideoFeedsFirstVideoRecommendationManager$1(IEntranceButtonDataSource paramIEntranceButtonDataSource) {}
  
  public void run()
  {
    int i = ReadInJoyHelper.f();
    if ((this.a instanceof VideoInfo))
    {
      localObject = (VideoInfo)this.a;
      if (i == 1) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009A23", "0X8009A23", 0, 0, "", "", "", RIJVideoReportManager.a((VideoInfo)localObject, i), false);
      }
    }
    while (!(this.a instanceof VideoInfo.EntranceDownloadInfo))
    {
      return;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", RIJVideoReportManager.a((VideoInfo)localObject, i), false);
      return;
    }
    Object localObject = (VideoInfo.EntranceDownloadInfo)this.a;
    VideoR5.Builder localBuilder = new VideoR5.Builder("", "", "", "");
    localBuilder.V(1).a(((VideoInfo.EntranceDownloadInfo)localObject).c).a(0).U(i).T(ReadinjoyTabFrame.b);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", localBuilder.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.1
 * JD-Core Version:    0.7.0.1
 */