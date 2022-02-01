package com.tencent.hippy.qq.module;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.SSOWebviewPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRspComm;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

@HippyNativeModule(name="QQDataModule")
public class QQDataModule
  extends QQBaseModule
{
  static final String CLASSNAME = "QQDataModule";
  private static final String QQGAMECENTER_DOMAIN = "gamecenter.qq.com";
  
  public QQDataModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="getCurrentJsBundleVersion")
  public void getCurrentJsBundleVersion(Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    HippyQQEngine localHippyQQEngine = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
    if (localHippyQQEngine == null) {}
    for (int i = 0;; i = localHippyQQEngine.getModuleVersion())
    {
      paramPromise.resolve(Integer.valueOf(i));
      return;
    }
  }
  
  protected void onUniAgent(String paramString, boolean paramBoolean, Bundle paramBundle, Promise paramPromise)
  {
    if ((paramPromise == null) || (paramBundle == null)) {
      return;
    }
    if (!paramBoolean)
    {
      int i = paramBundle.getInt("extra_result_code");
      if (i == 1001)
      {
        uniAgentCallBack(paramPromise, 201, 0, HardCodeUtil.a(2131714215));
        return;
      }
      if ((i == 1002) || (i == 1013))
      {
        uniAgentCallBack(paramPromise, 202, 0, HardCodeUtil.a(2131714221));
        return;
      }
      uniAgentCallBack(paramPromise, 255, 0, HardCodeUtil.a(2131714220));
      return;
    }
    try
    {
      paramBundle = paramBundle.getByteArray("extra_data");
      if (paramBundle == null)
      {
        uniAgentCallBack(paramPromise, 255, 0, "SSO返回数据包为空");
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("QQDataModule", 1, "onUniAgent, onReceive, Exception: " + paramString);
      uniAgentCallBack(paramPromise, 255, 0, "parse error");
      return;
    }
    Object localObject = new WebSSOAgent.UniSsoServerRsp();
    ((WebSSOAgent.UniSsoServerRsp)localObject).mergeFrom(paramBundle);
    long l1;
    if ((((WebSSOAgent.UniSsoServerRsp)localObject).comm.has()) && (((WebSSOAgent.UniSsoServerRsp)localObject).comm.proctime.has()))
    {
      l1 = ((WebSSOAgent.UniSsoServerRsp)localObject).comm.proctime.get();
      if (!((WebSSOAgent.UniSsoServerRsp)localObject).ret.has()) {
        break label428;
      }
    }
    label414:
    label428:
    for (long l2 = ((WebSSOAgent.UniSsoServerRsp)localObject).ret.get();; l2 = 0L)
    {
      if (((WebSSOAgent.UniSsoServerRsp)localObject).errmsg.has())
      {
        paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject).errmsg.get();
        if (!((WebSSOAgent.UniSsoServerRsp)localObject).rspdata.has()) {
          break label414;
        }
      }
      for (localObject = ((WebSSOAgent.UniSsoServerRsp)localObject).rspdata.get();; localObject = null)
      {
        JSONObject localJSONObject1 = SSOWebviewPlugin.a(l1);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("businessRet", l2);
        localJSONObject2.put("msg", paramBundle);
        localJSONObject2.put("data", localObject);
        localJSONObject2.put("ssoRet", 0);
        localJSONObject2.put("speedPoint", localJSONObject1);
        paramBundle = localJSONObject2.toString();
        if (QLog.isColorLevel()) {
          QLog.d("QQDataModule", 2, "uniAgent callback svrCostTime:" + l1 + ", Json string=" + paramBundle);
        }
        paramPromise.resolve(paramBundle);
        SSOWebviewPlugin.a(getAppInterface(), paramString, "ssoHippy", localJSONObject2, localJSONObject1);
        return;
        paramBundle = "SSO发送成功";
        break;
      }
      l1 = -1L;
      break;
    }
  }
  
  protected void sendUniAgentRequest(AppInterface paramAppInterface, String paramString1, long paramLong, String paramString2, BusinessObserver paramBusinessObserver)
  {
    Object localObject = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5");
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
    localUniSsoServerReq.comm.set((MessageMicro)localObject);
    localUniSsoServerReq.reqdata.set(paramString2);
    localObject = new NewIntent(paramAppInterface.getApplicationContext(), WebSSOAgentServlet.class);
    ((NewIntent)localObject).putExtra("extra_cmd", paramString1);
    ((NewIntent)localObject).putExtra("extra_data", localUniSsoServerReq.toByteArray());
    ((NewIntent)localObject).putExtra("extra_callbackid", "0");
    ((NewIntent)localObject).putExtra("extra_timeout", paramLong);
    ((NewIntent)localObject).setObserver(paramBusinessObserver);
    if (QLog.isColorLevel()) {
      QLog.d("QQDataModule", 2, "uniAgent, req, cmd=" + paramString1 + ", reqData=" + paramString2);
    }
    paramAppInterface.startServlet((NewIntent)localObject);
  }
  
  @HippyMethod(name="uniAgent")
  public void uniAgent(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap == null) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = getAppInterface();
    } while (localAppInterface == null);
    String str;
    long l;
    for (;;)
    {
      try
      {
        str = paramHippyMap.getString("cmd");
        if (paramHippyMap.containsKey("timeout"))
        {
          l = paramHippyMap.getLong("timeout");
          if (QLog.isColorLevel()) {
            QLog.d("QQDataModule", 2, "uniAgent, req, cmd=" + str + ",timeout = " + l);
          }
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          uniAgentCallBack(paramPromise, 255, 0, HardCodeUtil.a(2131714217));
          return;
        }
      }
      catch (Throwable paramHippyMap)
      {
        QLog.d("QQDataModule", 2, "uniAgent e:" + paramHippyMap);
        return;
      }
      l = -1L;
    }
    if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
    {
      uniAgentCallBack(paramPromise, 103, 0, "MSF未连接");
      return;
    }
    paramHippyMap = paramHippyMap.toJSONObject();
    SSOWebviewPlugin.a(paramHippyMap);
    paramHippyMap.put("option", SSOWebviewPlugin.a());
    paramPromise = new QQDataModule.1(this, str, paramPromise);
    sendUniAgentRequest(localAppInterface, str, l, paramHippyMap.toString(), paramPromise);
  }
  
  protected void uniAgentCallBack(Promise paramPromise, int paramInt1, int paramInt2, String paramString)
  {
    if (paramPromise == null) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ssoRet", paramInt1);
        localJSONObject.put("businessRet", paramInt2);
        localJSONObject.put("msg", paramString);
        paramPromise.resolve(localJSONObject.toString());
        if (QLog.isColorLevel())
        {
          QLog.d("QQDataModule", 2, "uniAgentCallBack ssoRet:" + paramInt1 + " businessRet:" + paramInt2 + " msg:" + paramString);
          return;
        }
      }
      catch (Throwable paramPromise)
      {
        QLog.e("QQDataModule", 1, "uniAgentCallBack e:" + paramPromise);
      }
    }
  }
  
  @HippyMethod(name="userInfo")
  public void userInfo(Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    Object localObject2 = getAppInterface();
    Object localObject1 = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
    if ((localObject2 != null) && (((AppInterface)localObject2).isLogin()) && (localObject1 != null) && (((HippyQQEngine)localObject1).getModuleName() != null) && (((HippyQQEngine)localObject1).getModuleName().startsWith("QQGameCenter")))
    {
      localObject1 = ((AppInterface)localObject2).getCurrentAccountUin();
      String str1 = ((AppInterface)localObject2).getCurrentNickname();
      Object localObject3 = (TicketManager)((AppInterface)localObject2).getManager(2);
      String str2 = ((TicketManager)localObject3).getSkey((String)localObject1);
      localObject3 = ((TicketManager)localObject3).getPskey((String)localObject1, "gamecenter.qq.com");
      localObject2 = SwiftBrowserCookieMonster.b((AppRuntime)localObject2, "gamecenter.qq.com");
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("uin", localObject1);
        localJSONObject.put("nick", str1);
        localJSONObject.put("skey", str2);
        localJSONObject.put("p_skey", localObject3);
        localJSONObject.put("pt4_token", localObject2);
        paramPromise.resolve(localJSONObject.toString());
        return;
      }
      catch (Throwable localThrowable) {}
    }
    paramPromise.resolve("{}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQDataModule
 * JD-Core Version:    0.7.0.1
 */