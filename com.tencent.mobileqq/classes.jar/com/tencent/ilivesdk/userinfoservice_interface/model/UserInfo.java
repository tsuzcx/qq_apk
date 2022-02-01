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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserInfo {uid=");
    localStringBuilder.append(this.uid);
    localStringBuilder.append("\nnick=");
    localStringBuilder.append(this.nick);
    localStringBuilder.append("\ngender=");
    localStringBuilder.append(this.gender);
    localStringBuilder.append("\nsignature=");
    localStringBuilder.append(this.signature);
    localStringBuilder.append("\nlogoUrl=");
    localStringBuilder.append(this.headUrl);
    localStringBuilder.append("\nheadKey=");
    localStringBuilder.append(this.headKey);
    localStringBuilder.append("\nlogoTimestamp=");
    localStringBuilder.append(this.headTimestamp);
    localStringBuilder.append("\nexplicitUid=");
    localStringBuilder.append(this.explicitUid);
    localStringBuilder.append("\nfanQun=");
    localStringBuilder.append(this.fanQun);
    localStringBuilder.append("\nawardWidgetUrl=");
    localStringBuilder.append(this.awardWidgetUrl);
    localStringBuilder.append("\nresidentCity=");
    localStringBuilder.append(this.residentCity);
    localStringBuilder.append("\nclientType=");
    localStringBuilder.append(this.clientType);
    localStringBuilder.append("\nbusinessUid=");
    localStringBuilder.append(this.businessUid);
    localStringBuilder.append("\n}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.userinfoservice_interface.model.UserInfo
 * JD-Core Version:    0.7.0.1
 */