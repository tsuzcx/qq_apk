package com.tencent.mobileqq.apollo;

import akmn;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$4
  extends IApolloRunnableTask
{
  ApolloRenderDriver$4(ApolloRenderDriver paramApolloRenderDriver, String[] paramArrayOfString) {}
  
  public String a()
  {
    return "onExecAction";
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "start run.");
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a(this.a[i]);
        i += 1;
      }
      this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      if ((!this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.this$0.jdField_a_of_type_Akmn != null)) {
        this.this$0.jdField_a_of_type_Akmn.onRender();
      }
      return;
    }
    finally
    {
      this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver.4
 * JD-Core Version:    0.7.0.1
 */