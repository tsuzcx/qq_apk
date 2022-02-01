package com.tencent.av.business.manager.report;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class VideoNodeReporter$6
  implements Runnable
{
  VideoNodeReporter$6(VideoNodeReporter paramVideoNodeReporter, long paramLong) {}
  
  public void run()
  {
    Object localObject = VideoNodeReporter.a(this.this$0, this.a);
    QLog.d("VideoNodeReporter", 1, "reportToServer ,roomId = " + this.a + ", detail = " + (String)localObject);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.a != 0L)) {
      DcReportUtil.a(null, "dc02402", (String)localObject);
    }
    VideoNodeReporter.a(this.this$0, this.a);
    localObject = this.this$0.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      VideoNodeReporter.SeesionRecord localSeesionRecord = (VideoNodeReporter.SeesionRecord)((Iterator)localObject).next();
      if (this.a == localSeesionRecord.a) {
        ((Iterator)localObject).remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.6
 * JD-Core Version:    0.7.0.1
 */