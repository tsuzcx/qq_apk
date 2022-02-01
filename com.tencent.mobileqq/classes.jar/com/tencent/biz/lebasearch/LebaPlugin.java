package com.tencent.biz.lebasearch;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class LebaPlugin
  extends WebViewPlugin
{
  QQCustomDialog a;
  TroopMemberApiClient b = null;
  QQCustomDialog c = null;
  String d = null;
  public BusinessObserver e = new LebaPlugin.1(this);
  
  public LebaPlugin()
  {
    this.mPluginNameSpace = "lebaPlugin";
  }
  
  private void a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (this.mRuntime.d() != null)
    {
      if (this.mRuntime.d().isFinishing()) {
        return;
      }
      if (this.a == null) {
        this.a = Utils.createPluginSetDialogForWeb(this.mRuntime.d(), this.b, this.e, paramInt, paramLong, paramString1, paramString2);
      }
      if (!this.a.isShowing()) {
        this.a.show();
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramJsBridgeListener = paramVarArgs[0];
    if (paramString3 == null) {
      return false;
    }
    long l;
    if (paramString3.equals("showOpenDialog")) {
      try
      {
        paramString1 = new JSONObject(paramJsBridgeListener);
        l = paramString1.optLong("id", -1L);
        paramJsBridgeListener = paramString1.optString("msg");
        paramString1 = paramString1.optString("callback");
        if (l == -1L) {
          break label296;
        }
        paramString2 = new Bundle();
        paramString2.putInt("reqCode", 10000);
        paramString2.putLong("uiResId", l);
        paramString2.putString("msg", paramJsBridgeListener);
        paramString2.putString("callback", paramString1);
        paramString2.putInt("dialogType", 1);
        this.b.a(18, paramString2, this.e);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    } else if (paramString3.equals("getPluginStatus")) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
        l = paramJsBridgeListener.optLong("id", -1L);
        paramJsBridgeListener = paramJsBridgeListener.optString("callback");
        if (l == -1L) {
          break label296;
        }
        paramString1 = new Bundle();
        paramString1.putInt("reqCode", 10002);
        paramString1.putLong("uiResId", l);
        paramString1.putString("callback", paramJsBridgeListener);
        this.b.a(18, paramString1, this.e);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    } else if (paramString3.equals("search")) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramJsBridgeListener).optString("keyWord");
        if (!TextUtils.isEmpty(paramJsBridgeListener))
        {
          this.mRuntime.d();
          SearchUtils.a("hot_list", "clk_hot_list", new String[] { paramJsBridgeListener });
          return true;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
    }
    label296:
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.b = TroopMemberApiClient.a();
    this.b.e();
  }
  
  protected void onDestroy()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((TroopMemberApiClient)localObject).f();
    }
    localObject = this.a;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      this.a.dismiss();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaPlugin
 * JD-Core Version:    0.7.0.1
 */