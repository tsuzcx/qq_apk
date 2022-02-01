package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.CallJs;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

final class PublicAccountH5AbilityPluginImpl$12
  implements EIPCResultCallback
{
  PublicAccountH5AbilityPluginImpl$12(BridgeModule.CallJs paramCallJs, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int j = 0;
    int i = j;
    if (paramEIPCResult != null)
    {
      i = j;
      if (paramEIPCResult.data != null) {
        i = paramEIPCResult.data.getInt("action_get_app_type");
      }
    }
    QLog.e("PublicAccountH5AbilityPlugin", 1, "getAppType is " + i);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule$CallJs != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule$CallJs.a(this.jdField_a_of_type_JavaLangString, new JSONObject().putOpt("app_type", Integer.valueOf(i)).toString());
      return;
    }
    catch (JSONException paramEIPCResult)
    {
      QLog.e("PublicAccountH5AbilityPlugin", 1, paramEIPCResult.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.12
 * JD-Core Version:    0.7.0.1
 */