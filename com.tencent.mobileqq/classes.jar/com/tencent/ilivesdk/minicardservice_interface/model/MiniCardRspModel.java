package com.tencent.ilivesdk.minicardservice_interface.model;

public class MiniCardRspModel
{
  public long explicitUid;
  public int heroValue;
  public long hotValue;
  public int isFollowed;
  public boolean isGuest;
  public String logoUrl = "";
  public String residentCity;
  public int totalFans;
  public int totalFollows;
  public long uin;
  public String userFromStr = "";
  public int userGender;
  public String userNick;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin:");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(" userNick:");
    localStringBuilder.append(this.userNick);
    localStringBuilder.append(" userGender:");
    localStringBuilder.append(this.userGender);
    localStringBuilder.append(" isFollowed:");
    localStringBuilder.append(this.isFollowed);
    localStringBuilder.append(" residentCity:");
    localStringBuilder.append(this.residentCity);
    localStringBuilder.append(" explicitUid:");
    localStringBuilder.append(this.explicitUid);
    localStringBuilder.append(" totalFans:");
    localStringBuilder.append(this.totalFans);
    localStringBuilder.append(" totalFollows:");
    localStringBuilder.append(this.totalFollows);
    localStringBuilder.append(" logoUrl:");
    localStringBuilder.append(this.logoUrl);
    localStringBuilder.append(" isGuest:");
    localStringBuilder.append(this.isGuest);
    localStringBuilder.append(" hotValue:");
    localStringBuilder.append(this.hotValue);
    localStringBuilder.append(" HeroValue:");
    localStringBuilder.append(this.heroValue);
    localStringBuilder.append(" userFromStr = ");
    localStringBuilder.append(this.userFromStr);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.minicardservice_interface.model.MiniCardRspModel
 * JD-Core Version:    0.7.0.1
 */