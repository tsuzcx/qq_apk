package com.tencent.mobileqq.apollo;

import aivb;
import ajkq;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$5
  extends IApolloRunnableTask
{
  ApolloRenderDriver$5(ApolloRenderDriver paramApolloRenderDriver, String[] paramArrayOfString, ajkq paramajkq) {}
  
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
      if (this.jdField_a_of_type_Ajkq != null) {
        this.jdField_a_of_type_Ajkq.d();
      }
      if ((!this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.this$0.jdField_a_of_type_Aivb != null)) {
        this.this$0.jdField_a_of_type_Aivb.onRender();
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