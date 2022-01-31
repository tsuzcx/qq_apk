package com.tencent.av.business.manager.report;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import liw;
import liy;

public class VideoNodeReporter$2
  implements Runnable
{
  public VideoNodeReporter$2(liw paramliw, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.a.size() > 0)
    {
      Iterator localIterator = this.this$0.a.iterator();
      while (localIterator.hasNext())
      {
        liy localliy = (liy)localIterator.next();
        if (localliy.a == -1L)
        {
          localliy.a = this.a;
          this.this$0.a(this.a, 26, this.a);
          QLog.d("VideoNodeReporter", 1, "updateCallerRoomId  updated roomId = " + this.a);
          liw.a(this.this$0, -1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.2
 * JD-Core Version:    0.7.0.1
 */