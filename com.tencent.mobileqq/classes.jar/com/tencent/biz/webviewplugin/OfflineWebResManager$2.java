package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.data.OfflineWebRes;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

class OfflineWebResManager$2
  implements Runnable
{
  OfflineWebResManager$2(OfflineWebResManager paramOfflineWebResManager, int paramInt) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(this.a * 1000);
      if (!OfflineWebResManager.jdField_a_of_type_Boolean)
      {
        OfflineWebResManager.c();
        if (!OfflineWebResManager.b)
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(OfflineWebRes.class.getSimpleName());
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      OfflineWebResManager.jdField_a_of_type_Boolean = this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(OfflineWebRes.class.getSimpleName());
      Object localObject;
      if (!OfflineWebResManager.jdField_a_of_type_Boolean)
      {
        localObject = new OfflineWebRes();
        ((OfflineWebRes)localObject).fileName = "test";
        ((OfflineWebRes)localObject).hashName = "test";
        ((OfflineWebRes)localObject).md5 = "test_md5";
        this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persist((Entity)localObject);
      }
      while (!OfflineWebResManager.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
      {
        localObject = (String)OfflineWebResManager.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
        this.this$0.b((String)localObject);
      }
      this.this$0.a();
      this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflineWebResManager.2
 * JD-Core Version:    0.7.0.1
 */