package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$3
  implements Runnable
{
  PublicAccountH5AbilityPluginImpl$3(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, ArrayList paramArrayList, JSONArray paramJSONArray, JSONObject paramJSONObject) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          String str = UUID.randomUUID().toString();
          str = "mqqpa://resourceid/" + str;
          this.jdField_a_of_type_OrgJsonJSONArray.put(i, str);
          CompressInfo localCompressInfo = new CompressInfo((String)this.jdField_a_of_type_JavaUtilArrayList.get(i), 0);
          localCompressInfo.f = 0;
          CompressOperator.a(localCompressInfo);
          if (!StringUtil.a(localCompressInfo.e)) {
            PublicAccountH5AbilityPluginImpl.localIdMap.put(str, localCompressInfo.e);
          } else {
            PublicAccountH5AbilityPluginImpl.localIdMap.put(str, this.jdField_a_of_type_JavaUtilArrayList.get(i));
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("value", this.jdField_a_of_type_OrgJsonJSONArray);
      this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", 0);
      this.jdField_a_of_type_OrgJsonJSONObject.put("msg", "Success");
      this.jdField_a_of_type_OrgJsonJSONObject.put("sourceType", "album");
      this.this$0.callJs(this.this$0.cameraCallback, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
      this.this$0.cameraCallback = "";
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.3
 * JD-Core Version:    0.7.0.1
 */