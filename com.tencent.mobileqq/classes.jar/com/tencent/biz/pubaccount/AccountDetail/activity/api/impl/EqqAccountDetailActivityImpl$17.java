package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class EqqAccountDetailActivityImpl$17
  extends NewPublicAccountObserver.ResponseResultListener
{
  EqqAccountDetailActivityImpl$17(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt1, int paramInt2) {}
  
  public int a()
  {
    return 7;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ArrayList))
    {
      paramObject = ((ArrayList)paramObject).iterator();
      for (;;)
      {
        if (paramObject.hasNext())
        {
          Object localObject = paramObject.next();
          if (((localObject instanceof AppletItem)) && (((AppletItem)localObject).c().equals(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.uin)))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.d = this.jdField_a_of_type_Int;
            this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.setAccountData();
            if (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.e == 6)
            {
              if (this.b != 1) {
                break label236;
              }
              this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.setShowMsgFlag(1);
              ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.app, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.uin, "mp_msg_ziliao_2", "share_click", 0, 0, "", "", "", "");
              ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.app, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.uin, "0X8004F05", "0X8004F05", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.TAG, 2, String.valueOf(this.b));
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.saveAccountDetailInSubThread();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.TAG, 2, "状态切换成功");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.setStatusText(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo);
      return;
      label236:
      ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.app, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.uin, "0X8004F07", "0X8004F07", 0, 0, "", "", "", "");
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.TAG, 2, "success:" + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.removeLoading();
  }
  
  public void b(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.displayToast(2131695222);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl;
    paramObject.waitingCount -= 1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.waitingCount == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.removeLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.EqqAccountDetailActivityImpl.17
 * JD-Core Version:    0.7.0.1
 */