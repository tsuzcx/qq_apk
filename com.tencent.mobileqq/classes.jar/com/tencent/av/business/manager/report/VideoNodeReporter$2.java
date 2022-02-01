package com.tencent.av.business.manager.report;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import lhw;
import lhy;

public class VideoNodeReporter$2
  implements Runnable
{
  public VideoNodeReporter$2(lhw paramlhw, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.a.size() > 0)
    {
      Iterator localIterator = this.this$0.a.iterator();
      while (localIterator.hasNext())
      {
        lhy locallhy = (lhy)localIterator.next();
        if (locallhy.a == -1L)
        {
          locallhy.a = this.a;
          this.this$0.a(this.a, 26, this.a);
          QLog.d("VideoNodeReporter", 1, "updateCallerRoomId  updated roomId = " + this.a);
          lhw.a(this.this$0, -1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.2
 * JD-Core Version:    0.7.0.1
 */