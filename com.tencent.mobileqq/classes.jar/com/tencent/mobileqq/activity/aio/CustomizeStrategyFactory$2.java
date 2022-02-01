package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
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
        QQAppInterface localQQAppInterface = QWalletTools.a();
        if (localQQAppInterface != null) {
          this.this$0.a = ((QWalletConfigManager)localQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER));
        }
        if (this.this$0.a != null) {
          this.this$0.a.c("redPack", this.this$0);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.2
 * JD-Core Version:    0.7.0.1
 */