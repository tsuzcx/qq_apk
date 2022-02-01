package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class VideoFeedsInterruptedAdManager$2
  implements View.OnClickListener
{
  VideoFeedsInterruptedAdManager$2(VideoFeedsInterruptedAdManager paramVideoFeedsInterruptedAdManager) {}
  
  public void onClick(View paramView)
  {
    VideoFeedsHelper.a(VideoFeedsInterruptedAdManager.a(this.a), VideoFeedsInterruptedAdManager.a(this.a).a);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", VideoFeedsInterruptedAdManager.a(this.a).getCurrentAccountUin());
      label45:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009BF2", "0X8009BF2", 0, 0, "", "", "", VideoReporter.a(null, null, VideoFeedsInterruptedAdManager.a(this.a).a.a.a, VideoFeedsInterruptedAdManager.a(this.a).a.a.g, localJSONObject), false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsInterruptedAdManager.2
 * JD-Core Version:    0.7.0.1
 */