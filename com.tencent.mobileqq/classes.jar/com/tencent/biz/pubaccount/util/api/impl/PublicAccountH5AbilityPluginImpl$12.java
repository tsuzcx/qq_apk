package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.fastweb.CallJs;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

final class PublicAccountH5AbilityPluginImpl$12
  implements EIPCResultCallback
{
  PublicAccountH5AbilityPluginImpl$12(CallJs paramCallJs, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int i;
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null)) {
      i = paramEIPCResult.data.getInt("action_get_app_type");
    } else {
      i = 0;
    }
    paramEIPCResult = new StringBuilder();
    paramEIPCResult.append("getAppType is ");
    paramEIPCResult.append(i);
    QLog.e("PublicAccountH5AbilityPlugin", 1, paramEIPCResult.toString());
    paramEIPCResult = this.a;
    if (paramEIPCResult != null) {
      try
      {
        paramEIPCResult.a(this.b, new JSONObject().putOpt("app_type", Integer.valueOf(i)).toString());
        return;
      }
      catch (JSONException paramEIPCResult)
      {
        QLog.e("PublicAccountH5AbilityPlugin", 1, paramEIPCResult.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.12
 * JD-Core Version:    0.7.0.1
 */