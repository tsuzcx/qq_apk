package com.tencent.mobileqq.app.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

class QQConfMeetingLogReportHelper$2
  implements Runnable
{
  QQConfMeetingLogReportHelper$2(QQConfMeetingLogReportHelper paramQQConfMeetingLogReportHelper, String paramString) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = ((QQAppInterface)QQConfMeetingLogReportHelper.a(this.this$0).get()).getCurrentAccountUin();
    String str = "MSFSDK_LogReport" + (String)localObject1;
    Object localObject2 = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject2 != null)
    {
      localObject1 = (TicketManager)((AppRuntime)localObject2).getManager(2);
      localObject2 = ((AppRuntime)localObject2).getAccount();
      if (localObject1 == null) {
        break label213;
      }
    }
    label213:
    for (localObject1 = ((TicketManager)localObject1).getSkey((String)localObject2);; localObject1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQConfMeetingLogReportHelper", 2, new Object[] { "[report] run: invoked. ", Integer.valueOf(AppSetting.a()), this.a, str, "", localObject2, localObject1 });
      }
      long l2 = System.currentTimeMillis();
      QLog.w("QQConfMeetingLogReportHelper", 1, "sendFile, Runnable, path[" + this.a + "], Thread[" + Thread.currentThread().getId() + "], cost[" + (l2 - l1) + "]");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.QQConfMeetingLogReportHelper.2
 * JD-Core Version:    0.7.0.1
 */