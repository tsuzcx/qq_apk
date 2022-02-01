package com.tencent.imsdk.message;

import com.tencent.imsdk.conversation.ConversationKey;
import java.util.List;

public class MessageSearchParam
{
  private ConversationKey conversationKey;
  private int count = 0;
  private List<String> keywordList;
  private MessageKey lastMessageKey;
  private List<Integer> messageTypeList;
  private List<Integer> searchFieldList;
  private int searchTimePeriod = 0;
  private int searchTimePosition = 0;
  private List<String> senderList;
  
  public ConversationKey getConversationKey()
  {
    return this.conversationKey;
  }
  
  public List<String> getKeywordList()
  {
    return this.keywordList;
  }
  
  public List<Integer> getMessageTypeList()
  {
    return this.messageTypeList;
  }
  
  public int getSearchTimePeriod()
  {
    return this.searchTimePeriod;
  }
  
  public int getSearchTimePosition()
  {
    return this.searchTimePosition;
  }
  
  public List<String> getSenderList()
  {
    return this.senderList;
  }
  
  public void setConversationKey(ConversationKey paramConversationKey)
  {
    this.conversationKey = paramConversationKey;
  }
  
  public void setKeywordList(List<String> paramList)
  {
    this.keywordList = paramList;
  }
  
  public void setMessageTypeList(List<Integer> paramList)
  {
    this.messageTypeList = paramList;
  }
  
  public void setSearchFieldList(List<Integer> paramList)
  {
    this.searchFieldList = paramList;
  }
  
  public void setSearchTimePeriod(int paramInt)
  {
    this.searchTimePeriod = paramInt;
  }
  
  public void setSearchTimePosition(int paramInt)
  {
    this.searchTimePosition = paramInt;
  }
  
  public void setSenderList(List<String> paramList)
  {
    this.senderList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.MessageSearchParam
 * JD-Core Version:    0.7.0.1
 */