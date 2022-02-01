package com.tencent.biz.pubaccount.AccountDetail.view;

import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class AccountDetailGroupListContainer$14$1
  extends NewPublicAccountObserver.ResponseResultListener
{
  AccountDetailGroupListContainer$14$1(AccountDetailGroupListContainer.14 param14, int paramInt) {}
  
  public int a()
  {
    return 7;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ArrayList))
    {
      Object localObject1 = ((ArrayList)paramObject).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((localObject2 instanceof AppletItem)) && (((AppletItem)localObject2).c().equals(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.d = this.jdField_a_of_type_Int;
          paramObject = null;
          localObject1 = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
          if (localObject1 != null) {
            paramObject = ((PublicAccountDataManager)localObject1).a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString);
          }
          if (paramObject != null)
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.e != 6) {
              break label237;
            }
            if (this.jdField_a_of_type_Int == 1) {
              paramObject.mShowMsgFlag = this.jdField_a_of_type_Int;
            }
          }
          label237:
          while (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.e != 3)
          {
            ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailGroupListContainer.14.1.1(this, paramObject), 10L);
            AccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo);
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).sendDetailInfoRequest(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString);
            return;
          }
          paramObject.isSyncLbs = true;
          if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.d == 1) {}
          for (boolean bool = true;; bool = false)
          {
            paramObject.isAgreeSyncLbs = bool;
            break;
          }
        }
      }
    }
    b(paramObject);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "success:" + paramBoolean);
    }
  }
  
  public void b(Object paramObject)
  {
    AccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer, 2131695222);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer.14.1
 * JD-Core Version:    0.7.0.1
 */