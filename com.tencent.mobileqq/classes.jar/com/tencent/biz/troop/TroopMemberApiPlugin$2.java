package com.tencent.biz.troop;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class TroopMemberApiPlugin$2
  implements VideoCombineHelper.Callback
{
  TroopMemberApiPlugin$2(TroopMemberApiPlugin paramTroopMemberApiPlugin, String paramString) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {}
    try
    {
      localJSONObject.put("retCode", 0);
      break label34;
      localJSONObject.put("retCode", 1);
      label34:
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("errMsg", paramString2);
      }
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("file", paramString1);
      }
      this.b.callJs(this.a, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(this.b.mTAG, 1, paramString2, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiPlugin.2
 * JD-Core Version:    0.7.0.1
 */