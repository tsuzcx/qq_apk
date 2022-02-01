package com.huawei.hms.push.ups.entity;

public class TokenResult
  extends CodeResult
{
  public String c;
  
  public TokenResult() {}
  
  public TokenResult(int paramInt)
  {
    super(paramInt);
  }
  
  public TokenResult(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  public TokenResult(String paramString)
  {
    this.c = paramString;
  }
  
  public String getToken()
  {
    return this.c;
  }
  
  public void setToken(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.ups.entity.TokenResult
 * JD-Core Version:    0.7.0.1
 */