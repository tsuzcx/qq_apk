package com.tencent.mobileqq.apollo;

import akrc;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$7
  extends IApolloRunnableTask
{
  public String a()
  {
    return "onRestoreAnimation";
  }
  
  public void run()
  {
    if (1 == this.a) {}
    for (String str = "me.restoreAnimationState();";; str = "friend.restoreAnimationState();")
    {
      this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      try
      {
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine != null) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a(str);
        }
        if (this.this$0.jdField_a_of_type_Akrc != null) {
          this.this$0.jdField_a_of_type_Akrc.onRender();
        }
        return;
      }
      finally
      {
        this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver.7
 * JD-Core Version:    0.7.0.1
 */