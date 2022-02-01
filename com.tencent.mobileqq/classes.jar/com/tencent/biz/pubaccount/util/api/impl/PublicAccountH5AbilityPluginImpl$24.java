package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$24
  implements ITroopMemberApiClientApi.Callback
{
  PublicAccountH5AbilityPluginImpl$24(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (this.d.activity != null) {
        this.d.cancleProgressDailog();
      }
      String str = paramBundle.getString("pic_local_id");
      JSONObject localJSONObject = new JSONObject();
      try
      {
        boolean bool = "-1".equals(str);
        Object localObject;
        if (bool)
        {
          localJSONObject.put("retCode", -1);
          localJSONObject.put("msg", "fail");
          if (this.a)
          {
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, -1, "1", "", "", "");
            localObject = str;
          }
          else
          {
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, -1, "1", "", "", "");
            localObject = str;
          }
        }
        else
        {
          localObject = str;
          if (this.a)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("mqqpa://resourceid/");
            ((StringBuilder)localObject).append(str);
            localObject = ((StringBuilder)localObject).toString();
          }
          paramBundle = paramBundle.getString("pic_local_path");
          PublicAccountH5AbilityPluginImpl.localIdMap.put(localObject, paramBundle);
          localJSONObject.put("retCode", 0);
          paramBundle = new StringBuilder();
          paramBundle.append(HardCodeUtil.a(2131906539));
          paramBundle.append((String)localObject);
          localJSONObject.put("msg", paramBundle.toString());
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("下载成功，localld为  ");
            paramBundle.append((String)localObject);
            QLog.i("PublicAccountH5AbilityPlugin", 2, paramBundle.toString());
          }
          if (this.a) {
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, 0, "1", "", "", "");
          } else {
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, 0, "1", "", "", "");
          }
        }
        localJSONObject.put("localId", localObject);
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
      }
      this.d.callJs(this.b, new String[] { localJSONObject.toString() });
      if (this.a) {
        this.d.startNextDownloadTask(this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.24
 * JD-Core Version:    0.7.0.1
 */