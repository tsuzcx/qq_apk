package com.tencent.mobileqq.activity.bless;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class BlessJsApiPlugin
  extends WebViewPlugin
{
  private static String a;
  public BroadcastReceiver a;
  
  public BlessJsApiPlugin()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new BlessJsApiPlugin.1(this);
    this.mPluginNameSpace = "bless";
  }
  
  public void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult, requestCode:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("，resultCode：");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("BlessJsApiPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 11000)
    {
      if (paramIntent == null) {
        return;
      }
      localObject = paramIntent.getStringExtra("arg_callback");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("arg_result_json");
        if (paramIntent == null) {
          break label284;
        }
      }
    }
    StringBuilder localStringBuilder;
    try
    {
      paramIntent = new JSONObject(paramIntent);
      paramIntent.put("retCode", 0);
      paramIntent = paramIntent.toString();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startNewPTVActivity");
        localStringBuilder.append(" result:");
        localStringBuilder.append(((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).replaceUrlInLog(paramIntent));
        QLog.d("BlessJsApiPlugin", 2, localStringBuilder.toString());
      }
      callJs((String)localObject, new String[] { paramIntent });
      return;
    }
    catch (Exception paramIntent) {}
    paramIntent = new JSONObject();
    paramIntent.put("retCode", -1);
    paramIntent = paramIntent.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startNewPTVActivity");
      localStringBuilder.append(" result:");
      localStringBuilder.append(paramIntent);
      QLog.d("BlessJsApiPlugin", 2, localStringBuilder.toString());
    }
    callJs((String)localObject, new String[] { paramIntent });
    label284:
    return;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934600L) && (paramMap != null))
    {
      int i = ((Integer)paramMap.get("requestCode")).intValue();
      if (i == 11000)
      {
        int j = ((Integer)paramMap.get("resultCode")).intValue();
        a((Intent)paramMap.get("data"), i, j);
        return true;
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("Call BlessJsApiPlugin handleJsRequest, url");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(" pkgName:");
      paramJsBridgeListener.append(paramString2);
      QLog.d("BlessJsApiPlugin", 2, paramJsBridgeListener.toString());
    }
    if ("bless".equals(paramString2))
    {
      if ("GSBase64Encode".equals(paramString3))
      {
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("Call Bless Api GSBaze64Encode, args:");
          paramJsBridgeListener.append(paramVarArgs);
          QLog.d("BlessJsApiPlugin", 2, paramJsBridgeListener.toString());
        }
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            paramString1 = paramJsBridgeListener.optString("need_encode_string");
            paramJsBridgeListener = paramJsBridgeListener.optString("callback");
            if (TextUtils.isEmpty(paramJsBridgeListener)) {
              break label1045;
            }
            paramString1 = NearbyURLSafeUtil.a(paramString1);
            paramString2 = new JSONObject();
            paramString2.put("encoded_string", paramString1);
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return true;
          }
        }
      }
      else if ("getBlessConfig".equals(paramString3))
      {
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("Call Bless Api getBlessConfig, args:");
          paramJsBridgeListener.append(paramVarArgs);
          QLog.d("BlessJsApiPlugin", 2, paramJsBridgeListener.toString());
        }
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
            if (TextUtils.isEmpty(paramJsBridgeListener)) {
              break label1045;
            }
            paramString1 = BlessManager.i();
            paramString2 = new JSONObject();
            paramString2.put("bless_config", paramString1);
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return true;
          }
        }
      }
      else if ("sendBlessText".equals(paramString3))
      {
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("Call Bless Api sendBlessText, args:");
          paramJsBridgeListener.append(paramVarArgs);
          QLog.d("BlessJsApiPlugin", 2, paramJsBridgeListener.toString());
        }
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            paramString1 = paramString1.optString("blesswords");
            if (TextUtils.isEmpty(paramJsBridgeListener)) {
              break label1045;
            }
            BlessJsApiUtils.a(this.mRuntime.a(), paramString1, paramJsBridgeListener);
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return true;
          }
        }
      }
      else if ("sendBlessPtv".equals(paramString3))
      {
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("Call sendBlessPtv, args:");
          paramJsBridgeListener.append(paramVarArgs);
          QLog.d("BlessJsApiPlugin", 2, paramJsBridgeListener.toString());
        }
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          try
          {
            Object localObject = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = ((JSONObject)localObject).optString("callback");
            paramString1 = ((JSONObject)localObject).optString("supportvideo");
            paramString2 = ((JSONObject)localObject).optString("supportphoto");
            paramString3 = ((JSONObject)localObject).optString("cameramode");
            paramVarArgs = ((JSONObject)localObject).optString("supportDD");
            String str1 = ((JSONObject)localObject).optString("unfoldDD");
            String str2 = ((JSONObject)localObject).optString("DDItemID");
            localObject = ((JSONObject)localObject).optString("supportFilter");
            if (TextUtils.isEmpty(paramJsBridgeListener)) {
              break label1045;
            }
            Activity localActivity = this.mRuntime.a();
            jdField_a_of_type_JavaLangString = paramJsBridgeListener;
            BlessJsApiUtils.a(localActivity, paramString1, paramString2, paramString3, paramVarArgs, str1, str2, (String)localObject, paramJsBridgeListener);
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            QLog.d("BlessJsApiPlugin", 1, "Call sendBlessPtv error, ", paramJsBridgeListener);
            return true;
          }
        }
      }
      else
      {
        boolean bool;
        if ("isSupportPTV".equals(paramString3))
        {
          if (QLog.isColorLevel())
          {
            paramJsBridgeListener = new StringBuilder();
            paramJsBridgeListener.append("Call Bless Api isSupportPTV, args:");
            paramJsBridgeListener.append(paramVarArgs);
            QLog.d("BlessJsApiPlugin", 2, paramJsBridgeListener.toString());
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
              if (TextUtils.isEmpty(paramJsBridgeListener)) {
                break label1045;
              }
              bool = BlessJsApiUtils.c(this.mRuntime.a());
              paramString1 = new JSONObject();
              paramString1.put("is_support_ptv", bool);
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              return true;
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
              return true;
            }
          }
        }
        else if ("isMobileSupportPTV".equals(paramString3))
        {
          if (QLog.isColorLevel())
          {
            paramJsBridgeListener = new StringBuilder();
            paramJsBridgeListener.append("Call Bless Api isMobileSupportPTV, args:");
            paramJsBridgeListener.append(paramVarArgs);
            QLog.d("BlessJsApiPlugin", 2, paramJsBridgeListener.toString());
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
              if (TextUtils.isEmpty(paramJsBridgeListener)) {
                break label1045;
              }
              bool = BlessJsApiUtils.a(this.mRuntime.a());
              paramString1 = new JSONObject();
              paramString1.put("is_mobile_support_ptv", bool);
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              return true;
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
              return true;
            }
          }
        }
        else if ("isMobileSupportPendant".equals(paramString3))
        {
          if (QLog.isColorLevel())
          {
            paramJsBridgeListener = new StringBuilder();
            paramJsBridgeListener.append("Call Bless Api isMobileSupportPendant, args:");
            paramJsBridgeListener.append(paramVarArgs);
            QLog.d("BlessJsApiPlugin", 2, paramJsBridgeListener.toString());
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
              if (!TextUtils.isEmpty(paramJsBridgeListener))
              {
                bool = BlessJsApiUtils.b(this.mRuntime.a());
                paramString1 = new JSONObject();
                paramString1.put("is_support_DynamicDecoration", bool);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                return true;
              }
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
      }
      label1045:
      return true;
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.BlessJsApiPlugin");
    this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessJsApiPlugin
 * JD-Core Version:    0.7.0.1
 */