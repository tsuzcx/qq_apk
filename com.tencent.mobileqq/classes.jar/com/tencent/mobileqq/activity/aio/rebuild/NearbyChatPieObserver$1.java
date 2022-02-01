package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.statistics.ReportTask;

class NearbyChatPieObserver$1
  implements Runnable
{
  NearbyChatPieObserver$1(NearbyChatPieObserver paramNearbyChatPieObserver, boolean paramBoolean, String paramString, NearbyCardManager paramNearbyCardManager) {}
  
  public void run()
  {
    ReportTask localReportTask = new ReportTask(NearbyChatPieObserver.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("data_card");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "msg_suc";; str = "msg_fail")
    {
      localReportTask.d(str).e(NearbyChatPieObserver.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a(new String[] { this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyCardManager.b()) }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPieObserver.1
 * JD-Core Version:    0.7.0.1
 */