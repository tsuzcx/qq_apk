package com.tencent.mobileqq.activity.qwallet.red;

import agzd;
import agzf;
import ahcy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QWalletRedManager$1
  implements Runnable
{
  public QWalletRedManager$1(ahcy paramahcy) {}
  
  public void run()
  {
    Object localObject = (agzf)ahcy.a(this.this$0).getManager(245);
    if (localObject != null)
    {
      ((agzf)localObject).c("redPoint", this.this$0);
      localObject = ((agzf)localObject).a("redPoint");
      ahcy.a(this.this$0).parseConfig((agzd)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "synDataFromMoggy" + ahcy.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.1
 * JD-Core Version:    0.7.0.1
 */