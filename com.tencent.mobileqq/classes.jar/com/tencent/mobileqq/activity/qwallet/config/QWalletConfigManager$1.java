package com.tencent.mobileqq.activity.qwallet.config;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QWalletConfigManager$1
  implements Runnable
{
  QWalletConfigManager$1(QWalletConfigManager paramQWalletConfigManager, WeakReference paramWeakReference) {}
  
  public void run()
  {
    QWalletConfigManager localQWalletConfigManager = (QWalletConfigManager)this.a.get();
    if (localQWalletConfigManager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "getAllConfigAgain");
      }
      localQWalletConfigManager.a(QWalletConfigManager.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager.1
 * JD-Core Version:    0.7.0.1
 */