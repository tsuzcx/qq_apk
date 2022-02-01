package com.tencent.imcore.message;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import com.tencent.widget.TraceUtils;

class QQMessageFacade$1
  implements Runnable
{
  QQMessageFacade$1(QQMessageFacade paramQQMessageFacade) {}
  
  public void run()
  {
    TraceUtils.traceBegin("initMsgCache");
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "before refreshCache");
    }
    QQMessageFacade.a(this.this$0, DraftTextManager.a(QQMessageFacade.a(this.this$0)));
    this.this$0.a().a();
    this.this$0.d();
    QQMessageFacade.a(this.this$0);
    this.this$0.notifyObservers(new RecentUser());
    if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.QQMessageFacade", 2, "after refreshCache");
      long l2 = System.currentTimeMillis();
      MsgAutoMonitorUtil.getInstance().printKeyAndValue("MSG_InitCostTime", l2 - l1 + "");
    }
    TraceUtils.traceEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.1
 * JD-Core Version:    0.7.0.1
 */