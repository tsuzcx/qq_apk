package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ArkAppNotifyCenter$TroopNotify
  implements ArkAppNotifyCenter.INotifyReg
{
  public boolean notify(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = null;
    try
    {
      paramString3 = new JSONObject(paramString3).optString("gc");
      if (TextUtils.isEmpty(paramString3)) {
        return false;
      }
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        QLog.e("ark.ArkAppNotifyCenter", 1, "notify json error!", paramString3);
        paramString3 = localJSONObject;
      }
      if (paramString2.equals("GetIsTroopOwner")) {
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("isOwner", TroopUtils.a(ArkAppNotifyCenter.getAppInterface(), paramString3, ArkAppNotifyCenter.getAppInterface().getCurrentUin()));
          ark.arkNotify(paramString1, paramString2, localJSONObject.toString(), "json");
          return true;
        }
        catch (Throwable paramString1)
        {
          for (;;)
          {
            QLog.e("ark.ArkAppNotifyCenter", 1, "ark.notify error!", paramString1);
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.TroopNotify
 * JD-Core Version:    0.7.0.1
 */