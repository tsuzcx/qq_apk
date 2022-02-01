package com.tencent.imcore.message.facade.send;

import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.facade.IMessageSendProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.hookparcel.ParcelHooker;
import com.tencent.mobileqq.data.MessageRecord;

class RecordMsgProcessor
  implements IMessageSendProcessor<QQAppInterface>
{
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (AppSetting.f()) {
      paramQQAppInterface.getParcelHooker().a(paramMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.send.RecordMsgProcessor
 * JD-Core Version:    0.7.0.1
 */