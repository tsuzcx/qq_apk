package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class AppInfo
  implements IMessageEntity
{
  @Packed
  private String appID;
  @Packed
  private String packageName;
  
  public AppInfo() {}
  
  public AppInfo(String paramString1, String paramString2)
  {
    this.appID = paramString1;
    this.packageName = paramString2;
  }
  
  public String getAppID()
  {
    return this.appID;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public void setAppID(String paramString)
  {
    this.appID = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.auth.AppInfo
 * JD-Core Version:    0.7.0.1
 */