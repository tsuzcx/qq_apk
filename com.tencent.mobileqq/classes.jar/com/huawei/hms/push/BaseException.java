package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

public class BaseException
  extends Exception
{
  public final int a;
  public final ErrorEnum b;
  
  public BaseException(int paramInt)
  {
    this.b = ErrorEnum.fromCode(paramInt);
    this.a = this.b.getExternalCode();
  }
  
  public int getErrorCode()
  {
    return this.a;
  }
  
  public String getMessage()
  {
    return this.b.getMessage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.BaseException
 * JD-Core Version:    0.7.0.1
 */