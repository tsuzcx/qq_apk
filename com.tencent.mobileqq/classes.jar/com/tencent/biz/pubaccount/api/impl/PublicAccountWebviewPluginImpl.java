package com.tencent.biz.pubaccount.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountWebviewPluginImpl
  extends WebViewPlugin
  implements IPublicAccountWebviewPlugin
{
  public static final String TAG = "PublicAccountWebviewPlugin";
  private static final String URL_FOR_REPORT = "/report?";
  public Bundle mReqBundle;
  
  public PublicAccountWebviewPluginImpl()
  {
    this.mPluginNameSpace = "PublicAccountJs";
  }
  
  private void doReport(String paramString)
  {
    Object localObject = URLUtil.a(paramString);
    paramString = getString((Map)localObject, "sub_action", "");
    String str = getString((Map)localObject, "action_name", "");
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str)))
    {
      ReportController.b(null, getString((Map)localObject, "tag", "P_CliOper"), getString((Map)localObject, "main_action", "Pb_account_lifeservice"), getString((Map)localObject, "to_uin", ""), paramString, str, getInt((Map)localObject, "from_type", 0), getInt((Map)localObject, "result", 0), getString((Map)localObject, "r2", ""), getString((Map)localObject, "r3", ""), getString((Map)localObject, "r4", ""), getString((Map)localObject, "r5", ""));
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("subAction[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("] or actionName[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("] null");
      QLog.d("PublicAccountWebviewPlugin", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private int getInt(Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (!TextUtils.isEmpty(paramMap)) {}
    try
    {
      i = Integer.parseInt(paramMap);
      return i;
    }
    catch (Exception paramMap) {}
    return paramInt;
  }
  
  private String getString(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    paramString1 = (String)paramMap.get(paramString1);
    paramMap = paramString1;
    if (paramString1 == null) {
      paramMap = paramString2;
    }
    return paramMap;
  }
  
  public WebViewPlugin getWebViewPlugin()
  {
    return this;
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 4L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("setShopFolderMsg".equals(paramString3)) {}
    int i;
    label854:
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString1.optString("msg");
      i = paramString1.optInt("type");
      paramString1 = new Intent("action_folder_msg_change");
      paramString1.putExtra("msg", paramJsBridgeListener);
      paramString1.putExtra("type", i);
      this.mRuntime.d().sendBroadcast(paramString1);
      return true;
    }
    catch (Exception paramJsBridgeListener) {}
    if ("onShopMsgClick".equals(paramString3))
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString1.optString("callback");
      paramString1 = paramString1.optString("uin");
      paramString2 = this.mRuntime.d();
      if (((paramString2 instanceof EcshopWebActivity)) && (!TextUtils.isEmpty(paramJsBridgeListener)))
      {
        ((EcshopWebActivity)paramString2).a(paramString1);
        paramString1 = new JSONObject();
        paramString1.put("ret", 0);
        callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        return true;
      }
    }
    else if ("getShopFirstMsg".equals(paramString3))
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
      paramString1 = this.mRuntime.d();
      if (((paramString1 instanceof EcshopWebActivity)) && (!TextUtils.isEmpty(paramJsBridgeListener)))
      {
        paramString1 = (EcshopWebActivity)paramString1;
        paramString2 = new JSONObject();
        if ((paramString1.b != null) && (!paramString1.b.isEmpty()))
        {
          paramString3 = (RecentShopParcel)paramString1.b.get(0);
          paramVarArgs = new JSONObject();
          if ((paramString3 != null) && (paramString3.g > 0) && (paramString3.j >= paramString1.g) && (paramString3.j > paramString3.k))
          {
            paramVarArgs.put("uin", paramString3.a);
            paramVarArgs.put("msg", paramString3.d);
            paramVarArgs.put("nick", paramString3.b);
            paramString2.put("data", paramVarArgs);
          }
        }
        callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
        return true;
      }
    }
    else
    {
      if (TextUtils.equals("socialize_feeds_update", paramString3)) {
        try
        {
          this.mReqBundle.clear();
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.getString("feeds_id");
          paramString1 = paramString1.optString("feeds_type", "1");
          this.mReqBundle.putLong("feeds_id", Long.valueOf(paramJsBridgeListener).longValue());
          this.mReqBundle.putInt("feeds_type", Integer.valueOf(paramString1).intValue());
          sendRemoteReq(DataFactory.a("ipc_kandian_socialfeeds_update", "", -1, this.mReqBundle), false, false);
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.d("PublicAccountWebviewPlugin", 1, "handle socialize_feeds_update response failed ", paramJsBridgeListener);
          return true;
        }
      }
      if ("toggleFolderList".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          i = paramJsBridgeListener.optInt("y_offset");
          boolean bool = paramJsBridgeListener.optBoolean("show_list");
          paramJsBridgeListener = this.mRuntime.d();
          if (!(paramJsBridgeListener instanceof EcshopWebActivity)) {
            break label854;
          }
          paramJsBridgeListener = ((EcshopWebActivity)paramJsBridgeListener).getCurrentWebViewFragment();
          if (!(paramJsBridgeListener instanceof ShopWebViewFragment)) {
            break label854;
          }
          if (bool)
          {
            ((ShopWebViewFragment)paramJsBridgeListener).a(1, i);
            return true;
          }
          ((ShopWebViewFragment)paramJsBridgeListener).a(0, 0);
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      } else if ("showRedDot".equals(paramString3)) {
        try
        {
          i = new JSONObject(paramVarArgs[0]).optInt("reddot");
          paramJsBridgeListener = this.mRuntime.d();
          if (!(paramJsBridgeListener instanceof EcshopWebActivity)) {
            break label854;
          }
          paramJsBridgeListener = ((EcshopWebActivity)paramJsBridgeListener).getCurrentWebViewFragment();
          if (!(paramJsBridgeListener instanceof ShopWebViewFragment)) {
            break label854;
          }
          ((ShopWebViewFragment)paramJsBridgeListener).a(i);
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      } else if ("getShopPushInfo".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
          paramString1 = this.mRuntime.d();
          if ((paramString1 instanceof EcshopWebActivity))
          {
            paramString1 = paramString1.getIntent().getBundleExtra("bundle");
            paramString2 = new JSONObject();
            paramString2.put("taskId", paramString1.getInt("PUSH_TASK_ID"));
            paramString2.put("folderMsg", paramString1.getString("str_ecshop_diy"));
            paramString2.put("taskType", paramString1.getInt("PUSH_TASK_TYPE"));
            paramString2.put("taskInfo", paramString1.getString("PUSH_TASK_INFO"));
            paramString2.put("receiveTs", paramString1.getLong("PUSH_RECEIVE_TIME"));
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
            return true;
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("PublicAccountWebviewPlugin", 1, "getShopPushInfo error:", paramJsBridgeListener);
        }
      }
    }
    return true;
    return true;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.equals("publicaccount")) && (paramString1 != null) && (paramString1.contains("/report?")))
    {
      doReport(paramString1);
      return true;
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      if (paramBoolean2) {
        Toast.makeText(this.mRuntime.d().getApplicationContext(), HardCodeUtil.a(2131906571), 0).show();
      }
    }
    else
    {
      if (paramBoolean1)
      {
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(paramBundle);
        return;
      }
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountWebviewPluginImpl
 * JD-Core Version:    0.7.0.1
 */