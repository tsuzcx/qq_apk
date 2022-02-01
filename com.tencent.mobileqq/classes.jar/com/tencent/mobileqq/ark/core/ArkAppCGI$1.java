package com.tencent.mobileqq.ark.core;

import com.tencent.mobileqq.ark.delegate.IHTTPDownloadCallback;
import com.tencent.qphone.base.util.QLog;

class ArkAppCGI$1
  implements IHTTPDownloadCallback
{
  ArkAppCGI$1(ArkAppCGI paramArkAppCGI, ArkAppCGI.QueryTask paramQueryTask) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt != 0)
    {
      QLog.i("ArkApp.ArkAppCGI", 1, String.format("download fail, url=%s, err=%d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppCGI$QueryTask.a, Integer.valueOf(paramInt) }));
      ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppCGI, this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppCGI$QueryTask, false, null);
      return;
    }
    ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppCGI, this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppCGI$QueryTask, true, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppCGI.1
 * JD-Core Version:    0.7.0.1
 */