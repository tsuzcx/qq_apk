package com.tencent.imcore.message.facade.send;

import com.tencent.imcore.message.facade.IMessageSendProcessor;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class ForwardOrderMsgProcessor
  implements IMessageSendProcessor<QQAppInterface>
{
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    ForwardOrderManager.a().a(paramQQAppInterface, paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.send.ForwardOrderMsgProcessor
 * JD-Core Version:    0.7.0.1
 */