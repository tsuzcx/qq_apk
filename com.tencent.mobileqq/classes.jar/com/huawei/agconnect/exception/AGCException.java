package com.huawei.agconnect.exception;

public abstract class AGCException
  extends Exception
{
  private int code;
  private String errMsg;
  
  public AGCException(String paramString, int paramInt)
  {
    this.code = paramInt;
    this.errMsg = paramString;
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  public String getErrMsg()
  {
    return this.errMsg;
  }
  
  public String getMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" code: ");
    localStringBuilder.append(this.code);
    localStringBuilder.append(" message: ");
    localStringBuilder.append(this.errMsg);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.exception.AGCException
 * JD-Core Version:    0.7.0.1
 */