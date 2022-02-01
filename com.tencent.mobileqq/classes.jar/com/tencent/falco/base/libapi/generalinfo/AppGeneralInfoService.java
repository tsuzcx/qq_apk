package com.tencent.falco.base.libapi.generalinfo;

import android.app.Application;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface AppGeneralInfoService
  extends ServiceBaseInterface
{
  public abstract String getAppId();
  
  public abstract Application getApplication();
  
  public abstract String getChannelID();
  
  public abstract int getClientType();
  
  public abstract String getDeviceID();
  
  public abstract String getFromId();
  
  public abstract String getGuid();
  
  public abstract int getHostVersionCode();
  
  public abstract String getHostVersionName();
  
  public abstract int getOpenSdkAppid();
  
  public abstract String getSource();
  
  public abstract int getTPPlatform();
  
  public abstract String getTPPlayerGuid();
  
  public abstract String getTargetTestEnv();
  
  public abstract String getTcloudId();
  
  public abstract String getTcloudLice();
  
  public abstract int getVersionCode();
  
  public abstract String getVersionName();
  
  public abstract int getWnsAppid();
  
  public abstract boolean isDebug();
  
  public abstract boolean isLiteSdk();
  
  public abstract boolean isNeedInitTPPlatform();
  
  public abstract boolean isRelease();
  
  public abstract boolean isSvrTestEnv();
  
  public abstract void setDeviceId(String paramString);
  
  public abstract void setFromId(String paramString);
  
  public abstract void setSource(String paramString);
  
  public abstract void setSvrTestEnv(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService
 * JD-Core Version:    0.7.0.1
 */