package com.tencent.imcore.message.facade.send.sender;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.facade.IMessageSender;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class MediaLightVideoMsgSender
  implements IMessageSender<QQAppInterface>
{
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramMessageRecord.istroop == 1) {
      AnonymousChatHelper.a().a(paramMessageRecord);
    }
    paramQQAppInterface.getMsgHandler().a(paramMessageRecord, paramBusinessObserver, paramBoolean);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.msgtype == -2071;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.send.sender.MediaLightVideoMsgSender
 * JD-Core Version:    0.7.0.1
 */