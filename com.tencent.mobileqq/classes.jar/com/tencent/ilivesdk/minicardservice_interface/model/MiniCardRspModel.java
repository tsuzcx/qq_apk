package com.tencent.ilivesdk.minicardservice_interface.model;

public class MiniCardRspModel
{
  public long explicitUid;
  public int heroValue;
  public long hotValue;
  public int isFollowed;
  public boolean isGuest;
  public String logoUrl;
  public String residentCity;
  public int totalFans;
  public int totalFollows;
  public long uin;
  public int userGender;
  public String userNick;
  
  public String toString()
  {
    return "uin:" + this.uin + " userNick:" + this.userNick + " userGender:" + this.userGender + " isFollowed:" + this.isFollowed + " residentCity:" + this.residentCity + " explicitUid:" + this.explicitUid + " totalFans:" + this.totalFans + " totalFollows:" + this.totalFollows + " hotValue:" + this.hotValue + " HeroValue:" + this.heroValue + " logoUrl:" + this.logoUrl + " isGuest:" + this.isGuest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.minicardservice_interface.model.MiniCardRspModel
 * JD-Core Version:    0.7.0.1
 */