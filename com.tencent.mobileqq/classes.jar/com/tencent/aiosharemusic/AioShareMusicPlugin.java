package com.tencent.aiosharemusic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.WebViewAioShareMusicHelper;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AioShareMusicPlugin
  extends WebViewPlugin
  implements AioShareMusicIPCWebClient.AioShareMusicClient2WebCallback, IPreCreatePluginChecker
{
  private WebViewAioShareMusicHelper a;
  private boolean b;
  
  public AioShareMusicPlugin()
  {
    this.mPluginNameSpace = "aioShareMusic";
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if (this.mRuntime != null)
    {
      if (this.mRuntime.f() == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEvent（） actionType =");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" data = ");
        localStringBuilder.append(paramJSONObject.toString());
        QLog.d("AioShareMusic.AioShareMusicPlugin", 2, localStringBuilder.toString());
      }
      if (this.a == null) {
        this.a = new WebViewAioShareMusicHelper((WebViewFragment)this.mRuntime.f());
      }
      if ("checkAioShareMusic".equals(paramString))
      {
        this.a.a(paramJSONObject);
        return;
      }
      if ("startListenAioShareMusic".equals(paramString))
      {
        this.a.b(paramJSONObject);
        return;
      }
      if ("updateSongIdToAioShareMusic".equals(paramString)) {
        try
        {
          paramString = paramJSONObject.getString("current_song_id");
          this.a.a = paramString;
          if (QLog.isColorLevel())
          {
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("updateSongId() newSongId = ");
            paramJSONObject.append(paramString);
            QLog.d("AioShareMusicAioShareMusic.AioShareMusicPlugin", 2, paramJSONObject.toString());
            return;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589934622L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((this.mRuntime != null) && (this.mRuntime.f() != null))
    {
      if (this.mRuntime.d() == null) {
        return true;
      }
      if (this.a == null) {
        this.a = new WebViewAioShareMusicHelper((WebViewFragment)this.mRuntime.f());
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleEvent() type = ");
        ((StringBuilder)localObject).append(paramLong);
        QLog.d("AioShareMusicAioShareMusic.AioShareMusicPlugin", 2, ((StringBuilder)localObject).toString());
      }
      if (paramLong == 8589934594L)
      {
        if (!this.b)
        {
          this.b = true;
          this.a.a(this.mRuntime.d().getIntent());
          return true;
        }
      }
      else if (paramLong == 8589934622L)
      {
        localObject = paramMap.get("intent");
        if ((localObject != null) && ((localObject instanceof Intent)))
        {
          paramString = (Intent)localObject;
          this.a.b(paramString);
          return true;
        }
      }
      return super.handleEvent(paramString, paramLong, paramMap);
    }
    return true;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    paramIntent = paramIntent.getExtras();
    return (paramIntent != null) && ("music".equals(paramIntent.getString("forward_ark_app_view")));
  }
  
  protected void onCreate()
  {
    super.onCreate();
    AioShareMusicIPCWebClient.b().a(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    WebViewAioShareMusicHelper localWebViewAioShareMusicHelper = this.a;
    if (localWebViewAioShareMusicHelper != null)
    {
      localWebViewAioShareMusicHelper.a();
      this.a = null;
    }
    AioShareMusicIPCWebClient.b().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aiosharemusic.AioShareMusicPlugin
 * JD-Core Version:    0.7.0.1
 */