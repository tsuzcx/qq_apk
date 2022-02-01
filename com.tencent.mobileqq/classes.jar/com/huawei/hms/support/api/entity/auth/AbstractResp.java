package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public abstract class AbstractResp
  implements IMessageEntity
{
  @Packed
  private String errorReason;
  @Packed
  private int rtnCode = 0;
  
  public String getErrorReason()
  {
    return this.errorReason;
  }
  
  public int getRtnCode()
  {
    return this.rtnCode;
  }
  
  public void setErrorReason(String paramString)
  {
    this.errorReason = paramString;
  }
  
  public void setRtnCode(int paramInt)
  {
    this.rtnCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.auth.AbstractResp
 * JD-Core Version:    0.7.0.1
 */