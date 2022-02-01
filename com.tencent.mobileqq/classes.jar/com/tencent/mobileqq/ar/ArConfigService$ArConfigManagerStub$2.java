package com.tencent.mobileqq.ar;

import com.tencent.qphone.base.util.QLog;

class ArConfigService$ArConfigManagerStub$2
  implements Runnable
{
  ArConfigService$ArConfigManagerStub$2(ArConfigService.ArConfigManagerStub paramArConfigManagerStub, ArConfigService paramArConfigService, int paramInt) {}
  
  public void run()
  {
    ArConfigService.a(this.jdField_a_of_type_ComTencentMobileqqArArConfigService, this.jdField_a_of_type_Int);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadArSo first progress ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.d("ArConfig_ArConfigService", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService.ArConfigManagerStub.2
 * JD-Core Version:    0.7.0.1
 */