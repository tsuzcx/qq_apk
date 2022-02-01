package com.tencent.av.business.manager.report;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import lik;
import lim;

public class VideoNodeReporter$5
  implements Runnable
{
  public VideoNodeReporter$5(lik paramlik, String paramString) {}
  
  public void run()
  {
    QLog.d("VideoNodeReporter", 1, "updateCrashType ,crashType = " + this.a);
    if (this.this$0.a.size() > 0)
    {
      Iterator localIterator = this.this$0.a.iterator();
      while (localIterator.hasNext()) {
        ((lim)localIterator.next()).d = this.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.5
 * JD-Core Version:    0.7.0.1
 */