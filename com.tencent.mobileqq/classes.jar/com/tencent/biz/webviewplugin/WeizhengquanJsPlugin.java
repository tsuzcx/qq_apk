package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.MakeVideoActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.JsWebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwJsInterface;
import org.json.JSONException;
import org.json.JSONObject;
import pij;

public class WeizhengquanJsPlugin
  extends JsWebViewPlugin
{
  protected long a;
  Activity a;
  public String a;
  private String b;
  private final String c = "getVideo";
  private final String d = "getPayAdInfo";
  
  public WeizhengquanJsPlugin()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private String a(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0) || (TextUtils.isEmpty(paramVarArgs[0])))
    {
      QLog.i("WeizhengquanJsPlugin", 2, "parameter error..." + paramVarArgs);
      return null;
    }
    QLog.i("WeizhengquanJsPlugin", 2, "arg[0] = " + paramVarArgs[0]);
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramVarArgs[0]).optString("callback");
      QLog.i("WeizhengquanJsPlugin", 2, "parameter callback = " + this.jdField_a_of_type_JavaLangString);
      return this.jdField_a_of_type_JavaLangString;
    }
    catch (JSONException paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  private void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte == 1)
    {
      if (paramInt != -1) {
        break label41;
      }
      paramIntent = paramIntent.getStringExtra("path");
      if (!TextUtils.isEmpty(paramIntent)) {
        break label25;
      }
    }
    label25:
    label41:
    do
    {
      return;
      ThreadManager.post(new pij(this, paramIntent), 2, null, true);
      return;
      paramIntent = paramIntent.getStringExtra("result");
    } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramIntent });
  }
  
  private boolean a(JsBridgeListener paramJsBridgeListener, String... paramVarArgs)
  {
    boolean bool = false;
    paramVarArgs = paramVarArgs[0];
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("WeizhengquanJsPlugin", 2, "" + this.jdField_a_of_type_Long + " WeizhengquanJsPlugin.handleJsRequest params:" + paramVarArgs);
    }
    if (paramVarArgs != null)
    {
      a(paramVarArgs, paramJsBridgeListener);
      bool = true;
    }
    return bool;
  }
  
  private boolean b(JsBridgeListener paramJsBridgeListener, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeizhengquanJsPlugin", 2, "prosGetPayAdInfo...");
    }
    if (!(this.mRuntime.a() instanceof QwJsInterface))
    {
      QLog.i("WeizhengquanJsPlugin", 2, "activity error : " + this.jdField_a_of_type_AndroidAppActivity);
      return false;
    }
    int i = ((QwJsInterface)this.mRuntime.a()).a();
    QLog.i("WeizhengquanJsPlugin", 2, "bzCode = " + i);
    if (1 != i) {
      return true;
    }
    paramVarArgs = (Bundle)((QwJsInterface)this.mRuntime.a()).b();
    if (paramVarArgs == null)
    {
      QLog.i("WeizhengquanJsPlugin", 2, "error bundle is null...");
      return true;
    }
    paramJsBridgeListener = paramVarArgs.getString("paySuccJsonData");
    i = paramVarArgs.getInt("ScreenHeight");
    int j = paramVarArgs.getInt("PayHeight");
    int k = paramVarArgs.getInt("ADHeight");
    QLog.i("WeizhengquanJsPlugin", 2, "data = " + paramJsBridgeListener + " sh = " + i + " ph = " + j + " ah = " + k);
    try
    {
      paramVarArgs = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ScreenHeight", i);
      localJSONObject.put("PayHeight", j);
      localJSONObject.put("ADHeight", k);
      paramVarArgs.put("display", localJSONObject);
      paramVarArgs.put("paySuccJsonData", paramJsBridgeListener);
      QLog.i("WeizhengquanJsPlugin", 2, this.jdField_a_of_type_JavaLangString + " => " + paramVarArgs);
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramVarArgs.toString() });
      return true;
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        paramJsBridgeListener.printStackTrace();
      }
    }
  }
  
  protected void a(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeizhengquanJsPlugin", 2, "pay requet params json=" + paramString);
    }
    paramJsBridgeListener = new Intent(this.jdField_a_of_type_AndroidAppActivity, MakeVideoActivity.class);
    paramJsBridgeListener.putExtra("params", paramString);
    startActivityForResult(paramJsBridgeListener, (byte)1);
  }
  
  protected String getNameSpace()
  {
    return "qw";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    QLog.d("WeizhengquanJsPlugin", 2, "handleJsRequest url = " + paramString1 + " pkgName = " + paramString2 + " methodName = " + paramString3 + " arg.length = " + paramVarArgs.length);
    if (!getNameSpace().equals(paramString2)) {}
    do
    {
      return false;
      this.jdField_a_of_type_JavaLangString = a(paramVarArgs);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        QLog.d("WeizhengquanJsPlugin", 2, "function name is null...");
        return true;
      }
      this.b = paramString3;
      if ("getVideo".equals(paramString3)) {
        return a(paramJsBridgeListener, paramVarArgs);
      }
    } while (!"getPayAdInfo".equals(paramString3));
    return b(paramJsBridgeListener, paramVarArgs);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if ("getVideo".equals(this.b)) {
      a(paramIntent, paramByte, paramInt);
    }
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WeizhengquanJsPlugin
 * JD-Core Version:    0.7.0.1
 */