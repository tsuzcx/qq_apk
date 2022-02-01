package com.tencent.mobileqq.activity.aio.rebuild;

import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class PublicAccountChatPie$43
  extends NewPublicAccountObserver.ResponseResultListener
{
  boolean jdField_a_of_type_Boolean;
  
  PublicAccountChatPie$43(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.b, 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "", false);
      paramObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (paramObject == null) {
        break label272;
      }
      paramObject = paramObject.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (paramObject == null) {
        break label256;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(paramObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.N = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.S = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.bj();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.ah)
      {
        paramObject = (PlusPanel)PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie).b(8);
        if (paramObject != null) {
          paramObject.a();
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
      return;
      label256:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.E();
      this.jdField_a_of_type_Boolean = false;
      continue;
      label272:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.E();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.w(2131695222);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.bi();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.43
 * JD-Core Version:    0.7.0.1
 */