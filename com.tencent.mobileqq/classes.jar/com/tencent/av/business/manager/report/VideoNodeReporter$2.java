package com.tencent.av.business.manager.report;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kyl;
import kyn;

public class VideoNodeReporter$2
  implements Runnable
{
  public VideoNodeReporter$2(kyl paramkyl, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.a.size() > 0)
    {
      Iterator localIterator = this.this$0.a.iterator();
      while (localIterator.hasNext())
      {
        kyn localkyn = (kyn)localIterator.next();
        if (localkyn.a == -1L)
        {
          localkyn.a = this.a;
          this.this$0.a(this.a, 26, this.a);
          QLog.d("VideoNodeReporter", 1, "updateCallerRoomId  updated roomId = " + this.a);
          kyl.a(this.this$0, -1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.2
 * JD-Core Version:    0.7.0.1
 */