package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class DeleteTokenReq
  implements IMessageEntity
{
  @Packed
  private String appId;
  @Packed
  private String pkgName;
  @Packed
  private String scope;
  @Packed
  private String token;
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getPkgName()
  {
    return this.pkgName;
  }
  
  public String getScope()
  {
    return this.scope;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setPkgName(String paramString)
  {
    this.pkgName = paramString;
  }
  
  public void setScope(String paramString)
  {
    this.scope = paramString;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public String toString()
  {
    return getClass().getName() + "{ pkgName: " + this.pkgName + " scope: " + this.scope + " appId: " + this.appId + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.aaid.entity.DeleteTokenReq
 * JD-Core Version:    0.7.0.1
 */