package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ors;

class BridgeModule$38$1
  implements Runnable
{
  BridgeModule$38$1(BridgeModule.38 param38, JSONObject paramJSONObject, JSONArray paramJSONArray) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("uploadVideoList", this.jdField_a_of_type_OrgJsonJSONArray);
        this.jdField_a_of_type_OrgJsonJSONObject.put("errCode", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule$38.jdField_a_of_type_Int);
        this.jdField_a_of_type_OrgJsonJSONObject.put("errMsg", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule$38.jdField_a_of_type_JavaLangString);
        JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule$38.jdField_a_of_type_Boolean) {
          continue;
        }
        i = 1;
        localJSONObject.put("hasVideoPublished", i);
        ors.a();
      }
      catch (JSONException localJSONException)
      {
        int i;
        QLog.e(BridgeModule.TAG, 1, "getUploadingVideoInfo onResult, put uploadVideoList error =" + QLog.getStackTraceString(localJSONException));
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i(BridgeModule.TAG, 2, "getUploadingVideoInfo, onResult=" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "errCode=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule$38.jdField_a_of_type_Int + "errMsg=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule$38.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule$38.jdField_a_of_type_Int != 0) {
        QLog.i(BridgeModule.TAG, 1, "responseUploadingVideoListerrCode=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule$38.jdField_a_of_type_Int + "errMsg=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule$38.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule$38.this$0.invokeJS(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule$38.b, this.jdField_a_of_type_OrgJsonJSONObject);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.38.1
 * JD-Core Version:    0.7.0.1
 */