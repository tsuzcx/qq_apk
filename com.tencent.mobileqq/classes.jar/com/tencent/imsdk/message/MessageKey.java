package com.tencent.imsdk.message;

import java.io.Serializable;

public class MessageKey
  implements Serializable
{
  private long clientTime;
  private String groupID;
  private boolean isMessageSender;
  private String messageID;
  private int messageType;
  private long random;
  private String receiverUserID;
  private String senderUserID;
  private long seq;
  private long serverTime;
  
  public long getClientTime()
  {
    return this.clientTime;
  }
  
  public String getGroupID()
  {
    return this.groupID;
  }
  
  public String getMessageID()
  {
    return this.messageID;
  }
  
  public int getMessageType()
  {
    return this.messageType;
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
  
  public long getServerTime()
  {
    return this.serverTime;
  }
  
  public boolean isMessageSender()
  {
    return this.isMessageSender;
  }
  
  public void setClientTime(long paramLong)
  {
    this.clientTime = paramLong;
  }
  
  public void setGroupID(String paramString)
  {
    this.groupID = paramString;
  }
  
  public void setIsMessageSender(boolean paramBoolean)
  {
    this.isMessageSender = paramBoolean;
  }
  
  public void setMessageID(String paramString)
  {
    this.messageID = paramString;
  }
  
  public void setMessageType(int paramInt)
  {
    this.messageType = paramInt;
  }
  
  public void setRandom(long paramLong)
  {
    this.random = paramLong;
  }
  
  public void setReceiverUserID(String paramString)
  {
    this.receiverUserID = paramString;
  }
  
  public void setSenderUserID(String paramString)
  {
    this.senderUserID = paramString;
  }
  
  public void setSeq(long paramLong)
  {
    this.seq = paramLong;
  }
  
  public void setServerTime(long paramLong)
  {
    this.serverTime = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MessageKey--->");
    localStringBuilder.append("messageID:");
    localStringBuilder.append(this.messageID);
    localStringBuilder.append(", messageType:");
    localStringBuilder.append(this.messageType);
    localStringBuilder.append(", isMessageSender:");
    localStringBuilder.append(this.isMessageSender);
    localStringBuilder.append(", senderUserID:");
    localStringBuilder.append(this.senderUserID);
    localStringBuilder.append(", receiverUserID:");
    localStringBuilder.append(this.receiverUserID);
    localStringBuilder.append(", groupID:");
    localStringBuilder.append(this.groupID);
    localStringBuilder.append(", clientTime:");
    localStringBuilder.append(this.clientTime);
    localStringBuilder.append(", serverTime:");
    localStringBuilder.append(this.serverTime);
    localStringBuilder.append(", seq:");
    localStringBuilder.append(this.seq);
    localStringBuilder.append(", random:");
    localStringBuilder.append(this.random);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.MessageKey
 * JD-Core Version:    0.7.0.1
 */