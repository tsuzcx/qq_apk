package com.tencent.av.gaudio;

import java.io.Serializable;

public class AVPhoneUserInfo
  implements Serializable
{
  public long account = 0L;
  public int accountType = 0;
  public AVPhoneUserInfo.TelInfo telInfo = new AVPhoneUserInfo.TelInfo(this);
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVUserInfo-->Account = ");
    localStringBuilder.append(this.account);
    localStringBuilder.append(" , AccountType = ");
    localStringBuilder.append(this.accountType);
    localStringBuilder.append(" , TelInfo = ");
    localStringBuilder.append(this.telInfo);
    localStringBuilder.append(" .");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVPhoneUserInfo
 * JD-Core Version:    0.7.0.1
 */