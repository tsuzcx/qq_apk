package com.tencent.mobileqq.activity.qwallet.red;

import akpb;
import akpd;
import akti;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QWalletRedManager$1
  implements Runnable
{
  public QWalletRedManager$1(akti paramakti) {}
  
  public void run()
  {
    Object localObject = (akpd)akti.a(this.this$0).getManager(245);
    if (localObject != null)
    {
      ((akpd)localObject).c("redPoint", this.this$0);
      localObject = ((akpd)localObject).a("redPoint");
      akti.a(this.this$0).parseConfig((akpb)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "synDataFromMoggy" + akti.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.1
 * JD-Core Version:    0.7.0.1
 */