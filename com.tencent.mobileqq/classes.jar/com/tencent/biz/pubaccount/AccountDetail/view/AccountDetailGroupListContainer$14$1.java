package com.tencent.biz.pubaccount.accountdetail.view;

import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.QQAppInterface;
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
        if (((localObject2 instanceof AppletItem)) && (((AppletItem)localObject2).c().equals(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.d = this.jdField_a_of_type_Int;
          paramObject = null;
          localObject1 = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
          if (localObject1 != null) {
            paramObject = (PublicAccountDetailImpl)((IPublicAccountDataManager)localObject1).findAccountDetailInfo(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString);
          }
          if (paramObject != null)
          {
            int i = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.e;
            boolean bool = true;
            if (i == 6)
            {
              i = this.jdField_a_of_type_Int;
              if (i == 1) {
                paramObject.mShowMsgFlag = i;
              }
            }
            else if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.e == 3)
            {
              paramObject.isSyncLbs = true;
              if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.d != 1) {
                bool = false;
              }
              paramObject.isAgreeSyncLbs = bool;
            }
            ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailGroupListContainer.14.1.1(this, paramObject), 10L);
            AccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo);
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).sendDetailInfoRequest(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString);
          }
          return;
        }
      }
    }
    b(paramObject);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("success:");
      paramObject.append(paramBoolean);
      QLog.d("AccountDetailGroupListContainer", 2, paramObject.toString());
    }
  }
  
  public void b(Object paramObject)
  {
    AccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer$14.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer, 2131695217);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.14.1
 * JD-Core Version:    0.7.0.1
 */