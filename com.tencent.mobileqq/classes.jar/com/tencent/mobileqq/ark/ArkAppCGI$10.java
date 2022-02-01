package com.tencent.mobileqq.ark;

import java.util.ArrayList;

class ArkAppCGI$10
  implements Runnable
{
  ArkAppCGI$10(ArkAppCGI paramArkAppCGI, ArkAppCGI.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    synchronized (ArkAppCGI.a(this.this$0))
    {
      ArkAppCGI.a(this.this$0).remove(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$QueryTask);
      this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$QueryTask.a.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$QueryTask, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfByte);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.10
 * JD-Core Version:    0.7.0.1
 */