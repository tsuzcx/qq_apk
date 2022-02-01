package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class PublicAccountChatPie$9
  implements Runnable
{
  PublicAccountChatPie$9(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    Object localObject = null;
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localPublicAccountDataManager != null) {
      localObject = localPublicAccountDataManager.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    boolean bool;
    if (localObject == null)
    {
      bool = this.this$0.F();
      this.this$0.E();
      if ((bool) && (TextUtils.isEmpty(this.this$0.f)) && (localPublicAccountDataManager != null))
      {
        localObject = localPublicAccountDataManager.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        if ((localObject != null) && (!TextUtils.isEmpty(((AccountDetail)localObject).summary))) {
          this.this$0.f = ((AccountDetail)localObject).summary;
        }
      }
    }
    for (;;)
    {
      if ((bool) || (PublicAccountChatPie.a(this.this$0)))
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EFB", "0X8004EFB", 0, 0, "", "", "", "", false);
        this.this$0.O = true;
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      }
      for (;;)
      {
        localObject = "0";
        if (bool) {
          localObject = "1";
        }
        long l = NetConnInfoCenter.getServerTime();
        if (QLog.isColorLevel()) {
          QLog.d("struct_log_tag", 2, "PublicAccountChatPie :CliOper|" + this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a + "|0X8005619|0X8005619" + 0 + "|" + 0 + "|" + Long.toString(l) + "|" + (String)localObject);
        }
        ReportController.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X8005619", "0X8005619", 0, 0, Long.toString(l), (String)localObject, "", "");
        return;
        if (!PublicAccountChatPie.b(this.this$0)) {
          this.this$0.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.init(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, new PublicAccountChatPie.9.1(this));
        }
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.9
 * JD-Core Version:    0.7.0.1
 */