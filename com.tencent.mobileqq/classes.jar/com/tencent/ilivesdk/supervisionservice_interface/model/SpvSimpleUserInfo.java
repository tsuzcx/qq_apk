package com.tencent.ilivesdk.supervisionservice_interface.model;

public class SpvSimpleUserInfo
{
  public SpvSimpleUserInfo.Gender gender = SpvSimpleUserInfo.Gender.UNKNOWN;
  public String headKey;
  public String headUrl;
  public String nick;
  public String signature;
  public long uid;
  
  public String toString()
  {
    return "SpvSimpleUserInfo {uid=" + this.uid + "\nnick=" + this.nick + "\ngender=" + this.gender + "\nsignature=" + this.signature + "\nlogoUrl=" + this.headUrl + "\nheadKey=" + this.headKey + "\n}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.model.SpvSimpleUserInfo
 * JD-Core Version:    0.7.0.1
 */