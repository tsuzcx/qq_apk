package com.tencent.mobileqq.activity.qwallet.red;

import aitb;
import aitd;
import aixa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QWalletRedManager$1
  implements Runnable
{
  public QWalletRedManager$1(aixa paramaixa) {}
  
  public void run()
  {
    Object localObject = (aitd)aixa.a(this.this$0).getManager(245);
    if (localObject != null)
    {
      ((aitd)localObject).c("redPoint", this.this$0);
      localObject = ((aitd)localObject).a("redPoint");
      aixa.a(this.this$0).parseConfig((aitb)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "synDataFromMoggy" + aixa.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.1
 * JD-Core Version:    0.7.0.1
 */