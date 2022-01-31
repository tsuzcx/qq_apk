package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import nmc;
import nyd;
import nzf;
import obd;
import org.json.JSONObject;
import qnv;
import qnw;
import qnz;

public class VideoFeedsGameAdComManager$2$1
  implements Runnable
{
  VideoFeedsGameAdComManager$2$1(VideoFeedsGameAdComManager.2 param2, Activity paramActivity, Pair paramPair) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if ((qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0) != null) && (qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).isShowing())) {
        qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).dismiss();
      }
      if (qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0) != 2) {
        break label93;
      }
      if (qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0) != null) {
        qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).dismiss();
      }
    }
    return;
    label93:
    qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0, new obd(qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0)));
    qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a((List)this.jdField_a_of_type_ComTencentUtilPair.first, (List)this.jdField_a_of_type_ComTencentUtilPair.second, qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).d, qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).jdField_a_of_type_JavaLangString, qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).b, qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).g, qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).c);
    qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).jdField_a_of_type_Long);
    qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0));
    Object localObject = new HashMap();
    ((HashMap)localObject).put("vid", qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0));
    localObject = nmc.a(null, qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).mRowKey, qnv.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0), qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).r, qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).d, (HashMap)localObject);
    qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a((JSONObject)localObject);
    qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(true);
    qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0);
    qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(new qnw(this));
    qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).show();
    nmc.a(new nyd().a(qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0)).a(nmc.z).b(nmc.ad).c(nmc.ao).d((JSONObject)localObject).a(qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0)).e(nzf.a(qnv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).jdField_a_of_type_Long, nmc.G)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.2.1
 * JD-Core Version:    0.7.0.1
 */