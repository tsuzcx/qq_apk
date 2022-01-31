package com.tencent.biz.pubaccount.util;

import awge;
import awgf;
import awgg;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import nrt;
import syn;

public class PublicAccountUtil$9$1
  implements Runnable
{
  public PublicAccountUtil$9$1(syn paramsyn, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse) {}
  
  public void run()
  {
    Object localObject1 = new AccountDetail(this.a);
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()).createEntityManager();
    if (localObject2 != null) {
      ((awgf)localObject2).b((awge)localObject1);
    }
    if ((this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      localObject2 = (PublicAccountHandler)((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface).a(11);
      if (localObject2 != null) {
        ((PublicAccountHandler)localObject2).a(localObject1);
      }
    }
    if (this.this$0.jdField_a_of_type_Int >= 0)
    {
      if (!(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        break label139;
      }
      localObject1 = (QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface;
    }
    for (;;)
    {
      nrt.a((QQAppInterface)localObject1, this.this$0.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_Int);
      return;
      label139:
      localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {
        localObject1 = (QQAppInterface)localObject1;
      } else {
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.9.1
 * JD-Core Version:    0.7.0.1
 */