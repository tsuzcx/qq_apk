package com.tencent.imsdk.message;

import java.io.Serializable;

public class MessageOfflinePushInfo
  implements Serializable
{
  public static final int OFFLINE_APNS_BADGE_MODE_DEFAULT = 0;
  public static final int OFFLINE_APNS_BADGE_MODE_IGNORE = 1;
  public static final int OFFLINE_PUSH_FLAG_DEFAULT = 0;
  public static final int OFFLINE_PUSH_FLAG_NO_PUSH = 1;
  private MessageOfflinePushInfo.AndroidOfflinePushInfo androidConfig = new MessageOfflinePushInfo.AndroidOfflinePushInfo(this);
  private MessageOfflinePushInfo.APNSOfflinePushInfo apnsConfig = new MessageOfflinePushInfo.APNSOfflinePushInfo(this);
  private String description;
  private byte[] extension;
  private int pushFlag;
  private String soundFilePath;
  private String title;
  
  public MessageOfflinePushInfo.AndroidOfflinePushInfo getAndroidConfig()
  {
    return this.androidConfig;
  }
  
  public MessageOfflinePushInfo.APNSOfflinePushInfo getApnsConfig()
  {
    return this.apnsConfig;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public byte[] getExtension()
  {
    return this.extension;
  }
  
  public int getPushFlag()
  {
    return this.pushFlag;
  }
  
  public String getSoundFilePath()
  {
    return this.soundFilePath;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setAndroidConfig(MessageOfflinePushInfo.AndroidOfflinePushInfo paramAndroidOfflinePushInfo)
  {
    this.androidConfig = paramAndroidOfflinePushInfo;
  }
  
  public void setApnsConfig(MessageOfflinePushInfo.APNSOfflinePushInfo paramAPNSOfflinePushInfo)
  {
    this.apnsConfig = paramAPNSOfflinePushInfo;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setExtension(byte[] paramArrayOfByte)
  {
    this.extension = paramArrayOfByte;
  }
  
  public void setPushFlag(int paramInt)
  {
    this.pushFlag = paramInt;
  }
  
  public void setSoundFilePath(String paramString)
  {
    this.soundFilePath = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.MessageOfflinePushInfo
 * JD-Core Version:    0.7.0.1
 */