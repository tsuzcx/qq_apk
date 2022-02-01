package com.tencent.imsdk.message;

import java.io.Serializable;

public class MessageOfflinePushInfo$APNSOfflinePushInfo
  implements Serializable
{
  private int badgeMode;
  private String description;
  private String soundFilePath;
  private String title;
  
  public MessageOfflinePushInfo$APNSOfflinePushInfo(MessageOfflinePushInfo paramMessageOfflinePushInfo) {}
  
  public void setBadgeMode(int paramInt)
  {
    this.badgeMode = paramInt;
  }
  
  public void setSoundFilePath(String paramString)
  {
    this.soundFilePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.MessageOfflinePushInfo.APNSOfflinePushInfo
 * JD-Core Version:    0.7.0.1
 */