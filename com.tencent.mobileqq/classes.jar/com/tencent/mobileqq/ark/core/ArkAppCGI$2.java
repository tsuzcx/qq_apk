package com.tencent.mobileqq.ark.core;

import java.util.ArrayList;

class ArkAppCGI$2
  implements Runnable
{
  ArkAppCGI$2(ArkAppCGI paramArkAppCGI, ArkAppCGI.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    synchronized (ArkAppCGI.a(this.this$0))
    {
      ArkAppCGI.a(this.this$0).remove(this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppCGI$QueryTask);
      this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppCGI$QueryTask.a.a(this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppCGI$QueryTask, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfByte);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppCGI.2
 * JD-Core Version:    0.7.0.1
 */