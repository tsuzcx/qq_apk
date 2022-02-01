package com.tencent.biz.pubaccount.readinjoy.viola.utils;

import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pnn;
import tzr;

class ViolaBizUtils$3$1
  implements Runnable
{
  ViolaBizUtils$3$1(ViolaBizUtils.3 param3, JSONObject paramJSONObject, JSONArray paramJSONArray) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("uploadVideoList", this.jdField_a_of_type_OrgJsonJSONArray);
        this.jdField_a_of_type_OrgJsonJSONObject.put("errCode", this.this$0.jdField_a_of_type_Int);
        this.jdField_a_of_type_OrgJsonJSONObject.put("errMsg", this.this$0.jdField_a_of_type_JavaLangString);
        JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
        if (!this.this$0.jdField_a_of_type_Boolean) {
          continue;
        }
        i = 1;
        localJSONObject.put("hasVideoPublished", i);
        pnn.a();
      }
      catch (JSONException localJSONException)
      {
        int i;
        QLog.e(tzr.jdField_a_of_type_JavaLangString, 1, "getUploadingVideoInfo onResult, put uploadVideoList error =" + QLog.getStackTraceString(localJSONException));
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i(tzr.jdField_a_of_type_JavaLangString, 2, "getUploadingVideoInfo, onResult=" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "errCode=" + this.this$0.jdField_a_of_type_Int + "errMsg=" + this.this$0.jdField_a_of_type_JavaLangString);
      }
      if (this.this$0.jdField_a_of_type_Int != 0) {
        QLog.i(tzr.jdField_a_of_type_JavaLangString, 1, "responseUploadingVideoListerrCode=" + this.this$0.jdField_a_of_type_Int + "errMsg=" + this.this$0.jdField_a_of_type_JavaLangString);
      }
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeJS(this.this$0.b, this.jdField_a_of_type_OrgJsonJSONObject);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils.3.1
 * JD-Core Version:    0.7.0.1
 */