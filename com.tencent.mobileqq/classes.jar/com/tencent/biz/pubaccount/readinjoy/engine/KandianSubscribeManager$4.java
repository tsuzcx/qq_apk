package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;

class KandianSubscribeManager$4
  implements Runnable
{
  KandianSubscribeManager$4(KandianSubscribeManager paramKandianSubscribeManager, String paramString1, long paramLong, String paramString2) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface == null) {
      return;
    }
    MessageRecord localMessageRecord2 = localQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
    MessageRecord localMessageRecord1;
    if (localMessageRecord2 != null)
    {
      localMessageRecord1 = MessageRecordFactory.a(-1000);
      MessageRecord.copyMessageRecordBaseField(localMessageRecord1, localMessageRecord2);
      localMessageRecord1.msgtype = -1000;
    }
    for (;;)
    {
      KandianSubscribeManager.a(localMessageRecord1, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.b);
      localQQAppInterface.getMessageFacade().a(localMessageRecord1, localQQAppInterface.getCurrentUin());
      return;
      localMessageRecord1 = MessageRecordFactory.a(-1000);
      localMessageRecord1.selfuin = localQQAppInterface.getCurrentAccountUin();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager.4
 * JD-Core Version:    0.7.0.1
 */