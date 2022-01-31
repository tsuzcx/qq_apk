package com.tencent.mobileqq.app;

import ajjz;
import atmp;
import atmq;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.qphone.base.util.QLog;

public class HotChatCenterManager$1
  implements Runnable
{
  public HotChatCenterManager$1(ajjz paramajjz, HotChatItemData paramHotChatItemData) {}
  
  public void run()
  {
    atmp localatmp = null;
    Object localObject4 = null;
    localObject2 = localObject4;
    localObject1 = localatmp;
    for (;;)
    {
      try
      {
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          continue;
        }
        localObject2 = localObject4;
        localObject1 = localatmp;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject4;
          localObject1 = localatmp;
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
        ((atmp)localObject1).a();
      }
      return;
      localObject2 = localObject4;
      localObject1 = localatmp;
      localatmp = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject2 = localatmp;
      localObject1 = localatmp;
      if (this.a.getStatus() == 1000)
      {
        localObject2 = localatmp;
        localObject1 = localatmp;
        localatmp.a(this.a);
        localObject2 = localatmp;
        localObject1 = localatmp;
        if (QLog.isColorLevel())
        {
          localObject2 = localatmp;
          localObject1 = localatmp;
          QLog.d("HotChatCenterManager", 2, new Object[] { "saveHotChatItemData [persist],code:", this.a.mHotChatCode });
        }
        if (localatmp != null) {
          localatmp.a();
        }
      }
      else
      {
        localObject2 = localatmp;
        localObject1 = localatmp;
        localatmp.a(this.a);
        localObject2 = localatmp;
        localObject1 = localatmp;
        if (QLog.isColorLevel())
        {
          localObject2 = localatmp;
          localObject1 = localatmp;
          QLog.d("HotChatCenterManager", 2, new Object[] { "saveHotChatItemData [update],code:", this.a.mHotChatCode });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatCenterManager.1
 * JD-Core Version:    0.7.0.1
 */