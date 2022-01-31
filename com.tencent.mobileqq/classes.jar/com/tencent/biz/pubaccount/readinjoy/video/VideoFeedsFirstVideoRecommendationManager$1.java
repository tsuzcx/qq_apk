package com.tencent.biz.pubaccount.readinjoy.video;

import bjxj;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import nrt;
import ors;
import rom;
import ron;
import slk;

public final class VideoFeedsFirstVideoRecommendationManager$1
  implements Runnable
{
  public VideoFeedsFirstVideoRecommendationManager$1(slk paramslk) {}
  
  public void run()
  {
    int i = bjxj.e();
    if ((this.a instanceof VideoInfo))
    {
      localObject = (VideoInfo)this.a;
      if (i == 1) {
        nrt.a(null, "", "0X8009A23", "0X8009A23", 0, 0, "", "", "", ors.a((VideoInfo)localObject, i), false);
      }
    }
    while (!(this.a instanceof VideoInfo.EntranceDownloadInfo))
    {
      return;
      nrt.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", ors.a((VideoInfo)localObject, i), false);
      return;
    }
    Object localObject = (VideoInfo.EntranceDownloadInfo)this.a;
    ron localron = new ron("", "", "", "");
    localron.V(1).a(((VideoInfo.EntranceDownloadInfo)localObject).c).a(0).U(i).T(ReadinjoyTabFrame.a);
    nrt.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", localron.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.1
 * JD-Core Version:    0.7.0.1
 */