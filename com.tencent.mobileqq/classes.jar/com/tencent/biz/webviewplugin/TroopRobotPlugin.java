package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopRobotPlugin
  extends VasWebviewJsPlugin
{
  public TroopRobotPlugin()
  {
    this.mPluginNameSpace = "robotsummary";
  }
  
  private boolean a(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length < 1) {
        return false;
      }
      paramVarArgs = paramVarArgs[0];
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs);
      paramVarArgs = ((JSONObject)localObject).optString("gc");
      String str1 = ((JSONObject)localObject).optString("robotUin");
      String str2 = ((JSONObject)localObject).optString("robotName");
      localObject = ((JSONObject)localObject).optString("callback");
      Bundle localBundle = new Bundle();
      localBundle.putString("robotuin", str1);
      localBundle.putString("troopuin", paramVarArgs);
      localBundle.putString("robotname", str2);
      paramVarArgs = DataFactory.a("ipc_cmd_share_robot_card", (String)localObject, this.mOnRemoteResp.key, localBundle);
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramVarArgs);
      return true;
    }
    catch (JSONException paramVarArgs) {}
    return false;
    return false;
  }
  
  private boolean b(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length < 1) {
        return false;
      }
      paramVarArgs = paramVarArgs[0];
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs);
      paramVarArgs = ((JSONObject)localObject).optString("oninfoUrl");
      String str1 = ((JSONObject)localObject).optString("oninfoTitle");
      String str2 = ((JSONObject)localObject).optString("offinfoUrl");
      String str3 = ((JSONObject)localObject).optString("offinfoTitle");
      String str4 = ((JSONObject)localObject).optString("gc");
      String str5 = ((JSONObject)localObject).optString("robotUin");
      String str6 = ((JSONObject)localObject).optString("robotName");
      int i = ((JSONObject)localObject).optInt("isRobotBuddy");
      localObject = ((JSONObject)localObject).optString("callback");
      Bundle localBundle = new Bundle();
      localBundle.putString("onurl", paramVarArgs);
      localBundle.putString("ontitle", str1);
      localBundle.putString("offtitle", str3);
      localBundle.putString("offurl", str2);
      localBundle.putString("robotuin", str5);
      localBundle.putString("troopuin", str4);
      localBundle.putString("robotname", str6);
      localBundle.putInt("isrobotbuddy", i);
      paramVarArgs = DataFactory.a("ipc_cmd_invoke_robot_function", (String)localObject, this.mOnRemoteResp.key, localBundle);
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramVarArgs);
      return true;
    }
    catch (JSONException paramVarArgs) {}
    return false;
    return false;
  }
  
  private boolean c(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length < 1) {
        return false;
      }
      paramVarArgs = paramVarArgs[0];
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs);
        paramVarArgs = ((JSONObject)localObject2).optString("gc");
        localObject1 = ((JSONObject)localObject2).optString("robotUin");
        String str = ((JSONObject)localObject2).optString("robotName");
        boolean bool = ((JSONObject)localObject2).optBoolean("isAdd");
        localObject2 = ((JSONObject)localObject2).optString("callback");
        Bundle localBundle = new Bundle();
        localBundle.putString("robotuin", (String)localObject1);
        localBundle.putString("troopuin", paramVarArgs);
        localBundle.putString("robotname", str);
        localBundle.putBoolean("isadd", Boolean.valueOf(bool).booleanValue());
        paramVarArgs = DataFactory.a("ipc_cmd_robot_member_change_function", (String)localObject2, this.mOnRemoteResp.key, localBundle);
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramVarArgs);
        return true;
      }
      catch (JSONException paramVarArgs)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleJsRequest exception notifyRobotMmeberChange");
        ((StringBuilder)localObject1).append(paramVarArgs.getMessage());
        QLog.e("TroopRobotPlugin", 2, ((StringBuilder)localObject1).toString());
      }
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"robotsummary".equals(paramString2)) {
      return false;
    }
    if ("sharecard".equals(paramString3)) {
      return a(paramVarArgs);
    }
    if ("executecommand".equals(paramString3)) {
      return b(paramVarArgs);
    }
    if ("memberchange".equals(paramString3)) {
      return c(paramVarArgs);
    }
    return false;
  }
  
  public void onResponse(Bundle paramBundle)
  {
    super.onResponse(paramBundle);
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotPlugin", 2, "robot plugin onResponse is null");
      }
      return;
    }
    if (paramBundle.getInt("respkey") != this.mOnRemoteResp.key)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotPlugin", 2, "robot plugin onResponse key not match");
      }
      return;
    }
    Object localObject1 = paramBundle.getString("cmd");
    int i;
    if ("ipc_cmd_share_robot_card".equals(localObject1))
    {
      i = paramBundle.getBundle("response").getInt("result");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("robot plugin is robot:");
        ((StringBuilder)localObject1).append(i);
        QLog.d("TroopRobotPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      if (i == 1)
      {
        localObject1 = this.mRuntime.d();
        paramBundle = paramBundle.getBundle("request");
        RobotUtils.a(null, (Activity)localObject1, null, paramBundle.getString("robotuin"), paramBundle.getString("robotname"), 21);
      }
    }
    else if ("ipc_cmd_invoke_robot_function".equals(localObject1))
    {
      localObject1 = paramBundle.getBundle("response").getString("result");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("strResult:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("TroopRobotPlugin", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = this.mRuntime.d();
      Object localObject3 = paramBundle.getBundle("request");
      i = ((Bundle)localObject3).getInt("isrobotbuddy");
      paramBundle = ((Bundle)localObject3).getString("onurl");
      String str1 = ((Bundle)localObject3).getString("ontitle");
      String str2 = ((Bundle)localObject3).getString("offtitle");
      String str3 = ((Bundle)localObject3).getString("offurl");
      String str4 = ((Bundle)localObject3).getString("robotuin");
      String str5 = ((Bundle)localObject3).getString("troopuin");
      localObject3 = ((Bundle)localObject3).getString("robotname");
      if (i == 1)
      {
        RobotUtils.a((Context)localObject2, str5, (String)localObject1, str4, (String)localObject3, paramBundle, str1, str3, str2, i);
        return;
      }
      if (i == 0) {
        RobotUtils.a((Context)localObject2, (String)localObject1, null, str4, (String)localObject3, paramBundle, str1, str3, str2, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.TroopRobotPlugin
 * JD-Core Version:    0.7.0.1
 */