package com.tencent.imsdk.message;

import com.tencent.imsdk.common.IMContext;
import java.util.List;

class MessageCenter$1
  extends MessageListener
{
  MessageCenter$1(MessageCenter paramMessageCenter) {}
  
  public void onReceiveMessageModified(List<Message> paramList)
  {
    IMContext.getInstance().runOnMainThread(new MessageCenter.1.4(this, paramList));
  }
  
  public void onReceiveMessageReceipt(List<MessageReceipt> paramList)
  {
    IMContext.getInstance().runOnMainThread(new MessageCenter.1.2(this, paramList));
  }
  
  public void onReceiveMessageRevoked(List<MessageKey> paramList)
  {
    IMContext.getInstance().runOnMainThread(new MessageCenter.1.3(this, paramList));
  }
  
  public void onReceiveNewMessage(List<Message> paramList)
  {
    IMContext.getInstance().runOnMainThread(new MessageCenter.1.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.MessageCenter.1
 * JD-Core Version:    0.7.0.1
 */