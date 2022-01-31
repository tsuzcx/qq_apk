package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;

public class ReadInJoyUserInfo
  extends Entity
{
  @notColumn
  private static final String TAG = "ReadInJoyUserInfo";
  public int accountType;
  public int faceFlag;
  public int faceType;
  public String faceUrl;
  public String md5Uin;
  public String nick;
  @notColumn
  public boolean requestFlag;
  public int systemID;
  public long timestamp;
  
  public String toString()
  {
    return "ReadInJoyUserInfo, accountType = " + this.accountType + '\n' + "md5Uin = " + this.md5Uin + '\n' + "nick = " + this.nick + '\n' + "faceType = " + this.faceType + '\n' + "timestamp = " + this.timestamp + '\n' + "faceFlag = " + this.faceFlag + '\n' + "faceUrl = " + this.faceUrl + '\n' + "systemID = " + this.systemID + '\n' + "requestFlag = " + this.requestFlag + '\n';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo
 * JD-Core Version:    0.7.0.1
 */