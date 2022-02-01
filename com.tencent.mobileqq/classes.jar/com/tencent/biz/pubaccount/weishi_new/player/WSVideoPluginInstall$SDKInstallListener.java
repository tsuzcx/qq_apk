package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerSdkMgr.InstallListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import org.json.JSONException;
import org.json.JSONObject;

class WSVideoPluginInstall$SDKInstallListener
  implements IWSPlayerSdkMgr.InstallListener
{
  private final Handler a;
  
  WSVideoPluginInstall$SDKInstallListener(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void a()
  {
    WSLog.d("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][onInstalledSuccess]");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "8.8.17");
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSVideoPluginInstall.java][onInstalledSuccess] JSONException: ");
      localStringBuilder.append(localJSONException.getLocalizedMessage());
      WSLog.d("WS_VIDEO_WSVideoPluginInstall", localStringBuilder.toString());
    }
    Handler localHandler = this.a;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(0);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSVideoPluginInstall.java][onInstalledFailed] errorCode:");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.d("WS_VIDEO_WSVideoPluginInstall", ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("version", "8.8.17");
      ((JSONObject)localObject).put("error_code", paramInt);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSVideoPluginInstall.java][onInstalledFailed] JSONException: ");
      localStringBuilder.append(localException.getLocalizedMessage());
      WSLog.d("WS_VIDEO_WSVideoPluginInstall", localStringBuilder.toString());
    }
    Handler localHandler = this.a;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.SDKInstallListener
 * JD-Core Version:    0.7.0.1
 */