package com.tencent.mobileqq.app;

import alug;
import awgf;
import awgg;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.qphone.base.util.QLog;

public class HotChatCenterManager$1
  implements Runnable
{
  public HotChatCenterManager$1(alug paramalug, HotChatItemData paramHotChatItemData) {}
  
  public void run()
  {
    Object localObject3 = null;
    awgf localawgf2 = null;
    localawgf1 = localawgf2;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          continue;
        }
        localawgf1 = localawgf2;
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          localawgf1 = localawgf2;
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
        localObject1 = localawgf1;
        QLog.e("HotChatCenterManager", 1, localThrowable, new Object[0]);
        if (localawgf1 == null) {
          continue;
        }
        localawgf1.a();
        return;
      }
      finally
      {
        if (localObject1 == null) {
          continue;
        }
        ((awgf)localObject1).a();
      }
      return;
      localawgf1 = localawgf2;
      localObject1 = localObject3;
      localawgf2 = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      localawgf1 = localawgf2;
      localObject1 = localawgf2;
      if (this.a.getStatus() == 1000)
      {
        localawgf1 = localawgf2;
        localObject1 = localawgf2;
        localawgf2.a(this.a);
        localawgf1 = localawgf2;
        localObject1 = localawgf2;
        if (QLog.isColorLevel())
        {
          localawgf1 = localawgf2;
          localObject1 = localawgf2;
          QLog.d("HotChatCenterManager", 2, new Object[] { "saveHotChatItemData [persist],code:", this.a.mHotChatCode });
        }
        if (localawgf2 != null) {
          localawgf2.a();
        }
      }
      else
      {
        localawgf1 = localawgf2;
        localObject1 = localawgf2;
        localawgf2.a(this.a);
        localawgf1 = localawgf2;
        localObject1 = localawgf2;
        if (QLog.isColorLevel())
        {
          localawgf1 = localawgf2;
          localObject1 = localawgf2;
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