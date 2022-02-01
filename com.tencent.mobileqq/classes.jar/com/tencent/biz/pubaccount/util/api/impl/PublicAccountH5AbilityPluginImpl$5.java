package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager.IPushNotifyDialogCallback;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$5
  implements RIJPushNotifyManager.IPushNotifyDialogCallback
{
  PublicAccountH5AbilityPluginImpl$5(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, String paramString) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("button", paramInt1);
      localJSONObject.put("result", paramInt2);
      this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
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
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.5
 * JD-Core Version:    0.7.0.1
 */