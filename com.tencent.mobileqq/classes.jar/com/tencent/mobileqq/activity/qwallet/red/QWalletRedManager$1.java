package com.tencent.mobileqq.activity.qwallet.red;

import aixq;
import aixs;
import ajbp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QWalletRedManager$1
  implements Runnable
{
  public QWalletRedManager$1(ajbp paramajbp) {}
  
  public void run()
  {
    Object localObject = (aixs)ajbp.a(this.this$0).getManager(245);
    if (localObject != null)
    {
      ((aixs)localObject).c("redPoint", this.this$0);
      localObject = ((aixs)localObject).a("redPoint");
      ajbp.a(this.this$0).parseConfig((aixq)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "synDataFromMoggy" + ajbp.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.1
 * JD-Core Version:    0.7.0.1
 */