package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class TokenResp
  implements IMessageEntity
{
  @Packed
  private String belongId;
  @Packed
  private int retCode = 0;
  @Packed
  private String token = "";
  @Packed
  private String tokenSin;
  
  public String getBelongId()
  {
    return this.belongId;
  }
  
  public int getRetCode()
  {
    return this.retCode;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public String getTokenSin()
  {
    return this.tokenSin;
  }
  
  public void setBelongId(String paramString)
  {
    this.belongId = paramString;
  }
  
  public void setRetCode(int paramInt)
  {
    this.retCode = paramInt;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public void setTokenSin(String paramString)
  {
    this.tokenSin = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.aaid.entity.TokenResp
 * JD-Core Version:    0.7.0.1
 */