package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class HotchatPlugin$4
  implements ITroopMemberApiClientApi.Callback
{
  HotchatPlugin$4(HotchatPlugin paramHotchatPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      String str = paramBundle.getString("content");
      paramBundle = paramBundle.getString("url");
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("content", str);
        localJSONObject.put("url", paramBundle);
        paramBundle = localJSONObject.toString();
      }
      catch (JSONException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HotchatPlugin", 2, paramBundle.getMessage());
        }
        paramBundle = null;
      }
      this.b.callJs(this.a, new String[] { paramBundle });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.HotchatPlugin.4
 * JD-Core Version:    0.7.0.1
 */