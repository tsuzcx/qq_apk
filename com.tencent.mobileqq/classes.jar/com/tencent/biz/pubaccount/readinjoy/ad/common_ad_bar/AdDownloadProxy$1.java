package com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.List;
import mqq.os.MqqHandler;
import oln;
import ooh;

public class AdDownloadProxy$1
  implements Runnable
{
  public AdDownloadProxy$1(oln paramoln) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData.d)) && (this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData.u != null))
    {
      Pair localPair = ooh.a(this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData.d);
      if (((this.this$0.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (localPair.first != null) && (((List)localPair.first).size() > 0))
      {
        Activity localActivity = (Activity)this.this$0.jdField_a_of_type_AndroidContentContext;
        localActivity.runOnUiThread(new AdDownloadProxy.1.1(this, localActivity, localPair));
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new AdDownloadProxy.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.AdDownloadProxy.1
 * JD-Core Version:    0.7.0.1
 */