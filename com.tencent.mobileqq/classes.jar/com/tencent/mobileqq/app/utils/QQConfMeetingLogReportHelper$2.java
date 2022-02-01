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
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("MSFSDK_LogReport");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject3 != null)
    {
      localObject1 = (TicketManager)((AppRuntime)localObject3).getManager(2);
      localObject3 = ((AppRuntime)localObject3).getAccount();
      if (localObject1 != null) {
        localObject1 = ((TicketManager)localObject1).getSkey((String)localObject3);
      } else {
        localObject1 = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQConfMeetingLogReportHelper", 2, new Object[] { "[report] run: invoked. ", Integer.valueOf(AppSetting.d()), this.a, localObject2, "", localObject3, localObject1 });
      }
    }
    long l2 = System.currentTimeMillis();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("sendFile, Runnable, path[");
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append("], Thread[");
    ((StringBuilder)localObject1).append(Thread.currentThread().getId());
    ((StringBuilder)localObject1).append("], cost[");
    ((StringBuilder)localObject1).append(l2 - l1);
    ((StringBuilder)localObject1).append("]");
    QLog.w("QQConfMeetingLogReportHelper", 1, ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.QQConfMeetingLogReportHelper.2
 * JD-Core Version:    0.7.0.1
 */