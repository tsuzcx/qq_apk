package com.tencent.mobileqq.app.automator.step;

import akaq;
import bgmq;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDoingSomething;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import obs;

class TimerCheckMsgCount$1
  implements Runnable
{
  TimerCheckMsgCount$1(TimerCheckMsgCount paramTimerCheckMsgCount) {}
  
  public void run()
  {
    this.this$0.a.app.a().l();
    ((HotChatManager)this.this$0.a.app.getManager(60)).b();
    this.this$0.a.app.a().c();
    if (!bgmq.l(this.this$0.a.app)) {}
    while (!((Boolean)bgmq.a("kandian_report_user_apps_switch", Boolean.valueOf(false))).booleanValue())
    {
      return;
      try
      {
        TimerCheckMsgCount.a(this.this$0);
        ReadInJoyDoingSomething.a();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    try
    {
      obs.a();
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("QQInitHandler", 1, "TImerCheckMsgCount run: ", localException2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount.1
 * JD-Core Version:    0.7.0.1
 */