package com.tencent.biz.pubaccount.readinjoy.struct;

import atmo;
import atnz;

public class ReadInJoyUserInfo
  extends atmo
{
  @atnz
  private static final String TAG = "ReadInJoyUserInfo";
  public int accountLevel;
  public int accountType;
  public int faceFlag;
  public int faceType;
  public String faceUrl;
  public String largeIconUrl;
  public String nick;
  @atnz
  public boolean requestFlag;
  public String smallIconUrl;
  public int systemID;
  public long timestamp;
  public String uin;
  
  public String toString()
  {
    return "ReadInJoyUserInfo, accountType = " + this.accountType + '\n' + "uin = " + this.uin + '\n' + "nick = " + this.nick + '\n' + "faceType = " + this.faceType + '\n' + "timestamp = " + this.timestamp + '\n' + "faceFlag = " + this.faceFlag + '\n' + "faceUrl = " + this.faceUrl + '\n' + "systemID = " + this.systemID + '\n' + "requestFlag = " + this.requestFlag + '\n' + "accountLevel = " + this.accountLevel + '\n' + "smallIconUrl = " + this.smallIconUrl + '\n' + "largeIconUrl = " + this.largeIconUrl + '\n';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo
 * JD-Core Version:    0.7.0.1
 */