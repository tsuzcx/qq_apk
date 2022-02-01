package com.tencent.mobileqq.activity.qwallet.red;

import ajye;
import ajyg;
import akcq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QWalletRedManager$1
  implements Runnable
{
  public QWalletRedManager$1(akcq paramakcq) {}
  
  public void run()
  {
    Object localObject = (ajyg)akcq.a(this.this$0).getManager(245);
    if (localObject != null)
    {
      ((ajyg)localObject).c("redPoint", this.this$0);
      localObject = ((ajyg)localObject).a("redPoint");
      akcq.a(this.this$0).parseConfig((ajye)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "synDataFromMoggy" + akcq.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.1
 * JD-Core Version:    0.7.0.1
 */