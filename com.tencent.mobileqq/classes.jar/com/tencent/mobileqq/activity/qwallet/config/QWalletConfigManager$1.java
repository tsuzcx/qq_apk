package com.tencent.mobileqq.activity.qwallet.config;

import agzd;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QWalletConfigManager$1
  implements Runnable
{
  public QWalletConfigManager$1(agzd paramagzd, WeakReference paramWeakReference) {}
  
  public void run()
  {
    agzd localagzd = (agzd)this.a.get();
    if (localagzd != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "getAllConfigAgain");
      }
      localagzd.a(agzd.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager.1
 * JD-Core Version:    0.7.0.1
 */