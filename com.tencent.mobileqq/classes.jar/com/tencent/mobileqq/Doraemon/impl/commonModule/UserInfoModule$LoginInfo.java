package com.tencent.mobileqq.Doraemon.impl.commonModule;

import com.tencent.mobileqq.Doraemon.APIParam;

public final class UserInfoModule$LoginInfo
{
  public String a;
  public String b;
  
  public APIParam a()
  {
    APIParam localAPIParam = new APIParam();
    localAPIParam.put("openid", this.a);
    localAPIParam.put("access_token", this.b);
    return localAPIParam;
  }
  
  public String toString()
  {
    return "LoginInfo{, openid='" + this.a + '\'' + ", access_token='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule.LoginInfo
 * JD-Core Version:    0.7.0.1
 */