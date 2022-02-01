package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.qphone.base.util.QLog;

class PublicAccountDetailDynamicDataManagerServiceImpl$1
  implements Runnable
{
  PublicAccountDetailDynamicDataManagerServiceImpl$1(PublicAccountDetailDynamicDataManagerServiceImpl paramPublicAccountDetailDynamicDataManagerServiceImpl, long paramLong, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.updateAccountDetailDynamicInfoDB(this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailDynamicDataManager", 2, "updateAccountDetailDynamicInfoDB end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailDynamicDataManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */