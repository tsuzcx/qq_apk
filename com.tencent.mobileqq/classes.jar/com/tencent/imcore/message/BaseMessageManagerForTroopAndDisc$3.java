package com.tencent.imcore.message;

import acmd;
import aopk;
import bcrg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class BaseMessageManagerForTroopAndDisc$3
  implements Runnable
{
  public BaseMessageManagerForTroopAndDisc$3(acmd paramacmd, MessageRecord paramMessageRecord, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest " + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getLogColorContent() + " holdFlag: " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.this$0.a.getMsgHandler().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 15000L);
      return;
    }
    this.this$0.a.getMsgCache().e(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.this$0.a();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (this.this$0.a.getMsgCache().e(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
      this.this$0.a.getMsgHandler().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 15000L - (l1 - l2));
    }
    for (;;)
    {
      this.this$0.a.getMsgCache().e(null);
      return;
      this.this$0.a.getMsgHandler().a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, aopk.b, aopk.k);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.3
 * JD-Core Version:    0.7.0.1
 */