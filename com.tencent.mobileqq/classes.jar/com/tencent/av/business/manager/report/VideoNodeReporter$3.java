package com.tencent.av.business.manager.report;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class VideoNodeReporter$3
  implements Runnable
{
  VideoNodeReporter$3(VideoNodeReporter paramVideoNodeReporter, int paramInt, long paramLong) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("in runnabe report ,node = ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(",value = ");
    ((StringBuilder)localObject).append(this.b);
    QLog.d("VideoNodeReporter", 1, ((StringBuilder)localObject).toString());
    if (this.this$0.e.size() > 0)
    {
      localObject = this.this$0.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoNodeReporter.SeesionRecord localSeesionRecord = (VideoNodeReporter.SeesionRecord)((Iterator)localObject).next();
        this.this$0.a(localSeesionRecord.a, this.a, this.b);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" report ,node = ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(",value = ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(",seesionRecordList is empty");
    QLog.d("VideoNodeReporter", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.3
 * JD-Core Version:    0.7.0.1
 */