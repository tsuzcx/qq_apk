package com.tencent.biz.pubaccount.AccountDetail.model;

import com.tencent.qphone.base.util.QLog;
import nso;

public class AccountDetailDynamicDataManager$1
  implements Runnable
{
  public AccountDetailDynamicDataManager$1(nso paramnso, long paramLong, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailDynamicDataManager", 2, "updateAccountDetailDynamicInfoDB end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager.1
 * JD-Core Version:    0.7.0.1
 */