package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$2
  implements Runnable
{
  PublicAccountH5AbilityPluginImpl$2(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, JSONArray paramJSONArray, JSONObject paramJSONObject) {}
  
  public void run()
  {
    CompressInfo localCompressInfo = new CompressInfo(this.this$0.cameraPath, 0);
    localCompressInfo.f = 0;
    CompressOperator.a(localCompressInfo);
    String str;
    if (!StringUtil.a(localCompressInfo.e))
    {
      str = "mqqpa://resourceid/" + this.this$0.cameraUUid;
      PublicAccountH5AbilityPluginImpl.localIdMap.put(str, localCompressInfo.e);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONArray.put(0, str);
        this.jdField_a_of_type_OrgJsonJSONObject.put("value", this.jdField_a_of_type_OrgJsonJSONArray);
        this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", 0);
        this.jdField_a_of_type_OrgJsonJSONObject.put("msg", "Success");
        this.jdField_a_of_type_OrgJsonJSONObject.put("sourceType", "camera");
        this.this$0.callJs(this.this$0.cameraCallback, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
        this.this$0.cameraPath = "";
        this.this$0.cameraCallback = "";
        this.this$0.cameraUUid = "";
        return;
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
      }
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", -1);
        this.jdField_a_of_type_OrgJsonJSONObject.put("msg", "compress fail");
        this.jdField_a_of_type_OrgJsonJSONObject.put("sourceType", "camera");
        this.this$0.callJs(this.this$0.cameraCallback, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, -1, "1", "", "", "");
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.2
 * JD-Core Version:    0.7.0.1
 */