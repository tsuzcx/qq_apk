package com.tencent.mobileqq.app.automator.step;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgCountChecker;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.kandian.base.report.api.IReadInJoyDoingSomething;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;

class TimerCheckMsgCount$1
  implements Runnable
{
  TimerCheckMsgCount$1(TimerCheckMsgCount paramTimerCheckMsgCount) {}
  
  public void run()
  {
    TimerCheckMsgCount.a(this.this$0).a(this.this$0.mAutomator.k);
    ((HotChatManager)this.this$0.mAutomator.k.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).k();
    this.this$0.mAutomator.k.getConversationFacade().f();
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getKanDianReportTTSwitch()) {
      try
      {
        TimerCheckMsgCount.b(this.this$0);
        ((IReadInJoyDoingSomething)QRoute.api(IReadInJoyDoingSomething.class)).reportManyAppsData();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    ((Boolean)((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySpValue("kandian_report_user_apps_switch", Boolean.valueOf(false))).booleanValue();
    TimerCheckMsgCount.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount.1
 * JD-Core Version:    0.7.0.1
 */