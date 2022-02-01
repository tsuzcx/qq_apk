package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Status;

public class AbstractMessageEntity
  implements IMessageEntity
{
  @Packed
  private Status commonStatus;
  
  public Status getCommonStatus()
  {
    return this.commonStatus;
  }
  
  public void setCommonStatus(Status paramStatus)
  {
    this.commonStatus = paramStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.core.aidl.AbstractMessageEntity
 * JD-Core Version:    0.7.0.1
 */