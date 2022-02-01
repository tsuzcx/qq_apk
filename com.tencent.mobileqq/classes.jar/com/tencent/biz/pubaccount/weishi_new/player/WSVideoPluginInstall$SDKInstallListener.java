package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerSdkMgr.InstallListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import org.json.JSONException;
import org.json.JSONObject;

class WSVideoPluginInstall$SDKInstallListener
  implements IWSPlayerSdkMgr.InstallListener
{
  private Handler a;
  
  WSVideoPluginInstall$SDKInstallListener(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "8.5.5");
      if (this.a != null) {
        this.a.sendEmptyMessage(0);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        WSLog.d("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][onInstalledSuccess] JSONException: " + localJSONException.getLocalizedMessage());
      }
    }
  }
  
  public void a(float paramFloat)
  {
    if (this.a != null) {
      this.a.sendEmptyMessage(2);
    }
  }
  
  public void a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "8.5.5");
      localJSONObject.put("error_code", paramInt);
      if (this.a != null) {
        this.a.sendEmptyMessage(1);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        WSLog.d("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][onInstalledFailed] JSONException: " + localException.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.SDKInstallListener
 * JD-Core Version:    0.7.0.1
 */