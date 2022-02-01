package com.tencent.mobileqq.activity.qwallet.config;

import aktz;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QWalletConfigManager$1
  implements Runnable
{
  public QWalletConfigManager$1(aktz paramaktz, WeakReference paramWeakReference) {}
  
  public void run()
  {
    aktz localaktz = (aktz)this.a.get();
    if (localaktz != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "getAllConfigAgain");
      }
      localaktz.a(aktz.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager.1
 * JD-Core Version:    0.7.0.1
 */