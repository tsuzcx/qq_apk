package com.tencent.biz.pubaccount.AccountDetail.model.api.impl;

import com.tencent.biz.pubaccount.AccountDetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicListModel;
import com.tencent.biz.pubaccount.AccountDetail.model.api.IPublicAccountDetailDynamicDataManagerService;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class PublicAccountDetailDynamicDataManagerServiceImpl$2
  implements Runnable
{
  PublicAccountDetailDynamicDataManagerServiceImpl$2(PublicAccountDetailDynamicDataManagerServiceImpl paramPublicAccountDetailDynamicDataManagerServiceImpl, long paramLong, QQAppInterface paramQQAppInterface, PublicAccountObserver paramPublicAccountObserver) {}
  
  public void run()
  {
    Object localObject = (DynamicInfoEntity)PublicAccountDetailDynamicDataManagerServiceImpl.access$000(this.this$0).find(DynamicInfoEntity.class, this.jdField_a_of_type_Long);
    if ((localObject != null) && (this.jdField_a_of_type_Long == Long.parseLong(((DynamicInfoEntity)localObject).puin)) && (((DynamicInfoEntity)localObject).dynamicInfoData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "getDynamicListForFirstEnterFromDB null != dynamicInfoEntity");
      }
      int i = AccountDetailDynamicListModel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, ((DynamicInfoEntity)localObject).dynamicInfoData, true);
      localObject = ((IPublicAccountDetailDynamicDataManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getAccountDetailDynamicInfoFromCache(this.jdField_a_of_type_Long);
      if ((i == 0) && (localObject != null) && (!((AccountDetailDynamicInfo)localObject).a().isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onDynamicListGet(true, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.api.impl.PublicAccountDetailDynamicDataManagerServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */