package com.tencent.biz.pubaccount.accountdetail.model;

import android.os.Bundle;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

final class AccountDetailBaseInfoModel$1
  implements BusinessObserver
{
  AccountDetailBaseInfoModel$1(QQAppInterface paramQQAppInterface, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("success:");
      ((StringBuilder)localObject1).append(String.valueOf(paramBoolean));
      QLog.d("AccountDetailBaseInfoModel", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (PublicAccountHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    boolean bool = false;
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        Object localObject2 = new mobileqq_mp.SetFunctionFlagResponse();
        ((mobileqq_mp.SetFunctionFlagResponse)localObject2).mergeFrom(paramBundle);
        if (((mobileqq_mp.RetInfo)((mobileqq_mp.SetFunctionFlagResponse)localObject2).ret_info.get()).ret_code.get() == 0)
        {
          ((mobileqq_mp.RetInfo)((mobileqq_mp.SetFunctionFlagResponse)localObject2).ret_info.get()).ret_code.get();
          if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseInfoModel", 2, "sendSetFunctionFlagRequest success");
          }
          this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.d = this.jdField_a_of_type_Int;
          paramBundle = null;
          localObject2 = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
          if (localObject2 != null) {
            paramBundle = (PublicAccountDetailImpl)((IPublicAccountDataManager)localObject2).findAccountDetailInfo(this.jdField_a_of_type_JavaLangString);
          }
          if (paramBundle != null)
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.e == 6)
            {
              if (this.jdField_a_of_type_Int == 1) {
                paramBundle.mShowMsgFlag = this.jdField_a_of_type_Int;
              }
            }
            else if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.e == 3)
            {
              paramBundle.isSyncLbs = true;
              paramBoolean = bool;
              if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.d == 1) {
                paramBoolean = true;
              }
              paramBundle.isAgreeSyncLbs = paramBoolean;
            }
            ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailBaseInfoModel.1.1(this, paramBundle), 10L);
            ((PublicAccountHandlerImpl)localObject1).notifyUI(109, true, this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo);
          }
        }
        else
        {
          ((PublicAccountHandlerImpl)localObject1).notifyUI(109, false, this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo);
        }
      }
      else
      {
        ((PublicAccountHandlerImpl)localObject1).notifyUI(109, false, this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo);
        return;
        ((PublicAccountHandlerImpl)localObject1).notifyUI(109, false, this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo);
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.model.AccountDetailBaseInfoModel.1
 * JD-Core Version:    0.7.0.1
 */