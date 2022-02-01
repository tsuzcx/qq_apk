package com.tencent.mobileqq.activity.qwallet.red;

import alam;
import alao;
import alex;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QWalletRedManager$1
  implements Runnable
{
  public QWalletRedManager$1(alex paramalex) {}
  
  public void run()
  {
    Object localObject = (alao)alex.a(this.this$0).getManager(245);
    if (localObject != null)
    {
      ((alao)localObject).c("redPoint", this.this$0);
      localObject = ((alao)localObject).a("redPoint");
      alex.a(this.this$0).parseConfig((alam)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "synDataFromMoggy" + alex.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.1
 * JD-Core Version:    0.7.0.1
 */