package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;

public class ResponseHeader
  implements IMessageEntity
{
  @Packed
  protected int statusCode;
  
  public ResponseHeader() {}
  
  public ResponseHeader(int paramInt)
  {
    this.statusCode = paramInt;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.core.aidl.ResponseHeader
 * JD-Core Version:    0.7.0.1
 */