package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.callback.AdDownloadCallback;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class VideoFeedsGameAdComManager$1
  implements AdDownloadCallback
{
  VideoFeedsGameAdComManager$1(VideoFeedsGameAdComManager paramVideoFeedsGameAdComManager) {}
  
  public void a(ADVideoAppDownloadData paramADVideoAppDownloadData, int paramInt1, int paramInt2)
  {
    if ((paramADVideoAppDownloadData == null) || (paramADVideoAppDownloadData.a == null) || (VideoFeedsGameAdComManager.a(this.a) == null) || (VideoFeedsGameAdComManager.a(this.a).a == null)) {}
    while ((!"2".equals(VideoFeedsGameAdComManager.a(this.a).a.s)) || (!paramADVideoAppDownloadData.d.equals(VideoFeedsGameAdComManager.a(this.a).a.d))) {
      return;
    }
    ThreadManager.getUIHandler().post(new VideoFeedsGameAdComManager.1.1(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.1
 * JD-Core Version:    0.7.0.1
 */