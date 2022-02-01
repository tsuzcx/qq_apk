package com.tencent.biz.pubaccount.readinjoy.viola.utils;

import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.PublishVideoHelper.IMoveUgcVideoCallback;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class ViolaBizUtils$7
  implements PublishVideoHelper.IMoveUgcVideoCallback
{
  ViolaBizUtils$7(JSONObject paramJSONObject, BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
      if (paramInt == 0) {}
      for (paramInt = 0;; paramInt = -1)
      {
        localJSONObject.put("errCode", paramInt);
        this.jdField_a_of_type_OrgJsonJSONObject.put("errMsg", paramString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeJS(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeJS(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject);
      QLog.e(ViolaBizUtils.jdField_a_of_type_JavaLangString, 1, "oidb_0xe2a error! e = " + paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils.7
 * JD-Core Version:    0.7.0.1
 */