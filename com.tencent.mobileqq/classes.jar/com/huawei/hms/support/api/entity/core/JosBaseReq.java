package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class JosBaseReq
  implements IMessageEntity
{
  @Packed
  private String channelId;
  @Packed
  private String cpId;
  @Packed
  private String hmsSdkVersionName;
  
  private static <T> T get(T paramT)
  {
    return paramT;
  }
  
  public String getChannelId()
  {
    return (String)get(this.channelId);
  }
  
  public String getCpID()
  {
    return (String)get(this.cpId);
  }
  
  public String getHmsSdkVersionName()
  {
    return (String)get(this.hmsSdkVersionName);
  }
  
  public void setChannelId(String paramString)
  {
    this.channelId = paramString;
  }
  
  public void setCpID(String paramString)
  {
    this.cpId = paramString;
  }
  
  public void setHmsSdkVersionName(String paramString)
  {
    this.hmsSdkVersionName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.core.JosBaseReq
 * JD-Core Version:    0.7.0.1
 */