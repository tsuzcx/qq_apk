package com.tencent.mobileqq.app;

import anwa;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class HotChatCenterManager$1
  implements Runnable
{
  public HotChatCenterManager$1(anwa paramanwa, HotChatItemData paramHotChatItemData) {}
  
  public void run()
  {
    EntityManager localEntityManager = null;
    Object localObject4 = null;
    localObject2 = localObject4;
    localObject1 = localEntityManager;
    for (;;)
    {
      try
      {
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          continue;
        }
        localObject2 = localObject4;
        localObject1 = localEntityManager;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject4;
          localObject1 = localEntityManager;
          QLog.d("HotChatCenterManager", 2, "saveHotChatItemData app = null");
        }
        if (0 != 0) {
          throw new NullPointerException();
        }
      }
      catch (Throwable localThrowable)
      {
        QQAppInterface localQQAppInterface;
        localObject1 = localObject2;
        QLog.e("HotChatCenterManager", 1, localThrowable, new Object[0]);
        return;
      }
      finally
      {
        if (localObject1 == null) {
          continue;
        }
        ((EntityManager)localObject1).close();
      }
      return;
      localObject2 = localObject4;
      localObject1 = localEntityManager;
      localEntityManager = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject2 = localEntityManager;
      localObject1 = localEntityManager;
      if (this.a.getStatus() == 1000)
      {
        localObject2 = localEntityManager;
        localObject1 = localEntityManager;
        localEntityManager.persist(this.a);
        localObject2 = localEntityManager;
        localObject1 = localEntityManager;
        if (QLog.isColorLevel())
        {
          localObject2 = localEntityManager;
          localObject1 = localEntityManager;
          QLog.d("HotChatCenterManager", 2, new Object[] { "saveHotChatItemData [persist],code:", this.a.mHotChatCode });
        }
        if (localEntityManager != null) {
          localEntityManager.close();
        }
      }
      else
      {
        localObject2 = localEntityManager;
        localObject1 = localEntityManager;
        localEntityManager.update(this.a);
        localObject2 = localEntityManager;
        localObject1 = localEntityManager;
        if (QLog.isColorLevel())
        {
          localObject2 = localEntityManager;
          localObject1 = localEntityManager;
          QLog.d("HotChatCenterManager", 2, new Object[] { "saveHotChatItemData [update],code:", this.a.mHotChatCode });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatCenterManager.1
 * JD-Core Version:    0.7.0.1
 */