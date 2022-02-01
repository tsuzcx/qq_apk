package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
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
    localCompressInfo.o = 0;
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(localCompressInfo);
    if (!StringUtil.isEmpty(localCompressInfo.l))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mqqpa://resourceid/");
      ((StringBuilder)localObject).append(this.this$0.cameraUUid);
      localObject = ((StringBuilder)localObject).toString();
      PublicAccountH5AbilityPluginImpl.localIdMap.put(localObject, localCompressInfo.l);
      try
      {
        this.a.put(0, localObject);
        this.b.put("value", this.a);
        this.b.put("retCode", 0);
        this.b.put("msg", "Success");
        this.b.put("sourceType", "camera");
        this.this$0.callJs(this.this$0.cameraCallback, new String[] { this.b.toString() });
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
    }
    else
    {
      try
      {
        this.b.put("retCode", -1);
        this.b.put("msg", "compress fail");
        this.b.put("sourceType", "camera");
        this.this$0.callJs(this.this$0.cameraCallback, new String[] { this.b.toString() });
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, -1, "1", "", "", "");
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
    }
    PublicAccountH5AbilityPluginImpl localPublicAccountH5AbilityPluginImpl = this.this$0;
    localPublicAccountH5AbilityPluginImpl.cameraPath = "";
    localPublicAccountH5AbilityPluginImpl.cameraCallback = "";
    localPublicAccountH5AbilityPluginImpl.cameraUUid = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.2
 * JD-Core Version:    0.7.0.1
 */