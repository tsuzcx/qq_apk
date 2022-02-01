package com.tencent.mobileqq.activity.qwallet.red;

import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigApi.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

class QWalletRedManager$1
  implements Runnable
{
  QWalletRedManager$1(QWalletRedManager paramQWalletRedManager) {}
  
  public void run()
  {
    Object localObject = (QWalletConfigManager)QWalletRedManager.a(this.this$0).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    if (localObject != null)
    {
      ((QWalletConfigManager)localObject).c("redPoint", this.this$0);
      localObject = ((QWalletConfigManager)localObject).a("redPoint");
      QWalletRedManager.a(this.this$0).parseConfig((IQWalletConfigApi.ConfigInfo)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "synDataFromMoggy" + QWalletRedManager.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.1
 * JD-Core Version:    0.7.0.1
 */