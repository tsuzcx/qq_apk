package com.tencent.mobileqq.activity.recent.data;

import ajsf;
import aktg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;

class RecentItemKandianMergeData$2
  implements Runnable
{
  RecentItemKandianMergeData$2(RecentItemKandianMergeData paramRecentItemKandianMergeData, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, long paramLong) {}
  
  public void run()
  {
    aktg localaktg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ajsf.aA, 7220, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, "time", Long.valueOf(this.jdField_a_of_type_Long));
    localaktg.a(this.this$0.mUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData.2
 * JD-Core Version:    0.7.0.1
 */