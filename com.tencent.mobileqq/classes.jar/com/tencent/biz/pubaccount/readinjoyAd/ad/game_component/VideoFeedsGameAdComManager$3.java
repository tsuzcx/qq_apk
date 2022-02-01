package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.GiftPackageManager;
import com.tencent.mobileqq.app.ThreadManager;
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
    if ((VideoFeedsGameAdComManager.a(this.this$0) != null) && (!TextUtils.isEmpty(VideoFeedsGameAdComManager.a(this.this$0).d)) && (VideoFeedsGameAdComManager.a(this.this$0).u != null)) {
      try
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("vid", VideoFeedsGameAdComManager.a(this.this$0));
        NativeAdUtils.a(new AdReportData().a(VideoFeedsGameAdComManager.a(this.this$0)).a(24).b(26).d(1).a(VideoFeedsGameAdComManager.a(this.this$0)).a(ReportAction.CLICK).d(NativeAdUtils.a(null, VideoFeedsGameAdComManager.a(this.this$0).mRowKey, VideoFeedsGameAdComManager.b(this.this$0), VideoFeedsGameAdComManager.a(this.this$0).s, VideoFeedsGameAdComManager.a(this.this$0).d, (HashMap)localObject)).e(GiftPackageManager.a(VideoFeedsGameAdComManager.a(this.this$0).a, 1)));
        localObject = GiftPackageManager.a(VideoFeedsGameAdComManager.a(this.this$0).d);
        if (((VideoFeedsGameAdComManager.a(this.this$0) instanceof Activity)) && (((Pair)localObject).first != null) && (((List)((Pair)localObject).first).size() > 0))
        {
          Activity localActivity = VideoFeedsGameAdComManager.a(this.this$0);
          localActivity.runOnUiThread(new VideoFeedsGameAdComManager.3.1(this, localActivity, (Pair)localObject));
          return;
        }
        ThreadManager.getUIHandler().post(new VideoFeedsGameAdComManager.3.2(this));
        return;
      }
      catch (Exception localException)
      {
        QLog.e(VideoFeedsGameAdComManager.a(), 2, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.3
 * JD-Core Version:    0.7.0.1
 */