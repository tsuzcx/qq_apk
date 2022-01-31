package com.tencent.mobileqq.apollo;

import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$8
  extends IApolloRunnableTask
{
  public String a()
  {
    return "updateMouseButton";
  }
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      return;
    }
    finally
    {
      this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver.8
 * JD-Core Version:    0.7.0.1
 */