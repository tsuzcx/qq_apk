package com.tencent.mobileqq.activity.qwallet.config;

import aitd;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QWalletConfigManager$1
  implements Runnable
{
  public QWalletConfigManager$1(aitd paramaitd, WeakReference paramWeakReference) {}
  
  public void run()
  {
    aitd localaitd = (aitd)this.a.get();
    if (localaitd != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "getAllConfigAgain");
      }
      localaitd.a(aitd.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager.1
 * JD-Core Version:    0.7.0.1
 */