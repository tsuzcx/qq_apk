package com.tencent.biz.pubaccount.readinjoy.video;

import bgmq;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import ndn;
import obz;
import qmu;
import qmv;
import rik;

public final class VideoFeedsFirstVideoRecommendationManager$1
  implements Runnable
{
  public VideoFeedsFirstVideoRecommendationManager$1(rik paramrik) {}
  
  public void run()
  {
    int i = bgmq.e();
    if ((this.a instanceof VideoInfo))
    {
      localObject = (VideoInfo)this.a;
      if (i == 1) {
        ndn.a(null, "", "0X8009A23", "0X8009A23", 0, 0, "", "", "", obz.a((VideoInfo)localObject, i), false);
      }
    }
    while (!(this.a instanceof VideoInfo.EntranceDownloadInfo))
    {
      return;
      ndn.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", obz.a((VideoInfo)localObject, i), false);
      return;
    }
    Object localObject = (VideoInfo.EntranceDownloadInfo)this.a;
    qmv localqmv = new qmv("", "", "", "");
    localqmv.V(1).a(((VideoInfo.EntranceDownloadInfo)localObject).c).a(0).U(i).T(ReadinjoyTabFrame.a);
    ndn.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", localqmv.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.1
 * JD-Core Version:    0.7.0.1
 */