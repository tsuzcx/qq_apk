package com.tencent.imsdk.conversation;

public class ConversationKey
{
  public static final int TYPE_C2C = 1;
  public static final int TYPE_GROUP = 2;
  private String conversationID;
  private int conversationType;
  
  public String getConversationID()
  {
    return this.conversationID;
  }
  
  public int getConversationType()
  {
    return this.conversationType;
  }
  
  public void setConversationID(String paramString)
  {
    this.conversationID = paramString;
  }
  
  public void setConversationType(int paramInt)
  {
    this.conversationType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.conversation.ConversationKey
 * JD-Core Version:    0.7.0.1
 */