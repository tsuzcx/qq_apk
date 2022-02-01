package com.tencent.biz.pubaccount.readinjoy.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.CallCommentJs;
import eipc.EIPCResult;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyIPCModule$1
  implements BridgeModule.CallCommentJs
{
  ReadInJoyIPCModule$1(ReadInJoyIPCModule paramReadInJoyIPCModule, int paramInt, RIJBiuAndCommentMixDataManager paramRIJBiuAndCommentMixDataManager) {}
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("arg_callback", paramString);
      paramString = new Bundle();
      paramString.putString("action_update_biu_and_comment_request_string", paramJSONObject.toString());
      paramString = EIPCResult.createResult(0, paramString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyIpcReadInJoyIPCModule.callbackResult(this.jdField_a_of_type_Int, paramString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager.a();
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ipc.ReadInJoyIPCModule.1
 * JD-Core Version:    0.7.0.1
 */