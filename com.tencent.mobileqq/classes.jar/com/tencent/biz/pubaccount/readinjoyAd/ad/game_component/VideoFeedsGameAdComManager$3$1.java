package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import ois;
import org.json.JSONObject;
import ufy;
import ugq;
import ugs;
import ugv;
import uhw;
import ulx;

public class VideoFeedsGameAdComManager$3$1
  implements Runnable
{
  VideoFeedsGameAdComManager$3$1(VideoFeedsGameAdComManager.3 param3, Activity paramActivity, Pair paramPair) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if ((ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0) != null) && (ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).isShowing())) {
        ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).dismiss();
      }
      if (ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0) != 2) {
        break label93;
      }
      if (ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0) != null) {
        ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).dismiss();
      }
    }
    return;
    label93:
    ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0, new ulx(ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0), 5));
    ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a((List)this.jdField_a_of_type_ComTencentUtilPair.first, (List)this.jdField_a_of_type_ComTencentUtilPair.second, ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).d, ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).jdField_a_of_type_JavaLangString, ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).b, ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).g, ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).c);
    ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).jdField_a_of_type_Long);
    ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0));
    Object localObject = new HashMap();
    ((HashMap)localObject).put("vid", ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0));
    localObject = ois.a(null, ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).mRowKey, ugq.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0), ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).s, ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).d, (HashMap)localObject);
    ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a((JSONObject)localObject);
    ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(true);
    ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0);
    ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(new ugs(this));
    ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).show();
    ois.a(new ufy().a(ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0)).a(24).b(26).c(1).d((JSONObject)localObject).a(ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0)).e(uhw.a(ugq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$3.this$0).jdField_a_of_type_Long, 2)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.3.1
 * JD-Core Version:    0.7.0.1
 */