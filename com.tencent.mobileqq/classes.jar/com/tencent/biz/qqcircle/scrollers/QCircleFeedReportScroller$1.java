package com.tencent.biz.qqcircle.scrollers;

import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleFeedReportScroller$1
  implements Runnable
{
  QCircleFeedReportScroller$1(QCircleFeedReportScroller paramQCircleFeedReportScroller, boolean paramBoolean, View paramView, FeedCloudMeta.StFeed paramStFeed, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.a)
    {
      localObject = this.b;
      VideoReport.reportEvent("xsj_feed_imp", localObject, QCircleFeedReportScroller.a(this.this$0, (QCircleBaseWidgetView)localObject));
    }
    QCircleFeedReportScroller.a(this.this$0, this.c, this.d, this.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("report expose from ");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(",isValid:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(",index:");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(",feedId:");
    ((StringBuilder)localObject).append(this.c.id.get());
    ((StringBuilder)localObject).append(",pageId:");
    ((StringBuilder)localObject).append(QCircleFeedReportScroller.a(this.this$0));
    QLog.d("QCircleFeedReportHelper", 4, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller.1
 * JD-Core Version:    0.7.0.1
 */