package com.tencent.imcore.message;

import acmw;
import awtg;
import blfz;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;

class QQMessageFacade$1
  implements Runnable
{
  QQMessageFacade$1(QQMessageFacade paramQQMessageFacade) {}
  
  public void run()
  {
    blfz.a("initMsgCache");
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "before refreshCache");
    }
    QQMessageFacade.access$002(this.this$0, awtg.a(QQMessageFacade.access$100(this.this$0)));
    this.this$0.getConversationFacade().a();
    this.this$0.refreshCache();
    QQMessageFacade.access$200(this.this$0);
    this.this$0.notifyObservers(new RecentUser());
    if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.QQMessageFacade", 2, "after refreshCache");
      long l2 = System.currentTimeMillis();
      MsgAutoMonitorUtil.getInstance().printKeyAndValue("MSG_InitCostTime", l2 - l1 + "");
    }
    blfz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.1
 * JD-Core Version:    0.7.0.1
 */