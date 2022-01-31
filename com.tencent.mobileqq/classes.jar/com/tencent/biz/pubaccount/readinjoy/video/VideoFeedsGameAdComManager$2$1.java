package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import noy;
import obk;
import ocp;
import oev;
import org.json.JSONObject;
import rcz;
import rda;
import rdd;

public class VideoFeedsGameAdComManager$2$1
  implements Runnable
{
  VideoFeedsGameAdComManager$2$1(VideoFeedsGameAdComManager.2 param2, Activity paramActivity, Pair paramPair) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if ((rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0) != null) && (rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).isShowing())) {
        rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).dismiss();
      }
      if (rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0) != 2) {
        break label93;
      }
      if (rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0) != null) {
        rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).dismiss();
      }
    }
    return;
    label93:
    rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0, new oev(rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0)));
    rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a((List)this.jdField_a_of_type_ComTencentUtilPair.first, (List)this.jdField_a_of_type_ComTencentUtilPair.second, rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).d, rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).jdField_a_of_type_JavaLangString, rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).b, rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).g, rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).c);
    rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).jdField_a_of_type_Long);
    rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0));
    Object localObject = new HashMap();
    ((HashMap)localObject).put("vid", rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0));
    localObject = noy.a(null, rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).mRowKey, rcz.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0), rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).r, rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).d, (HashMap)localObject);
    rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a((JSONObject)localObject);
    rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(true);
    rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0);
    rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(new rda(this));
    rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).show();
    noy.a(new obk().a(rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0)).a(noy.z).b(noy.ad).c(noy.ao).d((JSONObject)localObject).a(rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0)).e(ocp.a(rcz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).jdField_a_of_type_Long, noy.G)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.2.1
 * JD-Core Version:    0.7.0.1
 */