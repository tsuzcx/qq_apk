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
  private WebViewAioShareMusicHelper jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper;
  private boolean jdField_a_of_type_Boolean;
  
  public AioShareMusicPlugin()
  {
    this.mPluginNameSpace = "aioShareMusic";
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if (this.mRuntime != null)
    {
      if (this.mRuntime.a() == null) {
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
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper == null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper = new WebViewAioShareMusicHelper((WebViewFragment)this.mRuntime.a());
      }
      if ("checkAioShareMusic".equals(paramString))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper.a(paramJSONObject);
        return;
      }
      if ("startListenAioShareMusic".equals(paramString))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper.b(paramJSONObject);
        return;
      }
      if ("updateSongIdToAioShareMusic".equals(paramString)) {
        try
        {
          paramString = paramJSONObject.getString("current_song_id");
          this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper.a = paramString;
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
    if ((this.mRuntime != null) && (this.mRuntime.a() != null))
    {
      if (this.mRuntime.a() == null) {
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper == null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper = new WebViewAioShareMusicHelper((WebViewFragment)this.mRuntime.a());
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
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper.a(this.mRuntime.a().getIntent());
          return true;
        }
      }
      else if (paramLong == 8589934622L)
      {
        localObject = paramMap.get("intent");
        if ((localObject != null) && ((localObject instanceof Intent)))
        {
          paramString = (Intent)localObject;
          this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper.b(paramString);
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
    AioShareMusicIPCWebClient.a().a(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    WebViewAioShareMusicHelper localWebViewAioShareMusicHelper = this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper;
    if (localWebViewAioShareMusicHelper != null)
    {
      localWebViewAioShareMusicHelper.a();
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper = null;
    }
    AioShareMusicIPCWebClient.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aiosharemusic.AioShareMusicPlugin
 * JD-Core Version:    0.7.0.1
 */