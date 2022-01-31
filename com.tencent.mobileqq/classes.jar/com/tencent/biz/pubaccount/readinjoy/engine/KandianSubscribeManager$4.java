package com.tencent.biz.pubaccount.readinjoy.engine;

import ajsf;
import axaq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import onk;

class KandianSubscribeManager$4
  implements Runnable
{
  KandianSubscribeManager$4(KandianSubscribeManager paramKandianSubscribeManager, String paramString1, long paramLong, String paramString2) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)onk.a();
    if (localQQAppInterface == null) {
      return;
    }
    MessageRecord localMessageRecord2 = localQQAppInterface.a().b(ajsf.aQ, 1008);
    MessageRecord localMessageRecord1;
    if (localMessageRecord2 != null)
    {
      localMessageRecord1 = axaq.a(-1000);
      MessageRecord.copyMessageRecordBaseField(localMessageRecord1, localMessageRecord2);
      localMessageRecord1.msgtype = -1000;
    }
    for (;;)
    {
      KandianSubscribeManager.a(localMessageRecord1, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.b);
      localQQAppInterface.a().a(localMessageRecord1, localQQAppInterface.c());
      return;
      localMessageRecord1 = axaq.a(-1000);
      localMessageRecord1.selfuin = localQQAppInterface.getCurrentAccountUin();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager.4
 * JD-Core Version:    0.7.0.1
 */