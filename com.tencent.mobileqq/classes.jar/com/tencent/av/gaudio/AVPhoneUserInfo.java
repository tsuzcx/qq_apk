package com.tencent.av.gaudio;

import java.io.Serializable;

public class AVPhoneUserInfo
  implements Serializable
{
  public long account;
  public int accountType;
  public AVPhoneUserInfo.TelInfo telInfo = new AVPhoneUserInfo.TelInfo(this);
  
  public String toString()
  {
    return "AVUserInfo-->Account = " + this.account + " , AccountType = " + this.accountType + " , TelInfo = " + this.telInfo + " .";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.gaudio.AVPhoneUserInfo
 * JD-Core Version:    0.7.0.1
 */