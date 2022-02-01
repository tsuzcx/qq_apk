package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import mqq.app.AppRuntime;

class BaseMessageManager$1
  implements Runnable
{
  BaseMessageManager$1(BaseMessageManager paramBaseMessageManager, MessageRecord paramMessageRecord, long paramLong) {}
  
  public void run()
  {
    ((MessageCache)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getMsgCache()).d(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.this$0.a();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (!((MessageCache)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getMsgCache()).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq)) {
      BaseMessageManager.jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.this$0.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 15000L - (l1 - l2));
    } else {
      BaseMessageManager.jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.this$0.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, BaseMessageProcessor.b, BaseMessageProcessor.j);
    }
    ((MessageCache)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getMsgCache()).d(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.1
 * JD-Core Version:    0.7.0.1
 */