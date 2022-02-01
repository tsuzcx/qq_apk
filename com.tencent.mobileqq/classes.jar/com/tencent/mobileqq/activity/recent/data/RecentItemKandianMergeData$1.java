package com.tencent.mobileqq.activity.recent.data;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;

class RecentItemKandianMergeData$1
  implements Runnable
{
  public void run()
  {
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, "time", Long.valueOf(this.jdField_a_of_type_Long));
    localRecentUserProxy.b(this.this$0.mUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData.1
 * JD-Core Version:    0.7.0.1
 */