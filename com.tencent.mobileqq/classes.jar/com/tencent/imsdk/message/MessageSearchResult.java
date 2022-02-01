package com.tencent.imsdk.message;

import java.util.List;

public class MessageSearchResult
{
  private String conversationID;
  private List<String> messageIDList;
  private int messageType;
  
  public String getConversationID()
  {
    return this.conversationID;
  }
  
  public List<String> getMessageIDList()
  {
    return this.messageIDList;
  }
  
  public int getMessageType()
  {
    return this.messageType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.MessageSearchResult
 * JD-Core Version:    0.7.0.1
 */