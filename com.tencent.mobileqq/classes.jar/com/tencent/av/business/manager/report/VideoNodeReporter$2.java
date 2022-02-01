package com.tencent.av.business.manager.report;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class VideoNodeReporter$2
  implements Runnable
{
  VideoNodeReporter$2(VideoNodeReporter paramVideoNodeReporter, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.e.size() > 0)
    {
      Iterator localIterator = this.this$0.e.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (VideoNodeReporter.SeesionRecord)localIterator.next();
        if (((VideoNodeReporter.SeesionRecord)localObject).a == -1L)
        {
          long l = this.a;
          ((VideoNodeReporter.SeesionRecord)localObject).a = l;
          this.this$0.a(l, 26, l);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateCallerRoomId  updated roomId = ");
          ((StringBuilder)localObject).append(this.a);
          QLog.d("VideoNodeReporter", 1, ((StringBuilder)localObject).toString());
          VideoNodeReporter.a(this.this$0, -1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.2
 * JD-Core Version:    0.7.0.1
 */