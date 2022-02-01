package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.ar.ARRecord.VideoEncoderUtils;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class ARJsApiPlugin
  extends WebViewPlugin
{
  public static final String a = "ARJsApiPlugin";
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("arcard".equals(paramString2)) {
      if ("isEntranceSupport".equals(paramString3)) {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = a;
        paramString2 = new StringBuilder();
        paramString2.append("handleJsRequest jsonobject is ");
        paramString2.append(paramJsBridgeListener.toString());
        QLog.d(paramString1, 2, paramString2.toString());
        paramJsBridgeListener = paramJsBridgeListener.optString("callback");
        if (ARVideoUtil.a()) {
          break label322;
        }
        bool = true;
        paramString1 = new JSONObject();
        paramString1.put("is_entrance_support", bool);
        callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return false;
      }
      return false;
      if ("isModelSupport".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = a;
          paramString2 = new StringBuilder();
          paramString2.append("handleJsRequest jsonobject is ");
          paramString2.append(paramJsBridgeListener.toString());
          QLog.d(paramString1, 2, paramString2.toString());
          paramJsBridgeListener = paramJsBridgeListener.optString("callback");
          bool = VideoEncoderUtils.a();
          paramString1 = new JSONObject();
          paramString1.put("is_device_support", bool);
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return false;
        }
      }
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      label322:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ARJsApiPlugin
 * JD-Core Version:    0.7.0.1
 */