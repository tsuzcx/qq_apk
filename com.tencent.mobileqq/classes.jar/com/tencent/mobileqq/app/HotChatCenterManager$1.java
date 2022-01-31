package com.tencent.mobileqq.app;

import alpr;
import awbw;
import awbx;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.qphone.base.util.QLog;

public class HotChatCenterManager$1
  implements Runnable
{
  public HotChatCenterManager$1(alpr paramalpr, HotChatItemData paramHotChatItemData) {}
  
  public void run()
  {
    awbw localawbw = null;
    Object localObject4 = null;
    localObject2 = localObject4;
    localObject1 = localawbw;
    for (;;)
    {
      try
      {
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          continue;
        }
        localObject2 = localObject4;
        localObject1 = localawbw;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject4;
          localObject1 = localawbw;
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
        ((awbw)localObject1).a();
      }
      return;
      localObject2 = localObject4;
      localObject1 = localawbw;
      localawbw = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject2 = localawbw;
      localObject1 = localawbw;
      if (this.a.getStatus() == 1000)
      {
        localObject2 = localawbw;
        localObject1 = localawbw;
        localawbw.a(this.a);
        localObject2 = localawbw;
        localObject1 = localawbw;
        if (QLog.isColorLevel())
        {
          localObject2 = localawbw;
          localObject1 = localawbw;
          QLog.d("HotChatCenterManager", 2, new Object[] { "saveHotChatItemData [persist],code:", this.a.mHotChatCode });
        }
        if (localawbw != null) {
          localawbw.a();
        }
      }
      else
      {
        localObject2 = localawbw;
        localObject1 = localawbw;
        localawbw.a(this.a);
        localObject2 = localawbw;
        localObject1 = localawbw;
        if (QLog.isColorLevel())
        {
          localObject2 = localawbw;
          localObject1 = localawbw;
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