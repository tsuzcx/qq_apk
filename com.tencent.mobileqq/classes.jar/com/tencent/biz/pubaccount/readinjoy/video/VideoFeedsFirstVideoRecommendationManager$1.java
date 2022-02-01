package com.tencent.biz.pubaccount.readinjoy.video;

import bmqa;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import oat;
import pha;
import skb;
import skc;
import tkf;

public final class VideoFeedsFirstVideoRecommendationManager$1
  implements Runnable
{
  public VideoFeedsFirstVideoRecommendationManager$1(tkf paramtkf) {}
  
  public void run()
  {
    int i = bmqa.d();
    if ((this.a instanceof VideoInfo))
    {
      localObject = (VideoInfo)this.a;
      if (i == 1) {
        oat.a(null, "", "0X8009A23", "0X8009A23", 0, 0, "", "", "", pha.a((VideoInfo)localObject, i), false);
      }
    }
    while (!(this.a instanceof VideoInfo.EntranceDownloadInfo))
    {
      return;
      oat.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", pha.a((VideoInfo)localObject, i), false);
      return;
    }
    Object localObject = (VideoInfo.EntranceDownloadInfo)this.a;
    skc localskc = new skc("", "", "", "");
    localskc.V(1).a(((VideoInfo.EntranceDownloadInfo)localObject).c).a(0).U(i).T(ReadinjoyTabFrame.a);
    oat.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", localskc.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.1
 * JD-Core Version:    0.7.0.1
 */