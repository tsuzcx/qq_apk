package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class PublicAccountH5AbilityPluginImpl$4
  implements EIPCResultCallback
{
  PublicAccountH5AbilityPluginImpl$4(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.data != null)
    {
      paramEIPCResult = paramEIPCResult.data.getString("action_update_biu_and_comment_request_string");
      this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramEIPCResult });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.4
 * JD-Core Version:    0.7.0.1
 */