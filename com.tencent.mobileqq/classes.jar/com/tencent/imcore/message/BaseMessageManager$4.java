package com.tencent.imcore.message;

import abnt;
import amhm;
import ayvc;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class BaseMessageManager$4
  implements Runnable
{
  public BaseMessageManager$4(abnt paramabnt, MessageRecord paramMessageRecord, long paramLong) {}
  
  public void run()
  {
    this.this$0.a.a().f(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.this$0.a();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (!this.this$0.a.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq)) {
      this.this$0.a.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 15000L - (l1 - l2));
    }
    for (;;)
    {
      this.this$0.a.a().f(null);
      return;
      this.this$0.a.a().a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, amhm.e, amhm.m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.4
 * JD-Core Version:    0.7.0.1
 */