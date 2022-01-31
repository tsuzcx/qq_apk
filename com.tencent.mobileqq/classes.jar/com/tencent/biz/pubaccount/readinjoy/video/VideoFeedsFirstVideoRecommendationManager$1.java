package com.tencent.biz.pubaccount.readinjoy.video;

import bhvh;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import noo;
import onk;
import qzd;
import qze;
import rva;

public final class VideoFeedsFirstVideoRecommendationManager$1
  implements Runnable
{
  public VideoFeedsFirstVideoRecommendationManager$1(rva paramrva) {}
  
  public void run()
  {
    int i = bhvh.e();
    if ((this.a instanceof VideoInfo))
    {
      localObject = (VideoInfo)this.a;
      if (i == 1) {
        noo.a(null, "", "0X8009A23", "0X8009A23", 0, 0, "", "", "", onk.a((VideoInfo)localObject, i), false);
      }
    }
    while (!(this.a instanceof VideoInfo.EntranceDownloadInfo))
    {
      return;
      noo.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", onk.a((VideoInfo)localObject, i), false);
      return;
    }
    Object localObject = (VideoInfo.EntranceDownloadInfo)this.a;
    qze localqze = new qze("", "", "", "");
    localqze.W(1).a(((VideoInfo.EntranceDownloadInfo)localObject).c).a(0).V(i).U(ReadinjoyTabFrame.a);
    noo.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", localqze.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.1
 * JD-Core Version:    0.7.0.1
 */