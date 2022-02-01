package com.tencent.imcore.message.facade.send.sender;

import com.tencent.imcore.message.facade.IMessageSender;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.entitymanager.Provider;
import java.util.List;

public class MsgSenderProvider
  implements Provider<List<IMessageSender<QQAppInterface>>>
{
  private final List<IMessageSender<QQAppInterface>> a = new MsgSenderProvider.1(this);
  
  public List<IMessageSender<QQAppInterface>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.send.sender.MsgSenderProvider
 * JD-Core Version:    0.7.0.1
 */