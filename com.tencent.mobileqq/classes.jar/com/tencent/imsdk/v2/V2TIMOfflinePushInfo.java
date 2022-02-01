package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MessageOfflinePushInfo;
import com.tencent.imsdk.message.MessageOfflinePushInfo.APNSOfflinePushInfo;
import com.tencent.imsdk.message.MessageOfflinePushInfo.AndroidOfflinePushInfo;
import java.io.Serializable;

public class V2TIMOfflinePushInfo
  implements Serializable
{
  public static final String IOS_OFFLINE_PUSH_DEFAULT_SOUND = "default";
  public static final String IOS_OFFLINE_PUSH_NO_SOUND = "push.no_sound";
  private MessageOfflinePushInfo messageOfflinePushInfo;
  
  public void disablePush(boolean paramBoolean)
  {
    if (this.messageOfflinePushInfo == null) {
      this.messageOfflinePushInfo = new MessageOfflinePushInfo();
    }
    if (paramBoolean)
    {
      this.messageOfflinePushInfo.setPushFlag(1);
      return;
    }
    this.messageOfflinePushInfo.setPushFlag(0);
  }
  
  public String getDesc()
  {
    MessageOfflinePushInfo localMessageOfflinePushInfo = this.messageOfflinePushInfo;
    if (localMessageOfflinePushInfo != null) {
      return localMessageOfflinePushInfo.getDescription();
    }
    return null;
  }
  
  MessageOfflinePushInfo getMessageOfflinePushInfo()
  {
    return this.messageOfflinePushInfo;
  }
  
  public String getTitle()
  {
    MessageOfflinePushInfo localMessageOfflinePushInfo = this.messageOfflinePushInfo;
    if (localMessageOfflinePushInfo != null) {
      return localMessageOfflinePushInfo.getTitle();
    }
    return null;
  }
  
  public boolean isDisablePush()
  {
    MessageOfflinePushInfo localMessageOfflinePushInfo = this.messageOfflinePushInfo;
    return (localMessageOfflinePushInfo != null) && (localMessageOfflinePushInfo.getPushFlag() == 1);
  }
  
  public void setAndroidOPPOChannelID(String paramString)
  {
    MessageOfflinePushInfo localMessageOfflinePushInfo = this.messageOfflinePushInfo;
    if (localMessageOfflinePushInfo != null) {
      localMessageOfflinePushInfo.getAndroidConfig().setOppoChannelID(paramString);
    }
  }
  
  public void setDesc(String paramString)
  {
    if (this.messageOfflinePushInfo == null) {
      this.messageOfflinePushInfo = new MessageOfflinePushInfo();
    }
    this.messageOfflinePushInfo.setDescription(paramString);
  }
  
  public void setExt(byte[] paramArrayOfByte)
  {
    if (this.messageOfflinePushInfo == null) {
      this.messageOfflinePushInfo = new MessageOfflinePushInfo();
    }
    this.messageOfflinePushInfo.setExtension(paramArrayOfByte);
  }
  
  public void setIOSSound(String paramString)
  {
    MessageOfflinePushInfo localMessageOfflinePushInfo = this.messageOfflinePushInfo;
    if (localMessageOfflinePushInfo != null) {
      localMessageOfflinePushInfo.getApnsConfig().setSoundFilePath(paramString);
    }
  }
  
  public void setIgnoreIOSBadge(boolean paramBoolean)
  {
    MessageOfflinePushInfo localMessageOfflinePushInfo = this.messageOfflinePushInfo;
    if (localMessageOfflinePushInfo != null)
    {
      if (paramBoolean)
      {
        localMessageOfflinePushInfo.getApnsConfig().setBadgeMode(1);
        return;
      }
      localMessageOfflinePushInfo.getApnsConfig().setBadgeMode(0);
    }
  }
  
  void setMessageOfflinePushInfo(MessageOfflinePushInfo paramMessageOfflinePushInfo)
  {
    this.messageOfflinePushInfo = paramMessageOfflinePushInfo;
  }
  
  public void setTitle(String paramString)
  {
    if (this.messageOfflinePushInfo == null) {
      this.messageOfflinePushInfo = new MessageOfflinePushInfo();
    }
    this.messageOfflinePushInfo.setTitle(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMOfflinePushInfo
 * JD-Core Version:    0.7.0.1
 */