package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class AfterSyncMsg$InnerDPCObservers
  implements DPCObserver
{
  public void onDpcPullFinished(boolean paramBoolean)
  {
    if (paramBoolean) {
      paramBoolean = StatisticCollector.getSqliteSwitchBySample(3);
    }
    for (;;)
    {
      try
      {
        QLog.e("QQInitHandler_WalLog", 1, new Object[] { "onDpcPullFinished, isEnable: ", Boolean.valueOf(paramBoolean) });
        if (paramBoolean) {
          continue;
        }
        FileUtils.e(SQLiteOpenHelper.WAL_FLAG_FILE_PATH);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQInitHandler", 1, "onDpcPullFinished, get switch error", localThrowable);
        continue;
      }
      ((IDPCApi)QRoute.api(IDPCApi.class)).removeObserver(this);
      return;
      FileUtils.a(SQLiteOpenHelper.WAL_FLAG_FILE_PATH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg.InnerDPCObservers
 * JD-Core Version:    0.7.0.1
 */