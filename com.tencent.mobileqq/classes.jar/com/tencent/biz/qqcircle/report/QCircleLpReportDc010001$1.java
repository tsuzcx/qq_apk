package com.tencent.biz.qqcircle.report;

import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import vtk;
import vtt;
import vtw;

public final class QCircleLpReportDc010001$1
  implements Runnable
{
  public QCircleLpReportDc010001$1(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt4) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vtt.a("actiontype", String.valueOf(this.jdField_a_of_type_Int)), vtt.a("subactiontype", String.valueOf(this.jdField_b_of_type_Int)), vtt.a("thr_action", String.valueOf(this.jdField_c_of_type_Int)), vtt.a("mainType", String.valueOf(this.jdField_a_of_type_JavaLangString)), vtt.a("subType", String.valueOf(this.jdField_b_of_type_JavaLangString)), vtt.a("busiMsgId", this.jdField_c_of_type_JavaLangString), vtt.a("eeveeMsgId", this.jdField_d_of_type_JavaLangString), vtt.a("scene", String.valueOf(this.jdField_d_of_type_Int)), vtt.a("app_id", String.valueOf(10000)) }));
    ((List)localObject).addAll(vtt.a().a());
    localObject = vtt.a(vtk.a(), (List)localObject, null, null);
    vtw.a().a((QQCircleReport.SingleDcData)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc010001.1
 * JD-Core Version:    0.7.0.1
 */