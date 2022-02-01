package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class TokenResp
  implements IMessageEntity
{
  @Packed
  public String belongId;
  @Packed
  public int retCode = 0;
  @Packed
  public String subjectId;
  @Packed
  public String token = "";
  
  public String getBelongId()
  {
    return this.belongId;
  }
  
  public int getRetCode()
  {
    return this.retCode;
  }
  
  public String getSubjectId()
  {
    return this.subjectId;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setBelongId(String paramString)
  {
    this.belongId = paramString;
  }
  
  public void setRetCode(int paramInt)
  {
    this.retCode = paramInt;
  }
  
  public void setSubjectId(String paramString)
  {
    this.subjectId = paramString;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.aaid.entity.TokenResp
 * JD-Core Version:    0.7.0.1
 */