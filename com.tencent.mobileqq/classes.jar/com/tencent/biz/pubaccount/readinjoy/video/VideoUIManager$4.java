package com.tencent.biz.pubaccount.readinjoy.video;

import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils.OnPatchPlayListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;

class VideoUIManager$4
  implements ReadInJoyPatchAdUtils.OnPatchPlayListener
{
  VideoUIManager$4(VideoUIManager paramVideoUIManager) {}
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, AdvertisementInfo paramAdvertisementInfo)
  {
    VideoUIManager.a(this.a).b(2);
    VideoUIManager.a(this.a).a = paramAdvertisementInfo;
    ReadInJoyPatchAdUtils.a(this.a);
    VideoUIManager.a(this.a).setVisibility(0);
    VideoUIManager.a(this.a).setVisibility(0);
    VideoUIManager.a(this.a).setVisibility(0);
    VideoUIManager.a(this.a).a(paramVideoPlayParam, paramAdvertisementInfo, 1);
  }
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam, AdvertisementInfo paramAdvertisementInfo)
  {
    VideoUIManager.a(this.a).a = paramAdvertisementInfo;
    ReadInJoyPatchAdUtils.a(this.a);
    VideoUIManager.a(this.a).setVisibility(0);
    VideoUIManager.a(this.a).setVisibility(0);
    VideoUIManager.a(this.a).a(paramVideoPlayParam, paramAdvertisementInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.4
 * JD-Core Version:    0.7.0.1
 */