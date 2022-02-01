package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class DeleteTokenResp
  implements IMessageEntity
{
  @Packed
  private int retCode = 0;
  
  public int getRetCode()
  {
    return this.retCode;
  }
  
  public void setRetCode(int paramInt)
  {
    this.retCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.aaid.entity.DeleteTokenResp
 * JD-Core Version:    0.7.0.1
 */