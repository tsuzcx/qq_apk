package com.tencent.biz.pubaccount.AccountDetail.model;

import alvc;
import awbw;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import nhp;
import nhz;
import nia;

public class AccountDetailDynamicDataManager$2
  implements Runnable
{
  public AccountDetailDynamicDataManager$2(nhz paramnhz, long paramLong, QQAppInterface paramQQAppInterface, alvc paramalvc) {}
  
  public void run()
  {
    Object localObject = (DynamicInfoEntity)nhz.a(this.this$0).a(DynamicInfoEntity.class, this.jdField_a_of_type_Long);
    if ((localObject != null) && (this.jdField_a_of_type_Long == Long.parseLong(((DynamicInfoEntity)localObject).puin)) && (((DynamicInfoEntity)localObject).dynamicInfoData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "getDynamicListForFirstEnterFromDB null != dynamicInfoEntity");
      }
      int i = nia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, ((DynamicInfoEntity)localObject).dynamicInfoData, true);
      localObject = nhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Long);
      if ((i == 0) && (localObject != null) && (!((nhp)localObject).a().isEmpty())) {
        this.jdField_a_of_type_Alvc.a(true, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager.2
 * JD-Core Version:    0.7.0.1
 */