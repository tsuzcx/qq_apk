package com.tencent.mobileqq.ark.api.notify;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.module.IAppNotifyCallback;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class TroopNotify
  implements IAppNotifyCallback
{
  protected static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public boolean notify(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = new JSONObject(paramString3).optString("gc");
    }
    catch (Exception paramString3)
    {
      QLog.e("TroopNotify", 1, "notify json error!", paramString3);
      paramString3 = null;
    }
    if (TextUtils.isEmpty(paramString3)) {
      return false;
    }
    if (paramString2.equals("GetIsTroopOwner"))
    {
      QQAppInterface localQQAppInterface = a();
      if (localQQAppInterface == null)
      {
        QLog.e("TroopNotify", 1, "ark.notify error! appInterface == null");
        return true;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("isOwner", TroopUtils.a(localQQAppInterface, paramString3, localQQAppInterface.getCurrentUin()));
        ark.arkNotify(paramString1, paramString2, localJSONObject.toString(), "json");
        return true;
      }
      catch (Throwable paramString1)
      {
        QLog.e("TroopNotify", 1, "ark.notify error!", paramString1);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.TroopNotify
 * JD-Core Version:    0.7.0.1
 */