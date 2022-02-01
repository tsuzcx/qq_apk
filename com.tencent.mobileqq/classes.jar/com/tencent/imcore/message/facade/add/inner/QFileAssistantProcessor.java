package com.tencent.imcore.message.facade.add.inner;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;

class QFileAssistantProcessor
  implements IAddMultiMessagesInnerProcessor
{
  public void a(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((!QFileAssistantUtils.a(paramMessageRecord)) && (QFileAssistantUtils.a(paramMessageRecord.frienduin)))
    {
      QFileAssistantUtils.a(paramMessageRecord, 0);
      QFileAssistantUtils.a(paramBaseQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.QFileAssistantProcessor
 * JD-Core Version:    0.7.0.1
 */