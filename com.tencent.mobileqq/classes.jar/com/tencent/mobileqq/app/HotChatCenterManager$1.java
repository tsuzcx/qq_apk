package com.tencent.mobileqq.app;

import amtm;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class HotChatCenterManager$1
  implements Runnable
{
  public HotChatCenterManager$1(amtm paramamtm, HotChatItemData paramHotChatItemData) {}
  
  public void run()
  {
    Object localObject3 = null;
    EntityManager localEntityManager2 = null;
    localEntityManager1 = localEntityManager2;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          continue;
        }
        localEntityManager1 = localEntityManager2;
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          localEntityManager1 = localEntityManager2;
          localObject1 = localObject3;
          QLog.d("HotChatCenterManager", 2, "saveHotChatItemData app = null");
        }
        if (0 != 0) {
          throw new NullPointerException();
        }
      }
      catch (Throwable localThrowable)
      {
        QQAppInterface localQQAppInterface;
        localObject1 = localEntityManager1;
        QLog.e("HotChatCenterManager", 1, localThrowable, new Object[0]);
        if (localEntityManager1 == null) {
          continue;
        }
        localEntityManager1.close();
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
      localEntityManager1 = localEntityManager2;
      localObject1 = localObject3;
      localEntityManager2 = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      localEntityManager1 = localEntityManager2;
      localObject1 = localEntityManager2;
      if (this.a.getStatus() == 1000)
      {
        localEntityManager1 = localEntityManager2;
        localObject1 = localEntityManager2;
        localEntityManager2.persist(this.a);
        localEntityManager1 = localEntityManager2;
        localObject1 = localEntityManager2;
        if (QLog.isColorLevel())
        {
          localEntityManager1 = localEntityManager2;
          localObject1 = localEntityManager2;
          QLog.d("HotChatCenterManager", 2, new Object[] { "saveHotChatItemData [persist],code:", this.a.mHotChatCode });
        }
        if (localEntityManager2 != null) {
          localEntityManager2.close();
        }
      }
      else
      {
        localEntityManager1 = localEntityManager2;
        localObject1 = localEntityManager2;
        localEntityManager2.update(this.a);
        localEntityManager1 = localEntityManager2;
        localObject1 = localEntityManager2;
        if (QLog.isColorLevel())
        {
          localEntityManager1 = localEntityManager2;
          localObject1 = localEntityManager2;
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