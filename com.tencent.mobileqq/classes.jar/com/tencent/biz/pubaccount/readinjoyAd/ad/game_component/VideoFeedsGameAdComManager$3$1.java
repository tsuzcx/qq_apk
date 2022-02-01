package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import nzq;
import org.json.JSONObject;
import tlx;
import tmk;
import tmm;
import tmp;
import tns;
import trg;

public class VideoFeedsGameAdComManager$3$1
  implements Runnable
{
  VideoFeedsGameAdComManager$3$1(VideoFeedsGameAdComManager.3 param3, Activity paramActivity, Pair paramPair) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if ((tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0) != null) && (tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).isShowing())) {
        tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).dismiss();
      }
      if (tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0) != 2) {
        break label93;
      }
      if (tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0) != null) {
        tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).dismiss();
      }
    }
    return;
    label93:
    tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0, new trg(tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0), 5));
    tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a((List)this.jdField_a_of_type_ComTencentUtilPair.first, (List)this.jdField_a_of_type_ComTencentUtilPair.second, tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).d, tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).jdField_a_of_type_JavaLangString, tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).b, tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).g, tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).c);
    tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).jdField_a_of_type_Long);
    tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0));
    Object localObject = new HashMap();
    ((HashMap)localObject).put("vid", tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0));
    localObject = nzq.a(null, tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).mRowKey, tmk.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0), tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).s, tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).d, (HashMap)localObject);
    tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a((JSONObject)localObject);
    tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(true);
    tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0);
    tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(new tmm(this));
    tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).show();
    nzq.a(new tlx().a(tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0)).a(nzq.A).b(nzq.af).c(nzq.as).d((JSONObject)localObject).a(tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0)).e(tns.a(tmk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).jdField_a_of_type_Long, nzq.H)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.3.1
 * JD-Core Version:    0.7.0.1
 */