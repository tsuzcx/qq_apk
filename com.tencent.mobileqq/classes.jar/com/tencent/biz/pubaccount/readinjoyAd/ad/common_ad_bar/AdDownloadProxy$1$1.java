package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar;

import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.util.Pair;
import java.util.List;
import org.json.JSONObject;
import tql;
import tqm;
import txz;

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
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Txz != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Txz.isShowing())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Txz.dismiss();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Txz = new txz(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Txz.a(true);
      str3 = "";
      str4 = "";
      localObject1 = "";
      str2 = str3;
      str1 = str4;
    }
    try
    {
      Object localObject2 = new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData.u);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Txz.a((List)this.jdField_a_of_type_ComTencentUtilPair.first, (List)this.jdField_a_of_type_ComTencentUtilPair.second, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData.d, str2, str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData.g, (String)localObject1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Txz.a(new tqm(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barAdDownloadProxy$1.this$0.jdField_a_of_type_Txz.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.AdDownloadProxy.1.1
 * JD-Core Version:    0.7.0.1
 */