package com.tencent.imsdk.message;

import java.util.List;

public abstract class MessageListener
{
  public void onReceiveMessageModified(List<Message> paramList) {}
  
  public void onReceiveMessageReceipt(List<MessageReceipt> paramList) {}
  
  public void onReceiveMessageRevoked(List<MessageKey> paramList) {}
  
  public void onReceiveNewMessage(List<Message> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.MessageListener
 * JD-Core Version:    0.7.0.1
 */