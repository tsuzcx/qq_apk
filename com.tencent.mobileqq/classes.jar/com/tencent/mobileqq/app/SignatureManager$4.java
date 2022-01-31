package com.tencent.mobileqq.app;

import bbqq;
import bbqs;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class SignatureManager$4
  implements Runnable
{
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(this.a);
    bbqs localbbqs = bbqq.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a);
    if (localbbqs != null) {
      SignatureManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.a), localbbqs);
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager.4
 * JD-Core Version:    0.7.0.1
 */