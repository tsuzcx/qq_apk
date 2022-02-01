package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService;
import com.tencent.biz.pubaccount.accountdetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.accountdetail.model.AccountDetailDynamicListModel;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class PublicAccountDetailDynamicDataManagerServiceImpl$2
  implements Runnable
{
  PublicAccountDetailDynamicDataManagerServiceImpl$2(PublicAccountDetailDynamicDataManagerServiceImpl paramPublicAccountDetailDynamicDataManagerServiceImpl, long paramLong, AppInterface paramAppInterface, IPublicAccountObserver paramIPublicAccountObserver) {}
  
  public void run()
  {
    Object localObject = (PublicAccountDynamicInfoEntityImpl)PublicAccountDetailDynamicDataManagerServiceImpl.access$000(this.this$0).find(PublicAccountDynamicInfoEntityImpl.class, this.a);
    if ((localObject != null) && (this.a == Long.parseLong(((PublicAccountDynamicInfoEntityImpl)localObject).puin)) && (((PublicAccountDynamicInfoEntityImpl)localObject).dynamicInfoData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "getDynamicListForFirstEnterFromDB null != dynamicInfoEntity");
      }
      int i = AccountDetailDynamicListModel.a((QQAppInterface)this.b, true, ((PublicAccountDynamicInfoEntityImpl)localObject).dynamicInfoData, true);
      localObject = (AccountDetailDynamicInfo)((IPublicAccountDetailDynamicDataManagerService)this.b.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getAccountDetailDynamicInfoFromCache(this.a);
      if ((i == 0) && (localObject != null) && (!((AccountDetailDynamicInfo)localObject).a().isEmpty())) {
        this.c.onDynamicListGet(true, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailDynamicDataManagerServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */