package com.tencent.kingkong;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

class UpdateManager$UpdateHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    paramMessage = paramMessage.getData();
    try
    {
      String str = paramMessage.getString("PATCH_JSON_STRING");
      boolean bool = paramMessage.getBoolean("PATCH_FORCE_UPDATE");
      paramMessage = PatchInfo.a(new JSONObject(str));
      if (paramMessage != null) {
        UpdateManager.a(paramMessage, bool);
      }
      return;
    }
    catch (Exception paramMessage)
    {
      Common.Log.a("KingKongUpdateManager", "Update patch exception : " + paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager.UpdateHandler
 * JD-Core Version:    0.7.0.1
 */