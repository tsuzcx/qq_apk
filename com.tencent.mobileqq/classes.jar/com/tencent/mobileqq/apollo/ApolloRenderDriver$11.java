package com.tencent.mobileqq.apollo;

import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$11
  extends IApolloRunnableTask
{
  ApolloRenderDriver$11(ApolloRenderDriver paramApolloRenderDriver, String paramString) {}
  
  public String a()
  {
    return "exejsOnEngine";
  }
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a(this.a);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver.11
 * JD-Core Version:    0.7.0.1
 */