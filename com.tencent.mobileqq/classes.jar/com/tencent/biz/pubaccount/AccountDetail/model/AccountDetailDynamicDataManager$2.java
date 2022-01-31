package com.tencent.biz.pubaccount.AccountDetail.model;

import ajpe;
import atmp;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mtv;
import muf;
import mug;

public class AccountDetailDynamicDataManager$2
  implements Runnable
{
  public AccountDetailDynamicDataManager$2(muf parammuf, long paramLong, QQAppInterface paramQQAppInterface, ajpe paramajpe) {}
  
  public void run()
  {
    Object localObject = (DynamicInfoEntity)muf.a(this.this$0).a(DynamicInfoEntity.class, this.jdField_a_of_type_Long);
    if ((localObject != null) && (this.jdField_a_of_type_Long == Long.parseLong(((DynamicInfoEntity)localObject).puin)) && (((DynamicInfoEntity)localObject).dynamicInfoData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "getDynamicListForFirstEnterFromDB null != dynamicInfoEntity");
      }
      int i = mug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, ((DynamicInfoEntity)localObject).dynamicInfoData, true);
      localObject = muf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Long);
      if ((i == 0) && (localObject != null) && (!((mtv)localObject).a().isEmpty())) {
        this.jdField_a_of_type_Ajpe.a(true, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager.2
 * JD-Core Version:    0.7.0.1
 */