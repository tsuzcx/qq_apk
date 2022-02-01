package com.tencent.biz.qqcircle.report;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import vts;
import vtw;

public final class QCircleQualityReporter$1
  implements Runnable
{
  public QCircleQualityReporter$1(int paramInt, String paramString, List paramList) {}
  
  public void run()
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(this.jdField_a_of_type_Int);
    localSingleDcData.report_data.addAll(vts.a(this.jdField_a_of_type_JavaLangString));
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localSingleDcData.report_data.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    vtw.a().a(localSingleDcData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleQualityReporter.1
 * JD-Core Version:    0.7.0.1
 */