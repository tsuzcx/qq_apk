package com.tencent.biz.pubaccount.readinjoy.ad.game_component;

import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import nxw;
import omp;
import omz;
import onb;
import one;
import ooh;
import org.json.JSONObject;
import oro;

public class VideoFeedsGameAdComManager$3$1
  implements Runnable
{
  VideoFeedsGameAdComManager$3$1(VideoFeedsGameAdComManager.3 param3, Activity paramActivity, Pair paramPair) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if ((omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0) != null) && (omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).isShowing())) {
        omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).dismiss();
      }
      if (omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0) != 2) {
        break label93;
      }
      if (omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0) != null) {
        omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).dismiss();
      }
    }
    return;
    label93:
    omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0, new oro(omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0), 5));
    omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).a((List)this.jdField_a_of_type_ComTencentUtilPair.first, (List)this.jdField_a_of_type_ComTencentUtilPair.second, omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).d, omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).jdField_a_of_type_JavaLangString, omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).b, omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).g, omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).c);
    omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).jdField_a_of_type_Long);
    omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0));
    Object localObject = new HashMap();
    ((HashMap)localObject).put("vid", omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0));
    localObject = nxw.a(null, omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).mRowKey, omz.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0), omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).s, omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).d, (HashMap)localObject);
    omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).a((JSONObject)localObject);
    omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(true);
    omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0);
    omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).a(new onb(this));
    omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).show();
    nxw.a(new omp().a(omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0)).a(nxw.A).b(nxw.af).c(nxw.as).d((JSONObject)localObject).a(omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0)).e(ooh.a(omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdGame_componentVideoFeedsGameAdComManager$3.this$0).jdField_a_of_type_Long, nxw.H)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.game_component.VideoFeedsGameAdComManager.3.1
 * JD-Core Version:    0.7.0.1
 */