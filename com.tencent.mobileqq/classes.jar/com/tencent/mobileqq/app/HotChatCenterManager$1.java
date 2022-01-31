package com.tencent.mobileqq.app;

import ajyf;
import aukn;
import auko;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.qphone.base.util.QLog;

public class HotChatCenterManager$1
  implements Runnable
{
  public HotChatCenterManager$1(ajyf paramajyf, HotChatItemData paramHotChatItemData) {}
  
  public void run()
  {
    Object localObject3 = null;
    aukn localaukn2 = null;
    localaukn1 = localaukn2;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          continue;
        }
        localaukn1 = localaukn2;
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          localaukn1 = localaukn2;
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
        localObject1 = localaukn1;
        QLog.e("HotChatCenterManager", 1, localThrowable, new Object[0]);
        if (localaukn1 == null) {
          continue;
        }
        localaukn1.a();
        return;
      }
      finally
      {
        if (localObject1 == null) {
          continue;
        }
        ((aukn)localObject1).a();
      }
      return;
      localaukn1 = localaukn2;
      localObject1 = localObject3;
      localaukn2 = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      localaukn1 = localaukn2;
      localObject1 = localaukn2;
      if (this.a.getStatus() == 1000)
      {
        localaukn1 = localaukn2;
        localObject1 = localaukn2;
        localaukn2.a(this.a);
        localaukn1 = localaukn2;
        localObject1 = localaukn2;
        if (QLog.isColorLevel())
        {
          localaukn1 = localaukn2;
          localObject1 = localaukn2;
          QLog.d("HotChatCenterManager", 2, new Object[] { "saveHotChatItemData [persist],code:", this.a.mHotChatCode });
        }
        if (localaukn2 != null) {
          localaukn2.a();
        }
      }
      else
      {
        localaukn1 = localaukn2;
        localObject1 = localaukn2;
        localaukn2.a(this.a);
        localaukn1 = localaukn2;
        localObject1 = localaukn2;
        if (QLog.isColorLevel())
        {
          localaukn1 = localaukn2;
          localObject1 = localaukn2;
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