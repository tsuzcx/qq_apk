package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class BaseMessageManagerForTroopAndDisc$3
  implements Runnable
{
  BaseMessageManagerForTroopAndDisc$3(BaseMessageManagerForTroopAndDisc paramBaseMessageManagerForTroopAndDisc, MessageRecord paramMessageRecord, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doMsgRevokeRequest ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getLogColorContent());
      localStringBuilder.append(" holdFlag: ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      BaseMessageManager.a.a(this.this$0.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 15000L);
      return;
    }
    this.this$0.h(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.this$0.a();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (this.this$0.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
      BaseMessageManager.a.a(this.this$0.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 15000L - (l1 - l2));
    } else {
      BaseMessageManager.a.a(this.this$0.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, BaseMessageProcessor.b, BaseMessageProcessor.k);
    }
    this.this$0.h(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.3
 * JD-Core Version:    0.7.0.1
 */