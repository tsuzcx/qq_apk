package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.annotation.Packed;

public class AuthInfoResp
  extends AbstractResp
{
  @Packed
  private AuthorizationInfo authInfo;
  
  public AuthorizationInfo getAuthInfo()
  {
    return this.authInfo;
  }
  
  public int getRtnCode()
  {
    return super.getRtnCode();
  }
  
  public void setAuthInfo(AuthorizationInfo paramAuthorizationInfo)
  {
    this.authInfo = paramAuthorizationInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.auth.AuthInfoResp
 * JD-Core Version:    0.7.0.1
 */