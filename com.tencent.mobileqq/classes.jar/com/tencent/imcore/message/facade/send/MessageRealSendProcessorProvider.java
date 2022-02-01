package com.tencent.imcore.message.facade.send;

import com.tencent.imcore.message.facade.IMessageSendProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.entitymanager.Provider;
import java.util.List;

public class MessageRealSendProcessorProvider
  implements Provider<List<IMessageSendProcessor<QQAppInterface>>>
{
  private final List<IMessageSendProcessor<QQAppInterface>> a = new MessageRealSendProcessorProvider.1(this);
  
  public List<IMessageSendProcessor<QQAppInterface>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.send.MessageRealSendProcessorProvider
 * JD-Core Version:    0.7.0.1
 */