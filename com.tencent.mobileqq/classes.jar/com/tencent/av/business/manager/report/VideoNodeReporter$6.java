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
    Object localObject1 = VideoNodeReporter.a(this.this$0, this.a);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("reportToServer ,roomId = ");
    ((StringBuilder)localObject2).append(this.a);
    ((StringBuilder)localObject2).append(", detail = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d("VideoNodeReporter", 1, ((StringBuilder)localObject2).toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (this.a != 0L)) {
      DcReportUtil.a(null, "dc02402", (String)localObject1);
    }
    VideoNodeReporter.a(this.this$0, this.a);
    localObject1 = this.this$0.a.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VideoNodeReporter.SeesionRecord)((Iterator)localObject1).next();
      if (this.a == ((VideoNodeReporter.SeesionRecord)localObject2).a) {
        ((Iterator)localObject1).remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.6
 * JD-Core Version:    0.7.0.1
 */