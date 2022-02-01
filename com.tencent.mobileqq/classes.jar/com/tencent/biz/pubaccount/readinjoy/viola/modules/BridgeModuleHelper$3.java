package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager.IPushNotifyDialogCallback;
import org.json.JSONException;
import org.json.JSONObject;

final class BridgeModuleHelper$3
  implements RIJPushNotifyManager.IPushNotifyDialogCallback
{
  BridgeModuleHelper$3(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("button", paramInt1);
      localJSONObject.put("result", paramInt2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeJS(this.jdField_a_of_type_JavaLangString, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModuleHelper.3
 * JD-Core Version:    0.7.0.1
 */