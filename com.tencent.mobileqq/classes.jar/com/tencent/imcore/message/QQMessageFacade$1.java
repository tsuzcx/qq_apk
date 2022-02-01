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
    Object localObject = this.this$0;
    QQMessageFacade.a((QQMessageFacade)localObject, DraftTextManager.a(QQMessageFacade.a((QQMessageFacade)localObject)));
    this.this$0.a().b();
    this.this$0.t();
    QQMessageFacade.b(this.this$0);
    this.this$0.notifyObservers(new RecentUser());
    if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.QQMessageFacade", 2, "after refreshCache");
      long l2 = System.currentTimeMillis();
      localObject = MsgAutoMonitorUtil.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append("");
      ((MsgAutoMonitorUtil)localObject).printKeyAndValue("MSG_InitCostTime", localStringBuilder.toString());
    }
    TraceUtils.traceEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.1
 * JD-Core Version:    0.7.0.1
 */