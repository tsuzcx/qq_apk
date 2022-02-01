package com.tencent.falco.base.libapi.login;

public class LoginInfo
{
  public byte[] a2;
  public String access_token;
  public String businessUid;
  public String configData;
  public volatile LoginType loginType = LoginType.GUEST;
  public String openId;
  public long tinyid;
  public long uid;
  
  public String bytesToHexString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public LoginInfo clone()
  {
    LoginInfo localLoginInfo = new LoginInfo();
    localLoginInfo.uid = this.uid;
    localLoginInfo.tinyid = this.tinyid;
    localLoginInfo.a2 = ((byte[])this.a2.clone());
    localLoginInfo.openId = this.openId;
    localLoginInfo.access_token = this.access_token;
    localLoginInfo.businessUid = this.businessUid;
    localLoginInfo.loginType = this.loginType;
    localLoginInfo.configData = this.configData;
    return localLoginInfo;
  }
  
  public String toString()
  {
    long l1 = this.uid;
    int i = 0;
    long l2 = this.tinyid;
    String str1 = bytesToHexString(this.a2);
    String str2 = this.openId;
    String str3 = this.access_token;
    String str4 = this.businessUid;
    if (this.loginType != null) {
      i = this.loginType.ordinal();
    }
    return String.format("uid = %d, tinyid = %d, a2 = %s, openid = %s, access_token = %s, businessUid = %s, loginType = %d, configData = %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), str1, str2, str3, str4, Integer.valueOf(i), this.configData });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.login.LoginInfo
 * JD-Core Version:    0.7.0.1
 */