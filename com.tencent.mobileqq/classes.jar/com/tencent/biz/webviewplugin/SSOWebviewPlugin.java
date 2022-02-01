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
import com.tencent.mobileqq.apollo.handler.api.IApolloWebDataHandler;
import com.tencent.mobileqq.apollo.store.api.IApolloStoreReportHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
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
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  protected Activity a;
  private OnRemoteRespObserver jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver = new SSOWebviewPlugin.1(this);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRomData e:");
      localStringBuilder.append(localThrowable);
      QLog.e("SSOWebviewPlugin", 1, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("uniAgent, total=");
        localStringBuilder1.append(l1);
        localStringBuilder1.append(",pre=");
        localStringBuilder1.append(l2);
        localStringBuilder1.append(",msf=");
        localStringBuilder1.append(l3);
        localStringBuilder1.append(",after=");
        localStringBuilder1.append(l4);
        QLog.d("SSOWebviewPlugin", 2, localStringBuilder1.toString());
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
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("generateAgentCostData e:");
      localStringBuilder2.append(localThrowable);
      QLog.e("SSOWebviewPlugin", 1, localStringBuilder2.toString());
    }
    return localJSONObject;
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramAppInterface != null) {
      if (paramJSONObject2 == null) {
        return;
      }
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
        paramJSONObject2 = new StringBuilder();
        paramJSONObject2.append(l1);
        paramJSONObject2.append("");
        paramJSONObject1.put("totalTime", paramJSONObject2.toString());
        paramJSONObject2 = new StringBuilder();
        paramJSONObject2.append(l2);
        paramJSONObject2.append("");
        paramJSONObject1.put("packTime", paramJSONObject2.toString());
        paramJSONObject2 = new StringBuilder();
        paramJSONObject2.append(l3);
        paramJSONObject2.append("");
        paramJSONObject1.put("SSONetworkTime", paramJSONObject2.toString());
        paramJSONObject2 = new StringBuilder();
        paramJSONObject2.append(l4);
        paramJSONObject2.append("");
        paramJSONObject1.put("unpackTime", paramJSONObject2.toString());
        paramJSONObject2 = new StringBuilder();
        paramJSONObject2.append(l5);
        paramJSONObject2.append("");
        paramJSONObject1.put("serverProcessTime", paramJSONObject2.toString());
        paramJSONObject1.put("cmd", paramString1);
        paramString1 = paramAppInterface.getCurrentAccountUin();
        paramAppInterface = StatisticCollector.getInstance(paramAppInterface.getApplicationContext());
        if (0L != l6) {
          break label358;
        }
        bool = true;
        paramAppInterface.collectPerformance(paramString1, paramString2, bool, l1, 0L, paramJSONObject1, "", false);
        return;
      }
      catch (Throwable paramAppInterface)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("report ssoWebView:  ");
          paramString1.append(paramAppInterface);
          QLog.e("SSOWebviewPlugin", 2, paramString1.toString());
        }
      }
      return;
      label358:
      boolean bool = false;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    ((IApolloStoreReportHelper)QRoute.api(IApolloStoreReportHelper.class)).reportSSOTimeout(paramString, paramInt);
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    ((IApolloStoreReportHelper)QRoute.api(IApolloStoreReportHelper.class)).reportSSORetCodeNonZero(paramString, paramLong, paramInt);
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
    ((IApolloStoreReportHelper)QRoute.api(IApolloStoreReportHelper.class)).reportSSOSuccessCost(paramString, paramInt);
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (this.mRuntime == null) {
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uniAgent, jsonStr=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", url=");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("SSOWebviewPlugin", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString1);
        paramString2 = localJSONObject.getString("cmd");
        localObject1 = localJSONObject.getString("callback");
        if (localJSONObject.has("timeout"))
        {
          l1 = localJSONObject.getLong("timeout");
          boolean bool = QLog.isColorLevel();
          Object localObject2;
          if (bool)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("uniAgent, req, cmd=");
            ((StringBuilder)localObject2).append(paramString2);
            ((StringBuilder)localObject2).append(", callbackId=");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(",timeout = ");
            ((StringBuilder)localObject2).append(l1);
            QLog.d("SSOWebviewPlugin", 2, ((StringBuilder)localObject2).toString());
          }
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (!QLog.isColorLevel()) {
              break label1465;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: no callbackId");
            return;
          }
          bool = TextUtils.isEmpty(paramString2);
          if (bool)
          {
            paramString1 = new JSONObject();
            paramString1.put("ssoRet", 255);
            paramString1.put("businessRet", 0);
            paramString1.put("msg", HardCodeUtil.a(2131714146));
            super.callJs((String)localObject1, new String[] { paramString1.toString() });
            if (!QLog.isColorLevel()) {
              break label1466;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: no cmd");
            return;
          }
          if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication()))
          {
            paramString1 = new JSONObject();
            paramString1.put("ssoRet", 103);
            paramString1.put("businessRet", 0);
            paramString1.put("msg", "MSF未连接");
            super.callJs((String)localObject1, new String[] { paramString1.toString() });
            if (!QLog.isColorLevel()) {
              break label1467;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: network unavailable");
            return;
          }
          long l2 = 10240L;
          if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString2)) {
            l2 = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString2)).longValue();
          }
          if (l2 <= 0L) {
            break label1469;
          }
          long l3 = localJSONObject.toString().getBytes().length;
          if (l3 > l2)
          {
            paramString1 = new JSONObject();
            paramString1.put("ssoRet", 101);
            paramString1.put("businessRet", 0);
            paramString1.put("msg", HardCodeUtil.a(2131714154));
            super.callJs((String)localObject1, new String[] { paramString1.toString() });
            if (!QLog.isColorLevel()) {
              break label1468;
            }
            paramString1 = new StringBuilder();
            paramString1.append("uniAgent, req aborted, reason: pkg size exceeded, dataLength=");
            paramString1.append(l3);
            paramString1.append(", maxPkgSize=");
            paramString1.append(l2);
            QLog.d("SSOWebviewPlugin", 2, paramString1.toString());
            return;
          }
          l2 = System.currentTimeMillis() / 1000L;
          if (this.d.containsKey(paramString2))
          {
            localObject2 = (Pair)this.d.get(paramString2);
            if (!this.e.containsKey(paramString2)) {
              break label1472;
            }
            i = ((Integer)this.e.get(paramString2)).intValue();
            if (((Long)((Pair)localObject2).first).longValue() != l2)
            {
              this.d.put(paramString2, new Pair(Long.valueOf(l2), Integer.valueOf(0)));
            }
            else if (((Integer)((Pair)localObject2).second).intValue() + 1 <= i)
            {
              this.d.put(paramString2, new Pair(Long.valueOf(l2), Integer.valueOf(((Integer)((Pair)localObject2).second).intValue() + 1)));
            }
            else
            {
              paramString1 = new JSONObject();
              paramString1.put("ssoRet", 102);
              paramString1.put("businessRet", 0);
              paramString1.put("msg", HardCodeUtil.a(2131714143));
              super.callJs((String)localObject1, new String[] { paramString1.toString() });
              if (!QLog.isColorLevel()) {
                break;
              }
              paramString1 = new StringBuilder();
              paramString1.append("uniAgent, req aborted, reason: requests too frequently, cmd: ");
              paramString1.append(paramString2);
              paramString1.append(", freq: ");
              paramString1.append(i);
              QLog.d("SSOWebviewPlugin", 2, paramString1.toString());
            }
          }
          else
          {
            this.d.put(paramString2, new Pair(Long.valueOf(l2), Integer.valueOf(0)));
          }
          if (localJSONObject.has("needCookie"))
          {
            i = localJSONObject.getInt("needCookie");
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("uniAgent, req, needCookie=");
              ((StringBuilder)localObject2).append(i);
              QLog.d("SSOWebviewPlugin", 2, ((StringBuilder)localObject2).toString());
            }
            if (i == 1)
            {
              localObject2 = this.mRuntime.a();
              if (localObject2 != null)
              {
                localObject2 = ((CustomWebView)localObject2).getUrl();
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
                  {
                    this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
                    this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
                  }
                  String str = this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie((String)localObject2);
                  if (!TextUtils.isEmpty(str))
                  {
                    if (str.indexOf(',') != -1) {
                      str.replace(',', ';');
                    }
                    localJSONObject.put("Cookie", str);
                  }
                  if (QLog.isColorLevel())
                  {
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append("Get cookie:");
                    localStringBuilder.append(Util.c(str, new String[0]));
                    localStringBuilder.append(" from ");
                    localStringBuilder.append(Util.b((String)localObject2, new String[0]));
                    QLog.d("SSOWebviewPlugin", 2, localStringBuilder.toString());
                  }
                }
              }
            }
          }
          if ((this.mRuntime.a() != null) && (((IApolloWebDataHandler)QRoute.api(IApolloWebDataHandler.class)).doInterceptApolloCmd(this.mRuntime.a().getUrl(), paramString1, this.mRuntime.a(), this)))
          {
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder();
              paramString1.append("apollo_client_ApolloWebDataHandler uniAgent, req, cmd=");
              paramString1.append(paramString2);
              paramString1.append(" doInterceptApolloCmd:true");
              QLog.d("SSOWebviewPlugin", 2, paramString1.toString());
            }
          }
          else
          {
            localObject2 = new WebSSOAgent.UniSsoServerReqComm();
            ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
            ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
            ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.7.0");
            paramString1 = new WebSSOAgent.UniSsoServerReq();
            paramString1.comm.set((MessageMicro)localObject2);
            a(localJSONObject);
            localJSONObject.put("option", a());
            paramString1.reqdata.set(localJSONObject.toString());
            localObject2 = new NewIntent(this.mRuntime.a().getApplicationContext(), WebSSOAgentServlet.class);
            ((NewIntent)localObject2).putExtra("extra_cmd", paramString2);
            ((NewIntent)localObject2).putExtra("extra_data", paramString1.toByteArray());
            ((NewIntent)localObject2).putExtra("extra_callbackid", (String)localObject1);
            ((NewIntent)localObject2).putExtra("extra_timeout", l1);
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder();
              paramString1.append("uniAgent, req, cmd=");
              paramString1.append(paramString2);
              paramString1.append(", reqData=");
              paramString1.append(localJSONObject.toString());
              QLog.d("SSOWebviewPlugin", 2, paramString1.toString());
            }
            ((NewIntent)localObject2).setObserver(new SSOWebviewPlugin.2(this, System.currentTimeMillis(), paramString2));
            if (QLog.isColorLevel()) {
              QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, send request to msf");
            }
            this.mRuntime.a().startServlet((NewIntent)localObject2);
          }
          return;
        }
      }
      catch (JSONException|NullPointerException paramString1)
      {
        return;
      }
      long l1 = -1L;
      continue;
      label1465:
      return;
      label1466:
      return;
      label1467:
      return;
      label1468:
      return;
      label1469:
      continue;
      label1472:
      int i = 10;
    }
  }
  
  private void c(String paramString1, String paramString2) {}
  
  protected void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramString2 = Uri.parse(paramString2).getHost().split("\\.");
        paramString1 = new JSONObject(paramString1);
        String str2 = paramString1.getString("data");
        String str3 = paramString1.getString("cmd");
        c(str3, str2);
        String str1 = paramString1.getString("callback");
        if (this.jdField_a_of_type_Long != 0L)
        {
          long l1 = System.currentTimeMillis();
          long l2 = this.jdField_a_of_type_Long;
          l1 -= l2;
          if ((l1 >= 0L) && (l1 < this.jdField_a_of_type_Int * 1000))
          {
            paramString1 = new JSONObject();
            paramString1.put("cret", 1);
            callJs(str1, new String[] { paramString1.toString() });
            if (!QLog.isColorLevel()) {
              break label516;
            }
            QLog.d("SSOWebviewPlugin", 2, new Object[] { "limit frequency duration: ", Long.valueOf(l1), " minDuration:", Integer.valueOf(this.jdField_a_of_type_Int), " preTime:", Long.valueOf(this.jdField_a_of_type_Long) });
            return;
          }
          if (str2.getBytes().length > this.jdField_b_of_type_Int)
          {
            paramString1 = new JSONObject();
            paramString1.put("cret", 2);
            callJs(str1, new String[] { paramString1.toString() });
          }
        }
        else
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        paramString1 = "";
        i = paramString2.length - 1;
        if (i >= 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(paramString2[i]);
          localObject = ((StringBuilder)localObject).toString();
          paramString1 = (String)localObject;
          if (i == 0) {
            break label517;
          }
          paramString1 = new StringBuilder();
          paramString1.append((String)localObject);
          paramString1.append("_");
          paramString1 = paramString1.toString();
          break label517;
        }
        paramString2 = new NewIntent(this.mRuntime.a().getApplicationContext(), ProtoServlet.class);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MQUpdateSvc_");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(".web.");
        ((StringBuilder)localObject).append(str3);
        paramString2.putExtra("cmd", ((StringBuilder)localObject).toString());
        paramString1 = new WebSsoBody.WebSsoRequestBody();
        paramString1.type.set(0);
        paramString1.data.set(str2);
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(new SSOWebviewPlugin.3(this, str1, str3));
        this.mRuntime.a().startServlet(paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SSOWebviewPlugin", 2, "send request error!");
      }
      return;
      label516:
      return;
      label517:
      i -= 1;
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"sso".equals(paramString2)) {
      return false;
    }
    boolean bool2 = "sendRequest".equals(paramString3);
    boolean bool1 = true;
    if (bool2)
    {
      if (paramVarArgs.length > 0)
      {
        a(paramVarArgs[0], this.mRuntime.a().getUrl());
        return true;
      }
    }
    else if ("uniAgent".equals(paramString3))
    {
      if (paramVarArgs.length > 0)
      {
        WebSSOAgentServlet.jdField_a_of_type_Long = System.currentTimeMillis();
        b(paramVarArgs[0], paramString1);
        return true;
      }
    }
    else if ((!"PublicFollow".equals(paramString3)) || (paramVarArgs.length <= 0)) {}
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        if (paramString1.optInt("follow") != 1) {
          break label305;
        }
        paramJsBridgeListener = paramString1.optString("uin");
        paramString1 = paramString1.getString("callback");
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("sso.PublicFollow isFollow: ");
          paramString2.append(bool1);
          paramString2.append("  uin: ");
          paramString2.append(paramJsBridgeListener);
          QLog.d("SSOWebviewPlugin", 2, paramString2.toString());
        }
        paramString2 = new Bundle();
        paramString2.putBoolean("isFollow", bool1);
        paramString2.putString("uin", paramJsBridgeListener);
        paramString2.putString("callback", paramString1);
        paramJsBridgeListener = DataFactory.a("ipc_cmd_certified_account_web_plugin_follow", null, this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver.key, paramString2);
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramJsBridgeListener);
        return false;
      }
      catch (Throwable paramJsBridgeListener)
      {
        paramString1 = new StringBuilder();
        paramString1.append("sso.PublicFollow failed! ");
        paramString1.append(QLog.getStackTraceString(paramJsBridgeListener));
        QLog.e("SSOWebviewPlugin", 2, paramString1.toString());
      }
      return false;
      label305:
      bool1 = false;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver);
  }
  
  protected void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_MqqAppNewIntent;
    if (localObject != null) {
      ((NewIntent)localObject).setObserver(null);
    }
    this.jdField_a_of_type_ComTencentSmttSdkCookieManager = null;
    localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    localObject = this.jdField_b_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.jdField_b_of_type_JavaUtilHashMap = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.c = null;
    }
    localObject = this.d;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    localObject = this.e;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.SSOWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */