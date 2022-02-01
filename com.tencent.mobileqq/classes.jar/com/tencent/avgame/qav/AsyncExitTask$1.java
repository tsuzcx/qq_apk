package com.tencent.avgame.qav;

import android.os.Build;
import android.os.SystemClock;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

final class AsyncExitTask$1
  implements Runnable
{
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    QRoute.api(IDPCApi.class);
    AsyncExitTask.a(true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndPreloadDpcMng, cost[");
      localStringBuilder.append(SystemClock.elapsedRealtime() - l);
      localStringBuilder.append("], model[");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append("]");
      QLog.i("AsyncExitTask", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AsyncExitTask.1
 * JD-Core Version:    0.7.0.1
 */