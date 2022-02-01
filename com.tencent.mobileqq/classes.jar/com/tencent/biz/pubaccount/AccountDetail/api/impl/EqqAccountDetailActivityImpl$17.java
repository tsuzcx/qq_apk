package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class EqqAccountDetailActivityImpl$17
  extends NewPublicAccountObserver.ResponseResultListener
{
  EqqAccountDetailActivityImpl$17(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt1, int paramInt2) {}
  
  public int a()
  {
    return 7;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ArrayList))
    {
      paramObject = ((ArrayList)paramObject).iterator();
      while (paramObject.hasNext())
      {
        Object localObject = paramObject.next();
        if (((localObject instanceof AppletItem)) && (((AppletItem)localObject).c().equals(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.uin)))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.d = this.jdField_a_of_type_Int;
          this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.setAccountData();
          if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.e == 6) {
            if (this.b == 1)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.setShowMsgFlag(1);
              ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.app, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.uin, "mp_msg_ziliao_2", "share_click", 0, 0, "", "", "", "");
              ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.app, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.uin, "0X8004F05", "0X8004F05", 0, 0, "", "", "", "");
            }
            else
            {
              ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.app, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.uin, "0X8004F07", "0X8004F07", 0, 0, "", "", "", "");
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.TAG, 2, String.valueOf(this.b));
          }
          this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.saveAccountDetailInSubThread();
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.TAG, 2, "状态切换成功");
          }
          this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.setStatusText(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("success:");
      localStringBuilder.append(paramBoolean);
      QLog.d(paramObject, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.removeLoading();
  }
  
  public void b(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.displayToast(2131695217);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl;
    paramObject.waitingCount -= 1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.waitingCount == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.removeLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.17
 * JD-Core Version:    0.7.0.1
 */