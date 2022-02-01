package com.tencent.mobileqq.activity.bless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class BlessJsApiPlugin$1
  extends BroadcastReceiver
{
  BlessJsApiPlugin$1(BlessJsApiPlugin paramBlessJsApiPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("callback");
    int i = paramIntent.getIntExtra("bless_type", 0);
    int j = paramIntent.getIntExtra("bless_num", 0);
    paramContext = new JSONObject();
    try
    {
      paramContext.put("bless_type", i);
      paramContext.put("bless_num", j);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i("BlessJsApiPlugin", 2, String.format("call blessWebView, blesstype:%d, member:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    if (i == 2)
    {
      try
      {
        str1 = paramIntent.getStringExtra("bless_ptv_url");
        String str2 = paramIntent.getStringExtra("bless_ptv_uuid");
        String str3 = paramIntent.getStringExtra("bless_ptv_md5");
        paramIntent = paramIntent.getStringExtra("bless_ptv_nick");
        paramContext.put("bless_ptv_url", str1);
        paramContext.put("bless_ptv_uuid", str2);
        paramContext.put("bless_ptv_md5", str3);
        paramContext.put("bless_ptv_nick", paramIntent);
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
      this.a.callJs(BlessJsApiPlugin.a(), new String[] { paramContext.toString() });
      return;
    }
    if (i == 3)
    {
      this.a.callJs(BlessJsApiPlugin.a(), new String[] { paramContext.toString() });
      return;
    }
    this.a.callJs(str1, new String[] { paramContext.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessJsApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */