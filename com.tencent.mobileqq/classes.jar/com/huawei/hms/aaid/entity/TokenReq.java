package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class TokenReq
  implements IMessageEntity
{
  @Packed
  private String aaid;
  @Packed
  private String appId;
  @Packed
  private boolean firstTime;
  @Packed
  private String packageName;
  @Packed
  private String scope;
  
  public String getAaid()
  {
    return this.aaid;
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public String getScope()
  {
    return this.scope;
  }
  
  public boolean isFirstTime()
  {
    return this.firstTime;
  }
  
  public void setAaid(String paramString)
  {
    this.aaid = paramString;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setFirstTime(boolean paramBoolean)
  {
    this.firstTime = paramBoolean;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setScope(String paramString)
  {
    this.scope = paramString;
  }
  
  public String toString()
  {
    return getClass().getName() + "{ pkgName: " + this.packageName + " isFirstTime: " + this.firstTime + " scope: " + this.scope + " appId: " + this.appId + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.aaid.entity.TokenReq
 * JD-Core Version:    0.7.0.1
 */