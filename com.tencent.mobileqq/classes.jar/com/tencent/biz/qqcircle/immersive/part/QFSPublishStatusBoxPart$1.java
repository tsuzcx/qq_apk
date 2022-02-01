package com.tencent.biz.qqcircle.immersive.part;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.mobileqq.winkpublish.event.QCirclePublishBoxStatusEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QFSPublishStatusBoxPart$1
  implements Runnable
{
  QFSPublishStatusBoxPart$1(QFSPublishStatusBoxPart paramQFSPublishStatusBoxPart, QCirclePublishBoxStatusEvent paramQCirclePublishBoxStatusEvent) {}
  
  public void run()
  {
    QFSPublishStatusBoxPart.a(this.this$0);
    if (QFSPublishStatusBoxPart.b(this.this$0) != null)
    {
      if (QFSPublishStatusBoxPart.c(this.this$0) == null) {
        return;
      }
      if (this.a.taskCount <= 0)
      {
        QFSPublishStatusBoxPart.b(this.this$0).setVisibility(8);
        QLog.i("QFSPublishStatusBoxPart", 1, "updateUploadBoxStatus  PublishBoxStatusEvent  GONE");
        if (QFSPublishStatusBoxPart.d(this.this$0))
        {
          QCircleToast.a(QCircleToast.d, 2131896224, 0);
          QFSPublishStatusBoxPart.a(this.this$0, false);
        }
        return;
      }
      if ((QFSPublishStatusBoxPart.e(this.this$0) != null) && (QCirclePluginUtil.b(QFSPublishStatusBoxPart.e(this.this$0))))
      {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(16).setSubActionType(1).setThrActionType(0).setPageId(this.this$0.i()));
        QFSPublishStatusBoxPart.b(this.this$0).setVisibility(0);
      }
      else
      {
        QFSPublishStatusBoxPart.b(this.this$0).setVisibility(8);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUploadBoxStatus  PublishBoxStatusEvent  VISIBLE  taskCount = ");
      localStringBuilder.append(this.a.taskCount);
      localStringBuilder.append("  hasRunningTask:");
      localStringBuilder.append(this.a.hasRunningTask);
      localStringBuilder.append("  hasOfflineWaitingTask:");
      localStringBuilder.append(this.a.hasOfflineWaitingTask);
      QLog.d("QFSPublishStatusBoxPart", 4, localStringBuilder.toString());
      if (this.a.hasRunningTask)
      {
        QFSPublishStatusBoxPart.c(this.this$0).setBackgroundResource(2130845256);
        QFSPublishStatusBoxPart.a(this.this$0, String.valueOf(this.a.taskCount));
      }
      else if (this.a.hasOfflineWaitingTask)
      {
        QFSPublishStatusBoxPart.c(this.this$0).setBackgroundResource(2130845288);
        QFSPublishStatusBoxPart.a(this.this$0, "");
      }
      else
      {
        QFSPublishStatusBoxPart.c(this.this$0).setBackgroundResource(2130845289);
        QFSPublishStatusBoxPart.a(this.this$0, "");
      }
      if (this.a.hasFinishTask) {
        QFSPublishStatusBoxPart.a(this.this$0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSPublishStatusBoxPart.1
 * JD-Core Version:    0.7.0.1
 */