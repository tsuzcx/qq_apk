package com.tencent.hippy.qq.module;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.webviewplugin.SSOWebviewPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
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
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import oicq.wlogin_sdk.request.Ticket;
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
  
  public static String getPskeyFromTicket(Ticket paramTicket, String paramString)
  {
    if ((paramTicket != null) && (paramTicket._pskey_map != null) && (paramTicket._pskey_map.get(paramString) != null)) {
      return new String((byte[])paramTicket._pskey_map.get(paramString));
    }
    QLog.i("QQDataModule", 2, "getPskey error from ticket");
    return "";
  }
  
  @HippyMethod(name="getCurrentJsBundleVersion")
  public void getCurrentJsBundleVersion(Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    HippyQQEngine localHippyQQEngine = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
    int i;
    if (localHippyQQEngine == null) {
      i = 0;
    } else {
      i = localHippyQQEngine.getModuleVersion();
    }
    paramPromise.resolve(Integer.valueOf(i));
  }
  
  public String getDomain()
  {
    Object localObject1;
    if ((getFragment() != null) && (getFragment().getArguments() != null)) {
      localObject1 = getFragment().getArguments().getBundle("params");
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      localObject1 = ((Bundle)localObject1).getString("domain");
    } else {
      localObject1 = null;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).checkDomainPermission((String)localObject1)) {
        return localObject1;
      }
      return null;
    }
    HippyQQEngine localHippyQQEngine = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
    Object localObject2 = localObject1;
    if (localHippyQQEngine != null)
    {
      localObject2 = localObject1;
      if (localHippyQQEngine.getModuleName() != null)
      {
        localObject2 = localObject1;
        if (localHippyQQEngine.getModuleName().startsWith("QQGameCenter")) {
          localObject2 = "gamecenter.qq.com";
        }
      }
    }
    return localObject2;
  }
  
  @HippyMethod(name="getPskey")
  public void getPskey(Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    String str = getDomain();
    Object localObject2 = getAppInterface();
    if ((localObject2 != null) && (((AppInterface)localObject2).isLogin()) && (!TextUtils.isEmpty(str))) {
      try
      {
        localObject1 = ((AppInterface)localObject2).getCurrentAccountUin();
        localObject2 = (TicketManager)((AppInterface)localObject2).getManager(2);
        QQDataModule.1 local1 = new QQDataModule.1(this, str, paramPromise);
        localObject1 = ((TicketManager)localObject2).getPskey((String)localObject1, 16L, new String[] { str }, local1);
        if (localObject1 != null)
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("p_skey", getPskeyFromTicket((Ticket)localObject1, str));
          paramPromise.resolve(((JSONObject)localObject2).toString());
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("asyncTicket error:");
        ((StringBuilder)localObject1).append(localThrowable);
        QLog.e("QQDataModule", 1, ((StringBuilder)localObject1).toString());
      }
    }
    paramPromise.resolve("{}");
  }
  
  protected void onUniAgent(String paramString, boolean paramBoolean, Bundle paramBundle, Promise paramPromise)
  {
    if (paramPromise != null)
    {
      if (paramBundle == null) {
        return;
      }
      if (!paramBoolean)
      {
        int i = paramBundle.getInt("extra_result_code");
        if (i == 1001)
        {
          uniAgentCallBack(paramPromise, 201, 0, HardCodeUtil.a(2131911672));
          return;
        }
        if ((i != 1002) && (i != 1013))
        {
          uniAgentCallBack(paramPromise, 255, 0, HardCodeUtil.a(2131911677));
          return;
        }
        uniAgentCallBack(paramPromise, 202, 0, HardCodeUtil.a(2131911678));
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("extra_data");
        if (paramBundle == null)
        {
          uniAgentCallBack(paramPromise, 255, 0, "SSO返回数据包为空");
          return;
        }
        localObject = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject).mergeFrom(paramBundle);
        if ((!((WebSSOAgent.UniSsoServerRsp)localObject).comm.has()) || (!((WebSSOAgent.UniSsoServerRsp)localObject).comm.proctime.has())) {
          break label455;
        }
        l1 = ((WebSSOAgent.UniSsoServerRsp)localObject).comm.proctime.get();
        if (!((WebSSOAgent.UniSsoServerRsp)localObject).ret.has()) {
          break label463;
        }
        l2 = ((WebSSOAgent.UniSsoServerRsp)localObject).ret.get();
        if (!((WebSSOAgent.UniSsoServerRsp)localObject).errmsg.has()) {
          break label469;
        }
        paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject).errmsg.get();
        if (!((WebSSOAgent.UniSsoServerRsp)localObject).rspdata.has()) {
          break label476;
        }
        localObject = ((WebSSOAgent.UniSsoServerRsp)localObject).rspdata.get();
        JSONObject localJSONObject1 = SSOWebviewPlugin.a(l1);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("businessRet", l2);
        localJSONObject2.put("msg", paramBundle);
        localJSONObject2.put("data", localObject);
        localJSONObject2.put("ssoRet", 0);
        localJSONObject2.put("speedPoint", localJSONObject1);
        paramBundle = localJSONObject2.toString();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("uniAgent callback svrCostTime:");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(", Json string=");
          ((StringBuilder)localObject).append(paramBundle);
          QLog.d("QQDataModule", 2, ((StringBuilder)localObject).toString());
        }
        paramPromise.resolve(paramBundle);
        SSOWebviewPlugin.a(getAppInterface(), paramString, "ssoHippy", localJSONObject2, localJSONObject1);
        return;
      }
      catch (Throwable paramString)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onUniAgent, onReceive, Exception: ");
        paramBundle.append(paramString);
        QLog.e("QQDataModule", 1, paramBundle.toString());
        uniAgentCallBack(paramPromise, 255, 0, "parse error");
      }
      return;
      label455:
      long l1 = -1L;
      continue;
      label463:
      long l2 = 0L;
      continue;
      label469:
      paramBundle = "SSO发送成功";
      continue;
      label476:
      Object localObject = null;
    }
  }
  
  @HippyMethod(name="publicFollow")
  public void publicFollow(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap == null)
    {
      paramPromise.reject("params is null");
      return;
    }
    if (getAppInterface() == null)
    {
      paramPromise.reject("appInterface is null");
      return;
    }
    for (;;)
    {
      try
      {
        int i = paramHippyMap.getInt("follow");
        bool = true;
        if (i != 1) {
          break label248;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramHippyMap.getLong("uin"));
        ((StringBuilder)localObject).append("");
        paramHippyMap = ((StringBuilder)localObject).toString();
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("isFollow", bool);
        ((Bundle)localObject).putString("uin", paramHippyMap);
        localObject = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
        ((IPublicAccountObserver)localObject).setOnCallback(new QQDataModule.3(this, paramPromise));
        paramPromise = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramPromise instanceof QQAppInterface))
        {
          paramPromise = (QQAppInterface)paramPromise;
          if (bool)
          {
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin(paramPromise, BaseApplicationImpl.getApplication(), paramHippyMap, (IPublicAccountObserver)localObject, false, 0, true);
            return;
          }
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).unfollowUin(paramPromise, BaseApplicationImpl.getApplication(), paramHippyMap, false, (IPublicAccountObserver)localObject, true);
          return;
        }
      }
      catch (Throwable paramHippyMap)
      {
        paramPromise = new StringBuilder();
        paramPromise.append("uniAgent e:");
        paramPromise.append(paramHippyMap);
        QLog.d("QQDataModule", 2, paramPromise.toString());
      }
      return;
      label248:
      boolean bool = false;
    }
  }
  
  protected void sendUniAgentRequest(AppInterface paramAppInterface, String paramString1, long paramLong, String paramString2, BusinessObserver paramBusinessObserver)
  {
    Object localObject = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.8.17");
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
    localUniSsoServerReq.comm.set((MessageMicro)localObject);
    localUniSsoServerReq.reqdata.set(paramString2);
    localObject = new NewIntent(paramAppInterface.getApplicationContext(), WebSSOAgentServlet.class);
    ((NewIntent)localObject).putExtra("extra_cmd", paramString1);
    ((NewIntent)localObject).putExtra("extra_data", localUniSsoServerReq.toByteArray());
    ((NewIntent)localObject).putExtra("extra_callbackid", "0");
    ((NewIntent)localObject).putExtra("extra_timeout", paramLong);
    ((NewIntent)localObject).setObserver(paramBusinessObserver);
    if (QLog.isColorLevel())
    {
      paramBusinessObserver = new StringBuilder();
      paramBusinessObserver.append("uniAgent, req, cmd=");
      paramBusinessObserver.append(paramString1);
      paramBusinessObserver.append(", reqData=");
      paramBusinessObserver.append(paramString2);
      QLog.d("QQDataModule", 2, paramBusinessObserver.toString());
    }
    paramAppInterface.startServlet((NewIntent)localObject);
  }
  
  @HippyMethod(name="uniAgent")
  public void uniAgent(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap == null) {
      return;
    }
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface == null) {
      return;
    }
    for (;;)
    {
      try
      {
        String str = paramHippyMap.getString("cmd");
        if (paramHippyMap.containsKey("timeout"))
        {
          l = paramHippyMap.getLong("timeout");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("uniAgent, req, cmd=");
            localStringBuilder.append(str);
            localStringBuilder.append(",timeout = ");
            localStringBuilder.append(l);
            QLog.d("QQDataModule", 2, localStringBuilder.toString());
          }
          if (TextUtils.isEmpty(str))
          {
            uniAgentCallBack(paramPromise, 255, 0, HardCodeUtil.a(2131911674));
            return;
          }
          if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication()))
          {
            uniAgentCallBack(paramPromise, 103, 0, "MSF未连接");
            return;
          }
          paramHippyMap = paramHippyMap.toJSONObject();
          SSOWebviewPlugin.a(paramHippyMap);
          paramHippyMap.put("option", SSOWebviewPlugin.a());
          paramPromise = new QQDataModule.2(this, str, paramPromise);
          sendUniAgentRequest(localAppInterface, str, l, paramHippyMap.toString(), paramPromise);
          return;
        }
      }
      catch (Throwable paramHippyMap)
      {
        paramPromise = new StringBuilder();
        paramPromise.append("uniAgent e:");
        paramPromise.append(paramHippyMap);
        QLog.d("QQDataModule", 2, paramPromise.toString());
        return;
      }
      long l = -1L;
    }
  }
  
  protected void uniAgentCallBack(Promise paramPromise, int paramInt1, int paramInt2, String paramString)
  {
    if (paramPromise == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ssoRet", paramInt1);
      localJSONObject.put("businessRet", paramInt2);
      localJSONObject.put("msg", paramString);
      paramPromise.resolve(localJSONObject.toString());
      if (QLog.isColorLevel())
      {
        paramPromise = new StringBuilder();
        paramPromise.append("uniAgentCallBack ssoRet:");
        paramPromise.append(paramInt1);
        paramPromise.append(" businessRet:");
        paramPromise.append(paramInt2);
        paramPromise.append(" msg:");
        paramPromise.append(paramString);
        QLog.d("QQDataModule", 2, paramPromise.toString());
        return;
      }
    }
    catch (Throwable paramPromise)
    {
      paramString = new StringBuilder();
      paramString.append("uniAgentCallBack e:");
      paramString.append(paramPromise);
      QLog.e("QQDataModule", 1, paramString.toString());
    }
  }
  
  @HippyMethod(name="userInfo")
  public void userInfo(Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    Object localObject1;
    if ((getFragment() != null) && (getFragment().getArguments() != null)) {
      localObject1 = getFragment().getArguments().getBundle("params");
    } else {
      localObject1 = null;
    }
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = ((Bundle)localObject1).getString("domain");
    } else {
      localObject2 = null;
    }
    Object localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).checkDomainPermission((String)localObject2)) {
        localObject1 = localObject2;
      } else {
        localObject1 = null;
      }
    }
    else
    {
      localObject3 = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((HippyQQEngine)localObject3).getModuleName() != null)
        {
          localObject1 = localObject2;
          if (((HippyQQEngine)localObject3).getModuleName().startsWith("QQGameCenter")) {
            localObject1 = "gamecenter.qq.com";
          }
        }
      }
    }
    Object localObject5 = getAppInterface();
    if ((localObject5 != null) && (((AppInterface)localObject5).isLogin()) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      try
      {
        localObject2 = ((AppInterface)localObject5).getCurrentAccountUin();
        localObject3 = ((AppInterface)localObject5).getCurrentNickname();
        Object localObject4 = (TicketManager)((AppInterface)localObject5).getManager(2);
        String str = ((TicketManager)localObject4).getSkey((String)localObject2);
        localObject4 = ((TicketManager)localObject4).getPskey((String)localObject2, (String)localObject1);
        localObject1 = SwiftBrowserCookieMonster.b((AppRuntime)localObject5, (String)localObject1);
        localObject5 = new JSONObject();
        ((JSONObject)localObject5).put("uin", localObject2);
        ((JSONObject)localObject5).put("nick", localObject3);
        ((JSONObject)localObject5).put("skey", str);
        ((JSONObject)localObject5).put("p_skey", localObject4);
        ((JSONObject)localObject5).put("pt4_token", localObject1);
        paramPromise.resolve(((JSONObject)localObject5).toString());
        return;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("userInfo error:");
        ((StringBuilder)localObject2).append(localThrowable);
        QLog.e("QQDataModule", 1, ((StringBuilder)localObject2).toString());
      }
    }
    paramPromise.resolve("{}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQDataModule
 * JD-Core Version:    0.7.0.1
 */