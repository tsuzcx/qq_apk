package com.tencent.mobileqq.activity.qwallet.red;

import agzb;
import agzd;
import ahcw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QWalletRedManager$1
  implements Runnable
{
  public QWalletRedManager$1(ahcw paramahcw) {}
  
  public void run()
  {
    Object localObject = (agzd)ahcw.a(this.this$0).getManager(245);
    if (localObject != null)
    {
      ((agzd)localObject).c("redPoint", this.this$0);
      localObject = ((agzd)localObject).a("redPoint");
      ahcw.a(this.this$0).parseConfig((agzb)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "synDataFromMoggy" + ahcw.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.1
 * JD-Core Version:    0.7.0.1
 */