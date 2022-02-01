package com.tencent.biz.pubaccount.readinjoy.video;

import bmhv;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import olh;
import psu;
import sut;
import suu;
import tso;

public final class VideoFeedsFirstVideoRecommendationManager$1
  implements Runnable
{
  public VideoFeedsFirstVideoRecommendationManager$1(tso paramtso) {}
  
  public void run()
  {
    int i = bmhv.f();
    if ((this.a instanceof VideoInfo))
    {
      localObject = (VideoInfo)this.a;
      if (i == 1) {
        olh.a(null, "", "0X8009A23", "0X8009A23", 0, 0, "", "", "", psu.a((VideoInfo)localObject, i), false);
      }
    }
    while (!(this.a instanceof VideoInfo.EntranceDownloadInfo))
    {
      return;
      olh.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", psu.a((VideoInfo)localObject, i), false);
      return;
    }
    Object localObject = (VideoInfo.EntranceDownloadInfo)this.a;
    suu localsuu = new suu("", "", "", "");
    localsuu.U(1).a(((VideoInfo.EntranceDownloadInfo)localObject).c).a(0).T(i).S(ReadinjoyTabFrame.a);
    olh.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", localsuu.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.1
 * JD-Core Version:    0.7.0.1
 */