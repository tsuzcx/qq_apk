package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class EnableNotifyReq
  implements IMessageEntity
{
  @Packed
  private boolean enable;
  @Packed
  private String packageName;
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("EnableNotifyReq{");
    localStringBuilder.append("packageName='").append(this.packageName).append('\'');
    localStringBuilder.append(", enable=").append(this.enable);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.push.EnableNotifyReq
 * JD-Core Version:    0.7.0.1
 */