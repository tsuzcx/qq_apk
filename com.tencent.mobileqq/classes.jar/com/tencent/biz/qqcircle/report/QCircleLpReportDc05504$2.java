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

public final class QCircleLpReportDc05504$2
  implements Runnable
{
  public QCircleLpReportDc05504$2(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4, int paramInt5, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("touin", this.jdField_a_of_type_JavaLangString), vri.a("actiontype", String.valueOf(this.jdField_a_of_type_Int)), vri.a("subactiontype", String.valueOf(this.jdField_b_of_type_Int)), vri.a("thr_action", String.valueOf(this.jdField_c_of_type_Int)), vri.a("ext1", this.jdField_b_of_type_JavaLangString), vri.a("ext2", this.jdField_c_of_type_JavaLangString), vri.a("ext5", this.jdField_d_of_type_JavaLangString), vri.a("ext6", this.jdField_e_of_type_JavaLangString), vri.a("ext7", this.f), vri.a("vid", this.g) }));
    if (this.jdField_d_of_type_Int > -1)
    {
      ((List)localObject).add(vri.a("page_id", String.valueOf(this.jdField_d_of_type_Int)));
      if (this.jdField_e_of_type_Int <= -1) {
        break label274;
      }
      ((List)localObject).add(vri.a("fpage_id", String.valueOf(this.jdField_e_of_type_Int)));
    }
    for (;;)
    {
      ((List)localObject).addAll(vri.a().a());
      localObject = vri.a(vrf.a(), (List)localObject, null, vri.a().a(this.jdField_d_of_type_Int, this.jdField_a_of_type_ArrayOfByte));
      if (!vri.a().a()) {
        break label291;
      }
      vrl.a().a((QQCircleReport.SingleDcData)localObject, false);
      return;
      ((List)localObject).add(vri.a("page_id", "0"));
      break;
      label274:
      ((List)localObject).add(vri.a("fpage_id", "0"));
    }
    label291:
    QLog.w("QCircleReporter", 1, "QCircleLpReportDc05504 report miss Session: actiontype:" + this.jdField_a_of_type_Int + ",subActionType:" + this.jdField_b_of_type_Int + ",add Miss Session report cache list");
    vrl.a().b((QQCircleReport.SingleDcData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05504.2
 * JD-Core Version:    0.7.0.1
 */