package com.tencent.mobileqq.app;

import bhoh;
import bhoj;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class SignatureManager$3
  implements Runnable
{
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(this.a);
    bhoj localbhoj = bhoh.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a);
    if (localbhoj != null) {
      SignatureManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.a), localbhoj);
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager.3
 * JD-Core Version:    0.7.0.1
 */