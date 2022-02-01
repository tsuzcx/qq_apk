package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class PublicAccountChatPie$44
  extends NewPublicAccountObserver.ResponseResultListener
{
  boolean jdField_a_of_type_Boolean;
  
  PublicAccountChatPie$44(PublicAccountChatPie paramPublicAccountChatPie) {}
  
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
      paramObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (paramObject != null)
      {
        paramObject = paramObject.findAccountDetailInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        if (paramObject != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountHandler == null)
          {
            PublicAccountChatPie localPublicAccountChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie;
            localPublicAccountChatPie.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountHandler = ((IPublicAccountHandler)localPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountHandler.onFollowPublicAccount(paramObject);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.t();
          this.jdField_a_of_type_Boolean = false;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.t();
        this.jdField_a_of_type_Boolean = false;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie;
      paramObject.D = true;
      paramObject.I = true;
      paramObject.ap();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.X)
      {
        paramObject = (PlusPanel)PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie).b(8);
        if (paramObject != null) {
          paramObject.a();
        }
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie;
      paramObject.c(paramObject.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.m(2131695217);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.ao();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.44
 * JD-Core Version:    0.7.0.1
 */