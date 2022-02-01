package com.huawei.hms.support.api.entity.push;

import android.content.Context;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.push.s;
import com.huawei.hms.utils.Util;

public class SubscribeReq
  implements IMessageEntity
{
  @Packed
  public String appId;
  @Packed
  public boolean isFastApp = false;
  @Packed
  public String operation;
  @Packed
  public String packageName;
  @Packed
  public String projectId;
  @Packed
  public String subjectId;
  @Packed
  public String token;
  @Packed
  public String topic;
  
  public SubscribeReq() {}
  
  public SubscribeReq(Context paramContext, String paramString1, String paramString2)
  {
    this.packageName = paramContext.getPackageName();
    this.operation = paramString1;
    this.topic = paramString2;
    this.appId = Util.getAppId(paramContext);
    this.projectId = s.c(paramContext);
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getOperation()
  {
    return this.operation;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public String getProjectId()
  {
    return this.projectId;
  }
  
  public String getSubjectId()
  {
    return this.subjectId;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public String getTopic()
  {
    return this.topic;
  }
  
  public boolean isFastApp()
  {
    return this.isFastApp;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setFastApp(boolean paramBoolean)
  {
    this.isFastApp = paramBoolean;
  }
  
  public void setOperation(String paramString)
  {
    this.operation = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setProjectId(String paramString)
  {
    this.projectId = paramString;
  }
  
  public void setSubjectId(String paramString)
  {
    this.subjectId = paramString;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public void setTopic(String paramString)
  {
    this.topic = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubscribeReq{");
    localStringBuilder.append("packageName='");
    localStringBuilder.append(this.packageName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", operation='");
    localStringBuilder.append(this.operation);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.push.SubscribeReq
 * JD-Core Version:    0.7.0.1
 */