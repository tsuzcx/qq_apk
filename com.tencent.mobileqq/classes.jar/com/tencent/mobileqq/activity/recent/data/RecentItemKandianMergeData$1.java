package com.tencent.mobileqq.activity.recent.data;

import antf;
import apaw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;

class RecentItemKandianMergeData$1
  implements Runnable
{
  public void run()
  {
    apaw localapaw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(antf.aA, 7220, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, "time", Long.valueOf(this.jdField_a_of_type_Long));
    localapaw.saveRecentUser(this.this$0.mUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData.1
 * JD-Core Version:    0.7.0.1
 */