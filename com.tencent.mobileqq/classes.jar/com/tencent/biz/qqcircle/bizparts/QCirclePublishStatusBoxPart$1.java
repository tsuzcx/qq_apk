package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.mobileqq.winkpublish.event.QCirclePublishBoxStatusEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QCirclePublishStatusBoxPart$1
  implements Runnable
{
  QCirclePublishStatusBoxPart$1(QCirclePublishStatusBoxPart paramQCirclePublishStatusBoxPart, QCirclePublishBoxStatusEvent paramQCirclePublishBoxStatusEvent) {}
  
  public void run()
  {
    QCirclePublishStatusBoxPart.a(this.this$0);
    if (this.a.taskCount <= 0)
    {
      QCirclePublishStatusBoxPart.b(this.this$0).setVisibility(8);
      QLog.i("QCirclePublishStatusBoxPart", 1, "updateUploadBoxStatus  PublishBoxStatusEvent  GONE");
      return;
    }
    if ((QCirclePublishStatusBoxPart.c(this.this$0) != null) && (QCirclePluginUtil.b(QCirclePublishStatusBoxPart.c(this.this$0))))
    {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(16).setSubActionType(1).setThrActionType(0).setPageId(this.this$0.f()));
      QCirclePublishStatusBoxPart.b(this.this$0).setVisibility(0);
    }
    else
    {
      QCirclePublishStatusBoxPart.b(this.this$0).setVisibility(8);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateUploadBoxStatus PublishBoxStatusEvent VISIBLE taskCount = ");
    localStringBuilder.append(this.a.taskCount);
    localStringBuilder.append("  hasRunningTask:");
    localStringBuilder.append(this.a.hasRunningTask);
    localStringBuilder.append("  hasOfflineWaitingTask:");
    localStringBuilder.append(this.a.hasOfflineWaitingTask);
    QLog.d("QCirclePublishStatusBoxPart", 4, localStringBuilder.toString());
    if (this.a.hasRunningTask)
    {
      QCirclePublishStatusBoxPart.d(this.this$0).setBackgroundResource(2130845256);
      QCirclePublishStatusBoxPart.a(this.this$0, String.valueOf(this.a.taskCount));
      return;
    }
    if (this.a.hasOfflineWaitingTask)
    {
      QCirclePublishStatusBoxPart.d(this.this$0).setBackgroundResource(2130845288);
      QCirclePublishStatusBoxPart.a(this.this$0, "");
      return;
    }
    QCirclePublishStatusBoxPart.d(this.this$0).setBackgroundResource(2130845289);
    QCirclePublishStatusBoxPart.a(this.this$0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePublishStatusBoxPart.1
 * JD-Core Version:    0.7.0.1
 */