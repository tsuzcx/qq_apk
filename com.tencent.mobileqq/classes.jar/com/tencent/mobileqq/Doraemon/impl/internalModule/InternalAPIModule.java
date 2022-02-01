package com.tencent.mobileqq.Doraemon.impl.internalModule;

import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class InternalAPIModule
  extends DoraemonAPIModule
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    paramJSONObject = (TicketManager)paramString.getManager(2);
    paramString = paramString.getAccount();
    paramJSONObject = paramJSONObject.getSkey(paramString);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramString);
      localJSONObject.put("skey", paramJSONObject);
      DoraemonUtil.a(paramAPICallback, localJSONObject);
      return true;
    }
    catch (JSONException paramString)
    {
      for (;;)
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.internalModule.InternalAPIModule
 * JD-Core Version:    0.7.0.1
 */