package com.tencent.imcore.message.facade.send;

import com.tencent.imcore.message.facade.IMessageSendProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class MessageRealSendProcessorProvider$1
  extends ArrayList<IMessageSendProcessor<QQAppInterface>>
{
  MessageRealSendProcessorProvider$1(MessageRealSendProcessorProvider paramMessageRealSendProcessorProvider)
  {
    add(new RecordMsgProcessor());
    add(new ForwardOrderMsgProcessor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.send.MessageRealSendProcessorProvider.1
 * JD-Core Version:    0.7.0.1
 */