package com.tencent.av.utils;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;

final class VideoMsgTools$4
  implements Runnable
{
  VideoMsgTools$4(QQMessageFacade paramQQMessageFacade, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    localQQMessageFacade.a(localMessageRecord, localMessageRecord.selfuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.4
 * JD-Core Version:    0.7.0.1
 */