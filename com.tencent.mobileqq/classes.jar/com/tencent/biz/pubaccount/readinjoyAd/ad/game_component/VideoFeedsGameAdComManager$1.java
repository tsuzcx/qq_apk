package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
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
    if ((paramADVideoAppDownloadData != null) && (paramADVideoAppDownloadData.p != null) && (VideoFeedsGameAdComManager.a(this.a) != null))
    {
      if (VideoFeedsGameAdComManager.a(this.a).p == null) {
        return;
      }
      if (("2".equals(VideoFeedsGameAdComManager.a(this.a).p.t)) && (paramADVideoAppDownloadData.d.equals(VideoFeedsGameAdComManager.a(this.a).p.e))) {
        ThreadManager.getUIHandler().post(new VideoFeedsGameAdComManager.1.1(this, paramInt1, paramInt2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.1
 * JD-Core Version:    0.7.0.1
 */