package com.tencent.mobileqq.apollo;

import aivd;
import ajks;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$5
  extends IApolloRunnableTask
{
  ApolloRenderDriver$5(ApolloRenderDriver paramApolloRenderDriver, String[] paramArrayOfString, ajks paramajks) {}
  
  public String a()
  {
    return "onChangeDress";
  }
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        i += 1;
      }
      this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      if (this.jdField_a_of_type_Ajks != null) {
        this.jdField_a_of_type_Ajks.d();
      }
      if ((!this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.this$0.jdField_a_of_type_Aivd != null)) {
        this.this$0.jdField_a_of_type_Aivd.onRender();
      }
      return;
    }
    finally
    {
      this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver.5
 * JD-Core Version:    0.7.0.1
 */