package com.tencent.mobileqq.app.message;

import akab;
import akcw;
import awao;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class BaseMessageManagerForTroopAndDisc$3
  implements Runnable
{
  public BaseMessageManagerForTroopAndDisc$3(akab paramakab, MessageRecord paramMessageRecord, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest " + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getLogColorContent() + " holdFlag: " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.this$0.a.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 15000L);
      return;
    }
    this.this$0.a.a().e(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.this$0.a();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (this.this$0.a.a().e(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
      this.this$0.a.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 15000L - (l1 - l2));
    }
    for (;;)
    {
      this.this$0.a.a().e(null);
      return;
      this.this$0.a.a().a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, akcw.e, akcw.n);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.BaseMessageManagerForTroopAndDisc.3
 * JD-Core Version:    0.7.0.1
 */