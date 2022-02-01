package com.tencent.imcore.message.facade.notify;

import com.tencent.imcore.message.facade.IMessageNotifyProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.entitymanager.Provider;
import java.util.List;

public class MessageNotifyProcessorProvider
  implements Provider<List<IMessageNotifyProcessor<QQAppInterface>>>
{
  private final List<IMessageNotifyProcessor<QQAppInterface>> a = new MessageNotifyProcessorProvider.1(this);
  
  public List<IMessageNotifyProcessor<QQAppInterface>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.notify.MessageNotifyProcessorProvider
 * JD-Core Version:    0.7.0.1
 */