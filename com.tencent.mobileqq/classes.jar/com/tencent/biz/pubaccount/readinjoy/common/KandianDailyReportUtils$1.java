package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

final class KandianDailyReportUtils$1
  implements Runnable
{
  KandianDailyReportUtils$1(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extLong = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, "extLong", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils.1
 * JD-Core Version:    0.7.0.1
 */