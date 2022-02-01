package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

class DynamicChannelHeaderModule$2
  implements HttpWebCgiAsyncTask.Callback
{
  DynamicChannelHeaderModule$2(DynamicChannelHeaderModule paramDynamicChannelHeaderModule, int paramInt, ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig paramOfflineHeaderConfig) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "onResult result = ", paramJSONObject, ", requestCode = ", Integer.valueOf(paramInt) });
    if (DynamicChannelHeaderModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelHeaderModule)) {
      DynamicChannelHeaderModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelHeaderModule).execute(new DynamicChannelHeaderModule.2.1(this, paramJSONObject, paramBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelHeaderModule.2
 * JD-Core Version:    0.7.0.1
 */