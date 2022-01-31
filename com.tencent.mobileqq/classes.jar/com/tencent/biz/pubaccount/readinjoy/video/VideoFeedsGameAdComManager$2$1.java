package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import nmf;
import nyg;
import nzi;
import obg;
import org.json.JSONObject;
import qny;
import qnz;
import qoc;

public class VideoFeedsGameAdComManager$2$1
  implements Runnable
{
  VideoFeedsGameAdComManager$2$1(VideoFeedsGameAdComManager.2 param2, Activity paramActivity, Pair paramPair) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if ((qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0) != null) && (qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).isShowing())) {
        qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).dismiss();
      }
      if (qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0) != 2) {
        break label93;
      }
      if (qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0) != null) {
        qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).dismiss();
      }
    }
    return;
    label93:
    qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0, new obg(qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0)));
    qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a((List)this.jdField_a_of_type_ComTencentUtilPair.first, (List)this.jdField_a_of_type_ComTencentUtilPair.second, qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).d, qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).jdField_a_of_type_JavaLangString, qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).b, qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).g, qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).c);
    qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).jdField_a_of_type_Long);
    qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0));
    Object localObject = new HashMap();
    ((HashMap)localObject).put("vid", qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0));
    localObject = nmf.a(null, qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).mRowKey, qny.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0), qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).r, qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).d, (HashMap)localObject);
    qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a((JSONObject)localObject);
    qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(true);
    qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0);
    qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).a(new qnz(this));
    qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).show();
    nmf.a(new nyg().a(qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0)).a(nmf.z).b(nmf.ad).c(nmf.ao).d((JSONObject)localObject).a(qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0)).e(nzi.a(qny.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGameAdComManager$2.this$0).jdField_a_of_type_Long, nmf.G)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.2.1
 * JD-Core Version:    0.7.0.1
 */