package com.tencent.imcore.message;

import anmr;
import bbko;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class BaseMessageManager$3
  implements Runnable
{
  BaseMessageManager$3(BaseMessageManager paramBaseMessageManager, MessageRecord paramMessageRecord, long paramLong) {}
  
  public void run()
  {
    this.this$0.a.getMsgCache().f(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.this$0.a();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (!this.this$0.a.getMsgCache().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq)) {
      this.this$0.a.getMsgHandler().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 15000L - (l1 - l2));
    }
    for (;;)
    {
      this.this$0.a.getMsgCache().f(null);
      return;
      this.this$0.a.getMsgHandler().a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, anmr.b, anmr.j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.3
 * JD-Core Version:    0.7.0.1
 */