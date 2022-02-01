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
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if ((VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0) != null) && (VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).isShowing())) {
        VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).dismiss();
      }
      if (VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0) == 2)
      {
        if (VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0) != null) {
          VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).dismiss();
        }
        return;
      }
      VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0, new GiftPackageDialog(VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0), 5));
      VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a((List)this.jdField_a_of_type_ComTencentUtilPair.first, (List)this.jdField_a_of_type_ComTencentUtilPair.second, VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).d, VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).jdField_a_of_type_JavaLangString, VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).b, VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).g, VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).c);
      VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).jdField_a_of_type_Long);
      VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0));
      Object localObject = new HashMap();
      ((HashMap)localObject).put("vid", VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0));
      VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0, (HashMap)localObject);
      localObject = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(null, VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).mRowKey, VideoFeedsGameAdComManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0), VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).s, VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).d, (HashMap)localObject);
      VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a((JSONObject)localObject);
      VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(true);
      VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0);
      VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(new VideoFeedsGameAdComManager.3.1.1(this));
      VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).show();
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0)).a(24).b(26).d(1).d((JSONObject)localObject).a(VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0)).a(ReportAction.EXPOSE).a(ActionEntity.GamePopWindow).e(GiftPackageManager.a(VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0), VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).jdField_a_of_type_Long, 2)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.3.1
 * JD-Core Version:    0.7.0.1
 */