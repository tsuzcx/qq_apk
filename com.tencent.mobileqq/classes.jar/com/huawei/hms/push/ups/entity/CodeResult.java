package com.huawei.hms.push.ups.entity;

public class CodeResult
{
  public int a;
  public String b;
  
  public CodeResult() {}
  
  public CodeResult(int paramInt)
  {
    this.a = paramInt;
  }
  
  public CodeResult(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public String getReason()
  {
    return this.b;
  }
  
  public int getReturnCode()
  {
    return this.a;
  }
  
  public void setReason(String paramString)
  {
    this.b = paramString;
  }
  
  public void setReturnCode(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.ups.entity.CodeResult
 * JD-Core Version:    0.7.0.1
 */