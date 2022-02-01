package com.tencent.ilivesdk.roomaudienceservice_interface;

public class UserServer
{
  public byte[] businessData;
  public String businessUid;
  public int clientType;
  public long enterTime;
  public String faceUrl;
  public int initialClientType;
  public String logoFullUrl;
  public String nickName;
  public int score;
  public long tinyid;
  public long uin;
  public int version;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("uin: " + this.uin);
    localStringBuffer.append("\nfaceUrl: " + this.faceUrl);
    localStringBuffer.append("\nversion: " + this.version);
    localStringBuffer.append("\ntinyid: " + this.tinyid);
    localStringBuffer.append("\nclientType: " + this.clientType);
    localStringBuffer.append("\nnickName: " + this.nickName);
    localStringBuffer.append("\nenterTime: " + this.enterTime);
    localStringBuffer.append("\nlogoFullUrl: " + this.logoFullUrl);
    localStringBuffer.append("\nscore: " + this.score);
    localStringBuffer.append("\nbusinessUid: " + this.businessUid);
    localStringBuffer.append("\ninitialClientType: " + this.initialClientType);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomaudienceservice_interface.UserServer
 * JD-Core Version:    0.7.0.1
 */