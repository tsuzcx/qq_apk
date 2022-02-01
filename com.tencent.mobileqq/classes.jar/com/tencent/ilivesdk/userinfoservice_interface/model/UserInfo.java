package com.tencent.ilivesdk.userinfoservice_interface.model;

public class UserInfo
{
  public String awardWidgetUrl;
  public String businessUid;
  public int clientType;
  public long explicitUid;
  public long fanQun;
  public UserInfo.Gender gender = UserInfo.Gender.UNKNOWN;
  public String headKey;
  public long headTimestamp;
  public String headUrl;
  public String nick;
  public String residentCity;
  public String signature;
  public long uid;
  
  public String toString()
  {
    return "UserInfo {uid=" + this.uid + "\nnick=" + this.nick + "\ngender=" + this.gender + "\nsignature=" + this.signature + "\nlogoUrl=" + this.headUrl + "\nheadKey=" + this.headKey + "\nlogoTimestamp=" + this.headTimestamp + "\nexplicitUid=" + this.explicitUid + "\nfanQun=" + this.fanQun + "\nawardWidgetUrl=" + this.awardWidgetUrl + "\nresidentCity=" + this.residentCity + "\nclientType=" + this.clientType + "\nbusinessUid=" + this.businessUid + "\n}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.userinfoservice_interface.model.UserInfo
 * JD-Core Version:    0.7.0.1
 */