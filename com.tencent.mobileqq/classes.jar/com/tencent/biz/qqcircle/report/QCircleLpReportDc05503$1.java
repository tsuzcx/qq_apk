package com.tencent.biz.qqcircle.report;

import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import vtp;
import vtt;
import vtw;

public final class QCircleLpReportDc05503$1
  implements Runnable
{
  public QCircleLpReportDc05503$1(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vtt.a("login_time", String.valueOf(this.jdField_a_of_type_Long)), vtt.a("stay_time", String.valueOf(this.jdField_b_of_type_Long)), vtt.a("page_id", String.valueOf(this.jdField_c_of_type_Long)), vtt.a("ext1", this.jdField_a_of_type_JavaLangString), vtt.a("ext2", this.jdField_b_of_type_JavaLangString), vtt.a("ext3", this.jdField_c_of_type_JavaLangString), vtt.a("ext4", this.d), vtt.a("ext5", this.e), vtt.a("ext6", this.f) }));
    ((List)localObject).addAll(vtt.a().a());
    localObject = vtt.a(vtp.a(), (List)localObject, null, vtt.a().a(this.jdField_a_of_type_Int));
    vtw.a().a((QQCircleReport.SingleDcData)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05503.1
 * JD-Core Version:    0.7.0.1
 */