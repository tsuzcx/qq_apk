package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qidian.util.QidianUtils;

class C2CMessageProcessorCallback$1
  implements Runnable
{
  C2CMessageProcessorCallback$1(C2CMessageProcessorCallback paramC2CMessageProcessorCallback, C2CMessageProcessor paramC2CMessageProcessor, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    QidianUtils.a(this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mQidianMasterUin), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mQidianTaskId), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mQidianTipText, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageProcessorCallback.1
 * JD-Core Version:    0.7.0.1
 */