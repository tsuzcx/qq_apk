package com.tencent.ilivesdk.loginservice;

import android.content.Context;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.QualityReportTask;
import com.tencent.falco.base.libapi.datareport.ReportTask;
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
    String str = "3";
    if (paramInt == 1004) {
      str = "1";
    }
    for (;;)
    {
      this.loginServiceAdapter.getDataReportInterface().newTask().setPage("room_page").setPageDesc("直播间").setModule("login").setModuleDesc("登录").setActType("fail").setActTypeDesc("失败").addKeyValue("zt_str1", str).setRealTimeUpload(true).send();
      return;
      if (paramInt == 1006) {
        str = "2";
      }
    }
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
    if (this.loginImpl == null) {
      return null;
    }
    return this.loginImpl.getLoginInfo();
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
    if ((this.loginImpl == null) || (this.loginImpl.getLoginInfo() == null)) {}
    while (this.loginImpl.getLoginInfo().loginType == LoginType.GUEST) {
      return true;
    }
    return false;
  }
  
  public void loginAuth(LoginRequest paramLoginRequest, LoginCallback paramLoginCallback)
  {
    this.loginImpl.setLoginReqInfo(this.loginServiceAdapter.isTestEnv(), paramLoginRequest.id, paramLoginRequest.token, paramLoginRequest.appid, String.valueOf(this.loginServiceAdapter.getClientType()), this.loginServiceAdapter.getDeviceID(), "" + this.loginServiceAdapter.getVersionCode(), paramLoginRequest.loginType, paramLoginRequest.customExtData, paramLoginRequest.appid);
    this.loginImpl.doLogin(new LoginServiceImpl.1(this, paramLoginCallback, paramLoginRequest));
    reportLoginStartEvent();
  }
  
  public void logout(LogoutCallback paramLogoutCallback)
  {
    if (this.loginImpl != null) {
      this.loginImpl.doLogout(paramLogoutCallback);
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
    if (this.noLoginObserver != null) {
      this.noLoginObserver.onNoLogin(paramNoLoginReason);
    }
  }
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void removeRoomReLoginObserver(LoginObserver paramLoginObserver)
  {
    if (paramLoginObserver == null) {}
    while ((this.loginObserverList == null) || (this.loginObserverList.size() <= 0)) {
      return;
    }
    this.loginObserverList.remove(paramLoginObserver);
  }
  
  void reportLoginResultEvent(int paramInt1, int paramInt2, String paramString)
  {
    QualityReportTask localQualityReportTask = this.loginServiceAdapter.getDataReportInterface().newQualityTaskCustom().setActType("loginFinished").setActTypeDesc("登录结果").setModule("login").setPage("quality_page").addKeyValue("zt_int1", paramInt1).addKeyValue("zt_int2", paramInt2);
    if (this.loginServiceAdapter.loginByWns()) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localQualityReportTask.addKeyValue("zt_int3", paramInt1).addKeyValue("zt_str1", paramString).setRealTimeUpload(true).send();
      return;
    }
  }
  
  void reportLoginStartEvent()
  {
    QualityReportTask localQualityReportTask = this.loginServiceAdapter.getDataReportInterface().newQualityTaskCustom().setActType("beginLogin").setActTypeDesc("开始登录").setModule("login").setPage("quality_page");
    if (this.loginServiceAdapter.loginByWns()) {}
    for (int i = 1;; i = 0)
    {
      localQualityReportTask.addKeyValue("zt_int3", i).setRealTimeUpload(true).send();
      return;
    }
  }
  
  public void setAuthTicket(String paramString1, String paramString2)
  {
    if (this.loginImpl != null) {
      this.loginImpl.setAuthTicket(paramString1, paramString2);
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
    if (this.loginImpl != null) {
      this.loginImpl.refreshLogin(paramLoginCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginServiceImpl
 * JD-Core Version:    0.7.0.1
 */