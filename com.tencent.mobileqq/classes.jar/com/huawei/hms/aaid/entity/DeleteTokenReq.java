package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class DeleteTokenReq
  implements IMessageEntity
{
  @Packed
  public String appId;
  @Packed
  public int deleteType = 0;
  @Packed
  public boolean isFastApp = false;
  @Packed
  public boolean isMultiSender = false;
  @Packed
  public String pkgName;
  @Packed
  public String projectId;
  @Packed
  public String scope;
  @Packed
  public String subjectId;
  @Packed
  public String token;
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public int getDeleteType()
  {
    return this.deleteType;
  }
  
  public String getPkgName()
  {
    return this.pkgName;
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
  
  public String getToken()
  {
    return this.token;
  }
  
  public boolean isFastApp()
  {
    return this.isFastApp;
  }
  
  public boolean isMultiSender()
  {
    return this.isMultiSender;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setDeleteType(int paramInt)
  {
    this.deleteType = paramInt;
  }
  
  public void setFastApp(boolean paramBoolean)
  {
    this.isFastApp = paramBoolean;
  }
  
  public void setMultiSender(boolean paramBoolean)
  {
    this.isMultiSender = paramBoolean;
  }
  
  public void setPkgName(String paramString)
  {
    this.pkgName = paramString;
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
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(DeleteTokenReq.class.getName());
    localStringBuffer.append("{");
    localStringBuffer.append("pkgName: ");
    localStringBuffer.append(this.pkgName);
    localStringBuffer.append(",scope:");
    localStringBuffer.append(this.scope);
    localStringBuffer.append(",appId:");
    localStringBuffer.append(this.appId);
    localStringBuffer.append(",projectId:");
    localStringBuffer.append(this.projectId);
    localStringBuffer.append(",subjectId:");
    localStringBuffer.append(this.subjectId);
    localStringBuffer.append(",subjectId:");
    localStringBuffer.append(this.subjectId);
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.aaid.entity.DeleteTokenReq
 * JD-Core Version:    0.7.0.1
 */