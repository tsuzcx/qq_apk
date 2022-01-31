package com.tencent.mobileqq.activity.qwallet.config;

import agmq;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QWalletConfigManager$1
  implements Runnable
{
  public QWalletConfigManager$1(agmq paramagmq, WeakReference paramWeakReference) {}
  
  public void run()
  {
    agmq localagmq = (agmq)this.a.get();
    if (localagmq != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "getAllConfigAgain");
      }
      localagmq.a(agmq.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager.1
 * JD-Core Version:    0.7.0.1
 */