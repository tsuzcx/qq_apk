package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

class DynamicChannelDataModule$6
  implements HttpWebCgiAsyncTask.Callback
{
  DynamicChannelDataModule$6(DynamicChannelDataModule paramDynamicChannelDataModule, int paramInt) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "onResult result = ", paramJSONObject, ", requestCode = ", Integer.valueOf(paramInt) });
    if (DynamicChannelDataModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelDataModule)) {
      DynamicChannelDataModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDynamicChannelDataModule).execute(new DynamicChannelDataModule.6.1(this, paramBundle, paramJSONObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.6
 * JD-Core Version:    0.7.0.1
 */