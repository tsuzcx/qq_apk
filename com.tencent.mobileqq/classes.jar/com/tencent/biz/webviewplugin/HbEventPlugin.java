package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.SparseArray;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class HbEventPlugin
  extends WebViewPlugin
{
  private static int b = 1;
  private SparseArray<WeakReference<HbEventPlugin.DataReceiver>> a = null;
  
  public HbEventPlugin()
  {
    this.mPluginNameSpace = "redEnvelope";
  }
  
  private static int a()
  {
    int i = b;
    b = i + 1;
    return i;
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = new Intent(paramString1);
    paramString1.putExtra("portal_type_key", paramInt1);
    paramString1.putExtra("portal_agrs", paramString2);
    paramString1.putExtra("bc_seq", paramInt2);
    if (this.mRuntime.d() != null) {
      this.mRuntime.d().sendBroadcast(paramString1, "com.tencent.msg.permission.pushnotify");
    }
  }
  
  int a(String paramString)
  {
    if ("getRankingList".endsWith(paramString)) {
      return 1008;
    }
    if ("getHead".endsWith(paramString)) {
      return 1009;
    }
    if ("getJumpBtnState".endsWith(paramString)) {
      return 1010;
    }
    if ("getNick".endsWith(paramString)) {
      return 1011;
    }
    if ("takePhoto".endsWith(paramString)) {
      return 1012;
    }
    return -1;
  }
  
  HbEventPlugin.DataReceiver a(int paramInt)
  {
    if (this.a == null) {
      this.a = new SparseArray(12);
    }
    Object localObject = new HbEventPlugin.DataReceiver(this, null);
    ((HbEventPlugin.DataReceiver)localObject).c = paramInt;
    localObject = new WeakReference(localObject);
    this.a.put(paramInt, localObject);
    return (HbEventPlugin.DataReceiver)((WeakReference)localObject).get();
  }
  
  void a(BroadcastReceiver paramBroadcastReceiver, String paramString)
  {
    paramString = new IntentFilter(paramString);
    if (this.mRuntime.d() != null) {
      this.mRuntime.d().registerReceiver(paramBroadcastReceiver, paramString, "com.tencent.msg.permission.pushnotify", null);
    }
  }
  
  void a(String paramString, String... paramVarArgs)
  {
    callJs(paramString, paramVarArgs);
  }
  
  boolean b(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    localObject = (WeakReference)((SparseArray)localObject).get(paramInt);
    if (localObject == null) {
      return false;
    }
    localObject = (HbEventPlugin.DataReceiver)((WeakReference)localObject).get();
    if (localObject == null) {
      return false;
    }
    try
    {
      this.mRuntime.d().unregisterReceiver((BroadcastReceiver)localObject);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        localException.printStackTrace();
      }
    }
    return true;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest: ");
      paramJsBridgeListener.append(paramString3);
      paramJsBridgeListener.append(",");
      paramJsBridgeListener.append(paramVarArgs);
      QLog.i("PortalManager.HbEventPlugin", 2, paramJsBridgeListener.toString());
    }
    if (("redEnvelope".endsWith(paramString2)) && (("getRankingList".endsWith(paramString3)) || ("getHead".endsWith(paramString3)) || ("getJumpBtnState".endsWith(paramString3)) || ("getNick".endsWith(paramString3)) || ("takePhoto".endsWith(paramString3))))
    {
      int i = a();
      paramJsBridgeListener = a(i);
      a(paramJsBridgeListener, "com.tencent.portal.resp.action");
      if (paramVarArgs != null) {
        try
        {
          if (paramVarArgs.length > 0)
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener.a = paramString1.getString("callback");
            paramJsBridgeListener.b = paramString1.getJSONObject("params").toString();
          }
        }
        catch (JSONException paramString1)
        {
          paramString1.printStackTrace();
        }
      }
      a("com.tencent.portal.req.action", a(paramString3), i, paramJsBridgeListener.b);
      return true;
    }
    return false;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.a;
    if ((localObject != null) && (((SparseArray)localObject).size() > 0))
    {
      int i = 0;
      while (i < this.a.size())
      {
        localObject = (HbEventPlugin.DataReceiver)((WeakReference)this.a.get(i)).get();
        if (localObject != null) {
          b(((HbEventPlugin.DataReceiver)localObject).c);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.HbEventPlugin
 * JD-Core Version:    0.7.0.1
 */