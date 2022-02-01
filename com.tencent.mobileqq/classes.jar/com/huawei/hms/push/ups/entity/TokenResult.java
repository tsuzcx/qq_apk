package com.huawei.hms.push.ups.entity;

public class TokenResult
  extends CodeResult
{
  private String a;
  
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
    this.a = paramString;
  }
  
  public String getToken()
  {
    return this.a;
  }
  
  public void setToken(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.ups.entity.TokenResult
 * JD-Core Version:    0.7.0.1
 */