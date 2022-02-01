package com.tencent.biz.qqcircle.report;

import com.tencent.TMG.utils.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import vtq;
import vtt;
import vtw;

public final class QCircleLpReportDc05504$2
  implements Runnable
{
  public QCircleLpReportDc05504$2(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4, int paramInt5, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vtt.a("touin", this.jdField_a_of_type_JavaLangString), vtt.a("actiontype", String.valueOf(this.jdField_a_of_type_Int)), vtt.a("subactiontype", String.valueOf(this.jdField_b_of_type_Int)), vtt.a("thr_action", String.valueOf(this.jdField_c_of_type_Int)), vtt.a("ext1", this.jdField_b_of_type_JavaLangString), vtt.a("ext2", this.jdField_c_of_type_JavaLangString), vtt.a("ext5", this.jdField_d_of_type_JavaLangString), vtt.a("ext6", this.jdField_e_of_type_JavaLangString), vtt.a("ext7", this.f), vtt.a("vid", this.g) }));
    if (this.jdField_d_of_type_Int > -1)
    {
      ((List)localObject).add(vtt.a("page_id", String.valueOf(this.jdField_d_of_type_Int)));
      if (this.jdField_e_of_type_Int <= -1) {
        break label284;
      }
      ((List)localObject).add(vtt.a("fpage_id", String.valueOf(this.jdField_e_of_type_Int)));
    }
    for (;;)
    {
      ((List)localObject).addAll(vtt.a().a());
      localObject = vtt.a(vtq.a(), (List)localObject, null, vtt.a().a(this.jdField_d_of_type_Int, this.jdField_a_of_type_ArrayOfByte));
      if ((!vtt.a().a()) && (!vtq.a(this.jdField_a_of_type_Int))) {
        break label301;
      }
      vtw.a().a((QQCircleReport.SingleDcData)localObject, false);
      return;
      ((List)localObject).add(vtt.a("page_id", "0"));
      break;
      label284:
      ((List)localObject).add(vtt.a("fpage_id", "0"));
    }
    label301:
    QLog.w("QCircleReporter", 1, "QCircleLpReportDc05504 report miss Session: actiontype:" + this.jdField_a_of_type_Int + ",subActionType:" + this.jdField_b_of_type_Int + ",add Miss Session report cache list");
    vtw.a().b((QQCircleReport.SingleDcData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05504.2
 * JD-Core Version:    0.7.0.1
 */