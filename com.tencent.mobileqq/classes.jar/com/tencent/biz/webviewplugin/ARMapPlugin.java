package com.tencent.biz.webviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONObject;
import pfr;

public class ARMapPlugin
  extends WebViewPlugin
{
  public ARMapPlugin()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapPlugin", 2, "init");
    }
  }
  
  private boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramString1 = "";
    paramJsBridgeListener = paramString1;
    if (paramVarArgs != null)
    {
      paramJsBridgeListener = paramString1;
      if (paramVarArgs.length <= 0) {}
    }
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
      if (QLog.isColorLevel()) {
        QLog.d("ARMapPlugin", 2, "getLbsInfo callback=" + paramJsBridgeListener);
      }
      if (TextUtils.isEmpty(paramJsBridgeListener)) {
        return true;
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramJsBridgeListener = paramString1;
        if (QLog.isColorLevel())
        {
          QLog.d("ARMapPlugin", 2, "getLbsInfo exception", paramString2);
          paramJsBridgeListener = paramString1;
        }
      }
      SosoInterface.a(new pfr(this, 3, true, true, 600000L, false, false, "wealthgod_locate_check", paramJsBridgeListener));
    }
    return true;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapPlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("armap".equals(paramString2))
    {
      if ("getLbsInfo".equals(paramString3)) {
        return a(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      }
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ARMapPlugin
 * JD-Core Version:    0.7.0.1
 */