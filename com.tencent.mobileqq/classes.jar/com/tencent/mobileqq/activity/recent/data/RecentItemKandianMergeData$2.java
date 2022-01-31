package com.tencent.mobileqq.activity.recent.data;

import aljq;
import amjk;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;

class RecentItemKandianMergeData$2
  implements Runnable
{
  RecentItemKandianMergeData$2(RecentItemKandianMergeData paramRecentItemKandianMergeData, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, long paramLong) {}
  
  public void run()
  {
    amjk localamjk = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(aljq.aA, 7220, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, "time", Long.valueOf(this.jdField_a_of_type_Long));
    localamjk.a(this.this$0.mUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData.2
 * JD-Core Version:    0.7.0.1
 */