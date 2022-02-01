package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import android.app.Activity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.GiftPackageManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

class VideoFeedsGameAdComManager$3$1
  implements Runnable
{
  VideoFeedsGameAdComManager$3$1(VideoFeedsGameAdComManager.3 param3, Activity paramActivity, Pair paramPair) {}
  
  public void run()
  {
    if (!this.a.isFinishing())
    {
      if ((VideoFeedsGameAdComManager.i(this.c.this$0) != null) && (VideoFeedsGameAdComManager.i(this.c.this$0).isShowing())) {
        VideoFeedsGameAdComManager.i(this.c.this$0).dismiss();
      }
      if (VideoFeedsGameAdComManager.j(this.c.this$0) == 2)
      {
        if (VideoFeedsGameAdComManager.i(this.c.this$0) != null) {
          VideoFeedsGameAdComManager.i(this.c.this$0).dismiss();
        }
        return;
      }
      VideoFeedsGameAdComManager.a(this.c.this$0, new GiftPackageDialog(VideoFeedsGameAdComManager.h(this.c.this$0), 5));
      VideoFeedsGameAdComManager.i(this.c.this$0).a((List)this.b.first, (List)this.b.second, VideoFeedsGameAdComManager.c(this.c.this$0).e, VideoFeedsGameAdComManager.f(this.c.this$0).a, VideoFeedsGameAdComManager.f(this.c.this$0).b, VideoFeedsGameAdComManager.c(this.c.this$0).h, VideoFeedsGameAdComManager.f(this.c.this$0).c);
      VideoFeedsGameAdComManager.i(this.c.this$0).a(VideoFeedsGameAdComManager.f(this.c.this$0).d);
      VideoFeedsGameAdComManager.i(this.c.this$0).a(VideoFeedsGameAdComManager.e(this.c.this$0));
      Object localObject = new HashMap();
      ((HashMap)localObject).put("vid", VideoFeedsGameAdComManager.d(this.c.this$0));
      VideoFeedsGameAdComManager.a(this.c.this$0, (HashMap)localObject);
      localObject = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(null, VideoFeedsGameAdComManager.e(this.c.this$0).mRowKey, VideoFeedsGameAdComManager.g(this.c.this$0), VideoFeedsGameAdComManager.c(this.c.this$0).t, VideoFeedsGameAdComManager.c(this.c.this$0).e, (HashMap)localObject);
      VideoFeedsGameAdComManager.i(this.c.this$0).a((JSONObject)localObject);
      VideoFeedsGameAdComManager.i(this.c.this$0).a(true);
      VideoFeedsGameAdComManager.i(this.c.this$0).a(this.c.this$0);
      VideoFeedsGameAdComManager.i(this.c.this$0).a(new VideoFeedsGameAdComManager.3.1.1(this));
      VideoFeedsGameAdComManager.i(this.c.this$0).show();
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(VideoFeedsGameAdComManager.h(this.c.this$0)).a(24).b(26).d(1).d((JSONObject)localObject).a(VideoFeedsGameAdComManager.e(this.c.this$0)).a(ReportAction.EXPOSE).a(ActionEntity.GamePopWindow).e(GiftPackageManager.a(VideoFeedsGameAdComManager.e(this.c.this$0), VideoFeedsGameAdComManager.f(this.c.this$0).d, 2)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.3.1
 * JD-Core Version:    0.7.0.1
 */