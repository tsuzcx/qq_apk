package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.GiftPackageManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

class VideoFeedsGameAdComManager$3
  implements Runnable
{
  VideoFeedsGameAdComManager$3(VideoFeedsGameAdComManager paramVideoFeedsGameAdComManager) {}
  
  public void run()
  {
    if ((VideoFeedsGameAdComManager.c(this.this$0) != null) && (!TextUtils.isEmpty(VideoFeedsGameAdComManager.c(this.this$0).e)) && (VideoFeedsGameAdComManager.c(this.this$0).v != null)) {
      try
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("vid", VideoFeedsGameAdComManager.d(this.this$0));
        VideoFeedsGameAdComManager.a(this.this$0, (HashMap)localObject);
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(VideoFeedsGameAdComManager.h(this.this$0)).a(24).b(26).d(1).a(VideoFeedsGameAdComManager.e(this.this$0)).a(ReportAction.CLICK).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(null, VideoFeedsGameAdComManager.e(this.this$0).mRowKey, VideoFeedsGameAdComManager.g(this.this$0), VideoFeedsGameAdComManager.c(this.this$0).t, VideoFeedsGameAdComManager.c(this.this$0).e, (HashMap)localObject)).e(GiftPackageManager.a(VideoFeedsGameAdComManager.e(this.this$0), VideoFeedsGameAdComManager.f(this.this$0).d, 1)));
        localObject = GiftPackageManager.a(VideoFeedsGameAdComManager.c(this.this$0).e);
        if (((VideoFeedsGameAdComManager.h(this.this$0) instanceof Activity)) && (((Pair)localObject).first != null) && (((List)((Pair)localObject).first).size() > 0))
        {
          Activity localActivity = VideoFeedsGameAdComManager.h(this.this$0);
          localActivity.runOnUiThread(new VideoFeedsGameAdComManager.3.1(this, localActivity, (Pair)localObject));
          return;
        }
        ThreadManager.getUIHandler().post(new VideoFeedsGameAdComManager.3.2(this));
        return;
      }
      catch (Exception localException)
      {
        QLog.e(VideoFeedsGameAdComManager.u(), 2, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.3
 * JD-Core Version:    0.7.0.1
 */