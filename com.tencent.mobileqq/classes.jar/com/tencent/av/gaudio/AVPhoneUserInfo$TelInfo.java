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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TelInfo--> Nation = ");
    localStringBuilder.append(this.nation);
    localStringBuilder.append(", Prefix = ");
    localStringBuilder.append(this.prefix);
    localStringBuilder.append(", Mobile = ");
    localStringBuilder.append(this.mobile);
    localStringBuilder.append(", nationState = ");
    localStringBuilder.append(this.nationState);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo
 * JD-Core Version:    0.7.0.1
 */