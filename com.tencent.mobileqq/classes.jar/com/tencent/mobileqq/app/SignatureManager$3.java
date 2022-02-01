package com.tencent.mobileqq.app;

import bhzb;
import bhzd;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class SignatureManager$3
  implements Runnable
{
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(this.a);
    bhzd localbhzd = bhzb.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a);
    if (localbhzd != null) {
      SignatureManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.a), localbhzd);
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager.3
 * JD-Core Version:    0.7.0.1
 */