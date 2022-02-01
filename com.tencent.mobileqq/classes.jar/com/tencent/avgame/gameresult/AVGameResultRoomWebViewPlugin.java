package com.tencent.avgame.gameresult;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class AVGameResultRoomWebViewPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  public static final String a = AVGameResultRoomWebViewPlugin.class.getSimpleName();
  
  public AVGameResultRoomWebViewPlugin()
  {
    this.mPluginNameSpace = "avgame_result";
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934610L) || (paramLong == 8589934601L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "back game room, type[" + paramLong + "]");
      }
      this.mRuntime.a().setResult(273);
      this.mRuntime.a().finish();
      return true;
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (this.mPluginNameSpace.equalsIgnoreCase(paramString2))
    {
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder("Call AVGameWebViewPlugin handleJsRequest, url=").append(paramString1).append(" pkgName=").append(paramString2).append(" method=").append(paramString3);
        QLog.d(a, 2, paramJsBridgeListener.toString());
      }
      if (("backToRoom".equalsIgnoreCase(paramString3)) || ("challengeAgain".equalsIgnoreCase(paramString3)))
      {
        this.mRuntime.a().setResult(273);
        this.mRuntime.a().finish();
      }
      for (;;)
      {
        return true;
        if ("closeGame".equalsIgnoreCase(paramString3))
        {
          this.mRuntime.a().setResult(546);
          this.mRuntime.a().finish();
        }
      }
    }
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return (paramString1.contains("https://ti.qq.com/vgame/result")) || (paramString1.contains("https://ti.qq.com/hb2021/gameresult"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameresult.AVGameResultRoomWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */