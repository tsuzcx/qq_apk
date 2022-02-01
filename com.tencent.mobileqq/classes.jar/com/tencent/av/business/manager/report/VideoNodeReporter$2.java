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
    if (this.this$0.a.size() > 0)
    {
      Iterator localIterator = this.this$0.a.iterator();
      while (localIterator.hasNext())
      {
        VideoNodeReporter.SeesionRecord localSeesionRecord = (VideoNodeReporter.SeesionRecord)localIterator.next();
        if (localSeesionRecord.a == -1L)
        {
          localSeesionRecord.a = this.a;
          this.this$0.a(this.a, 26, this.a);
          QLog.d("VideoNodeReporter", 1, "updateCallerRoomId  updated roomId = " + this.a);
          VideoNodeReporter.a(this.this$0, -1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.2
 * JD-Core Version:    0.7.0.1
 */