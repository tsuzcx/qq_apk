package com.tencent.mobileqq.Doraemon.impl.internalModule;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class InternalAPIModule
  extends DoraemonAPIModule
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (paramInt != 9) {
      return false;
    }
    paramString = MobileQQ.sMobileQQ.waitAppRuntime(null);
    paramJSONObject = (TicketManager)paramString.getManager(2);
    paramString = paramString.getAccount();
    paramJSONObject = paramJSONObject.getSkey(paramString);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramString);
      localJSONObject.put("skey", paramJSONObject);
      DoraemonUtil.a(paramAPICallback, localJSONObject);
    }
    catch (JSONException paramString)
    {
      paramJSONObject = paramString.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.innerApi", 2, paramJSONObject, paramString);
      }
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = "";
      }
      DoraemonUtil.a(paramAPICallback, -1, paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.internalModule.InternalAPIModule
 * JD-Core Version:    0.7.0.1
 */