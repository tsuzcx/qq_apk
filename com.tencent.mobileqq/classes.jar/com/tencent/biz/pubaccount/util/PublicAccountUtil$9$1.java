package com.tencent.biz.pubaccount.util;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import olh;
import uuo;

public class PublicAccountUtil$9$1
  implements Runnable
{
  public PublicAccountUtil$9$1(uuo paramuuo, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse) {}
  
  public void run()
  {
    Object localObject1 = new AccountDetail(this.a);
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()).createEntityManager();
    if (localObject2 != null) {
      ((EntityManager)localObject2).persistOrReplace((Entity)localObject1);
    }
    if ((this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      localObject2 = (PublicAccountHandler)((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface).getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (localObject2 != null) {
        ((PublicAccountHandler)localObject2).a(localObject1);
      }
    }
    if (this.this$0.jdField_a_of_type_Int >= 0)
    {
      if (!(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        break label140;
      }
      localObject1 = (QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface;
    }
    for (;;)
    {
      olh.a((QQAppInterface)localObject1, this.this$0.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_Int);
      return;
      label140:
      localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {
        localObject1 = (QQAppInterface)localObject1;
      } else {
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.9.1
 * JD-Core Version:    0.7.0.1
 */