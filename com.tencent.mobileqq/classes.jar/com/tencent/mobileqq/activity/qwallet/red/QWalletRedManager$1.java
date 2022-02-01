package com.tencent.mobileqq.activity.qwallet.red;

import aktx;
import aktz;
import akyj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class QWalletRedManager$1
  implements Runnable
{
  public QWalletRedManager$1(akyj paramakyj) {}
  
  public void run()
  {
    Object localObject = (aktz)akyj.a(this.this$0).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    if (localObject != null)
    {
      ((aktz)localObject).c("redPoint", this.this$0);
      localObject = ((aktz)localObject).a("redPoint");
      akyj.a(this.this$0).parseConfig((aktx)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "synDataFromMoggy" + akyj.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.1
 * JD-Core Version:    0.7.0.1
 */