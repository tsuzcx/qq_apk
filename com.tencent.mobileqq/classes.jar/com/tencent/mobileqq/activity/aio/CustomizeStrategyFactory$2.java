package com.tencent.mobileqq.activity.aio;

import aktz;
import albw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class CustomizeStrategyFactory$2
  implements Runnable
{
  CustomizeStrategyFactory$2(CustomizeStrategyFactory paramCustomizeStrategyFactory) {}
  
  public void run()
  {
    synchronized (CustomizeStrategyFactory.a(this.this$0))
    {
      if (!CustomizeStrategyFactory.a(this.this$0))
      {
        QQAppInterface localQQAppInterface = albw.a();
        if (localQQAppInterface != null) {
          this.this$0.a = ((aktz)localQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER));
        }
        if (this.this$0.a != null) {
          this.this$0.a.c("redPack", this.this$0);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.2
 * JD-Core Version:    0.7.0.1
 */