package com.tencent.mobileqq.app;

import ajyd;
import aukp;
import aukq;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.qphone.base.util.QLog;

public class HotChatCenterManager$1
  implements Runnable
{
  public HotChatCenterManager$1(ajyd paramajyd, HotChatItemData paramHotChatItemData) {}
  
  public void run()
  {
    Object localObject3 = null;
    aukp localaukp2 = null;
    localaukp1 = localaukp2;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          continue;
        }
        localaukp1 = localaukp2;
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          localaukp1 = localaukp2;
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
        localObject1 = localaukp1;
        QLog.e("HotChatCenterManager", 1, localThrowable, new Object[0]);
        if (localaukp1 == null) {
          continue;
        }
        localaukp1.a();
        return;
      }
      finally
      {
        if (localObject1 == null) {
          continue;
        }
        ((aukp)localObject1).a();
      }
      return;
      localaukp1 = localaukp2;
      localObject1 = localObject3;
      localaukp2 = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      localaukp1 = localaukp2;
      localObject1 = localaukp2;
      if (this.a.getStatus() == 1000)
      {
        localaukp1 = localaukp2;
        localObject1 = localaukp2;
        localaukp2.a(this.a);
        localaukp1 = localaukp2;
        localObject1 = localaukp2;
        if (QLog.isColorLevel())
        {
          localaukp1 = localaukp2;
          localObject1 = localaukp2;
          QLog.d("HotChatCenterManager", 2, new Object[] { "saveHotChatItemData [persist],code:", this.a.mHotChatCode });
        }
        if (localaukp2 != null) {
          localaukp2.a();
        }
      }
      else
      {
        localaukp1 = localaukp2;
        localObject1 = localaukp2;
        localaukp2.a(this.a);
        localaukp1 = localaukp2;
        localObject1 = localaukp2;
        if (QLog.isColorLevel())
        {
          localaukp1 = localaukp2;
          localObject1 = localaukp2;
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