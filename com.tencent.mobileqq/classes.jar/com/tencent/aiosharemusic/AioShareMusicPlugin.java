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
    if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AioShareMusic.AioShareMusicPlugin", 2, "onEvent（） actionType =" + paramString + " data = " + paramJSONObject.toString());
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
            QLog.d("AioShareMusicAioShareMusic.AioShareMusicPlugin", 2, "updateSongId() newSongId = " + paramString);
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
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((this.mRuntime == null) || (this.mRuntime.a() == null) || (this.mRuntime.a() == null)) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper = new WebViewAioShareMusicHelper((WebViewFragment)this.mRuntime.a());
    }
    if (QLog.isColorLevel()) {
      QLog.d("AioShareMusicAioShareMusic.AioShareMusicPlugin", 2, "handleEvent() type = " + paramLong);
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
      Object localObject = paramMap.get("intent");
      if ((localObject != null) && ((localObject instanceof Intent)))
      {
        paramString = (Intent)localObject;
        this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper.b(paramString);
        return true;
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    paramIntent = paramIntent.getExtras();
    return (paramIntent != null) && ("music".equals(paramIntent.getString("forward_ark_app_view")));
  }
  
  public void onCreate()
  {
    super.onCreate();
    AioShareMusicIPCWebClient.a().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper.a();
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebViewAioShareMusicHelper = null;
    }
    AioShareMusicIPCWebClient.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aiosharemusic.AioShareMusicPlugin
 * JD-Core Version:    0.7.0.1
 */