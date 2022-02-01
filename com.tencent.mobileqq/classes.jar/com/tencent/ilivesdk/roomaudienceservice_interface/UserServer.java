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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin: ");
    localStringBuilder.append(this.uin);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nfaceUrl: ");
    localStringBuilder.append(this.faceUrl);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nversion: ");
    localStringBuilder.append(this.version);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("\ntinyid: ");
    localStringBuilder.append(this.tinyid);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nclientType: ");
    localStringBuilder.append(this.clientType);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nnickName: ");
    localStringBuilder.append(this.nickName);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nenterTime: ");
    localStringBuilder.append(this.enterTime);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nlogoFullUrl: ");
    localStringBuilder.append(this.logoFullUrl);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nscore: ");
    localStringBuilder.append(this.score);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nbusinessUid: ");
    localStringBuilder.append(this.businessUid);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("\ninitialClientType: ");
    localStringBuilder.append(this.initialClientType);
    localStringBuffer.append(localStringBuilder.toString());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.roomaudienceservice_interface.UserServer
 * JD-Core Version:    0.7.0.1
 */