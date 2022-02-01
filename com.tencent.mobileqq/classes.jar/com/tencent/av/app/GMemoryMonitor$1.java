package com.tencent.av.app;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class GMemoryMonitor$1
  implements ComponentCallbacks2
{
  GMemoryMonitor$1(GMemoryMonitor paramGMemoryMonitor) {}
  
  private void a(int paramInt)
  {
    VideoController localVideoController = this.a.a.a();
    if (localVideoController != null) {
      localVideoController.a("lowMemoryLevel", String.valueOf(paramInt));
    }
    for (;;)
    {
      try
      {
        ActivityManager localActivityManager = (ActivityManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
        localActivityManager.getMemoryInfo(localMemoryInfo);
        localVideoController = localVideoController.a("availMem", String.valueOf(localMemoryInfo.availMem / 1048576L)).a("threshold", String.valueOf(localMemoryInfo.threshold / 1048576L));
        if (!localMemoryInfo.lowMemory) {
          break label125;
        }
        paramInt = 1;
        localVideoController.a("lowMemory", String.valueOf(paramInt));
        return;
      }
      catch (Throwable localThrowable)
      {
        AVLog.printErrorLog("GMemoryMonitor", localThrowable.getMessage());
      }
      return;
      label125:
      paramInt = 0;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GMemoryMonitor", 2, "onConfigurationChanged called");
    }
  }
  
  public void onLowMemory()
  {
    QLog.d("GMemoryMonitor", 1, "onLowMemory called");
    GMemoryMonitor localGMemoryMonitor = this.a;
    localGMemoryMonitor.a(-10, localGMemoryMonitor.a.d);
    a(-10);
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (paramInt >= 15) {
      VideoNodeManager.a(41, paramInt);
    }
    if (paramInt == 15)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTrimMemory called ,level = ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("GMemoryMonitor", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.a;
      ((GMemoryMonitor)localObject).a(paramInt, ((GMemoryMonitor)localObject).a.d);
      ((VideoNodeReporter)this.a.a.a(4)).a(27, paramInt);
      a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GMemoryMonitor.1
 * JD-Core Version:    0.7.0.1
 */