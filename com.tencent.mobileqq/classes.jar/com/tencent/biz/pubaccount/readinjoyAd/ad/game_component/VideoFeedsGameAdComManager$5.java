package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;

class VideoFeedsGameAdComManager$5
  implements DialogInterface.OnClickListener
{
  VideoFeedsGameAdComManager$5(VideoFeedsGameAdComManager paramVideoFeedsGameAdComManager, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a)
    {
      if (VideoFeedsGameAdComManager.k(this.b)) {
        return;
      }
      this.b.e();
      return;
    }
    if ((VideoFeedsGameAdComManager.h(this.b) instanceof Activity))
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addGdtWebClickReport(VideoFeedsGameAdComManager.e(this.b));
      FastWeqAdUtils.a(VideoFeedsGameAdComManager.h(this.b), VideoFeedsGameAdComManager.c(this.b).q, VideoFeedsGameAdComManager.c(this.b).r, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.5
 * JD-Core Version:    0.7.0.1
 */