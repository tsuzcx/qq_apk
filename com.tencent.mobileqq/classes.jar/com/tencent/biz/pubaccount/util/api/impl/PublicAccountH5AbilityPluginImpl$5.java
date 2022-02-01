package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.mobileqq.kandian.biz.push.api.IPushNotifyDialogCallback;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$5
  implements IPushNotifyDialogCallback
{
  PublicAccountH5AbilityPluginImpl$5(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, String paramString) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("button", paramInt1);
      localJSONObject.put("result", paramInt2);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.5
 * JD-Core Version:    0.7.0.1
 */