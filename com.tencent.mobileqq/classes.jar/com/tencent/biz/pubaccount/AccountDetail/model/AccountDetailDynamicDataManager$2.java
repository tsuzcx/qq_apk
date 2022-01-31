package com.tencent.biz.pubaccount.AccountDetail.model;

import akdn;
import aukp;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import net;
import nfd;
import nfe;

public class AccountDetailDynamicDataManager$2
  implements Runnable
{
  public AccountDetailDynamicDataManager$2(nfd paramnfd, long paramLong, QQAppInterface paramQQAppInterface, akdn paramakdn) {}
  
  public void run()
  {
    Object localObject = (DynamicInfoEntity)nfd.a(this.this$0).a(DynamicInfoEntity.class, this.jdField_a_of_type_Long);
    if ((localObject != null) && (this.jdField_a_of_type_Long == Long.parseLong(((DynamicInfoEntity)localObject).puin)) && (((DynamicInfoEntity)localObject).dynamicInfoData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "getDynamicListForFirstEnterFromDB null != dynamicInfoEntity");
      }
      int i = nfe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, ((DynamicInfoEntity)localObject).dynamicInfoData, true);
      localObject = nfd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Long);
      if ((i == 0) && (localObject != null) && (!((net)localObject).a().isEmpty())) {
        this.jdField_a_of_type_Akdn.a(true, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager.2
 * JD-Core Version:    0.7.0.1
 */