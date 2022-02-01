package com.tencent.biz.pubaccount.AccountDetail.model;

import aoav;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import oao;
import oay;
import oaz;

public class AccountDetailDynamicDataManager$2
  implements Runnable
{
  public AccountDetailDynamicDataManager$2(oay paramoay, long paramLong, QQAppInterface paramQQAppInterface, aoav paramaoav) {}
  
  public void run()
  {
    Object localObject = (DynamicInfoEntity)oay.a(this.this$0).find(DynamicInfoEntity.class, this.jdField_a_of_type_Long);
    if ((localObject != null) && (this.jdField_a_of_type_Long == Long.parseLong(((DynamicInfoEntity)localObject).puin)) && (((DynamicInfoEntity)localObject).dynamicInfoData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "getDynamicListForFirstEnterFromDB null != dynamicInfoEntity");
      }
      int i = oaz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, ((DynamicInfoEntity)localObject).dynamicInfoData, true);
      localObject = oay.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Long);
      if ((i == 0) && (localObject != null) && (!((oao)localObject).a().isEmpty())) {
        this.jdField_a_of_type_Aoav.onDynamicListGet(true, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager.2
 * JD-Core Version:    0.7.0.1
 */