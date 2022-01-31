package com.tencent.biz.qqcircle.report;

import com.tencent.TMG.utils.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import tzv;
import tzy;
import uab;

public final class QCircleLpReportDc05504$1
  implements Runnable
{
  public QCircleLpReportDc05504$1(String paramString1, int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { tzy.a("touin", this.jdField_a_of_type_JavaLangString), tzy.a("actiontype", String.valueOf(this.jdField_a_of_type_Int)), tzy.a("subactiontype", String.valueOf(this.jdField_a_of_type_Long)), tzy.a("thr_action", String.valueOf(this.jdField_b_of_type_Long)), tzy.a("page_id", String.valueOf(this.jdField_b_of_type_Int)), tzy.a("fpage_id", String.valueOf(this.jdField_c_of_type_Int)), tzy.a("ext1", this.jdField_b_of_type_JavaLangString), tzy.a("ext2", this.jdField_c_of_type_JavaLangString), tzy.a("ext6", this.d), tzy.a("ext7", this.e), tzy.a("vid", this.f) }));
    ((List)localObject).addAll(tzy.a().a());
    localObject = tzy.a(tzv.a(), (List)localObject, null, tzy.a().a(this.jdField_b_of_type_Int));
    if (tzy.a().a())
    {
      uab.a().a((QQCircleReport.SingleDcData)localObject, false);
      return;
    }
    QLog.w("QCircleReporter", 1, "QCircleLpReportDc05504 report miss Session: actiontype:" + this.jdField_a_of_type_Int + ",subActionType:" + this.jdField_a_of_type_Long + ",add Miss Session report cache list");
    uab.a().b((QQCircleReport.SingleDcData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05504.1
 * JD-Core Version:    0.7.0.1
 */