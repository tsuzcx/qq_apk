package com.tencent.mobileqq.activity.aio.rebuild;

import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class PublicAccountChatPie$27
  extends NewPublicAccountObserver.ResponseResultListener
{
  PublicAccountChatPie$27(PublicAccountChatPie paramPublicAccountChatPie, String paramString) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.b, 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie, PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie));
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
      StructLongMessageDownloadProcessor.deleteTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      PublicAccountChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie, false);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.appid.get() + ""))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.b(1);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.w(2131695222);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    PublicAccountChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie);
    if (PublicAccountChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie) == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.bi();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.27
 * JD-Core Version:    0.7.0.1
 */