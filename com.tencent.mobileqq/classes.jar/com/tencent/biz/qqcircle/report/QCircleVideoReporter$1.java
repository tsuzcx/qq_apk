package com.tencent.biz.qqcircle.report;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import uab;
import uaf;

public final class QCircleVideoReporter$1
  implements Runnable
{
  public QCircleVideoReporter$1(FeedCloudMeta.StFeed paramStFeed, String paramString, List paramList) {}
  
  public void run()
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(5530);
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null)
    {
      QLog.w("QCircleVideoReporter", 1, "feed is null");
      return;
    }
    localSingleDcData.report_data.addAll(uaf.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed));
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localSingleDcData.report_data.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    uab.a().a(localSingleDcData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleVideoReporter.1
 * JD-Core Version:    0.7.0.1
 */