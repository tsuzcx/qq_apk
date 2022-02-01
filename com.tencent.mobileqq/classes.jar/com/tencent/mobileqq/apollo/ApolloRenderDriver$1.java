package com.tencent.mobileqq.apollo;

import ampx;
import anhm;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$1
  extends IApolloRunnableTask
{
  ApolloRenderDriver$1(ApolloRenderDriver paramApolloRenderDriver, int paramInt1, int paramInt2, String[] paramArrayOfString1, String[] paramArrayOfString2) {}
  
  public String a()
  {
    return "onSetActions";
  }
  
  public void run()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "start run.");
    }
    String[] arrayOfString = anhm.a(ApolloUtil.g(1), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfJavaLangString[0], this.jdField_a_of_type_ArrayOfJavaLangString[1]);
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (this.jdField_b_of_type_ArrayOfJavaLangString != null)
    {
      localObject1 = localObject3;
      if (this.jdField_b_of_type_ArrayOfJavaLangString.length == 2) {
        localObject1 = anhm.a(ApolloUtil.g(2), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_b_of_type_ArrayOfJavaLangString[1]);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    if (arrayOfString != null) {}
    for (int i = 0;; i = j) {
      do
      {
        try
        {
          while (i < arrayOfString.length)
          {
            this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a(arrayOfString[i]);
            i += 1;
            continue;
            while (i < localObject1.length)
            {
              this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a(localObject1[i]);
              i += 1;
            }
            this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
            if ((!this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.this$0.jdField_a_of_type_Ampx != null)) {
              this.this$0.jdField_a_of_type_Ampx.onRender();
            }
            return;
          }
        }
        finally
        {
          this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        }
      } while (localObject2 == null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver.1
 * JD-Core Version:    0.7.0.1
 */