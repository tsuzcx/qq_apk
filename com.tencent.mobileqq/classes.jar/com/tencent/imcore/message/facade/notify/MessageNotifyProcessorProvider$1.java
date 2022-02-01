package com.tencent.imcore.message.facade.notify;

import com.tencent.imcore.message.facade.IMessageNotifyProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class MessageNotifyProcessorProvider$1
  extends ArrayList<IMessageNotifyProcessor<QQAppInterface>>
{
  MessageNotifyProcessorProvider$1(MessageNotifyProcessorProvider paramMessageNotifyProcessorProvider)
  {
    add(new CommonMessageNotifyProcessor());
    add(new QQGameMessageNotifyProcessor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.notify.MessageNotifyProcessorProvider.1
 * JD-Core Version:    0.7.0.1
 */