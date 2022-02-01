package com.tencent.mobileqq.activity.qwallet.config;

import alao;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QWalletConfigManager$1
  implements Runnable
{
  public QWalletConfigManager$1(alao paramalao, WeakReference paramWeakReference) {}
  
  public void run()
  {
    alao localalao = (alao)this.a.get();
    if (localalao != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "getAllConfigAgain");
      }
      localalao.a(alao.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager.1
 * JD-Core Version:    0.7.0.1
 */