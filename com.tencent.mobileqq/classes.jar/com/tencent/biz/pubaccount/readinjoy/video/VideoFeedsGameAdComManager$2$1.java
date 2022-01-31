package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import nbe;
import nmv;
import nnx;
import npv;
import org.json.JSONObject;
import qca;
import qcb;
import qce;

public class VideoFeedsGameAdComManager$2$1
  implements Runnable
{
  VideoFeedsGameAdComManager$2$1(VideoFeedsGameAdComManager.2 param2, Activity paramActivity, Pair paramPair) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if ((qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0) != null) && (qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).isShowing())) {
        qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).dismiss();
      }
      if (qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0) != 2) {
        break label93;
      }
      if (qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0) != null) {
        qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).dismiss();
      }
    }
    return;
    label93:
    qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0, new npv(qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0)));
    qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a((List)this.jdField_a_of_type_ComTencentUtilPair.first, (List)this.jdField_a_of_type_ComTencentUtilPair.second, qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).d, qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).jdField_a_of_type_JavaLangString, qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).b, qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).g, qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).c);
    qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).jdField_a_of_type_Long);
    qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0));
    Object localObject = new HashMap();
    ((HashMap)localObject).put("vid", qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0));
    localObject = nbe.a(null, qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).mRowKey, qca.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0), qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).r, qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).d, (HashMap)localObject);
    qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a((JSONObject)localObject);
    qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(true);
    qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0);
    qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(new qcb(this));
    qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).show();
    nbe.a(new nmv().a(qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0)).a(nbe.z).b(nbe.ad).c(nbe.ao).d((JSONObject)localObject).a(qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0)).e(nnx.a(qca.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).jdField_a_of_type_Long, nbe.G)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.2.1
 * JD-Core Version:    0.7.0.1
 */