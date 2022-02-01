package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.apollo.ApolloStoreStabilityReportManager;
import com.tencent.mobileqq.apollo.api.handler.IApolloWebDataHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.util.Pair;
import java.util.HashMap;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class SSOWebviewPlugin
  extends WebViewPlugin
{
  int jdField_a_of_type_Int = 5;
  long jdField_a_of_type_Long = 0L;
  protected Activity a;
  private Client.OnRemoteRespObserver jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver = new SSOWebviewPlugin.1(this);
  private CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  public HashMap<String, Long> a;
  NewIntent jdField_a_of_type_MqqAppNewIntent;
  int b;
  public HashMap<String, Long> b;
  public HashMap<String, Long> c = new HashMap();
  HashMap<String, Pair<Long, Integer>> d = new HashMap();
  HashMap<String, Integer> e = new HashMap();
  
  public SSOWebviewPlugin()
  {
    this.jdField_b_of_type_Int = 204800;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.mPluginNameSpace = "sso";
  }
  
  public static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fingerprint", Build.FINGERPRINT);
      localJSONObject.put("model", Build.MODEL);
      localJSONObject.put("manufacturer", Build.MANUFACTURER);
      localJSONObject.put("brand", Build.BRAND);
      localJSONObject.put("device", Build.DEVICE);
      localJSONObject.put("product", Build.PRODUCT);
      localJSONObject.put("id", Build.ID);
      localJSONObject.put("level", Build.VERSION.SDK_INT);
      localJSONObject.put("cpu_abi", Build.CPU_ABI);
      localJSONObject.put("cpu_abi2", Build.CPU_ABI2);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SSOWebviewPlugin", 1, "getRomData e:" + localThrowable);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      WebSSOAgentServlet.d = System.currentTimeMillis();
      long l1 = WebSSOAgentServlet.d - WebSSOAgentServlet.jdField_a_of_type_Long;
      long l2 = WebSSOAgentServlet.b - WebSSOAgentServlet.jdField_a_of_type_Long;
      long l3 = WebSSOAgentServlet.c - WebSSOAgentServlet.b;
      long l4 = WebSSOAgentServlet.d - WebSSOAgentServlet.c;
      if (QLog.isColorLevel()) {
        QLog.d("SSOWebviewPlugin", 2, "uniAgent, total=" + l1 + ",pre=" + l2 + ",msf=" + l3 + ",after=" + l4);
      }
      localJSONObject.put("totalTime", l1);
      localJSONObject.put("packTime", l2);
      localJSONObject.put("SSONetworkTime", l3);
      localJSONObject.put("unpackTime", l4);
      localJSONObject.put("serverProcessTime", paramLong);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SSOWebviewPlugin", 1, "generateAgentCostData e:" + localThrowable);
    }
    return localJSONObject;
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramAppInterface == null) || (paramJSONObject2 == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        long l1 = paramJSONObject2.optLong("totalTime");
        long l2 = paramJSONObject2.optLong("packTime");
        long l3 = paramJSONObject2.optLong("SSONetworkTime");
        long l4 = paramJSONObject2.optLong("unpackTime");
        long l5 = paramJSONObject2.optLong("serverProcessTime");
        long l6 = paramJSONObject1.optLong("ssoRet", 0L);
        paramJSONObject1 = new HashMap();
        paramJSONObject1.put("param_FailCode", String.valueOf(l6));
        paramJSONObject1.put("totalTime", l1 + "");
        paramJSONObject1.put("packTime", l2 + "");
        paramJSONObject1.put("SSONetworkTime", l3 + "");
        paramJSONObject1.put("unpackTime", l4 + "");
        paramJSONObject1.put("serverProcessTime", l5 + "");
        paramJSONObject1.put("cmd", paramString1);
        paramString1 = paramAppInterface.getCurrentAccountUin();
        paramAppInterface = StatisticCollector.getInstance(paramAppInterface.getApplicationContext());
        if (0L != l6) {
          break label299;
        }
        bool = true;
        paramAppInterface.collectPerformance(paramString1, paramString2, bool, l1, 0L, paramJSONObject1, "", false);
        return;
      }
      catch (Throwable paramAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SSOWebviewPlugin", 2, "report ssoWebView:  " + paramAppInterface);
      return;
      label299:
      boolean bool = false;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SSOWebviewPlugin_apollo_store_stability_", 2, "reportSSOTimeout. cmd=" + paramString);
    }
    ApolloStoreStabilityReportManager localApolloStoreStabilityReportManager = ApolloStoreStabilityReportManager.a();
    if (localApolloStoreStabilityReportManager.a(paramString)) {
      localApolloStoreStabilityReportManager.a(paramString, null, -1001, paramInt);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SSOWebviewPlugin_apollo_store_stability_", 2, "reportSSOTimeout. cmd is not in white list");
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SSOWebviewPlugin_apollo_store_stability_", 2, "reportSSORetCodeNonZero. cmd=" + paramString + " ssoErrorCode=" + paramLong);
    }
    ApolloStoreStabilityReportManager localApolloStoreStabilityReportManager = ApolloStoreStabilityReportManager.a();
    if (localApolloStoreStabilityReportManager.a(paramString)) {
      localApolloStoreStabilityReportManager.a(paramString, null, -1002, paramInt);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SSOWebviewPlugin_apollo_store_stability_", 2, "reportSSORetCodeNonZero. cmd is not in white list");
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    paramJSONObject.remove("callback");
    paramJSONObject.remove("cmd");
    paramJSONObject.remove("needCookie");
    paramJSONObject.remove("timeout");
  }
  
  private void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SSOWebviewPlugin_apollo_store_stability_", 2, "reportSSOSuccessCost. cmd=" + paramString + " ssoCost=" + paramInt);
    }
    ApolloStoreStabilityReportManager localApolloStoreStabilityReportManager = ApolloStoreStabilityReportManager.a();
    if (localApolloStoreStabilityReportManager.a(paramString)) {
      localApolloStoreStabilityReportManager.a(paramString, null, 1000, paramInt);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SSOWebviewPlugin_apollo_store_stability_", 2, "reportSSORetCodeNonZero. cmd is not in white list");
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    while (this.mRuntime == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SSOWebviewPlugin", 2, "uniAgent, jsonStr=" + paramString1 + ", url=" + paramString2);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString1);
        String str1 = localJSONObject.getString("cmd");
        paramString2 = localJSONObject.getString("callback");
        if (localJSONObject.has("timeout"))
        {
          l1 = localJSONObject.getLong("timeout");
          if (QLog.isColorLevel()) {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, cmd=" + str1 + ", callbackId=" + paramString2 + ",timeout = " + l1);
          }
          if (TextUtils.isEmpty(paramString2))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: no callbackId");
            return;
          }
          if (TextUtils.isEmpty(str1))
          {
            paramString1 = new JSONObject();
            paramString1.put("ssoRet", 255);
            paramString1.put("businessRet", 0);
            paramString1.put("msg", HardCodeUtil.a(2131714217));
            super.callJs(paramString2, new String[] { paramString1.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: no cmd");
            return;
          }
          if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
          {
            paramString1 = new JSONObject();
            paramString1.put("ssoRet", 103);
            paramString1.put("businessRet", 0);
            paramString1.put("msg", "MSF未连接");
            super.callJs(paramString2, new String[] { paramString1.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: network unavailable");
            return;
          }
          long l2 = 10240L;
          if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(str1)) {
            l2 = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(str1)).longValue();
          }
          if (l2 > 0L)
          {
            long l3 = localJSONObject.toString().getBytes().length;
            if (l3 > l2)
            {
              paramString1 = new JSONObject();
              paramString1.put("ssoRet", 101);
              paramString1.put("businessRet", 0);
              paramString1.put("msg", HardCodeUtil.a(2131714225));
              super.callJs(paramString2, new String[] { paramString1.toString() });
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: pkg size exceeded, dataLength=" + l3 + ", maxPkgSize=" + l2);
              return;
            }
          }
          l2 = System.currentTimeMillis() / 1000L;
          if (this.d.containsKey(str1))
          {
            localObject = (Pair)this.d.get(str1);
            if (!this.e.containsKey(str1)) {
              break label1359;
            }
            i = ((Integer)this.e.get(str1)).intValue();
            if (((Long)((Pair)localObject).first).longValue() != l2)
            {
              this.d.put(str1, new Pair(Long.valueOf(l2), Integer.valueOf(0)));
              if (localJSONObject.has("needCookie"))
              {
                i = localJSONObject.getInt("needCookie");
                if (QLog.isColorLevel()) {
                  QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, needCookie=" + i);
                }
                if (i == 1)
                {
                  localObject = this.mRuntime.a();
                  if (localObject != null)
                  {
                    localObject = ((CustomWebView)localObject).getUrl();
                    if (!TextUtils.isEmpty((CharSequence)localObject))
                    {
                      if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
                      {
                        this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
                        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
                      }
                      String str2 = this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie((String)localObject);
                      if (!TextUtils.isEmpty(str2))
                      {
                        if (str2.indexOf(',') != -1) {
                          str2.replace(',', ';');
                        }
                        localJSONObject.put("Cookie", str2);
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("SSOWebviewPlugin", 2, "Get cookie:" + Util.c(str2, new String[0]) + " from " + Util.b((String)localObject, new String[0]));
                      }
                    }
                  }
                }
              }
              if ((this.mRuntime.a() == null) || (!((IApolloWebDataHandler)QRoute.api(IApolloWebDataHandler.class)).doInterceptApolloCmd(this.mRuntime.a().getUrl(), paramString1, this.mRuntime.a(), this))) {
                continue;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SSOWebviewPlugin", 2, "apollo_client_ApolloWebDataHandler uniAgent, req, cmd=" + str1 + " doInterceptApolloCmd:true");
              return;
            }
            if (((Integer)((Pair)localObject).second).intValue() + 1 <= i)
            {
              this.d.put(str1, new Pair(Long.valueOf(l2), Integer.valueOf(((Integer)((Pair)localObject).second).intValue() + 1)));
              continue;
            }
            paramString1 = new JSONObject();
            paramString1.put("ssoRet", 102);
            paramString1.put("businessRet", 0);
            paramString1.put("msg", HardCodeUtil.a(2131714214));
            super.callJs(paramString2, new String[] { paramString1.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: requests too frequently, cmd: " + str1 + ", freq: " + i);
            return;
          }
          this.d.put(str1, new Pair(Long.valueOf(l2), Integer.valueOf(0)));
          continue;
          Object localObject = new WebSSOAgent.UniSsoServerReqComm();
          ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
          ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
          ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5");
          paramString1 = new WebSSOAgent.UniSsoServerReq();
          paramString1.comm.set((MessageMicro)localObject);
          a(localJSONObject);
          localJSONObject.put("option", a());
          paramString1.reqdata.set(localJSONObject.toString());
          localObject = new NewIntent(this.mRuntime.a().getApplicationContext(), WebSSOAgentServlet.class);
          ((NewIntent)localObject).putExtra("extra_cmd", str1);
          ((NewIntent)localObject).putExtra("extra_data", paramString1.toByteArray());
          ((NewIntent)localObject).putExtra("extra_callbackid", paramString2);
          ((NewIntent)localObject).putExtra("extra_timeout", l1);
          if (QLog.isColorLevel()) {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, cmd=" + str1 + ", reqData=" + localJSONObject.toString());
          }
          ((NewIntent)localObject).setObserver(new SSOWebviewPlugin.2(this, System.currentTimeMillis(), str1));
          if (QLog.isColorLevel()) {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, send request to msf");
          }
          this.mRuntime.a().startServlet((NewIntent)localObject);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        return;
        long l1 = -1L;
        continue;
      }
      catch (NullPointerException paramString1)
      {
        return;
      }
      label1359:
      int i = 10;
    }
  }
  
  private void c(String paramString1, String paramString2) {}
  
  protected void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    String[] arrayOfString;
    String str2;
    String str3;
    String str1;
    do
    {
      return;
      try
      {
        arrayOfString = Uri.parse(paramString2).getHost().split("\\.");
        paramString1 = new JSONObject(paramString1);
        str2 = paramString1.getString("data");
        str3 = paramString1.getString("cmd");
        c(str3, str2);
        str1 = paramString1.getString("callback");
        if (this.jdField_a_of_type_Long == 0L) {
          break label203;
        }
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= this.jdField_a_of_type_Int * 1000) {
          break;
        }
        paramString1 = new JSONObject();
        paramString1.put("cret", 1);
        callJs(str1, new String[] { paramString1.toString() });
        return;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.d("SSOWebviewPlugin", 2, "send request error!");
    return;
    if (str2.getBytes().length > this.jdField_b_of_type_Int)
    {
      paramString1 = new JSONObject();
      paramString1.put("cret", 2);
      callJs(str1, new String[] { paramString1.toString() });
      return;
      label203:
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    int i = arrayOfString.length;
    paramString1 = "";
    i -= 1;
    for (;;)
    {
      if (i >= 0)
      {
        paramString2 = paramString1 + arrayOfString[i];
        paramString1 = paramString2;
        if (i != 0) {
          paramString1 = paramString2 + "_";
        }
      }
      else
      {
        paramString2 = new NewIntent(this.mRuntime.a().getApplicationContext(), ProtoServlet.class);
        paramString2.putExtra("cmd", "MQUpdateSvc_" + paramString1 + ".web." + str3);
        paramString1 = new WebSsoBody.WebSsoRequestBody();
        paramString1.type.set(0);
        paramString1.data.set(str2);
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(new SSOWebviewPlugin.3(this, str1, str3));
        this.mRuntime.a().startServlet(paramString2);
        return;
      }
      i -= 1;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = true;
    if (!"sso".equals(paramString2)) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (!"sendRequest".equals(paramString3)) {
            break;
          }
        } while (paramVarArgs.length <= 0);
        a(paramVarArgs[0], this.mRuntime.a().getUrl());
        return true;
        if (!"uniAgent".equals(paramString3)) {
          break;
        }
      } while (paramVarArgs.length <= 0);
      WebSSOAgentServlet.jdField_a_of_type_Long = System.currentTimeMillis();
      b(paramVarArgs[0], paramString1);
      return true;
    } while ((!"PublicFollow".equals(paramString3)) || (paramVarArgs.length <= 0));
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        if (paramString1.optInt("follow") == 1)
        {
          paramJsBridgeListener = paramString1.optString("uin");
          paramString1 = paramString1.getString("callback");
          if (QLog.isColorLevel()) {
            QLog.d("SSOWebviewPlugin", 2, "sso.PublicFollow isFollow: " + bool + "  uin: " + paramJsBridgeListener);
          }
          paramString2 = new Bundle();
          paramString2.putBoolean("isFollow", bool);
          paramString2.putString("uin", paramJsBridgeListener);
          paramString2.putString("callback", paramString1);
          paramJsBridgeListener = DataFactory.a("ipc_cmd_certified_account_web_plugin_follow", null, this.jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver.key, paramString2);
          WebIPCOperator.a().a(paramJsBridgeListener);
          return false;
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("SSOWebviewPlugin", 2, "sso.PublicFollow failed! " + QLog.getStackTraceString(paramJsBridgeListener));
        return false;
      }
      bool = false;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    WebIPCOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_a_of_type_ComTencentSmttSdkCookieManager = null;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (this.jdField_b_of_type_JavaUtilHashMap != null)
    {
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      this.jdField_b_of_type_JavaUtilHashMap = null;
    }
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
    }
    if (this.d != null) {
      this.d.clear();
    }
    if (this.e != null) {
      this.e.clear();
    }
    WebIPCOperator.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.SSOWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */