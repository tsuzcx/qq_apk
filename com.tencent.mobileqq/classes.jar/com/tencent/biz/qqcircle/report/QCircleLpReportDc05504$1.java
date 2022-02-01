package com.tencent.biz.qqcircle.report;

import com.tencent.TMG.utils.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import vrf;
import vri;
import vrl;

public final class QCircleLpReportDc05504$1
  implements Runnable
{
  public QCircleLpReportDc05504$1(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List paramList, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("touin", this.jdField_a_of_type_JavaLangString), vri.a("actiontype", String.valueOf(this.jdField_a_of_type_Int)), vri.a("subactiontype", String.valueOf(this.b)), vri.a("thr_action", String.valueOf(this.c)) }));
    if (this.d > -1) {
      ((List)localObject).add(vri.a("page_id", String.valueOf(this.d)));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        ((List)localObject).addAll(this.jdField_a_of_type_JavaUtilList);
      }
      ((List)localObject).addAll(vri.a().a());
      localObject = vri.a(vrf.a(), (List)localObject, null, vri.a().a(this.d, this.jdField_a_of_type_ArrayOfByte));
      if (!vri.a().a()) {
        break;
      }
      vrl.a().a((QQCircleReport.SingleDcData)localObject, false);
      return;
      ((List)localObject).add(vri.a("page_id", "0"));
    }
    QLog.w("QCircleReporter", 1, "QCircleLpReportDc05504 report miss Session: actiontype:" + this.jdField_a_of_type_Int + ",subActionType:" + this.b + ",add Miss Session report cache list");
    vrl.a().b((QQCircleReport.SingleDcData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05504.1
 * JD-Core Version:    0.7.0.1
 */