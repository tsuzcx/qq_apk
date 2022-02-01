package com.tencent.ilivesdk.loginservice;

import android.content.Context;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.falco.base.libapi.hostproxy.ILiveErrCodeTrans;
import com.tencent.falco.base.libapi.login.LoginCallback;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginObserver;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.falco.base.libapi.login.LoginServiceAdapter;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.login.LoginType;
import com.tencent.falco.base.libapi.login.LogoutCallback;
import com.tencent.falco.base.libapi.login.NoLoginObserver;
import com.tencent.falco.base.libapi.login.NoLoginObserver.NoLoginReason;
import com.tencent.falco.base.libapi.web.WebInterface;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LoginServiceImpl
  implements LoginServiceInterface
{
  private LoginImpl loginImpl;
  private List<LoginObserver> loginObserverList;
  private LoginServiceAdapter loginServiceAdapter;
  private String mBusinessUid;
  private NoLoginObserver noLoginObserver;
  
  private void reportLoginBizFailEvent(int paramInt)
  {
    paramInt = ILiveErrCodeTrans.a(paramInt);
    this.loginServiceAdapter.getDataReportInterface().newTask().setPage("room_page").setPageDesc("直播间").setModule("login").setModuleDesc("登录").setActType("fail").setActTypeDesc("失败").addKeyValue("zt_str1", String.valueOf(paramInt)).setRealTimeUpload(true).send();
  }
  
  private void reportLoginBizSuccessEvent()
  {
    this.loginServiceAdapter.getDataReportInterface().newTask().setPage("room_page").setPageDesc("直播间").setModule("login").setModuleDesc("登录").setActType("success").setActTypeDesc("成功").setRealTimeUpload(true).send();
  }
  
  public void addRoomReLoginObserver(LoginObserver paramLoginObserver)
  {
    this.loginObserverList.add(paramLoginObserver);
  }
  
  public void clearEventOutput()
  {
    this.loginObserverList.clear();
  }
  
  public String getBusinessUid()
  {
    return this.mBusinessUid;
  }
  
  public LoginInfo getLoginInfo()
  {
    LoginImpl localLoginImpl = this.loginImpl;
    if (localLoginImpl == null) {
      return null;
    }
    return localLoginImpl.getLoginInfo();
  }
  
  public void init(LoginServiceAdapter paramLoginServiceAdapter)
  {
    this.loginServiceAdapter = paramLoginServiceAdapter;
    this.loginObserverList = new LinkedList();
    if (paramLoginServiceAdapter.loginByWns())
    {
      this.loginImpl = new LoginImpWns(this.loginServiceAdapter);
      return;
    }
    this.loginImpl = new LoginImpl(this.loginServiceAdapter);
  }
  
  public boolean isGuest()
  {
    LoginImpl localLoginImpl = this.loginImpl;
    boolean bool = true;
    if (localLoginImpl != null)
    {
      if (localLoginImpl.getLoginInfo() == null) {
        return true;
      }
      if (this.loginImpl.getLoginInfo().loginType == LoginType.GUEST) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void loginAuth(LoginRequest paramLoginRequest, LoginCallback paramLoginCallback)
  {
    LoginImpl localLoginImpl = this.loginImpl;
    boolean bool = this.loginServiceAdapter.isTestEnv();
    String str1 = paramLoginRequest.id;
    String str2 = paramLoginRequest.token;
    String str3 = paramLoginRequest.appid;
    int i = this.loginServiceAdapter.getClientType();
    String str4 = this.loginServiceAdapter.getDeviceID();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.loginServiceAdapter.getVersionCode());
    localLoginImpl.setLoginReqInfo(bool, str1, str2, str3, String.valueOf(i), str4, localStringBuilder.toString(), paramLoginRequest.loginType, paramLoginRequest.customExtData, paramLoginRequest.appid);
    this.loginImpl.doLogin(new LoginServiceImpl.1(this, paramLoginCallback, paramLoginRequest));
    reportLoginStartEvent();
  }
  
  public void logout(LogoutCallback paramLogoutCallback)
  {
    LoginImpl localLoginImpl = this.loginImpl;
    if (localLoginImpl != null) {
      localLoginImpl.doLogout(paramLogoutCallback);
    }
  }
  
  public void notifyLoginRefresh()
  {
    if (this.loginServiceAdapter.getWebInterface() != null) {
      this.loginServiceAdapter.getWebInterface().rePlantCookie();
    }
    Iterator localIterator = this.loginObserverList.iterator();
    while (localIterator.hasNext()) {
      ((LoginObserver)localIterator.next()).onLoginSuccess();
    }
  }
  
  public void notifyNoLogin(NoLoginObserver.NoLoginReason paramNoLoginReason)
  {
    NoLoginObserver localNoLoginObserver = this.noLoginObserver;
    if (localNoLoginObserver != null) {
      localNoLoginObserver.onNoLogin(paramNoLoginReason);
    }
  }
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void removeRoomReLoginObserver(LoginObserver paramLoginObserver)
  {
    if (paramLoginObserver == null) {
      return;
    }
    List localList = this.loginObserverList;
    if ((localList != null) && (localList.size() > 0)) {
      this.loginObserverList.remove(paramLoginObserver);
    }
  }
  
  void reportLoginResultEvent(int paramInt1, int paramInt2, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void reportLoginStartEvent()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setAuthTicket(String paramString1, String paramString2)
  {
    LoginImpl localLoginImpl = this.loginImpl;
    if (localLoginImpl != null) {
      localLoginImpl.setAuthTicket(paramString1, paramString2);
    }
  }
  
  public void setBusinessUid(String paramString)
  {
    this.mBusinessUid = paramString;
  }
  
  public void setNoLoginObserver(NoLoginObserver paramNoLoginObserver)
  {
    this.noLoginObserver = paramNoLoginObserver;
  }
  
  public void tryToRefreshLogin(LoginCallback paramLoginCallback)
  {
    LoginImpl localLoginImpl = this.loginImpl;
    if (localLoginImpl != null) {
      localLoginImpl.refreshLogin(paramLoginCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginServiceImpl
 * JD-Core Version:    0.7.0.1
 */