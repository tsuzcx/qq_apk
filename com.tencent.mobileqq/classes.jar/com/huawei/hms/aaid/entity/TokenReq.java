package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class TokenReq
  implements IMessageEntity
{
  @Packed
  public String aaid;
  @Packed
  public String appId;
  @Packed
  public boolean firstTime;
  @Packed
  public boolean isFastApp = false;
  @Packed
  public boolean isMultiSender = false;
  @Packed
  public String packageName;
  @Packed
  public String projectId;
  @Packed
  public String scope;
  @Packed
  public String subjectId;
  
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
  
  public String getProjectId()
  {
    return this.projectId;
  }
  
  public String getScope()
  {
    return this.scope;
  }
  
  public String getSubjectId()
  {
    return this.subjectId;
  }
  
  public boolean isFastApp()
  {
    return this.isFastApp;
  }
  
  public boolean isFirstTime()
  {
    return this.firstTime;
  }
  
  public boolean isMultiSender()
  {
    return this.isMultiSender;
  }
  
  public void setAaid(String paramString)
  {
    this.aaid = paramString;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setFastApp(boolean paramBoolean)
  {
    this.isFastApp = paramBoolean;
  }
  
  public void setFirstTime(boolean paramBoolean)
  {
    this.firstTime = paramBoolean;
  }
  
  public void setMultiSender(boolean paramBoolean)
  {
    this.isMultiSender = paramBoolean;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setProjectId(String paramString)
  {
    this.projectId = paramString;
  }
  
  public void setScope(String paramString)
  {
    this.scope = paramString;
  }
  
  public void setSubjectId(String paramString)
  {
    this.subjectId = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(TokenReq.class.getName());
    localStringBuffer.append("{");
    localStringBuffer.append("pkgName: ");
    localStringBuffer.append(this.packageName);
    localStringBuffer.append(",isFirstTime: ");
    localStringBuffer.append(this.firstTime);
    localStringBuffer.append(",scope:");
    localStringBuffer.append(this.scope);
    localStringBuffer.append(",appId:");
    localStringBuffer.append(this.appId);
    localStringBuffer.append(",projectId:");
    localStringBuffer.append(this.projectId);
    localStringBuffer.append(",subjectId:");
    localStringBuffer.append(this.subjectId);
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.aaid.entity.TokenReq
 * JD-Core Version:    0.7.0.1
 */