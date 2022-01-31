package com.tencent.av.gaudio;

import java.io.Serializable;

public class AVPhoneUserInfo$TelInfo
  implements Serializable
{
  public String mobile;
  public String nation;
  public int nationState;
  public String prefix;
  
  public AVPhoneUserInfo$TelInfo(AVPhoneUserInfo paramAVPhoneUserInfo) {}
  
  public String toString()
  {
    return "TelInfo--> Nation = " + this.nation + ", Prefix = " + this.prefix + ", Mobile = " + this.mobile + ", nationState = " + this.nationState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo
 * JD-Core Version:    0.7.0.1
 */