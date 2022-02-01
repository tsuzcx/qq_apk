package com.tencent.mobileqq.apollo;

import amlr;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$10
  extends IApolloRunnableTask
{
  public String a()
  {
    return "updateExtraAction";
  }
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      if ((this.a != null) && (this.a.size() > 0))
      {
        Object localObject1 = new StringBuilder();
        StringBuilder localStringBuilder1 = new StringBuilder();
        StringBuilder localStringBuilder2 = new StringBuilder();
        int j = this.a.size();
        int i = 0;
        while (i < j)
        {
          String str = "layout" + i;
          amlr localamlr = (amlr)this.a.get(i);
          localStringBuilder1.append("var ").append(str).append(" = ").append(localamlr.toString()).append(";\n");
          localStringBuilder2.append("bubbleLayoutList.push(").append(str).append(");\n");
          i += 1;
        }
        ((StringBuilder)localObject1).append("if(this && this.bubbleLayoutList && this.updateActionRender) { bubbleLayoutList.splice(0, bubbleLayoutList.length);\n").append(localStringBuilder1.toString()).append(localStringBuilder2.toString()).append("updateActionRender();}");
        localObject1 = ((StringBuilder)localObject1).toString();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRenderDriver", 2, new Object[] { "[updateExtraAction] js str=", localObject1 });
        }
        this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a((String)localObject1);
      }
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
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver.10
 * JD-Core Version:    0.7.0.1
 */