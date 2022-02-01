package com.tencent.biz.qqcircle.publish.request;

import com.tencent.biz.qqcircle.publish.model.QzoneMediaUploadParams;
import cooperation.qqcircle.report.QCircleMapReporter;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

class QCircleUploadRequest$1
  implements Runnable
{
  QCircleUploadRequest$1(QCircleUploadRequest paramQCircleUploadRequest) {}
  
  public void run()
  {
    if (QCircleUploadRequest.a(this.this$0))
    {
      QCircleUploadRequest.b(this.this$0);
      QCircleUploadRequest.c(this.this$0);
      return;
    }
    Object localObject1 = QCircleMapReporter.getInstance();
    Object localObject2 = QCirclePublishQualityReporter.P_VIDEO_EXPORT_COST;
    Object localObject3 = QCircleUploadRequest.d(this.this$0);
    FeedCloudCommon.Entry localEntry = QCircleReportHelper.newEntry("traceid", this.this$0.c.O);
    Object localObject4 = QCircleReportHelper.newEntry("ext6", String.valueOf(QCircleUploadRequest.e(this.this$0)));
    StringBuilder localStringBuilder = new StringBuilder();
    boolean bool = QCircleUploadRequest.f(this.this$0);
    String str2 = "QQ";
    String str1;
    if (bool) {
      str1 = "QQ";
    } else {
      str1 = "Peak";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(":");
    localStringBuilder.append(QCircleUploadRequest.g(this.this$0));
    ((QCircleMapReporter)localObject1).reportEnd((String)localObject2, (String)localObject3, Arrays.asList(new FeedCloudCommon.Entry[] { localEntry, localObject4, QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()), QCircleReportHelper.newEntry("ret_code", "-80000006") }));
    localObject1 = QCirclePublishQualityReporter.E_VIDEO_EXPORT_RESULT;
    localObject2 = QCircleReportHelper.newEntry("traceid", this.this$0.c.O);
    localObject3 = QCircleReportHelper.newEntry("ret_code", "-80000006");
    localEntry = QCircleReportHelper.newEntry("ext6", String.valueOf(QCircleUploadRequest.e(this.this$0)));
    localObject4 = new StringBuilder();
    if (QCircleUploadRequest.f(this.this$0)) {
      str1 = str2;
    } else {
      str1 = "Peak";
    }
    ((StringBuilder)localObject4).append(str1);
    ((StringBuilder)localObject4).append(":");
    ((StringBuilder)localObject4).append(QCircleUploadRequest.g(this.this$0));
    QCirclePublishQualityReporter.report((String)localObject1, Arrays.asList(new FeedCloudCommon.Entry[] { localObject2, localObject3, localEntry, QCircleReportHelper.newEntry("attach_info", ((StringBuilder)localObject4).toString()) }));
    QCircleUploadRequest.a(this.this$0, 10001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.request.QCircleUploadRequest.1
 * JD-Core Version:    0.7.0.1
 */