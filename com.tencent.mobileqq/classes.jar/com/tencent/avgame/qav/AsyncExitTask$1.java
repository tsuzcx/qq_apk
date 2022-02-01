package com.tencent.avgame.qav;

import android.os.Build;
import android.os.SystemClock;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.qphone.base.util.QLog;
import ngb;

public final class AsyncExitTask$1
  implements Runnable
{
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    DeviceProfileManager.a();
    ngb.a(true);
    if (QLog.isColorLevel()) {
      QLog.i("AsyncExitTask", 2, "checkAndPreloadDpcMng, cost[" + (SystemClock.elapsedRealtime() - l) + "], model[" + Build.MODEL + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.AsyncExitTask.1
 * JD-Core Version:    0.7.0.1
 */