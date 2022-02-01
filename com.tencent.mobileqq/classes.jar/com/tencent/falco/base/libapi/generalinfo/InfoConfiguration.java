package com.tencent.falco.base.libapi.generalinfo;

import android.app.Application;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface InfoConfiguration
  extends ServiceBaseInterface
{
  public abstract void setAppId(String paramString);
  
  public abstract void setApplication(Application paramApplication);
  
  public abstract void setChannelID(String paramString);
  
  public abstract void setClientType(int paramInt);
  
  public abstract void setDebug(boolean paramBoolean);
  
  public abstract void setHostGuId(String paramString);
  
  public abstract void setHostVersionCode(int paramInt);
  
  public abstract void setHostVersionName(String paramString);
  
  public abstract void setLiteSdk(boolean paramBoolean);
  
  public abstract void setNeedInitTPPlatform(boolean paramBoolean);
  
  public abstract void setOpenSdkAppId(int paramInt);
  
  public abstract void setRelease(boolean paramBoolean);
  
  public abstract void setTPPlatform(int paramInt);
  
  public abstract void setTcloudConfig(String paramString1, String paramString2);
  
  public abstract void setVersionCode(int paramInt);
  
  public abstract void setVersionName(String paramString);
  
  public abstract void setWnsAppid(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.generalinfo.InfoConfiguration
 * JD-Core Version:    0.7.0.1
 */