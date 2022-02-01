package com.tencent.biz.pubaccount.readinjoy.video;

import bkwm;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import odq;
import pay;
import sid;
import sie;
import tfb;

public final class VideoFeedsFirstVideoRecommendationManager$1
  implements Runnable
{
  public VideoFeedsFirstVideoRecommendationManager$1(tfb paramtfb) {}
  
  public void run()
  {
    int i = bkwm.f();
    if ((this.a instanceof VideoInfo))
    {
      localObject = (VideoInfo)this.a;
      if (i == 1) {
        odq.a(null, "", "0X8009A23", "0X8009A23", 0, 0, "", "", "", pay.a((VideoInfo)localObject, i), false);
      }
    }
    while (!(this.a instanceof VideoInfo.EntranceDownloadInfo))
    {
      return;
      odq.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", pay.a((VideoInfo)localObject, i), false);
      return;
    }
    Object localObject = (VideoInfo.EntranceDownloadInfo)this.a;
    sie localsie = new sie("", "", "", "");
    localsie.U(1).a(((VideoInfo.EntranceDownloadInfo)localObject).c).a(0).T(i).S(ReadinjoyTabFrame.a);
    odq.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", localsie.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.1
 * JD-Core Version:    0.7.0.1
 */