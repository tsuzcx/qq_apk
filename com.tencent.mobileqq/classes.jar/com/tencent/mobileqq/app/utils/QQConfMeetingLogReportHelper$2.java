package com.tencent.mobileqq.app.utils;

import aoqe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class QQConfMeetingLogReportHelper$2
  implements Runnable
{
  public QQConfMeetingLogReportHelper$2(aoqe paramaoqe, String paramString) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = ((QQAppInterface)aoqe.a(this.this$0).get()).getCurrentAccountUin();
    String str1 = "MSFSDK_LogReport" + (String)localObject;
    localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null)
    {
      TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
      String str2 = ((AppRuntime)localObject).getAccount();
      localObject = "";
      if (localTicketManager != null) {
        localObject = localTicketManager.getSkey(str2);
      }
      QLog.syncReportLogSelf(AppSetting.a(), this.a, str1, "", str2, (String)localObject);
    }
    long l2 = System.currentTimeMillis();
    QLog.w("QQConfMeetingLogReportHelper", 1, "sendFile, Runnable, path[" + this.a + "], Thread[" + Thread.currentThread().getId() + "], cost[" + (l2 - l1) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.QQConfMeetingLogReportHelper.2
 * JD-Core Version:    0.7.0.1
 */