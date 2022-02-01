package com.tencent.biz.qqcircle.richframework.outbox;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.outbox.QCircleNetDetectHelper.DetectListener;

class QCircleOutboxTaskQueue$2$1
  implements QCircleNetDetectHelper.DetectListener
{
  QCircleOutboxTaskQueue$2$1(QCircleOutboxTaskQueue.2 param2) {}
  
  public void onDetectResult(boolean paramBoolean, long paramLong, String paramString)
  {
    if (paramBoolean)
    {
      QLog.d("QCircleOutboxTaskQueue", 1, "detectQCirclenNetConnection available,resumeOutboxTasks");
      if (QCircleOutboxTaskQueue.c(this.a.this$0) != null)
      {
        QCircleOutboxTaskQueue.c(this.a.this$0).removeCallbacks(QCircleOutboxTaskQueue.d(this.a.this$0));
        QCircleOutboxTaskQueue.c(this.a.this$0).post(QCircleOutboxTaskQueue.d(this.a.this$0));
      }
    }
    else
    {
      if (QCircleOutboxTaskQueue.c(this.a.this$0) != null)
      {
        QCircleOutboxTaskQueue.c(this.a.this$0).removeCallbacks(QCircleOutboxTaskQueue.e(this.a.this$0));
        QCircleOutboxTaskQueue.c(this.a.this$0).postDelayed(QCircleOutboxTaskQueue.e(this.a.this$0), 10000L);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detectQCirclenNetConnection blocked,retry again!retCode:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",errMsg:");
      localStringBuilder.append(paramString);
      QLog.d("QCircleOutboxTaskQueue", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue.2.1
 * JD-Core Version:    0.7.0.1
 */