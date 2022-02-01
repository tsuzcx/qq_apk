package com.tencent.biz.pubaccount.readinjoy.video;

import bnrf;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import ocd;
import ozs;
import sbf;
import sbg;
import tay;

public final class VideoFeedsFirstVideoRecommendationManager$1
  implements Runnable
{
  public VideoFeedsFirstVideoRecommendationManager$1(tay paramtay) {}
  
  public void run()
  {
    int i = bnrf.e();
    if ((this.a instanceof VideoInfo))
    {
      localObject = (VideoInfo)this.a;
      if (i == 1) {
        ocd.a(null, "", "0X8009A23", "0X8009A23", 0, 0, "", "", "", ozs.a((VideoInfo)localObject, i), false);
      }
    }
    while (!(this.a instanceof VideoInfo.EntranceDownloadInfo))
    {
      return;
      ocd.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", ozs.a((VideoInfo)localObject, i), false);
      return;
    }
    Object localObject = (VideoInfo.EntranceDownloadInfo)this.a;
    sbg localsbg = new sbg("", "", "", "");
    localsbg.U(1).a(((VideoInfo.EntranceDownloadInfo)localObject).c).a(0).T(i).S(ReadinjoyTabFrame.a);
    ocd.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", localsbg.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.1
 * JD-Core Version:    0.7.0.1
 */