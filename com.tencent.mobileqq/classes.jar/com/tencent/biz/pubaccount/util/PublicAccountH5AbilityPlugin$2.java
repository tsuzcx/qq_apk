package com.tencent.biz.pubaccount.util;

import atqs;
import awqx;
import baip;
import com.tencent.mobileqq.pic.CompressInfo;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rsv;

public class PublicAccountH5AbilityPlugin$2
  implements Runnable
{
  public PublicAccountH5AbilityPlugin$2(rsv paramrsv, JSONArray paramJSONArray, JSONObject paramJSONObject) {}
  
  public void run()
  {
    CompressInfo localCompressInfo = new CompressInfo(this.this$0.n, 0);
    localCompressInfo.f = 0;
    atqs.a(localCompressInfo);
    String str;
    if (!baip.a(localCompressInfo.e))
    {
      str = "mqqpa://resourceid/" + this.this$0.p;
      rsv.b.put(str, localCompressInfo.e);
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
        this.this$0.callJs(this.this$0.o, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
        awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
        this.this$0.n = "";
        this.this$0.o = "";
        this.this$0.p = "";
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
        this.this$0.callJs(this.this$0.o, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
        awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, -1, "1", "", "", "");
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.2
 * JD-Core Version:    0.7.0.1
 */