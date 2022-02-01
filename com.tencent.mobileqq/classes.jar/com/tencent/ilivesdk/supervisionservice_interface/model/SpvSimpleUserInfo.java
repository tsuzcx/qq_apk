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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SpvSimpleUserInfo {uid=");
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
    localStringBuilder.append("\n}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.model.SpvSimpleUserInfo
 * JD-Core Version:    0.7.0.1
 */