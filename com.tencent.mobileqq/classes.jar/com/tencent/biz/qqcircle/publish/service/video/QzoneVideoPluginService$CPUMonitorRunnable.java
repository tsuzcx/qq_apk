package com.tencent.biz.qqcircle.publish.service.video;

import android.os.Process;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.qphone.base.util.QLog;

public class QzoneVideoPluginService$CPUMonitorRunnable
  implements Runnable
{
  public void run()
  {
    int i = QzoneVideoPluginService.b();
    int j = QCircleHostQzoneThreadHelper.getVideoThreadId();
    int k = Process.getThreadPriority(j);
    if (i > 80)
    {
      if (k < 10) {
        Process.setThreadPriority(j, 10);
      }
    }
    else if ((!QzoneVideoPluginService.g()) && (k > TrimVideoThread.a)) {
      Process.setThreadPriority(j, TrimVideoThread.a);
    }
    j = Process.getThreadPriority(j);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cpu usage=");
      localStringBuilder.append(i);
      localStringBuilder.append(", priority=");
      localStringBuilder.append(j);
      QLog.d("[QcirclePublish]QzoneVideoPluginService", 2, localStringBuilder.toString());
    }
    if (QzoneVideoPluginService.a()) {
      QCircleHostQzoneThreadHelper.postBackGoundThreadDelayed(this, 5000L);
    }
    QzoneVideoPluginService.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.service.video.QzoneVideoPluginService.CPUMonitorRunnable
 * JD-Core Version:    0.7.0.1
 */