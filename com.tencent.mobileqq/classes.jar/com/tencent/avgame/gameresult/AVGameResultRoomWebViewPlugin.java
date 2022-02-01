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
  public static final String a = "AVGameResultRoomWebViewPlugin";
  
  public AVGameResultRoomWebViewPlugin()
  {
    this.mPluginNameSpace = "avgame_result";
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong != 8589934610L) && (paramLong != 8589934601L)) {
      return super.handleEvent(paramString, paramLong, paramMap);
    }
    if (QLog.isColorLevel())
    {
      paramString = a;
      paramMap = new StringBuilder();
      paramMap.append("back game room, type[");
      paramMap.append(paramLong);
      paramMap.append("]");
      QLog.d(paramString, 2, paramMap.toString());
    }
    this.mRuntime.d().setResult(273);
    this.mRuntime.d().finish();
    return true;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (this.mPluginNameSpace.equalsIgnoreCase(paramString2))
    {
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder("Call AVGameWebViewPlugin handleJsRequest, url=");
        paramJsBridgeListener.append(paramString1);
        paramJsBridgeListener.append(" pkgName=");
        paramJsBridgeListener.append(paramString2);
        paramJsBridgeListener.append(" method=");
        paramJsBridgeListener.append(paramString3);
        QLog.d(a, 2, paramJsBridgeListener.toString());
      }
      if ((!"backToRoom".equalsIgnoreCase(paramString3)) && (!"challengeAgain".equalsIgnoreCase(paramString3)))
      {
        if ("closeGame".equalsIgnoreCase(paramString3))
        {
          this.mRuntime.d().setResult(546);
          this.mRuntime.d().finish();
        }
      }
      else
      {
        this.mRuntime.d().setResult(273);
        this.mRuntime.d().finish();
      }
      return true;
    }
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return (paramString1.contains("https://ti.qq.com/vgame/result")) || (paramString1.contains("https://act.qzone.qq.com/"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.AVGameResultRoomWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */