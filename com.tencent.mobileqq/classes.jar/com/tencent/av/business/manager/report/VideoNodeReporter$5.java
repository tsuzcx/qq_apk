package com.tencent.av.business.manager.report;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class VideoNodeReporter$5
  implements Runnable
{
  VideoNodeReporter$5(VideoNodeReporter paramVideoNodeReporter, String paramString) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateCrashType ,crashType = ");
    ((StringBuilder)localObject).append(this.a);
    QLog.d("VideoNodeReporter", 1, ((StringBuilder)localObject).toString());
    if (this.this$0.a.size() > 0)
    {
      localObject = this.this$0.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoNodeReporter.SeesionRecord)((Iterator)localObject).next()).d = this.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.5
 * JD-Core Version:    0.7.0.1
 */