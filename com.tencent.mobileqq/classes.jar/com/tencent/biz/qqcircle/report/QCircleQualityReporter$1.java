package com.tencent.biz.qqcircle.report;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import tyl;
import typ;

public final class QCircleQualityReporter$1
  implements Runnable
{
  public QCircleQualityReporter$1(String paramString, List paramList) {}
  
  public void run()
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(5531);
    localSingleDcData.report_data.addAll(tyl.a(this.jdField_a_of_type_JavaLangString));
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localSingleDcData.report_data.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    typ.a().a(localSingleDcData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleQualityReporter.1
 * JD-Core Version:    0.7.0.1
 */