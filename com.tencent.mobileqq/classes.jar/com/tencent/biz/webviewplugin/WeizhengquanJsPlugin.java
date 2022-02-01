package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.JsWebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwJsInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class WeizhengquanJsPlugin
  extends JsWebViewPlugin
{
  Activity jdField_a_of_type_AndroidAppActivity;
  String jdField_a_of_type_JavaLangString = "";
  private final String b = "getPayAdInfo";
  private final String c = "pushMusicInfo";
  
  private String a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!TextUtils.isEmpty(paramVarArgs[0])))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("arg[0] = ");
      localStringBuilder.append(paramVarArgs[0]);
      QLog.i("WeizhengquanJsPlugin", 2, localStringBuilder.toString());
      try
      {
        this.jdField_a_of_type_JavaLangString = new JSONObject(paramVarArgs[0]).optString("callback");
      }
      catch (JSONException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("parameter callback = ");
      paramVarArgs.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("WeizhengquanJsPlugin", 2, paramVarArgs.toString());
      return this.jdField_a_of_type_JavaLangString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parameter error...");
    localStringBuilder.append(paramVarArgs);
    QLog.i("WeizhengquanJsPlugin", 2, localStringBuilder.toString());
    return null;
  }
  
  private void a(JsBridgeListener paramJsBridgeListener, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeizhengquanJsPlugin", 2, "prosGetPayAdInfo...");
    }
    if (!(this.mRuntime.a() instanceof QwJsInterface))
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("activity error : ");
      paramJsBridgeListener.append(this.jdField_a_of_type_AndroidAppActivity);
      QLog.i("WeizhengquanJsPlugin", 2, paramJsBridgeListener.toString());
      return;
    }
    int i = ((QwJsInterface)this.mRuntime.a()).a();
    paramJsBridgeListener = new StringBuilder();
    paramJsBridgeListener.append("bzCode = ");
    paramJsBridgeListener.append(i);
    QLog.i("WeizhengquanJsPlugin", 2, paramJsBridgeListener.toString());
    if (1 != i) {
      return;
    }
    paramVarArgs = (Bundle)((QwJsInterface)this.mRuntime.a()).b();
    if (paramVarArgs == null)
    {
      QLog.i("WeizhengquanJsPlugin", 2, "error bundle is null...");
      return;
    }
    paramJsBridgeListener = paramVarArgs.getString("paySuccJsonData");
    i = paramVarArgs.getInt("ScreenHeight");
    int j = paramVarArgs.getInt("PayHeight");
    int k = paramVarArgs.getInt("ADHeight");
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("data = ");
    paramVarArgs.append(paramJsBridgeListener);
    paramVarArgs.append(" sh = ");
    paramVarArgs.append(i);
    paramVarArgs.append(" ph = ");
    paramVarArgs.append(j);
    paramVarArgs.append(" ah = ");
    paramVarArgs.append(k);
    QLog.i("WeizhengquanJsPlugin", 2, paramVarArgs.toString());
    try
    {
      paramVarArgs = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ScreenHeight", i);
      localJSONObject.put("PayHeight", j);
      localJSONObject.put("ADHeight", k);
      paramVarArgs.put("display", localJSONObject);
      paramVarArgs.put("paySuccJsonData", paramJsBridgeListener);
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append(this.jdField_a_of_type_JavaLangString);
      paramJsBridgeListener.append(" => ");
      paramJsBridgeListener.append(paramVarArgs);
      QLog.i("WeizhengquanJsPlugin", 2, paramJsBridgeListener.toString());
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramVarArgs.toString() });
      return;
    }
    catch (JSONException paramJsBridgeListener)
    {
      paramJsBridgeListener.printStackTrace();
    }
  }
  
  private void b(JsBridgeListener paramJsBridgeListener, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeizhengquanJsPlugin", 2, "prosPushMusicInfo...");
    }
    if (paramVarArgs.length <= 0)
    {
      QLog.i("WeizhengquanJsPlugin", 2, "error, parameters empty...");
      return;
    }
    try
    {
      paramJsBridgeListener = new JSONObject();
      paramJsBridgeListener.put("ret_code", "0");
      paramJsBridgeListener.put("ret_msg", "success");
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramJsBridgeListener.toString() });
    }
    catch (JSONException paramJsBridgeListener)
    {
      paramJsBridgeListener.printStackTrace();
    }
    paramJsBridgeListener = new Intent();
    paramJsBridgeListener.putExtra("h5arg", paramVarArgs[0]);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramJsBridgeListener);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  protected String getNameSpace()
  {
    return "qw";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleJsRequest url = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" pkgName = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" methodName = ");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(" arg.length = ");
    localStringBuilder.append(paramVarArgs.length);
    QLog.d("WeizhengquanJsPlugin", 2, localStringBuilder.toString());
    if (!getNameSpace().equals(paramString2)) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = a(paramVarArgs);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.d("WeizhengquanJsPlugin", 2, "function name is null...");
      return true;
    }
    if ("getPayAdInfo".equals(paramString3))
    {
      a(paramJsBridgeListener, paramVarArgs);
      return true;
    }
    if ("pushMusicInfo".equals(paramString3))
    {
      b(paramJsBridgeListener, paramVarArgs);
      return true;
    }
    return false;
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WeizhengquanJsPlugin
 * JD-Core Version:    0.7.0.1
 */