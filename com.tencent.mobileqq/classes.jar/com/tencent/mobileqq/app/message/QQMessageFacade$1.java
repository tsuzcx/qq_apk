package com.tencent.mobileqq.app.message;

import akpb;
import asek;
import bfnl;
import bfwu;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

class QQMessageFacade$1
  implements Runnable
{
  QQMessageFacade$1(QQMessageFacade paramQQMessageFacade) {}
  
  public void run()
  {
    bfwu.a("initMsgCache");
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "before refreshCache");
    }
    QQMessageFacade.a(this.this$0, asek.a(QQMessageFacade.a(this.this$0)));
    this.this$0.a().a();
    this.this$0.d();
    QQMessageFacade.a(this.this$0);
    this.this$0.notifyObservers(new RecentUser());
    if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.QQMessageFacade", 2, "after refreshCache");
      long l2 = System.currentTimeMillis();
      bfnl.a().a("MSG_InitCostTime", l2 - l1 + "");
    }
    bfwu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.QQMessageFacade.1
 * JD-Core Version:    0.7.0.1
 */