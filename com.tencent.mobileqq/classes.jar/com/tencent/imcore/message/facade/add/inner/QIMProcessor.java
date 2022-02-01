package com.tencent.imcore.message.facade.add.inner;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerProcessor;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

class QIMProcessor
  implements IAddMultiMessagesInnerProcessor
{
  public void a(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    int i = FlashChatManager.a(paramMessageRecord);
    if (i != -1) {
      try
      {
        ((FlashChatManager)paramBaseQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(i, paramMessageRecord);
        return;
      }
      catch (Exception paramBaseQQAppInterface)
      {
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("addMultiMessagesInner type ");
          paramMessageRecord.append(i);
          QLog.e("QIMProcessor", 2, paramMessageRecord.toString(), paramBaseQQAppInterface);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.QIMProcessor
 * JD-Core Version:    0.7.0.1
 */