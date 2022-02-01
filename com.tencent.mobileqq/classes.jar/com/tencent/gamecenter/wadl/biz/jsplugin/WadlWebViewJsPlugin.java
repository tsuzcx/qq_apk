package com.tencent.gamecenter.wadl.biz.jsplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlCommConfig;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlCmdListener;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.biz.listener.WadlResCallBack;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WadlWebViewJsPlugin
  extends WebViewPlugin
  implements WadlCmdListener, WadlProxyServiceCallBackInterface, WadlResCallBack
{
  private static String b = "registerDownloadCallBackListener";
  private static String c = "getQueryDownloadAction";
  private static String d = "getQueryDownloadActionByVia";
  private static String e = "doGCDownloadAction";
  private static String f = "doDownloadAction";
  private static String g = "deleteDownload";
  private static String h = "getAvailableBytes";
  private static String i = "queryAllDownloadTask";
  private static String j = "getInstalledAppVersionCode";
  private static String k = "getValidWebSsoCmds";
  private static String l = "requestWebSso";
  private static String m = "requestFloatingPermission";
  private static String n = "queryFloatingPermission";
  private static String o = "openFloatingSetting";
  private static String p = "queryAllDownloadRes";
  private static String q = "doResDownloadAction";
  private static String r = "registerResCallBack";
  private static String s = "isFirstTimeEntry";
  private static String t = "clearFirstRimeEntryFlag";
  private static String u = "getDownloadVersion";
  private static String v = "getAppVersionCode";
  private static String w = "getAppVersionName";
  private static String x = "getDelayDownloadTasks";
  private static String y = "delDelayDownloadTasks";
  private String A = "";
  private Handler B;
  protected Toast a = null;
  private String z = "";
  
  public WadlWebViewJsPlugin()
  {
    this.mPluginNameSpace = "wadl_download";
    WadlProxyServiceUtil.a().a(this);
    WadlProxyServiceUtil.a().a(this);
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).addListener(this);
    this.B = new Handler(Looper.getMainLooper());
  }
  
  private String a()
  {
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, "enter getDownloadVersion");
    String str = String.valueOf(4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDownloadVersion',{\"version\":\"");
    localStringBuilder.append(str);
    localStringBuilder.append("\",\"r\":\"-1\"});}void(0);");
    callJs(localStringBuilder.toString());
    return str;
  }
  
  private void a(int paramInt, WadlParams paramWadlParams)
  {
    if (paramWadlParams == null) {
      return;
    }
    int i1 = 1;
    if ((paramInt != 4) && (paramInt != 5))
    {
      if (paramInt == 7)
      {
        WadlProxyServiceUtil.a().a(0, paramWadlParams.e);
        this.B.post(new WadlWebViewJsPlugin.1(this, paramWadlParams));
        i1 = 0;
      }
    }
    else {
      WadlProxyServiceUtil.a().c(0, paramWadlParams.e);
    }
    if (i1 != 0) {
      n(GameCenterUtil.c(paramInt));
    }
  }
  
  private void a(String paramString)
  {
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, "enter registerDownloadCallBackListener");
    this.z = paramString;
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getInstalledAppVersionCode packageNameJsonStr=");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(",guid=");
    ((StringBuilder)localObject1).append(paramString2);
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, ((StringBuilder)localObject1).toString());
    localObject1 = paramString2;
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramString1);
        paramString1 = paramString2;
        localObject1 = paramString2;
        if (TextUtils.isEmpty(paramString2))
        {
          localObject1 = paramString2;
          paramString1 = ((JSONObject)localObject2).optString("guid");
        }
        localObject1 = paramString1;
        JSONArray localJSONArray2 = ((JSONObject)localObject2).optJSONArray("packageNames");
        localObject1 = paramString1;
        localJSONArray1 = new JSONArray();
        if (localJSONArray2 == null) {
          continue;
        }
        i1 = 0;
        localObject1 = paramString1;
        if (i1 >= localJSONArray2.length()) {
          continue;
        }
        localObject1 = paramString1;
        str2 = localJSONArray2.getString(i1);
        localObject1 = paramString1;
        paramString2 = GameCenterUtil.d(str2);
        localObject2 = "";
        if (paramString2 == null) {
          continue;
        }
        localObject1 = paramString1;
        localObject2 = String.valueOf(paramString2.versionCode);
        localObject1 = paramString1;
        paramString2 = paramString2.versionName;
        localObject1 = paramString1;
        str1 = GameCenterUtil.e(GameCenterUtil.c(str2));
      }
      catch (Exception paramString1)
      {
        Object localObject2;
        JSONArray localJSONArray1;
        int i1;
        String str2;
        JSONObject localJSONObject;
        continue;
        paramString2 = "";
        String str1 = paramString2;
        continue;
      }
      localObject1 = paramString1;
      localJSONObject = new JSONObject();
      localObject1 = paramString1;
      localJSONObject.put("packageName", str2);
      localObject1 = paramString1;
      localJSONObject.put("versionCode", localObject2);
      localObject1 = paramString1;
      localJSONObject.put("versionName", paramString2);
      localObject1 = paramString1;
      localJSONObject.put("channel", str1);
      localObject1 = paramString1;
      localJSONArray1.put(localJSONObject);
      i1 += 1;
    }
    localObject1 = paramString1;
    paramString2 = new StringBuilder();
    localObject1 = paramString1;
    paramString2.append("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getInstalledAppVersionCode',{'guid':'");
    localObject1 = paramString1;
    paramString2.append(paramString1);
    localObject1 = paramString1;
    paramString2.append("','r':'0','data':'");
    localObject1 = paramString1;
    paramString2.append(localJSONArray1.toString());
    localObject1 = paramString1;
    paramString2.append("'});}void(0);");
    localObject1 = paramString1;
    paramString1 = paramString2.toString();
    break label390;
    paramString1 = new StringBuilder();
    paramString1.append("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getInstalledAppVersionCode',{\"guid\":\"");
    paramString1.append((String)localObject1);
    paramString1.append("\",\"r\":\"-1\"});}void(0);");
    paramString1 = paramString1.toString();
    label390:
    callJs(paramString1);
  }
  
  private boolean a(int paramInt, String... paramVarArgs)
  {
    return (paramVarArgs != null) && (paramVarArgs.length > paramInt);
  }
  
  private boolean a(String paramString, JsBridgeListener paramJsBridgeListener, String... paramVarArgs)
  {
    if (b.equals(paramString))
    {
      if (a(0, paramVarArgs))
      {
        a(paramVarArgs[0]);
        paramJsBridgeListener.a(null);
      }
      return true;
    }
    if (s.equals(paramString))
    {
      paramJsBridgeListener.a(Boolean.valueOf(b()));
      return true;
    }
    if (t.equals(paramString))
    {
      c();
      paramJsBridgeListener.a(null);
      return true;
    }
    if (u.equals(paramString))
    {
      paramJsBridgeListener.a(a());
      return true;
    }
    if (j.equals(paramString))
    {
      if (a(1, paramVarArgs))
      {
        a(paramVarArgs[0], paramVarArgs[1]);
        paramJsBridgeListener.a(null);
      }
      return true;
    }
    if (v.equals(paramString))
    {
      if (a(0, paramVarArgs)) {
        paramJsBridgeListener.a(b(paramVarArgs[0]));
      }
      return true;
    }
    if (w.equals(paramString))
    {
      if (a(0, paramVarArgs)) {
        paramJsBridgeListener.a(c(paramVarArgs[0]));
      }
      return true;
    }
    if (h.equals(paramString))
    {
      paramJsBridgeListener.a(Long.valueOf(d()));
      return true;
    }
    if (k.equals(paramString))
    {
      paramJsBridgeListener.a(h());
      return true;
    }
    return false;
  }
  
  private String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAppVersionCode packageName=");
    localStringBuilder.append(paramString);
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, localStringBuilder.toString());
    int i1 = GameCenterUtil.b(paramString);
    if (i1 == -1) {
      return "";
    }
    return String.valueOf(i1);
  }
  
  private boolean b()
  {
    boolean bool = MobileQQ.sMobileQQ.getSharedPreferences("wadl_jstask_file", 0).getBoolean("firstTime", true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("firstTime entry:");
    localStringBuilder.append(bool);
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, localStringBuilder.toString());
    return bool;
  }
  
  private boolean b(String paramString, JsBridgeListener paramJsBridgeListener, String... paramVarArgs)
  {
    if (i.equals(paramString))
    {
      e();
      paramJsBridgeListener.a(null);
      return true;
    }
    if (c.equals(paramString))
    {
      if (a(0, paramVarArgs))
      {
        d(paramVarArgs[0]);
        paramJsBridgeListener.a(null);
      }
      return true;
    }
    if (d.equals(paramString))
    {
      if (a(0, paramVarArgs))
      {
        e(paramVarArgs[0]);
        paramJsBridgeListener.a(null);
      }
      return true;
    }
    if (g.equals(paramString))
    {
      if (a(0, paramVarArgs))
      {
        g(paramVarArgs[0]);
        paramJsBridgeListener.a(null);
      }
      return true;
    }
    if ((!f.equals(paramString)) && (!e.equals(paramString))) {
      return false;
    }
    if (a(0, paramVarArgs)) {
      paramJsBridgeListener.a(Integer.valueOf(h(paramVarArgs[0])));
    }
    return true;
  }
  
  private String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAppVersionName:");
    localStringBuilder.append(paramString);
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, localStringBuilder.toString());
    paramString = GameCenterUtil.d(paramString);
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.versionName);
      localStringBuilder.append("");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void c()
  {
    SharedPreferences.Editor localEditor = MobileQQ.sMobileQQ.getSharedPreferences("wadl_jstask_file", 0).edit();
    localEditor.putBoolean("firstTime", false);
    localEditor.commit();
  }
  
  private void c(WadlResult paramWadlResult)
  {
    if (paramWadlResult != null)
    {
      paramWadlResult = GameCenterUtil.a(paramWadlResult).toString();
      StringBuilder localStringBuilder;
      if (TextUtils.isEmpty(this.z))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadProcess',");
        localStringBuilder.append(paramWadlResult);
        localStringBuilder.append(");}void(0);");
        paramWadlResult = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.z);
        localStringBuilder.append("(");
        localStringBuilder.append(paramWadlResult);
        localStringBuilder.append(")");
        paramWadlResult = localStringBuilder.toString();
      }
      callJs(paramWadlResult);
    }
  }
  
  private boolean c(String paramString, JsBridgeListener paramJsBridgeListener, String... paramVarArgs)
  {
    if (p.equals(paramString))
    {
      g();
      paramJsBridgeListener.a(null);
      return true;
    }
    if (q.equals(paramString))
    {
      if (a(0, paramVarArgs)) {
        paramJsBridgeListener.a(Integer.valueOf(j(paramVarArgs[0])));
      }
      return true;
    }
    if (r.equals(paramString))
    {
      if (a(0, paramVarArgs))
      {
        i(paramVarArgs[0]);
        paramJsBridgeListener.a(null);
      }
      return true;
    }
    return false;
  }
  
  private long d()
  {
    try
    {
      long l1 = Utils.c();
      return l1;
    }
    catch (Exception localException)
    {
      label6:
      break label6;
    }
    return 0L;
  }
  
  private void d(WadlResult paramWadlResult)
  {
    if (paramWadlResult != null)
    {
      paramWadlResult = GameCenterUtil.b(paramWadlResult).toString();
      StringBuilder localStringBuilder;
      if (TextUtils.isEmpty(this.A))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadResProcess',");
        localStringBuilder.append(paramWadlResult);
        localStringBuilder.append(");}void(0);");
        paramWadlResult = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.A);
        localStringBuilder.append("(");
        localStringBuilder.append(paramWadlResult);
        localStringBuilder.append(")");
        paramWadlResult = localStringBuilder.toString();
      }
      callJs(paramWadlResult);
    }
  }
  
  private void d(String paramString)
  {
    try
    {
      localObject1 = new JSONObject(paramString).getJSONArray("infolist");
    }
    catch (JSONException localJSONException)
    {
      Object localObject1;
      label19:
      Object localObject2;
      break label19;
    }
    QLog.w("Wadl_WadlWebViewJsPlugin", 1, "getQueryDownloadAction exception");
    localObject1 = null;
    localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = new JSONArray(paramString);
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        int i1;
        continue;
        i1 += 1;
      }
    }
    QLog.w("Wadl_WadlWebViewJsPlugin", 1, "getQueryDownloadAction exception");
    localObject2 = localObject1;
    if (localObject2 != null) {
      try
      {
        int i2 = ((JSONArray)localObject2).length();
        paramString = new ArrayList();
        i1 = 0;
        if (i1 < i2)
        {
          localObject1 = ((JSONArray)localObject2).getJSONObject(i1).optString("appid");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label160;
          }
          paramString.add(localObject1);
          break label160;
        }
        if (paramString.size() > 0)
        {
          WadlProxyServiceUtil.a().a(paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("Wadl_WadlWebViewJsPlugin", 1, "getQueryDownloadAction exception", paramString);
      }
    } else {
      return;
    }
  }
  
  private boolean d(String paramString, JsBridgeListener paramJsBridgeListener, String... paramVarArgs)
  {
    if (m.equals(paramString))
    {
      if (a(0, paramVarArgs))
      {
        GameCenterUtil.f(paramVarArgs[0]);
        paramJsBridgeListener.a(null);
      }
      return true;
    }
    if (n.equals(paramString))
    {
      if (a(0, paramVarArgs)) {
        paramJsBridgeListener.a(Integer.valueOf(k(paramVarArgs[0])));
      }
      return true;
    }
    if (o.equals(paramString))
    {
      if (a(0, paramVarArgs)) {
        paramJsBridgeListener.a(Integer.valueOf(l(paramVarArgs[0])));
      }
      return true;
    }
    return false;
  }
  
  private void e()
  {
    WadlProxyServiceUtil.a().a();
  }
  
  private void e(String paramString)
  {
    if ("ALL_TASK_QUERY_IDENTITY".equals(paramString))
    {
      e();
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getString("via");
      WadlProxyServiceUtil.a().a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Wadl_WadlWebViewJsPlugin", 1, "query getQueryDownloadActionByVia>>>", paramString);
    }
  }
  
  private boolean e(String paramString, JsBridgeListener paramJsBridgeListener, String... paramVarArgs)
  {
    if (y.equals(paramString))
    {
      if (a(0, paramVarArgs))
      {
        f(paramVarArgs[0]);
        paramJsBridgeListener.a(null);
      }
      return true;
    }
    if (x.equals(paramString))
    {
      f();
      paramJsBridgeListener.a(null);
      return true;
    }
    if (l.equals(paramString))
    {
      if (a(0, paramVarArgs))
      {
        m(paramVarArgs[0]);
        paramJsBridgeListener.a(null);
      }
      return true;
    }
    return false;
  }
  
  private void f()
  {
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, "getDelayDownloadTasks() BEGIN");
    Object localObject = GameCenterSpUtils.a("DELAY_LIST");
    JSONArray localJSONArray = new JSONArray();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      int i1 = 0;
      while (i1 < localObject.length)
      {
        JSONObject localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty(localObject[i1])) {
          try
          {
            localJSONObject.put("appid", localObject[i1]);
            localJSONArray.put(localJSONObject);
          }
          catch (JSONException localJSONException)
          {
            QLog.e("Wadl_WadlWebViewJsPlugin", 1, "getDelayDownloadTasks>>>", localJSONException);
          }
        }
        i1 += 1;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDelayDownloadTasks',{\"result\" : 0, \"task\":");
    ((StringBuilder)localObject).append(localJSONArray.toString());
    ((StringBuilder)localObject).append("});}void(0);");
    callJs(((StringBuilder)localObject).toString());
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, "getDelayDownloadTasks() END");
  }
  
  private void f(String paramString)
  {
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, "enter delDelayDownloadTasks()");
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("tasks");
      int i1 = 0;
      while (i1 < paramString.length())
      {
        GameCenterUtil.b(paramString.get(i1).toString(), "DELAY_LIST");
        i1 += 1;
      }
      callJs("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.delDelayDownloadTasks',{\"result\" : 0 });}void(0);");
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Wadl_WadlWebViewJsPlugin", 1, "delDelayDownloadTasks>>>", paramString);
    }
  }
  
  private void g()
  {
    WadlProxyServiceUtil.a().b();
  }
  
  private void g(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteDownload appid=");
    localStringBuilder.append(paramString);
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, localStringBuilder.toString());
    WadlProxyServiceUtil.a().c(0, paramString);
  }
  
  private int h(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doDownloadAction jsonParams=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, ((StringBuilder)localObject).toString());
    localObject = this.mRuntime.f();
    if (localObject != null) {
      localObject = ((WebViewProvider)localObject).getCurrentUrl();
    } else {
      localObject = "";
    }
    WadlParams localWadlParams = new WadlParams(paramString);
    localWadlParams.h = 0;
    if (TextUtils.isEmpty(localWadlParams.x)) {
      localWadlParams.x = ((String)localObject);
    }
    WadlProxyServiceUtil.a().a(localWadlParams);
    if ((localWadlParams.c == 2) || (localWadlParams.c == 12))
    {
      paramString = null;
      Activity localActivity = this.mRuntime.d();
      if (localActivity != null) {
        paramString = localActivity.getIntent();
      }
      paramString = GameCenterUtil.a(paramString);
      new WadlReportBuilder().a("dc00087").h("558").c("205906").b(localWadlParams.e).a(1, "55801").a(11, "4").a(12, "430").a(2, String.valueOf(paramString.first)).a(3, (String)paramString.second).a(4, localWadlParams.i).a(5, localWadlParams.k).a(6, (String)localObject).a();
    }
    return 0;
  }
  
  private String h()
  {
    Object localObject1 = (WadlCommConfig)((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).getConfig("comminfo");
    if (localObject1 != null) {
      localObject1 = ((WadlCommConfig)localObject1).a();
    } else {
      localObject1 = null;
    }
    String str;
    if (localObject1 != null) {
      try
      {
        localObject2 = new JSONArray();
        localObject1 = ((HashSet)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((JSONArray)localObject2).put(((Iterator)localObject1).next());
        }
        localObject1 = ((JSONArray)localObject2).toString();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Wadl_WadlWebViewJsPlugin", 1, "getValidWebSsoCmds>>>", localThrowable);
      }
    } else {
      str = "";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getValidWebSsoCmds...cmdsJsonStr=");
    ((StringBuilder)localObject2).append(str);
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, ((StringBuilder)localObject2).toString());
    return str;
  }
  
  private void i(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enter registerResCallBack callbackMethod=");
    localStringBuilder.append(paramString);
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, localStringBuilder.toString());
    this.A = paramString;
  }
  
  private int j(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doDownloadResAction jsonParams=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, ((StringBuilder)localObject).toString());
    localObject = this.mRuntime.f();
    if (localObject != null) {
      localObject = ((WebViewProvider)localObject).getCurrentUrl();
    } else {
      localObject = "";
    }
    paramString = new WadlParams(paramString);
    paramString.h = 0;
    paramString.b = true;
    if (TextUtils.isEmpty(paramString.x)) {
      paramString.x = ((String)localObject);
    }
    WadlProxyServiceUtil.a().d(paramString);
    return 0;
  }
  
  private int k(String paramString)
  {
    int i2 = Build.VERSION.SDK_INT;
    int i1 = 0;
    StringBuilder localStringBuilder;
    boolean bool1;
    if (i2 <= 28)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sdk version lower android10,version is ");
        localStringBuilder.append(Build.VERSION.SDK_INT);
        QLog.d("Wadl_WadlWebViewJsPlugin", 1, localStringBuilder.toString());
      }
      bool1 = true;
    }
    else
    {
      boolean bool2 = ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(MobileQQ.getContext());
      bool1 = bool2;
      if (!bool2)
      {
        new WadlReportBuilder().a("dc00087").h("558").b(paramString).c("202473").a(0).a();
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryFloatingPermission appid=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",floatPermission=");
      localStringBuilder.append(bool1);
      QLog.d("Wadl_WadlWebViewJsPlugin", 1, localStringBuilder.toString());
    }
    if (bool1) {
      i1 = 1;
    }
    return i1;
  }
  
  private int l(String paramString)
  {
    Object localObject;
    int i1;
    if (Build.VERSION.SDK_INT <= 28)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sdk version lower android10,version is ");
        ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
        QLog.d("Wadl_WadlWebViewJsPlugin", 1, ((StringBuilder)localObject).toString());
      }
      i1 = 0;
    }
    else
    {
      localObject = this.mRuntime.d();
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).requestPermission((Context)localObject);
        i1 = 1;
      }
      else
      {
        i1 = -1;
      }
      new WadlReportBuilder().a("dc00087").h("558").b(paramString).c("202473").a(i1).a();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openFloatingSetting appId=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",result=");
      ((StringBuilder)localObject).append(i1);
      QLog.d("Wadl_WadlWebViewJsPlugin", 1, ((StringBuilder)localObject).toString());
    }
    return i1;
  }
  
  private void m(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestWebSso...jsonParams=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, ((StringBuilder)localObject).toString());
    try
    {
      paramString = new JSONObject(paramString);
      localObject = paramString.getString("webssoCmdId");
      JSONObject localJSONObject = paramString.getJSONObject("webssoReq");
      paramString = (WadlCommConfig)((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).getConfig("comminfo");
      if (paramString != null) {
        paramString = paramString.a();
      } else {
        paramString = GameCenterUtil.a;
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramString != null) && (paramString.contains(localObject)))
      {
        paramString = new Bundle();
        paramString.putString("webssoReqJson", localJSONObject.toString());
        ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).requestWebSso((String)localObject, localJSONObject, paramString);
        return;
      }
      paramString = new StringBuilder();
      paramString.append("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.requestWebSso',{\"cmd\": ");
      paramString.append((String)localObject);
      paramString.append(", \"webssoReq\":");
      paramString.append(localJSONObject.toString());
      paramString.append(", \"ret\":-2});}void(0);");
      callJs(paramString.toString());
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Wadl_WadlWebViewJsPlugin", 1, "requestWebSso>>>", paramString);
    }
  }
  
  private void n(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.B.post(new WadlWebViewJsPlugin.2(this, paramString));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Wadl_WadlWebViewJsPlugin", 1, "showToast exception", paramString);
    }
  }
  
  public void a(WadlResult paramWadlResult)
  {
    if ((paramWadlResult != null) && (paramWadlResult.a != null))
    {
      WadlParams localWadlParams = paramWadlResult.a;
      int i1 = GameCenterUtil.a(paramWadlResult.d);
      if (i1 != -2)
      {
        if ((i1 != 6) && (i1 != 13) && (i1 != 20) && (i1 != 2) && (i1 != 3)) {
          if (i1 != 4)
          {
            if ((i1 != 9) && (i1 != 10)) {
              QLog.w("Wadl_WadlWebViewJsPlugin", 1, "download status not response!");
            }
          }
          else
          {
            n("下载完成");
            c(paramWadlResult);
            return;
          }
        }
        c(paramWadlResult);
        return;
      }
      i1 = GameCenterUtil.b(paramWadlResult.j);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWadlTaskStatusChanged  error,wadlErrCode=");
      localStringBuilder.append(i1);
      QLog.w("Wadl_WadlWebViewJsPlugin", 1, localStringBuilder.toString());
      c(paramWadlResult);
      a(i1, localWadlParams);
      return;
    }
    QLog.w("Wadl_WadlWebViewJsPlugin", 1, "onWadlTaskStatusChanged error wadlResult is null");
  }
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onQueryCallback params:");
    ((StringBuilder)localObject).append(paramArrayList);
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, ((StringBuilder)localObject).toString());
    if (paramArrayList != null) {
      try
      {
        localObject = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          ((JSONArray)localObject).put(GameCenterUtil.a((WadlResult)paramArrayList.next()));
        }
        paramArrayList = new StringBuilder();
        paramArrayList.append("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadAction',{\"guid\": ");
        paramArrayList.append("1");
        paramArrayList.append(", \"r\" : 0, \"data\":");
        paramArrayList.append(((JSONArray)localObject).toString());
        paramArrayList.append("});}void(0);");
        callJs(paramArrayList.toString());
        return;
      }
      catch (Exception paramArrayList)
      {
        QLog.e("Wadl_WadlWebViewJsPlugin", 1, "onQueryCallback exception:", paramArrayList);
      }
    }
  }
  
  public void b(WadlResult paramWadlResult)
  {
    if ((paramWadlResult != null) && (paramWadlResult.a != null))
    {
      int i1 = GameCenterUtil.a(paramWadlResult.d);
      if ((i1 != -2) && (i1 != 10) && (i1 != 20) && (i1 != 2) && (i1 != 3) && (i1 != 4))
      {
        QLog.w("Wadl_WadlWebViewJsPlugin", 1, "download status not response!");
        return;
      }
      d(paramWadlResult);
      return;
    }
    QLog.w("Wadl_WadlWebViewJsPlugin", 1, "onWadlResStatusChanged error wadlResult is null");
  }
  
  public void b(ArrayList<WadlResult> paramArrayList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onQueryCallbackVia params:");
    ((StringBuilder)localObject).append(paramArrayList);
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, ((StringBuilder)localObject).toString());
    if (paramArrayList != null) {
      try
      {
        localObject = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          ((JSONArray)localObject).put(GameCenterUtil.a((WadlResult)paramArrayList.next()));
        }
        paramArrayList = new StringBuilder();
        paramArrayList.append("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadActionByVia',{\"guid\": ");
        paramArrayList.append("1");
        paramArrayList.append(", \"r\" : 0, \"data\":");
        paramArrayList.append(((JSONArray)localObject).toString());
        paramArrayList.append("});}void(0);");
        callJs(paramArrayList.toString());
        return;
      }
      catch (Exception paramArrayList)
      {
        QLog.e("Wadl_WadlWebViewJsPlugin", 1, "onQueryCallbackVia exception:", paramArrayList);
      }
    }
  }
  
  public void c(ArrayList<WadlResult> paramArrayList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onQueryResCallback params:");
    ((StringBuilder)localObject).append(paramArrayList);
    QLog.i("Wadl_WadlWebViewJsPlugin", 1, ((StringBuilder)localObject).toString());
    if (paramArrayList != null) {
      try
      {
        localObject = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          ((JSONArray)localObject).put(GameCenterUtil.b((WadlResult)paramArrayList.next()));
        }
        paramArrayList = new StringBuilder();
        paramArrayList.append("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.queryAllDownloadRes',{\"r\" : 0, \"data\":");
        paramArrayList.append(((JSONArray)localObject).toString());
        paramArrayList.append("});}void(0);");
        callJs(paramArrayList.toString());
        return;
      }
      catch (Exception paramArrayList)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onQueryResCallback exception:");
        ((StringBuilder)localObject).append(paramArrayList.getMessage());
        QLog.e("Wadl_WadlWebViewJsPlugin", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public HashSet<String> getFilterCmds()
  {
    WadlCommConfig localWadlCommConfig = (WadlCommConfig)((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).getConfig("comminfo");
    if (localWadlCommConfig != null) {
      return localWadlCommConfig.a();
    }
    return GameCenterUtil.a;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    String str = "[";
    if (paramVarArgs != null)
    {
      int i2 = paramVarArgs.length;
      str = "[";
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = paramVarArgs[i1];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",");
        str = localStringBuilder.toString();
        i1 += 1;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("]");
    str = ((StringBuilder)localObject).toString();
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, str }));
    if (!"wadl_download".equals(paramString2)) {
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      str = paramVarArgs[0];
    } else {
      str = "";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleJsRequest method=");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(",params=");
    ((StringBuilder)localObject).append(str);
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, ((StringBuilder)localObject).toString());
    if (a(paramString3, paramJsBridgeListener, paramVarArgs)) {
      return true;
    }
    if (b(paramString3, paramJsBridgeListener, paramVarArgs)) {
      return true;
    }
    if (c(paramString3, paramJsBridgeListener, paramVarArgs)) {
      return true;
    }
    if (d(paramString3, paramJsBridgeListener, paramVarArgs)) {
      return true;
    }
    if (e(paramString3, paramJsBridgeListener, paramVarArgs)) {
      return true;
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCmdRsp cmd=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",isSucc");
    QLog.d("Wadl_WadlWebViewJsPlugin", 1, ((StringBuilder)localObject).toString());
    localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = new JSONObject();
    }
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("webssoReqJson");
    } else {
      paramIntent = null;
    }
    paramJSONObject = paramIntent;
    if (paramIntent == null) {
      paramJSONObject = "";
    }
    paramIntent = ((JSONObject)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.requestWebSso',{\"cmd\": ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", \"webssoReq\":");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append(", \"ret\":");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", \"data\":");
    ((StringBuilder)localObject).append(paramIntent);
    ((StringBuilder)localObject).append("});}void(0);");
    callJs(((StringBuilder)localObject).toString());
  }
  
  protected void onDestroy()
  {
    WadlProxyServiceUtil.a().b(this);
    WadlProxyServiceUtil.a().b(this);
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).removeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.jsplugin.WadlWebViewJsPlugin
 * JD-Core Version:    0.7.0.1
 */