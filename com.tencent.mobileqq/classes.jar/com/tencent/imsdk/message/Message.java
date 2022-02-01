package com.tencent.imsdk.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Message
  implements Serializable
{
  public static int MESSAGE_TYPE_C2C = 1;
  public static int MESSAGE_TYPE_GROUP = 2;
  public static int MESSAGE_TYPE_MULTI_SYNC = 3;
  public static int MESSAGE_TYPE_UNKNOWN = 0;
  public static int PLATFORM_ANDROID = 2;
  public static int PLATFORM_IOS = 3;
  public static int PLATFORM_MAC = 4;
  public static int PLATFORM_OTHER = 0;
  public static int PLATFORM_SIMULATOR = 5;
  public static int PLATFORM_WINDOWS = 1;
  public static final int V2TIM_MSG_STATUS_DELETED = 4;
  public static final int V2TIM_MSG_STATUS_LOCAL_IMPORTED = 5;
  public static final int V2TIM_MSG_STATUS_REVOKED = 6;
  public static final int V2TIM_MSG_STATUS_SENDING = 1;
  public static final int V2TIM_MSG_STATUS_SEND_FAILED = 3;
  public static final int V2TIM_MSG_STATUS_SUCCESS = 2;
  private long clientTime;
  private String cloudCustomString;
  private boolean excludedFromUnreadCount = false;
  private String faceUrl;
  private String friendRemark;
  private String groupID;
  private boolean isForward;
  private boolean isMessageSender;
  private boolean isPeerRead;
  private boolean isSelfRead;
  private int lifeTime = -1;
  private int localCustomNumber;
  private String localCustomString;
  private List<MessageBaseElement> messageBaseElements = new ArrayList();
  private List<MessageAtInfo> messageGroupAtInfoList = new ArrayList();
  private int messageStatus;
  private int messageType;
  private String msgID = "";
  private String nameCard;
  private String nickName;
  private MessageOfflinePushInfo offlinePushInfo;
  private int platform;
  private int priority;
  private long random;
  private long receiverTinyID;
  private String receiverUserID;
  private long senderTinyID;
  private String senderUserID;
  private long seq;
  private long serverTime;
  
  public void addElement(MessageBaseElement paramMessageBaseElement)
  {
    if (paramMessageBaseElement == null) {
      return;
    }
    this.messageBaseElements.add(paramMessageBaseElement);
  }
  
  protected void addMessageGroupAtInfo(MessageAtInfo paramMessageAtInfo)
  {
    this.messageGroupAtInfoList.add(paramMessageAtInfo);
  }
  
  public long getClientTime()
  {
    return this.clientTime;
  }
  
  public String getCloudCustomString()
  {
    return this.cloudCustomString;
  }
  
  public String getFaceUrl()
  {
    return this.faceUrl;
  }
  
  public String getFriendRemark()
  {
    return this.friendRemark;
  }
  
  public String getGroupID()
  {
    return this.groupID;
  }
  
  public int getLifeTime()
  {
    return this.lifeTime;
  }
  
  public int getLocalCustomNumber()
  {
    return this.localCustomNumber;
  }
  
  public String getLocalCustomString()
  {
    return this.localCustomString;
  }
  
  public List<MessageBaseElement> getMessageBaseElements()
  {
    return this.messageBaseElements;
  }
  
  public List<MessageAtInfo> getMessageGroupAtInfoList()
  {
    return this.messageGroupAtInfoList;
  }
  
  public MessageKey getMessageKey()
  {
    MessageKey localMessageKey = new MessageKey();
    localMessageKey.setMessageID(this.msgID);
    localMessageKey.setMessageType(this.messageType);
    localMessageKey.setIsMessageSender(this.isMessageSender);
    localMessageKey.setSenderUserID(this.senderUserID);
    localMessageKey.setReceiverUserID(this.receiverUserID);
    localMessageKey.setGroupID(this.groupID);
    localMessageKey.setClientTime(this.clientTime);
    localMessageKey.setServerTime(this.serverTime);
    localMessageKey.setSeq(this.seq);
    localMessageKey.setRandom(this.random);
    return localMessageKey;
  }
  
  public int getMessageStatus()
  {
    return this.messageStatus;
  }
  
  public int getMessageType()
  {
    return this.messageType;
  }
  
  public String getMsgID()
  {
    return this.msgID;
  }
  
  public String getNameCard()
  {
    return this.nameCard;
  }
  
  public String getNickName()
  {
    return this.nickName;
  }
  
  public MessageOfflinePushInfo getOfflinePushInfo()
  {
    return this.offlinePushInfo;
  }
  
  public int getPlatform()
  {
    return this.platform;
  }
  
  public int getPriority()
  {
    return this.priority;
  }
  
  public long getRandom()
  {
    return this.random;
  }
  
  public String getReceiverUserID()
  {
    return this.receiverUserID;
  }
  
  public String getSenderUserID()
  {
    return this.senderUserID;
  }
  
  public long getSeq()
  {
    return this.seq;
  }
  
  public long getTimestamp()
  {
    long l = this.serverTime;
    if (l > 0L) {
      return l;
    }
    return this.clientTime;
  }
  
  public boolean isExcludedFromUnreadCount()
  {
    return this.excludedFromUnreadCount;
  }
  
  public boolean isForward()
  {
    return this.isForward;
  }
  
  public boolean isMessageSender()
  {
    return this.isMessageSender;
  }
  
  public boolean isPeerRead()
  {
    if (this.isPeerRead) {
      return true;
    }
    this.isPeerRead = MessageCenter.getInstance().isMessagePeerRead(getMessageKey());
    return this.isPeerRead;
  }
  
  public boolean isSelfRead()
  {
    if (this.isSelfRead) {
      return true;
    }
    this.isSelfRead = MessageCenter.getInstance().isMessageSelfRead(getMessageKey());
    return this.isSelfRead;
  }
  
  public void setClientTime(long paramLong)
  {
    this.clientTime = paramLong;
  }
  
  public void setCloudCustomString(String paramString)
  {
    this.cloudCustomString = paramString;
  }
  
  public void setExcludedFromUnreadCount(boolean paramBoolean)
  {
    this.excludedFromUnreadCount = paramBoolean;
  }
  
  public void setForward(boolean paramBoolean)
  {
    this.isForward = paramBoolean;
  }
  
  public void setGroupID(String paramString)
  {
    this.groupID = paramString;
  }
  
  public void setIsMessageSender(boolean paramBoolean)
  {
    this.isMessageSender = paramBoolean;
  }
  
  public void setLifeTime(int paramInt)
  {
    this.lifeTime = paramInt;
  }
  
  public void setLocalCustomNumber(int paramInt)
  {
    this.localCustomNumber = paramInt;
    MessageCenter.getInstance().setLocalCustomNumber(this, paramInt);
  }
  
  public void setLocalCustomString(String paramString)
  {
    this.localCustomString = paramString;
    MessageCenter.getInstance().setLocalCustomString(this, paramString);
  }
  
  public void setMessageBaseElements(List<MessageBaseElement> paramList)
  {
    this.messageBaseElements = paramList;
  }
  
  public void setMessageGroupAtInfoList(List<MessageAtInfo> paramList)
  {
    this.messageGroupAtInfoList = paramList;
  }
  
  public void setMessageStatus(int paramInt)
  {
    this.messageStatus = paramInt;
  }
  
  public void setMessageType(int paramInt)
  {
    this.messageType = paramInt;
  }
  
  public void setOfflinePushInfo(MessageOfflinePushInfo paramMessageOfflinePushInfo)
  {
    this.offlinePushInfo = paramMessageOfflinePushInfo;
  }
  
  public void setPlatform(int paramInt)
  {
    this.platform = paramInt;
  }
  
  public void setPriority(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public void setReceiverUserID(String paramString)
  {
    this.receiverUserID = paramString;
  }
  
  public void setSenderUserID(String paramString)
  {
    this.senderUserID = paramString;
  }
  
  public void update(Message paramMessage)
  {
    this.msgID = paramMessage.msgID;
    this.messageType = paramMessage.messageType;
    this.isMessageSender = paramMessage.isMessageSender;
    this.senderUserID = paramMessage.senderUserID;
    this.receiverUserID = paramMessage.receiverUserID;
    this.groupID = paramMessage.groupID;
    this.clientTime = paramMessage.clientTime;
    this.serverTime = paramMessage.serverTime;
    this.seq = paramMessage.seq;
    this.random = paramMessage.random;
    this.messageStatus = paramMessage.messageStatus;
    Iterator localIterator1 = this.messageBaseElements.iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        return;
      }
      MessageBaseElement localMessageBaseElement = (MessageBaseElement)localIterator1.next();
      Iterator localIterator2 = paramMessage.messageBaseElements.iterator();
      if (localIterator2.hasNext()) {
        if (!localMessageBaseElement.update((MessageBaseElement)localIterator2.next())) {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.Message
 * JD-Core Version:    0.7.0.1
 */