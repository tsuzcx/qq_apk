package com.tencent.falco.base.libapi.login;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface LoginServiceInterface
  extends ServiceBaseInterface
{
  public abstract void addRoomReLoginObserver(LoginObserver paramLoginObserver);
  
  public abstract String getBusinessUid();
  
  public abstract LoginInfo getLoginInfo();
  
  public abstract void init(LoginServiceAdapter paramLoginServiceAdapter);
  
  public abstract boolean isGuest();
  
  public abstract void loginAuth(LoginRequest paramLoginRequest, LoginCallback paramLoginCallback);
  
  public abstract void logout(LogoutCallback paramLogoutCallback);
  
  public abstract void notifyLoginRefresh();
  
  public abstract void notifyNoLogin(NoLoginObserver.NoLoginReason paramNoLoginReason);
  
  public abstract void removeRoomReLoginObserver(LoginObserver paramLoginObserver);
  
  public abstract void setAuthTicket(String paramString1, String paramString2);
  
  public abstract void setBusinessUid(String paramString);
  
  public abstract void setNoLoginObserver(NoLoginObserver paramNoLoginObserver);
  
  public abstract void tryToRefreshLogin(LoginCallback paramLoginCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.login.LoginServiceInterface
 * JD-Core Version:    0.7.0.1
 */