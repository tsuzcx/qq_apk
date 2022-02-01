package com.tencent.imsdk.message;

import java.io.Serializable;

public class MessageOfflinePushInfo$AndroidOfflinePushInfo
  implements Serializable
{
  private String description;
  private int notifyMode;
  private String oppoChannelID;
  private String soundFilePath;
  private String title;
  
  public MessageOfflinePushInfo$AndroidOfflinePushInfo(MessageOfflinePushInfo paramMessageOfflinePushInfo) {}
  
  public void setOppoChannelID(String paramString)
  {
    this.oppoChannelID = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.MessageOfflinePushInfo.AndroidOfflinePushInfo
 * JD-Core Version:    0.7.0.1
 */