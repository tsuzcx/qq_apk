package com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar;

import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.util.Pair;
import java.util.List;
import oln;
import olo;
import org.json.JSONObject;
import oro;

public class AdDownloadProxy$1$1
  implements Runnable
{
  AdDownloadProxy$1$1(AdDownloadProxy.1 param1, Activity paramActivity, Pair paramPair) {}
  
  public void run()
  {
    String str3;
    String str4;
    Object localObject1;
    String str2;
    String str1;
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Oro != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Oro.isShowing())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Oro.dismiss();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Oro = new oro(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Oro.a(true);
      str3 = "";
      str4 = "";
      localObject1 = "";
      str2 = str3;
      str1 = str4;
    }
    try
    {
      Object localObject2 = new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData.u);
      str2 = str3;
      str1 = str4;
      str3 = ((JSONObject)localObject2).optString("sActivityId");
      str2 = str3;
      str1 = str4;
      str4 = ((JSONObject)localObject2).optString("sGiftName");
      str2 = str3;
      str1 = str4;
      localObject2 = ((JSONObject)localObject2).optString("sNeedRole");
      localObject1 = localObject2;
      str1 = str4;
      str2 = str3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Oro.a((List)this.jdField_a_of_type_ComTencentUtilPair.first, (List)this.jdField_a_of_type_ComTencentUtilPair.second, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData.d, str2, str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData.g, (String)localObject1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Oro.a(new olo(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Oro.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.AdDownloadProxy.1.1
 * JD-Core Version:    0.7.0.1
 */